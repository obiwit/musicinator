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
		BPM=1, NOTE=2, CHORD=3, SOUND=4, INT=5, DURATION=6, DOUBLE=7, ADD=8, SUB=9, 
		MUL=10, DIV=11, REM=12, BIGR=13, BIGE=14, SMLR=15, SMLE=16, EQLS=17, DIFS=18, 
		ARROW=19, ON=20, IN=21, AT=22, BAR=23, AND=24, COMMA=25, COLON=26, EQUAL=27, 
		LOOP=28, PLAY=29, TIMES=30, AFTER=31, SEMICOLON=32, ALWAYS=33, GETINT=34, 
		SEQUENTIALLY=35, IF=36, ELSE=37, ELIF=38, FOR=39, NUM_LIT=40, SQ_LIT=41, 
		PF_LIT=42, INST_LIT=43, OPEN_PR=44, OPEN_SB=45, OPEN_BR=46, CLOSE_PR=47, 
		CLOSE_SB=48, CLOSE_BR=49, WORD=50, STRING=51, LINE_COMMENT=52, BLOCK_COMMENT=53, 
		WS=54;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BPM", "NOTE", "CHORD", "SOUND", "LETTER", "INT", "DURATION", "DOUBLE", 
		"DIGIT", "OCTAVE", "ADD", "SUB", "MUL", "DIV", "REM", "BIGR", "BIGE", 
		"SMLR", "SMLE", "EQLS", "DIFS", "ARROW", "ON", "IN", "AT", "BAR", "AND", 
		"COMMA", "COLON", "EQUAL", "LOOP", "PLAY", "TIMES", "AFTER", "SEMICOLON", 
		"ALWAYS", "GETINT", "SEQUENTIALLY", "IF", "ELSE", "ELIF", "FOR", "NUM_LIT", 
		"SQ_LIT", "PF_LIT", "INST_LIT", "OPEN_PR", "OPEN_SB", "OPEN_BR", "CLOSE_PR", 
		"CLOSE_SB", "CLOSE_BR", "WORD", "STRING", "LINE_COMMENT", "BLOCK_COMMENT", 
		"WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\28\u0194\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\7\3|\n\3\f\3\16\3\177\13\3\3\3\5\3\u0082\n\3\3\4\3\4\3\4\6\4\u0087"+
		"\n\4\r\4\16\4\u0088\3\4\5\4\u008c\n\4\3\5\3\5\5\5\u0090\n\5\3\5\5\5\u0093"+
		"\n\5\3\6\3\6\3\7\6\7\u0098\n\7\r\7\16\7\u0099\3\b\3\b\3\b\3\b\3\b\6\b"+
		"\u00a1\n\b\r\b\16\b\u00a2\5\b\u00a5\n\b\3\t\3\t\3\t\7\t\u00aa\n\t\f\t"+
		"\16\t\u00ad\13\t\5\t\u00af\n\t\3\t\3\t\5\t\u00b3\n\t\3\n\3\n\3\13\3\13"+
		"\3\13\5\13\u00ba\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3"+
		"\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3"+
		" \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3"+
		"%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3"+
		"+\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3"+
		".\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\61\3\61"+
		"\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\66\7\66\u0167\n\66"+
		"\f\66\16\66\u016a\13\66\3\67\3\67\7\67\u016e\n\67\f\67\16\67\u0171\13"+
		"\67\3\67\3\67\38\38\38\38\78\u0179\n8\f8\168\u017c\138\38\38\39\39\39"+
		"\39\79\u0184\n9\f9\169\u0187\139\39\39\39\39\39\3:\6:\u018f\n:\r:\16:"+
		"\u0190\3:\3:\4\u016f\u0185\2;\3\3\5\4\7\5\t\6\13\2\r\7\17\b\21\t\23\2"+
		"\25\2\27\n\31\13\33\f\35\r\37\16!\17#\20%\21\'\22)\23+\24-\25/\26\61\27"+
		"\63\30\65\31\67\329\33;\34=\35?\36A\37C E!G\"I#K$M%O&Q\'S(U)W*Y+[,]-_"+
		".a/c\60e\61g\62i\63k\64m\65o\66q\67s8\3\2\n\4\2%%dd\3\2CI\3\2\62;\3\2"+
		"\62:\3\2c|\5\2C\\aac|\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u01a3\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3"+
		"\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2"+
		"\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\3u\3\2\2\2\5"+
		"y\3\2\2\2\7\u0083\3\2\2\2\t\u008f\3\2\2\2\13\u0094\3\2\2\2\r\u0097\3\2"+
		"\2\2\17\u00a4\3\2\2\2\21\u00b2\3\2\2\2\23\u00b4\3\2\2\2\25\u00b9\3\2\2"+
		"\2\27\u00bb\3\2\2\2\31\u00bd\3\2\2\2\33\u00bf\3\2\2\2\35\u00c1\3\2\2\2"+
		"\37\u00c3\3\2\2\2!\u00c5\3\2\2\2#\u00c7\3\2\2\2%\u00ca\3\2\2\2\'\u00cc"+
		"\3\2\2\2)\u00cf\3\2\2\2+\u00d2\3\2\2\2-\u00d5\3\2\2\2/\u00d8\3\2\2\2\61"+
		"\u00db\3\2\2\2\63\u00de\3\2\2\2\65\u00e1\3\2\2\2\67\u00e3\3\2\2\29\u00e7"+
		"\3\2\2\2;\u00e9\3\2\2\2=\u00eb\3\2\2\2?\u00ed\3\2\2\2A\u00f2\3\2\2\2C"+
		"\u00f7\3\2\2\2E\u00fd\3\2\2\2G\u0103\3\2\2\2I\u0105\3\2\2\2K\u010c\3\2"+
		"\2\2M\u0113\3\2\2\2O\u0120\3\2\2\2Q\u0123\3\2\2\2S\u0128\3\2\2\2U\u012c"+
		"\3\2\2\2W\u0130\3\2\2\2Y\u0137\3\2\2\2[\u0140\3\2\2\2]\u014c\3\2\2\2_"+
		"\u0157\3\2\2\2a\u0159\3\2\2\2c\u015b\3\2\2\2e\u015d\3\2\2\2g\u015f\3\2"+
		"\2\2i\u0161\3\2\2\2k\u0163\3\2\2\2m\u016b\3\2\2\2o\u0174\3\2\2\2q\u017f"+
		"\3\2\2\2s\u018e\3\2\2\2uv\7D\2\2vw\7R\2\2wx\7O\2\2x\4\3\2\2\2y}\5\13\6"+
		"\2z|\t\2\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0081\3\2\2\2"+
		"\177}\3\2\2\2\u0080\u0082\5\25\13\2\u0081\u0080\3\2\2\2\u0081\u0082\3"+
		"\2\2\2\u0082\6\3\2\2\2\u0083\u0086\5\5\3\2\u0084\u0085\7~\2\2\u0085\u0087"+
		"\5\5\3\2\u0086\u0084\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u008c\5\17\b\2\u008b\u008a\3"+
		"\2\2\2\u008b\u008c\3\2\2\2\u008c\b\3\2\2\2\u008d\u0090\5\5\3\2\u008e\u0090"+
		"\7T\2\2\u008f\u008d\3\2\2\2\u008f\u008e\3\2\2\2\u0090\u0092\3\2\2\2\u0091"+
		"\u0093\5\17\b\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\n\3\2\2"+
		"\2\u0094\u0095\t\3\2\2\u0095\f\3\2\2\2\u0096\u0098\5\23\n\2\u0097\u0096"+
		"\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\16\3\2\2\2\u009b\u009c\7}\2\2\u009c\u009d\5\21\t\2\u009d\u009e\7\177"+
		"\2\2\u009e\u00a5\3\2\2\2\u009f\u00a1\7)\2\2\u00a0\u009f\3\2\2\2\u00a1"+
		"\u00a2\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\3\2"+
		"\2\2\u00a4\u009b\3\2\2\2\u00a4\u00a0\3\2\2\2\u00a5\20\3\2\2\2\u00a6\u00ae"+
		"\5\r\7\2\u00a7\u00ab\7\60\2\2\u00a8\u00aa\5\r\7\2\u00a9\u00a8\3\2\2\2"+
		"\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00af"+
		"\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00a7\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\u00b3\3\2\2\2\u00b0\u00b1\7\60\2\2\u00b1\u00b3\5\r\7\2\u00b2\u00a6\3"+
		"\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\22\3\2\2\2\u00b4\u00b5\t\4\2\2\u00b5"+
		"\24\3\2\2\2\u00b6\u00b7\7/\2\2\u00b7\u00ba\7\63\2\2\u00b8\u00ba\t\5\2"+
		"\2\u00b9\u00b6\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba\26\3\2\2\2\u00bb\u00bc"+
		"\7-\2\2\u00bc\30\3\2\2\2\u00bd\u00be\7/\2\2\u00be\32\3\2\2\2\u00bf\u00c0"+
		"\7,\2\2\u00c0\34\3\2\2\2\u00c1\u00c2\7\61\2\2\u00c2\36\3\2\2\2\u00c3\u00c4"+
		"\7\'\2\2\u00c4 \3\2\2\2\u00c5\u00c6\7@\2\2\u00c6\"\3\2\2\2\u00c7\u00c8"+
		"\7@\2\2\u00c8\u00c9\7?\2\2\u00c9$\3\2\2\2\u00ca\u00cb\7>\2\2\u00cb&\3"+
		"\2\2\2\u00cc\u00cd\7>\2\2\u00cd\u00ce\7?\2\2\u00ce(\3\2\2\2\u00cf\u00d0"+
		"\7?\2\2\u00d0\u00d1\7?\2\2\u00d1*\3\2\2\2\u00d2\u00d3\7#\2\2\u00d3\u00d4"+
		"\7?\2\2\u00d4,\3\2\2\2\u00d5\u00d6\7/\2\2\u00d6\u00d7\7@\2\2\u00d7.\3"+
		"\2\2\2\u00d8\u00d9\7q\2\2\u00d9\u00da\7p\2\2\u00da\60\3\2\2\2\u00db\u00dc"+
		"\7k\2\2\u00dc\u00dd\7p\2\2\u00dd\62\3\2\2\2\u00de\u00df\7c\2\2\u00df\u00e0"+
		"\7v\2\2\u00e0\64\3\2\2\2\u00e1\u00e2\7~\2\2\u00e2\66\3\2\2\2\u00e3\u00e4"+
		"\7c\2\2\u00e4\u00e5\7p\2\2\u00e5\u00e6\7f\2\2\u00e68\3\2\2\2\u00e7\u00e8"+
		"\7.\2\2\u00e8:\3\2\2\2\u00e9\u00ea\7<\2\2\u00ea<\3\2\2\2\u00eb\u00ec\7"+
		"?\2\2\u00ec>\3\2\2\2\u00ed\u00ee\7n\2\2\u00ee\u00ef\7q\2\2\u00ef\u00f0"+
		"\7q\2\2\u00f0\u00f1\7r\2\2\u00f1@\3\2\2\2\u00f2\u00f3\7r\2\2\u00f3\u00f4"+
		"\7n\2\2\u00f4\u00f5\7c\2\2\u00f5\u00f6\7{\2\2\u00f6B\3\2\2\2\u00f7\u00f8"+
		"\7v\2\2\u00f8\u00f9\7k\2\2\u00f9\u00fa\7o\2\2\u00fa\u00fb\7g\2\2\u00fb"+
		"\u00fc\7u\2\2\u00fcD\3\2\2\2\u00fd\u00fe\7c\2\2\u00fe\u00ff\7h\2\2\u00ff"+
		"\u0100\7v\2\2\u0100\u0101\7g\2\2\u0101\u0102\7t\2\2\u0102F\3\2\2\2\u0103"+
		"\u0104\7=\2\2\u0104H\3\2\2\2\u0105\u0106\7c\2\2\u0106\u0107\7n\2\2\u0107"+
		"\u0108\7y\2\2\u0108\u0109\7c\2\2\u0109\u010a\7{\2\2\u010a\u010b\7u\2\2"+
		"\u010bJ\3\2\2\2\u010c\u010d\7i\2\2\u010d\u010e\7g\2\2\u010e\u010f\7v\2"+
		"\2\u010f\u0110\7K\2\2\u0110\u0111\7p\2\2\u0111\u0112\7v\2\2\u0112L\3\2"+
		"\2\2\u0113\u0114\7u\2\2\u0114\u0115\7g\2\2\u0115\u0116\7s\2\2\u0116\u0117"+
		"\7w\2\2\u0117\u0118\7g\2\2\u0118\u0119\7p\2\2\u0119\u011a\7v\2\2\u011a"+
		"\u011b\7k\2\2\u011b\u011c\7c\2\2\u011c\u011d\7n\2\2\u011d\u011e\7n\2\2"+
		"\u011e\u011f\7{\2\2\u011fN\3\2\2\2\u0120\u0121\7k\2\2\u0121\u0122\7h\2"+
		"\2\u0122P\3\2\2\2\u0123\u0124\7g\2\2\u0124\u0125\7n\2\2\u0125\u0126\7"+
		"u\2\2\u0126\u0127\7g\2\2\u0127R\3\2\2\2\u0128\u0129\5Q)\2\u0129\u012a"+
		"\7\"\2\2\u012a\u012b\5O(\2\u012bT\3\2\2\2\u012c\u012d\7h\2\2\u012d\u012e"+
		"\7q\2\2\u012e\u012f\7t\2\2\u012fV\3\2\2\2\u0130\u0131\7p\2\2\u0131\u0132"+
		"\7w\2\2\u0132\u0133\7o\2\2\u0133\u0134\7d\2\2\u0134\u0135\7g\2\2\u0135"+
		"\u0136\7t\2\2\u0136X\3\2\2\2\u0137\u0138\7u\2\2\u0138\u0139\7g\2\2\u0139"+
		"\u013a\7s\2\2\u013a\u013b\7w\2\2\u013b\u013c\7g\2\2\u013c\u013d\7p\2\2"+
		"\u013d\u013e\7e\2\2\u013e\u013f\7g\2\2\u013fZ\3\2\2\2\u0140\u0141\7r\2"+
		"\2\u0141\u0142\7g\2\2\u0142\u0143\7t\2\2\u0143\u0144\7h\2\2\u0144\u0145"+
		"\7q\2\2\u0145\u0146\7t\2\2\u0146\u0147\7o\2\2\u0147\u0148\7c\2\2\u0148"+
		"\u0149\7p\2\2\u0149\u014a\7e\2\2\u014a\u014b\7g\2\2\u014b\\\3\2\2\2\u014c"+
		"\u014d\7k\2\2\u014d\u014e\7p\2\2\u014e\u014f\7u\2\2\u014f\u0150\7v\2\2"+
		"\u0150\u0151\7t\2\2\u0151\u0152\7w\2\2\u0152\u0153\7o\2\2\u0153\u0154"+
		"\7g\2\2\u0154\u0155\7p\2\2\u0155\u0156\7v\2\2\u0156^\3\2\2\2\u0157\u0158"+
		"\7*\2\2\u0158`\3\2\2\2\u0159\u015a\7]\2\2\u015ab\3\2\2\2\u015b\u015c\7"+
		"}\2\2\u015cd\3\2\2\2\u015d\u015e\7+\2\2\u015ef\3\2\2\2\u015f\u0160\7_"+
		"\2\2\u0160h\3\2\2\2\u0161\u0162\7\177\2\2\u0162j\3\2\2\2\u0163\u0168\t"+
		"\6\2\2\u0164\u0167\t\7\2\2\u0165\u0167\5\23\n\2\u0166\u0164\3\2\2\2\u0166"+
		"\u0165\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2"+
		"\2\2\u0169l\3\2\2\2\u016a\u0168\3\2\2\2\u016b\u016f\7$\2\2\u016c\u016e"+
		"\13\2\2\2\u016d\u016c\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u0170\3\2\2\2"+
		"\u016f\u016d\3\2\2\2\u0170\u0172\3\2\2\2\u0171\u016f\3\2\2\2\u0172\u0173"+
		"\7$\2\2\u0173n\3\2\2\2\u0174\u0175\7\61\2\2\u0175\u0176\7\61\2\2\u0176"+
		"\u017a\3\2\2\2\u0177\u0179\n\b\2\2\u0178\u0177\3\2\2\2\u0179\u017c\3\2"+
		"\2\2\u017a\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017d\3\2\2\2\u017c"+
		"\u017a\3\2\2\2\u017d\u017e\b8\2\2\u017ep\3\2\2\2\u017f\u0180\7\61\2\2"+
		"\u0180\u0181\7,\2\2\u0181\u0185\3\2\2\2\u0182\u0184\13\2\2\2\u0183\u0182"+
		"\3\2\2\2\u0184\u0187\3\2\2\2\u0185\u0186\3\2\2\2\u0185\u0183\3\2\2\2\u0186"+
		"\u0188\3\2\2\2\u0187\u0185\3\2\2\2\u0188\u0189\7,\2\2\u0189\u018a\7\61"+
		"\2\2\u018a\u018b\3\2\2\2\u018b\u018c\b9\2\2\u018cr\3\2\2\2\u018d\u018f"+
		"\t\t\2\2\u018e\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u018e\3\2\2\2\u0190"+
		"\u0191\3\2\2\2\u0191\u0192\3\2\2\2\u0192\u0193\b:\2\2\u0193t\3\2\2\2\26"+
		"\2}\u0081\u0088\u008b\u008f\u0092\u0099\u00a2\u00a4\u00ab\u00ae\u00b2"+
		"\u00b9\u0166\u0168\u016f\u017a\u0185\u0190\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}