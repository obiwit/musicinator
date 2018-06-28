from midiutil import MIDIFile
from math import ceil
import sys
import copy

bpm = 240
midi = MIDIFile(numTracks=65534, file_format=1, deinterleave=False)
midi.addTempo(0,0,bpm)
currchannel = 0
longest = 0
ch_inst = []

bass = [44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44]
synth = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
piano = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
violin = [41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41]
drums = [119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119]
guitar = [25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25]
cello = [43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43]
tiko = [117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117, 117]

def addnotes(notes):
    time = notes[0] #When the sequence will start time wise
    temp = -1 
    global currchannel
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
                    instrument = instrument = notes[1][i][2]
                    if note < 0:
                        continue
                except:
                    pass

                if instrument != temp: #INSTRUMENT CHANGED, SWITCH CHANNEL NOW!!
                    currchannel = checkChannel(instrument)
                    midi.addProgramChange(1, currchannel, toInsert, instrument)
                    temp = instrument

                midi.addNote(1,currchannel,note,toInsert,noteDur,100)
                print("Added note {}, with instument {} with a duration of {} on time {}, on channel {}".format(note, instrument, noteDur, (toInsert*(85/bpm)), currchannel))


def checkChannel(instrument):
    global ch_inst

    if len(ch_inst) == 0:
        ch_inst.append(instrument)
        return 0
    elif instrument in ch_inst:
        return ch_inst.index(instrument)
    elif instrument not in ch_inst:
        try:
            if len(ch_inst) >= 16:
                raise ValueError
        except ValueError:
            print("MIDI does not Support over 16 instruments/channels")
            print("Dumping and quitting")
            exportfile()
            sys.exit(-1)
        ch_inst.append(instrument)
        return ch_inst.index(instrument)



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
    newInsert = 0
    prevOriginalInsert = 0
    if type(toMod[0]) is tuple:
        for tup in toMod:
            newTempo = tup[1] / ModNumber
            if prevOriginalInsert == tup[3]: # for chords
                newInsert -= newTempo
            newtup = (tup[0], newTempo,tup[2],newInsert)
            newInsert += newTempo
            prevOriginalInsert = tup[3]
            modded.append(newtup)
        return modded
    else:
        temp = copy.deepcopy(toMod)
        for tup in toMod[1]:
            newTempo = tup[1] / ModNumber
            if prevOriginalInsert == tup[3]: # for chords
                newInsert -= newTempo
            newtup = (tup[0], newTempo,tup[2],newInsert)
            newInsert += newTempo
            prevOriginalInsert = tup[3]
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

def exportfile(name):
    with open(name, 'wb') as file:
        midi.writeFile(file) #Writting the file
        print("MIDI File Written")

############################ LINE = 2
_0 = []
_1 = [(60,1.0,-1,-1)]
_0 = extendseq(_0, _1)
_2 = [(60,1.0,-1,-1)]
_0 = extendseq(_0, _2)
_3 = [(58,1.0,-1,-1)]
_0 = extendseq(_0, _3)
_4 = [(58,1.0,-1,-1)]
_0 = extendseq(_0, _4)
_5 = [(60,1.0,-1,-1)]
_0 = extendseq(_0, _5)
_6 = [(60,1.0,-1,-1)]
_0 = extendseq(_0, _6)
_7 = [(65,1.0,-1,-1)]
_0 = extendseq(_0, _7)
_8 = [(65,1.0,-1,-1)]
_0 = extendseq(_0, _8)
s1 = _0
############################ LINE = 3
_9 = []
_10 = [(63,1.0,-1,-1)]
_9 = extendseq(_9, _10)
_11 = [(63,1.0,-1,-1)]
_9 = extendseq(_9, _11)
_12 = [(62,1.0,-1,-1)]
_9 = extendseq(_9, _12)
_13 = [(62,1.0,-1,-1)]
_9 = extendseq(_9, _13)
_14 = [(63,1.0,-1,-1)]
_9 = extendseq(_9, _14)
_15 = [(63,1.0,-1,-1)]
_9 = extendseq(_9, _15)
_16 = [(67,1.0,-1,-1)]
_9 = extendseq(_9, _16)
_17 = [(67,1.0,-1,-1)]
_9 = extendseq(_9, _17)
s2 = _9
############################ LINE = 4
_18 = []
_19 = [(65,1.0,-1,-1)]
_18 = extendseq(_18, _19)
_20 = [(65,1.0,-1,-1)]
_18 = extendseq(_18, _20)
_21 = [(63,1.0,-1,-1)]
_18 = extendseq(_18, _21)
_22 = [(63,1.0,-1,-1)]
_18 = extendseq(_18, _22)
_23 = [(65,1.0,-1,-1)]
_18 = extendseq(_18, _23)
_24 = [(65,1.0,-1,-1)]
_18 = extendseq(_18, _24)
s3 = _18
############################ LINE = 5
_25 = []
_26 = [(68,1.0,-1,-1)]
_25 = extendseq(_25, _26)
_27 = [(68,1.0,-1,-1)]
_25 = extendseq(_25, _27)
_28 = [(67,1.0,-1,-1)]
_25 = extendseq(_25, _28)
_29 = [(67,1.0,-1,-1)]
_25 = extendseq(_25, _29)
_30 = [(68,1.0,-1,-1)]
_25 = extendseq(_25, _30)
_31 = [(68,1.0,-1,-1)]
_25 = extendseq(_25, _31)
_32 = [(75,1.0,-1,-1)]
_25 = extendseq(_25, _32)
_33 = [(75,1.0,-1,-1)]
_25 = extendseq(_25, _33)
s4 = _25
############################ LINE = 6
_34 = []
_35 = [(68,1.0,-1,-1)]
_34 = extendseq(_34, _35)
_36 = [(68,1.0,-1,-1)]
_34 = extendseq(_34, _36)
_37 = [(67,1.0,-1,-1)]
_34 = extendseq(_34, _37)
_38 = [(67,1.0,-1,-1)]
_34 = extendseq(_34, _38)
_39 = [(68,1.0,-1,-1)]
_34 = extendseq(_34, _39)
_40 = [(68,1.0,-1,-1)]
_34 = extendseq(_34, _40)
_41 = [(72,1.0,-1,-1)]
_34 = extendseq(_34, _41)
_42 = [(72,1.0,-1,-1)]
_34 = extendseq(_34, _42)
s5 = _34
############################ LINE = 7
_43 = []
_44 = [(68,1.0,-1,-1)]
_43 = extendseq(_43, _44)
_45 = [(68,1.0,-1,-1)]
_43 = extendseq(_43, _45)
_46 = [(67,1.0,-1,-1)]
_43 = extendseq(_43, _46)
_47 = [(67,1.0,-1,-1)]
_43 = extendseq(_43, _47)
_48 = [(68,1.0,-1,-1)]
_43 = extendseq(_43, _48)
_49 = [(68,1.0,-1,-1)]
_43 = extendseq(_43, _49)
_50 = [(70,1.0,-1,-1)]
_43 = extendseq(_43, _50)
_51 = [(70,1.0,-1,-1)]
_43 = extendseq(_43, _51)
s6 = _43
############################ LINE = 8
_52 = []
_53 = [(67,1.0,-1,-1)]
_52 = extendseq(_52, _53)
_54 = [(67,1.0,-1,-1)]
_52 = extendseq(_52, _54)
_55 = [(65,1.0,-1,-1)]
_52 = extendseq(_52, _55)
_56 = [(65,1.0,-1,-1)]
_52 = extendseq(_52, _56)
_57 = [(67,1.0,-1,-1)]
_52 = extendseq(_52, _57)
_58 = [(67,1.0,-1,-1)]
_52 = extendseq(_52, _58)
_59 = [(72,1.0,-1,-1)]
_52 = extendseq(_52, _59)
_60 = [(72,1.0,-1,-1)]
_52 = extendseq(_52, _60)
s7 = _52
############################ LINE = 9
_61 = []
_62 = [(67,1.0,-1,-1)]
_61 = extendseq(_61, _62)
_63 = [(67,1.0,-1,-1)]
_61 = extendseq(_61, _63)
_64 = [(65,1.0,-1,-1)]
_61 = extendseq(_61, _64)
_65 = [(65,1.0,-1,-1)]
_61 = extendseq(_61, _65)
_66 = [(67,1.0,-1,-1)]
_61 = extendseq(_61, _66)
_67 = [(67,1.0,-1,-1)]
_61 = extendseq(_61, _67)
_68 = [(68,1.0,-1,-1)]
_61 = extendseq(_61, _68)
_69 = [(68,1.0,-1,-1)]
_61 = extendseq(_61, _69)
_70 = [(68,1.0,-1,-1)]
_61 = extendseq(_61, _70)
_71 = [(68,1.0,-1,-1)]
_61 = extendseq(_61, _71)
_72 = [(67,1.0,-1,-1)]
_61 = extendseq(_61, _72)
_73 = [(67,1.0,-1,-1)]
_61 = extendseq(_61, _73)
_74 = [(68,1.0,-1,-1)]
_61 = extendseq(_61, _74)
_75 = [(68,1.0,-1,-1)]
_61 = extendseq(_61, _75)
_76 = [(77,1.0,-1,-1)]
_61 = extendseq(_61, _76)
_77 = [(77,1.0,-1,-1)]
_61 = extendseq(_61, _77)
_78 = [(68,1.0,-1,-1)]
_61 = extendseq(_61, _78)
_79 = [(68,1.0,-1,-1)]
_61 = extendseq(_61, _79)
_80 = [(67,1.0,-1,-1)]
_61 = extendseq(_61, _80)
_81 = [(67,1.0,-1,-1)]
_61 = extendseq(_61, _81)
_82 = [(68,1.0,-1,-1)]
_61 = extendseq(_61, _82)
_83 = [(68,1.0,-1,-1)]
_61 = extendseq(_61, _83)
_84 = [(77,1.0,-1,-1)]
_61 = extendseq(_61, _84)
_85 = [(77,1.0,-1,-1)]
_61 = extendseq(_61, _85)
_86 = [(68,1.0,-1,-1)]
_61 = extendseq(_61, _86)
_87 = [(68,1.0,-1,-1)]
_61 = extendseq(_61, _87)
_88 = [(68,1.0,-1,-1)]
_61 = extendseq(_61, _88)
_89 = [(68,1.0,-1,-1)]
_61 = extendseq(_61, _89)
_90 = [(68,1.0,-1,-1)]
_61 = extendseq(_61, _90)
s8 = _61
############################ LINE = 14
_91 = setinstrument(s1, synth)
_91 = [[-1], _91, -1]
_92 = 0
_93 = _91
_93[0] = [0]
_93[2] = 4
_93 = prepplay(_93)
addnotes(_93)
############################ LINE = 15
_94 = setinstrument(s2, synth)
_94 = [[-1], _94, -1]
_95 = 0
_96 = _94
_96[0] = [0]
_96[2] = 2
_96 = prepplay(_96)
_98 = 4
_99 = duration(s1)
_97 = _98*_99
_101 = setinstrument(s2, synth)
_101 = [[-1], _101, -1]
_102 = 0
_103 = _101
_103[0] = [0]
_103[2] = 2
_103 = prepplay(_103)
_100 = _101
_100 = offsetstart(_100, [_97])
_100 = prepplay(_100)
addnotes(_100)
############################ LINE = 16
_104 = setinstrument(s3, synth)
_104 = [[-1], _104, -1]
_105 = 0
_106 = _104
_106[0] = [0]
_106[2] = 1
_106 = prepplay(_106)
_109 = 4
_110 = duration(s1)
_108 = _109*_110
_112 = 2
_113 = duration(s2)
_111 = _112*_113
_107 = _108+_111
_115 = setinstrument(s3, synth)
_115 = [[-1], _115, -1]
_116 = 0
_117 = _115
_117[0] = [0]
_117[2] = 1
_117 = prepplay(_117)
_114 = _115
_114 = offsetstart(_114, [_107])
_114 = prepplay(_114)
addnotes(_114)
############################ LINE = 18
_121 = 4
_122 = duration(s1)
_120 = _121*_122
_124 = 2
_125 = duration(s2)
_123 = _124*_125
_119 = _120+_123
_126 = duration(s3)
_118 = _119+_126
t1 = _118
############################ LINE = 19
_128 = []
_129 = [(70,1.0,-1,-1)]
_128 = extendseq(_128, _129)
_130 = [(70,1.0,-1,-1)]
_128 = extendseq(_128, _130)
_127 = setinstrument(_128, synth)
_127 = [[-1], _127, -1]
_131 = 0
_132 = _127
_132[0] = [0]
_132[2] = 1
_132 = prepplay(_132)
_135 = []
_136 = [(70,1.0,-1,-1)]
_135 = extendseq(_135, _136)
_137 = [(70,1.0,-1,-1)]
_135 = extendseq(_135, _137)
_134 = setinstrument(_135, synth)
_134 = [[-1], _134, -1]
_138 = 0
_139 = _134
_139[0] = [0]
_139[2] = 1
_139 = prepplay(_139)
_133 = _134
_133 = offsetstart(_133, [t1])
_133 = prepplay(_133)
addnotes(_133)
############################ LINE = 21
_141 = []
_142 = [(70,1.0,-1,-1)]
_141 = extendseq(_141, _142)
_143 = [(70,1.0,-1,-1)]
_141 = extendseq(_141, _143)
_140 = setinstrument(_141, synth)
_140 = [[-1], _140, -1]
ps1 = _140
############################ LINE = 23
_145 = duration(ps1)
_144 = t1+_145
t2 = _144
############################ LINE = 24
_146 = setinstrument(s3, synth)
_146 = [[-1], _146, -1]
_147 = 0
_148 = _146
_148[0] = [0]
_148[2] = 1
_148 = prepplay(_148)
_150 = setinstrument(s3, synth)
_150 = [[-1], _150, -1]
_151 = 0
_152 = _150
_152[0] = [0]
_152[2] = 1
_152 = prepplay(_152)
_149 = _150
_149 = offsetstart(_149, [t2])
_149 = prepplay(_149)
addnotes(_149)
############################ LINE = 26
_154 = duration(s3)
_153 = t2+_154
t3 = _153
############################ LINE = 27
_156 = []
_157 = [(67,1.0,-1,-1)]
_156 = extendseq(_156, _157)
_158 = [(67,1.0,-1,-1)]
_156 = extendseq(_156, _158)
_155 = setinstrument(_156, synth)
_155 = [[-1], _155, -1]
_159 = 0
_160 = _155
_160[0] = [0]
_160[2] = 1
_160 = prepplay(_160)
_163 = []
_164 = [(67,1.0,-1,-1)]
_163 = extendseq(_163, _164)
_165 = [(67,1.0,-1,-1)]
_163 = extendseq(_163, _165)
_162 = setinstrument(_163, synth)
_162 = [[-1], _162, -1]
_166 = 0
_167 = _162
_167[0] = [0]
_167[2] = 1
_167 = prepplay(_167)
_161 = _162
_161 = offsetstart(_161, [t3])
_161 = prepplay(_161)
addnotes(_161)
############################ LINE = 30
_169 = []
_170 = [(67,1.0,-1,-1)]
_169 = extendseq(_169, _170)
_171 = [(67,1.0,-1,-1)]
_169 = extendseq(_169, _171)
_168 = setinstrument(_169, synth)
_168 = [[-1], _168, -1]
ps2 = _168
############################ LINE = 32
_173 = duration(ps2)
_172 = t3+_173
t4 = _172
############################ LINE = 33
_174 = setinstrument(s5, synth)
_174 = [[-1], _174, -1]
_175 = 0
_176 = _174
_176[0] = [0]
_176[2] = 2
_176 = prepplay(_176)
_178 = setinstrument(s5, synth)
_178 = [[-1], _178, -1]
_179 = 0
_180 = _178
_180[0] = [0]
_180[2] = 2
_180 = prepplay(_180)
_177 = _178
_177 = offsetstart(_177, [t4])
_177 = prepplay(_177)
addnotes(_177)
############################ LINE = 35
_183 = 2
_184 = duration(s5)
_182 = _183*_184
_181 = t4+_182
t5 = _181
############################ LINE = 36
_185 = setinstrument(s4, synth)
_185 = [[-1], _185, -1]
_186 = 0
_187 = _185
_187[0] = [0]
_187[2] = 1
_187 = prepplay(_187)
_189 = setinstrument(s4, synth)
_189 = [[-1], _189, -1]
_190 = 0
_191 = _189
_191[0] = [0]
_191[2] = 1
_191 = prepplay(_191)
_188 = _189
_188 = offsetstart(_188, [t5])
_188 = prepplay(_188)
addnotes(_188)
############################ LINE = 38
_193 = duration(s4)
_192 = t5+_193
t6 = _192
############################ LINE = 39
_194 = setinstrument(s6, synth)
_194 = [[-1], _194, -1]
_195 = 0
_196 = _194
_196[0] = [0]
_196[2] = 1
_196 = prepplay(_196)
_198 = setinstrument(s6, synth)
_198 = [[-1], _198, -1]
_199 = 0
_200 = _198
_200[0] = [0]
_200[2] = 1
_200 = prepplay(_200)
_197 = _198
_197 = offsetstart(_197, [t6])
_197 = prepplay(_197)
addnotes(_197)
############################ LINE = 40
_202 = duration(s6)
_201 = t6+_202
t7 = _201
############################ LINE = 41
_203 = setinstrument(s7, synth)
_203 = [[-1], _203, -1]
_204 = 0
_205 = _203
_205[0] = [0]
_205[2] = 1
_205 = prepplay(_205)
_207 = setinstrument(s7, synth)
_207 = [[-1], _207, -1]
_208 = 0
_209 = _207
_209[0] = [0]
_209[2] = 1
_209 = prepplay(_209)
_206 = _207
_206 = offsetstart(_206, [t7])
_206 = prepplay(_206)
addnotes(_206)
############################ LINE = 42
_211 = duration(s7)
_210 = t7+_211
t8 = _210
############################ LINE = 43
_212 = setinstrument(s8, synth)
_212 = [[-1], _212, -1]
_213 = 0
_214 = _212
_214[0] = [0]
_214[2] = 1
_214 = prepplay(_214)
_216 = setinstrument(s8, synth)
_216 = [[-1], _216, -1]
_217 = 0
_218 = _216
_218[0] = [0]
_218[2] = 1
_218 = prepplay(_218)
_215 = _216
_215 = offsetstart(_215, [t8])
_215 = prepplay(_215)
addnotes(_215)
############################ LINE = 50
_219 = 62
tl1 = _219
############################ LINE = 51
_220 = []
_221 = [(55,1.0,-1,-1)]
_220 = extendseq(_220, _221)
_222 = [(55,1.0,-1,-1)]
_220 = extendseq(_220, _222)
_223 = [(56,1.0,-1,-1)]
_220 = extendseq(_220, _223)
_224 = [(56,1.0,-1,-1)]
_220 = extendseq(_220, _224)
_225 = [(56,1.0,-1,-1)]
_220 = extendseq(_220, _225)
_226 = [(56,1.0,-1,-1)]
_220 = extendseq(_220, _226)
_227 = [(56,1.0,-1,-1)]
_220 = extendseq(_220, _227)
_228 = [(56,1.0,-1,-1)]
_220 = extendseq(_220, _228)
_229 = [(56,1.0,-1,-1)]
_220 = extendseq(_220, _229)
_230 = [(56,1.0,-1,-1)]
_220 = extendseq(_220, _230)
_231 = [(56,1.0,-1,-1)]
_220 = extendseq(_220, _231)
_232 = [(56,1.0,-1,-1)]
_220 = extendseq(_220, _232)
_233 = [(56,1.0,-1,-1)]
_220 = extendseq(_220, _233)
_234 = [(56,1.0,-1,-1)]
_220 = extendseq(_220, _234)
_235 = [(56,1.0,-1,-1)]
_220 = extendseq(_220, _235)
_236 = [(56,1.0,-1,-1)]
_220 = extendseq(_220, _236)
pl1 = _220
############################ LINE = 52
_237 = setinstrument(pl1, synth)
_237 = [[-1], _237, -1]
_238 = 0
_239 = _237
_239[0] = [0]
_239[2] = 2
_239 = prepplay(_239)
_241 = setinstrument(pl1, synth)
_241 = [[-1], _241, -1]
_242 = 0
_243 = _241
_243[0] = [0]
_243[2] = 2
_243 = prepplay(_243)
_240 = _241
_240 = offsetstart(_240, [tl1])
_240 = prepplay(_240)
addnotes(_240)
############################ LINE = 53
_246 = 2
_247 = duration(pl1)
_245 = _246*_247
_244 = tl1+_245
tl2 = _244
############################ LINE = 54
_248 = []
_249 = [(58,1.0,-1,-1)]
_248 = extendseq(_248, _249)
_250 = [(58,1.0,-1,-1)]
_248 = extendseq(_248, _250)
_251 = [(55,1.0,-1,-1)]
_248 = extendseq(_248, _251)
_252 = [(55,1.0,-1,-1)]
_248 = extendseq(_248, _252)
_253 = [(55,1.0,-1,-1)]
_248 = extendseq(_248, _253)
_254 = [(55,1.0,-1,-1)]
_248 = extendseq(_248, _254)
_255 = [(55,1.0,-1,-1)]
_248 = extendseq(_248, _255)
_256 = [(55,1.0,-1,-1)]
_248 = extendseq(_248, _256)
_257 = [(55,1.0,-1,-1)]
_248 = extendseq(_248, _257)
_258 = [(55,1.0,-1,-1)]
_248 = extendseq(_248, _258)
_259 = [(55,1.0,-1,-1)]
_248 = extendseq(_248, _259)
_260 = [(55,1.0,-1,-1)]
_248 = extendseq(_248, _260)
_261 = [(55,1.0,-1,-1)]
_248 = extendseq(_248, _261)
_262 = [(55,1.0,-1,-1)]
_248 = extendseq(_248, _262)
_263 = [(55,1.0,-1,-1)]
_248 = extendseq(_248, _263)
_264 = [(55,1.0,-1,-1)]
_248 = extendseq(_248, _264)
pl2 = _248
############################ LINE = 55
_265 = setinstrument(pl2, synth)
_265 = [[-1], _265, -1]
_266 = 0
_267 = _265
_267[0] = [0]
_267[2] = 1
_267 = prepplay(_267)
_269 = setinstrument(pl2, synth)
_269 = [[-1], _269, -1]
_270 = 0
_271 = _269
_271[0] = [0]
_271[2] = 1
_271 = prepplay(_271)
_268 = _269
_268 = offsetstart(_268, [tl2])
_268 = prepplay(_268)
addnotes(_268)
############################ LINE = 56
_273 = duration(pl2)
_272 = tl2+_273
tl3 = _272
############################ LINE = 57
_274 = []
_275 = [(51,1.0,-1,-1)]
_274 = extendseq(_274, _275)
_276 = [(51,1.0,-1,-1)]
_274 = extendseq(_274, _276)
_277 = [(53,1.0,-1,-1)]
_274 = extendseq(_274, _277)
_278 = [(53,1.0,-1,-1)]
_274 = extendseq(_274, _278)
_279 = [(53,1.0,-1,-1)]
_274 = extendseq(_274, _279)
_280 = [(53,1.0,-1,-1)]
_274 = extendseq(_274, _280)
_281 = [(53,1.0,-1,-1)]
_274 = extendseq(_274, _281)
_282 = [(53,1.0,-1,-1)]
_274 = extendseq(_274, _282)
_283 = [(53,1.0,-1,-1)]
_274 = extendseq(_274, _283)
_284 = [(53,1.0,-1,-1)]
_274 = extendseq(_274, _284)
_285 = [(53,1.0,-1,-1)]
_274 = extendseq(_274, _285)
_286 = [(53,1.0,-1,-1)]
_274 = extendseq(_274, _286)
_287 = [(53,1.0,-1,-1)]
_274 = extendseq(_274, _287)
_288 = [(53,1.0,-1,-1)]
_274 = extendseq(_274, _288)
_289 = [(53,1.0,-1,-1)]
_274 = extendseq(_274, _289)
_290 = [(53,1.0,-1,-1)]
_274 = extendseq(_274, _290)
_291 = [(53,1.0,-1,-1)]
_274 = extendseq(_274, _291)
_292 = [(53,1.0,-1,-1)]
_274 = extendseq(_274, _292)
pl3 = _274
############################ LINE = 58
_293 = setinstrument(pl3, synth)
_293 = [[-1], _293, -1]
_294 = 0
_295 = _293
_295[0] = [0]
_295[2] = 1
_295 = prepplay(_295)
_297 = setinstrument(pl3, synth)
_297 = [[-1], _297, -1]
_298 = 0
_299 = _297
_299[0] = [0]
_299[2] = 1
_299 = prepplay(_299)
_296 = _297
_296 = offsetstart(_296, [tl3])
_296 = prepplay(_296)
addnotes(_296)
############################ LINE = 59
_301 = duration(pl3)
_300 = tl3+_301
tl4 = _300
############################ LINE = 60
_302 = []
_303 = [(60,1.0,-1,-1)]
_302 = extendseq(_302, _303)
_304 = [(60,1.0,-1,-1)]
_302 = extendseq(_302, _304)
_305 = [(60,1.0,-1,-1)]
_302 = extendseq(_302, _305)
_306 = [(60,1.0,-1,-1)]
_302 = extendseq(_302, _306)
_307 = [(60,1.0,-1,-1)]
_302 = extendseq(_302, _307)
pl4 = _302
############################ LINE = 61
_308 = setinstrument(pl4, synth)
_308 = [[-1], _308, -1]
_309 = 0
_310 = _308
_310[0] = [0]
_310[2] = 1
_310 = prepplay(_310)
_312 = setinstrument(pl4, synth)
_312 = [[-1], _312, -1]
_313 = 0
_314 = _312
_314[0] = [0]
_314[2] = 1
_314 = prepplay(_314)
_311 = _312
_311 = offsetstart(_311, [tl4])
_311 = prepplay(_311)
addnotes(_311)
############################ LINE = 64
_316 = []
_317 = [(41,1.0,-1,-1)]
_316 = extendseq(_316, _317)
_318 = [(-49,1.0,-1,-1)]
_316 = extendseq(_316, _318)
_319 = [(-49,1.0,-1,-1)]
_316 = extendseq(_316, _319)
_320 = [(41,1.0,-1,-1)]
_316 = extendseq(_316, _320)
_321 = [(41,1.0,-1,-1)]
_316 = extendseq(_316, _321)
_322 = [(-49,1.0,-1,-1)]
_316 = extendseq(_316, _322)
_323 = [(-49,1.0,-1,-1)]
_316 = extendseq(_316, _323)
_324 = [(-49,1.0,-1,-1)]
_316 = extendseq(_316, _324)
_325 = [(41,1.0,-1,-1)]
_316 = extendseq(_316, _325)
_326 = [(-49,1.0,-1,-1)]
_316 = extendseq(_316, _326)
_327 = [(-49,1.0,-1,-1)]
_316 = extendseq(_316, _327)
_328 = [(41,1.0,-1,-1)]
_316 = extendseq(_316, _328)
_329 = [(41,1.0,-1,-1)]
_316 = extendseq(_316, _329)
_330 = [(-49,1.0,-1,-1)]
_316 = extendseq(_316, _330)
_331 = [(-49,1.0,-1,-1)]
_316 = extendseq(_316, _331)
_332 = [(-49,1.0,-1,-1)]
_316 = extendseq(_316, _332)
_315 = setinstrument(_316, tiko)
_315 = [[-1], _315, -1]
p1 = _315
############################ LINE = 65
_334 = 3
_333 = modPitch(p1, _334)
p2 = _333
############################ LINE = 66
_336 = 5
_335 = modPitch(p1, -1*_336)
p3 = _335
############################ LINE = 67
_338 = 4
_337 = modPitch(p1, -1*_338)
p4 = _337
############################ LINE = 68
_339 = duration(p1)
n1 = _339
############################ LINE = 69
_341 = duration(p2)
_340 = n1+_341
n2 = _340
############################ LINE = 70
_343 = duration(p3)
_342 = n2+_343
n3 = _342
############################ LINE = 71
_345 = duration(p4)
_344 = n3+_345
n4 = _344
############################ LINE = 72
_347 = duration(p1)
_346 = n4+_347
n5 = _346
############################ LINE = 73
_349 = duration(p2)
_348 = n5+_349
n6 = _348
############################ LINE = 74
_351 = duration(p3)
_350 = n6+_351
n7 = _350
############################ LINE = 76
_352 = 0
_353 = p1
_353[0] = [0]
_353[2] = 1
_353 = prepplay(_353)
addnotes(_353)
############################ LINE = 77
_354 = 0
_355 = p2
_355[0] = [0]
_355[2] = 1
_355 = prepplay(_355)
_357 = 0
_358 = p2
_358[0] = [0]
_358[2] = 1
_358 = prepplay(_358)
_356 = p2
_356 = offsetstart(_356, [n1])
_356 = prepplay(_356)
addnotes(_356)
############################ LINE = 78
_359 = 0
_360 = p3
_360[0] = [0]
_360[2] = 1
_360 = prepplay(_360)
_362 = 0
_363 = p3
_363[0] = [0]
_363[2] = 1
_363 = prepplay(_363)
_361 = p3
_361 = offsetstart(_361, [n2])
_361 = prepplay(_361)
addnotes(_361)
############################ LINE = 79
_364 = 0
_365 = p4
_365[0] = [0]
_365[2] = 1
_365 = prepplay(_365)
_367 = 0
_368 = p4
_368[0] = [0]
_368[2] = 1
_368 = prepplay(_368)
_366 = p4
_366 = offsetstart(_366, [n3])
_366 = prepplay(_366)
addnotes(_366)
############################ LINE = 80
_369 = 0
_370 = p1
_370[0] = [0]
_370[2] = 1
_370 = prepplay(_370)
_372 = 0
_373 = p1
_373[0] = [0]
_373[2] = 1
_373 = prepplay(_373)
_371 = p1
_371 = offsetstart(_371, [n4])
_371 = prepplay(_371)
addnotes(_371)
############################ LINE = 81
_374 = 0
_375 = p2
_375[0] = [0]
_375[2] = 1
_375 = prepplay(_375)
_377 = 0
_378 = p2
_378[0] = [0]
_378[2] = 1
_378 = prepplay(_378)
_376 = p2
_376 = offsetstart(_376, [n5])
_376 = prepplay(_376)
addnotes(_376)
############################ LINE = 82
_379 = 0
_380 = p3
_380[0] = [0]
_380[2] = 1
_380 = prepplay(_380)
_382 = 0
_383 = p3
_383[0] = [0]
_383[2] = 1
_383 = prepplay(_383)
_381 = p3
_381 = offsetstart(_381, [n6])
_381 = prepplay(_381)
addnotes(_381)
############################ LINE = 83
_384 = 0
_385 = p1
_385[0] = [0]
_385[2] = 1
_385 = prepplay(_385)
_387 = 0
_388 = p1
_388[0] = [0]
_388[2] = 1
_388 = prepplay(_388)
_386 = p1
_386 = offsetstart(_386, [n7])
_386 = prepplay(_386)
addnotes(_386)

exportfile("out.mid")
