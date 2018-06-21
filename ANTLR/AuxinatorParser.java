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
		BPM=1, SOUND=2, NOTE=3, LETTER=4, INT=5, DURATION=6, DOUBLE=7, ADD=8, 
		SUB=9, MUL=10, DIV=11, REM=12, BIGR=13, BIGE=14, SMLR=15, SMLE=16, EQLS=17, 
		DIFS=18, ARROW=19, OR=20, ON=21, IN=22, AND=23, COMMA=24, COLON=25, EQUAL=26, 
		PLAY=27, EXCEPT=28, SEMICOLON=29, IF=30, ELSE=31, ELIF=32, FOR=33, INST_LIT=34, 
		PF_LIT=35, SQ_LIT=36, NUM_LIT=37, OPEN_SB=38, CLOSE_SB=39, OPEN_BR=40, 
		CLOSE_BR=41, WORD=42, LINE_COMMENT=43, BLOCK_COMMENT=44, WS=45;
	public static final int
		RULE_main = 0, RULE_bpm = 1, RULE_instAssign = 2, RULE_instrumentDef = 3, 
		RULE_noteMap = 4, RULE_noteMapList = 5, RULE_instrumentInheritance = 6, 
		RULE_instrumentInheritanceList = 7, RULE_noteRange = 8;
	public static final String[] ruleNames = {
		"main", "bpm", "instAssign", "instrumentDef", "noteMap", "noteMapList", 
		"instrumentInheritance", "instrumentInheritanceList", "noteRange"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'BPM'", null, null, null, null, null, null, "'+'", "'-'", "'*'", 
		"'/'", "'%'", "'>'", "'>='", "'<'", "'<='", "'=='", "'!='", "'->'", "'|'", 
		"'on'", "'in'", "'and'", "','", "':'", "'='", "'play'", "'except'", "';'", 
		"'if'", "'else'", null, "'for'", "'instrument'", "'performance'", "'sequence'", 
		"'number'", "'['", "']'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BPM", "SOUND", "NOTE", "LETTER", "INT", "DURATION", "DOUBLE", "ADD", 
		"SUB", "MUL", "DIV", "REM", "BIGR", "BIGE", "SMLR", "SMLE", "EQLS", "DIFS", 
		"ARROW", "OR", "ON", "IN", "AND", "COMMA", "COLON", "EQUAL", "PLAY", "EXCEPT", 
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
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			bpm();
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==INST_LIT) {
				{
				{
				setState(19);
				instAssign();
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(25);
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
	}

	public final BpmContext bpm() throws RecognitionException {
		BpmContext _localctx = new BpmContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_bpm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(BPM);
			setState(28);
			match(EQUAL);
			setState(29);
			match(INT);
			setState(30);
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
	}

	public final InstAssignContext instAssign() throws RecognitionException {
		InstAssignContext _localctx = new InstAssignContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_instAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(INST_LIT);
			setState(33);
			match(WORD);
			setState(34);
			match(COLON);
			setState(35);
			instrumentDef();
			setState(36);
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
		public NoteMapListContext noteMapList() {
			return getRuleContext(NoteMapListContext.class,0);
		}
		public InstrumentInheritanceListContext instrumentInheritanceList() {
			return getRuleContext(InstrumentInheritanceListContext.class,0);
		}
		public TerminalNode WORD() { return getToken(AuxinatorParser.WORD, 0); }
		public TerminalNode INT() { return getToken(AuxinatorParser.INT, 0); }
		public InstrumentDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrumentDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).enterInstrumentDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).exitInstrumentDef(this);
		}
	}

	public final InstrumentDefContext instrumentDef() throws RecognitionException {
		InstrumentDefContext _localctx = new InstrumentDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_instrumentDef);
		try {
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				noteMapList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				instrumentInheritanceList();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				match(WORD);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				match(INT);
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

	public static class NoteMapContext extends ParserRuleContext {
		public TerminalNode WORD() { return getToken(AuxinatorParser.WORD, 0); }
		public TerminalNode EQUAL() { return getToken(AuxinatorParser.EQUAL, 0); }
		public TerminalNode NOTE() { return getToken(AuxinatorParser.NOTE, 0); }
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
	}

	public final NoteMapContext noteMap() throws RecognitionException {
		NoteMapContext _localctx = new NoteMapContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_noteMap);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(WORD);
			setState(45);
			match(EQUAL);
			setState(46);
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

	public static class NoteMapListContext extends ParserRuleContext {
		public List<NoteMapContext> noteMap() {
			return getRuleContexts(NoteMapContext.class);
		}
		public NoteMapContext noteMap(int i) {
			return getRuleContext(NoteMapContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AuxinatorParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AuxinatorParser.COMMA, i);
		}
		public NoteMapListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteMapList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).enterNoteMapList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AuxinatorParserListener ) ((AuxinatorParserListener)listener).exitNoteMapList(this);
		}
	}

	public final NoteMapListContext noteMapList() throws RecognitionException {
		NoteMapListContext _localctx = new NoteMapListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_noteMapList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			noteMap();
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(49);
				match(COMMA);
				setState(50);
				noteMap();
				}
				}
				setState(55);
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
	}

	public final InstrumentInheritanceContext instrumentInheritance() throws RecognitionException {
		InstrumentInheritanceContext _localctx = new InstrumentInheritanceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_instrumentInheritance);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(56);
				match(NOTE);
				}
				break;
			case 2:
				{
				setState(57);
				noteRange();
				}
				break;
			}
			setState(60);
			match(ARROW);
			setState(61);
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
	}

	public final InstrumentInheritanceListContext instrumentInheritanceList() throws RecognitionException {
		InstrumentInheritanceListContext _localctx = new InstrumentInheritanceListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_instrumentInheritanceList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			instrumentInheritance();
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(64);
				match(COMMA);
				setState(65);
				instrumentInheritance();
				}
				}
				setState(70);
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
	}

	public final NoteRangeContext noteRange() throws RecognitionException {
		NoteRangeContext _localctx = new NoteRangeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_noteRange);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(NOTE);
			setState(72);
			match(SUB);
			setState(73);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/N\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\7\2\27"+
		"\n\2\f\2\16\2\32\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\5\5-\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\7\7\66\n\7\f"+
		"\7\16\79\13\7\3\b\3\b\5\b=\n\b\3\b\3\b\3\b\3\t\3\t\3\t\7\tE\n\t\f\t\16"+
		"\tH\13\t\3\n\3\n\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\2\2K\2\24\3"+
		"\2\2\2\4\35\3\2\2\2\6\"\3\2\2\2\b,\3\2\2\2\n.\3\2\2\2\f\62\3\2\2\2\16"+
		"<\3\2\2\2\20A\3\2\2\2\22I\3\2\2\2\24\30\5\4\3\2\25\27\5\6\4\2\26\25\3"+
		"\2\2\2\27\32\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\33\3\2\2\2\32\30\3"+
		"\2\2\2\33\34\7\2\2\3\34\3\3\2\2\2\35\36\7\3\2\2\36\37\7\34\2\2\37 \7\7"+
		"\2\2 !\7\37\2\2!\5\3\2\2\2\"#\7$\2\2#$\7,\2\2$%\7\33\2\2%&\5\b\5\2&\'"+
		"\7\37\2\2\'\7\3\2\2\2(-\5\f\7\2)-\5\20\t\2*-\7,\2\2+-\7\7\2\2,(\3\2\2"+
		"\2,)\3\2\2\2,*\3\2\2\2,+\3\2\2\2-\t\3\2\2\2./\7,\2\2/\60\7\34\2\2\60\61"+
		"\7\5\2\2\61\13\3\2\2\2\62\67\5\n\6\2\63\64\7\32\2\2\64\66\5\n\6\2\65\63"+
		"\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\r\3\2\2\29\67\3\2\2\2"+
		":=\7\5\2\2;=\5\22\n\2<:\3\2\2\2<;\3\2\2\2=>\3\2\2\2>?\7\25\2\2?@\7,\2"+
		"\2@\17\3\2\2\2AF\5\16\b\2BC\7\32\2\2CE\5\16\b\2DB\3\2\2\2EH\3\2\2\2FD"+
		"\3\2\2\2FG\3\2\2\2G\21\3\2\2\2HF\3\2\2\2IJ\7\5\2\2JK\7\13\2\2KL\7\5\2"+
		"\2L\23\3\2\2\2\7\30,\67<F";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}