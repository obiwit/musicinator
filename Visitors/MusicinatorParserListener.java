// Generated from MusicinatorParser.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MusicinatorParser}.
 */
public interface MusicinatorParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(MusicinatorParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(MusicinatorParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#instructions}.
	 * @param ctx the parse tree
	 */
	void enterInstructions(MusicinatorParser.InstructionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#instructions}.
	 * @param ctx the parse tree
	 */
	void exitInstructions(MusicinatorParser.InstructionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MusicinatorParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MusicinatorParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simplePlay}
	 * labeled alternative in {@link MusicinatorParser#play}.
	 * @param ctx the parse tree
	 */
	void enterSimplePlay(MusicinatorParser.SimplePlayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simplePlay}
	 * labeled alternative in {@link MusicinatorParser#play}.
	 * @param ctx the parse tree
	 */
	void exitSimplePlay(MusicinatorParser.SimplePlayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code timedPlay}
	 * labeled alternative in {@link MusicinatorParser#play}.
	 * @param ctx the parse tree
	 */
	void enterTimedPlay(MusicinatorParser.TimedPlayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code timedPlay}
	 * labeled alternative in {@link MusicinatorParser#play}.
	 * @param ctx the parse tree
	 */
	void exitTimedPlay(MusicinatorParser.TimedPlayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loopPlay}
	 * labeled alternative in {@link MusicinatorParser#play}.
	 * @param ctx the parse tree
	 */
	void enterLoopPlay(MusicinatorParser.LoopPlayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loopPlay}
	 * labeled alternative in {@link MusicinatorParser#play}.
	 * @param ctx the parse tree
	 */
	void exitLoopPlay(MusicinatorParser.LoopPlayContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#forStat}.
	 * @param ctx the parse tree
	 */
	void enterForStat(MusicinatorParser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#forStat}.
	 * @param ctx the parse tree
	 */
	void exitForStat(MusicinatorParser.ForStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(MusicinatorParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(MusicinatorParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarExpr(MusicinatorParser.VarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarExpr(MusicinatorParser.VarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracketArray}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBracketArray(MusicinatorParser.BracketArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracketArray}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBracketArray(MusicinatorParser.BracketArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(MusicinatorParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(MusicinatorParser.AddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numRangeArray}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumRangeArray(MusicinatorParser.NumRangeArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numRangeArray}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumRangeArray(MusicinatorParser.NumRangeArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code perExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPerExpr(MusicinatorParser.PerExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code perExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPerExpr(MusicinatorParser.PerExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code seqExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSeqExpr(MusicinatorParser.SeqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code seqExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSeqExpr(MusicinatorParser.SeqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParensExpr(MusicinatorParser.ParensExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParensExpr(MusicinatorParser.ParensExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpr(MusicinatorParser.MulDivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpr(MusicinatorParser.MulDivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumExpr(MusicinatorParser.NumExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumExpr(MusicinatorParser.NumExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andArray}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndArray(MusicinatorParser.AndArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andArray}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndArray(MusicinatorParser.AndArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code seqList}
	 * labeled alternative in {@link MusicinatorParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSeqList(MusicinatorParser.SeqListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code seqList}
	 * labeled alternative in {@link MusicinatorParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSeqList(MusicinatorParser.SeqListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code seqNote}
	 * labeled alternative in {@link MusicinatorParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSeqNote(MusicinatorParser.SeqNoteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code seqNote}
	 * labeled alternative in {@link MusicinatorParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSeqNote(MusicinatorParser.SeqNoteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code seqChord}
	 * labeled alternative in {@link MusicinatorParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSeqChord(MusicinatorParser.SeqChordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code seqChord}
	 * labeled alternative in {@link MusicinatorParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSeqChord(MusicinatorParser.SeqChordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code perFromSeq}
	 * labeled alternative in {@link MusicinatorParser#performance}.
	 * @param ctx the parse tree
	 */
	void enterPerFromSeq(MusicinatorParser.PerFromSeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code perFromSeq}
	 * labeled alternative in {@link MusicinatorParser#performance}.
	 * @param ctx the parse tree
	 */
	void exitPerFromSeq(MusicinatorParser.PerFromSeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numDuration}
	 * labeled alternative in {@link MusicinatorParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumDuration(MusicinatorParser.NumDurationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numDuration}
	 * labeled alternative in {@link MusicinatorParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumDuration(MusicinatorParser.NumDurationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numDouble}
	 * labeled alternative in {@link MusicinatorParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumDouble(MusicinatorParser.NumDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numDouble}
	 * labeled alternative in {@link MusicinatorParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumDouble(MusicinatorParser.NumDoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numInt}
	 * labeled alternative in {@link MusicinatorParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumInt(MusicinatorParser.NumIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numInt}
	 * labeled alternative in {@link MusicinatorParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumInt(MusicinatorParser.NumIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numGetInt}
	 * labeled alternative in {@link MusicinatorParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumGetInt(MusicinatorParser.NumGetIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numGetInt}
	 * labeled alternative in {@link MusicinatorParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumGetInt(MusicinatorParser.NumGetIntContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(MusicinatorParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(MusicinatorParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#types}.
	 * @param ctx the parse tree
	 */
	void enterTypes(MusicinatorParser.TypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#types}.
	 * @param ctx the parse tree
	 */
	void exitTypes(MusicinatorParser.TypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(MusicinatorParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(MusicinatorParser.ConditionContext ctx);
}