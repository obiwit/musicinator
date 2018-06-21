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
	 * Enter a parse tree produced by the {@code sequenceAssign}
	 * labeled alternative in {@link MusicinatorParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterSequenceAssign(MusicinatorParser.SequenceAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sequenceAssign}
	 * labeled alternative in {@link MusicinatorParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitSequenceAssign(MusicinatorParser.SequenceAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code perfomanceAssign}
	 * labeled alternative in {@link MusicinatorParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterPerfomanceAssign(MusicinatorParser.PerfomanceAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code perfomanceAssign}
	 * labeled alternative in {@link MusicinatorParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitPerfomanceAssign(MusicinatorParser.PerfomanceAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberAssign}
	 * labeled alternative in {@link MusicinatorParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterNumberAssign(MusicinatorParser.NumberAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberAssign}
	 * labeled alternative in {@link MusicinatorParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitNumberAssign(MusicinatorParser.NumberAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sequenceArrayAssign}
	 * labeled alternative in {@link MusicinatorParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterSequenceArrayAssign(MusicinatorParser.SequenceArrayAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sequenceArrayAssign}
	 * labeled alternative in {@link MusicinatorParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitSequenceArrayAssign(MusicinatorParser.SequenceArrayAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code perfomancArrayeAssign}
	 * labeled alternative in {@link MusicinatorParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterPerfomancArrayeAssign(MusicinatorParser.PerfomancArrayeAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code perfomancArrayeAssign}
	 * labeled alternative in {@link MusicinatorParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitPerfomancArrayeAssign(MusicinatorParser.PerfomancArrayeAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intrumentArrayAssign}
	 * labeled alternative in {@link MusicinatorParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterIntrumentArrayAssign(MusicinatorParser.IntrumentArrayAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intrumentArrayAssign}
	 * labeled alternative in {@link MusicinatorParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitIntrumentArrayAssign(MusicinatorParser.IntrumentArrayAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberArrayAssign}
	 * labeled alternative in {@link MusicinatorParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterNumberArrayAssign(MusicinatorParser.NumberArrayAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberArrayAssign}
	 * labeled alternative in {@link MusicinatorParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitNumberArrayAssign(MusicinatorParser.NumberArrayAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#play}.
	 * @param ctx the parse tree
	 */
	void enterPlay(MusicinatorParser.PlayContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#play}.
	 * @param ctx the parse tree
	 */
	void exitPlay(MusicinatorParser.PlayContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#forstatment}.
	 * @param ctx the parse tree
	 */
	void enterForstatment(MusicinatorParser.ForstatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#forstatment}.
	 * @param ctx the parse tree
	 */
	void exitForstatment(MusicinatorParser.ForstatmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#ifstatment}.
	 * @param ctx the parse tree
	 */
	void enterIfstatment(MusicinatorParser.IfstatmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#ifstatment}.
	 * @param ctx the parse tree
	 */
	void exitIfstatment(MusicinatorParser.IfstatmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(MusicinatorParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(MusicinatorParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSequence(MusicinatorParser.SequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSequence(MusicinatorParser.SequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#performance}.
	 * @param ctx the parse tree
	 */
	void enterPerformance(MusicinatorParser.PerformanceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#performance}.
	 * @param ctx the parse tree
	 */
	void exitPerformance(MusicinatorParser.PerformanceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#sequenceArray}.
	 * @param ctx the parse tree
	 */
	void enterSequenceArray(MusicinatorParser.SequenceArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#sequenceArray}.
	 * @param ctx the parse tree
	 */
	void exitSequenceArray(MusicinatorParser.SequenceArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#sequenceList}.
	 * @param ctx the parse tree
	 */
	void enterSequenceList(MusicinatorParser.SequenceListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#sequenceList}.
	 * @param ctx the parse tree
	 */
	void exitSequenceList(MusicinatorParser.SequenceListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#performanceArray}.
	 * @param ctx the parse tree
	 */
	void enterPerformanceArray(MusicinatorParser.PerformanceArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#performanceArray}.
	 * @param ctx the parse tree
	 */
	void exitPerformanceArray(MusicinatorParser.PerformanceArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#performanceList}.
	 * @param ctx the parse tree
	 */
	void enterPerformanceList(MusicinatorParser.PerformanceListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#performanceList}.
	 * @param ctx the parse tree
	 */
	void exitPerformanceList(MusicinatorParser.PerformanceListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#instrumentArray}.
	 * @param ctx the parse tree
	 */
	void enterInstrumentArray(MusicinatorParser.InstrumentArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#instrumentArray}.
	 * @param ctx the parse tree
	 */
	void exitInstrumentArray(MusicinatorParser.InstrumentArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#wordList}.
	 * @param ctx the parse tree
	 */
	void enterWordList(MusicinatorParser.WordListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#wordList}.
	 * @param ctx the parse tree
	 */
	void exitWordList(MusicinatorParser.WordListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#numberArray}.
	 * @param ctx the parse tree
	 */
	void enterNumberArray(MusicinatorParser.NumberArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#numberArray}.
	 * @param ctx the parse tree
	 */
	void exitNumberArray(MusicinatorParser.NumberArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#numberList}.
	 * @param ctx the parse tree
	 */
	void enterNumberList(MusicinatorParser.NumberListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#numberList}.
	 * @param ctx the parse tree
	 */
	void exitNumberList(MusicinatorParser.NumberListContext ctx);
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
	 * Enter a parse tree produced by {@link MusicinatorParser#arrayTypes}.
	 * @param ctx the parse tree
	 */
	void enterArrayTypes(MusicinatorParser.ArrayTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#arrayTypes}.
	 * @param ctx the parse tree
	 */
	void exitArrayTypes(MusicinatorParser.ArrayTypesContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#numericExpr}.
	 * @param ctx the parse tree
	 */
	void enterNumericExpr(MusicinatorParser.NumericExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#numericExpr}.
	 * @param ctx the parse tree
	 */
	void exitNumericExpr(MusicinatorParser.NumericExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicinatorParser#numericVariable}.
	 * @param ctx the parse tree
	 */
	void enterNumericVariable(MusicinatorParser.NumericVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicinatorParser#numericVariable}.
	 * @param ctx the parse tree
	 */
	void exitNumericVariable(MusicinatorParser.NumericVariableContext ctx);
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
}