parser grammar AuxinatorParser;

options {tokenVocab = AuxinatorLexer;}

main: bpm (noteMap | instAssign)* EOF;

bpm: BPM EQUAL INT SEMICOLON;

instAssign: INST_LIT WORD COLON instrumentDef SEMICOLON;

instrumentDef: instrumentInheritanceList		#defInheritance
		     | WORD								#defWord
		     | INT 								#defInt
		     ;

noteMap: WORD EQUAL NOTE SEMICOLON;

instrumentInheritanceList: instrumentInheritance (COMMA instrumentInheritance)*;
instrumentInheritance: (NOTE|noteRange) ARROW WORD;

noteRange: NOTE SUB NOTE;