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
_92 = pp
_92[0] = [0]
_92[2] = 1
_92 = prepplay(_92)
_91 = _92
_91[0] = [non]
_91 = prepplay(_91)
addnotes(_91)
############################ LINE = 69
_94 = pp
_94[0] = [0]
_94[2] = 1
_94 = prepplay(_94)
_93 = _94
_93[0] = n
_93 = prepplay(_93)
addnotes(_93)
############################ LINE = 72
_96 = duration(s)
_97 = 5
_95 = _96<_97
_100 = duration(p)
_101 = 10
_99 = _100==_101
_98 = _99
_103 = duration(s)
_104 = 10
_102 = _103>_104
if _102:
	############################ LINE = 73
	_106 = setinstrument(s, piano)
	_106 = [[-1], _106, -1]
	_105 = _106
	_105[0] = [0]
	_105[2] = 1
	_105 = prepplay(_105)
	addnotes(_105)
	############################ LINE = 74
	_108 = [(60,1.0,-1,-1)]
	_107 = createseq([_108])
	banana = _107
elif _95:
	############################ LINE = 77
	_110 = setinstrument(s, guitar)
	_110 = [[-1], _110, -1]
	_109 = _110
	_109[0] = [0]
	_109[2] = 1
	_109 = prepplay(_109)
	addnotes(_109)
	############################ LINE = 78
	_111 = 5
	nada = _111
elif _98:
	############################ LINE = 81
	_112 = p
	_112[0] = [0]
	_112[2] = 1
	_112 = prepplay(_112)
	addnotes(_112)
else:
	############################ LINE = 84
	_114 = setinstrument(s, piano)
	_114 = [[-1], _114, -1]
	_113 = _114
	_113[0] = [0]
	_113[2] = 1
	_113 = prepplay(_113)
	addnotes(_113)
############################ LINE = 87
p = preploop(p)
addnotes(p)
############################ LINE = 90
_116 = setinstrument(twinkle, piano)
_116 = [[-1], _116, -1]
_115 = _116
_115[0] = [0]
_115[2] = 1
_115 = prepplay(_115)
addnotes(_115)
############################ LINE = 92
_120 = [(60,1.0,-1,-1)]
_121 = [(60,1.0,-1,-1)]
_122 = [(67,1.0,-1,-1)]
_123 = [(67,1.0,-1,-1)]
_124 = [(69,1.0,-1,-1)]
_125 = [(69,1.0,-1,-1)]
_126 = [(67,2.0,-1,-1)]
_127 = [(65,1.0,-1,-1)]
_128 = [(65,1.0,-1,-1)]
_129 = [(64,1.0,-1,-1)]
_130 = [(64,1.0,-1,-1)]
_131 = [(62,1.0,-1,-1)]
_132 = [(62,1.0,-1,-1)]
_133 = [(60,2.0,-1,-1)]
_119 = createseq([_120,_121,_122,_123,_124,_125,_126,_127,_128,_129,_130,_131,_132,_133])
_118 = setinstrument(_119, piano)
_118 = [[-1], _118, -1]
_117 = _118
_117[0] = [0]
_117[2] = 1
_117 = prepplay(_117)
addnotes(_117)
############################ LINE = 95
_137 = [(62,1.5,-1,-1)]
_138 = [(62,0.5,-1,-1)]
_139 = [(64,1.0,-1,-1)]
_140 = [(62,1.0,-1,-1)]
_141 = [(67,1.0,-1,-1)]
_142 = [(65,2.0,-1,-1)]
_136 = createseq([_137,_138,_139,_140,_141,_142])
_135 = setinstrument(_136, piano)
_135 = [[-1], _135, -1]
_145 = [(62,1.5,-1,-1)]
_146 = [(62,0.5,-1,-1)]
_147 = [(64,1.0,-1,-1)]
_148 = [(62,1.0,-1,-1)]
_149 = [(69,1.0,-1,-1)]
_150 = [(67,2.0,-1,-1)]
_144 = createseq([_145,_146,_147,_148,_149,_150])
_143 = setinstrument(_144, bass)
_143 = [[-1], _143, -1]
_134 = [_135,_143]
p_a = _134
############################ LINE = 100
_151 = p_a
_151[0] = [0]
_151[2] = 1
_151 = prepplay(_151)
addnotes(_151)
############################ LINE = 102
_152 = [band,violin]
new_band = _152
############################ LINE = 106
intro3 = p_a[0]
############################ LINE = 108
for inst in band:
	############################ LINE = 109
	_154 = setinstrument(twinkle, inst)
	_154 = [[-1], _154, -1]
	_153 = _154
	_153[0] = [0]
	_153[2] = 1
	_153 = prepplay(_153)
	addnotes(_153)

with open("out.mid", 'wb') as file:
    midi.writeFile(file) #Writting the file
    print("MIDI File Written")
