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
	//private StringBuilder pythonCode;// TODO!!

	public DefPhase(Music music, Map<String, Integer> noteMap) {
		this.music = music;
		this.noteMap = noteMap;
		currentIndentation = "";
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

		// TODO - Python - generate start of python file, with BPM info, to StringBuilder
	}
	@Override public void exitMain(MusicinatorParser.MainContext ctx) {
		System.out.println(scopes.get(ctx));
		// write from StringBuilder to python
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
		//System.out.println("Var Assigned: "+ ctx.WORD() + " of type " + ctx.types().getText());

		// add variable to the scope
		Map<String, Object> currentScope = scopes.get(ctx.getParent().getParent());
		currentScope.put(ctx.WORD().getText(), values.get(ctx.expr()));
	}
	
	// @Override public void enterArrayAssign(MusicinatorParser.ArrayAssignContext ctx) { }
	@Override public void exitArrayAssign(MusicinatorParser.ArrayAssignContext ctx) {
		//System.out.println("Array Assigned: "+ ctx.WORD() + " of type " + ctx.arrayTypes().getText());	

		// add variable to the scope
		Map<String, Object> currentScope = scopes.get(ctx.getParent().getParent());
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
	@Override public void exitLoopPlay(MusicinatorParser.LoopPlayContext ctx) { }
	// @Override public void enterRepeatPlay(MusicinatorParser.RepeatPlayContext ctx) { }
	@Override public void exitRepeatPlay(MusicinatorParser.RepeatPlayContext ctx) { }
	// @Override public void enterSimplePlay(MusicinatorParser.SimplePlayContext ctx) { }
	@Override public void exitSimplePlay(MusicinatorParser.SimplePlayContext ctx) { }
	// @Override public void enterTimedPlay(MusicinatorParser.TimedPlayContext ctx) { }
	@Override public void exitTimedPlay(MusicinatorParser.TimedPlayContext ctx) {
		// check wether AT or AFTER
		// check wehter ALWAYS
	}

/*
	 .|';               
	 ||                 
	'||'  .|''|, '||''| 
	 ||   ||  ||  ||    
	.||.  `|..|' .||.   
	                  
*/
	
	@Override public void enterForStat(MusicinatorParser.ForStatContext ctx) {
		scopes.put(ctx, new HashMap<String, Object>());
		
		// add python code to iterate the for loop to stringbuilder
		// if numbers, use for numbers
		currentIndentation += "\t";
	}
	@Override public void exitForStat(MusicinatorParser.ForStatContext ctx) {
		// end for loop

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
		scopes.put(ctx, new HashMap<String, Object>());

		// add python code to iterate the if to stringbuilder
		currentIndentation += "\t";
	}
	@Override public void exitIfStat(MusicinatorParser.IfStatContext ctx) {
		// end if

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
		if(ctx.list() != null) {
			values.put(ctx, values.get(ctx.list()));
		} else if (ctx.ARROW() != null) {
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
				System.err.println("ERROR! Can't create number array "+start+"->"+end+"! "+start+" is bigger than "+end+"!");
				System.exit(1);
			}

		} else if (ctx.expr(0) != null) {
			// get type of array
			MusicinatorParser.ArrayAssignContext assignCtx = (MusicinatorParser.ArrayAssignContext)ctx.getParent().getRuleContext();
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
				System.out.println("ERROR: array of type " + type + " could not be created!");
				System.exit(1);
			}
		} else {
			// array is empty ("[]")
			values.put(ctx, (Object)new Object[0]);
		}
	}
	
	// @Override public void enterList(MusicinatorParser.ListContext ctx) { }
	@Override public void exitList(MusicinatorParser.ListContext ctx) {
		// get type of array
		MusicinatorParser.ArrayAssignContext assignCtx = (MusicinatorParser.ArrayAssignContext)ctx.getParent().getParent().getRuleContext();
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
			System.out.println("ERROR: array of type " + type + " could not be created!");
			System.exit(1);
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
			System.err.println("ERROR! Variable \"" + ctx.sequence().getText() + "\" is not a sequence!");
			System.exit(1);
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
	
	// @Override public void enterSeqLiteral(MusicinatorParser.SeqLiteralContext ctx) { }
	@Override public void exitSeqLiteral(MusicinatorParser.SeqLiteralContext ctx) {
		Note[] n = new Note[1];
		n[0] = new Note(ctx.SOUND().getText());
		values.put(ctx, new Sequence(n));
	}
	
	// @Override public void enterSeqPitchMod(MusicinatorParser.SeqPitchModContext ctx) { }
	@Override public void exitSeqPitchMod(MusicinatorParser.SeqPitchModContext ctx) {
		// get sequence
		if(!(values.get(ctx.sequence()) instanceof Sequence)) {
				System.err.println("ERROR! Variable \"" + ctx.sequence().getText() + "\" is not a sequence!");
				System.exit(1);
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
				System.err.println("ERROR! Variable \"" + ctx.sequence(0).getText() + "\" is not a sequence!");
				System.exit(1);
			}
			seq = (Sequence)values.get(ctx.sequence(0));

			// join all other sequences to the first one
			for (int i = 1; i < seqNum; i++) {
				if(!(values.get(ctx.sequence(i)) instanceof Sequence)) {
					System.err.println("ERROR! Variable \"" + ctx.sequence(i).getText() + "\" is not a sequence!");
					System.exit(1);
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
		// get sequence
		if(!(values.get(ctx.sequence()) instanceof Sequence)) {
				System.err.println("ERROR! Variable \"" + ctx.sequence().getText() + "\" is not a sequence!");
				System.exit(1);
		}
		Sequence seq = (Sequence)values.get(ctx.sequence());

		// get instrument
		if (!music.isInstrument(ctx.WORD().getText())) {
			System.err.println("ERROR! Variable \"" + ctx.WORD().getText() + "\" does not exist!");
			System.exit(1);
		}
		Instrument inst = (Instrument)music.getInstrument(ctx.WORD().getText());

		values.put(ctx, (Object)new Performance(seq, inst));
	}
	
	// @Override public void enterPerSpeedMod(MusicinatorParser.PerSpeedModContext ctx) { }
	@Override public void exitPerSpeedMod(MusicinatorParser.PerSpeedModContext ctx) {
		// get performance
		if(!(values.get(ctx.performance()) instanceof Performance)) {
				System.err.println("ERROR! Variable \"" + ctx.performance().getText() + "\" is not a performance!");
				System.exit(1);
		}
		Performance per = (Performance)values.get(ctx.performance());

		// mod performance
		if (ctx.op.equals("*"))
			values.put(ctx, per.modulateTempo((double)values.get(ctx.number())));
		else
			values.put(ctx, per.modulateTempo(-1*(double)values.get(ctx.number())));
	}
	
	// @Override public void enterPerPitchMod(MusicinatorParser.PerPitchModContext ctx) { }
	@Override public void exitPerPitchMod(MusicinatorParser.PerPitchModContext ctx) {
		// get performance
		if(!(values.get(ctx.performance()) instanceof Performance)) {
				System.err.println("ERROR! Variable \"" + ctx.performance().getText() + "\" is not a performance!");
				System.exit(1);
		}
		Performance per = (Performance)values.get(ctx.performance());

		// mod performance
		if (ctx.op.equals("+"))
			values.put(ctx, per.modulatePitch((int)(double)values.get(ctx.number())));
		else
			values.put(ctx, per.modulatePitch(-1*(int)(double)values.get(ctx.number())));
	}

/*
	'||\   ||`                     '||                         
	 ||\\  ||                       ||                         
	 || \\ ||  '||  ||` '||),,(|,   ||''|, .|''|, '||''| ('''' 
	 ||  \\||   ||  ||   || || ||   ||  || ||..||  ||     `'') 
	.||   \||.  `|..'|. .||    ||. .||..|' `|...  .||.   `...' 
	                                                           
*/	
	// @Override public void enterNumDouble(MusicinatorParser.NumDoubleContext ctx) { }
	@Override public void exitNumDouble(MusicinatorParser.NumDoubleContext ctx) {
		values.put(ctx, (Object)(Double.parseDouble(ctx.getText())));
	}
	
	// @Override public void enterNumMulDiv(MusicinatorParser.NumMulDivContext ctx) { }
	@Override public void exitNumMulDiv(MusicinatorParser.NumMulDivContext ctx) {
		if(ctx.op.equals("*"))
			values.put(ctx, (Object)((double)values.get(ctx.number(0)) * (double)values.get(ctx.number(1))));
		else
			values.put(ctx, (Object)((double)values.get(ctx.number(0)) / (double)values.get(ctx.number(1))));
	}

	// @Override public void enterNumAddSub(MusicinatorParser.NumAddSubContext ctx) { }
	@Override public void exitNumAddSub(MusicinatorParser.NumAddSubContext ctx) {
		if(ctx.op.equals("+"))
			values.put(ctx, (Object)((double)values.get(ctx.number(0)) + (double)values.get(ctx.number(1))));
		else
			values.put(ctx, (Object)((double)values.get(ctx.number(0)) - (double)values.get(ctx.number(1))));
	}
	
	// @Override public void enterNumVar(MusicinatorParser.NumVarContext ctx) { }
	@Override public void exitNumVar(MusicinatorParser.NumVarContext ctx) {
		values.put(ctx, values.get(ctx.variable()));
	}

	// @Override public void enterNumInt(MusicinatorParser.NumIntContext ctx) { }
	@Override public void exitNumInt(MusicinatorParser.NumIntContext ctx) {
		values.put(ctx, (Object)(Double.parseDouble(ctx.getText())));
	}
	
	// @Override public void enterNumDuration(MusicinatorParser.NumDurationContext ctx) { }
	@Override public void exitNumDuration(MusicinatorParser.NumDurationContext ctx) {
		Map<String, Object> currentScope = getCurrentScope(ctx.getParent().getParent());
		
		// get sequence
		if(!(currentScope.get(ctx.WORD().getText()) instanceof Sequence)) {
				System.err.println("ERROR! Variable \"" + ctx.WORD().getText() + "\" is not a sequence!");
				System.exit(1);
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
				System.err.println("ERROR! Variable \"" + var + "\" does not exist!");
				System.exit(1);
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
	
	// @Override public void enterTypes(MusicinatorParser.TypesContext ctx) { }
	// @Override public void exitTypes(MusicinatorParser.TypesContext ctx) { }
	
	// @Override public void enterArrayTypes(MusicinatorParser.ArrayTypesContext ctx) { }
	// @Override public void exitArrayTypes(MusicinatorParser.ArrayTypesContext ctx) { }
	
	// @Override public void enterCondition(MusicinatorParser.ConditionContext ctx) { }
	// @Override public void exitCondition(MusicinatorParser.ConditionContext ctx) { }


	// @Override public void enterEveryRule(ParserRuleContext ctx) { }
	// @Override public void exitEveryRule(ParserRuleContext ctx) { }
	// @Override public void visitTerminal(TerminalNode node) { }
	// @Override public void visitErrorNode(ErrorNode node) { }
}