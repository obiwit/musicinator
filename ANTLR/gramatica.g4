grammar gramatica ;
program : stat* EOF ;

play: 'play' WORD ';';
performance: 'performance' WORD '=' WORD 'on' INSTRUMENTS';' ;
sequence: 'sequence' WORD '=' '[' stringNotes ']' ';';

stringNotes : NOTE*;


NOTE: (([A-G] ('#'|'b')*  OCTAVE?) | 'R' ) ('{'DOUBLE'}')?  ; // Não inclui frações (1/3) POR AGORA 
WORD: [a-Z]+;
OCTAVE: ('-'[1-2] | [0-8]);
DOUBLE: DIGIT+ ('.' DIGIT*)? | ('.' DIGIT+);
fragment DIGIT: [0-9];
INSTRUMENTS: 'piano' | 'guitar' | 'violin' | 'cello' | 'bass' | 'drums' ;

LINE_COMMENT: '//' .*? NEWLINE -> skip;
BLOCK_COMMENT: '/*' .*? '*/' NEWLINE -> skip;
NEWLINE : '\r'? '\n' ;
WS: [ \t\r\n]+ -> skip ;


