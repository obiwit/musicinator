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
		: types WORD EQUAL (expr|performance) SEMICOLON					#varAssign
		| arrayTypes OPEN_SB CLOSE_SB WORD EQUAL arrayExpr SEMICOLON 	#arrayAssign
		;

play 	: PLAY performance SEQUENTIALLY? (number TIMES)? SEMICOLON 			#simplePlay
		| (AT (variable|number|arrayExpr) | AFTER variable ALWAYS?) play	#timedPlay
		| LOOP performance													#loopPlay
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
		: OPEN_SB (expr (COMMA expr)*)? CLOSE_SB
		| expr (AND expr)*
		| number ARROW number
		;

expr 	: variable 			#varExpr // detects instruments without entering another "type"
		| performance 		#perExpr
		| sequence 			#seqExpr
		| number 			#numExpr
		;
		

// "lower level" definitions - types, expressions and conditions
sequence
		: sequence op=(MUL|DIV) number 			#seqSpeedMod
		| sequence op=(ADD|SUB) number 			#seqPitchMod
		| OPEN_SB sequence* CLOSE_SB 			#seqList
		| SOUND									#seqNote
		| CHORD									#seqChord	
		| variable								#seqVar
		;

performance
		: performance op=(MUL|DIV) number 		#perSpeedMod
		| performance op=(ADD|SUB) number 		#perPitchMod
		| sequenceList ON WORD 					#perFromSeq
		| variable 								#perVar
		;


sequenceList	// sequenceList is used to prevent mutually left-recursion between arrayExpr, performance, and expr
		: OPEN_SB (sequence (COMMA sequence)*)? CLOSE_SB
		| sequence (AND sequence)*
		;

number
		: number op=(MUL|DIV) number			#numMulDiv
		| number op=(ADD|SUB) number			#numAddSub
		| BAR WORD BAR 							#numDuration
		| DOUBLE 								#numDouble
		| INT 									#numInt
		| GETINT OPEN_PR STRING? CLOSE_PR 		#numGetInt
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

