parser grammar AuxinatorParser;

options {tokenVocab = AuxinatorLexer;}

main: bpm instAssign* EOF;

bpm: BPM EQUAL INT SEMICOLON;

instAssign: INST_LIT WORD COLON instrumentDef SEMICOLON;

instrumentDef: noteMapList
		     | instrumentInheritanceList
		     | WORD
		     | INT 
		     ;

noteMap: WORD EQUAL NOTE;
noteMapList: noteMap (COMMA noteMap)*;

instrumentInheritance: (NOTE|noteRange) ARROW WORD;
instrumentInheritanceList: instrumentInheritance (COMMA instrumentInheritance)*;

noteRange: NOTE SUB NOTE;