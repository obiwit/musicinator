parser grammar AuxinatorParser;

options {tokenVocab = AuxinatorLexer;}

main: bpm (noteMap | instAssign)* EOF;

bpm: BPM EQUAL INT SEMICOLON;

noteMap: WORD EQUAL NOTE SEMICOLON;

instAssign: INST_LIT WORD COLON instrumentDef SEMICOLON;

instrumentDef: instrumentInheritanceList		#defInheritance
		     | WORD								#defWord
		     | INT 								#defInt
		     ;
instrumentInheritanceList: instrumentInheritance (COMMA instrumentInheritance)*;
instrumentInheritance: (NOTE|noteRange) ARROW WORD;

noteRange: NOTE SUB NOTE;