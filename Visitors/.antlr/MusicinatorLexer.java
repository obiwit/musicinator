// Generated from /home/toms/Documents/lfaproj/lfa-1718-g12/Visitors/MusicinatorLexer.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MusicinatorLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"CHORD", "SOUND", "NOTE", "LETTER", "INT", "DURATION", "DOUBLE", "DIGIT", 
		"OCTAVE", "ADD", "SUB", "MUL", "DIV", "REM", "BIGR", "BIGE", "SMLR", "SMLE", 
		"EQLS", "DIFS", "ARROW", "ON", "IN", "AT", "BAR", "AND", "COMMA", "COLON", 
		"EQUAL", "LOOP", "PLAY", "TIMES", "AFTER", "SEMICOLON", "ALWAYS", "GETINT", 
		"SEQUENTIALLY", "IF", "ELSE", "ELIF", "FOR", "NUM_LIT", "SQ_LIT", "PF_LIT", 
		"INST_LIT", "OPEN_PR", "OPEN_SB", "OPEN_BR", "CLOSE_PR", "CLOSE_SB", "CLOSE_BR", 
		"WORD", "STRING", "LINE_COMMENT", "BLOCK_COMMENT", "WS"
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


	public MusicinatorLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MusicinatorLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\66\u018e\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\3\2\3\2\6\2w\n\2\r"+
		"\2\16\2x\3\2\5\2|\n\2\3\3\3\3\5\3\u0080\n\3\3\3\5\3\u0083\n\3\3\4\3\4"+
		"\7\4\u0087\n\4\f\4\16\4\u008a\13\4\3\4\5\4\u008d\n\4\3\5\3\5\3\6\6\6\u0092"+
		"\n\6\r\6\16\6\u0093\3\7\3\7\3\7\3\7\3\7\6\7\u009b\n\7\r\7\16\7\u009c\5"+
		"\7\u009f\n\7\3\b\3\b\3\b\7\b\u00a4\n\b\f\b\16\b\u00a7\13\b\5\b\u00a9\n"+
		"\b\3\b\3\b\5\b\u00ad\n\b\3\t\3\t\3\n\3\n\3\n\5\n\u00b4\n\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3"+
		"!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3$\3$\3$\3$\3$\3$\3$\3%\3"+
		"%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3"+
		"(\3(\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3"+
		",\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3"+
		".\3.\3.\3.\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3"+
		"\64\3\65\3\65\3\65\7\65\u0161\n\65\f\65\16\65\u0164\13\65\3\66\3\66\7"+
		"\66\u0168\n\66\f\66\16\66\u016b\13\66\3\66\3\66\3\67\3\67\3\67\3\67\7"+
		"\67\u0173\n\67\f\67\16\67\u0176\13\67\3\67\3\67\38\38\38\38\78\u017e\n"+
		"8\f8\168\u0181\138\38\38\38\38\38\39\69\u0189\n9\r9\169\u018a\39\39\4"+
		"\u0169\u017f\2:\3\3\5\4\7\2\t\2\13\5\r\6\17\7\21\2\23\2\25\b\27\t\31\n"+
		"\33\13\35\f\37\r!\16#\17%\20\'\21)\22+\23-\24/\25\61\26\63\27\65\30\67"+
		"\319\32;\33=\34?\35A\36C\37E G!I\"K#M$O%Q&S\'U(W)Y*[+],_-a.c/e\60g\61"+
		"i\62k\63m\64o\65q\66\3\2\n\4\2%%dd\3\2CI\3\2\62;\3\2\62:\3\2c|\5\2C\\"+
		"aac|\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u019c\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3"+
		"\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2"+
		"\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2"+
		"o\3\2\2\2\2q\3\2\2\2\3s\3\2\2\2\5\177\3\2\2\2\7\u0084\3\2\2\2\t\u008e"+
		"\3\2\2\2\13\u0091\3\2\2\2\r\u009e\3\2\2\2\17\u00ac\3\2\2\2\21\u00ae\3"+
		"\2\2\2\23\u00b3\3\2\2\2\25\u00b5\3\2\2\2\27\u00b7\3\2\2\2\31\u00b9\3\2"+
		"\2\2\33\u00bb\3\2\2\2\35\u00bd\3\2\2\2\37\u00bf\3\2\2\2!\u00c1\3\2\2\2"+
		"#\u00c4\3\2\2\2%\u00c6\3\2\2\2\'\u00c9\3\2\2\2)\u00cc\3\2\2\2+\u00cf\3"+
		"\2\2\2-\u00d2\3\2\2\2/\u00d5\3\2\2\2\61\u00d8\3\2\2\2\63\u00db\3\2\2\2"+
		"\65\u00dd\3\2\2\2\67\u00e1\3\2\2\29\u00e3\3\2\2\2;\u00e5\3\2\2\2=\u00e7"+
		"\3\2\2\2?\u00ec\3\2\2\2A\u00f1\3\2\2\2C\u00f7\3\2\2\2E\u00fd\3\2\2\2G"+
		"\u00ff\3\2\2\2I\u0106\3\2\2\2K\u010d\3\2\2\2M\u011a\3\2\2\2O\u011d\3\2"+
		"\2\2Q\u0122\3\2\2\2S\u0126\3\2\2\2U\u012a\3\2\2\2W\u0131\3\2\2\2Y\u013a"+
		"\3\2\2\2[\u0146\3\2\2\2]\u0151\3\2\2\2_\u0153\3\2\2\2a\u0155\3\2\2\2c"+
		"\u0157\3\2\2\2e\u0159\3\2\2\2g\u015b\3\2\2\2i\u015d\3\2\2\2k\u0165\3\2"+
		"\2\2m\u016e\3\2\2\2o\u0179\3\2\2\2q\u0188\3\2\2\2sv\5\7\4\2tu\7~\2\2u"+
		"w\5\7\4\2vt\3\2\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2z|\5\r\7\2"+
		"{z\3\2\2\2{|\3\2\2\2|\4\3\2\2\2}\u0080\5\7\4\2~\u0080\7T\2\2\177}\3\2"+
		"\2\2\177~\3\2\2\2\u0080\u0082\3\2\2\2\u0081\u0083\5\r\7\2\u0082\u0081"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\6\3\2\2\2\u0084\u0088\5\t\5\2\u0085"+
		"\u0087\t\2\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2"+
		"\2\2\u0088\u0089\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008b"+
		"\u008d\5\23\n\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\b\3\2\2"+
		"\2\u008e\u008f\t\3\2\2\u008f\n\3\2\2\2\u0090\u0092\5\21\t\2\u0091\u0090"+
		"\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\f\3\2\2\2\u0095\u0096\7}\2\2\u0096\u0097\5\17\b\2\u0097\u0098\7\177\2"+
		"\2\u0098\u009f\3\2\2\2\u0099\u009b\7)\2\2\u009a\u0099\3\2\2\2\u009b\u009c"+
		"\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e"+
		"\u0095\3\2\2\2\u009e\u009a\3\2\2\2\u009f\16\3\2\2\2\u00a0\u00a8\5\13\6"+
		"\2\u00a1\u00a5\7\60\2\2\u00a2\u00a4\5\13\6\2\u00a3\u00a2\3\2\2\2\u00a4"+
		"\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a9\3\2"+
		"\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a1\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9"+
		"\u00ad\3\2\2\2\u00aa\u00ab\7\60\2\2\u00ab\u00ad\5\13\6\2\u00ac\u00a0\3"+
		"\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\20\3\2\2\2\u00ae\u00af\t\4\2\2\u00af"+
		"\22\3\2\2\2\u00b0\u00b1\7/\2\2\u00b1\u00b4\7\63\2\2\u00b2\u00b4\t\5\2"+
		"\2\u00b3\u00b0\3\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\24\3\2\2\2\u00b5\u00b6"+
		"\7-\2\2\u00b6\26\3\2\2\2\u00b7\u00b8\7/\2\2\u00b8\30\3\2\2\2\u00b9\u00ba"+
		"\7,\2\2\u00ba\32\3\2\2\2\u00bb\u00bc\7\61\2\2\u00bc\34\3\2\2\2\u00bd\u00be"+
		"\7\'\2\2\u00be\36\3\2\2\2\u00bf\u00c0\7@\2\2\u00c0 \3\2\2\2\u00c1\u00c2"+
		"\7@\2\2\u00c2\u00c3\7?\2\2\u00c3\"\3\2\2\2\u00c4\u00c5\7>\2\2\u00c5$\3"+
		"\2\2\2\u00c6\u00c7\7>\2\2\u00c7\u00c8\7?\2\2\u00c8&\3\2\2\2\u00c9\u00ca"+
		"\7?\2\2\u00ca\u00cb\7?\2\2\u00cb(\3\2\2\2\u00cc\u00cd\7#\2\2\u00cd\u00ce"+
		"\7?\2\2\u00ce*\3\2\2\2\u00cf\u00d0\7/\2\2\u00d0\u00d1\7@\2\2\u00d1,\3"+
		"\2\2\2\u00d2\u00d3\7q\2\2\u00d3\u00d4\7p\2\2\u00d4.\3\2\2\2\u00d5\u00d6"+
		"\7k\2\2\u00d6\u00d7\7p\2\2\u00d7\60\3\2\2\2\u00d8\u00d9\7c\2\2\u00d9\u00da"+
		"\7v\2\2\u00da\62\3\2\2\2\u00db\u00dc\7~\2\2\u00dc\64\3\2\2\2\u00dd\u00de"+
		"\7c\2\2\u00de\u00df\7p\2\2\u00df\u00e0\7f\2\2\u00e0\66\3\2\2\2\u00e1\u00e2"+
		"\7.\2\2\u00e28\3\2\2\2\u00e3\u00e4\7<\2\2\u00e4:\3\2\2\2\u00e5\u00e6\7"+
		"?\2\2\u00e6<\3\2\2\2\u00e7\u00e8\7n\2\2\u00e8\u00e9\7q\2\2\u00e9\u00ea"+
		"\7q\2\2\u00ea\u00eb\7r\2\2\u00eb>\3\2\2\2\u00ec\u00ed\7r\2\2\u00ed\u00ee"+
		"\7n\2\2\u00ee\u00ef\7c\2\2\u00ef\u00f0\7{\2\2\u00f0@\3\2\2\2\u00f1\u00f2"+
		"\7v\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7o\2\2\u00f4\u00f5\7g\2\2\u00f5"+
		"\u00f6\7u\2\2\u00f6B\3\2\2\2\u00f7\u00f8\7c\2\2\u00f8\u00f9\7h\2\2\u00f9"+
		"\u00fa\7v\2\2\u00fa\u00fb\7g\2\2\u00fb\u00fc\7t\2\2\u00fcD\3\2\2\2\u00fd"+
		"\u00fe\7=\2\2\u00feF\3\2\2\2\u00ff\u0100\7c\2\2\u0100\u0101\7n\2\2\u0101"+
		"\u0102\7y\2\2\u0102\u0103\7c\2\2\u0103\u0104\7{\2\2\u0104\u0105\7u\2\2"+
		"\u0105H\3\2\2\2\u0106\u0107\7i\2\2\u0107\u0108\7g\2\2\u0108\u0109\7v\2"+
		"\2\u0109\u010a\7K\2\2\u010a\u010b\7p\2\2\u010b\u010c\7v\2\2\u010cJ\3\2"+
		"\2\2\u010d\u010e\7u\2\2\u010e\u010f\7g\2\2\u010f\u0110\7s\2\2\u0110\u0111"+
		"\7w\2\2\u0111\u0112\7g\2\2\u0112\u0113\7p\2\2\u0113\u0114\7v\2\2\u0114"+
		"\u0115\7k\2\2\u0115\u0116\7c\2\2\u0116\u0117\7n\2\2\u0117\u0118\7n\2\2"+
		"\u0118\u0119\7{\2\2\u0119L\3\2\2\2\u011a\u011b\7k\2\2\u011b\u011c\7h\2"+
		"\2\u011cN\3\2\2\2\u011d\u011e\7g\2\2\u011e\u011f\7n\2\2\u011f\u0120\7"+
		"u\2\2\u0120\u0121\7g\2\2\u0121P\3\2\2\2\u0122\u0123\5O(\2\u0123\u0124"+
		"\7\"\2\2\u0124\u0125\5M\'\2\u0125R\3\2\2\2\u0126\u0127\7h\2\2\u0127\u0128"+
		"\7q\2\2\u0128\u0129\7t\2\2\u0129T\3\2\2\2\u012a\u012b\7p\2\2\u012b\u012c"+
		"\7w\2\2\u012c\u012d\7o\2\2\u012d\u012e\7d\2\2\u012e\u012f\7g\2\2\u012f"+
		"\u0130\7t\2\2\u0130V\3\2\2\2\u0131\u0132\7u\2\2\u0132\u0133\7g\2\2\u0133"+
		"\u0134\7s\2\2\u0134\u0135\7w\2\2\u0135\u0136\7g\2\2\u0136\u0137\7p\2\2"+
		"\u0137\u0138\7e\2\2\u0138\u0139\7g\2\2\u0139X\3\2\2\2\u013a\u013b\7r\2"+
		"\2\u013b\u013c\7g\2\2\u013c\u013d\7t\2\2\u013d\u013e\7h\2\2\u013e\u013f"+
		"\7q\2\2\u013f\u0140\7t\2\2\u0140\u0141\7o\2\2\u0141\u0142\7c\2\2\u0142"+
		"\u0143\7p\2\2\u0143\u0144\7e\2\2\u0144\u0145\7g\2\2\u0145Z\3\2\2\2\u0146"+
		"\u0147\7k\2\2\u0147\u0148\7p\2\2\u0148\u0149\7u\2\2\u0149\u014a\7v\2\2"+
		"\u014a\u014b\7t\2\2\u014b\u014c\7w\2\2\u014c\u014d\7o\2\2\u014d\u014e"+
		"\7g\2\2\u014e\u014f\7p\2\2\u014f\u0150\7v\2\2\u0150\\\3\2\2\2\u0151\u0152"+
		"\7*\2\2\u0152^\3\2\2\2\u0153\u0154\7]\2\2\u0154`\3\2\2\2\u0155\u0156\7"+
		"}\2\2\u0156b\3\2\2\2\u0157\u0158\7+\2\2\u0158d\3\2\2\2\u0159\u015a\7_"+
		"\2\2\u015af\3\2\2\2\u015b\u015c\7\177\2\2\u015ch\3\2\2\2\u015d\u0162\t"+
		"\6\2\2\u015e\u0161\t\7\2\2\u015f\u0161\5\21\t\2\u0160\u015e\3\2\2\2\u0160"+
		"\u015f\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162\u0163\3\2"+
		"\2\2\u0163j\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0169\7$\2\2\u0166\u0168"+
		"\13\2\2\2\u0167\u0166\3\2\2\2\u0168\u016b\3\2\2\2\u0169\u016a\3\2\2\2"+
		"\u0169\u0167\3\2\2\2\u016a\u016c\3\2\2\2\u016b\u0169\3\2\2\2\u016c\u016d"+
		"\7$\2\2\u016dl\3\2\2\2\u016e\u016f\7\61\2\2\u016f\u0170\7\61\2\2\u0170"+
		"\u0174\3\2\2\2\u0171\u0173\n\b\2\2\u0172\u0171\3\2\2\2\u0173\u0176\3\2"+
		"\2\2\u0174\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0177\3\2\2\2\u0176"+
		"\u0174\3\2\2\2\u0177\u0178\b\67\2\2\u0178n\3\2\2\2\u0179\u017a\7\61\2"+
		"\2\u017a\u017b\7,\2\2\u017b\u017f\3\2\2\2\u017c\u017e\13\2\2\2\u017d\u017c"+
		"\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u0180\3\2\2\2\u017f\u017d\3\2\2\2\u0180"+
		"\u0182\3\2\2\2\u0181\u017f\3\2\2\2\u0182\u0183\7,\2\2\u0183\u0184\7\61"+
		"\2\2\u0184\u0185\3\2\2\2\u0185\u0186\b8\2\2\u0186p\3\2\2\2\u0187\u0189"+
		"\t\t\2\2\u0188\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u0188\3\2\2\2\u018a"+
		"\u018b\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018d\b9\2\2\u018dr\3\2\2\2\26"+
		"\2x{\177\u0082\u0088\u008c\u0093\u009c\u009e\u00a5\u00a8\u00ac\u00b3\u0160"+
		"\u0162\u0169\u0174\u017f\u018a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}