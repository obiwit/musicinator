lexer grammar MusicinatorLexer;
	
//LEXER RULES

SOUND: 			(((NOTE OCTAVE?) | 'R' ) DURATION?) ('|' SOUND)*;
NOTE: 			LETTER ('#'|'b')* ;
LETTER: 		[A-G];

INT:			DIGIT+ ;
DURATION:		('{' DOUBLE '}') | ('\'')+;
DOUBLE: 		(DIGIT+ ('.' DIGIT*)?) | ('.' DIGIT+);
fragment DIGIT:	[0-9];
fragment OCTAVE:('-'[1-2] | [0-8]);
WORD: 			[_a-z] ([_a-zA-Z] | DIGIT)*;

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

INST_LIT: 'instrument';
PF_LIT: 'performance';
SQ_LIT: 'sequence';
NUM_LIT: 'number';
T_LIT: 'time';

OPEN_BR: '[';
CLOSE_BR: ']';

NEWLINE : 		'\r'? '\n' -> skip;
LINE_COMMENT: 	'//' .*? NEWLINE -> skip;
BLOCK_COMMENT: 	'/*' .*? '*/' -> skip;
WS: 			[ \r\n]+ -> skip ;
TAB: '\t';