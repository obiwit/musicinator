// Generated from MusicinatorParser.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.stringtemplate.v4.*;

import java.io.*;
import java.util.*;
/**
 * This class provides an empty implementation of {@link MusicinatorParserVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class Compiler extends MusicinatorParserBaseVisitor<Variable> {
	Scope globalScope;
	Scope currentScope;
	private Music music;

	private final STGroup group;
	private PrintWriter printer;
	private int varNum;

	Compiler(Music m, Scope s, String dstFile) {
		music = m;
		globalScope = s;
		currentScope = globalScope;

		varNum = 0;

		group = new STGroupFile("generator.stg");

		try {
			printer = new PrintWriter(new FileOutputStream(new File(dstFile))); 
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't write to \"" + dstFile + "\"!");
			System.exit(1);
		}
	}

	
	@Override public Variable visitMain(MusicinatorParser.MainContext ctx) {
System.out.println("Started Compilation (๑˃̵ᴗ˂̵)و"); 

		int maxtracks = ctx.instructions().size();
		printer.println(group.getInstanceOf("header").render()+"\n"); //Python imports

		// add global definitions
		ST gen = group.getInstanceOf("createmidi");
		gen.add("varbpm", music.bpm());				//Initializing Midi
		gen.add("vartrack", maxtracks);
		printer.println(gen.render()+"\n");

		// add all instruments as arrays 
		HashMap<String, Instrument> instruments = music.getAllInstruments();
		Set<String> instrNames = instruments.keySet();
		for (String s : instrNames) {
		    gen = group.getInstanceOf("vardec");
			gen.add("varname", s);				
			gen.add("value", instruments.get(s));
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
	
	@Override public Variable visitInstructions(MusicinatorParser.InstructionsContext ctx) {
printer.println("############################ LINE = "+ctx.start.getLine());	

		if (ctx.play() != null) {
			Variable v = visit(ctx.play());

			ST gen = group.getInstanceOf("u_addnotes");
			gen.add("varname", v.name());
			printer.println(gen.render());

			return v;
		} else {
			return visitChildren(ctx);
		}
	}
	
	// ASSIGN
	@Override public Variable visitAssignment(MusicinatorParser.AssignmentContext ctx) { 

		String varName = ctx.WORD().getText();

		ST gen = group.getInstanceOf("vardec");
		gen.add("varname", varName);
		gen.add("value", visit(ctx.expr()).name());
		printer.println(gen.render());

		return currentScope.getVariable(varName);
	}
	
	// PLAY
	@Override public Variable visitSimplePlay(MusicinatorParser.SimplePlayContext ctx) {
		String varName = visit(ctx.per).name();

		// change start time to 0
		ST gen = group.getInstanceOf("vardec");
		gen.add("varname", varName+"[0]");
		gen.add("value", "[0]");
		printer.println(gen.render());

		// change repeat times to given number or 1, if no number was given 
		String repeatTimes = (ctx.rep == null)? "1": ctx.rep.getText();
		gen = group.getInstanceOf("vardec");
		gen.add("varname", varName+"[2]");
		gen.add("value", repeatTimes);
		printer.println(gen.render());

		// TODOs
		// update longestPerformanceDuration

		// TODO return other value
		return new Variable(varName, Type.ERROR);
	}
	
	@Override public Variable visitTimedPlay(MusicinatorParser.TimedPlayContext ctx) {

		String varName = visit(ctx.play()).name();

		// change start time
		ST gen = group.getInstanceOf("vardec");
		gen.add("varname", varName+"[0]");

		// TODO if var not number arrar, add []
		Variable v = visit(ctx.expr());
		if (v.type() == Type.NUMBER_ARRAY) {
			gen.add("value", v.name());
		} else {
			gen.add("value", "["+v.name()+"]");
		}

		printer.println(gen.render());

		// TODO
		// update longestPerformanceDuration 

		// TODO return other value
		return new Variable(varName, Type.ERROR);
	}
	
	@Override public Variable visitLoopPlay(MusicinatorParser.LoopPlayContext ctx) { 
		// TODO
		return visitChildren(ctx);
	}
	
	// FOR
	@Override public Variable visitForStat(MusicinatorParser.ForStatContext ctx) { 
		// TODO

		// create new scope child
		currentScope = currentScope.getNextChildScope();

		ST gen = group.getInstanceOf("forloop");
		gen.add("instance", ctx.newVar.getText());
		gen.add("array", ctx.array.getText());
		gen.add("code", "");
		printer.println(gen.render());

		Variable v = visitChildren(ctx); 


		// return to parent scope
		currentScope = currentScope.getParentScope();

		return v;
	}
	
	// IF
	@Override public Variable visitIfStat(MusicinatorParser.IfStatContext ctx) { 
		// TODO 

		// create new scope child
		currentScope = currentScope.getNextChildScope();
		Variable v =  visitChildren(ctx); 

		// return to parent scope
		currentScope = currentScope.getParentScope();

		return v;
	}
	
	// EXPR (SIMPLE TYPES)
	@Override public Variable visitVarExpr(MusicinatorParser.VarExprContext ctx) {
		return visit(ctx.variable());
	}
	
	@Override public Variable visitPerExpr(MusicinatorParser.PerExprContext ctx) { 
		return visit(ctx.performance());
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
		// TODO
		// how to check whether first operand is Type.NUMBER
		
		return visitChildren(ctx);// return visit(ctx.e1); 
	}
	
	@Override public Variable visitAddSubExpr(MusicinatorParser.AddSubExprContext ctx) { 
		// TODO
		// how to check whether first operand is Type.NUMBER
		
		return visitChildren(ctx);// return visit(ctx.e1); 
	}
	
	// EXPR (ARRAYS)
	@Override public Variable visitBracketArray(MusicinatorParser.BracketArrayContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		gen.add("varname", varName);

		Variable v = visit(ctx.expr(0));
		gen.add("value", "[" + v.name());

		int exprsNum = ctx.expr().size();
		for (int i = 1; i < exprsNum-1; i++) {
			gen.add("value", "," + visit(ctx.expr(i)).name());
		}
		gen.add("value", "]");
		printer.println(gen.render());

		return new Variable(varName, Type.toArrayType(v.type()));
	}

	@Override public Variable visitAndArray(MusicinatorParser.AndArrayContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
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

	@Override public Variable visitNumRangeArray(MusicinatorParser.NumRangeArrayContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("range");
		gen.add("varname", varName);
		gen.add("first", visit(ctx.e1).name());
		gen.add("last", visit(ctx.e1).name());
		printer.println(gen.render());

		return new Variable(varName, Type.NUMBER_ARRAY);
	}
	
	// SEQUENCE
	@Override public Variable visitSeqNote(MusicinatorParser.SeqNoteContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		gen.add("varname", varName);
		gen.add("value", "[" + new Note(ctx.SOUND().getText()) + "]");
		printer.println(gen.render());

		return new Variable(varName, Type.SEQUENCE);
	}

	@Override public Variable visitSeqChord(MusicinatorParser.SeqChordContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		gen.add("varname", varName);
		gen.add("value", new Chord(ctx.CHORD().getText()));
		printer.println(gen.render());

		return new Variable(varName, Type.SEQUENCE);
	}

	@Override public Variable visitSeqList(MusicinatorParser.SeqListContext ctx) { 

		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("u_createseq");
		gen.add("varname", varName);
		gen.add("seqs", "[");

		int sequencesNum = ctx.sequence().size();
		for (int i = 0; i < sequencesNum-1; i++) {
			gen.add("seqs", visit(ctx.sequence(i)).name()+",");
		}
		gen.add("seqs", visit(ctx.sequence(sequencesNum-1)).name() + "]");
		printer.println(gen.render());

		return new Variable(varName, Type.SEQUENCE);
	}

	// PERFORMANCE
	@Override public Variable visitPerFromSeq(MusicinatorParser.PerFromSeqContext ctx) { 

		String varName = "_" + varNum++; // descartable variable

		// get sequence and tie it to an instrument
		ST gen = group.getInstanceOf("u_setinstrument");
		gen.add("varname", varName);
		String sequence = (ctx.seq == null)? 
							visit(ctx.sequence()).name() : visit(ctx.seq).name();
		gen.add("seq", sequence);
		gen.add("instrument", ctx.inst.getText());
		printer.println(gen.render());

		// create performance, with 'flag' values for start & repeat times
		gen = group.getInstanceOf("vardec");
		gen.add("varname", varName);
		gen.add("value", "[[-1], "+varName+", -1]");
		printer.println(gen.render());

		return new Variable(varName, Type.PERFORMANCE);

	}

	// NUMBER
	@Override public Variable visitNumInt(MusicinatorParser.NumIntContext ctx) { 

		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		
		gen.add("varname", varName);
		gen.add("value", ctx.INT().getText());

		printer.println(gen.render());

		return new Variable(varName, Type.NUMBER);
	}

	@Override public Variable visitNumDouble(MusicinatorParser.NumDoubleContext ctx) { 

		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		
		gen.add("varname", varName);
		gen.add("value", ctx.DOUBLE().getText());

		printer.println(gen.render());

		return new Variable(varName, Type.NUMBER);
	}

	@Override public Variable visitNumGetInt(MusicinatorParser.NumGetIntContext ctx) { 

		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("u_getint");
		
		gen.add("varname", varName);
		gen.add("str", ctx.STRING().getText());

		printer.println(gen.render());

		return new Variable(varName, Type.NUMBER);
	}

	@Override public Variable visitNumDuration(MusicinatorParser.NumDurationContext ctx) { 
		
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("u_duration");
		
		gen.add("varname", varName);
		gen.add("performance", visit(ctx.variable()).name());

		printer.println(gen.render());

		return new Variable(varName, Type.NUMBER);
	}

	// VARIABLE
	@Override public Variable visitVariable(MusicinatorParser.VariableContext ctx) {
	 	if (currentScope.isVariable(ctx.WORD().getText())) {
	 		// if variable is entry of array, return it as a simple type
			if (ctx.getText().contains("[")) {
				return new Variable(ctx.getText(),
					Type.toSimpleType(currentScope.getVariable(ctx.WORD().getText()).type()));
			}
			return currentScope.getVariable(ctx.WORD().getText());
	 	} else { // is instrument
	 		return new Variable(ctx.getText(), Type.INSTRUMENT);
	 	}
	}

	// @Override public Variable visitTypes(MusicinatorParser.TypesContext ctx) { 
	// 	return visitChildren(ctx); 
	// }

	// @Override public Variable visitCondition(MusicinatorParser.ConditionContext ctx) { 
	// 	return visitChildren(ctx); 
	// }

	private void error(String details, ParserRuleContext ctx) {
		System.err.println("ERROR! Line " + ctx.start.getLine() + ": " + details);
		System.exit(1);
	}
}