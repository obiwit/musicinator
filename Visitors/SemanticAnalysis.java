// Generated from MusicinatorParser.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

import java.io.*;
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
	ErrorHandler errors;

	SemanticAnalysis(Music m) {
		music = m;
		globalScope = new Scope();
		currentScope = globalScope;
		try {
			errors = new ErrorHandler("log.txt");
		} catch (IOException e) {
			System.err.println("Could not create log file!");
		}
	}
	
	// ASSIGN
	@Override public Type visitDeclare(MusicinatorParser.DeclareContext ctx) { 
		// add new scope entry
		String varName = ctx.assignment().getText().split("=")[0].trim();

		if (currentScope.isVariable(varName)) {
			errors.error("Variable \"" + varName + "\" already exists!", ctx);
		} else if (music.isReservedWord(varName)) {
			errors.error("\"" + varName + "\" is a reserved word or an instrument name!", ctx);
		}

		// add an entry with variable's name, but no type yet
		currentScope.setVariable(varName, new Variable(varName, Type.NONE));

		// get variable value and check its type
		Type varType = visit(ctx.assignment());

		if (varType == Type.NONE) {
			// remove created scope entry
			currentScope.removeVariable(varName);
			errors.error("Illegal variable definition: " + ctx.getText(), ctx);
		}

		String declaredVarType = ctx.types().getText();
		if (ctx.OPEN_SB() != null) declaredVarType += "_array";

		// compare declared and written types
		if(!declaredVarType.equalsIgnoreCase(varType.name())) {
			// remove created scope entry
			currentScope.removeVariable(varName);
			errors.error(declaredVarType.replace("_", " ") + " \"" +  varName 
				  + "\" is not of type " + varType.name().toLowerCase().replace("_", " ")
				  + "!", ctx);
		}

		currentScope.setVariable(varName, new Variable(varName, varType));

		return Type.NONE; // used to prevent a declaration inside a declaration
	}
	@Override public Type visitAssign(MusicinatorParser.AssignContext ctx) { 
		// check variable already exists
		String varName = ctx.WORD().getText();

		if (!currentScope.isVariable(varName)) {
			errors.error("Variable \"" + varName + "\" doesn't exists!", ctx);
		}

		// check defined var is not an instrument
		Type varType = visit(ctx.expr());
		if (varType == Type.INSTRUMENT) {
			errors.error("Can only define instruments in aux file!", ctx);
		}

		return varType; 
	}
	
	// FOR
	@Override public Type visitForStat(MusicinatorParser.ForStatContext ctx) { 
		// create new scope child
		currentScope = currentScope.createChildScope();

		// get type of array
		Type arrayType = visit(ctx.expr());
		if (Type.isSimpleType(arrayType)) {
			errors.error("Variable \"" + ctx.expr().getText() + "\" is not an array!", ctx);
		}

		// add variable defined in the for declaration to current scope
		String varName = ctx.WORD().getText();
		currentScope.setVariable(varName, 
				new Variable(varName, Type.toSimpleType(arrayType)));

		// visit children
		Type t =  visitChildren(ctx); 

		// return to parent scope
		currentScope = currentScope.getParentScope();

		return t;
	}
	
	// IF
	@Override public Type visitIfStat(MusicinatorParser.IfStatContext ctx) { 
		// create new scope child
		currentScope = currentScope.createChildScope();
		Type t =  visitChildren(ctx); 

		// return to parent scope
		currentScope = currentScope.getParentScope();

		return t;
	}

	// PLAY
	@Override public Type visitSimplePlay(MusicinatorParser.SimplePlayContext ctx) {
		Type perType = visit(ctx.per);
		if (perType != Type.PERFORMANCE && perType != Type.PERFORMANCE_ARRAY) {
			errors.error("Variable \"" + ctx.per.getText()
				  + "\" is not a performance nor a performance array!", ctx);
		}
		return perType;
	}

	@Override public Type visitTimedPlay(MusicinatorParser.TimedPlayContext ctx) {
		Type perType = visit(ctx.play());
		Type timeType = visit(ctx.expr());
		// TODO sure we want this error?
		if (timeType == Type.NUMBER_ARRAY) {
			if (perType == Type.PERFORMANCE_ARRAY) {
				errors.error("Invalid play comand! Play doesn't support both performance "
					  + "and number arrays simultaneously!", ctx);
			}
		} else if (timeType != Type.NUMBER) { // TODO don't forget (timeType != Type.NUMBER_ARRAY && ... if you remove above
			errors.error("Variable \"" + ctx.expr().getText()
				  + "\" is not a number nor a number array!", ctx);
		}

		return perType;
	}
	@Override public Type visitLoopPlay(MusicinatorParser.LoopPlayContext ctx) {
		Type perType = visit(ctx.expr());
		if (perType != Type.PERFORMANCE && perType != Type.PERFORMANCE_ARRAY) {
			errors.error("Variable \"" + ctx.expr().getText()
				  + "\" is not a performance nor a performance array!", ctx);
		}
		return perType;
	}
	
	// EXPR (SIMPLE TYPES)
	@Override public Type visitVarExpr(MusicinatorParser.VarExprContext ctx) { 
		return visit(ctx.variable()); 
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
		// guarantee first operand is Type.NUMBER, Type.SEQUENCE or Type.PERFORMANCE
		Type e1Type = visit(ctx.e1);
		if (e1Type != Type.NUMBER && e1Type != Type.SEQUENCE && e1Type != Type.PERFORMANCE)
			errors.error("Variable \"" + ctx.e1.getText() + "\" is not a number, sequence"
				  +" or performance!", ctx);

		// guarantee second operand is Type.NUMBER
		if (visit(ctx.e2) != Type.NUMBER)
			errors.error("Variable \"" + ctx.e2.getText() + "\" is not a number!", ctx);
		
		return visit(ctx.e1); 
	}
	
	@Override public Type visitAddSubExpr(MusicinatorParser.AddSubExprContext ctx) { 
		// guarantee first operand is Type.NUMBER, Type.SEQUENCE or Type.PERFORMANCE
		Type e1Type = visit(ctx.e1);
		if (e1Type != Type.NUMBER && e1Type != Type.SEQUENCE && e1Type != Type.PERFORMANCE)
			errors.error("Variable \"" + ctx.e1.getText() + "\" is not a number, sequence"
				  +" or performance!", ctx);

		// guarantee second operand is Type.NUMBER
		if (visit(ctx.e2) != Type.NUMBER)
			errors.error("Variable \"" + ctx.e2.getText() + "\" is not a number!", ctx);
		
		return visit(ctx.e1); 
	}
	
	// EXPR (ARRAYS)
	@Override public Type visitBracketArray(MusicinatorParser.BracketArrayContext ctx) { 
		// get and check Type of first child
		Type firstType = visit(ctx.expr(0));
		if(!Type.isSimpleType(firstType)) {
			errors.error("Invalid array type! Items must be of type number,"
				  + " sequence, performance or instrument!", ctx);
		}

		// iterate over all other children and check same type
		int exprsNum = ctx.expr().size();

		for (int i = 1; i < exprsNum; i++) {
			if (visit(ctx.expr(i)) != firstType) {
				errors.error("All items of array \"" + ctx.getText()
					  + "\" must be of the same type!", ctx);
			}
		}

		return Type.toArrayType(firstType); 
	}

	@Override public Type visitAndArray(MusicinatorParser.AndArrayContext ctx) { 
		// get and check Type of array
		Type arrayType = Type.toSimpleType(visit(ctx.expr(0)));

		// iterate over all other children and check same type
		int exprsNum = ctx.expr().size();

		for (int i = 1; i < exprsNum; i++) {
			if (Type.toSimpleType(visit(ctx.expr(i))) != arrayType) {
				errors.error("All items of array \"" + ctx.getText()
					  + "\" must be of the same type!", ctx);
			}
		}

		return Type.toArrayType(arrayType); 
	}

	@Override public Type visitNumRangeArray(MusicinatorParser.NumRangeArrayContext ctx) { 
		// guarantee exprs are Type.NUMBER
		if (visit(ctx.e1) != Type.NUMBER)
			errors.error("Variable \"" + ctx.e1.getText() + "\" is not a number!", ctx);
		if (visit(ctx.e2) != Type.NUMBER)
			errors.error("Variable \"" + ctx.e2.getText() + "\" is not a number!", ctx);

		return Type.NUMBER_ARRAY; 
	}
	
	// SEQUENCE
	@Override public Type visitSeqNote(MusicinatorParser.SeqNoteContext ctx) { 
		return Type.NOTE; 
	}

	@Override public Type visitSeqChord(MusicinatorParser.SeqChordContext ctx) { 
		return Type.NOTE; 
	}

	@Override public Type visitSeqList(MusicinatorParser.SeqListContext ctx) { 
		// iterate over all children, and confirm they are all Type.SEQUENCE
		int sequencesNum = ctx.expr().size();

		for (int i = 0; i < sequencesNum; i++) {
			Type exprType = visit(ctx.expr(i));
			if (exprType != Type.SEQUENCE && exprType != Type.NOTE)
				errors.error("Variable \"" + ctx.expr(i) + "\" is not a sequence"
							 + " nor a note!", ctx);
		}

		return Type.SEQUENCE; 
	}

	// PERFORMANCE
	@Override public Type visitPerformance(MusicinatorParser.PerformanceContext ctx) { 

		Type seqType = visit(ctx.expr());
		Type instType = visit(ctx.variable());

		if (seqType == Type.SEQUENCE) {
			if (instType == Type.INSTRUMENT) {
				return Type.PERFORMANCE;
			} else if (instType == Type.INSTRUMENT_ARRAY) {
				return Type.PERFORMANCE_ARRAY;
			}
			
		} else if (seqType == Type.SEQUENCE_ARRAY) {
			if (instType != Type.INSTRUMENT) {
				errors.error("Variable \"" + ctx.variable().getText() 
						 + "\" is not an instrument!", ctx);
			}
			return Type.PERFORMANCE_ARRAY;
		}

		errors.error("Variable \"" + ctx.expr().getText() 
						 + "\" is not a sequence nor a sequence array!", ctx);

		// after flagging error, pass valid type to detect further errors
		return Type.PERFORMANCE; 

	}

	// NUMBER
	@Override public Type visitNumInt(MusicinatorParser.NumIntContext ctx) { 
		return Type.NUMBER; 
	}

	@Override public Type visitNumDouble(MusicinatorParser.NumDoubleContext ctx) { 
		return Type.NUMBER; 
	}

	@Override public Type visitNumGetInt(MusicinatorParser.NumGetIntContext ctx) { 
		return Type.NUMBER; 
	}

	@Override public Type visitNumDuration(MusicinatorParser.NumDurationContext ctx) { 
		// verify variable is single sequence or performance
		Type varType = visit(ctx.variable());

		if (varType != Type.SEQUENCE && varType != Type.PERFORMANCE) {
			errors.error("Variable \"" + ctx.variable().getText()
				  + "\" is neither a sequence nor a performance!", ctx);
		} 

		return Type.NUMBER; 
	}

	// VARIABLE
	@Override public Type visitVariable(MusicinatorParser.VariableContext ctx) { 
		String varName = ctx.WORD().getText();
		Type varType = Type.INSTRUMENT;

		// get variable type
		if (currentScope.isVariable(varName)) {
			varType = currentScope.getVariable(varName).type();
		} else if (music.isNoteName(varName)) {
			varType = Type.SEQUENCE;
		} else if(!music.isInstrument(varName)) {
			errors.error("Variable \"" + varName + "\" is not defined!", ctx);
		}

		if (ctx.OPEN_SB() != null) {

			if (Type.isSimpleType(varType)) {
				errors.error("Variable \"" + varName + "\" is not an array!", ctx);
			}

			int indexNum = ctx.expr().size();
			for (int i = 0; i < indexNum; i++) {
				if (visit(ctx.expr(i)) != Type.NUMBER) {
					errors.error("Array index must be a number and variable \"" 
						  + ctx.expr(i).getText() + "\" is not a number!", ctx);
				}
			}
			// if indexing array without colon, then variable is no longer an array
			if (ctx.COLON() == null) {
				return Type.toSimpleType(varType); 
			} 
		}

		return varType; 
	}


	@Override public Type visitCondition(MusicinatorParser.ConditionContext ctx) { 
		
		if (ctx.e1 == null) {
			return visit(ctx.condition());
		}
		if(visit(ctx.e1) != Type.NUMBER || visit(ctx.e2) != Type.NUMBER) {
			errors.error("Condition operands must be numbers!", ctx);
		}

		return Type.BOOL;
	}

}