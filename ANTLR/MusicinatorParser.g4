parser grammar MusicinatorParser;

options {tokenVocab = MusicinatorLexer;}
//PARSER RULES

main:	instructions* EOF ;
// Exucute this command to compile grammar
// antlr4-build && antlr4-test gramatica main -gui < example.txt  && antlr4-clean

instructions
		: assignment
		| play
		| ifstatment
		;

assignment
		: SQ_LIT WORD EQUAL sequence SEMICOLON 			#sequenceAssign
		| PF_LIT WORD EQUAL performance SEMICOLON 		#perfomanceAssign
		| NUM_LIT WORD EQUAL numericExpr SEMICOLON 		#numberAssign
//		| T_LIT WORD EQUAL numericExpr SEMICOLON		#timeAssign

		| SQ_LIT OPEN_BR CLOSE_BR WORD EQUAL sequenceArray SEMICOLON 		#sequenceArrayAssign
		| PF_LIT OPEN_BR CLOSE_BR WORD EQUAL performanceArray SEMICOLON 	#perfomancArrayeAssign
		| INST_LIT OPEN_BR CLOSE_BR WORD EQUAL instrumentArray SEMICOLON	#intrumentArrayAssign
		| NUM_LIT OPEN_BR CLOSE_BR WORD EQUAL numberArray SEMICOLON			#numberArrayAssign
		;

// TODO (play)
play
		: PLAY (WORD | stringNotes)  (ON WORD)? SEMICOLON
		;


ifstatment
		: IF condition COLON body (ELIF condition COLON body)* (ELSE COLON body)?;
body
		: TAB play //problemas com os \t sendo que estão "skipados" 
		;


// DEFINITIONS
sequence
		: sequence op=(MUL|DIV) numericExpr 
		| sequence op=(ADD|SUB) numericExpr 
		| stringNotes 
		| variable
		;

performance
		: performance op=(MUL|DIV) numericExpr 
		| performance op=(ADD|SUB) numericExpr 
		| sequence ON WORD 
		| variable
		;

sequenceArray
		: OPEN_BR sequenceList CLOSE_BR
		| WORD
		;
sequenceList: sequence (COMMA sequence)*;

performanceArray
		: OPEN_BR performanceList CLOSE_BR
		| WORD
		;
performanceList: performance (COMMA performance)*;

instrumentArray
		: OPEN_BR wordList CLOSE_BR
		| instrumentArray op=(AND|EXCEPT) WORD
		| WORD 
		;
wordList: WORD (COMMA WORD)*;

numberArray
		: OPEN_BR numberList CLOSE_BR
		| WORD
		;
numberList: numericExpr (COMMA numericExpr)*;



// ADDONS/HELPERS
condition
		:	numericExpr op=(BIGR|BIGE|SMLR|SMLE|EQLS|DIFS) numericExpr
		;

numericExpr
		: numericExpr op=(MUL|DIV|REM) numericExpr
		| numericExpr op=(ADD|SUB) numericExpr
		| variable
		| OR WORD OR
		| DOUBLE
		;

variable
		: WORD OPEN_BR INT CLOSE_BR
		| WORD
		;

stringNotes
		: OPEN_BR (SOUND)* CLOSE_BR
		;