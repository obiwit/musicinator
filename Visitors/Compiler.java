// Generated from MusicinatorParser.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.stringtemplate.v4.*;

//import org.antlr.v4.runtime.RuleContext;

import java.io.*;
import java.util.*;
/**
 * This class provides an empty implementation of {@link MusicinatorParserVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <Variable> The return type of the visit operation. 
 */
public class Compiler extends MusicinatorParserBaseVisitor<Variable> {
	private Scope globalScope;
	private Scope currentScope;
	private Music music;

	private final STGroup group;
	private PrintWriter printer;

	private int varNum;
	private String currentIndentation;

	Compiler(Music m, Scope s, String dstFile) {
		music = m;
		globalScope = s;
		currentScope = globalScope;

		varNum = 0;
		currentIndentation = "";

		group = new STGroupFile("generator.stg");

		try {
			printer = new PrintWriter(new FileOutputStream(new File(dstFile))); 
		} catch (IOException e) {
			System.err.println("Couldn't write to \"" + dstFile + "\"!");
			System.exit(1);
		}
	}

	
	@Override public Variable visitMain(MusicinatorParser.MainContext ctx) {
System.out.println("Started Compilation (๑˃̵ᴗ˂̵)و"); 

		printer.println(group.getInstanceOf("header").render()+"\n"); //Python imports

		// add global definitions
		ST gen = group.getInstanceOf("createmidi");
		gen.add("varbpm", music.bpm());				//Initializing Midi
		gen.add("vartrack", "65534");
		printer.println(gen.render()+"\n");

		// add all instruments as arrays 
		HashMap<String, Instrument> instruments = music.instruments();
		Set<String> instrNames = instruments.keySet();
		for (String s : instrNames) {
		    gen = group.getInstanceOf("vardec");
			gen.add("indentation", currentIndentation);
			gen.add("varname", s);				
			gen.add("value", instruments.get(s));
			printer.println(gen.render());
		}

		// add all note aliases
		HashMap<String, Integer> noteMap = music.noteMap();
		Set<String> noteNames = noteMap.keySet();
		for (String s : noteNames) {
		    gen = group.getInstanceOf("vardec");
			gen.add("indentation", currentIndentation);
			gen.add("varname", s);				
			gen.add("value", noteMap.get(s));
			printer.println(gen.render());
		}

		// add methods
		printer.println("\n"+group.getInstanceOf("body").render()+"\n"); // def addnotes()

		// visit children
		Variable v = visitChildren(ctx);

		// add instruction to export to destination file
		gen = group.getInstanceOf("exportfile");
		gen.add("name", "out.mid");
		printer.println("\n"+gen.render());

		printer.flush();
		return v;

	}

	// TODO remove method
	@Override public Variable visitInstructions(MusicinatorParser.InstructionsContext ctx) {
printer.println(currentIndentation+"############################ LINE = "+ctx.start.getLine());	
		return visitChildren(ctx);
	}
	
	// ASSIGN
	@Override public Variable visitAssign(MusicinatorParser.AssignContext ctx) { 

		String varName = ctx.WORD().getText();

		ST gen = group.getInstanceOf("vardec");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName);
		gen.add("value", visit(ctx.expr()).name());
		printer.println(gen.render());

		return currentScope.getVariable(varName);
	}
	
	// FOR
	@Override public Variable visitForStat(MusicinatorParser.ForStatContext ctx) { 
		// create new scope child
		currentScope = currentScope.getNextChildScope();

		// generate for loop
		ST gen = group.getInstanceOf("forloop");
		gen.add("indentation", currentIndentation);
		gen.add("instance", ctx.WORD().getText());
		gen.add("array", visit(ctx.expr()).name());
		printer.println(gen.render());

		// update indentation level and visit children
		currentIndentation += "\t";
		Iterator<MusicinatorParser.InstructionsContext> forIntructions = ctx.forBody.iterator();
		while(forIntructions.hasNext()) {
			visit(forIntructions.next()); 
		}

		// restore indentation level and return to parent scope
		currentIndentation = currentIndentation.substring(0, currentIndentation.length() -1);
		currentScope = currentScope.getParentScope();

		return new Variable("", Type.NONE);
	}
	
	// IF
	@Override public Variable visitIfStat(MusicinatorParser.IfStatContext ctx) { 	
		// create new scope child
		currentScope = currentScope.getNextChildScope();

		// visit else if conditions before generating if
		// (otherwise it wouldn't be possible to initialize
		// the variables for the else if conditions)
		Iterator<MusicinatorParser.ConditionContext> conditions = ctx.elifCond.iterator();
		int elifNum = ctx.ELIF().size();
		String[] elifConds = new String[elifNum];
		for (int i = 0; i < elifNum; i++) {
			elifConds[i] = visit(conditions.next()).name();
		}

		// generate if statement
		ST gen = group.getInstanceOf("if");
		gen.add("indentation", currentIndentation);
		gen.add("condition", visit(ctx.ifCond).name());
		printer.println(gen.render());

		// update indentation level and visit children
		currentIndentation += "\t";
		Iterator<MusicinatorParser.InstructionsContext> ifIntructions = ctx.ifBody.iterator();
		while(ifIntructions.hasNext()) {
			visit(ifIntructions.next()); 
		}

		// restore indentation
		currentIndentation = currentIndentation.substring(0, currentIndentation.length() -1);

		// generate else ifs, if any
		Iterator<MusicinatorParser.InstructionsContext> iter = ctx.elifBody.iterator();
		
		if (elifNum > 1) {
			// get start of first else if block 
			conditions = ctx.elifCond.iterator();
			MusicinatorParser.ConditionContext condition = conditions.next();

			int i = 0; 
		    while(iter.hasNext()) {
				MusicinatorParser.InstructionsContext instruc = iter.next();

				// generate new else if blocks, if needed
				if (instruc.start.getStartIndex() > condition.start.getStartIndex()) {
					if (conditions.hasNext())
						condition = conditions.next();

					gen = group.getInstanceOf("elif");
					gen.add("indentation", currentIndentation);
					gen.add("condition", elifConds[i++]);
					printer.println(gen.render());
				}

				// visit block body
				currentIndentation += "\t";
				visit(instruc);
				currentIndentation = currentIndentation.substring(0, currentIndentation.length() -1);
		    }
		} else { // 1 or 0 else ifs
			while(iter.hasNext()) { // implies 1 else if

				// start else if
				gen = group.getInstanceOf("elif");
				gen.add("indentation", currentIndentation);
				gen.add("condition", elifConds[0]);
				printer.println(gen.render());

				// visit else if body
				MusicinatorParser.InstructionsContext instruc = iter.next();
				currentIndentation += "\t";
				visit(instruc);
				currentIndentation = currentIndentation.substring(0, currentIndentation.length() -1);
			}
		}

		// generate else, if any
		if (ctx.ELSE() != null) {
			gen = group.getInstanceOf("else");
			gen.add("indentation", currentIndentation);
			printer.println(gen.render());

			// visit else body
			currentIndentation += "\t";
			Iterator<MusicinatorParser.InstructionsContext> elseIntructions = ctx.elseBody.iterator();
			while(elseIntructions.hasNext()) {
				visit(elseIntructions.next()); 
			}
			currentIndentation = currentIndentation.substring(0, currentIndentation.length() -1);
		}

		// return to parent scope
		currentScope = currentScope.getParentScope();
		return new Variable("", Type.NONE);
	}
	
	// PLAY
	private void insertInMIDI(Variable per, String instanceName) { // adds performance to MIDI

		String addnotesIndentation = currentIndentation;

		// if play was applied to a performance array, instead of
		// adding only a performance, must add every perfomance iterated
		// over in the for loop that play created 
		if (per.type() == Type.PERFORMANCE_ARRAY)
			addnotesIndentation += "\t";

		ST gen = group.getInstanceOf("u_addnotes");
		gen.add("indentation", addnotesIndentation);
		gen.add("varname", instanceName);
		printer.println(gen.render());
	}

	@Override public Variable visitSimplePlay(MusicinatorParser.SimplePlayContext ctx) {
		// get passed performance and repeatTimes
		Variable per = visit(ctx.per);
		String varName = per.name();
		String repeatTimes = (ctx.rep == null)? "1": ctx.rep.getText();

		// variable used to keep track of start times, needed
		// if play is sequential
		String startTime = "_" + varNum++; 
		ST gen = group.getInstanceOf("vardec");
		gen.add("indentation", currentIndentation);
		gen.add("varname", startTime);
		gen.add("value", "0");
		printer.println(gen.render());

		// generate name for performance (needed in case of performance arrays)
		String instanceName = "_" + varNum++; 

		// if per is actually an array, generate a for loop that
		// iterates over all the performances
		if (per.type() == Type.PERFORMANCE_ARRAY) {
			// generate for loop
			gen = group.getInstanceOf("forloop");
			gen.add("indentation", currentIndentation);
			gen.add("instance", instanceName);
			gen.add("array", varName);
			printer.println(gen.render());
			currentIndentation += "\t";

			// generate simple play for each performance in array
			if (ctx.SEQUENTIALLY() != null) {
				generateSimplePlay(instanceName, repeatTimes, startTime);

				String increment = "_" + varNum++;
				gen = group.getInstanceOf("u_duration");
				gen.add("indentation", currentIndentation);
				gen.add("varname", increment);
				gen.add("performance", instanceName);
				printer.println(gen.render());

				gen = group.getInstanceOf("vardec");
				gen.add("indentation", currentIndentation);
				gen.add("varname", startTime);
				gen.add("value", startTime+"+"+increment);
				printer.println(gen.render());

			}

			// end generated for loop
			currentIndentation = currentIndentation.substring(0, currentIndentation.length() -1);

		} else {
			// copy performance to new var
			gen = group.getInstanceOf("vardec");
			gen.add("indentation", currentIndentation);
			gen.add("varname", instanceName);
			gen.add("value", per.name());
			printer.println(gen.render());

			generateSimplePlay(instanceName, repeatTimes, "0");
		}

		if(!(ctx.getParent() instanceof MusicinatorParser.TimedPlayContext)) {
			insertInMIDI(per, instanceName);
		}

		return per;
	}

	private void generateSimplePlay(String varName, String repeatTimes, String startTime) {
		// change start time to startTime
		ST gen = group.getInstanceOf("vardec");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName+"[0]");
		gen.add("value", "["+startTime+"]");
		printer.println(gen.render());

		// change repeat times to given number or 1, if no number was given 
		gen = group.getInstanceOf("vardec");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName+"[2]");
		gen.add("value", repeatTimes);
		printer.println(gen.render());

		// update longestPerformanceDuration
		gen = group.getInstanceOf("u_prepplay");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName);
		printer.println(gen.render());
	}
	
	@Override public Variable visitTimedPlay(MusicinatorParser.TimedPlayContext ctx) {
		// get passed performance and repeatTimes
		Variable per = visit(ctx.play());
		String varName = per.name();
		Variable startVar = visit(ctx.expr());

		// generate name for performance (needed in case of performance arrays)
		String instanceName = "_" + varNum++; 

		// if per is actually an array, generate a for loop that
		// iterates over all the performances
		if (per.type() == Type.PERFORMANCE_ARRAY) {
			// generate for loop
			ST gen = group.getInstanceOf("forloop");
			gen.add("indentation", currentIndentation);
			gen.add("instance", instanceName);
			gen.add("array", varName);
			printer.println(gen.render());
			currentIndentation += "\t";

			// generate timed play for each performance in array
			generateTimedPlay(instanceName, startVar);

			// end generated for loop
			currentIndentation = currentIndentation.substring(0, currentIndentation.length() -1);

		} else {
			// copy performance to new var
			ST gen = group.getInstanceOf("vardec");
			gen.add("indentation", currentIndentation);
			gen.add("varname", instanceName);
			gen.add("value", visit(ctx.play()).name());
			printer.println(gen.render());

			generateTimedPlay(instanceName, startVar);
		}

		insertInMIDI(per, instanceName);

		return per;
	}
	
	private void generateTimedPlay(String varName, Variable start) {
		// change start time, by adding offset to original time
		// (to allow sequential play)
		ST gen = group.getInstanceOf("u_offsetstart");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName);
		gen.add("performance", varName);

		// if start var not number arrar, add [] around it
		if (start.type() == Type.NUMBER_ARRAY) {
			gen.add("offset", start.name());
		} else {
			gen.add("offset", "["+start.name()+"]");
		}
		printer.println(gen.render());

		// update longestPerformanceDuration
		gen = group.getInstanceOf("u_prepplay");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName);
		printer.println(gen.render());
	}
	
	@Override public Variable visitLoopPlay(MusicinatorParser.LoopPlayContext ctx) { 
		// get passed performance and repeatTimes
		Variable per = visit(ctx.expr());

		// generate name for performance (needed in case of performance arrays)
		String instanceName = "_" + varNum++; 

		// if per is actually an array, generate a for loop that
		// iterates over all the performances
		if (per.type() == Type.PERFORMANCE_ARRAY) {

			// generate for loop
			ST gen = group.getInstanceOf("forloop");
			gen.add("indentation", currentIndentation);
			gen.add("instance", instanceName);
			gen.add("array", per.name());
			printer.println(gen.render());
			currentIndentation += "\t";

			// generate loop play for each performance in array
			generateLoopPlay(instanceName);

			// end generated for loop
			currentIndentation = currentIndentation.substring(0, currentIndentation.length() -1);

		} else {
			// copy performance to new var
			ST gen = group.getInstanceOf("vardec");
			gen.add("indentation", currentIndentation);
			gen.add("varname", instanceName);
			gen.add("value", per.name());
			printer.println(gen.render());

			generateLoopPlay(instanceName);
		}

		insertInMIDI(per, instanceName);
		return new Variable(instanceName, per.type());
	}
	private void generateLoopPlay(String varName) {
		// change start time to 0
		ST gen = group.getInstanceOf("vardec");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName+"[0]");
		gen.add("value", "[0]");
		printer.println(gen.render());

		// change repeat times to allow looping
		gen = group.getInstanceOf("u_preploop");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName);
		printer.println(gen.render());
	}
	
	// EXPR (SIMPLE TYPES)
	@Override public Variable visitVarExpr(MusicinatorParser.VarExprContext ctx) {
		return visit(ctx.variable());
	}
	
	@Override public Variable visitSeqExpr(MusicinatorParser.SeqExprContext ctx) { 
		return visit(ctx.sequence());
	}
	
	@Override public Variable visitNumExpr(MusicinatorParser.NumExprContext ctx) { 
		return visit(ctx.number());
	}
	
	@Override public Variable visitParensExpr(MusicinatorParser.ParensExprContext ctx) { 
		return visit(ctx.expr());
	}
	
	@Override public Variable visitMulDivExpr(MusicinatorParser.MulDivExprContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen;

		// check whether first operand is Type.NUMBER or not
		Variable firstOperand = visit(ctx.e1);
		if (firstOperand.type() == Type.NUMBER) {

			gen = group.getInstanceOf("vardec");
			gen.add("indentation", currentIndentation);
			gen.add("varname", varName);
			gen.add("value", firstOperand.name()+ctx.op.getText()+visit(ctx.e2).name());

		} else { 

			// firstOperand is a performance or sequence
			gen = group.getInstanceOf("u_modTempo");
			gen.add("indentation", currentIndentation);
			gen.add("varname", varName);
			gen.add("performance", firstOperand.name());

			String modNumber = visit(ctx.e2).name();
			if (ctx.op.getText().equals("/")) 
				modNumber = "1/"+modNumber;

			gen.add("modnumber", modNumber);
		}
		
		printer.println(gen.render());
		return new Variable(varName, firstOperand.type());
	}
	
	@Override public Variable visitAddSubExpr(MusicinatorParser.AddSubExprContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen;

		// check whether first operand is Type.NUMBER or not
		Variable firstOperand = visit(ctx.e1);
		if (firstOperand.type() == Type.NUMBER) {

			gen = group.getInstanceOf("vardec");
			gen.add("indentation", currentIndentation);
			gen.add("varname", varName);
			gen.add("value", firstOperand.name()+ctx.op.getText()+visit(ctx.e2).name());

		} else { 
			
			// firstOperand is a performance or sequence
			gen = group.getInstanceOf("u_modPitch");
			gen.add("indentation", currentIndentation);
			gen.add("varname", varName);
			gen.add("performance", firstOperand.name());

			String modNumber = visit(ctx.e2).name();
			if (ctx.op.getText().equals("-")) 
				modNumber = "-1*"+modNumber;
			gen.add("modnumber", modNumber);
		}
		
		printer.println(gen.render());
		return new Variable(varName, firstOperand.type());
	}
	
	// EXPR (ARRAYS)
	@Override public Variable visitBracketArray(MusicinatorParser.BracketArrayContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName);

		Variable v = visit(ctx.expr(0));
		gen.add("value", "[" + v.name());

		int exprsNum = ctx.expr().size();
		for (int i = 1; i < exprsNum; i++) {
			gen.add("value", "," + visit(ctx.expr(i)).name());
		}
		gen.add("value", "]");
		printer.println(gen.render());

		return new Variable(varName, Type.toArrayType(v.type()));
	}

	@Override public Variable visitAndArray(MusicinatorParser.AndArrayContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName);

		// generate array in python, taking care to use the correct notation depending
		// on expr being a simple type or an array
		Variable v = visit(ctx.expr(0));
		if (Type.isSimpleType(v.type())) {
			gen.add("value", "[" + v.name()+"]");
		} else {
			gen.add("value", " + " + v.name());
		}

		int exprsNum = ctx.expr().size();
		for (int i = 1; i < exprsNum; i++) {
			v = visit(ctx.expr(i));

			if (Type.isSimpleType(v.type())) {
				gen.add("value", " + [" + v.name()+"]");
			} else {
				gen.add("value", " + " + v.name());
			}
		}
		printer.println(gen.render());

		return new Variable(varName, Type.toArrayType(v.type()));
	}

	@Override public Variable visitNumRangeArray(MusicinatorParser.NumRangeArrayContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("range");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName);
		gen.add("first", visit(ctx.e1).name());
		gen.add("last", visit(ctx.e2).name());
		printer.println(gen.render());

		return new Variable(varName, Type.NUMBER_ARRAY);
	}
	
	// SEQUENCE
	@Override public Variable visitSeqNote(MusicinatorParser.SeqNoteContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName);
		gen.add("value", "[" + new Note(ctx.SOUND().getText()) + "]");
		printer.println(gen.render());

		return new Variable(varName, Type.NOTE);
	}

	@Override public Variable visitSeqChord(MusicinatorParser.SeqChordContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName);
		gen.add("value", new Chord(ctx.CHORD().getText()));
		printer.println(gen.render());

		return new Variable(varName, Type.NOTE);
	}

	@Override public Variable visitSeqList(MusicinatorParser.SeqListContext ctx) { 

		String varName = "_" + varNum++; // descartable variable

		// create empty sequence
		ST gen = group.getInstanceOf("vardec");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName);
		gen.add("value", "[]");
		printer.println(gen.render());

		int sequencesNum = ctx.expr().size();

		// if not empty array, add sequences that make it up
		for (int i = 0; i < sequencesNum; i++) {
			Variable vExpr = visit(ctx.expr(i));

			if (vExpr.type() == Type.NOTE) {
				// add note or chord to sequence
				gen = group.getInstanceOf("u_extendseq");
				gen.add("indentation", currentIndentation);
				gen.add("varname", varName);
				gen.add("original",varName);
				gen.add("toextend",vExpr.name());
				printer.println(gen.render());

			} else { 
				// expr is a sequence
				gen = group.getInstanceOf("u_appendseq");
				gen.add("indentation", currentIndentation);
				gen.add("varname", varName);
				gen.add("original",varName);
				gen.add("toappend",vExpr.name());
				printer.println(gen.render());

			}
		}

		return new Variable(varName, Type.SEQUENCE);
	}

	// PERFORMANCE
	@Override public Variable visitPerformance(MusicinatorParser.PerformanceContext ctx) { 

		String varName = "_" + varNum++; // descartable variable

		Variable seq = visit(ctx.expr());
		Variable inst = visit(ctx.variable());

		if (seq.type() == Type.SEQUENCE && inst.type() == Type.INSTRUMENT) {			
			
			createPerformance(varName, seq.name(), inst.name());
			return new Variable(varName, Type.PERFORMANCE);

		} else { // performance array

			// create new performance array
			ST gen = group.getInstanceOf("vardec");
			gen.add("indentation", currentIndentation);
			gen.add("varname", varName);
			gen.add("value", "[]");
			printer.println(gen.render());

			String instanceName = "_" + varNum++; // descartable variable
			// generate for loop
			gen = group.getInstanceOf("forloop");
			gen.add("indentation", currentIndentation);
			gen.add("instance", instanceName);
			if (seq.type() == Type.SEQUENCE_ARRAY) {
				gen.add("array", seq.name());
			} else {
				gen.add("array", inst.name());
			}
			printer.println(gen.render());
			currentIndentation += "\t";

			// generate loop play for each performance in array
			if (seq.type() == Type.SEQUENCE_ARRAY) {
				createPerformance(instanceName, instanceName, inst.name());
			} else {
				createPerformance(instanceName, seq.name(), instanceName);
			}

			// append new performances to array
			gen = group.getInstanceOf("append");
			gen.add("indentation", currentIndentation);
			gen.add("varname", varName);
			gen.add("toappend", instanceName);
			printer.println(gen.render());

			// end generated for loop
			currentIndentation = currentIndentation.substring(0, currentIndentation.length() -1);
			return new Variable(varName, Type.PERFORMANCE_ARRAY);
		}

	} 
	private void createPerformance(String varName, String seqName, String instName) {

		// get sequence and tie it to an instrument
		ST gen = group.getInstanceOf("u_setinstrument");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName);
		String sequence = seqName;
		gen.add("seq", sequence);
		gen.add("instrument", instName);
		printer.println(gen.render());

		// create performance, with 'flag' values for start & repeat times
		gen = group.getInstanceOf("vardec");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName);
		gen.add("value", "[[-1], "+varName+", -1]");
		printer.println(gen.render());
	}

	// NUMBER
	@Override public Variable visitNumInt(MusicinatorParser.NumIntContext ctx) { 

		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName);
		gen.add("value", ctx.INT().getText());

		printer.println(gen.render());

		return new Variable(varName, Type.NUMBER);
	}

	@Override public Variable visitNumDouble(MusicinatorParser.NumDoubleContext ctx) { 

		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName);
		gen.add("value", ctx.DOUBLE().getText());

		printer.println(gen.render());

		return new Variable(varName, Type.NUMBER);
	}

	@Override public Variable visitNumGetInt(MusicinatorParser.NumGetIntContext ctx) { 

		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("u_getint");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName);
		gen.add("str", ctx.STRING().getText());

		printer.println(gen.render());

		return new Variable(varName, Type.NUMBER);
	}

	@Override public Variable visitNumDuration(MusicinatorParser.NumDurationContext ctx) { 
		
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("u_duration");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName);
		gen.add("performance", visit(ctx.variable()).name());

		printer.println(gen.render());

		return new Variable(varName, Type.NUMBER);
	}

	// VARIABLE
	@Override public Variable visitVariable(MusicinatorParser.VariableContext ctx) {
		String varName = ctx.WORD().getText();

	 	if (currentScope.isVariable(varName)) {

	 		// check if variable is an indexing of an array
			if (ctx.getText().contains("[")) {

				if (ctx.COLON() == null) {
					// if variable is entry of array (without colon),
					// return it as a simple type
					return new Variable(ctx.getText(),
						Type.toSimpleType(currentScope.getVariable(varName).type()));
				} else {

					// create array slice
					varName = "_" + varNum++;

					ST gen = group.getInstanceOf("vardec");
					gen.add("indentation", currentIndentation);
					gen.add("varname", varName);
					gen.add("value", ctx.getText());
					printer.println(gen.render());

					return new Variable(varName, 
						currentScope.getVariable(ctx.WORD().getText()).type());
				}
			}

			// otherwise, it's a variable
			return currentScope.getVariable(ctx.WORD().getText());

	 	} else if (music.isNoteName(varName)) {

	 		// generate sequence from note name
	 		varName = "_" + varNum++;
	 		double varDuration = 1;

			if (ctx.DURATION() != null) {
				varDuration = Note.durationFromStr(ctx.DURATION().getText());
			}

			ST gen = group.getInstanceOf("vardec");
			gen.add("indentation", currentIndentation);
			gen.add("varname", varName);
			gen.add("value", "("+ctx.WORD().getText()+","+varDuration+"-1,-1)");
			printer.println(gen.render());

	 		return new Variable(varName, Type.SEQUENCE);

	 	} else { // is instrument
	 		return new Variable(ctx.getText(), Type.INSTRUMENT);
	 	}
	}

	@Override public Variable visitCondition(MusicinatorParser.ConditionContext ctx) { 
		
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		gen.add("indentation", currentIndentation);
		gen.add("varname", varName);

		// get condition value
		String value = "";
		if (ctx.e1 == null) {
			value = visit(ctx.condition()).name();
		} else {
			value = visit(ctx.e1).name() + ctx.op.getText() + visit(ctx.e2).name();
		}

		gen.add("value", value);
		printer.println(gen.render());

		return new Variable(varName, Type.BOOL);
	}
}