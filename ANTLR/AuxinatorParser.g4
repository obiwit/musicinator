parser grammar AuxinatorParser;

options {tokenVocab = AuxinatorLexer;}

main: bpm (noteMap | instAssign)* EOF;

bpm: BPM EQUAL INT SEMICOLON;

instAssign: INST_LIT WORD COLON instrumentDef SEMICOLON;

instrumentDef: instrumentInheritanceList
		     | WORD
		     | INT 
		     ;

noteMap: WORD EQUAL NOTE SEMICOLON;

instrumentInheritance: (NOTE|noteRange) ARROW WORD;
instrumentInheritanceList: instrumentInheritance (COMMA instrumentInheritance)*;

noteRange: NOTE SUB NOTE;