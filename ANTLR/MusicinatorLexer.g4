lexer grammar MusicinatorLexer;

//LEXER RULES
//CHORD:			SOUND ('|' SOUND)+;
SOUND: 			((NOTE | 'R' ) DURATION?) ('|' SOUND)*;
fragment NOTE: 	LETTER ('#'|'b')* OCTAVE?;
fragment LETTER:[A-G];

INT:			DIGIT+ ;
DURATION:		('{' DOUBLE '}') | ('\'')+;
DOUBLE: 		(INT ('.' INT*)?) | ('.' INT);
fragment DIGIT:	[0-9];
fragment OCTAVE:('-1'| [0-8]);

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
ARROW: '->';

ON: 'on';
IN: 'in';
AT: 'at';
BAR: '|';
AND: 'and';
COMMA: ',';
COLON: ':';
EQUAL: '=';
LOOP: 'loop';
PLAY: 'play';
TIMES: 'times';
AFTER: 'after';
SEMICOLON: ';';
ALWAYS: 'always';
SEQUENTIALLY: 'sequentially';


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


WORD: 			[_a-z] ([_a-zA-Z] | DIGIT)*;

LINE_COMMENT: 	'//' ~[\r\n]* -> skip;
BLOCK_COMMENT: 	'/*' .*? '*/' -> skip;

WS: 			[ \t\r\n]+ -> skip ;
