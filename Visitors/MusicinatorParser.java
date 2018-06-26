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
		CHORD=1, SOUND=2, INT=3, DURATION=4, DOUBLE=5, ADD=6, SUB=7, MUL=8, DIV=9, 
		REM=10, BIGR=11, BIGE=12, SMLR=13, SMLE=14, EQLS=15, DIFS=16, ARROW=17, 
		ON=18, IN=19, AT=20, BAR=21, AND=22, COMMA=23, COLON=24, EQUAL=25, LOOP=26, 
		PLAY=27, TIMES=28, AFTER=29, SEMICOLON=30, ALWAYS=31, GETINT=32, SEQUENTIALLY=33, 
		IF=34, ELSE=35, ELIF=36, FOR=37, NUM_LIT=38, SQ_LIT=39, PF_LIT=40, INST_LIT=41, 
		OPEN_PR=42, OPEN_SB=43, OPEN_BR=44, CLOSE_PR=45, CLOSE_SB=46, CLOSE_BR=47, 
		WORD=48, STRING=49, LINE_COMMENT=50, BLOCK_COMMENT=51, WS=52;
	public static final int
		RULE_main = 0, RULE_instructions = 1, RULE_assignment = 2, RULE_play = 3, 
		RULE_forStat = 4, RULE_ifStat = 5, RULE_expr = 6, RULE_sequence = 7, RULE_performance = 8, 
		RULE_number = 9, RULE_variable = 10, RULE_types = 11, RULE_condition = 12;
	public static final String[] ruleNames = {
		"main", "instructions", "assignment", "play", "forStat", "ifStat", "expr", 
		"sequence", "performance", "number", "variable", "types", "condition"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, "'+'", "'-'", "'*'", "'/'", "'%'", 
		"'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'->'", "'on'", "'in'", 
		"'at'", "'|'", "'and'", "','", "':'", "'='", "'loop'", "'play'", "'times'", 
		"'after'", "';'", "'always'", "'getInt'", "'sequentially'", "'if'", "'else'", 
		null, "'for'", "'number'", "'sequence'", "'performance'", "'instrument'", 
		"'('", "'['", "'{'", "')'", "']'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CHORD", "SOUND", "INT", "DURATION", "DOUBLE", "ADD", "SUB", "MUL", 
		"DIV", "REM", "BIGR", "BIGE", "SMLR", "SMLE", "EQLS", "DIFS", "ARROW", 
		"ON", "IN", "AT", "BAR", "AND", "COMMA", "COLON", "EQUAL", "LOOP", "PLAY", 
		"TIMES", "AFTER", "SEMICOLON", "ALWAYS", "GETINT", "SEQUENTIALLY", "IF", 
		"ELSE", "ELIF", "FOR", "NUM_LIT", "SQ_LIT", "PF_LIT", "INST_LIT", "OPEN_PR", 
		"OPEN_SB", "OPEN_BR", "CLOSE_PR", "CLOSE_SB", "CLOSE_BR", "WORD", "STRING", 
		"LINE_COMMENT", "BLOCK_COMMENT", "WS"
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << LOOP) | (1L << PLAY) | (1L << AFTER) | (1L << IF) | (1L << FOR) | (1L << NUM_LIT) | (1L << SQ_LIT) | (1L << PF_LIT) | (1L << INST_LIT))) != 0)) {
				{
				{
				setState(26);
				instructions();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(32);
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
		public ForStatContext forStat() {
			return getRuleContext(ForStatContext.class,0);
		}
		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class,0);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitInstructions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstructionsContext instructions() throws RecognitionException {
		InstructionsContext _localctx = new InstructionsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_instructions);
		try {
			setState(38);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM_LIT:
			case SQ_LIT:
			case PF_LIT:
			case INST_LIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				assignment();
				}
				break;
			case AT:
			case LOOP:
			case PLAY:
			case AFTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				play();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				forStat();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 4);
				{
				setState(37);
				ifStat();
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
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
		}
		public TerminalNode WORD() { return getToken(MusicinatorParser.WORD, 0); }
		public TerminalNode EQUAL() { return getToken(MusicinatorParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MusicinatorParser.SEMICOLON, 0); }
		public TerminalNode OPEN_SB() { return getToken(MusicinatorParser.OPEN_SB, 0); }
		public TerminalNode CLOSE_SB() { return getToken(MusicinatorParser.CLOSE_SB, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			types();
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN_SB) {
				{
				setState(41);
				match(OPEN_SB);
				setState(42);
				match(CLOSE_SB);
				}
			}

			setState(45);
			match(WORD);
			setState(46);
			match(EQUAL);
			setState(47);
			expr(0);
			setState(48);
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

	public static class PlayContext extends ParserRuleContext {
		public PlayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_play; }
	 
		public PlayContext() { }
		public void copyFrom(PlayContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LoopPlayContext extends PlayContext {
		public TerminalNode LOOP() { return getToken(MusicinatorParser.LOOP, 0); }
		public PerformanceContext performance() {
			return getRuleContext(PerformanceContext.class,0);
		}
		public LoopPlayContext(PlayContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterLoopPlay(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitLoopPlay(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitLoopPlay(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SimplePlayContext extends PlayContext {
		public TerminalNode PLAY() { return getToken(MusicinatorParser.PLAY, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(MusicinatorParser.SEMICOLON, 0); }
		public TerminalNode SEQUENTIALLY() { return getToken(MusicinatorParser.SEQUENTIALLY, 0); }
		public TerminalNode TIMES() { return getToken(MusicinatorParser.TIMES, 0); }
		public SimplePlayContext(PlayContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterSimplePlay(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitSimplePlay(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitSimplePlay(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TimedPlayContext extends PlayContext {
		public PlayContext play() {
			return getRuleContext(PlayContext.class,0);
		}
		public TerminalNode AT() { return getToken(MusicinatorParser.AT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode AFTER() { return getToken(MusicinatorParser.AFTER, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ALWAYS() { return getToken(MusicinatorParser.ALWAYS, 0); }
		public TimedPlayContext(PlayContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterTimedPlay(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitTimedPlay(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitTimedPlay(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlayContext play() throws RecognitionException {
		PlayContext _localctx = new PlayContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_play);
		int _la;
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLAY:
				_localctx = new SimplePlayContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(PLAY);
				setState(51);
				expr(0);
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEQUENTIALLY) {
					{
					setState(52);
					match(SEQUENTIALLY);
					}
				}

				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHORD) | (1L << SOUND) | (1L << INT) | (1L << DOUBLE) | (1L << BAR) | (1L << GETINT) | (1L << OPEN_PR) | (1L << OPEN_SB) | (1L << WORD))) != 0)) {
					{
					setState(55);
					expr(0);
					setState(56);
					match(TIMES);
					}
				}

				setState(60);
				match(SEMICOLON);
				}
				break;
			case AT:
			case AFTER:
				_localctx = new TimedPlayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case AT:
					{
					setState(62);
					match(AT);
					setState(63);
					expr(0);
					}
					break;
				case AFTER:
					{
					setState(64);
					match(AFTER);
					setState(65);
					variable();
					setState(67);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ALWAYS) {
						{
						setState(66);
						match(ALWAYS);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(71);
				play();
				}
				break;
			case LOOP:
				_localctx = new LoopPlayContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(73);
				match(LOOP);
				setState(74);
				performance();
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

	public static class ForStatContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MusicinatorParser.FOR, 0); }
		public TypesContext types() {
			return getRuleContext(TypesContext.class,0);
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
		public ForStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterForStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitForStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitForStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatContext forStat() throws RecognitionException {
		ForStatContext _localctx = new ForStatContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_forStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(FOR);
			setState(78);
			types();
			setState(79);
			match(WORD);
			setState(80);
			match(IN);
			setState(81);
			match(WORD);
			setState(82);
			match(OPEN_BR);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << LOOP) | (1L << PLAY) | (1L << AFTER) | (1L << IF) | (1L << FOR) | (1L << NUM_LIT) | (1L << SQ_LIT) | (1L << PF_LIT) | (1L << INST_LIT))) != 0)) {
				{
				{
				setState(83);
				instructions();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
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

	public static class IfStatContext extends ParserRuleContext {
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
		public List<TerminalNode> CLOSE_BR() { return getTokens(MusicinatorParser.CLOSE_BR); }
		public TerminalNode CLOSE_BR(int i) {
			return getToken(MusicinatorParser.CLOSE_BR, i);
		}
		public List<InstructionsContext> instructions() {
			return getRuleContexts(InstructionsContext.class);
		}
		public InstructionsContext instructions(int i) {
			return getRuleContext(InstructionsContext.class,i);
		}
		public List<TerminalNode> ELIF() { return getTokens(MusicinatorParser.ELIF); }
		public TerminalNode ELIF(int i) {
			return getToken(MusicinatorParser.ELIF, i);
		}
		public TerminalNode ELSE() { return getToken(MusicinatorParser.ELSE, 0); }
		public IfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ifStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(IF);
			setState(92);
			condition();
			setState(93);
			match(OPEN_BR);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << LOOP) | (1L << PLAY) | (1L << AFTER) | (1L << IF) | (1L << FOR) | (1L << NUM_LIT) | (1L << SQ_LIT) | (1L << PF_LIT) | (1L << INST_LIT))) != 0)) {
				{
				{
				setState(94);
				instructions();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
			match(CLOSE_BR);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELIF) {
				{
				{
				setState(101);
				match(ELIF);
				setState(102);
				condition();
				setState(103);
				match(OPEN_BR);
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << LOOP) | (1L << PLAY) | (1L << AFTER) | (1L << IF) | (1L << FOR) | (1L << NUM_LIT) | (1L << SQ_LIT) | (1L << PF_LIT) | (1L << INST_LIT))) != 0)) {
					{
					{
					setState(104);
					instructions();
					}
					}
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(110);
				match(CLOSE_BR);
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(117);
				match(ELSE);
				setState(118);
				match(OPEN_BR);
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AT) | (1L << LOOP) | (1L << PLAY) | (1L << AFTER) | (1L << IF) | (1L << FOR) | (1L << NUM_LIT) | (1L << SQ_LIT) | (1L << PF_LIT) | (1L << INST_LIT))) != 0)) {
					{
					{
					setState(119);
					instructions();
					}
					}
					setState(124);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(125);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarExprContext extends ExprContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public VarExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterVarExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitVarExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitVarExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BracketArrayContext extends ExprContext {
		public TerminalNode OPEN_SB() { return getToken(MusicinatorParser.OPEN_SB, 0); }
		public TerminalNode CLOSE_SB() { return getToken(MusicinatorParser.CLOSE_SB, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MusicinatorParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MusicinatorParser.COMMA, i);
		}
		public BracketArrayContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterBracketArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitBracketArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitBracketArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubExprContext extends ExprContext {
		public ExprContext e1;
		public Token op;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(MusicinatorParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(MusicinatorParser.SUB, 0); }
		public AddSubExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterAddSubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitAddSubExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitAddSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumRangeArrayContext extends ExprContext {
		public ExprContext e1;
		public ExprContext e2;
		public TerminalNode ARROW() { return getToken(MusicinatorParser.ARROW, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public NumRangeArrayContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterNumRangeArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitNumRangeArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitNumRangeArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PerExprContext extends ExprContext {
		public PerformanceContext performance() {
			return getRuleContext(PerformanceContext.class,0);
		}
		public PerExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterPerExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitPerExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitPerExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SeqExprContext extends ExprContext {
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public SeqExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterSeqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitSeqExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitSeqExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensExprContext extends ExprContext {
		public TerminalNode OPEN_PR() { return getToken(MusicinatorParser.OPEN_PR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PR() { return getToken(MusicinatorParser.CLOSE_PR, 0); }
		public ParensExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterParensExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitParensExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitParensExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivExprContext extends ExprContext {
		public ExprContext e1;
		public Token op;
		public ExprContext e2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(MusicinatorParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(MusicinatorParser.DIV, 0); }
		public MulDivExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterMulDivExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitMulDivExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitMulDivExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumExprContext extends ExprContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterNumExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitNumExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitNumExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndArrayContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(MusicinatorParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(MusicinatorParser.AND, i);
		}
		public AndArrayContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterAndArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitAndArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitAndArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(129);
				variable();
				}
				break;
			case 2:
				{
				_localctx = new PerExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(130);
				performance();
				}
				break;
			case 3:
				{
				_localctx = new SeqExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131);
				sequence();
				}
				break;
			case 4:
				{
				_localctx = new NumExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(132);
				number();
				}
				break;
			case 5:
				{
				_localctx = new ParensExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(133);
				match(OPEN_PR);
				setState(134);
				expr(0);
				setState(135);
				match(CLOSE_PR);
				}
				break;
			case 6:
				{
				_localctx = new BracketArrayContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(137);
				match(OPEN_SB);
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHORD) | (1L << SOUND) | (1L << INT) | (1L << DOUBLE) | (1L << BAR) | (1L << GETINT) | (1L << OPEN_PR) | (1L << OPEN_SB) | (1L << WORD))) != 0)) {
					{
					setState(138);
					expr(0);
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(139);
						match(COMMA);
						setState(140);
						expr(0);
						}
						}
						setState(145);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(148);
				match(CLOSE_SB);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(167);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivExprContext(new ExprContext(_parentctx, _parentState));
						((MulDivExprContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(151);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(152);
						((MulDivExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(153);
						((MulDivExprContext)_localctx).e2 = expr(6);
						}
						break;
					case 2:
						{
						_localctx = new AddSubExprContext(new ExprContext(_parentctx, _parentState));
						((AddSubExprContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(154);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(155);
						((AddSubExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(156);
						((AddSubExprContext)_localctx).e2 = expr(5);
						}
						break;
					case 3:
						{
						_localctx = new NumRangeArrayContext(new ExprContext(_parentctx, _parentState));
						((NumRangeArrayContext)_localctx).e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(157);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(158);
						match(ARROW);
						setState(159);
						((NumRangeArrayContext)_localctx).e2 = expr(2);
						}
						break;
					case 4:
						{
						_localctx = new AndArrayContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(160);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(163); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(161);
								match(AND);
								setState(162);
								expr(0);
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(165); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class SequenceContext extends ParserRuleContext {
		public SequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence; }
	 
		public SequenceContext() { }
		public void copyFrom(SequenceContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SeqNoteContext extends SequenceContext {
		public TerminalNode SOUND() { return getToken(MusicinatorParser.SOUND, 0); }
		public SeqNoteContext(SequenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterSeqNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitSeqNote(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitSeqNote(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SeqChordContext extends SequenceContext {
		public TerminalNode CHORD() { return getToken(MusicinatorParser.CHORD, 0); }
		public SeqChordContext(SequenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterSeqChord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitSeqChord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitSeqChord(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SeqListContext extends SequenceContext {
		public TerminalNode OPEN_SB() { return getToken(MusicinatorParser.OPEN_SB, 0); }
		public TerminalNode CLOSE_SB() { return getToken(MusicinatorParser.CLOSE_SB, 0); }
		public List<SequenceContext> sequence() {
			return getRuleContexts(SequenceContext.class);
		}
		public SequenceContext sequence(int i) {
			return getRuleContext(SequenceContext.class,i);
		}
		public SeqListContext(SequenceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterSeqList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitSeqList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitSeqList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SequenceContext sequence() throws RecognitionException {
		SequenceContext _localctx = new SequenceContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sequence);
		int _la;
		try {
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_SB:
				_localctx = new SeqListContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(OPEN_SB);
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHORD) | (1L << SOUND) | (1L << OPEN_SB))) != 0)) {
					{
					{
					setState(173);
					sequence();
					}
					}
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(179);
				match(CLOSE_SB);
				}
				break;
			case SOUND:
				_localctx = new SeqNoteContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				match(SOUND);
				}
				break;
			case CHORD:
				_localctx = new SeqChordContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
				match(CHORD);
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

	public static class PerformanceContext extends ParserRuleContext {
		public PerformanceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_performance; }
	 
		public PerformanceContext() { }
		public void copyFrom(PerformanceContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PerFromSeqContext extends PerformanceContext {
		public VariableContext seq;
		public VariableContext inst;
		public TerminalNode ON() { return getToken(MusicinatorParser.ON, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public SequenceContext sequence() {
			return getRuleContext(SequenceContext.class,0);
		}
		public PerFromSeqContext(PerformanceContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterPerFromSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitPerFromSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitPerFromSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PerformanceContext performance() throws RecognitionException {
		PerformanceContext _localctx = new PerformanceContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_performance);
		try {
			_localctx = new PerFromSeqContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CHORD:
			case SOUND:
			case OPEN_SB:
				{
				setState(184);
				sequence();
				}
				break;
			case WORD:
				{
				setState(185);
				((PerFromSeqContext)_localctx).seq = variable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(188);
			match(ON);
			setState(189);
			((PerFromSeqContext)_localctx).inst = variable();
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

	public static class NumberContext extends ParserRuleContext {
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
	 
		public NumberContext() { }
		public void copyFrom(NumberContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NumIntContext extends NumberContext {
		public TerminalNode INT() { return getToken(MusicinatorParser.INT, 0); }
		public NumIntContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterNumInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitNumInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitNumInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumDoubleContext extends NumberContext {
		public TerminalNode DOUBLE() { return getToken(MusicinatorParser.DOUBLE, 0); }
		public NumDoubleContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterNumDouble(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitNumDouble(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitNumDouble(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumGetIntContext extends NumberContext {
		public TerminalNode GETINT() { return getToken(MusicinatorParser.GETINT, 0); }
		public TerminalNode OPEN_PR() { return getToken(MusicinatorParser.OPEN_PR, 0); }
		public TerminalNode CLOSE_PR() { return getToken(MusicinatorParser.CLOSE_PR, 0); }
		public TerminalNode STRING() { return getToken(MusicinatorParser.STRING, 0); }
		public NumGetIntContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterNumGetInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitNumGetInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitNumGetInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumDurationContext extends NumberContext {
		public List<TerminalNode> BAR() { return getTokens(MusicinatorParser.BAR); }
		public TerminalNode BAR(int i) {
			return getToken(MusicinatorParser.BAR, i);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public NumDurationContext(NumberContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).enterNumDuration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicinatorParserListener ) ((MusicinatorParserListener)listener).exitNumDuration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitNumDuration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_number);
		int _la;
		try {
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BAR:
				_localctx = new NumDurationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(BAR);
				setState(192);
				variable();
				setState(193);
				match(BAR);
				}
				break;
			case DOUBLE:
				_localctx = new NumDoubleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				match(DOUBLE);
				}
				break;
			case INT:
				_localctx = new NumIntContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(196);
				match(INT);
				}
				break;
			case GETINT:
				_localctx = new NumGetIntContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(197);
				match(GETINT);
				setState(198);
				match(OPEN_PR);
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STRING) {
					{
					setState(199);
					match(STRING);
					}
				}

				setState(202);
				match(CLOSE_PR);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_variable);
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				match(WORD);
				setState(206);
				match(OPEN_SB);
				setState(207);
				match(INT);
				setState(208);
				match(CLOSE_SB);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
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

	public static class TypesContext extends ParserRuleContext {
		public TerminalNode SQ_LIT() { return getToken(MusicinatorParser.SQ_LIT, 0); }
		public TerminalNode PF_LIT() { return getToken(MusicinatorParser.PF_LIT, 0); }
		public TerminalNode NUM_LIT() { return getToken(MusicinatorParser.NUM_LIT, 0); }
		public TerminalNode INST_LIT() { return getToken(MusicinatorParser.INST_LIT, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_types);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUM_LIT) | (1L << SQ_LIT) | (1L << PF_LIT) | (1L << INST_LIT))) != 0)) ) {
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

	public static class ConditionContext extends ParserRuleContext {
		public Token op;
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicinatorParserVisitor ) return ((MusicinatorParserVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			number();
			setState(215);
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
			setState(216);
			number();
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
		case 6:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 1);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\66\u00dd\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\5\3)\n\3\3\4\3\4\3\4\5\4.\n\4\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\5\58\n\5\3\5\3\5\3\5\5\5=\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5"+
		"F\n\5\5\5H\n\5\3\5\3\5\3\5\3\5\5\5N\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7"+
		"\6W\n\6\f\6\16\6Z\13\6\3\6\3\6\3\7\3\7\3\7\3\7\7\7b\n\7\f\7\16\7e\13\7"+
		"\3\7\3\7\3\7\3\7\3\7\7\7l\n\7\f\7\16\7o\13\7\3\7\3\7\7\7s\n\7\f\7\16\7"+
		"v\13\7\3\7\3\7\3\7\7\7{\n\7\f\7\16\7~\13\7\3\7\5\7\u0081\n\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0090\n\b\f\b\16\b\u0093"+
		"\13\b\5\b\u0095\n\b\3\b\5\b\u0098\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\6\b\u00a6\n\b\r\b\16\b\u00a7\7\b\u00aa\n\b\f\b\16\b\u00ad"+
		"\13\b\3\t\3\t\7\t\u00b1\n\t\f\t\16\t\u00b4\13\t\3\t\3\t\3\t\5\t\u00b9"+
		"\n\t\3\n\3\n\5\n\u00bd\n\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\5\13\u00cb\n\13\3\13\5\13\u00ce\n\13\3\f\3\f\3\f\3\f\3\f"+
		"\5\f\u00d5\n\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\2\3\16\17\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\2\6\3\2\n\13\3\2\b\t\3\2(+\3\2\r\22\2\u00f5\2\37"+
		"\3\2\2\2\4(\3\2\2\2\6*\3\2\2\2\bM\3\2\2\2\nO\3\2\2\2\f]\3\2\2\2\16\u0097"+
		"\3\2\2\2\20\u00b8\3\2\2\2\22\u00bc\3\2\2\2\24\u00cd\3\2\2\2\26\u00d4\3"+
		"\2\2\2\30\u00d6\3\2\2\2\32\u00d8\3\2\2\2\34\36\5\4\3\2\35\34\3\2\2\2\36"+
		"!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2!\37\3\2\2\2\"#\7\2\2\3"+
		"#\3\3\2\2\2$)\5\6\4\2%)\5\b\5\2&)\5\n\6\2\')\5\f\7\2($\3\2\2\2(%\3\2\2"+
		"\2(&\3\2\2\2(\'\3\2\2\2)\5\3\2\2\2*-\5\30\r\2+,\7-\2\2,.\7\60\2\2-+\3"+
		"\2\2\2-.\3\2\2\2./\3\2\2\2/\60\7\62\2\2\60\61\7\33\2\2\61\62\5\16\b\2"+
		"\62\63\7 \2\2\63\7\3\2\2\2\64\65\7\35\2\2\65\67\5\16\b\2\668\7#\2\2\67"+
		"\66\3\2\2\2\678\3\2\2\28<\3\2\2\29:\5\16\b\2:;\7\36\2\2;=\3\2\2\2<9\3"+
		"\2\2\2<=\3\2\2\2=>\3\2\2\2>?\7 \2\2?N\3\2\2\2@A\7\26\2\2AH\5\16\b\2BC"+
		"\7\37\2\2CE\5\26\f\2DF\7!\2\2ED\3\2\2\2EF\3\2\2\2FH\3\2\2\2G@\3\2\2\2"+
		"GB\3\2\2\2HI\3\2\2\2IJ\5\b\5\2JN\3\2\2\2KL\7\34\2\2LN\5\22\n\2M\64\3\2"+
		"\2\2MG\3\2\2\2MK\3\2\2\2N\t\3\2\2\2OP\7\'\2\2PQ\5\30\r\2QR\7\62\2\2RS"+
		"\7\25\2\2ST\7\62\2\2TX\7.\2\2UW\5\4\3\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2"+
		"XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2[\\\7\61\2\2\\\13\3\2\2\2]^\7$\2\2^_\5\32"+
		"\16\2_c\7.\2\2`b\5\4\3\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2"+
		"\2\2ec\3\2\2\2ft\7\61\2\2gh\7&\2\2hi\5\32\16\2im\7.\2\2jl\5\4\3\2kj\3"+
		"\2\2\2lo\3\2\2\2mk\3\2\2\2mn\3\2\2\2np\3\2\2\2om\3\2\2\2pq\7\61\2\2qs"+
		"\3\2\2\2rg\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2u\u0080\3\2\2\2vt\3\2"+
		"\2\2wx\7%\2\2x|\7.\2\2y{\5\4\3\2zy\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2"+
		"\2}\177\3\2\2\2~|\3\2\2\2\177\u0081\7\61\2\2\u0080w\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081\r\3\2\2\2\u0082\u0083\b\b\1\2\u0083\u0098\5\26\f\2\u0084"+
		"\u0098\5\22\n\2\u0085\u0098\5\20\t\2\u0086\u0098\5\24\13\2\u0087\u0088"+
		"\7,\2\2\u0088\u0089\5\16\b\2\u0089\u008a\7/\2\2\u008a\u0098\3\2\2\2\u008b"+
		"\u0094\7-\2\2\u008c\u0091\5\16\b\2\u008d\u008e\7\31\2\2\u008e\u0090\5"+
		"\16\b\2\u008f\u008d\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u008c\3\2"+
		"\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0098\7\60\2\2\u0097"+
		"\u0082\3\2\2\2\u0097\u0084\3\2\2\2\u0097\u0085\3\2\2\2\u0097\u0086\3\2"+
		"\2\2\u0097\u0087\3\2\2\2\u0097\u008b\3\2\2\2\u0098\u00ab\3\2\2\2\u0099"+
		"\u009a\f\7\2\2\u009a\u009b\t\2\2\2\u009b\u00aa\5\16\b\b\u009c\u009d\f"+
		"\6\2\2\u009d\u009e\t\3\2\2\u009e\u00aa\5\16\b\7\u009f\u00a0\f\3\2\2\u00a0"+
		"\u00a1\7\23\2\2\u00a1\u00aa\5\16\b\4\u00a2\u00a5\f\4\2\2\u00a3\u00a4\7"+
		"\30\2\2\u00a4\u00a6\5\16\b\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\3\2\2\2\u00a9\u0099\3\2"+
		"\2\2\u00a9\u009c\3\2\2\2\u00a9\u009f\3\2\2\2\u00a9\u00a2\3\2\2\2\u00aa"+
		"\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\17\3\2\2"+
		"\2\u00ad\u00ab\3\2\2\2\u00ae\u00b2\7-\2\2\u00af\u00b1\5\20\t\2\u00b0\u00af"+
		"\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b5\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b9\7\60\2\2\u00b6\u00b9\7"+
		"\4\2\2\u00b7\u00b9\7\3\2\2\u00b8\u00ae\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8"+
		"\u00b7\3\2\2\2\u00b9\21\3\2\2\2\u00ba\u00bd\5\20\t\2\u00bb\u00bd\5\26"+
		"\f\2\u00bc\u00ba\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00bf\7\24\2\2\u00bf\u00c0\5\26\f\2\u00c0\23\3\2\2\2\u00c1\u00c2\7\27"+
		"\2\2\u00c2\u00c3\5\26\f\2\u00c3\u00c4\7\27\2\2\u00c4\u00ce\3\2\2\2\u00c5"+
		"\u00ce\7\7\2\2\u00c6\u00ce\7\5\2\2\u00c7\u00c8\7\"\2\2\u00c8\u00ca\7,"+
		"\2\2\u00c9\u00cb\7\63\2\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\u00ce\7/\2\2\u00cd\u00c1\3\2\2\2\u00cd\u00c5\3\2"+
		"\2\2\u00cd\u00c6\3\2\2\2\u00cd\u00c7\3\2\2\2\u00ce\25\3\2\2\2\u00cf\u00d0"+
		"\7\62\2\2\u00d0\u00d1\7-\2\2\u00d1\u00d2\7\5\2\2\u00d2\u00d5\7\60\2\2"+
		"\u00d3\u00d5\7\62\2\2\u00d4\u00cf\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\27"+
		"\3\2\2\2\u00d6\u00d7\t\4\2\2\u00d7\31\3\2\2\2\u00d8\u00d9\5\24\13\2\u00d9"+
		"\u00da\t\5\2\2\u00da\u00db\5\24\13\2\u00db\33\3\2\2\2\34\37(-\67<EGMX"+
		"cmt|\u0080\u0091\u0094\u0097\u00a7\u00a9\u00ab\u00b2\u00b8\u00bc\u00ca"+
		"\u00cd\u00d4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}