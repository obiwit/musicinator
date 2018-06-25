import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import org.antlr.v4.runtime.tree.ParseTreeProperty;
import java.util.*;
import java.lang.reflect.*;

/**
 * A listerner that walks the main file's tree.
 *
 * Creates various scopes, for the main context and subscopes for any
 * 'if' or 'for' it encounter, managing all the variables.
 * Also generates the python code, using String Templates and StringBuilder.
 */

public class DefPhase extends MusicinatorParserBaseListener {
	ParseTreeProperty<Map<String, Object>> scopes = new ParseTreeProperty<>();
	ParseTreeProperty<Object> values = new ParseTreeProperty<>();
	Map<String, Integer> noteMap;
	Music music;
	private String currentIndentation;
	//private StringBuilder pythonCode; // TODO!!

	private int numberNums; // number of number variables

	public DefPhase(Music music, Map<String, Integer> noteMap) {
		this.music = music;
		this.noteMap = noteMap;
		currentIndentation = "";

		numberNums = 0;
	}
	
	/*

                                                                                                                       
      *******                                                                                                          
    *       ***      *                    *                                                           *                
   *         **     **                   **                                                          **                
   **        *      **                   **                                                          **                
    ***           ********             ********                                                    ********    ****    
   ** ***        ********     ****    ********     ***    *** **** ****       ***    ***  ****    ********    * **** * 
    *** ***         **       * ***  *    **       * ***    *** **** ***  *   * ***    **** **** *    **      **  ****  
      *** ***       **      *   ****     **      *   ***    **  **** ****   *   ***    **   ****     **     ****       
        *** ***     **     **    **      **     **    ***   **   **   **   **    ***   **    **      **       ***      
          ** ***    **     **    **      **     ********    **   **   **   ********    **    **      **         ***    
           ** **    **     **    **      **     *******     **   **   **   *******     **    **      **           ***  
            * *     **     **    **      **     **          **   **   **   **          **    **      **      ****  **  
  ***        *      **     **    **      **     ****    *   **   **   **   ****    *   **    **      **     * **** *   
 *  *********        **     ***** **      **     *******    ***  ***  ***   *******    ***   ***      **       ****    
*     *****                  ***   **             *****      ***  ***  ***   *****      ***   ***                      
*                                                                                                                      
 **                                                                                                                    
                                                              

	*/
	
	@Override public void enterMain(MusicinatorParser.MainContext ctx) {
		scopes.put(ctx, new HashMap<String, Object>());
		// TODO!!

		// TODO - Python - generate start of python file, with BPM info, to StringBuilder
	}
	@Override public void exitMain(MusicinatorParser.MainContext ctx) {
		System.out.println(scopes.get(ctx));
		// write from StringBuilder to python
		// TODO!!
	}
	
	// @Override public void enterInstructions(MusicinatorParser.InstructionsContext ctx) { }
	// @Override public void exitInstructions(MusicinatorParser.InstructionsContext ctx) {
			// TODO - Python - add track/channel to stringbuilder
			// for each play in ctx (play will have performance stored)
	// }

/*
	                                                                      ||    
	                     ''                                               ||    
	 '''|.  ('''' (''''  ||  .|''|, `||''|,  '||),,(|,  .|''|, `||''|,  ''||''  
	.|''||   `'')  `'')  ||  ||  ||  ||  ||   || || ||  ||..||  ||  ||    ||    
	`|..||. `...' `...' .||. `|..|| .||  ||. .||    ||. `|...  .||  ||.   `|..' 
	                             ||                                             
	                          `..|' 
*/
	
	// @Override public void enterVarAssign(MusicinatorParser.VarAssignContext ctx) { }
	@Override public void exitVarAssign(MusicinatorParser.VarAssignContext ctx) {
		// TODO!! Verify type!!

		// var declaration if type == number

		// add variable to the scope
		Map<String, Object> currentScope = getCurrentScope(ctx.getParent().getParent());
		
		if(ctx.expr() != null)
			currentScope.put(ctx.WORD().getText(), values.get(ctx.expr()));
		else
			currentScope.put(ctx.WORD().getText(), values.get(ctx.performance()));
	}
	
	// @Override public void enterArrayAssign(MusicinatorParser.ArrayAssignContext ctx) { }
	@Override public void exitArrayAssign(MusicinatorParser.ArrayAssignContext ctx) {
		// add variable to the scope
		Map<String, Object> currentScope = getCurrentScope(ctx.getParent().getParent());
		currentScope.put(ctx.WORD().getText(), values.get(ctx.arrayExpr()));
	}

/*
	        '||`                  
	         ||                   
	'||''|,  ||   '''|.  '||  ||` 
	 ||  ||  ||  .|''||   `|..||  
	 ||..|' .||. `|..||.      ||  
	 ||                    ,  |'  
	.||                     '' 
*/	
	
	// @Override public void enterLoopPlay(MusicinatorParser.LoopPlayContext ctx) { }
	@Override public void exitLoopPlay(MusicinatorParser.LoopPlayContext ctx) {
		// TODO!! write to String Builder

		// get performance(s)
		Performance[] pers = (Performance[])values.get(ctx.performance());

		// change repeatTime for each performance in pers, if necessary
		for (int i = 0; i < pers.length; i++) {

			double totalDuration = pers[i].startTime() + pers[i].duration();

			// get longestPerformance, change repeatTimes so totalDur (duration*repeats) >= (longest - start)
			int repeatTimes = (int)((music.longestPerformanceDuration() - pers[i].startTime()) 
									/ pers[i].duration()) + 1;
			pers[i].repeatTimes(repeatTimes);
		}

		values.put(ctx, pers);
	}
	// @Override public void enterSimplePlay(MusicinatorParser.SimplePlayContext ctx) { }
	@Override public void exitSimplePlay(MusicinatorParser.SimplePlayContext ctx) {
		// TODO!! if getParent is not timedPlay, write to String Builder

		// get performance(s)
		if (!(values.get(ctx.performance()) instanceof Performance[])) {
			error("Variable \"" + ctx.performance().getText() + "\" is not a performance!");
		}
		Performance[] pers = (Performance[])values.get(ctx.performance());

		// adjust performance(s) start times if they are to be played sequentially 
		// TODO!! bellow correct?
		if(ctx.SEQUENTIALLY() != null) {
			// if play is contained inside a timedPlay, then timedPlay will change the
			// start times of pers so they are sequential, while offsetting them as needed
			if (ctx.getParent().getRuleContext() instanceof MusicinatorParser.TimedPlayContext) {
				for (int i = 1; i < pers.length; i++) {
					pers[i].addStartTime(0);
				}
			} else {
				// if play is not contained inside a timedPlay, it changes the start times
				// so they are sequential, with an offset of 0 (= default start time)
				double currentTime = 0;
				for (int i = 1; i < pers.length; i++) {
					pers[i].addStartTime(currentTime);
					currentTime += pers[i].duration();
				}
			}
		}

		if(ctx.TIMES() != null) { // repeat instruction		
			// update repeatTimes for each performance
			for (int i = 0; i < pers.length; i++) {
				pers[i] = pers[i].repeat((int)(double)values.get(ctx.number()));
			}
		}

		// update longestPerformanceDuration, if it is the case
		for (int i = 0; i < pers.length; i++) {
			double totalDuration = pers[i].startTime() + pers[i].duration()*pers[i].repeatTimes();
			if (music.longestPerformanceDuration() < totalDuration) {
				music.longestPerformanceDuration(totalDuration);
			}
		}

		// pass performance "up"
		values.put(ctx, (Object)pers);
	}
	// @Override public void enterTimedPlay(MusicinatorParser.TimedPlayContext ctx) { }
	@Override public void exitTimedPlay(MusicinatorParser.TimedPlayContext ctx) {
		// TODO!! write to String Builder

		// get target performance(s)
		Performance pers[] = (Performance[])values.get(ctx.play());

		// check no timedPlay instruction is contained in itself, since it would create
		// a contradiction
		if(ctx.getParent().getRuleContext() instanceof MusicinatorParser.TimedPlayContext) {
			error("A performance can't have conflicting start times! Invalid instruction: "
				  + ctx.getParent().getText());
		}

		// get scope
		Map<String, Object> currentScope = getCurrentScope(ctx.getParent().getParent());

		// check whether AT or AFTER
		if (ctx.AFTER() != null) {
			
			// get reference performance (via variable)
			Performance[] refs;
			if (!currentScope.containsKey(ctx.variable().WORD().getText())) {
				error("Variable \"" + ctx.variable().WORD() + "\" does not exist!");
			} 	
			if (!(currentScope.get(ctx.variable().WORD().getText()) instanceof Performance[])) {
				error("Variable \"" + ctx.variable().WORD().getText() + "\" is not a performance!");
			}

			refs = (Performance[])currentScope.get(ctx.variable().WORD().getText());
			if (refs.length == 0) {
				error("Variable \"" + ctx.variable().WORD().getText() + "\" is an empty performance array!");
			}

			if (ctx.variable().OPEN_SB() != null) {
				// variable is an entry of array
				int index = Integer.parseInt(ctx.variable().INT().getText());
				if(refs.length <= index) {
					error("Array index out of bounds (" + index + ") in array \""
						  + ctx.variable().WORD().getText() + "\"!");
				}
				Performance[] temp = new Performance[1];
				temp[0] = refs[index];
				refs = temp;
			}

			
			// change starting time for each of the performances in pers
			for (int i = 0; i < refs.length; i++) {

				// check whether ALWAYS
				if (ctx.ALWAYS() != null) {
					// use all starts
					// TODO!!

				} else {
					// use only first start
					double newStartTime = refs[i].startTime() + refs[i].duration(); 
					// TODO!! replace refs[i].startTime() by refs[i].startTime()[0] or equiv

					// TODO!! the fors bellow will also need to be corrected - if more than 1 refs,
					// bellow fors don't work (because only one set of 0s)

					MusicinatorParser.SimplePlayContext perCtx = 
						(MusicinatorParser.SimplePlayContext)ctx.play().getRuleContext();
					if (perCtx.SEQUENTIALLY() != null) {
						// adjust times to play array items sequentially
						pers[0].changeStartTime(0, pers[0].startTime() + newStartTime);
						for (int j = 1; j < pers.length; j++) {
							// replace 0 value placed by simplePlay
							pers[j].changeStartTime(0, pers[j-1].startTime() + pers[j-1].duration());
						}
					} else {
						for (int j = 0; j < pers.length; j++) {
							// replace 0 value placed by simplePlay
							pers[j].changeStartTime(0, newStartTime);
						}
					}

				}
			}
		} else { // AT
			// check number > 0
			/*
			if (ctx.variable() != null) {

				double[] startTimes;

				if(values.get(ctx.variable().getText()) instanceof double) {
				//	startTimes = new double[]
				} else if(values.get(ctx.variable().getText()) instanceof double[]) {

				} else {
					error("Variable \"" + ctx.variable().getText() 
						  + "\" is neither a number nor a number array!");
				}


			} else if (ctx.number() != null) {
				//double startTime

			} else { //arrayExpr

			}*/
		}


		// update target performance on current scope so it has the correct start times

	}

/*
	 .|';               
	 ||                 
	'||'  .|''|, '||''| 
	 ||   ||  ||  ||    
	.||.  `|..|' .||.   
	                  
*/
	
	@Override public void enterForStat(MusicinatorParser.ForStatContext ctx) {
		// TODO!! write to String Builder

		scopes.put(ctx, new HashMap<String, Object>()); // TODO copy old scope (HashMap shallow copy - use .clone() ?) 
		// TODO!!

		// add python code to iterate the for loop to stringbuilder
		// if numbers, use for numbers
		currentIndentation += "\t";
	}
	@Override public void exitForStat(MusicinatorParser.ForStatContext ctx) {
		// end for loop
		// TODO!!

		// remove trailing '\t'
		currentIndentation = currentIndentation.substring(0, currentIndentation.length()-1);
	}

/*
	      .|'; 
	 ''   ||   
	 ||  '||'  
	 ||   ||   
	.||. .||.  
          
*/
	
	@Override public void enterIfStat(MusicinatorParser.IfStatContext ctx) {
		// TODO!! write to String Builder

		scopes.put(ctx, new HashMap<String, Object>()); // TODO copy old scope (HashMap shallow copy - use .clone() ?)
		// TODO!!

		// add python code to iterate the if to stringbuilder
		currentIndentation += "\t";
	}
	@Override public void exitIfStat(MusicinatorParser.IfStatContext ctx) {
		// end if
		// TODO!!

		// remove trailing '\t'
		currentIndentation = currentIndentation.substring(0, currentIndentation.length()-1);
	}
	
/*
                                                                                                                                   
     ***** **                                                                                                                      
  ******  **** *                                                                          *                                        
 **   *  * ****                                                                          ***                                       
*    *  *   **                                                                            *                                        
    *  *          ***    ***       ****    ***  ****                 ****       ****               ****                    ****    
   ** **         * ***  **** *    * ***  *  **** **** *    ***      * **** *   * **** * ***       * ***  * ***  ****      * **** * 
   ** **            *** *****    *   ****    **   ****    * ***    **  ****   **  ****   ***     *   ****   **** **** *  **  ****  
   ** ******         ***  **    **    **     **          *   ***  ****       ****         **    **    **     **   ****  ****       
   ** *****           ***       **    **     **         **    ***   ***        ***        **    **    **     **    **     ***      
   ** **             * ***      **    **     **         ********      ***        ***      **    **    **     **    **       ***    
   *  **            *   ***     **    **     **         *******         ***        ***    **    **    **     **    **         ***  
      *            *     ***    **    **     **         **         ****  **   ****  **    **    **    **     **    **    ****  **  
  ****         *  *       *** * *******      ***        ****    * * **** *   * **** *     **     ******      **    **   * **** *   
 *  ***********  *         ***  ******        ***        *******     ****       ****      *** *   ****       ***   ***     ****    
*     ******                    **                        *****                            ***                ***   ***            
*                               **                                                                                                 
 **                             **                                                                                                 
                                 **                                                                                                
                                      
*/


/*
                                                                                        
	 '''|.  '||''| '||''|  '''|.  '||  ||` ('''' 
	.|''||   ||     ||    .|''||   `|..||   `'') 
	`|..||. .||.   .||.   `|..||.      ||  `...' 
	                                ,  |'        
	                                 '' 
*/

	// @Override public void enterArrayExpr(MusicinatorParser.ArrayExprContext ctx) { }
	@Override public void exitArrayExpr(MusicinatorParser.ArrayExprContext ctx) {
		if (ctx.ARROW() != null) {
			//a->b = [a, ..., b] = range(a, b+1)
			// TODO!! change this into range (actual Python)
			// array of consecutive numbers, from number(0) to number(1)
			int start = (int)(double)values.get(ctx.number(0));
			int end = (int)(double)values.get(ctx.number(1));

			int range = end - start + 1;

			if (range > 0) {
				double[] array = new double[range];

				for(int i = 0; i < range; i++) {
					array[i] = i+start;
				}

				values.put(ctx, (Object)array);
			} else {
				error("Can't create number array " + start + "->" + end + "! "
					  + start + " is bigger than " + end + "!");
			}

		} else if (ctx.expr(0) != null) {
			// get type of array
			MusicinatorParser.ArrayAssignContext assignCtx = 
				(MusicinatorParser.ArrayAssignContext)ctx.getParent().getRuleContext();
			String type = assignCtx.arrayTypes().getText();
			type = type.substring(0, 1).toUpperCase() + type.substring(1);

			// get size of array
			int size = ctx.expr().size();

			// build array
			try {

				if (type.equals("Number")) {
					// build array of numbers
					double[] array = new double[size];

					for (int i = 0; i < size; i++) {
						array[i] = (double)values.get(ctx.expr(i));
					}

					values.put(ctx, (Object)array);

				} else {
					Class<?> clazz = Class.forName(type);
					Object array = Array.newInstance(clazz, size);

					for (int i = 0; i < size; i++) {
						Array.set(array, i, values.get(ctx.expr(i)));
					}

					values.put(ctx, array);
				}


			} catch(ClassNotFoundException e) {
				error("Array of type " + type + " could not be created!");
			}
		} else {
			// array is empty ("[]")
			values.put(ctx, (Object)new Object[0]);
		}
	}

	// @Override public void enterVarExpr(MusicinatorParser.VarExprContext ctx) { }
	@Override public void exitVarExpr(MusicinatorParser.VarExprContext ctx) {
		values.put(ctx, values.get(ctx.variable()));
	}
	
	// @Override public void enterPerExpr(MusicinatorParser.PerExprContext ctx) { }
	@Override public void exitPerExpr(MusicinatorParser.PerExprContext ctx) {
		values.put(ctx, values.get(ctx.performance()));
	}
	
	// @Override public void enterSeqExpr(MusicinatorParser.SeqExprContext ctx) { }
	@Override public void exitSeqExpr(MusicinatorParser.SeqExprContext ctx) {
		values.put(ctx, values.get(ctx.sequence()));
	}
	
	// @Override public void enterNumExpr(MusicinatorParser.NumExprContext ctx) { }
	@Override public void exitNumExpr(MusicinatorParser.NumExprContext ctx) {
		values.put(ctx, values.get(ctx.number()));
	}

/*
	.|'''|                                                              
	||                                                                  
	`|'''|, .|''|, .|''||`  '||  ||` .|''|, `||''|,  .|'', .|''|, ('''' 
	 .   || ||..|| ||  ||    ||  ||  ||..||  ||  ||  ||    ||..||  `'') 
	 |...|' `|...  `|..||    `|..'|. `|...  .||  ||. `|..' `|...  `...' 
	                   || ,                                             
	                   ||` 
*/
	
	// @Override public void enterSeqSpeedMod(MusicinatorParser.SeqSpeedModContext ctx) { }
	@Override public void exitSeqSpeedMod(MusicinatorParser.SeqSpeedModContext ctx) {
		// get sequence
		if(!(values.get(ctx.sequence()) instanceof Sequence)) {
			error("Variable \"" + ctx.sequence().getText() + "\" is not a sequence!");
		}
		Sequence seq = (Sequence)values.get(ctx.sequence());

		// mod sequence
		if (ctx.op.equals("*"))
			values.put(ctx, seq.modulateTempo((double)values.get(ctx.number())));
		else
			values.put(ctx, seq.modulateTempo(-1*(double)values.get(ctx.number())));
	}
	
	// @Override public void enterSeqVar(MusicinatorParser.SeqVarContext ctx) { }
	@Override public void exitSeqVar(MusicinatorParser.SeqVarContext ctx) {
		values.put(ctx, values.get(ctx.variable()));
	}
	
	// @Override public void enterSeqNote(MusicinatorParser.SeqNoteContext ctx) { }
	@Override public void exitSeqNote(MusicinatorParser.SeqNoteContext ctx) {
		Note[] n = new Note[1];
		n[0] = new Note(ctx.SOUND().getText());
		values.put(ctx, new Sequence(n));
	}
	
	// @Override public void enterSeqChord(MusicinatorParser.SeqChordContext ctx) { }
	@Override public void exitSeqChord(MusicinatorParser.SeqChordContext ctx) {
		// TODO!! CLASS CHORD, etc.
		Note[] n = new Note[1];
		n[0] = new Note(ctx.CHORD().getText());
		values.put(ctx, new Sequence(n));
	}
	
	// @Override public void enterSeqPitchMod(MusicinatorParser.SeqPitchModContext ctx) { }
	@Override public void exitSeqPitchMod(MusicinatorParser.SeqPitchModContext ctx) {
		// get sequence
		if(!(values.get(ctx.sequence()) instanceof Sequence)) {
			error("Variable \"" + ctx.sequence().getText() + "\" is not a sequence!");
		}
		Sequence seq = (Sequence)values.get(ctx.sequence());

		// mod sequence
		if (ctx.op.equals("+"))
			values.put(ctx, seq.modulatePitch((int)(double)values.get(ctx.number())));
		else
			values.put(ctx, seq.modulatePitch(-1*(int)(double)values.get(ctx.number())));
	}
	
	// @Override public void enterSeqList(MusicinatorParser.SeqListContext ctx) { }
	@Override public void exitSeqList(MusicinatorParser.SeqListContext ctx) {
		// get number of sequences in list
		int seqNum = ctx.sequence().size();

		Sequence seq;
		if (seqNum > 0) {
			// get first sequence
			if(!(values.get(ctx.sequence(0)) instanceof Sequence)) {
				error("Variable \"" + ctx.sequence(0).getText() + "\" is not a sequence!");
			}
			seq = (Sequence)values.get(ctx.sequence(0));

			// join all other sequences to the first one
			for (int i = 1; i < seqNum; i++) {
				if(!(values.get(ctx.sequence(i)) instanceof Sequence)) {
					error("Variable \"" + ctx.sequence(i).getText() + "\" is not a sequence!");
				}
				seq.absorb((Sequence)values.get(ctx.sequence(i)));
			}

		} else {
			seq = new Sequence(new Note[0]);
		}

		values.put(ctx, (Object)seq);
	}

/*
	'||'''|,                .|';                                                              
	 ||   ||                ||                                                                
	 ||...|' .|''|, '||''| '||'  .|''|, '||''| '||),,(|,   '''|.  `||''|,  .|'', .|''|, ('''' 
	 ||      ||..||  ||     ||   ||  ||  ||     || || ||  .|''||   ||  ||  ||    ||..||  `'') 
	.||      `|...  .||.   .||.  `|..|' .||.   .||    ||. `|..||. .||  ||. `|..' `|...  `...'
*/
	
	// @Override public void enterPerVar(MusicinatorParser.PerVarContext ctx) { }
	@Override public void exitPerVar(MusicinatorParser.PerVarContext ctx) {
		values.put(ctx, values.get(ctx.variable()));
	}
	
	// @Override public void enterPerFromSeq(MusicinatorParser.PerFromSeqContext ctx) { }
	@Override public void exitPerFromSeq(MusicinatorParser.PerFromSeqContext ctx) {
		// Since an array can be stored in a variable, there was no sintatic way of guaranteeing
		// that what is being created is a performance and not a performance array. As such,
		// this rule was extended and invariably creates a performance array (which can
		// have only 1 element).

		// get sequence(s)
		Sequence[] seqs = (Sequence[])values.get(ctx.sequenceList());

		// get instrument(s)
		Instrument[] insts = null;
		if (music.isInstrument(ctx.WORD().getText())) {
			insts = new Instrument[1];
			insts[0] = (Instrument)music.getInstrument(ctx.WORD().getText());
		} else {
			Map<String, Object> currentScope = getCurrentScope(ctx.getParent().getParent());

			if(currentScope.containsKey(ctx.WORD().getText()) && 
			   currentScope.get(ctx.WORD().getText()) instanceof Instrument[]) {

				insts = (Instrument[])currentScope.get(ctx.WORD().getText());

			} else {
				error("Instrument \"" + ctx.WORD().getText() + "\" does not exist!");
			}
		}
		
		// create performance array
		Performance[] pers;
		if (seqs.length == 1 && insts.length == 1) {
			// single performance
			pers = new Performance[1];
			pers[0] = new Performance(seqs[0], insts[0]);
		} else {
			// confirm only sequence or instrument contain an array
			if (seqs.length > 1 && insts.length > 1) {
				error("Cannot create a performance array from both a"
					  + " sequence and instrument arrays! Invalid instruction: "
					  + ctx.getText());
			}

			// array has more than 1 element
			if (seqs.length == 1) {
				pers = new Performance[insts.length];
				for (int i = 0; i < insts.length; i++)
					pers[i] = new Performance(seqs[0], insts[i]);
			} else {
				pers = new Performance[seqs.length];
				for (int i = 0; i < seqs.length; i++)
					pers[i] = new Performance(seqs[i], insts[0]);
			}
		}
		values.put(ctx, (Object)pers);
	}
	
	// @Override public void enterPerSpeedMod(MusicinatorParser.PerSpeedModContext ctx) { }
	@Override public void exitPerSpeedMod(MusicinatorParser.PerSpeedModContext ctx) {
		// get performance
		if(!(values.get(ctx.performance()) instanceof Performance[])) {
			error("Variable \"" + ctx.performance().getText() + "\" is not a performance!");
		}
		Performance[] pers = (Performance[])values.get(ctx.performance());

		// mod performance
		for (int i = 0; i < pers.length; i++) {
			if (ctx.op.equals("*"))
				values.put(ctx, pers[i].modulateTempo((double)values.get(ctx.number())));
			else
				values.put(ctx, pers[i].modulateTempo(-1*(double)values.get(ctx.number())));
		}
	}
	
	// @Override public void enterPerPitchMod(MusicinatorParser.PerPitchModContext ctx) { }
	@Override public void exitPerPitchMod(MusicinatorParser.PerPitchModContext ctx) {
		// get performance
		if(!(values.get(ctx.performance()) instanceof Performance[])) {
			error("Variable \"" + ctx.performance().getText() + "\" is not a performance!");
		}
		Performance[] pers = (Performance[])values.get(ctx.performance());

		// mod performance
		for (int i = 0; i < pers.length; i++) {
			if (ctx.op.equals("+"))
				values.put(ctx, pers[i].modulatePitch((int)(double)values.get(ctx.number())));
			else
				values.put(ctx, pers[i].modulatePitch(-1*(int)(double)values.get(ctx.number())));
		}
	}

	// @Override public void enterSequenceList(MusicinatorParser.SequenceListContext ctx) { }
	@Override public void exitSequenceList(MusicinatorParser.SequenceListContext ctx) {
		// create Sequence[]
		Sequence[] seqs = new Sequence[ctx.sequence().size()];

		for(int i = 0; i < seqs.length; i++) {
			seqs[i] = (Sequence)values.get(ctx.sequence(i));
		}

		values.put(ctx, (Object)seqs);
	}

/*
	'||\   ||`                     '||                         
	 ||\\  ||                       ||                         
	 || \\ ||  '||  ||` '||),,(|,   ||''|, .|''|, '||''| ('''' 
	 ||  \\||   ||  ||   || || ||   ||  || ||..||  ||     `'') 
	.||   \||.  `|..'|. .||    ||. .||..|' `|...  .||.   `...' 
	                                                           
*/	

/*
Numbers are strings.
*/

	// @Override public void enterNumDouble(MusicinatorParser.NumDoubleContext ctx) { }
	@Override public void exitNumDouble(MusicinatorParser.NumDoubleContext ctx) {
		// TODO!! (numberNums++)
		values.put(ctx, (Object)(Double.parseDouble(ctx.getText())));
	}
	
	// @Override public void enterNumMulDiv(MusicinatorParser.NumMulDivContext ctx) { }
	@Override public void exitNumMulDiv(MusicinatorParser.NumMulDivContext ctx) {
		// TODO!! (numberNums++)
		if(ctx.op.equals("*"))
			values.put(ctx, (Object)((double)values.get(ctx.number(0)) * (double)values.get(ctx.number(1))));
		else
			values.put(ctx, (Object)((double)values.get(ctx.number(0)) / (double)values.get(ctx.number(1))));
	}

	// @Override public void enterNumAddSub(MusicinatorParser.NumAddSubContext ctx) { }
	@Override public void exitNumAddSub(MusicinatorParser.NumAddSubContext ctx) {
		// TODO!! (numberNums++)
		if(ctx.op.equals("+"))
			values.put(ctx, (Object)((double)values.get(ctx.number(0)) + (double)values.get(ctx.number(1))));
		else
			values.put(ctx, (Object)((double)values.get(ctx.number(0)) - (double)values.get(ctx.number(1))));
	}
	
	// @Override public void enterNumVar(MusicinatorParser.NumVarContext ctx) { }
	@Override public void exitNumVar(MusicinatorParser.NumVarContext ctx) {
		// TODO!! (numberNums++)
		values.put(ctx, values.get(ctx.variable()));
	}

	// @Override public void enterNumInt(MusicinatorParser.NumIntContext ctx) { }
	@Override public void exitNumInt(MusicinatorParser.NumIntContext ctx) {
		// TODO!! (numberNums++)
		values.put(ctx, (Object)(Double.parseDouble(ctx.getText())));
	}

	// @Override public void enterNumGetInt(MusicinatorParser.NumGetIntContext ctx) { }
	@Override public void exitNumGetInt(MusicinatorParser.NumGetIntContext ctx) {
		// TODO!! (numberNums++)
		// TODO!!
		// also Python - String Builder
	}
	
	// @Override public void enterNumDuration(MusicinatorParser.NumDurationContext ctx) { }
	@Override public void exitNumDuration(MusicinatorParser.NumDurationContext ctx) {
		// TODO!! (numberNums++)

		Map<String, Object> currentScope = getCurrentScope(ctx.getParent().getParent());
		
		// get sequence
		if(!(currentScope.get(ctx.WORD().getText()) instanceof Sequence)) {
			error("Variable \"" + ctx.WORD().getText() + "\" is not a sequence!");
		}
		Sequence seq = (Sequence)currentScope.get(ctx.WORD().getText());

		values.put(ctx, (Object)seq.duration()); 
	}

/*
	\\      //                             '||     '||`              
	 \\    //                  ''           ||      ||               
	  \\  //    '''|.  '||''|  ||   '''|.   ||''|,  ||  .|''|, ('''' 
	   \\//    .|''||   ||     ||  .|''||   ||  ||  ||  ||..||  `'') 
	    \/     `|..||. .||.   .||. `|..||. .||..|' .||. `|...  `...' 
*/	
	
	// @Override public void enterVariable(MusicinatorParser.VariableContext ctx) { }
	@Override public void exitVariable(MusicinatorParser.VariableContext ctx) {
		// get current scope
		Map<String, Object> currentScope =  getCurrentScope(ctx.getParent().getParent());

		// check variable exists
		String var = ctx.WORD().getText();
		if(!currentScope.containsKey(var)) {
			if (!music.isInstrument(var)) {
				error("Variable \"" + var + "\" does not exist!");
			} else {
				// "variable" is not a variable but an instrument name
				values.put(ctx, (Object)music.getInstrument(var));
				return;
			}
		}

		// get variable's value
		if (ctx.OPEN_SB() == null) {
			// non-array variable name
			values.put(ctx, currentScope.get(var));
		} else { 
			// array value
			values.put(ctx, Array.get(currentScope.get(var), Integer.parseInt(ctx.INT().getText())));
		}
	}

/*
                                                                     
      * ***                *                                         
    *  ****        *     **                                          
   *  *  ***      **     **                                          
  *  **   ***     **     **                                          
 *  ***    ***  ******** **                  ***  ****       ****    
**   **     ** ********  **  ***      ***     **** **** *   * **** * 
**   **     **    **     ** * ***    * ***     **   ****   **  ****  
**   **     **    **     ***   ***  *   ***    **         ****       
**   **     **    **     **     ** **    ***   **           ***      
**   **     **    **     **     ** ********    **             ***    
 **  **     **    **     **     ** *******     **               ***  
  ** *      *     **     **     ** **          **          ****  **  
   ***     *      **     **     ** ****    *   ***        * **** *   
    *******        **    **     **  *******     ***          ****    
      ***                 **    **   *****                           
                                *                                    
                               *                                     
                              *                                      
                             *                                       
                                   
*/

	private Map<String, Object> getCurrentScope(ParserRuleContext scopeCtx) {
		while (scopes.get(scopeCtx) == null) scopeCtx = scopeCtx.getParent();
		return scopes.get(scopeCtx);
	}

	private void error(String details) {
		System.err.println("ERROR! " + details);
		System.exit(1);
	}
	
	// @Override public void enterTypes(MusicinatorParser.TypesContext ctx) { }
	// @Override public void exitTypes(MusicinatorParser.TypesContext ctx) { }
	
	// @Override public void enterArrayTypes(MusicinatorParser.ArrayTypesContext ctx) { }
	// @Override public void exitArrayTypes(MusicinatorParser.ArrayTypesContext ctx) { }
	
	// @Override public void enterCondition(MusicinatorParser.ConditionContext ctx) { }
	// @Override public void exitCondition(MusicinatorParser.ConditionContext ctx) {
		// TODO!!
	// }


	// @Override public void enterEveryRule(ParserRuleContext ctx) { }
	// @Override public void exitEveryRule(ParserRuleContext ctx) { }
	// @Override public void visitTerminal(TerminalNode node) { }
	// @Override public void visitErrorNode(ErrorNode node) { }
}