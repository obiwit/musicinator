from midiutil import MIDIFile
from math import ceil
import sys

bpm = 160
midi = MIDIFile(numTracks=26, file_format=1)
midi.addTempo(0,0,bpm)
currtrack = 0
longest = 0

bass = [44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44]
piano = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
violin = [41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41]
porcoespinho = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
drums = [119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119]
guitar = [25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25]
cello = [43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43]
tamborBarulhento = 60

def addnotes(notes):
    time = notes[0] #When the sequence will start time wise
    temp = 1 #default instrument
    global currtrack #we want the global scope of this variable
    duration(notes)

    repeat_times = (int)(notes[len(notes)-1])

    for x in range(len(time)):
        initialTime = time[x] - duration(notes[1])
        for _ in range(repeat_times):
            initialTime += duration(notes[1])
            for i in range(0, len(notes[1])):
                try:
                    note = notes[1][i][0] #getting the note
                    noteDur = notes[1][i][1] #duration of the note
                    toInsert = notes[1][i][3] + initialTime
                    if note < 0:
                        continue

                except:
                    pass

                try: #trying for instrument change
                    instrument = notes[1][i][2] #checking for instrument
                    if(instrument != temp):
                        midi.addProgramChange(currtrack, 0, toInsert, instrument) #changing the current instrument
                        temp = instrument
                except:
                    instrument = temp #it keeps the old instrument
                    pass

                midi.addNote(currtrack,0,note,toInsert,noteDur,100)

                print("Added note {}, with instument {} with a duration of {} on time {}, on channel {}".format(note, instrument, noteDur, (toInsert*(85/bpm)), currtrack))
        currtrack += 1

def getInt(varstr):
    while True:
        try:
            a = int(input(varstr))
        except ValueError:
            print("Please input a valid number")
            continue
        else:
            break
    return a

def duration(toCheck):
    if len(toCheck) == 0:
        return 0
    if type(toCheck[0]) is tuple:
        size = len(toCheck)-1
        return toCheck[0][3] + toCheck[size][3] + toCheck[size][1]
    else:
        if len(toCheck[1]) == 0:
            return 0
        size = len(toCheck[1]) - 1
        return toCheck[1][0][3] + toCheck[1][size][3] + toCheck[1][size][1]

def modPitch(toMod, ModNumber):
    modded = []
    if type(toMod[0]) is tuple:
        for tup in toMod:
            newPitch = tup[0] + ModNumber
            try:
                if newPitch < 0:
                    raise ValueError
            except ValueError:
                print("Modulated note below 0, expect silence")
                pass
            newtup = (newPitch, tup[1],tup[2],tup[3])
            modded.append(newtup)
        return modded
    else:
        temp = toMod
        for tup in toMod[1]:
            newPitch = tup[0] + ModNumber
            try:
                if newPitch < 0:
                    raise ValueError
            except ValueError:
                print("Modulated note below 0, expect silence")
                pass
            newtup = (newPitch, tup[1],tup[2],tup[3])
            modded.append(newtup)
        temp[1] = modded
        return temp


def modTempo(toMod, ModNumber):
    modded = []
    if type(toMod[0]) is tuple:
        for tup in toMod:
            newTempo = tup[1] * ModNumber
            newtup = (tup[0], newTempo,tup[2],tup[3])
            modded.append(newtup)
        return modded
    else:
        temp = toMod
        for tup in toMod[1]:
            newTempo = tup[1] * ModNumber
            newtup = (tup[0], newTempo,tup[2],tup[3])
            modded.append(newtup)
        temp[1] = modded
        return temp

def extendseq(original, toextend):
    modded = []
    if len(original) == 0:
        for tup in toextend:
            newtup = (tup[0], tup[1], tup[2], 0)
            modded.append(newtup)
        return modded
    else:
        for tup in original:
            modded.append(tup)
        time = duration(original)
        for tup in toextend:
            newtup = (tup[0], tup[1], tup[2], time)
            modded.append(newtup)
        return modded

def createseq(seq):
    newseq = []
    for s in seq:
        newseq = extendseq(newseq, s)
    return newseq

def setinstrument(seq,nome):
    if len(seq)==0:
        return seq
    newseq = []
    for tup in seq:
        new = (tup[0],tup[1],nome[tup[0]],tup[3])
        newseq.append(new)
    return newseq

def prepplay(perf):
    global longest #we want the global scope of this variable
    perf_duration = max(perf[0])+duration(perf[1]) * perf[2]
    if perf_duration > longest:
        longest = perf_duration
    return perf

def preploop(perf):
    global longest #we want the global scope of this variable
    repeats = longest/duration(perf[1])
    perf[2] = ceil(repeats)
    return perf


############################ LINE = 79
_4 = [(109,2.0,-1,-1)]
_5 = [(69,1.0,-1,-1)]
_6 = [(60,1.0,-1,-1)]
_7 = [(62,3.12,-1,-1)]
_8 = [(71,1.0,-1,-1)]
_9 = [(108,1.0,-1,-1)]
_10 = [(62,3.0,-1,-1)]
_11 = [(73,0.5,-1,-1)]
_12 = [(64,4.0,-1,-1)]
_13 = [(77,3.0,-1,-1)]
_14 = [(65,0.0625,-1,-1)]
_3 = createseq([_4,_5,_6,_7,_8,_9,_10,_11,_12,_13,_14])
_15 = 40
_2 = modPitch(_3, _15)
_16 = 20
_1 = modPitch(_2, -1*_16)
_17 = 12
_0 = modPitch(_1, _17)
first1_sequence = _0
############################ LINE = 81
_18 = duration(first1_sequence)
t = _18
############################ LINE = 82
_19 = 20
non = _19
############################ LINE = 83
_21 = [(60,1.0,-1,-1),(64,1.0,-1,-1),(67,1.0,-1,-1)]
_20 = createseq([_21])
intro = _20
############################ LINE = 85
_23 = [(60,1.0,-1,-1)]
_22 = createseq([_23])
twinkle1 = _22
############################ LINE = 86
_25 = [(60,1.0,-1,-1)]
_26 = [(60,1.0,-1,-1)]
_27 = [(67,1.0,-1,-1)]
_28 = [(67,1.0,-1,-1)]
_29 = [(69,1.0,-1,-1)]
_30 = [(69,1.0,-1,-1)]
_31 = [(67,2.0,-1,-1)]
_32 = [(65,1.0,-1,-1)]
_33 = [(65,1.0,-1,-1)]
_34 = [(64,1.0,-1,-1)]
_35 = [(64,1.0,-1,-1)]
_36 = [(62,1.0,-1,-1)]
_37 = [(62,1.0,-1,-1)]
_38 = [(60,2.0,-1,-1)]
_24 = createseq([_25,_26,_27,_28,_29,_30,_31,_32,_33,_34,_35,_36,_37,_38])
twinkle = _24
############################ LINE = 87
_39 = setinstrument(twinkle, guitar)
_39 = [[-1], _39, -1]
p = _39
############################ LINE = 89
_41 = [(-49,4.0,-1,-1)]
_42 = [(60,4.0,-1,-1)]
_43 = [(67,4.0,-1,-1)]
_44 = [(72,3.5,-1,-1)]
_45 = [(64,0.5,-1,-1),(67,0.5,-1,-1),(72,0.5,-1,-1)]
_46 = [(64,8.0,-1,-1),(67,8.0,-1,-1),(72,8.0,-1,-1)]
_47 = [(60,4.0,-1,-1)]
_48 = [(67,4.0,-1,-1)]
_40 = createseq([_41,_42,_43,_44,_45,_46,_47,_48])
intro2 = _40
############################ LINE = 91
_51 = [(60,0.25,-1,-1)]
_52 = [(60,1.0,-1,-1)]
_53 = [(67,1.0,-1,-1)]
_54 = [(67,1.0,-1,-1)]
_55 = [(69,0.5,-1,-1)]
_56 = [(69,0.5,-1,-1)]
_57 = [(67,2.0,-1,-1)]
_58 = [(65,1.0,-1,-1)]
_59 = [(65,1.0,-1,-1)]
_60 = [(64,1.0,-1,-1)]
_61 = [(64,1.0,-1,-1)]
_62 = [(62,1.0,-1,-1)]
_63 = [(62,1.0,-1,-1)]
_64 = [(60,2.0,-1,-1)]
_50 = createseq([_51,_52,_53,_54,_55,_56,_57,_58,_59,_60,_61,_62,_63,_64])
_49 = setinstrument(_50, guitar)
_49 = [[-1], _49, -1]
pp = _49
############################ LINE = 93
_65 = [piano,guitar,bass,drums]
band = _65
############################ LINE = 94
_68 = [bass,drums]
_67 = [guitar,_68]
_66 = [piano,_67]
band3 = _66
############################ LINE = 95
_70 = 1
_71 = 2
_72 = 3
_69 = [_70,_71,_72]
n = _69
############################ LINE = 96
_74 = 1
_75 = 1
_73 = range(_74, _75+1)
n2 = _73
############################ LINE = 97
_77 = [(60,1.0,-1,-1)]
_78 = [(60,1.0,-1,-1)]
_79 = [(67,1.0,-1,-1)]
_80 = [(67,1.0,-1,-1)]
_81 = [(69,1.0,-1,-1)]
_82 = [(69,1.0,-1,-1)]
_83 = [(67,2.0,-1,-1)]
_84 = [(65,1.0,-1,-1)]
_85 = [(65,1.0,-1,-1)]
_86 = [(64,1.0,-1,-1)]
_87 = [(64,1.0,-1,-1)]
_88 = [(62,1.0,-1,-1)]
_89 = [(62,1.0,-1,-1)]
_90 = [(60,2.0,-1,-1)]
_76 = createseq([_77,_78,_79,_80,_81,_82,_83,_84,_85,_86,_87,_88,_89,_90])
s = _76
############################ LINE = 100
_91 = 0
_92 = p
_92[0] = [0]
_92[2] = 1
_92 = prepplay(_92)
addnotes(_92)
############################ LINE = 101
_93 = 0
_94 = pp
_94[0] = [0]
_94[2] = 1
_94 = prepplay(_94)
_96 = 0
_97 = pp
_97[0] = [0]
_97[2] = 1
_97 = prepplay(_97)
_95 = _97
_95[0] = _95[0]+[non]
_95 = prepplay(_95)
addnotes(_95)
############################ LINE = 102
_98 = 0
_99 = pp
_99[0] = [0]
_99[2] = 1
_99 = prepplay(_99)
_101 = 0
_102 = pp
_102[0] = [0]
_102[2] = 1
_102 = prepplay(_102)
_100 = _102
_100[0] = _100[0]+n
_100 = prepplay(_100)
addnotes(_100)
############################ LINE = 105
_104 = duration(s)
_105 = 5
_103 = _104<_105
_108 = duration(p)
_109 = 10
_107 = _108==_109
_106 = _107
_111 = duration(s)
_112 = 10
_110 = _111>_112
if _110:
	############################ LINE = 106
	_113 = setinstrument(s, piano)
	_113 = [[-1], _113, -1]
	_114 = 0
	_115 = _113
	_115[0] = [0]
	_115[2] = 1
	_115 = prepplay(_115)
	addnotes(_115)
	############################ LINE = 107
	_117 = [(60,1.0,-1,-1)]
	_116 = createseq([_117])
	banana = _116
elif _103:
	############################ LINE = 110
	_118 = setinstrument(s, guitar)
	_118 = [[-1], _118, -1]
	_119 = 0
	_120 = _118
	_120[0] = [0]
	_120[2] = 1
	_120 = prepplay(_120)
	addnotes(_120)
	############################ LINE = 111
	_121 = 5
	nada = _121
elif _106:
	############################ LINE = 114
	_122 = 0
	_123 = p
	_123[0] = [0]
	_123[2] = 1
	_123 = prepplay(_123)
	addnotes(_123)
else:
	############################ LINE = 117
	_124 = setinstrument(s, piano)
	_124 = [[-1], _124, -1]
	_125 = 0
	_126 = _124
	_126[0] = [0]
	_126[2] = 1
	_126 = prepplay(_126)
	addnotes(_126)
############################ LINE = 120
p[0] = [0]
p = preploop(p)
addnotes(p)
############################ LINE = 123
_127 = setinstrument(twinkle, piano)
_127 = [[-1], _127, -1]
_128 = 0
_129 = _127
_129[0] = [0]
_129[2] = 1
_129 = prepplay(_129)
addnotes(_129)
############################ LINE = 125
_132 = [(60,1.0,-1,-1)]
_133 = [(60,1.0,-1,-1)]
_134 = [(67,1.0,-1,-1)]
_135 = [(67,1.0,-1,-1)]
_136 = [(69,1.0,-1,-1)]
_137 = [(69,1.0,-1,-1)]
_138 = [(67,2.0,-1,-1)]
_139 = [(65,1.0,-1,-1)]
_140 = [(65,1.0,-1,-1)]
_141 = [(64,1.0,-1,-1)]
_142 = [(64,1.0,-1,-1)]
_143 = [(62,1.0,-1,-1)]
_144 = [(62,1.0,-1,-1)]
_145 = [(60,2.0,-1,-1)]
_131 = createseq([_132,_133,_134,_135,_136,_137,_138,_139,_140,_141,_142,_143,_144,_145])
_130 = setinstrument(_131, piano)
_130 = [[-1], _130, -1]
_146 = 0
_147 = _130
_147[0] = [0]
_147[2] = 1
_147 = prepplay(_147)
addnotes(_147)
############################ LINE = 128
_151 = [(62,1.5,-1,-1)]
_152 = [(62,0.5,-1,-1)]
_153 = [(64,1.0,-1,-1)]
_154 = [(62,1.0,-1,-1)]
_155 = [(67,1.0,-1,-1)]
_156 = [(65,2.0,-1,-1)]
_150 = createseq([_151,_152,_153,_154,_155,_156])
_149 = setinstrument(_150, piano)
_149 = [[-1], _149, -1]
_159 = [(62,1.5,-1,-1)]
_160 = [(62,0.5,-1,-1)]
_161 = [(64,1.0,-1,-1)]
_162 = [(62,1.0,-1,-1)]
_163 = [(69,1.0,-1,-1)]
_164 = [(67,2.0,-1,-1)]
_158 = createseq([_159,_160,_161,_162,_163,_164])
_157 = setinstrument(_158, bass)
_157 = [[-1], _157, -1]
_167 = [(62,1.5,-1,-1)]
_168 = [(62,0.5,-1,-1)]
_169 = [(74,1.0,-1,-1)]
_170 = [(71,1.0,-1,-1)]
_171 = [(67,1.0,-1,-1)]
_172 = [(65,1.0,-1,-1)]
_173 = [(64,1.0,-1,-1)]
_166 = createseq([_167,_168,_169,_170,_171,_172,_173])
_165 = setinstrument(_166, guitar)
_165 = [[-1], _165, -1]
_148 = [_149,_157,_165]
p_a = _148
############################ LINE = 133
_174 = 0
for _175 in p_a:
	_175[0] = [_174]
	_175[2] = 1
	_175 = prepplay(_175)
	_174 = duration(_175)
	addnotes(_175)
############################ LINE = 135
_176 = [band,violin]
new_band = _176
############################ LINE = 139
intro3 = p_a[0]
############################ LINE = 141
for inst in band:
	############################ LINE = 142
	_177 = setinstrument(twinkle, inst)
	_177 = [[-1], _177, -1]
	_178 = 0
	_179 = _177
	_179[0] = [0]
	_179[2] = 1
	_179 = prepplay(_179)
	addnotes(_179)

with open("out.mid", 'wb') as file:
    midi.writeFile(file) #Writting the file
    print("MIDI File Written")
