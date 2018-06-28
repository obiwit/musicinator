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
		: types (OPEN_SB CLOSE_SB)? assignment 		#declare
		| WORD EQUAL expr SEMICOLON 				#assign
		;

play 	: PLAY per=expr SEQUENTIALLY? (rep=expr TIMES)? SEMICOLON 	#simplePlay
		| AT expr play												#timedPlay //(AT expr | AFTER variable ALWAYS?)
		| LOOP expr	SEMICOLON										#loopPlay
		;

forStat	: FOR types WORD IN expr OPEN_BR forBody+=instructions* CLOSE_BR
		;

ifStat	: IF ifCond=condition OPEN_BR ifBody+=instructions* CLOSE_BR 
		  (ELIF elifCond+=condition OPEN_BR  (elifBody+=instructions)* CLOSE_BR)* 
		  (ELSE OPEN_BR  elseBody+=instructions* CLOSE_BR)?
		;


// "lower level" definitions - types, expressions and conditions
expr 	: variable 									#varExpr
		| sequence 									#seqExpr
		| number 									#numExpr
		| OPEN_PR expr CLOSE_PR						#parensExpr

		| e1=expr op=(MUL|DIV) e2=expr				#mulDivExpr
		| e1=expr op=(ADD|SUB) e2=expr				#addSubExpr
		| expr ON variable 							#performance

		| OPEN_SB expr (COMMA expr)* CLOSE_SB 		#bracketArray
		| expr (AND expr)+							#andArray
		| e1=expr ARROW e2=expr 					#numRangeArray
		;
		

sequence
		: OPEN_SB expr* CLOSE_SB 				#seqList
		| SOUND									#seqNote
		| CHORD									#seqChord	
		;

number 	: BAR variable BAR 						#numDuration
		| DOUBLE 								#numDouble
		| INT 									#numInt
		| GETINT OPEN_PR STRING? CLOSE_PR 		#numGetInt
		;

variable
		: WORD OPEN_SB expr CLOSE_SB
		| WORD OPEN_SB start=expr? COLON end=expr? CLOSE_SB
		| WORD DURATION
		| WORD 										
		;

types 	: SQ_LIT 
		| PF_LIT 
		| NUM_LIT
		| INST_LIT
		;

condition
		: e1=expr op=(BIGR|BIGE|SMLR|SMLE|EQLS|DIFS) e2=expr
		| OPEN_PR condition CLOSE_PR
		;
