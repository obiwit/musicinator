// Generated from MusicinatorParser.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
//import org.stringtemplate.v4.*;

import java.util.*;

/**
 * This class provides an empty implementation of {@link MusicinatorParserVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 */
public class SemanticAnalysis extends MusicinatorParserBaseVisitor<Type> {
	Scope globalScope;
	Scope currentScope;
	Music music;

	SemanticAnalysis(Music m) {
		music = m;
		globalScope = new Scope();
		currentScope = globalScope;
	}

	
	@Override public Type visitMain(MusicinatorParser.MainContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public Type visitInstructions(MusicinatorParser.InstructionsContext ctx) {
		//System.out.println("["+ctx.start.getLine()+"]"); 
		return visitChildren(ctx); 
	}
	
	// ASSIGN
	@Override public Type visitAssignment(MusicinatorParser.AssignmentContext ctx) { 
		// check variable doesn't already exist
		String varName = ctx.WORD().getText();

		if (currentScope.isVariable(varName)) {
			error("Variable \"" + varName + "\" already exists!", ctx);
		} else if (music.isReservedWord(varName)) {
			error("\"" + varName + "\" is a reserved word!", ctx);
		}

		// add new scope entry
		Type varType = visit(ctx.expr());

		String declaredVarType = ctx.types().getText();
		if (ctx.OPEN_SB() != null) declaredVarType += "_array";

		// compare declared and written types
		if(!declaredVarType.equals( varType.name().toLowerCase() )) {
			error(declaredVarType.replace("_", " ") + " \"" +  ctx.expr().getText() 
				  + "\" is not of type " + varType.name().toLowerCase().replace("_", " ")
				  + "!", ctx);
		}

		// check defined var is not an instrument
		if (varType == Type.INSTRUMENT) {
			error("Can only define an instrument in aux file!", ctx);
		}

		System.out.println("["+ctx.start.getLine()+"] Set variable \""+varName+"\" of type "+varType.name());

		currentScope.setVariable(varName, new Variable(varName, varType, ctx));
		return varType; 
	}
	
	// @Override public Type visitArrayAssign(MusicinatorParser.ArrayAssignContext ctx) { 
	// 	// TODO new scope entry
	// 	return visitChildren(ctx); 
	// }
	
	// PLAY
	@Override public Type visitSimplePlay(MusicinatorParser.SimplePlayContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public Type visitTimedPlay(MusicinatorParser.TimedPlayContext ctx) { 
		return visitChildren(ctx); 
	}
	
	@Override public Type visitLoopPlay(MusicinatorParser.LoopPlayContext ctx) { 
		return visitChildren(ctx); 
	}
	
	// FOR
	@Override public Type visitForStat(MusicinatorParser.ForStatContext ctx) { 
		// TODO

		// create new scope child
		currentScope = currentScope.createChildScope();
		Type t =  visitChildren(ctx); 

		// return to parent scope
		currentScope = currentScope.getParentScope();

		return t;
	}
	
	// IF
	@Override public Type visitIfStat(MusicinatorParser.IfStatContext ctx) { 
		// TODO 

		// create new scope child
		currentScope = currentScope.createChildScope();
		Type t =  visitChildren(ctx); 

		// return to parent scope
		currentScope = currentScope.getParentScope();

		return t;
	}
	
	// EXPR (SIMPLE TYPES)
	@Override public Type visitVarExpr(MusicinatorParser.VarExprContext ctx) { 
		return visit(ctx.variable()); 
	}
	
	@Override public Type visitPerExpr(MusicinatorParser.PerExprContext ctx) { 
		return visit(ctx.performance()); 
	}
	
	@Override public Type visitSeqExpr(MusicinatorParser.SeqExprContext ctx) { 
		return visit(ctx.sequence()); 
	}
	
	@Override public Type visitNumExpr(MusicinatorParser.NumExprContext ctx) { 
		return visit(ctx.number()); 
	}
	
	@Override public Type visitParensExpr(MusicinatorParser.ParensExprContext ctx) { 
		return visit(ctx.expr()); 
	}
	
	@Override public Type visitMulDivExpr(MusicinatorParser.MulDivExprContext ctx) { 
		// guarantee second operand is Type.NUMBER
		if (visit(ctx.e2) != Type.NUMBER)
			error("Variable \"" + ctx.e2.getText() + "is not a number!", ctx);
		
		return visit(ctx.e1); 
	}
	
	@Override public Type visitAddSubExpr(MusicinatorParser.AddSubExprContext ctx) { 
		// guarantee second operand is Type.NUMBER
		if (visit(ctx.e2) != Type.NUMBER)
			error("Variable \"" + ctx.e2.getText() + "is not a number!", ctx);
		
		return visit(ctx.e1); 
	}
	
	// EXPR (ARRAYS)
	@Override public Type visitBracketArray(MusicinatorParser.BracketArrayContext ctx) { 
		// get and check Type of first child
		Type firstType = visit(ctx.expr(0));
		if(!Type.isSimpleType(firstType)) {
			error("Invalid array type! Items must be of type number,"
				  + " sequence, performance or instrument!", ctx);
		}

		// iterate over all other children and check same type
		int sequencesNum = ctx.expr().size();

		for (int i = 1; i < sequencesNum; i++) {
			if (visit(ctx.expr(i)) != firstType) {
				error("All items of array \"" + ctx.getText()
					  + "\" must be of the same type!", ctx);
			}
		}

		return Type.toArrayType(firstType); 
	}
	// TODO!! Fix awful repetition
	@Override public Type visitAndArray(MusicinatorParser.AndArrayContext ctx) { 
		// get and check Type of array
		Type arrayType = Type.toSimpleType(visit(ctx.expr(0)));

		// iterate over all other children and check same type
		int sequencesNum = ctx.expr().size();

		for (int i = 1; i < sequencesNum; i++) {

			if (Type.toSimpleType(visit(ctx.expr(i))) != arrayType) {
				error("All items of array \"" + ctx.getText()
					  + "\" must be of the same type!", ctx);
			}
		}

		return Type.toArrayType(arrayType); 
	}

	@Override public Type visitNumRangeArray(MusicinatorParser.NumRangeArrayContext ctx) { 
		// guarantee exprs are Type.NUMBER
		if (visit(ctx.e1) != Type.NUMBER)
			error("Variable \"" + ctx.e1.getText() + "is not a number!", ctx);
		if (visit(ctx.e2) != Type.NUMBER)
			error("Variable \"" + ctx.e2.getText() + "is not a number!", ctx);

		return Type.NUMBER_ARRAY; 
	}
	
	// SEQUENCE
	@Override public Type visitSeqNote(MusicinatorParser.SeqNoteContext ctx) { 
		return Type.SEQUENCE; 
	}

	@Override public Type visitSeqChord(MusicinatorParser.SeqChordContext ctx) { 
		return Type.SEQUENCE; 
	}

	// @Override public Type visitSeqSpeedMod(MusicinatorParser.SeqSpeedModContext ctx) { 
	// 	// guarantee expr is Type.NUMBER
	// 	if (visit(ctx.expr()) != Type.NUMBER)
	// 		error("Variable \"" + ctx.expr().getText() + "is not a number!", ctx);

	// 	return visit(ctx.sequence());  
	// }

	// @Override public Type visitSeqPitchMod(MusicinatorParser.SeqPitchModContext ctx) {
	// 	// guarantee expr is Type.NUMBER
	// 	if (visit(ctx.expr()) != Type.NUMBER)
	// 		error("Variable \"" + ctx.expr().getText() + "is not a number!", ctx);

	// 	return visit(ctx.sequence()); 
	// }

	@Override public Type visitSeqList(MusicinatorParser.SeqListContext ctx) { 
		// iterate over all children, and confirm they are all Type.SEQUENCE
		int sequencesNum = ctx.sequence().size();

		for (int i = 0; i < sequencesNum; i++) {
			if (visit(ctx.sequence(i)) != Type.SEQUENCE)
				error("Variable \"" + ctx.sequence(i) + "\" is not a sequence!", ctx);
		}

		return Type.SEQUENCE; 
	}

	// PERFORMANCE
	@Override public Type visitPerFromSeq(MusicinatorParser.PerFromSeqContext ctx) { 

		Type seqType = (ctx.seq == null) ? visit(ctx.sequence()) : visit(ctx.seq);
		Type instType = visit(ctx.inst);

		if (seqType != Type.SEQUENCE) 
			error("Variable \"" + ctx.seq.getText() + "is not a sequence!", ctx);
		
		if (instType != Type.INSTRUMENT)
			error("Variable \"" + ctx.inst.getText() + "is not an instrument!", ctx);
		
		return Type.PERFORMANCE;

	}

	// @Override public Type visitPerSpeedMod(MusicinatorParser.PerSpeedModContext ctx) {
	// 	// guarantee expr is Type.NUMBER
	// 	if (visit(ctx.expr()) != Type.NUMBER)
	// 		error("Variable \"" + ctx.expr().getText() + "is not a number!", ctx);

	// 	return visit(ctx.performance()); 
	// }

	// @Override public Type visitPerPitchMod(MusicinatorParser.PerPitchModContext ctx) { 
	// 	// guarantee expr is Type.NUMBER
	// 	if (visit(ctx.expr()) != Type.NUMBER)
	// 		error("Variable \"" + ctx.expr().getText() + "is not a number!", ctx);

	// 	return visit(ctx.performance()); 
	// }

	// NUMBER
	@Override public Type visitNumInt(MusicinatorParser.NumIntContext ctx) { 
		return Type.NUMBER; 
	}

	@Override public Type visitNumDouble(MusicinatorParser.NumDoubleContext ctx) { 
		return Type.NUMBER; 
	}

	// @Override public Type visitNumMulDiv(MusicinatorParser.NumMulDivContext ctx) { 
	// 	return Type.NUMBER; 
	// }

	// @Override public Type visitNumAddSub(MusicinatorParser.NumAddSubContext ctx) { 
	// 	return Type.NUMBER; 
	// }

	@Override public Type visitNumGetInt(MusicinatorParser.NumGetIntContext ctx) { 
		return Type.NUMBER; 
	}

	@Override public Type visitNumDuration(MusicinatorParser.NumDurationContext ctx) { 
		// verify variable is single sequence or performance
		Type varType = visit(ctx.variable());

		if (varType != Type.SEQUENCE && varType != Type.PERFORMANCE) {
			error("Variable \"" + ctx.variable().getText()
				  + "\" is neither a sequence nor a performance!", ctx);
		} 

		return Type.NUMBER; 
	}

	// @Override public Type visitNumVar(MusicinatorParser.NumVarContext ctx) { 
	// 	if (visit(ctx.variable()) != Type.NUMBER) 
	// 		error("Variable \"" + ctx.variable().getText() + "\" is not a number!", ctx);

	// 	return Type.NUMBER; 
	// }

	// VARIABLE
	@Override public Type visitVariable(MusicinatorParser.VariableContext ctx) { 
		String varName = ctx.WORD().getText();
		Type varType = Type.INSTRUMENT;

		// get variable type
		if (currentScope.isVariable(varName)) {
			varType = currentScope.getVariable(varName).type();

		} else if (!music.isInstrument(varName)) {
			error("Variable \"" + varName + "\" is not defined!", ctx);
		}

		if (ctx.OPEN_SB() != null) {

			if (Type.isSimpleType(varType)) {
				error("Variable \"" + varName + "\" is not an array!", ctx);
			}
			return Type.toSimpleType(varType); 
		}

		//System.out.println("["+ctx.start.getLine()+"] Read variable \""+varName+"\" of type "+ varType);

		return varType; 
	}

	// @Override public Type visitTypes(MusicinatorParser.TypesContext ctx) { 
	// 	return visitChildren(ctx); 
	// }

	// @Override public Type visitArrayTypes(MusicinatorParser.ArrayTypesContext ctx) { 
	// 	return visitChildren(ctx); 
	// }

	// @Override public Type visitCondition(MusicinatorParser.ConditionContext ctx) { 
	// 	return visitChildren(ctx); 
	// }

	private void error(String details, ParserRuleContext ctx) {
		System.err.println("ERROR! Line " + ctx.start.getLine() + ": " + details);
		System.exit(1);
	}
}