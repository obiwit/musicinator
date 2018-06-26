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
		: types (OPEN_SB CLOSE_SB)? WORD EQUAL expr SEMICOLON
		;

play 	: PLAY per=expr SEQUENTIALLY? (rep=expr TIMES)? SEMICOLON 	#simplePlay
		| (AT expr | AFTER variable ALWAYS?) play					#timedPlay
		| LOOP performance											#loopPlay
		;

forStat	: FOR types newVar=WORD IN array=WORD OPEN_BR instructions* CLOSE_BR
		;

ifStat	: IF ifCond=condition OPEN_BR ifBody=instructions* CLOSE_BR 
		  (ELIF elifCond=condition OPEN_BR  elifBody=instructions* CLOSE_BR)* 
		  (ELSE OPEN_BR  elseBody=instructions* CLOSE_BR)?
		;


// "lower level" definitions - types, expressions and conditions
expr 	: variable 									#varExpr
		| performance 								#perExpr
		| sequence 									#seqExpr
		| number 									#numExpr
		| OPEN_PR expr CLOSE_PR						#parensExpr

		| e1=expr op=(MUL|DIV) e2=expr				#mulDivExpr
		| e1=expr op=(ADD|SUB) e2=expr				#addSubExpr

		| OPEN_SB expr (COMMA expr)* CLOSE_SB 		#bracketArray
		| expr (AND expr)+							#andArray
		| e1=expr ARROW e2=expr 					#numRangeArray
		;
		

sequence
		: OPEN_SB sequence* CLOSE_SB 			#seqList
		| SOUND									#seqNote
		| CHORD									#seqChord	
		;

performance
		: (sequence|seq=variable) ON inst=variable 
		;

number 	: BAR variable BAR 						#numDuration
		| DOUBLE 								#numDouble
		| INT 									#numInt
		| GETINT OPEN_PR STRING? CLOSE_PR 		#numGetInt
		;

variable
		: WORD OPEN_SB INT CLOSE_SB
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

