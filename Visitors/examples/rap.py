from midiutil import MIDIFile
from math import ceil
import sys
import copy

bpm = 160
midi = MIDIFile(numTracks=1000, file_format=1)
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

def offsetstart(perf, offset):
    originaltime = perf[0][0]
    perf[0] = offset
    for i in range(0,len(perf[0])):
        perf[0][i] += originaltime
    return perf


############################ LINE = 1
_2 = [(48,1.0,-1,-1)]
_3 = [(51,1.0,-1,-1)]
_4 = [(55,1.0,-1,-1)]
_5 = [(56,1.0,-1,-1)]
_6 = [(60,3.0,-1,-1)]
_7 = [(56,1.0,-1,-1)]
_8 = [(55,1.5,-1,-1)]
_9 = [(-49,0.5,-1,-1)]
_10 = [(56,1.0,-1,-1)]
_11 = [(55,0.4,-1,-1)]
_12 = [(56,0.4,-1,-1)]
_13 = [(55,0.4,-1,-1)]
_14 = [(53,0.5,-1,-1)]
_15 = [(55,0.6,-1,-1)]
_16 = [(-49,0.2,-1,-1)]
_17 = [(59,1.0,-1,-1)]
_1 = createseq([_2,_3,_4,_5,_6,_7,_8,_9,_10,_11,_12,_13,_14,_15,_16,_17])
_18 = 12
_0 = modPitch(_1, _18)
rap1 = _0
############################ LINE = 2
_21 = [(36,2.0,-1,-1)]
_22 = [(38,1.0,-1,-1)]
_23 = [(39,1.0,-1,-1)]
_24 = [(41,3.0,-1,-1)]
_25 = [(41,1.0,-1,-1)]
_26 = [(39,1.5,-1,-1)]
_27 = [(-49,0.5,-1,-1)]
_28 = [(41,1.0,-1,-1)]
_29 = [(39,0.4,-1,-1)]
_30 = [(38,1.3,-1,-1)]
_31 = [(-49,0.8,-1,-1)]
_32 = [(43,1.0,-1,-1)]
_20 = createseq([_21,_22,_23,_24,_25,_26,_27,_28,_29,_30,_31,_32])
_33 = 12
_19 = modPitch(_20, _33)
rap2 = _19
############################ LINE = 4
_36 = [(44,0.5,-1,-1)]
_37 = [(-49,0.5,-1,-1)]
_38 = [(49,0.5,-1,-1)]
_39 = [(-49,0.5,-1,-1)]
_40 = [(56,1.2,-1,-1)]
_41 = [(56,1.2,-1,-1)]
_42 = [(56,0.8,-1,-1)]
_43 = [(52,0.5,-1,-1)]
_44 = [(-49,0.5,-1,-1)]
_45 = [(57,0.5,-1,-1)]
_46 = [(-49,0.5,-1,-1)]
_47 = [(51,1.2,-1,-1)]
_48 = [(51,1.2,-1,-1)]
_49 = [(51,0.8,-1,-1)]
_35 = createseq([_36,_37,_38,_39,_40,_41,_42,_43,_44,_45,_46,_47,_48,_49])
_50 = 12
_34 = modPitch(_35, _50)
alors = _34
############################ LINE = 5
_53 = [(52,1.0,-1,-1)]
_54 = [(-49,0.33,-1,-1)]
_55 = [(52,1.0,-1,-1)]
_56 = [(-49,0.33,-1,-1)]
_57 = [(52,1.0,-1,-1)]
_58 = [(-49,0.33,-1,-1)]
_59 = [(52,1.0,-1,-1)]
_60 = [(-49,0.33,-1,-1)]
_61 = [(52,1.0,-1,-1)]
_62 = [(-49,0.33,-1,-1)]
_63 = [(52,0.5,-1,-1)]
_64 = [(54,0.5,-1,-1)]
_65 = [(-49,0.1,-1,-1)]
_66 = [(51,0.5,-1,-1)]
_67 = [(-49,0.5,-1,-1)]
_68 = [(51,0.5,-1,-1)]
_69 = [(-49,0.5,-1,-1)]
_70 = [(51,0.5,-1,-1)]
_52 = createseq([_53,_54,_55,_56,_57,_58,_59,_60,_61,_62,_63,_64,_65,_66,_67,_68,_69,_70])
_71 = 24
_51 = modPitch(_52, _71)
alors2 = _51
############################ LINE = 12
_72 = setinstrument(alors, piano)
_72 = [[-1], _72, -1]
p_alors = _72
############################ LINE = 16
_73 = setinstrument(alors2, piano)
_73 = [[-1], _73, -1]
_74 = 0
_75 = _73
_75[0] = [0]
_75[2] = 1
_75 = prepplay(_75)
_77 = 2
_78 = duration(alors)
_76 = _77*_78
_80 = setinstrument(alors2, piano)
_80 = [[-1], _80, -1]
_81 = 0
_82 = _80
_82[0] = [0]
_82[2] = 1
_82 = prepplay(_82)
_79 = _80
_79 = offsetstart(_79, [_76])
_79 = prepplay(_79)
addnotes(_79)
############################ LINE = 17
_83 = setinstrument(alors2, piano)
_83 = [[-1], _83, -1]
_84 = 0
_85 = _83
_85[0] = [0]
_85[2] = 1
_85 = prepplay(_85)
_87 = 3
_88 = duration(alors)
_86 = _87*_88
_90 = setinstrument(alors2, piano)
_90 = [[-1], _90, -1]
_91 = 0
_92 = _90
_92[0] = [0]
_92[2] = 1
_92 = prepplay(_92)
_89 = _90
_89 = offsetstart(_89, [_86])
_89 = prepplay(_89)
addnotes(_89)
############################ LINE = 18
_93 = p_alors
_93[0] = [0]
_93 = preploop(_93)
addnotes(_93)

with open("out.mid", 'wb') as file:
    midi.writeFile(file) #Writting the file
    print("MIDI File Written")
