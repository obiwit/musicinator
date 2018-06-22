// Generated from MusicinatorParser.g4 by ANTLR 4.7.1

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import org.antlr.v4.runtime.tree.ParseTreeProperty;
import java.util.*;

/**
 * 
 */
public class RefPhase extends MusicinatorParserBaseListener {

	Music music;
	ParseTreeProperty<Map<String, Object>> scopes;

	public RefPhase(Music music, ParseTreeProperty<Map<String, Object>> scopes) {
		this.music = music;
		this.scopes = scopes;
	}
	
	// @Override public void enterPlay(MusicinatorParser.PlayContext ctx) { }
	@Override public void exitPlay(MusicinatorParser.PlayContext ctx) { }
	
	// @Override public void enterForStat(MusicinatorParser.ForStatContext ctx) { }
	@Override public void exitForStat(MusicinatorParser.ForStatContext ctx) { }
	
	// @Override public void enterIfStat(MusicinatorParser.IfStatContext ctx) { }
	@Override public void exitIfStat(MusicinatorParser.IfStatContext ctx) { }
	
	// @Override public void enterArrayExpr(MusicinatorParser.ArrayExprContext ctx) { }
	@Override public void exitArrayExpr(MusicinatorParser.ArrayExprContext ctx) { }
	
	// @Override public void enterList(MusicinatorParser.ListContext ctx) { }
	@Override public void exitList(MusicinatorParser.ListContext ctx) { }
	
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
	@Override public void exitTypes(MusicinatorParser.TypesContext ctx) { }
	
	// @Override public void enterArrayTypes(MusicinatorParser.ArrayTypesContext ctx) { }
	@Override public void exitArrayTypes(MusicinatorParser.ArrayTypesContext ctx) { }
	
	// @Override public void enterCondition(MusicinatorParser.ConditionContext ctx) { }
	@Override public void exitCondition(MusicinatorParser.ConditionContext ctx) { }

	// @Override public void enterEveryRule(ParserRuleContext ctx) { }
	// @Override public void exitEveryRule(ParserRuleContext ctx) { }
	// @Override public void visitTerminal(TerminalNode node) { }
	// @Override public void visitErrorNode(ErrorNode node) { }
}