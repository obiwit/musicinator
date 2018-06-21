parser grammar MusicinatorParser;

options {tokenVocab = MusicinatorLexer;}
//PARSER RULES

main:	instructions* EOF ;
// Exucute this command to compile grammar: Musicinator
// antlr4-build && antlr4-test Musicinator main -gui < example.txt
// antlr4-clean

instructions
		: assignment
		| play
		| ifstatment
		| forstatment
		;

assignment
		: SQ_LIT WORD EQUAL sequence SEMICOLON 					#sequenceAssign
		| PF_LIT WORD EQUAL performance SEMICOLON 				#perfomanceAssign
		| NUM_LIT WORD EQUAL numericExpr SEMICOLON 				#numberAssign

		| SQ_LIT OPEN_SB CLOSE_SB WORD EQUAL sequenceArray SEMICOLON 		#sequenceArrayAssign
		| PF_LIT OPEN_SB CLOSE_SB WORD EQUAL performanceArray SEMICOLON 	#perfomancArrayeAssign
		| INST_LIT OPEN_SB CLOSE_SB WORD EQUAL instrumentArray SEMICOLON	#intrumentArrayAssign
		| NUM_LIT OPEN_SB CLOSE_SB WORD EQUAL numberArray SEMICOLON		#numberArrayAssign
		;

/* V2 - seria mais adequado uma tatica do tipo abaixo?

assignment:
		types WORD EQUAL expr SEMICOLON
		| arrayTypes OPEN_SB CLOSE_SB WORD EQUAL arrayExpr SEMICOLON
		;

expr: sequence
	| performance
	| numericExpr
	;

types: SQ_LIT | PF_LIT | NUM_LIT;
arrayTypes: types | INST_LIT;

// arrayExpr mais em baixo, em comentario tambem

*/

play
		: PLAY sequence  (ON WORD)? SEMICOLON
		;

forstatment
		: FOR arrayTypes WORD IN WORD OPEN_BR instructions* CLOSE_BR
		;

ifstatment
		: IF condition OPEN_BR body CLOSE_BR (ELIF condition OPEN_BR body CLOSE_BR)* (ELSE OPEN_BR body CLOSE_BR)?
		;
body
		: instructions
		;


// DEFINITIONS
sequence
		: sequence op=(MUL|DIV) numericVariable 
		| sequence op=(ADD|SUB) numericVariable 
		| OPEN_SB sequence* CLOSE_SB 
		| variable
		| SOUND
		;

performance
		: performance op=(MUL|DIV) numericVariable 
		| performance op=(ADD|SUB) numericVariable 
		| sequence ON WORD 
		| variable
		;

sequenceArray
		: OPEN_SB sequenceList? CLOSE_SB
		| WORD
		;

sequenceList
		: sequence (COMMA sequence)*
		;

performanceArray
		: OPEN_SB performanceList? CLOSE_SB
		| WORD
		;

performanceList: performance (COMMA performance)*;

instrumentArray
		: OPEN_SB wordList? CLOSE_SB
		| instrumentArray op=(AND|EXCEPT) WORD
		| WORD 
		;

wordList
		: WORD (COMMA WORD)*
		;

numberArray
		: OPEN_SB numberList? CLOSE_SB
		| WORD
		;

numberList
		: numericExpr (COMMA numericExpr)*
		;

/* V2 (cont.) - seria mais adequado uma tatica do tipo abaixo?

arrayExpr
		: OPEN_SB list? CLOSE_SB
		| WORD
		;

list 	: sequenceList
		| performanceList
		| numberList
		;
*/

// ADDONS/HELPERS

types: SQ_LIT | PF_LIT | NUM_LIT;
arrayTypes: types | INST_LIT;

condition
		: numericExpr op=(BIGR|BIGE|SMLR|SMLE|EQLS|DIFS) numericExpr
		;

numericExpr
		: numericExpr op=(MUL|DIV|REM) numericExpr
		| numericExpr op=(ADD|SUB) numericExpr
		| numericVariable
		;

numericVariable
		: variable
		| OR WORD OR
		| DOUBLE
		| INT
		;

variable
		: WORD OPEN_SB INT CLOSE_SB
		| WORD
		;
