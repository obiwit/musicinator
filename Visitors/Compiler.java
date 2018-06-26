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

		//////////
		ST gen = group.getInstanceOf("createmidi");
		gen.add("varbpm", music.bpm());				//Initializing Midi
		gen.add("vartrack", maxtracks);
		//////////

		// TODO!! add instruments as arrays using vardecl

		printer.println(gen.render()+"\n");
		printer.println(group.getInstanceOf("body").render()+"\n"); // def addnotes()

		String s = visitChildren(ctx);
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
		gen.add("name", varName);
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
		gen.add("name", varName);
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
		gen.add("name", varName);
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

		// TODO fix using ST
		// ST gen = group.getInstanceOf("fornumbers");
		// gen.add("first", visit(ctx.e1));
		// gen.add("last", visit(ctx.e1));
		// printer.println(gen.render());

		printer.println(varName + " = " + "range("+visit(ctx.e1)+", "+visit(ctx.e1)+"+1)");

		return varName;
	}
	
	// SEQUENCE
	@Override public String visitSeqNote(MusicinatorParser.SeqNoteContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		gen.add("name", varName);
		gen.add("value", "[" + new Note(ctx.SOUND().getText()) + "]");
		printer.println(gen.render());

		return varName;
	}

	@Override public String visitSeqChord(MusicinatorParser.SeqChordContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		gen.add("name", varName);
		gen.add("value", new Chord(ctx.CHORD().getText()));
		printer.println(gen.render());

		return varName;
	}

	@Override public String visitSeqList(MusicinatorParser.SeqListContext ctx) { 

		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("u_extendseq");
		gen.add("varname", varName);

		int sequencesNum = ctx.sequence().size();

		// TODO use ST instead of semi-hardcoded strings
		for (int i = 0; i < sequencesNum-1; i++) {
			gen.add("original", "extendseq(");
			gen.add("toextend", visit(ctx.sequence(i))+"),");
		}
		gen.add("original", "[]");
		gen.add("toextend", visit(ctx.sequence(sequencesNum-1)));

		// extendSeq( ... extendSeq(extendSeq([], v1), v2) ... )

		// extendSeq(<first>, <last>)
		// <first> = extendSeq(
		// <last> = v1), 
		// ....
		// <first> = [], 
		// <last> = vlast

		printer.println(gen.render());

		return varName;
	}

	// PERFORMANCE
	@Override public String visitPerFromSeq(MusicinatorParser.PerFromSeqContext ctx) { 

		// [[-1], seq, -1]
		String varName = "_" + varNum++; // descartable variable

		// ST gen = group.getInstanceOf("vardec");
		// gen.add("name", varName);

		// TODO
		// get sequence
		// String sequence = visit()
		// alter sequence so it now knows instrument
		//...

		//gen.add("value", "[[-1], "+sequence+", -1]");

		return varName;

	}

	// NUMBER
	@Override public String visitNumInt(MusicinatorParser.NumIntContext ctx) { 

		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		
		gen.add("name", varName);
		gen.add("value", ctx.INT().getText());

		printer.println(gen.render());

		return varName;

		// return visitChildren(ctx);
	}

	@Override public String visitNumDouble(MusicinatorParser.NumDoubleContext ctx) { 

		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		
		gen.add("name", varName);
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
		return "_" + ctx.getText();
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