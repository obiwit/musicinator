from midiutil import MIDIFile
import sys

bpm = 160
midi = MIDIFile(numTracks=26, file_format=1)
midi.addTempo(0,0,bpm)
currtrack = 0
longest = 0

bass = [44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44]
piano = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
violin = [41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41]
porcoespinho = [-1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
drums = [119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119]
guitar = [25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25]
cello = [43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43]

def addnotes(notes):
    time = notes[0] #When the sequence will start time wise
    temp = 1 #default instrument
    global currtrack #we want the global scope of this variable


    repeat_times = (int)(notes[len(notes)-1])

    for x in range(len(time)):
        initialTime = time[x]
        for _ in range(repeat_times):
            for i in range(0, len(notes[1])):
                try:
                    note = notes[1][i][0] #getting the note
                    duration = notes[1][i][1] #duration of the note
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

                midi.addNote(currtrack,0,note,toInsert,duration,100)

                print("Added note {}, with instument {} with a duration of {} on time {}, on channel {}".format(note, instrument, duration, toInsert, currtrack))
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
    if type(toCheck[0]) is tuple:
        size = len(toCheck)-1
        return toCheck[0][3] + toCheck[size][3] + toCheck[size][1]
    else:
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
        toMod[1] = modded
        return toMod


def modTempo(toMod, ModNumber):
    modded = []
    if type(toMod[0]) is tuple:
        for tup in toMod:
            newTempo = tup[1] * ModNumber
            newtup = (tup[0], newTempo,tup[2],tup[3])
            modded.append(newtup)
        return modded
    else:
        for tup in toMod[1]:
            newTempo = tup[1] * ModNumber
            newtup = (tup[0], newTempo,tup[2],tup[3])
            modded.append(newtup)
        toMod[1] = modded
        return toMod

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
    perf_duration = max(perf[0])+duration(perf[1]) * perf[3]
    if perf_duration > longest:
        longest = perf_duration
    return perf

def preploop(perf)
    global longest #we want the global scope of this variable
    repeats = longest/duration(perf[1])
    perf[2]=repeats
    return perf


############################ LINE = 46
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
############################ LINE = 48
_18 = duration(first1_sequence)
t = _18
############################ LINE = 49
_19 = 20
non = _19
############################ LINE = 50
_21 = [(60,1.0,-1,-1),(64,1.0,-1,-1),(67,1.0,-1,-1)]
_20 = createseq([_21])
intro = _20
############################ LINE = 52
_23 = [(60,1.0,-1,-1)]
_22 = createseq([_23])
twinkle1 = _22
############################ LINE = 53
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
############################ LINE = 54
_39 = setinstrument(twinkle, guitar)
_39 = [[-1], _39, -1]
p = _39
############################ LINE = 56
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
############################ LINE = 58
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
############################ LINE = 60
_65 = [piano,guitar,bass]
band = _65
############################ LINE = 61
_68 = [bass,drums]
_67 = [guitar,_68]
_66 = [piano,_67]
band3 = _66
############################ LINE = 62
_70 = 1
_71 = 2
_69 = [_70,_71]
n = _69
############################ LINE = 63
_73 = 1
_74 = 1
_72 = range(_73, _74+1)
n2 = _72
############################ LINE = 64
_76 = [(60,1.0,-1,-1)]
_77 = [(60,1.0,-1,-1)]
_78 = [(67,1.0,-1,-1)]
_79 = [(67,1.0,-1,-1)]
_80 = [(69,1.0,-1,-1)]
_81 = [(69,1.0,-1,-1)]
_82 = [(67,2.0,-1,-1)]
_83 = [(65,1.0,-1,-1)]
_84 = [(65,1.0,-1,-1)]
_85 = [(64,1.0,-1,-1)]
_86 = [(64,1.0,-1,-1)]
_87 = [(62,1.0,-1,-1)]
_88 = [(62,1.0,-1,-1)]
_89 = [(60,2.0,-1,-1)]
_75 = createseq([_76,_77,_78,_79,_80,_81,_82,_83,_84,_85,_86,_87,_88,_89])
s = _75
############################ LINE = 67
_90 = p
_90[0] = [0]
_90[2] = 1
_90 = prepplay(_90)
addnotes(_90)
############################ LINE = 68
_91 = pp
_91[0] = [0]
_91[2] = 1
_91 = prepplay(_91)
_93 = pp
_93[0] = [0]
_93[2] = 1
_93 = prepplay(_93)
_92 = _93
_92[0] = [non]
_92 = prepplay(_92)
addnotes(_92)
############################ LINE = 69
_94 = pp
_94[0] = [0]
_94[2] = 1
_94 = prepplay(_94)
_96 = pp
_96[0] = [0]
_96[2] = 1
_96 = prepplay(_96)
_95 = _96
_95[0] = n
_95 = prepplay(_95)
addnotes(_95)
############################ LINE = 72
_98 = duration(s)
_99 = 5
_97 = _98<_99
_102 = duration(p)
_103 = 10
_101 = _102==_103
_100 = _101
_105 = duration(s)
_106 = 10
_104 = _105>_106
if _104:
	############################ LINE = 73
	_107 = setinstrument(s, piano)
	_107 = [[-1], _107, -1]
	_108 = _107
	_108[0] = [0]
	_108[2] = 1
	_108 = prepplay(_108)
	addnotes(_108)
	############################ LINE = 74
	_110 = [(60,1.0,-1,-1)]
	_109 = createseq([_110])
	banana = _109
elif _97:
	############################ LINE = 77
	_111 = setinstrument(s, guitar)
	_111 = [[-1], _111, -1]
	_112 = _111
	_112[0] = [0]
	_112[2] = 1
	_112 = prepplay(_112)
	addnotes(_112)
	############################ LINE = 78
	_113 = 5
	nada = _113
elif _100:
	############################ LINE = 81
	_114 = p
	_114[0] = [0]
	_114[2] = 1
	_114 = prepplay(_114)
	addnotes(_114)
else:
	############################ LINE = 84
	_115 = setinstrument(s, piano)
	_115 = [[-1], _115, -1]
	_116 = _115
	_116[0] = [0]
	_116[2] = 1
	_116 = prepplay(_116)
	addnotes(_116)
############################ LINE = 87
p = preploop(p)
addnotes(p)
############################ LINE = 90
_117 = setinstrument(twinkle, piano)
_117 = [[-1], _117, -1]
_118 = _117
_118[0] = [0]
_118[2] = 1
_118 = prepplay(_118)
addnotes(_118)
############################ LINE = 92
_121 = [(60,1.0,-1,-1)]
_122 = [(60,1.0,-1,-1)]
_123 = [(67,1.0,-1,-1)]
_124 = [(67,1.0,-1,-1)]
_125 = [(69,1.0,-1,-1)]
_126 = [(69,1.0,-1,-1)]
_127 = [(67,2.0,-1,-1)]
_128 = [(65,1.0,-1,-1)]
_129 = [(65,1.0,-1,-1)]
_130 = [(64,1.0,-1,-1)]
_131 = [(64,1.0,-1,-1)]
_132 = [(62,1.0,-1,-1)]
_133 = [(62,1.0,-1,-1)]
_134 = [(60,2.0,-1,-1)]
_120 = createseq([_121,_122,_123,_124,_125,_126,_127,_128,_129,_130,_131,_132,_133,_134])
_119 = setinstrument(_120, piano)
_119 = [[-1], _119, -1]
_135 = _119
_135[0] = [0]
_135[2] = 1
_135 = prepplay(_135)
addnotes(_135)
############################ LINE = 95
_139 = [(62,1.5,-1,-1)]
_140 = [(62,0.5,-1,-1)]
_141 = [(64,1.0,-1,-1)]
_142 = [(62,1.0,-1,-1)]
_143 = [(67,1.0,-1,-1)]
_144 = [(65,2.0,-1,-1)]
_138 = createseq([_139,_140,_141,_142,_143,_144])
_137 = setinstrument(_138, piano)
_137 = [[-1], _137, -1]
_147 = [(62,1.5,-1,-1)]
_148 = [(62,0.5,-1,-1)]
_149 = [(64,1.0,-1,-1)]
_150 = [(62,1.0,-1,-1)]
_151 = [(69,1.0,-1,-1)]
_152 = [(67,2.0,-1,-1)]
_146 = createseq([_147,_148,_149,_150,_151,_152])
_145 = setinstrument(_146, bass)
_145 = [[-1], _145, -1]
_136 = [_137,_145]
p_a = _136
############################ LINE = 100
for _153 in p_a:
	_153[0] = [0]
	_153[2] = 1
	_153 = prepplay(_153)
	addnotes(p_a)
############################ LINE = 102
_154 = [band,violin]
new_band = _154
############################ LINE = 106
intro3 = p_a[0]
############################ LINE = 108
for inst in band:
	############################ LINE = 109
	_155 = setinstrument(twinkle, inst)
	_155 = [[-1], _155, -1]
	_156 = _155
	_156[0] = [0]
	_156[2] = 1
	_156 = prepplay(_156)
	addnotes(_156)

with open("out.mid", 'wb') as file:
    midi.writeFile(file) #Writting the file
    print("MIDI File Written")
