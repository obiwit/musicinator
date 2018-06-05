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
		| forstatment
		;

assignment
		: SQ_LIT WORD EQUAL sequence SEMICOLON 					#sequenceAssign
		| PF_LIT WORD EQUAL performance SEMICOLON 				#perfomanceAssign
		| NUM_LIT WORD EQUAL numericExpr SEMICOLON 				#numberAssign
//		| T_LIT WORD EQUAL numericExpr SEMICOLON				#timeAssign

		| SQ_LIT OPEN_SB CLOSE_SB WORD EQUAL sequenceArray SEMICOLON 		#sequenceArrayAssign
		| PF_LIT OPEN_SB CLOSE_SB WORD EQUAL performanceArray SEMICOLON 	#perfomancArrayeAssign
		| INST_LIT OPEN_SB CLOSE_SB WORD EQUAL instrumentArray SEMICOLON	#intrumentArrayAssign
		| NUM_LIT OPEN_SB CLOSE_SB WORD EQUAL numberArray SEMICOLON		#numberArrayAssign
		;

// TODO (play)
play
		: PLAY (WORD | stringNotes)  (ON WORD)? SEMICOLON
		;

forstatment	:FOR arrayTypes WORD IN WORD OPEN_BR instructions* CLOSE_BR
		;

ifstatment
		: IF condition COLON body (ELIF condition COLON body)* (ELSE COLON body)?
		;
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
		: OPEN_SB sequenceList CLOSE_SB
		| WORD
		;

sequenceList: sequence (COMMA sequence)*;

performanceArray
		: OPEN_SB performanceList CLOSE_SB
		| WORD
		;

performanceList: performance (COMMA performance)*;

instrumentArray
		: OPEN_SB wordList CLOSE_SB
		| instrumentArray op=(AND|EXCEPT) WORD
		| WORD 
		;

wordList: WORD (COMMA WORD)*;

numberArray
		: OPEN_SB numberList CLOSE_SB
		| WORD
		;

numberList: numericExpr (COMMA numericExpr)*;



// ADDONS/HELPERS


arrayTypes
		: SQ_LIT | PF_LIT | NUM_LIT | INST_LIT
		;

condition
		: numericExpr op=(BIGR|BIGE|SMLR|SMLE|EQLS|DIFS) numericExpr
		;

numericExpr
		: numericExpr op=(MUL|DIV|REM) numericExpr
		| numericExpr op=(ADD|SUB) numericExpr
		| variable
		| OR WORD OR
		| DOUBLE
		;

variable
		: WORD OPEN_SB INT CLOSE_BR
		| WORD
		;

stringNotes
		: OPEN_SB (SOUND)* CLOSE_BR
		;
