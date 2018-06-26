// Generated from MusicinatorParser.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.stringtemplate.v4.*;

/**
 * This class provides an empty implementation of {@link MusicinatorParserVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class Compiler extends MusicinatorParserBaseVisitor<ST> {
	Scope globalScope;
	Scope currentScope;
	Music music;

	Compiler(Music m, Scope s) {
		music = m;
		globalScope = s;
		currentScope = globalScope;
	}

	
	@Override public ST visitMain(MusicinatorParser.MainContext ctx) {
		System.out.println("Started Compilation"); 
		return visitChildren(ctx);// return visitChildren(ctx); 
	}
	
	@Override public ST visitInstructions(MusicinatorParser.InstructionsContext ctx) {
		return visitChildren(ctx);// return visitChildren(ctx); 
	}
	
	// ASSIGN
	@Override public ST visitAssignment(MusicinatorParser.AssignmentContext ctx) { 
		return visitChildren(ctx);
	}
	
	// PLAY
	@Override public ST visitSimplePlay(MusicinatorParser.SimplePlayContext ctx) { 
		return visitChildren(ctx);// return visitChildren(ctx); 
	}
	
	@Override public ST visitTimedPlay(MusicinatorParser.TimedPlayContext ctx) { 
		return visitChildren(ctx);// return visitChildren(ctx); 
	}
	
	@Override public ST visitLoopPlay(MusicinatorParser.LoopPlayContext ctx) { 
		return visitChildren(ctx);// return visitChildren(ctx); 
	}
	
	// FOR
	@Override public ST visitForStat(MusicinatorParser.ForStatContext ctx) { 
		// TODO

		// create new scope child
		currentScope = currentScope.getNextChildScope();
		ST t =  visitChildren(ctx); 

		// return to parent scope
		currentScope = currentScope.getParentScope();

		return t;
	}
	
	// IF
	@Override public ST visitIfStat(MusicinatorParser.IfStatContext ctx) { 
		// TODO 

		// create new scope child
		currentScope = currentScope.getNextChildScope();
		ST t =  visitChildren(ctx); 

		// return to parent scope
		currentScope = currentScope.getParentScope();

		return t;
	}
	
	// EXPR (SIMPLE TYPES)
	@Override public ST visitVarExpr(MusicinatorParser.VarExprContext ctx) { 
		return visitChildren(ctx);// return visit(ctx.variable()); 
	}
	
	@Override public ST visitPerExpr(MusicinatorParser.PerExprContext ctx) { 
		return visitChildren(ctx);// return visit(ctx.performance()); 
	}
	
	@Override public ST visitSeqExpr(MusicinatorParser.SeqExprContext ctx) { 
		return visitChildren(ctx);// return visit(ctx.sequence()); 
	}
	
	@Override public ST visitNumExpr(MusicinatorParser.NumExprContext ctx) { 
		return visitChildren(ctx);// return visit(ctx.number()); 
	}
	
	@Override public ST visitParensExpr(MusicinatorParser.ParensExprContext ctx) { 
		return visitChildren(ctx);// return visit(ctx.expr()); 
	}
	
	@Override public ST visitMulDivExpr(MusicinatorParser.MulDivExprContext ctx) { 
		// // guarantee second operand is Type.NUMBER
		// if (visit(ctx.e2) != Type.NUMBER)
		// 	error("Variable \"" + ctx.e2.getText() + "is not a number!", ctx);
		
		return visitChildren(ctx);// return visit(ctx.e1); 
	}
	
	@Override public ST visitAddSubExpr(MusicinatorParser.AddSubExprContext ctx) { 
		// // guarantee second operand is Type.NUMBER
		// if (visit(ctx.e2) != Type.NUMBER)
		// 	error("Variable \"" + ctx.e2.getText() + "is not a number!", ctx);
		
		return visitChildren(ctx);// return visit(ctx.e1); 
	}
	
	// EXPR (ARRAYS)
	@Override public ST visitBracketArray(MusicinatorParser.BracketArrayContext ctx) { 
		// // get and check ST of first child
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
	@Override public ST visitAndArray(MusicinatorParser.AndArrayContext ctx) { 
		// // get and check ST of array
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

	@Override public ST visitNumRangeArray(MusicinatorParser.NumRangeArrayContext ctx) { 
		// // guarantee exprs are Type.NUMBER
		// if (visit(ctx.e1) != Type.NUMBER)
		// 	error("Variable \"" + ctx.e1.getText() + "is not a number!", ctx);
		// if (visit(ctx.e2) != Type.NUMBER)
		// 	error("Variable \"" + ctx.e2.getText() + "is not a number!", ctx);

		return visitChildren(ctx);// return Type.NUMBER_ARRAY; 
	}
	
	// SEQUENCE
	@Override public ST visitSeqNote(MusicinatorParser.SeqNoteContext ctx) { 
		return visitChildren(ctx);// return Type.SEQUENCE; 
	}

	@Override public ST visitSeqChord(MusicinatorParser.SeqChordContext ctx) { 
		return visitChildren(ctx);// return Type.SEQUENCE; 
	}

	@Override public ST visitSeqList(MusicinatorParser.SeqListContext ctx) { 
		// iterate over all children, and confirm they are all Type.SEQUENCE
		// int sequencesNum = ctx.sequence().size();

		// for (int i = 0; i < sequencesNum; i++) {
		// 	if (visit(ctx.sequence(i)) != Type.SEQUENCE)
		// 		error("Variable \"" + ctx.sequence(i) + "\" is not a sequence!", ctx);
		// }

		return visitChildren(ctx);// return Type.SEQUENCE; 
	}

	// PERFORMANCE
	@Override public ST visitPerFromSeq(MusicinatorParser.PerFromSeqContext ctx) { 

		// Type seqType = (ctx.seq == null) ? visit(ctx.sequence()) : visit(ctx.seq);
		// Type instType = visit(ctx.inst);

		// if (seqType != Type.SEQUENCE) 
		// 	error("Variable \"" + ctx.seq.getText() + "is not a sequence!", ctx);
		
		// if (instType != Type.INSTRUMENT)
		// 	error("Variable \"" + ctx.inst.getText() + "is not an instrument!", ctx);
		
		return visitChildren(ctx);// return Type.PERFORMANCE;

	}

	// NUMBER
	@Override public ST visitNumInt(MusicinatorParser.NumIntContext ctx) { 
		return visitChildren(ctx);// return Type.NUMBER; 
	}

	@Override public ST visitNumDouble(MusicinatorParser.NumDoubleContext ctx) { 
		return visitChildren(ctx);// return Type.NUMBER; 
	}

	@Override public ST visitNumGetInt(MusicinatorParser.NumGetIntContext ctx) { 
		return visitChildren(ctx);// return Type.NUMBER; 
	}

	@Override public ST visitNumDuration(MusicinatorParser.NumDurationContext ctx) { 
		// // verify variable is single sequence or performance
		// Type varType = visit(ctx.variable());

		// if (varType != Type.SEQUENCE && varType != Type.PERFORMANCE) {
		// 	error("Variable \"" + ctx.variable().getText()
		// 		  + "\" is neither a sequence nor a performance!", ctx);
		// } 

		return visitChildren(ctx);// return Type.NUMBER; 
	}

	// VARIABLE
	@Override public ST visitVariable(MusicinatorParser.VariableContext ctx) { 
		// String varName = ctx.WORD().getText();
		// Type varType = Type.INSTRUMENT;

		// // get variable type
		// if (currentScope.isVariable(varName)) {
		// 	varType = currentScope.getVariable(varName).type();

		// } else if (!music.isInstrument(varName)) {
		// 	error("Variable \"" + varName + "\" is not defined!", ctx);
		// }

		// if (ctx.OPEN_SB() != null) {

		// 	if (Type.isSimpleType(varType)) {
		// 		error("Variable \"" + varName + "\" is not an array!", ctx);
		// 	}
		// 	return Type.toSimpleType(varType); 
		// }

		// //System.out.println("["+ctx.start.getLine()+"] Read variable \""+varName+"\" of type "+ varType);

		return visitChildren(ctx);// return varType; 
	}

	// @Override public ST visitTypes(MusicinatorParser.TypesContext ctx) { 
	// 	return visitChildren(ctx); 
	// }

	// @Override public ST visitCondition(MusicinatorParser.ConditionContext ctx) { 
	// 	return visitChildren(ctx); 
	// }

	private void error(String details, ParserRuleContext ctx) {
		System.err.println("ERROR! Line " + ctx.start.getLine() + ": " + details);
		System.exit(1);
	}
}