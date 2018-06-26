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
public class Compiler extends MusicinatorParserBaseVisitor<String> {
	Scope globalScope;
	Scope currentScope;
	Music music;

	final STGroup group;
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

	
	@Override public String visitMain(MusicinatorParser.MainContext ctx) {
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
		String s = visitChildren(ctx);

		// add instruction to export to destination file
		gen = group.getInstanceOf("exportfile");
		gen.add("name", "out.mid");
		printer.println("\n"+gen.render());

		printer.flush();
		return s;

	}
	
	@Override public String visitInstructions(MusicinatorParser.InstructionsContext ctx) {
printer.println("############################ LINE = "+ctx.start.getLine());		
		return visitChildren(ctx);
	}
	
	// ASSIGN
	@Override public String visitAssignment(MusicinatorParser.AssignmentContext ctx) { 

		String varName = ctx.WORD().getText();

		ST gen = group.getInstanceOf("vardec");
		gen.add("varname", varName);
		gen.add("value", visit(ctx.expr()));
		printer.println(gen.render());

		return varName;
	}
	
	// PLAY
	@Override public String visitSimplePlay(MusicinatorParser.SimplePlayContext ctx) { 
		return visitChildren(ctx);// return visitChildren(ctx); 
	}
	
	@Override public String visitTimedPlay(MusicinatorParser.TimedPlayContext ctx) { 
		return visitChildren(ctx);// return visitChildren(ctx); 
	}
	
	@Override public String visitLoopPlay(MusicinatorParser.LoopPlayContext ctx) { 
		return visitChildren(ctx);// return visitChildren(ctx); 
	}
	
	// FOR
	@Override public String visitForStat(MusicinatorParser.ForStatContext ctx) { 
		// TODO

		// create new scope child
		currentScope = currentScope.getNextChildScope();
		String t =  visitChildren(ctx); 

		// return to parent scope
		currentScope = currentScope.getParentScope();

		return t;
	}
	
	// IF
	@Override public String visitIfStat(MusicinatorParser.IfStatContext ctx) { 
		// TODO 

		// create new scope child
		currentScope = currentScope.getNextChildScope();
		String t =  visitChildren(ctx); 

		// return to parent scope
		currentScope = currentScope.getParentScope();

		return t;
	}
	
	// EXPR (SIMPLE TYPES)
	@Override public String visitVarExpr(MusicinatorParser.VarExprContext ctx) { 
		return visitChildren(ctx);// return visit(ctx.variable()); 
	}
	
	@Override public String visitPerExpr(MusicinatorParser.PerExprContext ctx) { 
		return visitChildren(ctx);// return visit(ctx.performance()); 
	}
	
	@Override public String visitSeqExpr(MusicinatorParser.SeqExprContext ctx) { 
		return visitChildren(ctx);// return visit(ctx.sequence()); 
	}
	
	@Override public String visitNumExpr(MusicinatorParser.NumExprContext ctx) { 
		return visitChildren(ctx);// return visit(ctx.number()); 
	}
	
	@Override public String visitParensExpr(MusicinatorParser.ParensExprContext ctx) { 
		return visitChildren(ctx);// return visit(ctx.expr()); 
	}
	
	@Override public String visitMulDivExpr(MusicinatorParser.MulDivExprContext ctx) { 
		// // guarantee second operand is Type.NUMBER
		// if (visit(ctx.e2) != Type.NUMBER)
		// 	error("Variable \"" + ctx.e2.getText() + "is not a number!", ctx);
		
		return visitChildren(ctx);// return visit(ctx.e1); 
	}
	
	@Override public String visitAddSubExpr(MusicinatorParser.AddSubExprContext ctx) { 
		// // guarantee second operand is Type.NUMBER
		// if (visit(ctx.e2) != Type.NUMBER)
		// 	error("Variable \"" + ctx.e2.getText() + "is not a number!", ctx);
		
		return visitChildren(ctx);// return visit(ctx.e1); 
	}
	
	// EXPR (ARRAYS)
	@Override public String visitBracketArray(MusicinatorParser.BracketArrayContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		gen.add("varname", varName);
		gen.add("value", "[");

		int exprsNum = ctx.expr().size();
		for (int i = 1; i < exprsNum-1; i++) {
			gen.add("value", visit(ctx.expr(i)) + ",");
		}
		gen.add("value", visit(ctx.expr(exprsNum-1)));
		gen.add("value", "]");

		printer.println(gen.render());

		return varName;
	}

	@Override public String visitAndArray(MusicinatorParser.AndArrayContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		gen.add("varname", varName);
		gen.add("value", "[");

		int exprsNum = ctx.expr().size();
		for (int i = 1; i < exprsNum-1; i++) {
			gen.add("value", visit(ctx.expr(i)) + ",");
		}
		gen.add("value", visit(ctx.expr(exprsNum-1)));
		gen.add("value", "]");

		printer.println(gen.render());

		return varName;
	}

	@Override public String visitNumRangeArray(MusicinatorParser.NumRangeArrayContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("range");
		gen.add("varname", varName);
		gen.add("first", visit(ctx.e1));
		gen.add("last", visit(ctx.e1));
		printer.println(gen.render());

		return varName;
	}
	
	// SEQUENCE
	@Override public String visitSeqNote(MusicinatorParser.SeqNoteContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		gen.add("varname", varName);
		gen.add("value", "[" + new Note(ctx.SOUND().getText()) + "]");
		printer.println(gen.render());

		return varName;
	}

	@Override public String visitSeqChord(MusicinatorParser.SeqChordContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		gen.add("varname", varName);
		gen.add("value", new Chord(ctx.CHORD().getText()));
		printer.println(gen.render());

		return varName;
	}

	@Override public String visitSeqList(MusicinatorParser.SeqListContext ctx) { 

		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("u_createseq");
		gen.add("varname", varName);
		gen.add("seqs", "[");

		int sequencesNum = ctx.sequence().size();
		for (int i = 0; i < sequencesNum-1; i++) {
			gen.add("seqs", visit(ctx.sequence(i))+",");
		}
		gen.add("seqs", visit(ctx.sequence(sequencesNum-1)) + "]");
		printer.println(gen.render());

		return varName;
	}

	// PERFORMANCE
	@Override public String visitPerFromSeq(MusicinatorParser.PerFromSeqContext ctx) { 

		String varName = "_" + varNum++; // descartable variable

		// get sequence and tie it to an instrument
		ST gen = group.getInstanceOf("u_setinstrument");
		gen.add("varname", varName);
		String sequence = (ctx.seq == null)? visit(ctx.sequence()) : visit(ctx.seq);
		gen.add("seq", sequence);
		gen.add("instrument", ctx.inst.getText());
		printer.println(gen.render());

		// create performance, with 'flag' values for start & repeat times
		gen = group.getInstanceOf("vardec");
		gen.add("varname", varName);
		gen.add("value", "[[-1], "+varName+", -1]");
		printer.println(gen.render());

		return varName;

	}

	// NUMBER
	@Override public String visitNumInt(MusicinatorParser.NumIntContext ctx) { 

		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		
		gen.add("varname", varName);
		gen.add("value", ctx.INT().getText());

		printer.println(gen.render());

		return varName;

		// return visitChildren(ctx);
	}

	@Override public String visitNumDouble(MusicinatorParser.NumDoubleContext ctx) { 

		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		
		gen.add("varname", varName);
		gen.add("value", ctx.DOUBLE().getText());

		printer.println(gen.render());

		return varName;

		// return visitChildren(ctx);
	}

	@Override public String visitNumGetInt(MusicinatorParser.NumGetIntContext ctx) { 

		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("u_getint");
		
		gen.add("varname", varName);
		gen.add("str", ctx.STRING().getText());

		printer.println(gen.render());

		return varName;

		// return visitChildren(ctx);
	}

	@Override public String visitNumDuration(MusicinatorParser.NumDurationContext ctx) { 
		
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("u_duration");
		
		gen.add("varname", varName);
		gen.add("performance", visit(ctx.variable()));

		printer.println(gen.render());

		return varName;

		//return visitChildren(ctx);// return Type.NUMBER; 
	}

	// VARIABLE
	@Override public String visitVariable(MusicinatorParser.VariableContext ctx) { 
		return ctx.getText();
	}

	// @Override public String visitTypes(MusicinatorParser.TypesContext ctx) { 
	// 	return visitChildren(ctx); 
	// }

	// @Override public String visitCondition(MusicinatorParser.ConditionContext ctx) { 
	// 	return visitChildren(ctx); 
	// }

	private void error(String details, ParserRuleContext ctx) {
		System.err.println("ERROR! Line " + ctx.start.getLine() + ": " + details);
		System.exit(1);
	}
}