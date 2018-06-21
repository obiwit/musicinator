// Generated from MusicinatorParser.g4 by ANTLR 4.7.1

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.*;

public class DefPhase extends MusicinatorParserBaseListener {
	ParseTreeProperty<ArrayList<String>> scope = new ParseTreeProperty<>();
	Map<String, Object> variables = new HashMap<>();
	Map<String, Note> noteMap;

	//public DefPhase() {} // uncomment to compile atm
	public DefPhase(Map<String, Note> noteMap) {
		// noteMap contains defined non-standard notes and their standard conterparts
		this.noteMap = noteMap;
	}

	// @Override public void enterMain(MusicinatorParser.MainContext ctx) { }
	@Override public void exitMain(MusicinatorParser.MainContext ctx) { }

	// @Override public void enterInstructions(MusicinatorParser.InstructionsContext ctx) { }
	@Override public void exitInstructions(MusicinatorParser.InstructionsContext ctx) { }
	
	// @Override public void enterSequenceAssign(MusicinatorParser.SequenceAssignContext ctx) { }
	@Override public void exitSequenceAssign(MusicinatorParser.SequenceAssignContext ctx) { }
	
	// @Override public void enterPerfomanceAssign(MusicinatorParser.PerfomanceAssignContext ctx) { }
	@Override public void exitPerfomanceAssign(MusicinatorParser.PerfomanceAssignContext ctx) { }
	
	// @Override public void enterNumberAssign(MusicinatorParser.NumberAssignContext ctx) { }
	@Override public void exitNumberAssign(MusicinatorParser.NumberAssignContext ctx) { }
	
	// @Override public void enterSequenceArrayAssign(MusicinatorParser.SequenceArrayAssignContext ctx) { }
	@Override public void exitSequenceArrayAssign(MusicinatorParser.SequenceArrayAssignContext ctx) { }
	
	// @Override public void enterPerfomancArrayeAssign(MusicinatorParser.PerfomancArrayeAssignContext ctx) { }
	@Override public void exitPerfomancArrayeAssign(MusicinatorParser.PerfomancArrayeAssignContext ctx) { }
	
	// @Override public void enterIntrumentArrayAssign(MusicinatorParser.IntrumentArrayAssignContext ctx) { }
	@Override public void exitIntrumentArrayAssign(MusicinatorParser.IntrumentArrayAssignContext ctx) { }
	
	// @Override public void enterNumberArrayAssign(MusicinatorParser.NumberArrayAssignContext ctx) { }
	@Override public void exitNumberArrayAssign(MusicinatorParser.NumberArrayAssignContext ctx) { }
	
	// @Override public void enterPlay(MusicinatorParser.PlayContext ctx) { }
	@Override public void exitPlay(MusicinatorParser.PlayContext ctx) { }
	
	// @Override public void enterForstatment(MusicinatorParser.ForstatmentContext ctx) { }
	@Override public void exitForstatment(MusicinatorParser.ForstatmentContext ctx) { }
	
	// @Override public void enterIfstatment(MusicinatorParser.IfstatmentContext ctx) { }
	@Override public void exitIfstatment(MusicinatorParser.IfstatmentContext ctx) { }
	
	// @Override public void enterBody(MusicinatorParser.BodyContext ctx) { }
	@Override public void exitBody(MusicinatorParser.BodyContext ctx) { }
	
	// @Override public void enterSequence(MusicinatorParser.SequenceContext ctx) { }
	@Override public void exitSequence(MusicinatorParser.SequenceContext ctx) { }
	
	// @Override public void enterPerformance(MusicinatorParser.PerformanceContext ctx) { }
	@Override public void exitPerformance(MusicinatorParser.PerformanceContext ctx) { }
	
	// @Override public void enterSequenceArray(MusicinatorParser.SequenceArrayContext ctx) { }
	@Override public void exitSequenceArray(MusicinatorParser.SequenceArrayContext ctx) { }
	
	// @Override public void enterSequenceList(MusicinatorParser.SequenceListContext ctx) { }
	@Override public void exitSequenceList(MusicinatorParser.SequenceListContext ctx) { }
	
	// @Override public void enterPerformanceArray(MusicinatorParser.PerformanceArrayContext ctx) { }
	@Override public void exitPerformanceArray(MusicinatorParser.PerformanceArrayContext ctx) { }
	
	// @Override public void enterPerformanceList(MusicinatorParser.PerformanceListContext ctx) { }
	@Override public void exitPerformanceList(MusicinatorParser.PerformanceListContext ctx) { }
	
	// @Override public void enterInstrumentArray(MusicinatorParser.InstrumentArrayContext ctx) { }
	@Override public void exitInstrumentArray(MusicinatorParser.InstrumentArrayContext ctx) { }
	
	// @Override public void enterWordList(MusicinatorParser.WordListContext ctx) { }
	@Override public void exitWordList(MusicinatorParser.WordListContext ctx) { }
	
	// @Override public void enterNumberArray(MusicinatorParser.NumberArrayContext ctx) { }
	@Override public void exitNumberArray(MusicinatorParser.NumberArrayContext ctx) { }
	
	// @Override public void enterNumberList(MusicinatorParser.NumberListContext ctx) { }
	@Override public void exitNumberList(MusicinatorParser.NumberListContext ctx) { }
	
	// @Override public void enterTypes(MusicinatorParser.TypesContext ctx) { }
	@Override public void exitTypes(MusicinatorParser.TypesContext ctx) { }
	
	// @Override public void enterArrayTypes(MusicinatorParser.ArrayTypesContext ctx) { }
	@Override public void exitArrayTypes(MusicinatorParser.ArrayTypesContext ctx) { }
	
	// @Override public void enterCondition(MusicinatorParser.ConditionContext ctx) { }
	@Override public void exitCondition(MusicinatorParser.ConditionContext ctx) { }
	
	// @Override public void enterNumericExpr(MusicinatorParser.NumericExprContext ctx) { }
	@Override public void exitNumericExpr(MusicinatorParser.NumericExprContext ctx) { }
	
	// @Override public void enterNumericVariable(MusicinatorParser.NumericVariableContext ctx) { }
	@Override public void exitNumericVariable(MusicinatorParser.NumericVariableContext ctx) { }

	// @Override public void enterVariable(MusicinatorParser.VariableContext ctx) { }
	@Override public void exitVariable(MusicinatorParser.VariableContext ctx) { }

	// @Override public void enterEveryRule(ParserRuleContext ctx) { }
	// @Override public void exitEveryRule(ParserRuleContext ctx) { }
	// @Override public void visitTerminal(TerminalNode node) { }
	// @Override public void visitErrorNode(ErrorNode node) { }
}