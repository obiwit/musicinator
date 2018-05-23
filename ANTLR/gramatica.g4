grammar gramatica ;
main : instructions* EOF ;
// Exucute this command to compile grammar
// antlr4-build && antlr4-test gramatica main -gui < ex1.lfa

instructions: sequencecmd
     		| performancecmd
			| playcmd
			| aftercmd
			| LINE_COMMENT
			| BLOCK_COMMENT
			;

playcmd: 'play' WORD ';' ;
performancecmd: 'performance' WORD '=' WORD 'on' INSTRUMENTS ';' ;
sequencecmd: 'sequence' WORD '=' '[' stringNotes ']' ';' ;
aftercmd:	'after' WORD 'play' WORD ';'		#normalAfterPlay
		//|	'after' WORD 'always play' WORD #alwaysAfterPlay
		;

stringNotes : NOTE*;
NOTE: (([A-G] ('#'*|'b'*)  OCTAVE?) ('|' ([A-G] ('#'*|'b'*) OCTAVE?))? | 'R' ) ('{'DOUBLE'}')?  ; // Não inclui frações (1/3) POR AGORA


INSTRUMENTS: 'piano' | 'guitar' | 'violin' | 'cello' | 'bass' | 'drums' ;
// Aceita o conjunto vazio
WORD: [a-zA-Z]+ (DIGIT)*;
OCTAVE: ('-'[1-2] | [0-8]);
DOUBLE: DIGIT+ ('.' DIGIT*)? | ('.' DIGIT+);
fragment DIGIT: [0-9];


LINE_COMMENT: '//' .*? NEWLINE ;
BLOCK_COMMENT: '/*' .*? '*/';
NEWLINE : '\r'? '\n' -> skip;
WS: [ \t\r\n]+ -> skip ;
