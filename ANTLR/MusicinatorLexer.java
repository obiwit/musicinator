// Generated from MusicinatorLexer.g4 by ANTLR 4.7.1
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
		SOUND=1, NOTE=2, LETTER=3, INT=4, DURATION=5, DOUBLE=6, ADD=7, SUB=8, 
		MUL=9, DIV=10, REM=11, BIGR=12, BIGE=13, SMLR=14, SMLE=15, EQLS=16, DIFS=17, 
		ARROW=18, OR=19, ON=20, IN=21, AND=22, COMMA=23, COLON=24, EQUAL=25, PLAY=26, 
		EXCEPT=27, SEMICOLON=28, IF=29, ELSE=30, ELIF=31, FOR=32, INST_LIT=33, 
		PF_LIT=34, SQ_LIT=35, NUM_LIT=36, OPEN_SB=37, CLOSE_SB=38, OPEN_BR=39, 
		CLOSE_BR=40, WORD=41, LINE_COMMENT=42, BLOCK_COMMENT=43, WS=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"SOUND", "NOTE", "LETTER", "INT", "DURATION", "DOUBLE", "DIGIT", "OCTAVE", 
		"ADD", "SUB", "MUL", "DIV", "REM", "BIGR", "BIGE", "SMLR", "SMLE", "EQLS", 
		"DIFS", "ARROW", "OR", "ON", "IN", "AND", "COMMA", "COLON", "EQUAL", "PLAY", 
		"EXCEPT", "SEMICOLON", "IF", "ELSE", "ELIF", "FOR", "INST_LIT", "PF_LIT", 
		"SQ_LIT", "NUM_LIT", "OPEN_SB", "CLOSE_SB", "OPEN_BR", "CLOSE_BR", "WORD", 
		"LINE_COMMENT", "BLOCK_COMMENT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u0142\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\5\2b\n\2\3\2\5\2e\n\2\3\2\3\2\7\2i\n\2"+
		"\f\2\16\2l\13\2\3\3\3\3\7\3p\n\3\f\3\16\3s\13\3\3\3\5\3v\n\3\3\4\3\4\3"+
		"\5\6\5{\n\5\r\5\16\5|\3\6\3\6\3\6\3\6\3\6\6\6\u0084\n\6\r\6\16\6\u0085"+
		"\5\6\u0088\n\6\3\7\3\7\3\7\7\7\u008d\n\7\f\7\16\7\u0090\13\7\5\7\u0092"+
		"\n\7\3\7\3\7\5\7\u0096\n\7\3\b\3\b\3\t\3\t\3\t\5\t\u009d\n\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3"+
		"&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3"+
		"+\3,\3,\3,\7,\u011e\n,\f,\16,\u0121\13,\3-\3-\3-\3-\7-\u0127\n-\f-\16"+
		"-\u012a\13-\3-\3-\3.\3.\3.\3.\7.\u0132\n.\f.\16.\u0135\13.\3.\3.\3.\3"+
		".\3.\3/\6/\u013d\n/\r/\16/\u013e\3/\3/\3\u0133\2\60\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\2\21\2\23\t\25\n\27\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23"+
		")\24+\25-\26/\27\61\30\63\31\65\32\67\339\34;\35=\36?\37A C!E\"G#I$K%"+
		"M&O\'Q(S)U*W+Y,[-].\3\2\13\4\2%%dd\3\2CI\3\2\62;\3\2\63\64\3\2\62:\4\2"+
		"aac|\5\2C\\aac|\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u0150\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2"+
		"\2\2]\3\2\2\2\3a\3\2\2\2\5m\3\2\2\2\7w\3\2\2\2\tz\3\2\2\2\13\u0087\3\2"+
		"\2\2\r\u0095\3\2\2\2\17\u0097\3\2\2\2\21\u009c\3\2\2\2\23\u009e\3\2\2"+
		"\2\25\u00a0\3\2\2\2\27\u00a2\3\2\2\2\31\u00a4\3\2\2\2\33\u00a6\3\2\2\2"+
		"\35\u00a8\3\2\2\2\37\u00aa\3\2\2\2!\u00ad\3\2\2\2#\u00af\3\2\2\2%\u00b2"+
		"\3\2\2\2\'\u00b5\3\2\2\2)\u00b8\3\2\2\2+\u00bb\3\2\2\2-\u00bd\3\2\2\2"+
		"/\u00c0\3\2\2\2\61\u00c3\3\2\2\2\63\u00c7\3\2\2\2\65\u00c9\3\2\2\2\67"+
		"\u00cb\3\2\2\29\u00cd\3\2\2\2;\u00d2\3\2\2\2=\u00d9\3\2\2\2?\u00db\3\2"+
		"\2\2A\u00de\3\2\2\2C\u00e3\3\2\2\2E\u00e7\3\2\2\2G\u00eb\3\2\2\2I\u00f6"+
		"\3\2\2\2K\u0102\3\2\2\2M\u010b\3\2\2\2O\u0112\3\2\2\2Q\u0114\3\2\2\2S"+
		"\u0116\3\2\2\2U\u0118\3\2\2\2W\u011a\3\2\2\2Y\u0122\3\2\2\2[\u012d\3\2"+
		"\2\2]\u013c\3\2\2\2_b\5\5\3\2`b\7T\2\2a_\3\2\2\2a`\3\2\2\2bd\3\2\2\2c"+
		"e\5\13\6\2dc\3\2\2\2de\3\2\2\2ej\3\2\2\2fg\7~\2\2gi\5\3\2\2hf\3\2\2\2"+
		"il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\4\3\2\2\2lj\3\2\2\2mq\5\7\4\2np\t\2\2"+
		"\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2ru\3\2\2\2sq\3\2\2\2tv\5\21"+
		"\t\2ut\3\2\2\2uv\3\2\2\2v\6\3\2\2\2wx\t\3\2\2x\b\3\2\2\2y{\5\17\b\2zy"+
		"\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\n\3\2\2\2~\177\7}\2\2\177\u0080"+
		"\5\r\7\2\u0080\u0081\7\177\2\2\u0081\u0088\3\2\2\2\u0082\u0084\7)\2\2"+
		"\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086"+
		"\3\2\2\2\u0086\u0088\3\2\2\2\u0087~\3\2\2\2\u0087\u0083\3\2\2\2\u0088"+
		"\f\3\2\2\2\u0089\u0091\5\t\5\2\u008a\u008e\7\60\2\2\u008b\u008d\5\t\5"+
		"\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f"+
		"\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u008a\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0096\3\2\2\2\u0093\u0094\7\60\2\2\u0094\u0096\5"+
		"\t\5\2\u0095\u0089\3\2\2\2\u0095\u0093\3\2\2\2\u0096\16\3\2\2\2\u0097"+
		"\u0098\t\4\2\2\u0098\20\3\2\2\2\u0099\u009a\7/\2\2\u009a\u009d\t\5\2\2"+
		"\u009b\u009d\t\6\2\2\u009c\u0099\3\2\2\2\u009c\u009b\3\2\2\2\u009d\22"+
		"\3\2\2\2\u009e\u009f\7-\2\2\u009f\24\3\2\2\2\u00a0\u00a1\7/\2\2\u00a1"+
		"\26\3\2\2\2\u00a2\u00a3\7,\2\2\u00a3\30\3\2\2\2\u00a4\u00a5\7\61\2\2\u00a5"+
		"\32\3\2\2\2\u00a6\u00a7\7\'\2\2\u00a7\34\3\2\2\2\u00a8\u00a9\7@\2\2\u00a9"+
		"\36\3\2\2\2\u00aa\u00ab\7@\2\2\u00ab\u00ac\7?\2\2\u00ac \3\2\2\2\u00ad"+
		"\u00ae\7>\2\2\u00ae\"\3\2\2\2\u00af\u00b0\7>\2\2\u00b0\u00b1\7?\2\2\u00b1"+
		"$\3\2\2\2\u00b2\u00b3\7?\2\2\u00b3\u00b4\7?\2\2\u00b4&\3\2\2\2\u00b5\u00b6"+
		"\7#\2\2\u00b6\u00b7\7?\2\2\u00b7(\3\2\2\2\u00b8\u00b9\7/\2\2\u00b9\u00ba"+
		"\7@\2\2\u00ba*\3\2\2\2\u00bb\u00bc\7~\2\2\u00bc,\3\2\2\2\u00bd\u00be\7"+
		"q\2\2\u00be\u00bf\7p\2\2\u00bf.\3\2\2\2\u00c0\u00c1\7k\2\2\u00c1\u00c2"+
		"\7p\2\2\u00c2\60\3\2\2\2\u00c3\u00c4\7c\2\2\u00c4\u00c5\7p\2\2\u00c5\u00c6"+
		"\7f\2\2\u00c6\62\3\2\2\2\u00c7\u00c8\7.\2\2\u00c8\64\3\2\2\2\u00c9\u00ca"+
		"\7<\2\2\u00ca\66\3\2\2\2\u00cb\u00cc\7?\2\2\u00cc8\3\2\2\2\u00cd\u00ce"+
		"\7r\2\2\u00ce\u00cf\7n\2\2\u00cf\u00d0\7c\2\2\u00d0\u00d1\7{\2\2\u00d1"+
		":\3\2\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4\7z\2\2\u00d4\u00d5\7e\2\2\u00d5"+
		"\u00d6\7g\2\2\u00d6\u00d7\7r\2\2\u00d7\u00d8\7v\2\2\u00d8<\3\2\2\2\u00d9"+
		"\u00da\7=\2\2\u00da>\3\2\2\2\u00db\u00dc\7k\2\2\u00dc\u00dd\7h\2\2\u00dd"+
		"@\3\2\2\2\u00de\u00df\7g\2\2\u00df\u00e0\7n\2\2\u00e0\u00e1\7u\2\2\u00e1"+
		"\u00e2\7g\2\2\u00e2B\3\2\2\2\u00e3\u00e4\5A!\2\u00e4\u00e5\7\"\2\2\u00e5"+
		"\u00e6\5? \2\u00e6D\3\2\2\2\u00e7\u00e8\7h\2\2\u00e8\u00e9\7q\2\2\u00e9"+
		"\u00ea\7t\2\2\u00eaF\3\2\2\2\u00eb\u00ec\7k\2\2\u00ec\u00ed\7p\2\2\u00ed"+
		"\u00ee\7u\2\2\u00ee\u00ef\7v\2\2\u00ef\u00f0\7t\2\2\u00f0\u00f1\7w\2\2"+
		"\u00f1\u00f2\7o\2\2\u00f2\u00f3\7g\2\2\u00f3\u00f4\7p\2\2\u00f4\u00f5"+
		"\7v\2\2\u00f5H\3\2\2\2\u00f6\u00f7\7r\2\2\u00f7\u00f8\7g\2\2\u00f8\u00f9"+
		"\7t\2\2\u00f9\u00fa\7h\2\2\u00fa\u00fb\7q\2\2\u00fb\u00fc\7t\2\2\u00fc"+
		"\u00fd\7o\2\2\u00fd\u00fe\7c\2\2\u00fe\u00ff\7p\2\2\u00ff\u0100\7e\2\2"+
		"\u0100\u0101\7g\2\2\u0101J\3\2\2\2\u0102\u0103\7u\2\2\u0103\u0104\7g\2"+
		"\2\u0104\u0105\7s\2\2\u0105\u0106\7w\2\2\u0106\u0107\7g\2\2\u0107\u0108"+
		"\7p\2\2\u0108\u0109\7e\2\2\u0109\u010a\7g\2\2\u010aL\3\2\2\2\u010b\u010c"+
		"\7p\2\2\u010c\u010d\7w\2\2\u010d\u010e\7o\2\2\u010e\u010f\7d\2\2\u010f"+
		"\u0110\7g\2\2\u0110\u0111\7t\2\2\u0111N\3\2\2\2\u0112\u0113\7]\2\2\u0113"+
		"P\3\2\2\2\u0114\u0115\7_\2\2\u0115R\3\2\2\2\u0116\u0117\7}\2\2\u0117T"+
		"\3\2\2\2\u0118\u0119\7\177\2\2\u0119V\3\2\2\2\u011a\u011f\t\7\2\2\u011b"+
		"\u011e\t\b\2\2\u011c\u011e\5\17\b\2\u011d\u011b\3\2\2\2\u011d\u011c\3"+
		"\2\2\2\u011e\u0121\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120"+
		"X\3\2\2\2\u0121\u011f\3\2\2\2\u0122\u0123\7\61\2\2\u0123\u0124\7\61\2"+
		"\2\u0124\u0128\3\2\2\2\u0125\u0127\n\t\2\2\u0126\u0125\3\2\2\2\u0127\u012a"+
		"\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012b\3\2\2\2\u012a"+
		"\u0128\3\2\2\2\u012b\u012c\b-\2\2\u012cZ\3\2\2\2\u012d\u012e\7\61\2\2"+
		"\u012e\u012f\7,\2\2\u012f\u0133\3\2\2\2\u0130\u0132\13\2\2\2\u0131\u0130"+
		"\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0134\3\2\2\2\u0133\u0131\3\2\2\2\u0134"+
		"\u0136\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u0137\7,\2\2\u0137\u0138\7\61"+
		"\2\2\u0138\u0139\3\2\2\2\u0139\u013a\b.\2\2\u013a\\\3\2\2\2\u013b\u013d"+
		"\t\n\2\2\u013c\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013c\3\2\2\2\u013e"+
		"\u013f\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141\b/\2\2\u0141^\3\2\2\2\24"+
		"\2adjqu|\u0085\u0087\u008e\u0091\u0095\u009c\u011d\u011f\u0128\u0133\u013e"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}