from midiutil import MIDIFile
import sys

bpm = 120
midi = MIDIFile(numTracks=22, file_format=1)
midi.addTempo(0,0,bpm)
currtrack = 0

bass = [44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44]
piano = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
violin = [41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41]
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
############################ LINE = 4
_15 = 20
non = _15
############################ LINE = 5
_17 = [(60,1.0,-1,-1),(64,1.0,-1,-1),(67,1.0,-1,-1)]
_16 = createseq([_17])
intro = _16
############################ LINE = 7
_19 = [(60,1.0,-1,-1)]
_18 = createseq([_19])
twinkle1 = _18
############################ LINE = 8
_21 = [(60,1.0,-1,-1)]
_22 = [(60,1.0,-1,-1)]
_23 = [(67,1.0,-1,-1)]
_24 = [(67,1.0,-1,-1)]
_25 = [(69,1.0,-1,-1)]
_26 = [(69,1.0,-1,-1)]
_27 = [(67,2.0,-1,-1)]
_28 = [(65,1.0,-1,-1)]
_29 = [(65,1.0,-1,-1)]
_30 = [(64,1.0,-1,-1)]
_31 = [(64,1.0,-1,-1)]
_32 = [(62,1.0,-1,-1)]
_33 = [(62,1.0,-1,-1)]
_34 = [(60,2.0,-1,-1)]
_20 = createseq([_21,_22,_23,_24,_25,_26,_27,_28,_29,_30,_31,_32,_33,_34])
twinkle = _20
############################ LINE = 9
_35 = setinstrument(twinkle, guitar)
_35 = [[-1], _35, -1]
p = _35
############################ LINE = 11
_37 = [(-49,4.0,-1,-1)]
_38 = [(60,4.0,-1,-1)]
_39 = [(67,4.0,-1,-1)]
_40 = [(72,3.5,-1,-1)]
_41 = [(64,0.5,-1,-1),(67,0.5,-1,-1),(72,0.5,-1,-1)]
_42 = [(64,8.0,-1,-1),(67,8.0,-1,-1),(72,8.0,-1,-1)]
_43 = [(60,4.0,-1,-1)]
_44 = [(67,4.0,-1,-1)]
_36 = createseq([_37,_38,_39,_40,_41,_42,_43,_44])
intro2 = _36
############################ LINE = 13
_47 = [(60,0.25,-1,-1)]
_48 = [(60,1.0,-1,-1)]
_49 = [(67,1.0,-1,-1)]
_50 = [(67,1.0,-1,-1)]
_51 = [(69,0.5,-1,-1)]
_52 = [(69,0.5,-1,-1)]
_53 = [(67,2.0,-1,-1)]
_54 = [(65,1.0,-1,-1)]
_55 = [(65,1.0,-1,-1)]
_56 = [(64,1.0,-1,-1)]
_57 = [(64,1.0,-1,-1)]
_58 = [(62,1.0,-1,-1)]
_59 = [(62,1.0,-1,-1)]
_60 = [(60,2.0,-1,-1)]
_46 = createseq([_47,_48,_49,_50,_51,_52,_53,_54,_55,_56,_57,_58,_59,_60])
_45 = setinstrument(_46, guitar)
_45 = [[-1], _45, -1]
pp = _45
############################ LINE = 15
_61 = [piano,guitar,bass]
band = _61
############################ LINE = 17
_64 = [bass,drums]
_63 = [guitar,_64]
_62 = [piano,_63]
band3 = _62
############################ LINE = 18
_66 = 1
_67 = 2
_65 = [_66,_67]
n = _65
############################ LINE = 19
_69 = 1
_70 = 1
_68 = range(_69, _70+1)
n2 = _68
############################ LINE = 20
_72 = [(60,1.0,-1,-1)]
_73 = [(60,1.0,-1,-1)]
_74 = [(67,1.0,-1,-1)]
_75 = [(67,1.0,-1,-1)]
_76 = [(69,1.0,-1,-1)]
_77 = [(69,1.0,-1,-1)]
_78 = [(67,2.0,-1,-1)]
_79 = [(65,1.0,-1,-1)]
_80 = [(65,1.0,-1,-1)]
_81 = [(64,1.0,-1,-1)]
_82 = [(64,1.0,-1,-1)]
_83 = [(62,1.0,-1,-1)]
_84 = [(62,1.0,-1,-1)]
_85 = [(60,2.0,-1,-1)]
_71 = createseq([_72,_73,_74,_75,_76,_77,_78,_79,_80,_81,_82,_83,_84,_85])
s = _71
############################ LINE = 23
p[0] = [0]
p[2] = 1
addnotes(p)
############################ LINE = 24
pp[0] = [0]
pp[2] = 1
pp[0] = [non]
addnotes(pp)
############################ LINE = 25
pp[0] = [0]
pp[2] = 1
pp[0] = n
addnotes(pp)
############################ LINE = 43
_86 = setinstrument(twinkle, piano)
_86 = [[-1], _86, -1]
_86[0] = [0]
_86[2] = 1
addnotes(_86)
############################ LINE = 45
_89 = [(60,1.0,-1,-1)]
_90 = [(60,1.0,-1,-1)]
_91 = [(67,1.0,-1,-1)]
_92 = [(67,1.0,-1,-1)]
_93 = [(69,1.0,-1,-1)]
_94 = [(69,1.0,-1,-1)]
_95 = [(67,2.0,-1,-1)]
_96 = [(65,1.0,-1,-1)]
_97 = [(65,1.0,-1,-1)]
_98 = [(64,1.0,-1,-1)]
_99 = [(64,1.0,-1,-1)]
_100 = [(62,1.0,-1,-1)]
_101 = [(62,1.0,-1,-1)]
_102 = [(60,2.0,-1,-1)]
_88 = createseq([_89,_90,_91,_92,_93,_94,_95,_96,_97,_98,_99,_100,_101,_102])
_87 = setinstrument(_88, piano)
_87 = [[-1], _87, -1]
_87[0] = [0]
_87[2] = 1
addnotes(_87)
############################ LINE = 48
_106 = [(62,1.5,-1,-1)]
_107 = [(62,0.5,-1,-1)]
_108 = [(64,1.0,-1,-1)]
_109 = [(62,1.0,-1,-1)]
_110 = [(67,1.0,-1,-1)]
_111 = [(65,2.0,-1,-1)]
_105 = createseq([_106,_107,_108,_109,_110,_111])
_104 = setinstrument(_105, piano)
_104 = [[-1], _104, -1]
_114 = [(62,1.5,-1,-1)]
_115 = [(62,0.5,-1,-1)]
_116 = [(64,1.0,-1,-1)]
_117 = [(62,1.0,-1,-1)]
_118 = [(69,1.0,-1,-1)]
_119 = [(67,2.0,-1,-1)]
_113 = createseq([_114,_115,_116,_117,_118,_119])
_112 = setinstrument(_113, bass)
_112 = [[-1], _112, -1]
_103 = [_104,_112]
p_a = _103
############################ LINE = 55
_120 = [band,violin]
new_band = _120
############################ LINE = 59
intro3 = p_a[0]
############################ LINE = 61
for inst in band:

############################ LINE = 62
_121 = setinstrument(twinkle, inst)
_121 = [[-1], _121, -1]
_121[0] = [0]
_121[2] = 1
addnotes(_121)

with open("out.mid", 'wb') as file:
    midi.writeFile(file) #Writting the file
    print("MIDI File Written")
