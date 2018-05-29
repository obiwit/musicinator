grammar gramatica ;
main : instructions* EOF ;
// Exucute this command to compile grammar
// antlr4-build gramatica && antlr4-test gramatica main -gui < example.txt  && antlr4-clean

instructions: sequence
		| play
		| instrumentsArray
		| performanceArray
		| performance
     		| LINE_COMMENT
		| BLOCK_COMMENT
		;

play: 	  'play' (WORD | stringNotes)  ('on' WORD)?';';	
performance: 'performance' WORD '=' ( ((WORD | stringNotes)  ('on' WORD))| (WORD '[' INT+ ']') )';' ;
sequence: 'sequence' WORD '='  stringNotes ';';
performanceArray: 'performance' '[]' WORD '=' (('['(((WORD | stringNotes)  ('on' WORD) ) |(WORD | stringNotes)  ('on' WORD) ',')*']')) ';' ;
instrumentsArray: 'instrument' '[]' WORD '=' (('['(WORD (','WORD)* )*']') | (WORD (('and'|'except') WORD)* )* ) ';' ;

stringNotes : '[' (SOUND)* ']'  ;
//INSTRUMENTS: 'piano' | 'guitar' | 'violin' | 'cello' | 'bass' | 'drums' ;

	
SOUND: (((NOTE OCTAVE?) | 'R' ) DOUBLE?) ('|' SOUND)*;
NOTE: LETTER ('#'|'b')* ;
LETTER: [A-G];


INT: DIGIT;
OCTAVE: ('-'[1-2] | [0-8]);
DOUBLE: ('{' ((DIGIT+ ('.' DIGIT*)?) | ('.' DIGIT+) )'}') | ('\'')+;
fragment DIGIT: [0-9];
WORD: [_a-z] ([_a-zA-Z] | DIGIT)*;


NEWLINE : '\r'? '\n' -> skip;
LINE_COMMENT: '//' .*? NEWLINE -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;
WS: [ \t\r\n]+ -> skip ;




