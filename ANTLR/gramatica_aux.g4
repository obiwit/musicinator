main: bpm instAssign* EOF;

bpm: 'BPM' '=' INT ';';

instAssign: 'instrument' WORD ':' instrumentDef ';';

instrumentDef: noteMapList
	     | instrumentInheritanceList
	     | WORD
	     |INT 
	     ;

noteMap: WORD '=' NOTE;
noteMapList: noteMap (',' noteMap)*;

instrumentInheritance: (NOTE|NOTE_RANGE) '->' WORD;
instrumentInheritanceList: instrumentInheritance (',' instrumentInheritance)*;

NOTE_RANGE: NOTE '-' NOTE;

NOTE: [A-G] ('#'*|'b'*) OCTAVE;
fragment OCTAVE: (('-'[1-2])|[0-8]);

WORD: [a-zA-Z] [_a-zA-Z0-9]*;
INT: [0-9]+;

LINE_COMMENT: '//' .*? NEWLINE ;
BLOCK_COMMENT: '/*' .*? '*/';
WS: [ \t\r\n]+ -> skip ;