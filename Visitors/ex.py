from midiutil import MIDIFile
import sys

bpm = 120
midi = MIDIFile(numTracks=24, file_format=1)
midi.addTempo(0,0,bpm)
currtrack = 0

bass = [44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44]
piano = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
violin = [41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41]
drums = [119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119]
guitar = [25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25]
cello = [43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43]

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
    for i in len(seq):
        newseq = extendseq(newseq,seq[i])
    return newseq

def setinstrument(seq,nome):
    if len(seq)==0:
        return seq
    newseq = []
    for tup in seq:
        new = (tup[0],tup[1],nome[tup[0]],tup[3])
        newseq.append(new)
    return newseq


############################ LINE = 1
_1 = [(109,2.0,-1,-1)]
_2 = [(69,1.0,-1,-1)]
_3 = [(60,1.0,-1,-1)]
_4 = [(62,3.12,-1,-1)]
_5 = [(71,1.0,-1,-1)]
_6 = [(108,1.0,-1,-1)]
_7 = [(62,3.0,-1,-1)]
_8 = [(73,0.5,-1,-1)]
_9 = [(64,4.0,-1,-1)]
_10 = [(77,3.0,-1,-1)]
_11 = [(65,0.0625,-1,-1)]
_0 = createseq([_1,_2,_3,_4,_5,_6,_7,_8,_9,_10,_11])
_12 = 40
_13 = 20
_14 = 12
first1_sequence = _14
############################ LINE = 3
_15 = duration(first1_sequence)
t = _15
############################ LINE = 4
_16 = 20
non = _16
############################ LINE = 6
_18 = [(60,1.0,-1,-1),(64,1.0,-1,-1),(67,1.0,-1,-1)]
_17 = createseq([_18])
intro = _17
############################ LINE = 8
_20 = [(60,1.0,-1,-1)]
_19 = createseq([_20])
twinkle1 = _19
############################ LINE = 9
_22 = [(60,1.0,-1,-1)]
_23 = [(60,1.0,-1,-1)]
_24 = [(67,1.0,-1,-1)]
_25 = [(67,1.0,-1,-1)]
_26 = [(69,1.0,-1,-1)]
_27 = [(69,1.0,-1,-1)]
_28 = [(67,2.0,-1,-1)]
_29 = [(65,1.0,-1,-1)]
_30 = [(65,1.0,-1,-1)]
_31 = [(64,1.0,-1,-1)]
_32 = [(64,1.0,-1,-1)]
_33 = [(62,1.0,-1,-1)]
_34 = [(62,1.0,-1,-1)]
_35 = [(60,2.0,-1,-1)]
_21 = createseq([_22,_23,_24,_25,_26,_27,_28,_29,_30,_31,_32,_33,_34,_35])
twinkle = _21
############################ LINE = 10
_36 = setinstrument(twinkle, guitar)
_36 = [[-1], _36, -1]
p = _36
############################ LINE = 12
_38 = [(-49,4.0,-1,-1)]
_39 = [(60,4.0,-1,-1)]
_40 = [(67,4.0,-1,-1)]
_41 = [(72,3.5,-1,-1)]
_42 = [(64,0.5,-1,-1),(67,0.5,-1,-1),(72,0.5,-1,-1)]
_43 = [(64,8.0,-1,-1),(67,8.0,-1,-1),(72,8.0,-1,-1)]
_44 = [(60,4.0,-1,-1)]
_45 = [(67,4.0,-1,-1)]
_37 = createseq([_38,_39,_40,_41,_42,_43,_44,_45])
intro2 = _37
############################ LINE = 14
_48 = [(60,0.25,-1,-1)]
_49 = [(60,1.0,-1,-1)]
_50 = [(67,1.0,-1,-1)]
_51 = [(67,1.0,-1,-1)]
_52 = [(69,0.5,-1,-1)]
_53 = [(69,0.5,-1,-1)]
_54 = [(67,2.0,-1,-1)]
_55 = [(65,1.0,-1,-1)]
_56 = [(65,1.0,-1,-1)]
_57 = [(64,1.0,-1,-1)]
_58 = [(64,1.0,-1,-1)]
_59 = [(62,1.0,-1,-1)]
_60 = [(62,1.0,-1,-1)]
_61 = [(60,2.0,-1,-1)]
_47 = createseq([_48,_49,_50,_51,_52,_53,_54,_55,_56,_57,_58,_59,_60,_61])
_46 = setinstrument(_47, guitar)
_46 = [[-1], _46, -1]
pp = _46
############################ LINE = 16
_62 = [guitar,bass,drums]
band = _62
############################ LINE = 18
_65 = [drums]
_64 = [_65]
_63 = [_64]
band3 = _63
############################ LINE = 19
_67 = 2
_68 = 3
_66 = [_67,_68]
n = _66
############################ LINE = 20
_70 = 1
_71 = 1
_69 = range(_70, _71+1)
n2 = _69
############################ LINE = 21
_73 = [(60,1.0,-1,-1)]
_74 = [(60,1.0,-1,-1)]
_75 = [(67,1.0,-1,-1)]
_76 = [(67,1.0,-1,-1)]
_77 = [(69,1.0,-1,-1)]
_78 = [(69,1.0,-1,-1)]
_79 = [(67,2.0,-1,-1)]
_80 = [(65,1.0,-1,-1)]
_81 = [(65,1.0,-1,-1)]
_82 = [(64,1.0,-1,-1)]
_83 = [(64,1.0,-1,-1)]
_84 = [(62,1.0,-1,-1)]
_85 = [(62,1.0,-1,-1)]
_86 = [(60,2.0,-1,-1)]
_72 = createseq([_73,_74,_75,_76,_77,_78,_79,_80,_81,_82,_83,_84,_85,_86])
s = _72
############################ LINE = 24
############################ LINE = 25
############################ LINE = 26
_87 = setinstrument(intro, piano)
_87 = [[-1], _87, -1]
############################ LINE = 30
_88 = duration(s)
_89 = 10
############################ LINE = 31
_90 = duration(s)
_91 = 5
############################ LINE = 34
_92 = setinstrument(s, guitar)
_92 = [[-1], _92, -1]
############################ LINE = 37
_93 = setinstrument(s, piano)
_93 = [[-1], _93, -1]
############################ LINE = 43
_94 = setinstrument(twinkle, piano)
_94 = [[-1], _94, -1]
############################ LINE = 45
_97 = [(60,1.0,-1,-1)]
_98 = [(60,1.0,-1,-1)]
_99 = [(67,1.0,-1,-1)]
_100 = [(67,1.0,-1,-1)]
_101 = [(69,1.0,-1,-1)]
_102 = [(69,1.0,-1,-1)]
_103 = [(67,2.0,-1,-1)]
_104 = [(65,1.0,-1,-1)]
_105 = [(65,1.0,-1,-1)]
_106 = [(64,1.0,-1,-1)]
_107 = [(64,1.0,-1,-1)]
_108 = [(62,1.0,-1,-1)]
_109 = [(62,1.0,-1,-1)]
_110 = [(60,2.0,-1,-1)]
_96 = createseq([_97,_98,_99,_100,_101,_102,_103,_104,_105,_106,_107,_108,_109,_110])
_95 = setinstrument(_96, piano)
_95 = [[-1], _95, -1]
############################ LINE = 48
_114 = [(62,1.5,-1,-1)]
_115 = [(62,0.5,-1,-1)]
_116 = [(64,1.0,-1,-1)]
_117 = [(62,1.0,-1,-1)]
_118 = [(69,1.0,-1,-1)]
_119 = [(67,2.0,-1,-1)]
_113 = createseq([_114,_115,_116,_117,_118,_119])
_112 = setinstrument(_113, bass)
_112 = [[-1], _112, -1]
_122 = [(62,1.5,-1,-1)]
_123 = [(62,0.5,-1,-1)]
_124 = [(74,1.0,-1,-1)]
_125 = [(71,1.0,-1,-1)]
_126 = [(67,1.0,-1,-1)]
_127 = [(65,1.0,-1,-1)]
_128 = [(64,1.0,-1,-1)]
_121 = createseq([_122,_123,_124,_125,_126,_127,_128])
_120 = setinstrument(_121, guitar)
_120 = [[-1], _120, -1]
_111 = [_112,_120]
p_a = _111
############################ LINE = 55
_129 = [violin]
new_band = _129
############################ LINE = 59
intro3 = p_a[0]
############################ LINE = 61
############################ LINE = 62
_130 = setinstrument(twinkle, inst)
_130 = [[-1], _130, -1]
with open("out.mid", 'wb') as file:
    midi.writeFile(file) #Writting the file
    print("MIDI File Written")
