grammar gramatica ;

//PARSER RULES

main:	instructions* EOF ;
// Exucute this command to compile grammar
// antlr4-build && antlr4-test gramatica main -gui < example.txt  && antlr4-clean

instructions
		: sequence
		| performance
		| play
		| time
		| number
		| instrumentsArray	// inserçao de op=(...)
		| performanceArray	//c Erro em performance corrigido
		| ifstatment
		;

sequence
		: 'sequence' WORD '=' a ';'
		;

a:  a ('*'|'/') sum | a ('+'|'-') sum | stringNotes | WORD;

performance
		: 'performance' WORD '=' ( ((WORD | stringNotes)  ('on' WORD))| (WORD '[' INT ']') )';'
		;

play
		: 'play' (WORD | stringNotes)  ('on' WORD)?';'
		;

time
		: 'time' WORD '=' ('-')? (WORD | '|' WORD '|' | INT+ ) (('+'|'-') (WORD | '|' WORD '|' | INT+ ))*';'
		;

number
		: 'number' WORD '=' INT ';'
		;

instrumentsArray
		: 'instrument' '[]' WORD '=' (('['(WORD (','WORD)* )*']') | (WORD ( op=('and'|'except') WORD)* )* ) ';'
		;

performanceArray
		: 'performance' '[]' WORD '=' '[' ((WORD | stringNotes)  ('on' WORD) ) (','(WORD | stringNotes)  ('on' WORD))* ']' ';'
								//	  (('['(((WORD | stringNotes)  ('on' WORD) ) |(WORD | stringNotes)  ('on' WORD) ',')*']')) ';'
		;

ifstatment
		: 'if' condition ':' body ('else if' condition ':' body)* ('else' ':' body)?;
body
		: '\t' play //problemas com os \t sendo que estão "skipados" 
		;
condition
		:	expr '>' expr
		|	expr '>=' expr
		|	expr '<' expr
		|	expr '<=' expr
		|	expr '==' expr
		|	expr '!=' expr
		;
expr
		: '|' WORD '|'
		| INT
		;

sum
		: sum op=('+'|'-') sum
		| INT
		;

stringNotes
		: '[' (SOUND)* ']'
		;
		
//INSTRUMENTS: 'piano' | 'guitar' | 'violin' | 'cello' | 'bass' | 'drums' ;
	
//LEXER RULES

SOUND: 			(((NOTE OCTAVE?) | 'R' ) DOUBLE?) ('|' SOUND)*;
NOTE: 			LETTER ('#'|'b')* ;
LETTER: 		[A-G];

INT:			DIGIT+ ;
DOUBLE:			('{' ((DIGIT+ ('.' DIGIT*)?) | ('.' DIGIT+) )'}') | ('\'')+;
fragment DIGIT:	[0-9];
fragment OCTAVE:('-'[1-2] | [0-8]);
WORD: 			[_a-z] ([_a-zA-Z] | DIGIT)*;

NEWLINE : 		'\r'? '\n' -> skip;
LINE_COMMENT: 	'//' .*? NEWLINE -> skip;
BLOCK_COMMENT: 	'/*' .*? '*/' -> skip;
WS: 			[ \r\n]+ -> skip ;
