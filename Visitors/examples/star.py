from midiutil import MIDIFile
from math import ceil
import sys
import copy

bpm = 320
midi = MIDIFile(numTracks=65534, file_format=1)
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


############################ LINE = 1
_0 = []
_1 = [(-49,3.0,-1,-1)]
_0 = extendseq(_0, _1)
_2 = [(69,0.875,-1,-1)]
_0 = extendseq(_0, _2)
_3 = [(-49,0.125,-1,-1)]
_0 = extendseq(_0, _3)
_4 = [(77,0.5,-1,-1)]
_0 = extendseq(_0, _4)
_5 = [(74,0.5,-1,-1)]
_0 = extendseq(_0, _5)
_6 = [(74,0.875,-1,-1)]
_0 = extendseq(_0, _6)
_7 = [(-49,0.125,-1,-1)]
_0 = extendseq(_0, _7)
_8 = [(72,0.5,-1,-1)]
_0 = extendseq(_0, _8)
_9 = [(69,0.5,-1,-1)]
_0 = extendseq(_0, _9)
_10 = [(69,0.5,-1,-1)]
_0 = extendseq(_0, _10)
_11 = [(75,1.0,-1,-1)]
_0 = extendseq(_0, _11)
_12 = [(74,0.5,-1,-1)]
_0 = extendseq(_0, _12)
_13 = [(74,0.5,-1,-1)]
_0 = extendseq(_0, _13)
_14 = [(72,0.5,-1,-1)]
_0 = extendseq(_0, _14)
_15 = [(72,0.5,-1,-1)]
_0 = extendseq(_0, _15)
_16 = [(69,0.5,-1,-1)]
_0 = extendseq(_0, _16)
_17 = [(-49,0.5,-1,-1)]
_0 = extendseq(_0, _17)
_18 = [(69,0.5,-1,-1)]
_0 = extendseq(_0, _18)
_19 = [(77,0.5,-1,-1)]
_0 = extendseq(_0, _19)
_20 = [(74,0.5,-1,-1)]
_0 = extendseq(_0, _20)
_21 = [(74,0.5,-1,-1)]
_0 = extendseq(_0, _21)
_22 = [(72,0.5,-1,-1)]
_0 = extendseq(_0, _22)
_23 = [(72,0.5,-1,-1)]
_0 = extendseq(_0, _23)
_24 = [(69,0.5,-1,-1)]
_0 = extendseq(_0, _24)
_25 = [(69,0.5,-1,-1)]
_0 = extendseq(_0, _25)
_26 = [(67,1.0,-1,-1)]
_0 = extendseq(_0, _26)
_27 = [(65,1.375,-1,-1)]
_0 = extendseq(_0, _27)
_28 = [(-49,0.125,-1,-1)]
_0 = extendseq(_0, _28)
_29 = [(69,0.5,-1,-1)]
_0 = extendseq(_0, _29)
_30 = [(69,0.5,-1,-1)]
_0 = extendseq(_0, _30)
_31 = [(77,0.5,-1,-1)]
_0 = extendseq(_0, _31)
_32 = [(74,0.5,-1,-1)]
_0 = extendseq(_0, _32)
_33 = [(74,0.5,-1,-1)]
_0 = extendseq(_0, _33)
_34 = [(72,0.5,-1,-1)]
_0 = extendseq(_0, _34)
_35 = [(72,0.5,-1,-1)]
_0 = extendseq(_0, _35)
_36 = [(69,0.5,-1,-1)]
_0 = extendseq(_0, _36)
_37 = [(69,0.5,-1,-1)]
_0 = extendseq(_0, _37)
_38 = [(75,1.0,-1,-1)]
_0 = extendseq(_0, _38)
_39 = [(74,0.5,-1,-1)]
_0 = extendseq(_0, _39)
_40 = [(74,0.5,-1,-1)]
_0 = extendseq(_0, _40)
_41 = [(72,0.5,-1,-1)]
_0 = extendseq(_0, _41)
_42 = [(72,0.5,-1,-1)]
_0 = extendseq(_0, _42)
_43 = [(69,0.5,-1,-1)]
_0 = extendseq(_0, _43)
_44 = [(69,0.5,-1,-1)]
_0 = extendseq(_0, _44)
_45 = [(77,1.0,-1,-1)]
_0 = extendseq(_0, _45)
_46 = [(74,0.5,-1,-1)]
_0 = extendseq(_0, _46)
_47 = [(74,0.5,-1,-1)]
_0 = extendseq(_0, _47)
_48 = [(72,1.0,-1,-1)]
_0 = extendseq(_0, _48)
_49 = [(69,0.5,-1,-1)]
_0 = extendseq(_0, _49)
_50 = [(69,0.5,-1,-1)]
_0 = extendseq(_0, _50)
_51 = [(72,1.0,-1,-1)]
_0 = extendseq(_0, _51)
_52 = [(67,1.375,-1,-1)]
_0 = extendseq(_0, _52)
intro = _0
############################ LINE = 8
_55 = 12
_54 = modPitch(intro, -1*_55)
_53 = setinstrument(_54, strings)
_53 = [[-1], _53, -1]
_56 = 0
_57 = _53
_57[0] = [0]
_57[2] = 1
_57 = prepplay(_57)
addnotes(_57)

with open("out.mid", 'wb') as file:
    midi.writeFile(file) #Writting the file
    print("MIDI File Written")
