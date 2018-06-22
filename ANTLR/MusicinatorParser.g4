parser grammar MusicinatorParser;

options {tokenVocab = MusicinatorLexer;}

main:	instructions* EOF ;

// "high level" definitions - statements
instructions
		: assignment
		| play
		| forStat
		| ifStat
		;

assignment
		: types WORD EQUAL expr SEMICOLON								#varAssign
		| arrayTypes OPEN_SB CLOSE_SB WORD EQUAL arrayExpr SEMICOLON 	#arrayAssign
		;

play 	: PLAY performance SEMICOLON
		;

forStat	: FOR arrayTypes WORD IN WORD OPEN_BR instructions* CLOSE_BR
		;

ifStat	: IF condition 
		  OPEN_BR  instructions* CLOSE_BR 
		  (ELIF condition OPEN_BR  instructions* CLOSE_BR)* 
		  (ELSE OPEN_BR  instructions* CLOSE_BR)?
		;


// "middle level" definitions - constructs (arrays)
arrayExpr
		: OPEN_SB list? CLOSE_SB
		| expr (AND expr)*
		;

list 	: expr (COMMA expr)*
		;

expr 	: variable 			#varExpr // detects instruments without entering another "type"
		| performance 		#perExpr
		| sequence 			#seqExpr
		| number 			#numExpr
		;


/* V1
list 	: sequenceList
		| performanceList
		| numberList
		;

sequenceList
		: sequence ((COMMA|AND) sequence)*
		;

performanceList
		: performance ((COMMA|AND) performance)*;

wordList
		: WORD ((COMMA|AND) WORD)*
		;

numberList
		: number ((COMMA|AND) number)*
		;
*/

// "lower level" definitions - types, expressions and conditions
sequence
		: sequence op=(MUL|DIV) number 			#seqSpeedMod
		| sequence op=(ADD|SUB) number 			#seqPitchMod
		| OPEN_SB sequence* CLOSE_SB 			#seqList
		| SOUND									#seqLiteral
		| variable								#seqVar
		;

performance
		: performance op=(MUL|DIV) number 		#perSpeedMod
		| performance op=(ADD|SUB) number 		#perPitchMod
		| sequence ON WORD 						#perFromSeq
		| variable 								#perVar
		;

number
		: number op=(MUL|DIV|REM) number		#numMulDiv
		| number op=(ADD|SUB) number			#numAddSub
		| OR WORD OR 							#numDuration
		| DOUBLE 								#numDouble
		| INT 									#numInt
		| variable								#numVar
		;

variable
		: WORD OPEN_SB INT CLOSE_SB
		| WORD 										
		;

types 	: SQ_LIT 
		| PF_LIT 
		| NUM_LIT;

arrayTypes
		: types 
		| INST_LIT;

condition
		: number op=(BIGR|BIGE|SMLR|SMLE|EQLS|DIFS) number
		;

