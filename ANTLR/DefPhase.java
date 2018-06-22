// Generated from MusicinatorParser.g4 by ANTLR 4.7.1

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import org.antlr.v4.runtime.tree.ParseTreeProperty;
import java.util.*;
import java.lang.reflect.*;

/**
 * DefPhase annotates the tree with the available variables in each node.
 *
 */

public class DefPhase extends MusicinatorParserBaseListener {
	ParseTreeProperty<Map<String, Object>> scopes = new ParseTreeProperty<>();
	ParseTreeProperty<Object> values = new ParseTreeProperty<>();
	Map<String, Integer> noteMap;

	public DefPhase(Map<String, Integer> noteMap) {
		// noteMap contains defined non-standard notes and their standard conterparts
		this.noteMap = noteMap;
	}
	
	
	@Override public void enterMain(MusicinatorParser.MainContext ctx) {
		scopes.put(ctx, new HashMap<String, Object>());
	}
	// @Override public void exitMain(MusicinatorParser.MainContext ctx) {	}
	
	// @Override public void enterInstructions(MusicinatorParser.InstructionsContext ctx) { }
	// @Override public void exitInstructions(MusicinatorParser.InstructionsContext ctx) { }
	
	// @Override public void enterVarAssign(MusicinatorParser.VarAssignContext ctx) { }
	@Override public void exitVarAssign(MusicinatorParser.VarAssignContext ctx) {
		//System.out.println("Var Assigned: "+ ctx.WORD() + " of type " + ctx.types().getText());

		// add variable to the scope
		Map<String, Object> currentScope = scopes.get(ctx.getParent().getParent());
		currentScope.put(ctx.WORD().getText(), values.get(ctx.expr()));
		scopes.put(ctx.getParent().getParent(), currentScope);
	}
	
	// @Override public void enterArrayAssign(MusicinatorParser.ArrayAssignContext ctx) { }
	@Override public void exitArrayAssign(MusicinatorParser.ArrayAssignContext ctx) {
		//System.out.println("Array Assigned: "+ ctx.WORD() + " of type " + ctx.arrayTypes().getText());	

		// add variable to the scope
		Map<String, Object> currentScope = scopes.get(ctx.getParent().getParent());
		currentScope.put(ctx.WORD().getText(), values.get(ctx.arrayExpr()));
		scopes.put(ctx.getParent().getParent(), currentScope);
	}
	
	
	// @Override public void enterPlay(MusicinatorParser.PlayContext ctx) { }
	// @Override public void exitPlay(MusicinatorParser.PlayContext ctx) { }
	
	@Override public void enterForStat(MusicinatorParser.ForStatContext ctx) {
		scopes.put(ctx, new HashMap<String, Object>());
	}
	//@Override public void exitForStat(MusicinatorParser.ForStatContext ctx) { }
	
	@Override public void enterIfStat(MusicinatorParser.IfStatContext ctx) {
		scopes.put(ctx, new HashMap<String, Object>());
	}
	//@Override public void exitIfStat(MusicinatorParser.IfStatContext ctx) { }
	
	// @Override public void enterArrayExpr(MusicinatorParser.ArrayExprContext ctx) { }
	@Override public void exitArrayExpr(MusicinatorParser.ArrayExprContext ctx) {
		if(ctx.list() != null) {
			values.put(ctx, values.get(ctx.list()));
		} else if (ctx.expr(0) != null) {
			// TODO
			//values.put(ctx, buildArray(type, size, iter));
		} else {
			values.put(ctx, (Object)new Object[0]);
		}
	}
	
	// @Override public void enterList(MusicinatorParser.ListContext ctx) { }
	@Override public void exitList(MusicinatorParser.ListContext ctx) {
		// get type of array
		MusicinatorParser.ArrayAssignContext assignCtx = (MusicinatorParser.ArrayAssignContext)ctx.getParent().getParent().getRuleContext();
		String type = assignCtx.arrayTypes().getText();
		type = (type != "number") ? type.substring(0, 1).toUpperCase() + type.substring(1) : "Double";
		System.out.println("Array Assigned: "+type);

		// get size of array
		int size = ctx.expr().size();

		// build array
		try {
			// TODO add package names
			Object array = Array.newInstance(Class.forName(type), size);
			for (int i = 0; i < size; i++) {

			}
		} catch(Exception e) {

		}
	}
	
	// @Override public void enterVarExpr(MusicinatorParser.VarExprContext ctx) { }
	@Override public void exitVarExpr(MusicinatorParser.VarExprContext ctx) { }
	
	// @Override public void enterPerExpr(MusicinatorParser.PerExprContext ctx) { }
	@Override public void exitPerExpr(MusicinatorParser.PerExprContext ctx) { }
	
	// @Override public void enterSeqExpr(MusicinatorParser.SeqExprContext ctx) { }
	@Override public void exitSeqExpr(MusicinatorParser.SeqExprContext ctx) { }
	
	// @Override public void enterNumExpr(MusicinatorParser.NumExprContext ctx) { }
	@Override public void exitNumExpr(MusicinatorParser.NumExprContext ctx) { }
	
	// @Override public void enterSeqSpeedMod(MusicinatorParser.SeqSpeedModContext ctx) { }
	@Override public void exitSeqSpeedMod(MusicinatorParser.SeqSpeedModContext ctx) { }
	
	// @Override public void enterSeqVar(MusicinatorParser.SeqVarContext ctx) { }
	@Override public void exitSeqVar(MusicinatorParser.SeqVarContext ctx) { }
	
	// @Override public void enterSeqLiteral(MusicinatorParser.SeqLiteralContext ctx) { }
	@Override public void exitSeqLiteral(MusicinatorParser.SeqLiteralContext ctx) { }
	
	// @Override public void enterSeqPitchMod(MusicinatorParser.SeqPitchModContext ctx) { }
	@Override public void exitSeqPitchMod(MusicinatorParser.SeqPitchModContext ctx) { }
	
	// @Override public void enterSeqList(MusicinatorParser.SeqListContext ctx) { }
	@Override public void exitSeqList(MusicinatorParser.SeqListContext ctx) { }
	
	// @Override public void enterPerVar(MusicinatorParser.PerVarContext ctx) { }
	@Override public void exitPerVar(MusicinatorParser.PerVarContext ctx) { }
	
	// @Override public void enterPerFromSeq(MusicinatorParser.PerFromSeqContext ctx) { }
	@Override public void exitPerFromSeq(MusicinatorParser.PerFromSeqContext ctx) { }
	
	// @Override public void enterPerSpeedMod(MusicinatorParser.PerSpeedModContext ctx) { }
	@Override public void exitPerSpeedMod(MusicinatorParser.PerSpeedModContext ctx) { }
	
	// @Override public void enterPerPitchMod(MusicinatorParser.PerPitchModContext ctx) { }
	@Override public void exitPerPitchMod(MusicinatorParser.PerPitchModContext ctx) { }
	
	// @Override public void enterNumInt(MusicinatorParser.NumIntContext ctx) { }
	@Override public void exitNumInt(MusicinatorParser.NumIntContext ctx) { }
	
	// @Override public void enterNumDouble(MusicinatorParser.NumDoubleContext ctx) { }
	@Override public void exitNumDouble(MusicinatorParser.NumDoubleContext ctx) { }
	
	// @Override public void enterNumMulDiv(MusicinatorParser.NumMulDivContext ctx) { }
	@Override public void exitNumMulDiv(MusicinatorParser.NumMulDivContext ctx) { }
	
	// @Override public void enterNumAddSub(MusicinatorParser.NumAddSubContext ctx) { }
	@Override public void exitNumAddSub(MusicinatorParser.NumAddSubContext ctx) { }
	
	// @Override public void enterNumVar(MusicinatorParser.NumVarContext ctx) { }
	@Override public void exitNumVar(MusicinatorParser.NumVarContext ctx) { }
	
	// @Override public void enterNumDuration(MusicinatorParser.NumDurationContext ctx) { }
	@Override public void exitNumDuration(MusicinatorParser.NumDurationContext ctx) { }
	
	// @Override public void enterVariable(MusicinatorParser.VariableContext ctx) { }
	@Override public void exitVariable(MusicinatorParser.VariableContext ctx) { }
	
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