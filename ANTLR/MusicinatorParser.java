// Generated from MusicinatorParser.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MusicinatorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SOUND=1, NOTE=2, LETTER=3, INT=4, DURATION=5, DOUBLE=6, ADD=7, SUB=8, 
		MUL=9, DIV=10, REM=11, BIGR=12, BIGE=13, SMLR=14, SMLE=15, EQLS=16, DIFS=17, 
		ARROW=18, OR=19, ON=20, IN=21, AND=22, COMMA=23, COLON=24, EQUAL=25, PLAY=26, 
		EXCEPT=27, SEMICOLON=28, IF=29, ELSE=30, ELIF=31, FOR=32, INST_LIT=33, 
		PF_LIT=34, SQ_LIT=35, NUM_LIT=36, OPEN_SB=37, CLOSE_SB=38, OPEN_BR=39, 
		CLOSE_BR=40, WORD=41, LINE_COMMENT=42, BLOCK_COMMENT=43, WS=44;
	public static final int
		RULE_main = 0, RULE_instructions = 1, RULE_assignment = 2, RULE_play = 3, 
		RULE_forstatment = 4, RULE_ifstatment = 5, RULE_body = 6, RULE_sequence = 7, 
		RULE_performance = 8, RULE_sequenceArray = 9, RULE_sequenceList = 10, 
		RULE_performanceArray = 11, RULE_performanceList = 12, RULE_instrumentArray = 13, 
		RULE_wordList = 14, RULE_numberArray = 15, RULE_numberList = 16, RULE_types = 17, 
		RULE_arrayTypes = 18, RULE_condition = 19, RULE_numericExpr = 20, RULE_numericVariable = 21, 
		RULE_variable = 22;
	public static final String[] ruleNames = {
		"main", "instructions", "assignment", "play", "forstatment", "ifstatment", 
		"body", "sequence", "performance", "sequenceArray", "sequenceList", "performanceArray", 
		"performanceList", "instrumentArray", "wordList", "numberArray", "numberList", 
		"types", "arrayTypes", "condition", "numericExpr", "numericVariable", 
		"variable"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "'+'", "'-'", "'*'", "'/'", 
		"'%'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'->'", "'|'", "'on'", 
		"'in'", "'and'", "','", "':'", "'='", "'play'", "'except'", "';'", "'if'", 
		"'else'", null, "'for'", "'instrument'", "'performance'", "'sequence'", 
		"'number'", "'['", "']'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SOUND", "NOTE", "LETTER", "INT", "DURATION", "DOUBLE", "ADD", "SUB", 
		"MUL", "DIV", "REM", "BIGR", "BIGE", "SMLR", "SMLE", "EQLS", "DIFS", "ARROW", 
		"OR", "ON", "IN", "AND", "COMMA", "COLON", "EQUAL", "PLAY", "EXCEPT", 
		"SEMICOLON", "IF", "ELSE", "ELIF", "FOR", "INST_LIT", "PF_LIT", "SQ_LIT", 
		"NUM_LIT", "OPEN_SB", "CLOSE_SB", "OPEN_BR", "CLOSE_BR", "WORD", "LINE_COMMENT", 
		"BLOCK_COMMENT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MusicinatorParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MusicinatorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MainContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MusicinatorParser.EOF, 0); }
		public List<InstructionsContext> instructions() {
			return getRuleContexts(InstructionsContext.class);
		}
		public InstructionsContext instructions(int i) {
			return getRuleContext(InstructionsContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitMain(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLAY) | (1L << IF) | (1L << FOR) | (1L << INST_LIT) | (1L << PF_LIT) | (1L << SQ_LIT) | (1L << NUM_LIT))) != 0)) {
				{
				{
				setState(46);
				instructions();
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstructionsContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public PlayContext play() {
			return getRuleContext(PlayContext.class,0);
		}
		public IfstatmentContext ifstatment() {
			return getRuleContext(IfstatmentContext.class,0);
		}
		public ForstatmentContext forstatment() {
			return getRuleContext(ForstatmentContext.class,0);
		}
		public InstructionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instructions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterInstructions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitInstructions(this);
		}
	}

	public final InstructionsContext instructions() throws RecognitionException {
		InstructionsContext _localctx = new InstructionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instructions);
		try {
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INST_LIT:
			case PF_LIT:
			case SQ_LIT:
			case NUM_LIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				assignment();
				}
				break;
			case PLAY:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				play();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				ifstatment();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(57);
				forstatment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SequenceArrayAssignContext extends AssignmentContext {
		public TerminalNode SQ_LIT() { return getToken(MusicinatorParser.SQ_LIT, 0); }
		public TerminalNode OPEN_SB() { return getToken(MusicinatorParser.OPEN_SB, 0); }
		public TerminalNode CLOSE_SB() { return getToken(MusicinatorParser.CLOSE_SB, 0); }
		public TerminalNode WORD() { return getToken(MusicinatorParser.WORD, 0); }
		public TerminalNode EQUAL() { return getToken(MusicinatorParser.EQUAL, 0); }
		public SequenceArrayContext sequenceArray() {
			return getRuleContext(SequenceArrayContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MusicinatorParser.SEMICOLON, 0); }
		public SequenceArrayAssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterSequenceArrayAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitSequenceArrayAssign(this);
		}
	}
	public static class SequenceAssignContext extends AssignmentContext {
		public TerminalNode SQ_LIT() { return getToken(MusicinatorParser.SQ_LIT, 0); }
		public TerminalNode WORD() { return getToken(MusicinatorParser.WORD, 0); }
		public TerminalNode EQUAL() { return getToken(MusicinatorParser.EQUAL, 0); }
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MusicinatorParser.SEMICOLON, 0); }
		public SequenceAssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterSequenceAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitSequenceAssign(this);
		}
	}
	public static class IntrumentArrayAssignContext extends AssignmentContext {
		public TerminalNode INST_LIT() { return getToken(MusicinatorParser.INST_LIT, 0); }
		public TerminalNode OPEN_SB() { return getToken(MusicinatorParser.OPEN_SB, 0); }
		public TerminalNode CLOSE_SB() { return getToken(MusicinatorParser.CLOSE_SB, 0); }
		public TerminalNode WORD() { return getToken(MusicinatorParser.WORD, 0); }
		public TerminalNode EQUAL() { return getToken(MusicinatorParser.EQUAL, 0); }
		public InstrumentArrayContext instrumentArray() {
			return getRuleContext(InstrumentArrayContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MusicinatorParser.SEMICOLON, 0); }
		public IntrumentArrayAssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterIntrumentArrayAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitIntrumentArrayAssign(this);
		}
	}
	public static class PerfomancArrayeAssignContext extends AssignmentContext {
		public TerminalNode PF_LIT() { return getToken(MusicinatorParser.PF_LIT, 0); }
		public TerminalNode OPEN_SB() { return getToken(MusicinatorParser.OPEN_SB, 0); }
		public TerminalNode CLOSE_SB() { return getToken(MusicinatorParser.CLOSE_SB, 0); }
		public TerminalNode WORD() { return getToken(MusicinatorParser.WORD, 0); }
		public TerminalNode EQUAL() { return getToken(MusicinatorParser.EQUAL, 0); }
		public PerformanceArrayContext performanceArray() {
			return getRuleContext(PerformanceArrayContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MusicinatorParser.SEMICOLON, 0); }
		public PerfomancArrayeAssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterPerfomancArrayeAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitPerfomancArrayeAssign(this);
		}
	}
	public static class NumberAssignContext extends AssignmentContext {
		public TerminalNode NUM_LIT() { return getToken(MusicinatorParser.NUM_LIT, 0); }
		public TerminalNode WORD() { return getToken(MusicinatorParser.WORD, 0); }
		public TerminalNode EQUAL() { return getToken(MusicinatorParser.EQUAL, 0); }
		public NumericExprContext numericExpr() {
			return getRuleContext(NumericExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MusicinatorParser.SEMICOLON, 0); }
		public NumberAssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterNumberAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitNumberAssign(this);
		}
	}
	public static class PerfomanceAssignContext extends AssignmentContext {
		public TerminalNode PF_LIT() { return getToken(MusicinatorParser.PF_LIT, 0); }
		public TerminalNode WORD() { return getToken(MusicinatorParser.WORD, 0); }
		public TerminalNode EQUAL() { return getToken(MusicinatorParser.EQUAL, 0); }
		public PerformanceContext performance() {
			return getRuleContext(PerformanceContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MusicinatorParser.SEMICOLON, 0); }
		public PerfomanceAssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterPerfomanceAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitPerfomanceAssign(this);
		}
	}
	public static class NumberArrayAssignContext extends AssignmentContext {
		public TerminalNode NUM_LIT() { return getToken(MusicinatorParser.NUM_LIT, 0); }
		public TerminalNode OPEN_SB() { return getToken(MusicinatorParser.OPEN_SB, 0); }
		public TerminalNode CLOSE_SB() { return getToken(MusicinatorParser.CLOSE_SB, 0); }
		public TerminalNode WORD() { return getToken(MusicinatorParser.WORD, 0); }
		public TerminalNode EQUAL() { return getToken(MusicinatorParser.EQUAL, 0); }
		public NumberArrayContext numberArray() {
			return getRuleContext(NumberArrayContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MusicinatorParser.SEMICOLON, 0); }
		public NumberArrayAssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterNumberArrayAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitNumberArrayAssign(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignment);
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new SequenceAssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				match(SQ_LIT);
				setState(61);
				match(WORD);
				setState(62);
				match(EQUAL);
				setState(63);
				sequence(0);
				setState(64);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new PerfomanceAssignContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(PF_LIT);
				setState(67);
				match(WORD);
				setState(68);
				match(EQUAL);
				setState(69);
				performance(0);
				setState(70);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new NumberAssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				match(NUM_LIT);
				setState(73);
				match(WORD);
				setState(74);
				match(EQUAL);
				setState(75);
				numericExpr(0);
				setState(76);
				match(SEMICOLON);
				}
				break;
			case 4:
				_localctx = new SequenceArrayAssignContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				match(SQ_LIT);
				setState(79);
				match(OPEN_SB);
				setState(80);
				match(CLOSE_SB);
				setState(81);
				match(WORD);
				setState(82);
				match(EQUAL);
				setState(83);
				sequenceArray();
				setState(84);
				match(SEMICOLON);
				}
				break;
			case 5:
				_localctx = new PerfomancArrayeAssignContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(86);
				match(PF_LIT);
				setState(87);
				match(OPEN_SB);
				setState(88);
				match(CLOSE_SB);
				setState(89);
				match(WORD);
				setState(90);
				match(EQUAL);
				setState(91);
				performanceArray();
				setState(92);
				match(SEMICOLON);
				}
				break;
			case 6:
				_localctx = new IntrumentArrayAssignContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(94);
				match(INST_LIT);
				setState(95);
				match(OPEN_SB);
				setState(96);
				match(CLOSE_SB);
				setState(97);
				match(WORD);
				setState(98);
				match(EQUAL);
				setState(99);
				instrumentArray(0);
				setState(100);
				match(SEMICOLON);
				}
				break;
			case 7:
				_localctx = new NumberArrayAssignContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(102);
				match(NUM_LIT);
				setState(103);
				match(OPEN_SB);
				setState(104);
				match(CLOSE_SB);
				setState(105);
				match(WORD);
				setState(106);
				match(EQUAL);
				setState(107);
				numberArray();
				setState(108);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PlayContext extends ParserRuleContext {
		public TerminalNode PLAY() { return getToken(MusicinatorParser.PLAY, 0); }
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MusicinatorParser.SEMICOLON, 0); }
		public TerminalNode ON() { return getToken(MusicinatorParser.ON, 0); }
		public TerminalNode WORD() { return getToken(MusicinatorParser.WORD, 0); }
		public PlayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_play; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterPlay(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitPlay(this);
		}
	}

	public final PlayContext play() throws RecognitionException {
		PlayContext _localctx = new PlayContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_play);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(PLAY);
			setState(113);
			sequence(0);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(114);
				match(ON);
				setState(115);
				match(WORD);
				}
			}

			setState(118);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForstatmentContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MusicinatorParser.FOR, 0); }
		public ArrayTypesContext arrayTypes() {
			return getRuleContext(ArrayTypesContext.class,0);
		}
		public List<TerminalNode> WORD() { return getTokens(MusicinatorParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(MusicinatorParser.WORD, i);
		}
		public TerminalNode IN() { return getToken(MusicinatorParser.IN, 0); }
		public TerminalNode OPEN_BR() { return getToken(MusicinatorParser.OPEN_BR, 0); }
		public TerminalNode CLOSE_BR() { return getToken(MusicinatorParser.CLOSE_BR, 0); }
		public List<InstructionsContext> instructions() {
			return getRuleContexts(InstructionsContext.class);
		}
		public InstructionsContext instructions(int i) {
			return getRuleContext(InstructionsContext.class,i);
		}
		public ForstatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forstatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterForstatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitForstatment(this);
		}
	}

	public final ForstatmentContext forstatment() throws RecognitionException {
		ForstatmentContext _localctx = new ForstatmentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_forstatment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(FOR);
			setState(121);
			arrayTypes();
			setState(122);
			match(WORD);
			setState(123);
			match(IN);
			setState(124);
			match(WORD);
			setState(125);
			match(OPEN_BR);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLAY) | (1L << IF) | (1L << FOR) | (1L << INST_LIT) | (1L << PF_LIT) | (1L << SQ_LIT) | (1L << NUM_LIT))) != 0)) {
				{
				{
				setState(126);
				instructions();
				}
				}
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(132);
			match(CLOSE_BR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfstatmentContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MusicinatorParser.IF, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<TerminalNode> OPEN_BR() { return getTokens(MusicinatorParser.OPEN_BR); }
		public TerminalNode OPEN_BR(int i) {
			return getToken(MusicinatorParser.OPEN_BR, i);
		}
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public List<TerminalNode> CLOSE_BR() { return getTokens(MusicinatorParser.CLOSE_BR); }
		public TerminalNode CLOSE_BR(int i) {
			return getToken(MusicinatorParser.CLOSE_BR, i);
		}
		public List<TerminalNode> ELIF() { return getTokens(MusicinatorParser.ELIF); }
		public TerminalNode ELIF(int i) {
			return getToken(MusicinatorParser.ELIF, i);
		}
		public TerminalNode ELSE() { return getToken(MusicinatorParser.ELSE, 0); }
		public IfstatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstatment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterIfstatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitIfstatment(this);
		}
	}

	public final IfstatmentContext ifstatment() throws RecognitionException {
		IfstatmentContext _localctx = new IfstatmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifstatment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(IF);
			setState(135);
			condition();
			setState(136);
			match(OPEN_BR);
			setState(137);
			body();
			setState(138);
			match(CLOSE_BR);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELIF) {
				{
				{
				setState(139);
				match(ELIF);
				setState(140);
				condition();
				setState(141);
				match(OPEN_BR);
				setState(142);
				body();
				setState(143);
				match(CLOSE_BR);
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(150);
				match(ELSE);
				setState(151);
				match(OPEN_BR);
				setState(152);
				body();
				setState(153);
				match(CLOSE_BR);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public InstructionsContext instructions() {
			return getRuleContext(InstructionsContext.class,0);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitBody(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_body);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			instructions();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SequenceContext extends ParserRuleContext {
		public Token op;
		public TerminalNode OPEN_SB() { return getToken(MusicinatorParser.OPEN_SB, 0); }
		public TerminalNode CLOSE_SB() { return getToken(MusicinatorParser.CLOSE_SB, 0); }
		public List<SequenceContext> sequence() {
			return getRuleContexts(SequenceContext.class);
		}
		public SequenceContext sequence(int i) {
			return getRuleContext(SequenceContext.class,i);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode SOUND() { return getToken(MusicinatorParser.SOUND, 0); }
		public NumericVariableContext numericVariable() {
			return getRuleContext(NumericVariableContext.class,0);
		}
		public TerminalNode MUL() { return getToken(MusicinatorParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(MusicinatorParser.DIV, 0); }
		public TerminalNode ADD() { return getToken(MusicinatorParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(MusicinatorParser.SUB, 0); }
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitSequence(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		return sequence(0);
	}

	private SequenceContext sequence(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SequenceContext _localctx = new SequenceContext(_ctx, _parentState);
		SequenceContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_sequence, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_SB:
				{
				setState(160);
				match(OPEN_SB);
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SOUND) | (1L << OPEN_SB) | (1L << WORD))) != 0)) {
					{
					{
					setState(161);
					sequence(0);
					}
					}
					setState(166);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(167);
				match(CLOSE_SB);
				}
				break;
			case WORD:
				{
				setState(168);
				variable();
				}
				break;
			case SOUND:
				{
				setState(169);
				match(SOUND);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(178);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new SequenceContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_sequence);
						setState(172);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(173);
						((SequenceContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((SequenceContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(174);
						numericVariable();
						}
						break;
					case 2:
						{
						_localctx = new SequenceContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_sequence);
						setState(175);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(176);
						((SequenceContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((SequenceContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(177);
						numericVariable();
						}
						break;
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PerformanceContext extends ParserRuleContext {
		public Token op;
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public TerminalNode ON() { return getToken(MusicinatorParser.ON, 0); }
		public TerminalNode WORD() { return getToken(MusicinatorParser.WORD, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public PerformanceContext performance() {
			return getRuleContext(PerformanceContext.class,0);
		}
		public NumericVariableContext numericVariable() {
			return getRuleContext(NumericVariableContext.class,0);
		}
		public TerminalNode MUL() { return getToken(MusicinatorParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(MusicinatorParser.DIV, 0); }
		public TerminalNode ADD() { return getToken(MusicinatorParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(MusicinatorParser.SUB, 0); }
		public PerformanceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_performance; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterPerformance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitPerformance(this);
		}
	}

	public final PerformanceContext performance() throws RecognitionException {
		return performance(0);
	}

	private PerformanceContext performance(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PerformanceContext _localctx = new PerformanceContext(_ctx, _parentState);
		PerformanceContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_performance, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(184);
				sequence(0);
				setState(185);
				match(ON);
				setState(186);
				match(WORD);
				}
				break;
			case 2:
				{
				setState(188);
				variable();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(197);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new PerformanceContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_performance);
						setState(191);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(192);
						((PerformanceContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((PerformanceContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(193);
						numericVariable();
						}
						break;
					case 2:
						{
						_localctx = new PerformanceContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_performance);
						setState(194);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(195);
						((PerformanceContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((PerformanceContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(196);
						numericVariable();
						}
						break;
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SequenceArrayContext extends ParserRuleContext {
		public TerminalNode OPEN_SB() { return getToken(MusicinatorParser.OPEN_SB, 0); }
		public TerminalNode CLOSE_SB() { return getToken(MusicinatorParser.CLOSE_SB, 0); }
		public SequenceListContext sequenceList() {
			return getRuleContext(SequenceListContext.class,0);
		}
		public TerminalNode WORD() { return getToken(MusicinatorParser.WORD, 0); }
		public SequenceArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequenceArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterSequenceArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitSequenceArray(this);
		}
	}

	public final SequenceArrayContext sequenceArray() throws RecognitionException {
		SequenceArrayContext _localctx = new SequenceArrayContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sequenceArray);
		int _la;
		try {
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_SB:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				match(OPEN_SB);
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SOUND) | (1L << OPEN_SB) | (1L << WORD))) != 0)) {
					{
					setState(203);
					sequenceList();
					}
				}

				setState(206);
				match(CLOSE_SB);
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				match(WORD);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SequenceListContext extends ParserRuleContext {
		public List<SequenceContext> sequence() {
			return getRuleContexts(SequenceContext.class);
		}
		public SequenceContext sequence(int i) {
			return getRuleContext(SequenceContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MusicinatorParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MusicinatorParser.COMMA, i);
		}
		public SequenceListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequenceList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterSequenceList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitSequenceList(this);
		}
	}

	public final SequenceListContext sequenceList() throws RecognitionException {
		SequenceListContext _localctx = new SequenceListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sequenceList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			sequence(0);
			setState(215);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(211);
				match(COMMA);
				setState(212);
				sequence(0);
				}
				}
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PerformanceArrayContext extends ParserRuleContext {
		public TerminalNode OPEN_SB() { return getToken(MusicinatorParser.OPEN_SB, 0); }
		public TerminalNode CLOSE_SB() { return getToken(MusicinatorParser.CLOSE_SB, 0); }
		public PerformanceListContext performanceList() {
			return getRuleContext(PerformanceListContext.class,0);
		}
		public TerminalNode WORD() { return getToken(MusicinatorParser.WORD, 0); }
		public PerformanceArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_performanceArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterPerformanceArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitPerformanceArray(this);
		}
	}

	public final PerformanceArrayContext performanceArray() throws RecognitionException {
		PerformanceArrayContext _localctx = new PerformanceArrayContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_performanceArray);
		int _la;
		try {
			setState(224);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_SB:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				match(OPEN_SB);
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SOUND) | (1L << OPEN_SB) | (1L << WORD))) != 0)) {
					{
					setState(219);
					performanceList();
					}
				}

				setState(222);
				match(CLOSE_SB);
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				match(WORD);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PerformanceListContext extends ParserRuleContext {
		public List<PerformanceContext> performance() {
			return getRuleContexts(PerformanceContext.class);
		}
		public PerformanceContext performance(int i) {
			return getRuleContext(PerformanceContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MusicinatorParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MusicinatorParser.COMMA, i);
		}
		public PerformanceListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_performanceList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterPerformanceList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitPerformanceList(this);
		}
	}

	public final PerformanceListContext performanceList() throws RecognitionException {
		PerformanceListContext _localctx = new PerformanceListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_performanceList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			performance(0);
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(227);
				match(COMMA);
				setState(228);
				performance(0);
				}
				}
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InstrumentArrayContext extends ParserRuleContext {
		public Token op;
		public TerminalNode OPEN_SB() { return getToken(MusicinatorParser.OPEN_SB, 0); }
		public TerminalNode CLOSE_SB() { return getToken(MusicinatorParser.CLOSE_SB, 0); }
		public WordListContext wordList() {
			return getRuleContext(WordListContext.class,0);
		}
		public TerminalNode WORD() { return getToken(MusicinatorParser.WORD, 0); }
		public InstrumentArrayContext instrumentArray() {
			return getRuleContext(InstrumentArrayContext.class,0);
		}
		public TerminalNode AND() { return getToken(MusicinatorParser.AND, 0); }
		public TerminalNode EXCEPT() { return getToken(MusicinatorParser.EXCEPT, 0); }
		public InstrumentArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrumentArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterInstrumentArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitInstrumentArray(this);
		}
	}

	public final InstrumentArrayContext instrumentArray() throws RecognitionException {
		return instrumentArray(0);
	}

	private InstrumentArrayContext instrumentArray(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InstrumentArrayContext _localctx = new InstrumentArrayContext(_ctx, _parentState);
		InstrumentArrayContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_instrumentArray, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_SB:
				{
				setState(235);
				match(OPEN_SB);
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==WORD) {
					{
					setState(236);
					wordList();
					}
				}

				setState(239);
				match(CLOSE_SB);
				}
				break;
			case WORD:
				{
				setState(240);
				match(WORD);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(248);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new InstrumentArrayContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_instrumentArray);
					setState(243);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(244);
					((InstrumentArrayContext)_localctx).op = _input.LT(1);
					_la = _input.LA(1);
					if ( !(_la==AND || _la==EXCEPT) ) {
						((InstrumentArrayContext)_localctx).op = (Token)_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(245);
					match(WORD);
					}
					} 
				}
				setState(250);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class WordListContext extends ParserRuleContext {
		public List<TerminalNode> WORD() { return getTokens(MusicinatorParser.WORD); }
		public TerminalNode WORD(int i) {
			return getToken(MusicinatorParser.WORD, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MusicinatorParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MusicinatorParser.COMMA, i);
		}
		public WordListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wordList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterWordList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitWordList(this);
		}
	}

	public final WordListContext wordList() throws RecognitionException {
		WordListContext _localctx = new WordListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_wordList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(WORD);
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(252);
				match(COMMA);
				setState(253);
				match(WORD);
				}
				}
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberArrayContext extends ParserRuleContext {
		public TerminalNode OPEN_SB() { return getToken(MusicinatorParser.OPEN_SB, 0); }
		public TerminalNode CLOSE_SB() { return getToken(MusicinatorParser.CLOSE_SB, 0); }
		public NumberListContext numberList() {
			return getRuleContext(NumberListContext.class,0);
		}
		public TerminalNode WORD() { return getToken(MusicinatorParser.WORD, 0); }
		public NumberArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterNumberArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitNumberArray(this);
		}
	}

	public final NumberArrayContext numberArray() throws RecognitionException {
		NumberArrayContext _localctx = new NumberArrayContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_numberArray);
		int _la;
		try {
			setState(265);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_SB:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				match(OPEN_SB);
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << DOUBLE) | (1L << OR) | (1L << WORD))) != 0)) {
					{
					setState(260);
					numberList();
					}
				}

				setState(263);
				match(CLOSE_SB);
				}
				break;
			case WORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				match(WORD);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberListContext extends ParserRuleContext {
		public List<NumericExprContext> numericExpr() {
			return getRuleContexts(NumericExprContext.class);
		}
		public NumericExprContext numericExpr(int i) {
			return getRuleContext(NumericExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MusicinatorParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MusicinatorParser.COMMA, i);
		}
		public NumberListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterNumberList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitNumberList(this);
		}
	}

	public final NumberListContext numberList() throws RecognitionException {
		NumberListContext _localctx = new NumberListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_numberList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			numericExpr(0);
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(268);
				match(COMMA);
				setState(269);
				numericExpr(0);
				}
				}
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypesContext extends ParserRuleContext {
		public TerminalNode SQ_LIT() { return getToken(MusicinatorParser.SQ_LIT, 0); }
		public TerminalNode PF_LIT() { return getToken(MusicinatorParser.PF_LIT, 0); }
		public TerminalNode NUM_LIT() { return getToken(MusicinatorParser.NUM_LIT, 0); }
		public TypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_types; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitTypes(this);
		}
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_types);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PF_LIT) | (1L << SQ_LIT) | (1L << NUM_LIT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayTypesContext extends ParserRuleContext {
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public TerminalNode INST_LIT() { return getToken(MusicinatorParser.INST_LIT, 0); }
		public ArrayTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterArrayTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitArrayTypes(this);
		}
	}

	public final ArrayTypesContext arrayTypes() throws RecognitionException {
		ArrayTypesContext _localctx = new ArrayTypesContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arrayTypes);
		try {
			setState(279);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PF_LIT:
			case SQ_LIT:
			case NUM_LIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(277);
				types();
				}
				break;
			case INST_LIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(278);
				match(INST_LIT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public Token op;
		public List<NumericExprContext> numericExpr() {
			return getRuleContexts(NumericExprContext.class);
		}
		public NumericExprContext numericExpr(int i) {
			return getRuleContext(NumericExprContext.class,i);
		}
		public TerminalNode BIGR() { return getToken(MusicinatorParser.BIGR, 0); }
		public TerminalNode BIGE() { return getToken(MusicinatorParser.BIGE, 0); }
		public TerminalNode SMLR() { return getToken(MusicinatorParser.SMLR, 0); }
		public TerminalNode SMLE() { return getToken(MusicinatorParser.SMLE, 0); }
		public TerminalNode EQLS() { return getToken(MusicinatorParser.EQLS, 0); }
		public TerminalNode DIFS() { return getToken(MusicinatorParser.DIFS, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			numericExpr(0);
			setState(282);
			((ConditionContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BIGR) | (1L << BIGE) | (1L << SMLR) | (1L << SMLE) | (1L << EQLS) | (1L << DIFS))) != 0)) ) {
				((ConditionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(283);
			numericExpr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericExprContext extends ParserRuleContext {
		public Token op;
		public NumericVariableContext numericVariable() {
			return getRuleContext(NumericVariableContext.class,0);
		}
		public List<NumericExprContext> numericExpr() {
			return getRuleContexts(NumericExprContext.class);
		}
		public NumericExprContext numericExpr(int i) {
			return getRuleContext(NumericExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(MusicinatorParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(MusicinatorParser.DIV, 0); }
		public TerminalNode REM() { return getToken(MusicinatorParser.REM, 0); }
		public TerminalNode ADD() { return getToken(MusicinatorParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(MusicinatorParser.SUB, 0); }
		public NumericExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterNumericExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitNumericExpr(this);
		}
	}

	public final NumericExprContext numericExpr() throws RecognitionException {
		return numericExpr(0);
	}

	private NumericExprContext numericExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NumericExprContext _localctx = new NumericExprContext(_ctx, _parentState);
		NumericExprContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_numericExpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(286);
			numericVariable();
			}
			_ctx.stop = _input.LT(-1);
			setState(296);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(294);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new NumericExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_numericExpr);
						setState(288);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(289);
						((NumericExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << REM))) != 0)) ) {
							((NumericExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(290);
						numericExpr(4);
						}
						break;
					case 2:
						{
						_localctx = new NumericExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_numericExpr);
						setState(291);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(292);
						((NumericExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((NumericExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(293);
						numericExpr(3);
						}
						break;
					}
					} 
				}
				setState(298);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NumericVariableContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<TerminalNode> OR() { return getTokens(MusicinatorParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(MusicinatorParser.OR, i);
		}
		public TerminalNode WORD() { return getToken(MusicinatorParser.WORD, 0); }
		public TerminalNode DOUBLE() { return getToken(MusicinatorParser.DOUBLE, 0); }
		public TerminalNode INT() { return getToken(MusicinatorParser.INT, 0); }
		public NumericVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterNumericVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitNumericVariable(this);
		}
	}

	public final NumericVariableContext numericVariable() throws RecognitionException {
		NumericVariableContext _localctx = new NumericVariableContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_numericVariable);
		try {
			setState(305);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				variable();
				}
				break;
			case OR:
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
				match(OR);
				setState(301);
				match(WORD);
				setState(302);
				match(OR);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(303);
				match(DOUBLE);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 4);
				{
				setState(304);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(MusicinatorParser.WORD, 0); }
		public TerminalNode OPEN_SB() { return getToken(MusicinatorParser.OPEN_SB, 0); }
		public TerminalNode INT() { return getToken(MusicinatorParser.INT, 0); }
		public TerminalNode CLOSE_SB() { return getToken(MusicinatorParser.CLOSE_SB, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_variable);
		try {
			setState(312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(307);
				match(WORD);
				setState(308);
				match(OPEN_SB);
				setState(309);
				match(INT);
				setState(310);
				match(CLOSE_SB);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
				match(WORD);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return sequence_sempred((SequenceContext)_localctx, predIndex);
		case 8:
			return performance_sempred((PerformanceContext)_localctx, predIndex);
		case 13:
			return instrumentArray_sempred((InstrumentArrayContext)_localctx, predIndex);
		case 20:
			return numericExpr_sempred((NumericExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean sequence_sempred(SequenceContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean performance_sempred(PerformanceContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean instrumentArray_sempred(InstrumentArrayContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean numericExpr_sempred(NumericExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u013d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\7\2\62"+
		"\n\2\f\2\16\2\65\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3=\n\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4q\n\4\3\5\3\5\3\5\3\5"+
		"\5\5w\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u0082\n\6\f\6\16\6\u0085"+
		"\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0094\n"+
		"\7\f\7\16\7\u0097\13\7\3\7\3\7\3\7\3\7\3\7\5\7\u009e\n\7\3\b\3\b\3\t\3"+
		"\t\3\t\7\t\u00a5\n\t\f\t\16\t\u00a8\13\t\3\t\3\t\3\t\5\t\u00ad\n\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\7\t\u00b5\n\t\f\t\16\t\u00b8\13\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\5\n\u00c0\n\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00c8\n\n\f\n\16\n"+
		"\u00cb\13\n\3\13\3\13\5\13\u00cf\n\13\3\13\3\13\5\13\u00d3\n\13\3\f\3"+
		"\f\3\f\7\f\u00d8\n\f\f\f\16\f\u00db\13\f\3\r\3\r\5\r\u00df\n\r\3\r\3\r"+
		"\5\r\u00e3\n\r\3\16\3\16\3\16\7\16\u00e8\n\16\f\16\16\16\u00eb\13\16\3"+
		"\17\3\17\3\17\5\17\u00f0\n\17\3\17\3\17\5\17\u00f4\n\17\3\17\3\17\3\17"+
		"\7\17\u00f9\n\17\f\17\16\17\u00fc\13\17\3\20\3\20\3\20\7\20\u0101\n\20"+
		"\f\20\16\20\u0104\13\20\3\21\3\21\5\21\u0108\n\21\3\21\3\21\5\21\u010c"+
		"\n\21\3\22\3\22\3\22\7\22\u0111\n\22\f\22\16\22\u0114\13\22\3\23\3\23"+
		"\3\24\3\24\5\24\u011a\n\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\7\26\u0129\n\26\f\26\16\26\u012c\13\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\5\27\u0134\n\27\3\30\3\30\3\30\3\30\3\30\5\30\u013b"+
		"\n\30\3\30\2\6\20\22\34*\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*,.\2\b\3\2\13\f\3\2\t\n\4\2\30\30\35\35\3\2$&\3\2\16\23\3\2\13\r\2"+
		"\u014f\2\63\3\2\2\2\4<\3\2\2\2\6p\3\2\2\2\br\3\2\2\2\nz\3\2\2\2\f\u0088"+
		"\3\2\2\2\16\u009f\3\2\2\2\20\u00ac\3\2\2\2\22\u00bf\3\2\2\2\24\u00d2\3"+
		"\2\2\2\26\u00d4\3\2\2\2\30\u00e2\3\2\2\2\32\u00e4\3\2\2\2\34\u00f3\3\2"+
		"\2\2\36\u00fd\3\2\2\2 \u010b\3\2\2\2\"\u010d\3\2\2\2$\u0115\3\2\2\2&\u0119"+
		"\3\2\2\2(\u011b\3\2\2\2*\u011f\3\2\2\2,\u0133\3\2\2\2.\u013a\3\2\2\2\60"+
		"\62\5\4\3\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64"+
		"\66\3\2\2\2\65\63\3\2\2\2\66\67\7\2\2\3\67\3\3\2\2\28=\5\6\4\29=\5\b\5"+
		"\2:=\5\f\7\2;=\5\n\6\2<8\3\2\2\2<9\3\2\2\2<:\3\2\2\2<;\3\2\2\2=\5\3\2"+
		"\2\2>?\7%\2\2?@\7+\2\2@A\7\33\2\2AB\5\20\t\2BC\7\36\2\2Cq\3\2\2\2DE\7"+
		"$\2\2EF\7+\2\2FG\7\33\2\2GH\5\22\n\2HI\7\36\2\2Iq\3\2\2\2JK\7&\2\2KL\7"+
		"+\2\2LM\7\33\2\2MN\5*\26\2NO\7\36\2\2Oq\3\2\2\2PQ\7%\2\2QR\7\'\2\2RS\7"+
		"(\2\2ST\7+\2\2TU\7\33\2\2UV\5\24\13\2VW\7\36\2\2Wq\3\2\2\2XY\7$\2\2YZ"+
		"\7\'\2\2Z[\7(\2\2[\\\7+\2\2\\]\7\33\2\2]^\5\30\r\2^_\7\36\2\2_q\3\2\2"+
		"\2`a\7#\2\2ab\7\'\2\2bc\7(\2\2cd\7+\2\2de\7\33\2\2ef\5\34\17\2fg\7\36"+
		"\2\2gq\3\2\2\2hi\7&\2\2ij\7\'\2\2jk\7(\2\2kl\7+\2\2lm\7\33\2\2mn\5 \21"+
		"\2no\7\36\2\2oq\3\2\2\2p>\3\2\2\2pD\3\2\2\2pJ\3\2\2\2pP\3\2\2\2pX\3\2"+
		"\2\2p`\3\2\2\2ph\3\2\2\2q\7\3\2\2\2rs\7\34\2\2sv\5\20\t\2tu\7\26\2\2u"+
		"w\7+\2\2vt\3\2\2\2vw\3\2\2\2wx\3\2\2\2xy\7\36\2\2y\t\3\2\2\2z{\7\"\2\2"+
		"{|\5&\24\2|}\7+\2\2}~\7\27\2\2~\177\7+\2\2\177\u0083\7)\2\2\u0080\u0082"+
		"\5\4\3\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\7*"+
		"\2\2\u0087\13\3\2\2\2\u0088\u0089\7\37\2\2\u0089\u008a\5(\25\2\u008a\u008b"+
		"\7)\2\2\u008b\u008c\5\16\b\2\u008c\u0095\7*\2\2\u008d\u008e\7!\2\2\u008e"+
		"\u008f\5(\25\2\u008f\u0090\7)\2\2\u0090\u0091\5\16\b\2\u0091\u0092\7*"+
		"\2\2\u0092\u0094\3\2\2\2\u0093\u008d\3\2\2\2\u0094\u0097\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u009d\3\2\2\2\u0097\u0095\3\2"+
		"\2\2\u0098\u0099\7 \2\2\u0099\u009a\7)\2\2\u009a\u009b\5\16\b\2\u009b"+
		"\u009c\7*\2\2\u009c\u009e\3\2\2\2\u009d\u0098\3\2\2\2\u009d\u009e\3\2"+
		"\2\2\u009e\r\3\2\2\2\u009f\u00a0\5\4\3\2\u00a0\17\3\2\2\2\u00a1\u00a2"+
		"\b\t\1\2\u00a2\u00a6\7\'\2\2\u00a3\u00a5\5\20\t\2\u00a4\u00a3\3\2\2\2"+
		"\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9"+
		"\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\u00ad\7(\2\2\u00aa\u00ad\5.\30\2\u00ab"+
		"\u00ad\7\3\2\2\u00ac\u00a1\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ab\3\2"+
		"\2\2\u00ad\u00b6\3\2\2\2\u00ae\u00af\f\7\2\2\u00af\u00b0\t\2\2\2\u00b0"+
		"\u00b5\5,\27\2\u00b1\u00b2\f\6\2\2\u00b2\u00b3\t\3\2\2\u00b3\u00b5\5,"+
		"\27\2\u00b4\u00ae\3\2\2\2\u00b4\u00b1\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\21\3\2\2\2\u00b8\u00b6\3\2\2"+
		"\2\u00b9\u00ba\b\n\1\2\u00ba\u00bb\5\20\t\2\u00bb\u00bc\7\26\2\2\u00bc"+
		"\u00bd\7+\2\2\u00bd\u00c0\3\2\2\2\u00be\u00c0\5.\30\2\u00bf\u00b9\3\2"+
		"\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c9\3\2\2\2\u00c1\u00c2\f\6\2\2\u00c2"+
		"\u00c3\t\2\2\2\u00c3\u00c8\5,\27\2\u00c4\u00c5\f\5\2\2\u00c5\u00c6\t\3"+
		"\2\2\u00c6\u00c8\5,\27\2\u00c7\u00c1\3\2\2\2\u00c7\u00c4\3\2\2\2\u00c8"+
		"\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\23\3\2\2"+
		"\2\u00cb\u00c9\3\2\2\2\u00cc\u00ce\7\'\2\2\u00cd\u00cf\5\26\f\2\u00ce"+
		"\u00cd\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d3\7("+
		"\2\2\u00d1\u00d3\7+\2\2\u00d2\u00cc\3\2\2\2\u00d2\u00d1\3\2\2\2\u00d3"+
		"\25\3\2\2\2\u00d4\u00d9\5\20\t\2\u00d5\u00d6\7\31\2\2\u00d6\u00d8\5\20"+
		"\t\2\u00d7\u00d5\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9"+
		"\u00da\3\2\2\2\u00da\27\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00de\7\'\2"+
		"\2\u00dd\u00df\5\32\16\2\u00de\u00dd\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\u00e0\3\2\2\2\u00e0\u00e3\7(\2\2\u00e1\u00e3\7+\2\2\u00e2\u00dc\3\2\2"+
		"\2\u00e2\u00e1\3\2\2\2\u00e3\31\3\2\2\2\u00e4\u00e9\5\22\n\2\u00e5\u00e6"+
		"\7\31\2\2\u00e6\u00e8\5\22\n\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb\3\2\2\2"+
		"\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\33\3\2\2\2\u00eb\u00e9"+
		"\3\2\2\2\u00ec\u00ed\b\17\1\2\u00ed\u00ef\7\'\2\2\u00ee\u00f0\5\36\20"+
		"\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f4"+
		"\7(\2\2\u00f2\u00f4\7+\2\2\u00f3\u00ec\3\2\2\2\u00f3\u00f2\3\2\2\2\u00f4"+
		"\u00fa\3\2\2\2\u00f5\u00f6\f\4\2\2\u00f6\u00f7\t\4\2\2\u00f7\u00f9\7+"+
		"\2\2\u00f8\u00f5\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb\35\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u0102\7+\2\2"+
		"\u00fe\u00ff\7\31\2\2\u00ff\u0101\7+\2\2\u0100\u00fe\3\2\2\2\u0101\u0104"+
		"\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\37\3\2\2\2\u0104"+
		"\u0102\3\2\2\2\u0105\u0107\7\'\2\2\u0106\u0108\5\"\22\2\u0107\u0106\3"+
		"\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010c\7(\2\2\u010a"+
		"\u010c\7+\2\2\u010b\u0105\3\2\2\2\u010b\u010a\3\2\2\2\u010c!\3\2\2\2\u010d"+
		"\u0112\5*\26\2\u010e\u010f\7\31\2\2\u010f\u0111\5*\26\2\u0110\u010e\3"+
		"\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113"+
		"#\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0116\t\5\2\2\u0116%\3\2\2\2\u0117"+
		"\u011a\5$\23\2\u0118\u011a\7#\2\2\u0119\u0117\3\2\2\2\u0119\u0118\3\2"+
		"\2\2\u011a\'\3\2\2\2\u011b\u011c\5*\26\2\u011c\u011d\t\6\2\2\u011d\u011e"+
		"\5*\26\2\u011e)\3\2\2\2\u011f\u0120\b\26\1\2\u0120\u0121\5,\27\2\u0121"+
		"\u012a\3\2\2\2\u0122\u0123\f\5\2\2\u0123\u0124\t\7\2\2\u0124\u0129\5*"+
		"\26\6\u0125\u0126\f\4\2\2\u0126\u0127\t\3\2\2\u0127\u0129\5*\26\5\u0128"+
		"\u0122\3\2\2\2\u0128\u0125\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2"+
		"\2\2\u012a\u012b\3\2\2\2\u012b+\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u0134"+
		"\5.\30\2\u012e\u012f\7\25\2\2\u012f\u0130\7+\2\2\u0130\u0134\7\25\2\2"+
		"\u0131\u0134\7\b\2\2\u0132\u0134\7\6\2\2\u0133\u012d\3\2\2\2\u0133\u012e"+
		"\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0132\3\2\2\2\u0134-\3\2\2\2\u0135"+
		"\u0136\7+\2\2\u0136\u0137\7\'\2\2\u0137\u0138\7\6\2\2\u0138\u013b\7(\2"+
		"\2\u0139\u013b\7+\2\2\u013a\u0135\3\2\2\2\u013a\u0139\3\2\2\2\u013b/\3"+
		"\2\2\2\"\63<pv\u0083\u0095\u009d\u00a6\u00ac\u00b4\u00b6\u00bf\u00c7\u00c9"+
		"\u00ce\u00d2\u00d9\u00de\u00e2\u00e9\u00ef\u00f3\u00fa\u0102\u0107\u010b"+
		"\u0112\u0119\u0128\u012a\u0133\u013a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}