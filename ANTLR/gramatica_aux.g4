main: bpm instAssign* EOF;

bpm: 'BPM' '=' INT ';';

instAssign: 'instrument' WORD = INT ';';

WORD: [a-zA-Z] [_a-zA-Z0-9]*;
INT: [0-9]+;
NEWLINE : '\r'? '\n' -> skip;