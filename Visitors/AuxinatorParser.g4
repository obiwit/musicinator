parser grammar AuxinatorParser;

options {tokenVocab = AuxinatorLexer;}

main: bpm (noteMap | instAssign)* EOF;

bpm: BPM EQUAL INT SEMICOLON;

noteMap: WORD EQUAL NOTE SEMICOLON;

instAssign: INST_LIT WORD COLON instrumentDef SEMICOLON;

instrumentDef: instrumentInheritance (COMMA instrumentInheritance)*		#defInheritance
		     | WORD									#defWord
		     | INT 									#defInt
		     ;
instrumentInheritance: (n=NOTE|(n1=NOTE SUB n2=NOTE)) ARROW WORD;