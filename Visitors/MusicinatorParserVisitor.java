// Generated from MusicinatorParser.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MusicinatorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MusicinatorParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MusicinatorParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(MusicinatorParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicinatorParser#instructions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstructions(MusicinatorParser.InstructionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicinatorParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(MusicinatorParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simplePlay}
	 * labeled alternative in {@link MusicinatorParser#play}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimplePlay(MusicinatorParser.SimplePlayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code timedPlay}
	 * labeled alternative in {@link MusicinatorParser#play}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimedPlay(MusicinatorParser.TimedPlayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loopPlay}
	 * labeled alternative in {@link MusicinatorParser#play}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopPlay(MusicinatorParser.LoopPlayContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicinatorParser#forStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStat(MusicinatorParser.ForStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicinatorParser#ifStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(MusicinatorParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExpr(MusicinatorParser.VarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bracketArray}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketArray(MusicinatorParser.BracketArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(MusicinatorParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numRangeArray}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumRangeArray(MusicinatorParser.NumRangeArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code perExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPerExpr(MusicinatorParser.PerExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code seqExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeqExpr(MusicinatorParser.SeqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensExpr(MusicinatorParser.ParensExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mulDivExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpr(MusicinatorParser.MulDivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumExpr(MusicinatorParser.NumExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andArray}
	 * labeled alternative in {@link MusicinatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndArray(MusicinatorParser.AndArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code seqList}
	 * labeled alternative in {@link MusicinatorParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeqList(MusicinatorParser.SeqListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code seqNote}
	 * labeled alternative in {@link MusicinatorParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeqNote(MusicinatorParser.SeqNoteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code seqChord}
	 * labeled alternative in {@link MusicinatorParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeqChord(MusicinatorParser.SeqChordContext ctx);
	/**
	 * Visit a parse tree produced by the {@code perFromSeq}
	 * labeled alternative in {@link MusicinatorParser#performance}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPerFromSeq(MusicinatorParser.PerFromSeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numDuration}
	 * labeled alternative in {@link MusicinatorParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumDuration(MusicinatorParser.NumDurationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numDouble}
	 * labeled alternative in {@link MusicinatorParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumDouble(MusicinatorParser.NumDoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numInt}
	 * labeled alternative in {@link MusicinatorParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumInt(MusicinatorParser.NumIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numGetInt}
	 * labeled alternative in {@link MusicinatorParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumGetInt(MusicinatorParser.NumGetIntContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicinatorParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(MusicinatorParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicinatorParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypes(MusicinatorParser.TypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicinatorParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(MusicinatorParser.ConditionContext ctx);
}