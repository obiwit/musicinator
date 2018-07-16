lexer grammar MusicinatorLexer;

//LEXER RULES
CHORD:			NOTE ('|' NOTE)+ DURATION?;
SOUND: 			(NOTE | 'R' ) DURATION?;
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
GETINT: 'getInt';
SEQUENTIALLY: 'sequentially';

IF: 'if';
ELSE: 'else';
ELIF: ELSE ' ' IF;
FOR: 'for';

NUM_LIT: 'number';
SQ_LIT: 'sequence';
PF_LIT: 'performance';
INST_LIT: 'instrument';

OPEN_PR: '(';
OPEN_SB: '[';
OPEN_BR: '{';
CLOSE_PR: ')';
CLOSE_SB: ']';
CLOSE_BR: '}';

WORD: 		[a-z] ([_a-zA-Z] | DIGIT)*;
STRING: 	'"' .*? '"';

LINE_COMMENT: 	'//' ~[\r\n]* -> skip;
BLOCK_COMMENT: 	'/*' .*? '*/' -> skip;

WS: 			[ \t\r\n]+ -> skip ;
