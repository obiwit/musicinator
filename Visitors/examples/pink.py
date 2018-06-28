from midiutil import MIDIFile
from math import ceil
import sys
import copy

bpm = 180
midi = MIDIFile(numTracks=2147483647, file_format=1)
midi.addTempo(0,0,bpm)
currtrack = 0
longest = 0

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


############################ LINE = 1
_0 = []
_1 = [(87,0.33,-1,-1)]
_0 = extendseq(_0, _1)
_2 = [(88,1.0,-1,-1)]
_0 = extendseq(_0, _2)
_3 = [(90,0.33,-1,-1)]
_0 = extendseq(_0, _3)
_4 = [(91,1.0,-1,-1)]
_0 = extendseq(_0, _4)
_5 = [(87,0.33,-1,-1)]
_0 = extendseq(_0, _5)
_6 = [(88,1.0,-1,-1)]
_0 = extendseq(_0, _6)
_7 = [(90,0.33,-1,-1)]
_0 = extendseq(_0, _7)
_8 = [(91,1.0,-1,-1)]
_0 = extendseq(_0, _8)
_9 = [(96,0.33,-1,-1)]
_0 = extendseq(_0, _9)
_10 = [(95,1.0,-1,-1)]
_0 = extendseq(_0, _10)
_11 = [(88,0.33,-1,-1)]
_0 = extendseq(_0, _11)
_12 = [(91,1.0,-1,-1)]
_0 = extendseq(_0, _12)
_13 = [(95,0.33,-1,-1)]
_0 = extendseq(_0, _13)
_14 = [(94,3.0,-1,-1)]
_0 = extendseq(_0, _14)
_15 = [(93,0.6,-1,-1)]
_0 = extendseq(_0, _15)
_16 = [(91,0.6,-1,-1)]
_0 = extendseq(_0, _16)
_17 = [(88,0.6,-1,-1)]
_0 = extendseq(_0, _17)
_18 = [(86,0.6,-1,-1)]
_0 = extendseq(_0, _18)
_19 = [(88,3.0,-1,-1)]
_0 = extendseq(_0, _19)
_20 = [(87,0.33,-1,-1)]
_0 = extendseq(_0, _20)
_21 = [(88,1.0,-1,-1)]
_0 = extendseq(_0, _21)
_22 = [(90,0.33,-1,-1)]
_0 = extendseq(_0, _22)
_23 = [(91,1.0,-1,-1)]
_0 = extendseq(_0, _23)
_24 = [(87,0.33,-1,-1)]
_0 = extendseq(_0, _24)
_25 = [(88,1.0,-1,-1)]
_0 = extendseq(_0, _25)
_26 = [(90,0.33,-1,-1)]
_0 = extendseq(_0, _26)
_27 = [(91,1.0,-1,-1)]
_0 = extendseq(_0, _27)
_28 = [(96,0.33,-1,-1)]
_0 = extendseq(_0, _28)
_29 = [(95,1.0,-1,-1)]
_0 = extendseq(_0, _29)
_30 = [(91,0.33,-1,-1)]
_0 = extendseq(_0, _30)
_31 = [(95,1.0,-1,-1)]
_0 = extendseq(_0, _31)
_32 = [(100,0.33,-1,-1)]
_0 = extendseq(_0, _32)
_33 = [(99,4.0,-1,-1)]
_0 = extendseq(_0, _33)
_34 = [(87,0.33,-1,-1)]
_0 = extendseq(_0, _34)
_35 = [(88,1.0,-1,-1)]
_0 = extendseq(_0, _35)
_36 = [(90,0.33,-1,-1)]
_0 = extendseq(_0, _36)
_37 = [(91,1.0,-1,-1)]
_0 = extendseq(_0, _37)
_38 = [(87,0.33,-1,-1)]
_0 = extendseq(_0, _38)
_39 = [(88,1.0,-1,-1)]
_0 = extendseq(_0, _39)
_40 = [(90,0.33,-1,-1)]
_0 = extendseq(_0, _40)
_41 = [(91,1.0,-1,-1)]
_0 = extendseq(_0, _41)
_42 = [(96,0.33,-1,-1)]
_0 = extendseq(_0, _42)
_43 = [(95,1.0,-1,-1)]
_0 = extendseq(_0, _43)
_44 = [(88,0.33,-1,-1)]
_0 = extendseq(_0, _44)
_45 = [(91,1.0,-1,-1)]
_0 = extendseq(_0, _45)
_46 = [(95,0.33,-1,-1)]
_0 = extendseq(_0, _46)
_47 = [(94,3.0,-1,-1)]
_0 = extendseq(_0, _47)
_48 = [(93,0.6,-1,-1)]
_0 = extendseq(_0, _48)
_49 = [(91,0.6,-1,-1)]
_0 = extendseq(_0, _49)
_50 = [(88,0.6,-1,-1)]
_0 = extendseq(_0, _50)
_51 = [(86,0.6,-1,-1)]
_0 = extendseq(_0, _51)
_52 = [(88,3.0,-1,-1)]
_0 = extendseq(_0, _52)
_53 = [(100,1.0,-1,-1)]
_0 = extendseq(_0, _53)
_54 = [(98,0.33,-1,-1)]
_0 = extendseq(_0, _54)
_55 = [(95,1.0,-1,-1)]
_0 = extendseq(_0, _55)
_56 = [(93,0.33,-1,-1)]
_0 = extendseq(_0, _56)
_57 = [(91,1.0,-1,-1)]
_0 = extendseq(_0, _57)
_58 = [(88,0.33,-1,-1)]
_0 = extendseq(_0, _58)
_59 = [(94,0.33,-1,-1)]
_0 = extendseq(_0, _59)
_60 = [(93,1.0,-1,-1)]
_0 = extendseq(_0, _60)
_61 = [(94,0.33,-1,-1)]
_0 = extendseq(_0, _61)
_62 = [(93,1.0,-1,-1)]
_0 = extendseq(_0, _62)
_63 = [(94,0.33,-1,-1)]
_0 = extendseq(_0, _63)
_64 = [(93,1.0,-1,-1)]
_0 = extendseq(_0, _64)
_65 = [(94,0.33,-1,-1)]
_0 = extendseq(_0, _65)
_66 = [(93,1.0,-1,-1)]
_0 = extendseq(_0, _66)
_67 = [(91,1.0,-1,-1)]
_0 = extendseq(_0, _67)
_68 = [(88,1.0,-1,-1)]
_0 = extendseq(_0, _68)
_69 = [(86,1.0,-1,-1)]
_0 = extendseq(_0, _69)
_70 = [(88,1.0,-1,-1)]
_0 = extendseq(_0, _70)
_71 = [(88,4.0,-1,-1)]
_0 = extendseq(_0, _71)
pink = _0
############################ LINE = 9
_72 = setinstrument(pink, piano)
_72 = [[-1], _72, -1]
p_pink = _72
############################ LINE = 11
_74 = getInt("How many semitones to lower? ")
_73 = modPitch(p_pink, -1*_74)
_75 = 0
_76 = _73
_76[0] = [0]
_76[2] = 1
_76 = prepplay(_76)
addnotes(_76)
############################ LINE = 12
_78 = 24
_77 = modPitch(p_pink, -1*_78)
_79 = 0
_80 = _77
_80[0] = [0]
_80[2] = 1
_80 = prepplay(_80)
_81 = duration(p_pink)
_84 = 24
_83 = modPitch(p_pink, -1*_84)
_85 = 0
_86 = _83
_86[0] = [0]
_86[2] = 1
_86 = prepplay(_86)
_82 = _83
_82 = offsetstart(_82, [_81])
_82 = prepplay(_82)
addnotes(_82)

with open("out.mid", 'wb') as file:
    midi.writeFile(file) #Writting the file
    print("MIDI File Written")
