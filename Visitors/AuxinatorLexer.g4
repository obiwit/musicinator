lexer grammar AuxinatorLexer;

import MusicinatorLexer;

BPM: 'BPM'|'bpm';
NOTE: LETTER ('#'|'b')* OCTAVE?;