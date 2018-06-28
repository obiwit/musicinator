from midiutil import MIDIFile
from math import ceil
import sys
import copy

bpm = 320
midi = MIDIFile(numTracks=3, file_format=1)
midi.addTempo(0,0,bpm)
currtrack = 0
longest = 0

bass = [44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44]
piano = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
violin = [41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41]
strings = [45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45]
drums = [119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119]
guitar = [25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25]
cello = [43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43]

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
        temp = copy.deepcopy(toMod)
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
        temp = copy.deepcopy(toMod)
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

def appendseq(original, toappend):
    offsetTime = duration(original)
    for tup in toappend:
        newTime = tup[3] + offsetTime
        newtup = (tup[0],tup[1],tup[2],newTime)
        original.append(newtup)
    return original

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

def offsetstart(perf, offset):
    originaltime = perf[0][0]
    perf[0] = offset
    for i in range(0,len(perf[0])):
        perf[0][i] += originaltime
    return perf


############################ LINE = 3
_0 = []
_1 = [(71,1.0,-1,-1)]
_0 = extendseq(_0, _1)
_2 = [(72,1.0,-1,-1)]
_0 = extendseq(_0, _2)
_3 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _3)
_4 = [(71,1.0,-1,-1)]
_0 = extendseq(_0, _4)
_5 = [(67,2.0,-1,-1)]
_0 = extendseq(_0, _5)
_6 = [(71,1.0,-1,-1)]
_0 = extendseq(_0, _6)
_7 = [(72,1.0,-1,-1)]
_0 = extendseq(_0, _7)
_8 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _8)
_9 = [(71,1.0,-1,-1)]
_0 = extendseq(_0, _9)
_10 = [(67,2.0,-1,-1)]
_0 = extendseq(_0, _10)
_11 = [(79,1.0,-1,-1)]
_0 = extendseq(_0, _11)
_12 = [(77,1.0,-1,-1)]
_0 = extendseq(_0, _12)
_13 = [(76,2.0,-1,-1)]
_0 = extendseq(_0, _13)
_14 = [(76,2.0,-1,-1)]
_0 = extendseq(_0, _14)
_15 = [(76,2.0,-1,-1)]
_0 = extendseq(_0, _15)
_16 = [(76,3.0,-1,-1)]
_0 = extendseq(_0, _16)
_17 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _17)
_18 = [(72,1.0,-1,-1)]
_0 = extendseq(_0, _18)
_19 = [(71,1.0,-1,-1)]
_0 = extendseq(_0, _19)
_20 = [(69,2.0,-1,-1)]
_0 = extendseq(_0, _20)
_21 = [(69,2.0,-1,-1)]
_0 = extendseq(_0, _21)
_22 = [(69,2.0,-1,-1)]
_0 = extendseq(_0, _22)
_23 = [(74,3.0,-1,-1)]
_0 = extendseq(_0, _23)
_24 = [(72,1.0,-1,-1)]
_0 = extendseq(_0, _24)
_25 = [(72,1.0,-1,-1)]
_0 = extendseq(_0, _25)
_26 = [(69,1.0,-1,-1)]
_0 = extendseq(_0, _26)
_27 = [(67,1.0,-1,-1)]
_0 = extendseq(_0, _27)
_28 = [(65,1.0,-1,-1)]
_0 = extendseq(_0, _28)
_29 = [(67,1.0,-1,-1)]
_0 = extendseq(_0, _29)
_30 = [(71,1.0,-1,-1)]
_0 = extendseq(_0, _30)
_31 = [(69,1.0,-1,-1)]
_0 = extendseq(_0, _31)
_32 = [(65,1.0,-1,-1)]
_0 = extendseq(_0, _32)
_33 = [(67,1.0,-1,-1)]
_0 = extendseq(_0, _33)
_34 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _34)
_35 = [(77,1.0,-1,-1)]
_0 = extendseq(_0, _35)
_36 = [(79,2.0,-1,-1)]
_0 = extendseq(_0, _36)
_37 = [(79,2.0,-1,-1)]
_0 = extendseq(_0, _37)
_38 = [(81,2.0,-1,-1)]
_0 = extendseq(_0, _38)
_39 = [(79,2.0,-1,-1)]
_0 = extendseq(_0, _39)
_40 = [(79,2.0,-1,-1)]
_0 = extendseq(_0, _40)
_41 = [(81,2.0,-1,-1)]
_0 = extendseq(_0, _41)
_42 = [(79,2.0,-1,-1)]
_0 = extendseq(_0, _42)
_43 = [(81,2.0,-1,-1)]
_0 = extendseq(_0, _43)
_44 = [(83,2.0,-1,-1)]
_0 = extendseq(_0, _44)
_45 = [(81,1.0,-1,-1)]
_0 = extendseq(_0, _45)
_46 = [(77,1.0,-1,-1)]
_0 = extendseq(_0, _46)
_47 = [(74,2.0,-1,-1)]
_0 = extendseq(_0, _47)
_48 = [(76,1.0,-1,-1)]
_0 = extendseq(_0, _48)
_49 = [(77,1.0,-1,-1)]
_0 = extendseq(_0, _49)
_50 = [(79,1.0,-1,-1)]
_0 = extendseq(_0, _50)
_51 = [(77,1.0,-1,-1)]
_0 = extendseq(_0, _51)
_52 = [(79,1.0,-1,-1)]
_0 = extendseq(_0, _52)
_53 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _53)
_54 = [(77,1.0,-1,-1)]
_0 = extendseq(_0, _54)
_55 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _55)
_56 = [(79,1.0,-1,-1)]
_0 = extendseq(_0, _56)
_57 = [(77,1.0,-1,-1)]
_0 = extendseq(_0, _57)
_58 = [(79,1.0,-1,-1)]
_0 = extendseq(_0, _58)
_59 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _59)
_60 = [(77,1.0,-1,-1)]
_0 = extendseq(_0, _60)
_61 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _61)
_62 = [(79,2.0,-1,-1)]
_0 = extendseq(_0, _62)
_63 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _63)
_64 = [(72,1.0,-1,-1)]
_0 = extendseq(_0, _64)
_65 = [(71,1.0,-1,-1)]
_0 = extendseq(_0, _65)
_66 = [(69,1.0,-1,-1)]
_0 = extendseq(_0, _66)
_67 = [(67,1.0,-1,-1)]
_0 = extendseq(_0, _67)
_68 = [(67,1.0,-1,-1)]
_0 = extendseq(_0, _68)
_69 = [(71,1.0,-1,-1)]
_0 = extendseq(_0, _69)
_70 = [(74,2.0,-1,-1)]
_0 = extendseq(_0, _70)
_71 = [(75,1.0,-1,-1)]
_0 = extendseq(_0, _71)
_72 = [(72,1.0,-1,-1)]
_0 = extendseq(_0, _72)
_73 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _73)
_74 = [(72,1.0,-1,-1)]
_0 = extendseq(_0, _74)
_75 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _75)
_76 = [(71,1.0,-1,-1)]
_0 = extendseq(_0, _76)
_77 = [(76,1.0,-1,-1)]
_0 = extendseq(_0, _77)
_78 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _78)
_79 = [(72,1.0,-1,-1)]
_0 = extendseq(_0, _79)
_80 = [(71,1.0,-1,-1)]
_0 = extendseq(_0, _80)
_81 = [(69,2.0,-1,-1)]
_0 = extendseq(_0, _81)
_82 = [(69,2.0,-1,-1)]
_0 = extendseq(_0, _82)
_83 = [(74,2.0,-1,-1)]
_0 = extendseq(_0, _83)
_84 = [(71,2.0,-1,-1)]
_0 = extendseq(_0, _84)
_85 = [(-49,2.0,-1,-1)]
_0 = extendseq(_0, _85)
_86 = [(67,1.0,-1,-1)]
_0 = extendseq(_0, _86)
_87 = [(71,1.0,-1,-1)]
_0 = extendseq(_0, _87)
_88 = [(74,2.0,-1,-1)]
_0 = extendseq(_0, _88)
_89 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _89)
_90 = [(73,1.0,-1,-1)]
_0 = extendseq(_0, _90)
_91 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _91)
_92 = [(72,1.0,-1,-1)]
_0 = extendseq(_0, _92)
_93 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _93)
_94 = [(71,1.0,-1,-1)]
_0 = extendseq(_0, _94)
_95 = [(76,1.0,-1,-1)]
_0 = extendseq(_0, _95)
_96 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _96)
_97 = [(72,1.0,-1,-1)]
_0 = extendseq(_0, _97)
_98 = [(71,1.0,-1,-1)]
_0 = extendseq(_0, _98)
_99 = [(69,2.0,-1,-1)]
_0 = extendseq(_0, _99)
_100 = [(69,1.0,-1,-1)]
_0 = extendseq(_0, _100)
_101 = [(67,1.0,-1,-1)]
_0 = extendseq(_0, _101)
_102 = [(69,1.0,-1,-1)]
_0 = extendseq(_0, _102)
_103 = [(71,1.0,-1,-1)]
_0 = extendseq(_0, _103)
_104 = [(67,1.0,-1,-1)]
_0 = extendseq(_0, _104)
_105 = [(74,2.0,-1,-1)]
_0 = extendseq(_0, _105)
_106 = [(79,2.0,-1,-1)]
_0 = extendseq(_0, _106)
_107 = [(79,2.0,-1,-1)]
_0 = extendseq(_0, _107)
_108 = [(83,1.0,-1,-1)]
_0 = extendseq(_0, _108)
_109 = [(79,1.0,-1,-1)]
_0 = extendseq(_0, _109)
_110 = [(74,2.0,-1,-1)]
_0 = extendseq(_0, _110)
_111 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _111)
_112 = [(79,1.0,-1,-1)]
_0 = extendseq(_0, _112)
_113 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _113)
_114 = [(71,1.0,-1,-1)]
_0 = extendseq(_0, _114)
_115 = [(67,2.0,-1,-1)]
_0 = extendseq(_0, _115)
_116 = [(67,1.0,-1,-1)]
_0 = extendseq(_0, _116)
_117 = [(65,1.0,-1,-1)]
_0 = extendseq(_0, _117)
_118 = [(67,1.0,-1,-1)]
_0 = extendseq(_0, _118)
_119 = [(71,1.0,-1,-1)]
_0 = extendseq(_0, _119)
_120 = [(71,2.0,-1,-1)]
_0 = extendseq(_0, _120)
_121 = [(69,2.0,-1,-1)]
_0 = extendseq(_0, _121)
_122 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _122)
_123 = [(77,1.0,-1,-1)]
_0 = extendseq(_0, _123)
_124 = [(79,2.0,-1,-1)]
_0 = extendseq(_0, _124)
_125 = [(79,2.0,-1,-1)]
_0 = extendseq(_0, _125)
_126 = [(83,1.0,-1,-1)]
_0 = extendseq(_0, _126)
_127 = [(79,1.0,-1,-1)]
_0 = extendseq(_0, _127)
_128 = [(74,2.0,-1,-1)]
_0 = extendseq(_0, _128)
_129 = [(74,2.0,-1,-1)]
_0 = extendseq(_0, _129)
_130 = [(79,1.0,-1,-1)]
_0 = extendseq(_0, _130)
_131 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _131)
_132 = [(71,1.0,-1,-1)]
_0 = extendseq(_0, _132)
_133 = [(74,1.0,-1,-1)]
_0 = extendseq(_0, _133)
_134 = [(67,1.0,-1,-1)]
_0 = extendseq(_0, _134)
_135 = [(71,1.0,-1,-1)]
_0 = extendseq(_0, _135)
_136 = [(69,1.0,-1,-1)]
_0 = extendseq(_0, _136)
_137 = [(65,1.0,-1,-1)]
_0 = extendseq(_0, _137)
_138 = [(67,4.0,-1,-1)]
_0 = extendseq(_0, _138)
waltz = _0
############################ LINE = 49
_139 = setinstrument(waltz, piano)
_139 = [[-1], _139, -1]
_140 = 0
_141 = _139
_141[0] = [0]
_141[2] = 1
_141 = prepplay(_141)
addnotes(_141)
############################ LINE = 50
_144 = 24
_143 = modPitch(waltz, -1*_144)
_142 = setinstrument(_143, strings)
_142 = [[-1], _142, -1]
_145 = 0
_146 = _142
_146[0] = [0]
_146[2] = 1
_146 = prepplay(_146)
addnotes(_146)

with open("out.mid", 'wb') as file:
    midi.writeFile(file) #Writting the file
    print("MIDI File Written")
