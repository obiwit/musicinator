// Generated from AuxinatorParser.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AuxinatorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BPM=1, NOTE=2, CHORD=3, SOUND=4, INT=5, DURATION=6, DOUBLE=7, ADD=8, SUB=9, 
		MUL=10, DIV=11, REM=12, BIGR=13, BIGE=14, SMLR=15, SMLE=16, EQLS=17, DIFS=18, 
		ARROW=19, ON=20, IN=21, AT=22, BAR=23, AND=24, COMMA=25, COLON=26, EQUAL=27, 
		LOOP=28, PLAY=29, TIMES=30, AFTER=31, SEMICOLON=32, ALWAYS=33, GETINT=34, 
		SEQUENTIALLY=35, IF=36, ELSE=37, ELIF=38, FOR=39, NUM_LIT=40, SQ_LIT=41, 
		PF_LIT=42, INST_LIT=43, OPEN_PR=44, OPEN_SB=45, OPEN_BR=46, CLOSE_PR=47, 
		CLOSE_SB=48, CLOSE_BR=49, WORD=50, STRING=51, LINE_COMMENT=52, BLOCK_COMMENT=53, 
		WS=54;
	public static final int
		RULE_main = 0, RULE_bpm = 1, RULE_noteMap = 2, RULE_instAssign = 3, RULE_instrumentDef = 4, 
		RULE_instrumentInheritanceList = 5, RULE_instrumentInheritance = 6, RULE_noteRange = 7;
	public static final String[] ruleNames = {
		"main", "bpm", "noteMap", "instAssign", "instrumentDef", "instrumentInheritanceList", 
		"instrumentInheritance", "noteRange"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'BPM'", null, null, null, null, null, null, "'+'", "'-'", "'*'", 
		"'/'", "'%'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'->'", "'on'", 
		"'in'", "'at'", "'|'", "'and'", "','", "':'", "'='", "'loop'", "'play'", 
		"'times'", "'after'", "';'", "'always'", "'getInt'", "'sequentially'", 
		"'if'", "'else'", null, "'for'", "'number'", "'sequence'", "'performance'", 
		"'instrument'", "'('", "'['", "'{'", "')'", "']'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BPM", "NOTE", "CHORD", "SOUND", "INT", "DURATION", "DOUBLE", "ADD", 
		"SUB", "MUL", "DIV", "REM", "BIGR", "BIGE", "SMLR", "SMLE", "EQLS", "DIFS", 
		"ARROW", "ON", "IN", "AT", "BAR", "AND", "COMMA", "COLON", "EQUAL", "LOOP", 
		"PLAY", "TIMES", "AFTER", "SEMICOLON", "ALWAYS", "GETINT", "SEQUENTIALLY", 
		"IF", "ELSE", "ELIF", "FOR", "NUM_LIT", "SQ_LIT", "PF_LIT", "INST_LIT", 
		"OPEN_PR", "OPEN_SB", "OPEN_BR", "CLOSE_PR", "CLOSE_SB", "CLOSE_BR", "WORD", 
		"STRING", "LINE_COMMENT", "BLOCK_COMMENT", "WS"
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
	public String getGrammarFileName() { return "AuxinatorParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AuxinatorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MainContext extends ParserRuleContext {
		public BpmContext bpm() {
			return getRuleContext(BpmContext.class,0);
		}
		public TerminalNode EOF() { return getToken(AuxinatorParser.EOF, 0); }
		public List<NoteMapContext> noteMap() {
			return getRuleContexts(NoteMapContext.class);
		}
		public NoteMapContext noteMap(int i) {
			return getRuleContext(NoteMapContext.class,i);
		}
		public List<InstAssignContext> instAssign() {
			return getRuleContexts(InstAssignContext.class);
		}
		public InstAssignContext instAssign(int i) {
			return getRuleContext(InstAssignContext.class,i);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).exitMain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuxinatorParserVisitor ) return ((AuxinatorParserVisitor<? extends T>)visitor).visitMain(this);
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
			setState(16);
			bpm();
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INST_LIT || _la==WORD) {
				{
				setState(19);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case WORD:
					{
					setState(17);
					noteMap();
					}
					break;
				case INST_LIT:
					{
					setState(18);
					instAssign();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24);
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

	public static class BpmContext extends ParserRuleContext {
		public TerminalNode BPM() { return getToken(AuxinatorParser.BPM, 0); }
		public TerminalNode EQUAL() { return getToken(AuxinatorParser.EQUAL, 0); }
		public TerminalNode INT() { return getToken(AuxinatorParser.INT, 0); }
		public TerminalNode SEMICOLON() { return getToken(AuxinatorParser.SEMICOLON, 0); }
		public BpmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bpm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).enterBpm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).exitBpm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuxinatorParserVisitor ) return ((AuxinatorParserVisitor<? extends T>)visitor).visitBpm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BpmContext bpm() throws RecognitionException {
		BpmContext _localctx = new BpmContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_bpm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(BPM);
			setState(27);
			match(EQUAL);
			setState(28);
			match(INT);
			setState(29);
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

	public static class NoteMapContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(AuxinatorParser.WORD, 0); }
		public TerminalNode EQUAL() { return getToken(AuxinatorParser.EQUAL, 0); }
		public TerminalNode NOTE() { return getToken(AuxinatorParser.NOTE, 0); }
		public TerminalNode SEMICOLON() { return getToken(AuxinatorParser.SEMICOLON, 0); }
		public NoteMapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteMap; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).enterNoteMap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).exitNoteMap(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuxinatorParserVisitor ) return ((AuxinatorParserVisitor<? extends T>)visitor).visitNoteMap(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoteMapContext noteMap() throws RecognitionException {
		NoteMapContext _localctx = new NoteMapContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_noteMap);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(WORD);
			setState(32);
			match(EQUAL);
			setState(33);
			match(NOTE);
			setState(34);
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

	public static class InstAssignContext extends ParserRuleContext {
		public TerminalNode INST_LIT() { return getToken(AuxinatorParser.INST_LIT, 0); }
		public TerminalNode WORD() { return getToken(AuxinatorParser.WORD, 0); }
		public TerminalNode COLON() { return getToken(AuxinatorParser.COLON, 0); }
		public InstrumentDefContext instrumentDef() {
			return getRuleContext(InstrumentDefContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(AuxinatorParser.SEMICOLON, 0); }
		public InstAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).enterInstAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).exitInstAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuxinatorParserVisitor ) return ((AuxinatorParserVisitor<? extends T>)visitor).visitInstAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstAssignContext instAssign() throws RecognitionException {
		InstAssignContext _localctx = new InstAssignContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(INST_LIT);
			setState(37);
			match(WORD);
			setState(38);
			match(COLON);
			setState(39);
			instrumentDef();
			setState(40);
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

	public static class InstrumentDefContext extends ParserRuleContext {
		public InstrumentDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrumentDef; }
	 
		public InstrumentDefContext() { }
		public void copyFrom(InstrumentDefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DefWordContext extends InstrumentDefContext {
		public TerminalNode WORD() { return getToken(AuxinatorParser.WORD, 0); }
		public DefWordContext(InstrumentDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).enterDefWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).exitDefWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuxinatorParserVisitor ) return ((AuxinatorParserVisitor<? extends T>)visitor).visitDefWord(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefIntContext extends InstrumentDefContext {
		public TerminalNode INT() { return getToken(AuxinatorParser.INT, 0); }
		public DefIntContext(InstrumentDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).enterDefInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).exitDefInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuxinatorParserVisitor ) return ((AuxinatorParserVisitor<? extends T>)visitor).visitDefInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefInheritanceContext extends InstrumentDefContext {
		public InstrumentInheritanceListContext instrumentInheritanceList() {
			return getRuleContext(InstrumentInheritanceListContext.class,0);
		}
		public DefInheritanceContext(InstrumentDefContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).enterDefInheritance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).exitDefInheritance(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuxinatorParserVisitor ) return ((AuxinatorParserVisitor<? extends T>)visitor).visitDefInheritance(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstrumentDefContext instrumentDef() throws RecognitionException {
		InstrumentDefContext _localctx = new InstrumentDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_instrumentDef);
		try {
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOTE:
				_localctx = new DefInheritanceContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				instrumentInheritanceList();
				}
				break;
			case WORD:
				_localctx = new DefWordContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				match(WORD);
				}
				break;
			case INT:
				_localctx = new DefIntContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(44);
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

	public static class InstrumentInheritanceListContext extends ParserRuleContext {
		public List<InstrumentInheritanceContext> instrumentInheritance() {
			return getRuleContexts(InstrumentInheritanceContext.class);
		}
		public InstrumentInheritanceContext instrumentInheritance(int i) {
			return getRuleContext(InstrumentInheritanceContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AuxinatorParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AuxinatorParser.COMMA, i);
		}
		public InstrumentInheritanceListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrumentInheritanceList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).enterInstrumentInheritanceList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).exitInstrumentInheritanceList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuxinatorParserVisitor ) return ((AuxinatorParserVisitor<? extends T>)visitor).visitInstrumentInheritanceList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstrumentInheritanceListContext instrumentInheritanceList() throws RecognitionException {
		InstrumentInheritanceListContext _localctx = new InstrumentInheritanceListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_instrumentInheritanceList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			instrumentInheritance();
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(48);
				match(COMMA);
				setState(49);
				instrumentInheritance();
				}
				}
				setState(54);
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

	public static class InstrumentInheritanceContext extends ParserRuleContext {
		public TerminalNode ARROW() { return getToken(AuxinatorParser.ARROW, 0); }
		public TerminalNode WORD() { return getToken(AuxinatorParser.WORD, 0); }
		public TerminalNode NOTE() { return getToken(AuxinatorParser.NOTE, 0); }
		public NoteRangeContext noteRange() {
			return getRuleContext(NoteRangeContext.class,0);
		}
		public InstrumentInheritanceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrumentInheritance; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).enterInstrumentInheritance(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).exitInstrumentInheritance(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuxinatorParserVisitor ) return ((AuxinatorParserVisitor<? extends T>)visitor).visitInstrumentInheritance(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstrumentInheritanceContext instrumentInheritance() throws RecognitionException {
		InstrumentInheritanceContext _localctx = new InstrumentInheritanceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_instrumentInheritance);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(55);
				match(NOTE);
				}
				break;
			case 2:
				{
				setState(56);
				noteRange();
				}
				break;
			}
			setState(59);
			match(ARROW);
			setState(60);
			match(WORD);
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

	public static class NoteRangeContext extends ParserRuleContext {
		public List<TerminalNode> NOTE() { return getTokens(AuxinatorParser.NOTE); }
		public TerminalNode NOTE(int i) {
			return getToken(AuxinatorParser.NOTE, i);
		}
		public TerminalNode SUB() { return getToken(AuxinatorParser.SUB, 0); }
		public NoteRangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteRange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).enterNoteRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).exitNoteRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AuxinatorParserVisitor ) return ((AuxinatorParserVisitor<? extends T>)visitor).visitNoteRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoteRangeContext noteRange() throws RecognitionException {
		NoteRangeContext _localctx = new NoteRangeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_noteRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(NOTE);
			setState(63);
			match(SUB);
			setState(64);
			match(NOTE);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\38E\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\7\2\26\n"+
		"\2\f\2\16\2\31\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\5\6\60\n\6\3\7\3\7\3\7\7\7\65\n\7\f"+
		"\7\16\78\13\7\3\b\3\b\5\b<\n\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\2\2\n\2"+
		"\4\6\b\n\f\16\20\2\2\2B\2\22\3\2\2\2\4\34\3\2\2\2\6!\3\2\2\2\b&\3\2\2"+
		"\2\n/\3\2\2\2\f\61\3\2\2\2\16;\3\2\2\2\20@\3\2\2\2\22\27\5\4\3\2\23\26"+
		"\5\6\4\2\24\26\5\b\5\2\25\23\3\2\2\2\25\24\3\2\2\2\26\31\3\2\2\2\27\25"+
		"\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2\31\27\3\2\2\2\32\33\7\2\2\3\33\3"+
		"\3\2\2\2\34\35\7\3\2\2\35\36\7\35\2\2\36\37\7\7\2\2\37 \7\"\2\2 \5\3\2"+
		"\2\2!\"\7\64\2\2\"#\7\35\2\2#$\7\4\2\2$%\7\"\2\2%\7\3\2\2\2&\'\7-\2\2"+
		"\'(\7\64\2\2()\7\34\2\2)*\5\n\6\2*+\7\"\2\2+\t\3\2\2\2,\60\5\f\7\2-\60"+
		"\7\64\2\2.\60\7\7\2\2/,\3\2\2\2/-\3\2\2\2/.\3\2\2\2\60\13\3\2\2\2\61\66"+
		"\5\16\b\2\62\63\7\33\2\2\63\65\5\16\b\2\64\62\3\2\2\2\658\3\2\2\2\66\64"+
		"\3\2\2\2\66\67\3\2\2\2\67\r\3\2\2\28\66\3\2\2\29<\7\4\2\2:<\5\20\t\2;"+
		"9\3\2\2\2;:\3\2\2\2<=\3\2\2\2=>\7\25\2\2>?\7\64\2\2?\17\3\2\2\2@A\7\4"+
		"\2\2AB\7\13\2\2BC\7\4\2\2C\21\3\2\2\2\7\25\27/\66;";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}