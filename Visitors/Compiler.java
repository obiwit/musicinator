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
	//private ST gen;

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
		// // get and check String of first child
		// Type firstType = visit(ctx.expr(0));
		// if(!Type.isSimpleType(firstType)) {
		// 	error("Invalid array type! Items must be of type number,"
		// 		  + " sequence, performance or instrument!", ctx);
		// }

		// // iterate over all other children and check same type
		// int sequencesNum = ctx.expr().size();

		// for (int i = 1; i < sequencesNum; i++) {
		// 	if (visit(ctx.expr(i)) != firstType) {
		// 		error("All items of array \"" + ctx.getText()
		// 			  + "\" must be of the same type!", ctx);
		// 	}
		// }

		return visitChildren(ctx);// return Type.toArrayType(firstType); 
	}
	// TODO!! Fix awful repetition
	@Override public String visitAndArray(MusicinatorParser.AndArrayContext ctx) { 
		// // get and check String of array
		// Type arrayType = Type.toSimpleType(visit(ctx.expr(0)));

		// // iterate over all other children and check same type
		// int sequencesNum = ctx.expr().size();

		// for (int i = 1; i < sequencesNum; i++) {

		// 	if (Type.toSimpleType(visit(ctx.expr(i))) != arrayType) {
		// 		error("All items of array \"" + ctx.getText()
		// 			  + "\" must be of the same type!", ctx);
		// 	}
		// }

		return visitChildren(ctx);// return Type.toArrayType(arrayType); 
	}

	@Override public String visitNumRangeArray(MusicinatorParser.NumRangeArrayContext ctx) { 
		// // guarantee exprs are Type.NUMBER
		// if (visit(ctx.e1) != Type.NUMBER)
		// 	error("Variable \"" + ctx.e1.getText() + "is not a number!", ctx);
		// if (visit(ctx.e2) != Type.NUMBER)
		// 	error("Variable \"" + ctx.e2.getText() + "is not a number!", ctx);

		return visitChildren(ctx);// return Type.NUMBER_ARRAY; 
	}
	
	// SEQUENCE
	@Override public String visitSeqNote(MusicinatorParser.SeqNoteContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		gen.add("name", varName);
		gen.add("value", new Note(ctx.SOUND().getText()));
		printer.println(gen.render());

		return varName;
	}

	@Override public String visitSeqChord(MusicinatorParser.SeqChordContext ctx) { 
		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		gen.add("name", varName);
		gen.add("value", new Note(ctx.CHORD().getText()));
		printer.println(gen.render());

		return varName;
	}

	@Override public String visitSeqList(MusicinatorParser.SeqListContext ctx) { 

		String varName = "_" + varNum++; // descartable variable

		ST gen = group.getInstanceOf("vardec");
		gen.add("name", varName);

		String varValue = "[]";
		
		int sequencesNum = ctx.sequence().size();
		for (int i = 0; i < sequencesNum; i++) {
			varValue += ".append(" + visit(ctx.sequence(i)) + ")";
		}

		gen.add("value", varValue);
		printer.println(gen.render());

		return varName;

		//return visitChildren(ctx);
	}

	// PERFORMANCE
	@Override public String visitPerFromSeq(MusicinatorParser.PerFromSeqContext ctx) { 

		// Type seqType = (ctx.seq == null) ? visit(ctx.sequence()) : visit(ctx.seq);
		// Type instType = visit(ctx.inst);

		// if (seqType != Type.SEQUENCE) 
		// 	error("Variable \"" + ctx.seq.getText() + "is not a sequence!", ctx);
		
		// if (instType != Type.INSTRUMENT)
		// 	error("Variable \"" + ctx.inst.getText() + "is not an instrument!", ctx);
		
		return visitChildren(ctx);// return Type.PERFORMANCE;

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