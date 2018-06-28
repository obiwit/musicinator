from midiutil import MIDIFile
from math import ceil
import sys
import copy

bpm = 320
midi = MIDIFile(numTracks=10, file_format=1, deinterleave=False)
midi.addTempo(0,0,bpm)
currchannel = 0
longest = 0
ch_inst = []

flute = [74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74, 74]
bass = [44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44]
piano = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
violin = [41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41]
strings = [45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45]
drums = [119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119]
guitar = [25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25, 25]
cello = [43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43, 43]

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

def exportfile(name):
    with open(name, 'wb') as file:
        midi.writeFile(file) #Writting the file
        print("MIDI File Written")

################# LINE = 3
# original instruction =  sequencewaltz=[BC5D5BG{2}BC5D5BG{2}G5F5E5{2}E5{2}E5{2}E5{3}D5C5BA{2}A{2}A{2}D5{3}C5C5AGFGBAFG4D5F5G5{2}G5{2}A5{2}G5{2}G5{2}A5{2}G5{2}A5{2}B5{2}A5F5D5{2}E5F5G5F5G5D5F5D5G5F5G5D5F5D5G5{2}D5C5BAG4GBD5{2}D#5C5D5C5D5BE5D5C5BA{2}A{2}D5{2}B{2}R{2}GBD5{2}D5C#5D5C5D5BE5D5C5BA{2}AGABG4D5{2}G5{2}G5{2}B5G5D5{2}D5G5D5BG{2}GFGBB{2}A{2}D5F5G5{2}G5{2}B5G5D5{2}D5{2}G5D5BD5GBAFG{4}];
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
################# LINE = 49
# original instruction =  at2playwaltz+12onpiano;
_141 = 12
_140 = modPitch(waltz, _141)
_139 = setinstrument(_140, piano)
_139 = [[-1], _139, -1]
_142 = 0
_143 = _139
_143[0] = [_142]
_143[2] = 1
_143 = prepplay(_143)
_144 = 2
_148 = 12
_147 = modPitch(waltz, _148)
_146 = setinstrument(_147, piano)
_146 = [[-1], _146, -1]
_149 = 0
_150 = _146
_150[0] = [_149]
_150[2] = 1
_150 = prepplay(_150)
_145 = _146
_145 = offsetstart(_145, [_144])
_145 = prepplay(_145)
addnotes(_145)
################# LINE = 50
# original instruction =  at1playwaltzonflute;
_151 = setinstrument(waltz, flute)
_151 = [[-1], _151, -1]
_152 = 0
_153 = _151
_153[0] = [_152]
_153[2] = 1
_153 = prepplay(_153)
_154 = 1
_156 = setinstrument(waltz, flute)
_156 = [[-1], _156, -1]
_157 = 0
_158 = _156
_158[0] = [_157]
_158[2] = 1
_158 = prepplay(_158)
_155 = _156
_155 = offsetstart(_155, [_154])
_155 = prepplay(_155)
addnotes(_155)
################# LINE = 51
# original instruction =  playwaltz-24onbass;
_161 = 24
_160 = modPitch(waltz, -1*_161)
_159 = setinstrument(_160, bass)
_159 = [[-1], _159, -1]
_162 = 0
_163 = _159
_163[0] = [_162]
_163[2] = 1
_163 = prepplay(_163)
addnotes(_163)
################# LINE = 53
# original instruction =  loop[G0B0D1]onstrings;
_165 = []
_166 = [(19,1.0,-1,-1)]
_165 = extendseq(_165, _166)
_167 = [(23,1.0,-1,-1)]
_165 = extendseq(_165, _167)
_168 = [(26,1.0,-1,-1)]
_165 = extendseq(_165, _168)
_164 = setinstrument(_165, strings)
_164 = [[-1], _164, -1]
_169 = _164
_169[0] = [0]
_169 = preploop(_169)
addnotes(_169)

exportfile("waltz.mid")
