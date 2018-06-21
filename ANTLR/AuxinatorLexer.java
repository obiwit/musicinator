// Generated from AuxinatorLexer.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AuxinatorLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BPM", "SOUND", "NOTE", "LETTER", "INT", "DURATION", "DOUBLE", "DIGIT", 
		"OCTAVE", "ADD", "SUB", "MUL", "DIV", "REM", "BIGR", "BIGE", "SMLR", "SMLE", 
		"EQLS", "DIFS", "ARROW", "OR", "ON", "IN", "AND", "COMMA", "COLON", "EQUAL", 
		"PLAY", "EXCEPT", "SEMICOLON", "IF", "ELSE", "ELIF", "FOR", "INST_LIT", 
		"PF_LIT", "SQ_LIT", "NUM_LIT", "OPEN_SB", "CLOSE_SB", "OPEN_BR", "CLOSE_BR", 
		"WORD", "LINE_COMMENT", "BLOCK_COMMENT", "WS"
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


	public AuxinatorLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "AuxinatorLexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2/\u0148\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3\2\3\3\3\3\5\3h\n\3\3\3"+
		"\5\3k\n\3\3\3\3\3\7\3o\n\3\f\3\16\3r\13\3\3\4\3\4\7\4v\n\4\f\4\16\4y\13"+
		"\4\3\4\5\4|\n\4\3\5\3\5\3\6\6\6\u0081\n\6\r\6\16\6\u0082\3\7\3\7\3\7\3"+
		"\7\3\7\6\7\u008a\n\7\r\7\16\7\u008b\5\7\u008e\n\7\3\b\3\b\3\b\7\b\u0093"+
		"\n\b\f\b\16\b\u0096\13\b\5\b\u0098\n\b\3\b\3\b\5\b\u009c\n\b\3\t\3\t\3"+
		"\n\3\n\3\n\5\n\u00a3\n\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3\""+
		"\3#\3#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3("+
		"\3(\3(\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3-\7-\u0124\n-\f-\16-\u0127"+
		"\13-\3.\3.\3.\3.\7.\u012d\n.\f.\16.\u0130\13.\3.\3.\3/\3/\3/\3/\7/\u0138"+
		"\n/\f/\16/\u013b\13/\3/\3/\3/\3/\3/\3\60\6\60\u0143\n\60\r\60\16\60\u0144"+
		"\3\60\3\60\3\u0139\2\61\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\2\23\2\25\n\27"+
		"\13\31\f\33\r\35\16\37\17!\20#\21%\22\'\23)\24+\25-\26/\27\61\30\63\31"+
		"\65\32\67\339\34;\35=\36?\37A C!E\"G#I$K%M&O\'Q(S)U*W+Y,[-]._/\3\2\13"+
		"\4\2%%dd\3\2CI\3\2\62;\3\2\63\64\3\2\62:\4\2aac|\5\2C\\aac|\4\2\f\f\17"+
		"\17\5\2\13\f\17\17\"\"\2\u0156\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2"+
		"\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3"+
		"\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2"+
		"\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2"+
		";\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3"+
		"\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2"+
		"\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\3"+
		"a\3\2\2\2\5g\3\2\2\2\7s\3\2\2\2\t}\3\2\2\2\13\u0080\3\2\2\2\r\u008d\3"+
		"\2\2\2\17\u009b\3\2\2\2\21\u009d\3\2\2\2\23\u00a2\3\2\2\2\25\u00a4\3\2"+
		"\2\2\27\u00a6\3\2\2\2\31\u00a8\3\2\2\2\33\u00aa\3\2\2\2\35\u00ac\3\2\2"+
		"\2\37\u00ae\3\2\2\2!\u00b0\3\2\2\2#\u00b3\3\2\2\2%\u00b5\3\2\2\2\'\u00b8"+
		"\3\2\2\2)\u00bb\3\2\2\2+\u00be\3\2\2\2-\u00c1\3\2\2\2/\u00c3\3\2\2\2\61"+
		"\u00c6\3\2\2\2\63\u00c9\3\2\2\2\65\u00cd\3\2\2\2\67\u00cf\3\2\2\29\u00d1"+
		"\3\2\2\2;\u00d3\3\2\2\2=\u00d8\3\2\2\2?\u00df\3\2\2\2A\u00e1\3\2\2\2C"+
		"\u00e4\3\2\2\2E\u00e9\3\2\2\2G\u00ed\3\2\2\2I\u00f1\3\2\2\2K\u00fc\3\2"+
		"\2\2M\u0108\3\2\2\2O\u0111\3\2\2\2Q\u0118\3\2\2\2S\u011a\3\2\2\2U\u011c"+
		"\3\2\2\2W\u011e\3\2\2\2Y\u0120\3\2\2\2[\u0128\3\2\2\2]\u0133\3\2\2\2_"+
		"\u0142\3\2\2\2ab\7D\2\2bc\7R\2\2cd\7O\2\2d\4\3\2\2\2eh\5\7\4\2fh\7T\2"+
		"\2ge\3\2\2\2gf\3\2\2\2hj\3\2\2\2ik\5\r\7\2ji\3\2\2\2jk\3\2\2\2kp\3\2\2"+
		"\2lm\7~\2\2mo\5\5\3\2nl\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\6\3\2\2"+
		"\2rp\3\2\2\2sw\5\t\5\2tv\t\2\2\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2"+
		"\2x{\3\2\2\2yw\3\2\2\2z|\5\23\n\2{z\3\2\2\2{|\3\2\2\2|\b\3\2\2\2}~\t\3"+
		"\2\2~\n\3\2\2\2\177\u0081\5\21\t\2\u0080\177\3\2\2\2\u0081\u0082\3\2\2"+
		"\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\f\3\2\2\2\u0084\u0085"+
		"\7}\2\2\u0085\u0086\5\17\b\2\u0086\u0087\7\177\2\2\u0087\u008e\3\2\2\2"+
		"\u0088\u008a\7)\2\2\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089"+
		"\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u0084\3\2\2\2\u008d"+
		"\u0089\3\2\2\2\u008e\16\3\2\2\2\u008f\u0097\5\13\6\2\u0090\u0094\7\60"+
		"\2\2\u0091\u0093\5\13\6\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094"+
		"\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2"+
		"\2\2\u0097\u0090\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009c\3\2\2\2\u0099"+
		"\u009a\7\60\2\2\u009a\u009c\5\13\6\2\u009b\u008f\3\2\2\2\u009b\u0099\3"+
		"\2\2\2\u009c\20\3\2\2\2\u009d\u009e\t\4\2\2\u009e\22\3\2\2\2\u009f\u00a0"+
		"\7/\2\2\u00a0\u00a3\t\5\2\2\u00a1\u00a3\t\6\2\2\u00a2\u009f\3\2\2\2\u00a2"+
		"\u00a1\3\2\2\2\u00a3\24\3\2\2\2\u00a4\u00a5\7-\2\2\u00a5\26\3\2\2\2\u00a6"+
		"\u00a7\7/\2\2\u00a7\30\3\2\2\2\u00a8\u00a9\7,\2\2\u00a9\32\3\2\2\2\u00aa"+
		"\u00ab\7\61\2\2\u00ab\34\3\2\2\2\u00ac\u00ad\7\'\2\2\u00ad\36\3\2\2\2"+
		"\u00ae\u00af\7@\2\2\u00af \3\2\2\2\u00b0\u00b1\7@\2\2\u00b1\u00b2\7?\2"+
		"\2\u00b2\"\3\2\2\2\u00b3\u00b4\7>\2\2\u00b4$\3\2\2\2\u00b5\u00b6\7>\2"+
		"\2\u00b6\u00b7\7?\2\2\u00b7&\3\2\2\2\u00b8\u00b9\7?\2\2\u00b9\u00ba\7"+
		"?\2\2\u00ba(\3\2\2\2\u00bb\u00bc\7#\2\2\u00bc\u00bd\7?\2\2\u00bd*\3\2"+
		"\2\2\u00be\u00bf\7/\2\2\u00bf\u00c0\7@\2\2\u00c0,\3\2\2\2\u00c1\u00c2"+
		"\7~\2\2\u00c2.\3\2\2\2\u00c3\u00c4\7q\2\2\u00c4\u00c5\7p\2\2\u00c5\60"+
		"\3\2\2\2\u00c6\u00c7\7k\2\2\u00c7\u00c8\7p\2\2\u00c8\62\3\2\2\2\u00c9"+
		"\u00ca\7c\2\2\u00ca\u00cb\7p\2\2\u00cb\u00cc\7f\2\2\u00cc\64\3\2\2\2\u00cd"+
		"\u00ce\7.\2\2\u00ce\66\3\2\2\2\u00cf\u00d0\7<\2\2\u00d08\3\2\2\2\u00d1"+
		"\u00d2\7?\2\2\u00d2:\3\2\2\2\u00d3\u00d4\7r\2\2\u00d4\u00d5\7n\2\2\u00d5"+
		"\u00d6\7c\2\2\u00d6\u00d7\7{\2\2\u00d7<\3\2\2\2\u00d8\u00d9\7g\2\2\u00d9"+
		"\u00da\7z\2\2\u00da\u00db\7e\2\2\u00db\u00dc\7g\2\2\u00dc\u00dd\7r\2\2"+
		"\u00dd\u00de\7v\2\2\u00de>\3\2\2\2\u00df\u00e0\7=\2\2\u00e0@\3\2\2\2\u00e1"+
		"\u00e2\7k\2\2\u00e2\u00e3\7h\2\2\u00e3B\3\2\2\2\u00e4\u00e5\7g\2\2\u00e5"+
		"\u00e6\7n\2\2\u00e6\u00e7\7u\2\2\u00e7\u00e8\7g\2\2\u00e8D\3\2\2\2\u00e9"+
		"\u00ea\5C\"\2\u00ea\u00eb\7\"\2\2\u00eb\u00ec\5A!\2\u00ecF\3\2\2\2\u00ed"+
		"\u00ee\7h\2\2\u00ee\u00ef\7q\2\2\u00ef\u00f0\7t\2\2\u00f0H\3\2\2\2\u00f1"+
		"\u00f2\7k\2\2\u00f2\u00f3\7p\2\2\u00f3\u00f4\7u\2\2\u00f4\u00f5\7v\2\2"+
		"\u00f5\u00f6\7t\2\2\u00f6\u00f7\7w\2\2\u00f7\u00f8\7o\2\2\u00f8\u00f9"+
		"\7g\2\2\u00f9\u00fa\7p\2\2\u00fa\u00fb\7v\2\2\u00fbJ\3\2\2\2\u00fc\u00fd"+
		"\7r\2\2\u00fd\u00fe\7g\2\2\u00fe\u00ff\7t\2\2\u00ff\u0100\7h\2\2\u0100"+
		"\u0101\7q\2\2\u0101\u0102\7t\2\2\u0102\u0103\7o\2\2\u0103\u0104\7c\2\2"+
		"\u0104\u0105\7p\2\2\u0105\u0106\7e\2\2\u0106\u0107\7g\2\2\u0107L\3\2\2"+
		"\2\u0108\u0109\7u\2\2\u0109\u010a\7g\2\2\u010a\u010b\7s\2\2\u010b\u010c"+
		"\7w\2\2\u010c\u010d\7g\2\2\u010d\u010e\7p\2\2\u010e\u010f\7e\2\2\u010f"+
		"\u0110\7g\2\2\u0110N\3\2\2\2\u0111\u0112\7p\2\2\u0112\u0113\7w\2\2\u0113"+
		"\u0114\7o\2\2\u0114\u0115\7d\2\2\u0115\u0116\7g\2\2\u0116\u0117\7t\2\2"+
		"\u0117P\3\2\2\2\u0118\u0119\7]\2\2\u0119R\3\2\2\2\u011a\u011b\7_\2\2\u011b"+
		"T\3\2\2\2\u011c\u011d\7}\2\2\u011dV\3\2\2\2\u011e\u011f\7\177\2\2\u011f"+
		"X\3\2\2\2\u0120\u0125\t\7\2\2\u0121\u0124\t\b\2\2\u0122\u0124\5\21\t\2"+
		"\u0123\u0121\3\2\2\2\u0123\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123"+
		"\3\2\2\2\u0125\u0126\3\2\2\2\u0126Z\3\2\2\2\u0127\u0125\3\2\2\2\u0128"+
		"\u0129\7\61\2\2\u0129\u012a\7\61\2\2\u012a\u012e\3\2\2\2\u012b\u012d\n"+
		"\t\2\2\u012c\u012b\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e"+
		"\u012f\3\2\2\2\u012f\u0131\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0132\b."+
		"\2\2\u0132\\\3\2\2\2\u0133\u0134\7\61\2\2\u0134\u0135\7,\2\2\u0135\u0139"+
		"\3\2\2\2\u0136\u0138\13\2\2\2\u0137\u0136\3\2\2\2\u0138\u013b\3\2\2\2"+
		"\u0139\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a\u013c\3\2\2\2\u013b\u0139"+
		"\3\2\2\2\u013c\u013d\7,\2\2\u013d\u013e\7\61\2\2\u013e\u013f\3\2\2\2\u013f"+
		"\u0140\b/\2\2\u0140^\3\2\2\2\u0141\u0143\t\n\2\2\u0142\u0141\3\2\2\2\u0143"+
		"\u0144\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0146\3\2"+
		"\2\2\u0146\u0147\b\60\2\2\u0147`\3\2\2\2\24\2gjpw{\u0082\u008b\u008d\u0094"+
		"\u0097\u009b\u00a2\u0123\u0125\u012e\u0139\u0144\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}