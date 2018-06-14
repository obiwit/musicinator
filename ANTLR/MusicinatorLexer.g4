lexer grammar MusicinatorLexer;
	
//LEXER RULES

SOUND: 			((NOTE | 'R' ) DURATION?) ('|' SOUND)*;
NOTE: 			LETTER ('#'|'b')* OCTAVE?;
LETTER: 		[A-G];

INT:			DIGIT+ ;
DURATION:		('{' DOUBLE '}') | ('\'')+;
DOUBLE: 		(INT ('.' INT*)?) | ('.' INT);
fragment DIGIT:	[0-9];
fragment OCTAVE:('-'[1-2] | [0-8]);


ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
REM:  '%';

BIGR: '>';
BIGE: '>=';
SMLR: '<';
SMLE: '<=';
EQLS: '==';
DIFS: '!=';

OR: '|';
ON: 'on';
IN: 'in';
AND: 'and';
COMMA: ',';
COLON: ':';
EQUAL: '=';
PLAY: 'play';
EXCEPT: 'except';
SEMICOLON: ';';

IF: 'if';
ELSE: 'else';
ELIF: ELSE ' ' IF;
FOR: 'for';


INST_LIT: 'instrument';
PF_LIT: 'performance';
SQ_LIT: 'sequence';
NUM_LIT: 'number';

OPEN_SB: '[';
CLOSE_SB: ']';
OPEN_BR: '{';
CLOSE_BR: '}';


BPM: 'BPM';
ARROW: '->';

WORD: 			[_a-z] ([_a-zA-Z] | DIGIT)*;
NEWLINE : 		'\r'? '\n' -> skip;
LINE_COMMENT: 	'//' .*? NEWLINE -> skip;
BLOCK_COMMENT: 	'/*' .*? '*/' -> skip;
WS: 			[ \t\r\n]+ -> skip ;
