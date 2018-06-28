from midiutil import MIDIFile
from math import ceil
import sys
import copy

bpm = 150
midi = MIDIFile(numTracks=65534, file_format=1)
midi.addTempo(0,0,bpm)
currchannel = 0
longest = 0
ch_inst = []

slapBass = [37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37, 37]
bass = [44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44]
vibrofone = [12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12]
synth = [39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39, 39]
piano = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
violin = [41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41]
synthPiano = [3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3]
drums = [119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119, 119]
harpsiChord = [7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7]
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

############################ LINE = 3
_0 = []
_1 = [(71,0.25,-1,-1)]
_0 = extendseq(_0, _1)
_2 = [(76,0.25,-1,-1)]
_0 = extendseq(_0, _2)
_3 = [(79,0.25,-1,-1)]
_0 = extendseq(_0, _3)
_4 = [(83,0.25,-1,-1)]
_0 = extendseq(_0, _4)
_5 = [(84,0.25,-1,-1)]
_0 = extendseq(_0, _5)
_6 = [(83,0.25,-1,-1)]
_0 = extendseq(_0, _6)
_7 = [(79,0.25,-1,-1)]
_0 = extendseq(_0, _7)
_8 = [(76,0.25,-1,-1)]
_0 = extendseq(_0, _8)
intro1 = _0
############################ LINE = 4
_9 = []
_10 = [(-49,0.25,-1,-1)]
_9 = extendseq(_9, _10)
_11 = [(71,0.25,-1,-1)]
_9 = extendseq(_9, _11)
_12 = [(71,0.25,-1,-1)]
_9 = extendseq(_9, _12)
_13 = [(71,0.25,-1,-1)]
_9 = extendseq(_9, _13)
_14 = [(71,0.25,-1,-1),(72,0.25,-1,-1)]
_9 = extendseq(_9, _14)
_15 = [(71,0.25,-1,-1)]
_9 = extendseq(_9, _15)
_16 = [(71,0.25,-1,-1)]
_9 = extendseq(_9, _16)
intro2 = _9
############################ LINE = 5
_17 = []
_18 = [(-49,0.5,-1,-1)]
_17 = extendseq(_17, _18)
_19 = [(67,0.25,-1,-1)]
_17 = extendseq(_17, _19)
_20 = [(-49,0.25,-1,-1)]
_17 = extendseq(_17, _20)
intro3 = _17
############################ LINE = 6
_21 = []
_22 = [(64,0.25,-1,-1)]
_21 = extendseq(_21, _22)
intro4 = _21
############################ LINE = 8
_23 = setinstrument(intro1, vibrofone)
_23 = [[-1], _23, -1]
_24 = 0
_25 = _23
_25[0] = [0]
_25[2] = 4
_25 = prepplay(_25)
addnotes(_25)
############################ LINE = 9
_26 = setinstrument(intro2, synth)
_26 = [[-1], _26, -1]
_27 = 0
_28 = _26
_28[0] = [0]
_28[2] = 4
_28 = prepplay(_28)
addnotes(_28)
############################ LINE = 10
_29 = setinstrument(intro3, synth)
_29 = [[-1], _29, -1]
_30 = 0
_31 = _29
_31[0] = [0]
_31[2] = 8
_31 = prepplay(_31)
addnotes(_31)
############################ LINE = 11
_32 = setinstrument(intro4, synth)
_32 = [[-1], _32, -1]
_33 = 0
_34 = _32
_34[0] = [0]
_34[2] = 32
_34 = prepplay(_34)
addnotes(_34)
############################ LINE = 14
_36 = 4
_37 = duration(intro1)
_35 = _36*_37
parte2 = _35
############################ LINE = 16
_38 = []
_39 = [(60,0.25,-1,-1)]
_38 = extendseq(_38, _39)
_40 = [(-49,0.25,-1,-1)]
_38 = extendseq(_38, _40)
_41 = [(64,0.25,-1,-1)]
_38 = extendseq(_38, _41)
_42 = [(-49,0.25,-1,-1)]
_38 = extendseq(_38, _42)
_43 = [(67,0.25,-1,-1)]
_38 = extendseq(_38, _43)
_44 = [(-49,0.25,-1,-1)]
_38 = extendseq(_38, _44)
_45 = [(71,0.25,-1,-1)]
_38 = extendseq(_38, _45)
_46 = [(-49,0.25,-1,-1)]
_38 = extendseq(_38, _46)
_47 = [(72,0.25,-1,-1)]
_38 = extendseq(_38, _47)
_48 = [(-49,0.25,-1,-1)]
_38 = extendseq(_38, _48)
_49 = [(71,0.25,-1,-1)]
_38 = extendseq(_38, _49)
_50 = [(-49,0.25,-1,-1)]
_38 = extendseq(_38, _50)
_51 = [(67,0.25,-1,-1)]
_38 = extendseq(_38, _51)
_52 = [(-49,0.25,-1,-1)]
_38 = extendseq(_38, _52)
_53 = [(64,0.25,-1,-1)]
_38 = extendseq(_38, _53)
_54 = [(-49,0.25,-1,-1)]
_38 = extendseq(_38, _54)
bouncer = _38
############################ LINE = 17
_55 = []
_56 = [(48,0.25,-1,-1)]
_55 = extendseq(_55, _56)
_57 = [(-49,0.25,-1,-1)]
_55 = extendseq(_55, _57)
_58 = [(48,0.25,-1,-1)]
_55 = extendseq(_55, _58)
_59 = [(-49,1.25,-1,-1)]
_55 = extendseq(_55, _59)
ticker1 = _55
############################ LINE = 18
_60 = []
_61 = [(52,0.25,-1,-1)]
_60 = extendseq(_60, _61)
_62 = [(-49,0.25,-1,-1)]
_60 = extendseq(_60, _62)
_63 = [(52,0.25,-1,-1)]
_60 = extendseq(_60, _63)
_64 = [(-49,1.25,-1,-1)]
_60 = extendseq(_60, _64)
ticker2 = _60
############################ LINE = 20
_65 = setinstrument(bouncer, slapBass)
_65 = [[-1], _65, -1]
_66 = 0
_67 = _65
_67[0] = [0]
_67[2] = 30
_67 = prepplay(_67)
_69 = setinstrument(bouncer, slapBass)
_69 = [[-1], _69, -1]
_70 = 0
_71 = _69
_71[0] = [0]
_71[2] = 30
_71 = prepplay(_71)
_68 = _69
_68 = offsetstart(_68, [parte2])
_68 = prepplay(_68)
addnotes(_68)
############################ LINE = 21
_72 = setinstrument(bouncer, synthPiano)
_72 = [[-1], _72, -1]
_73 = 0
_74 = _72
_74[0] = [0]
_74[2] = 30
_74 = prepplay(_74)
_76 = setinstrument(bouncer, synthPiano)
_76 = [[-1], _76, -1]
_77 = 0
_78 = _76
_78[0] = [0]
_78[2] = 30
_78 = prepplay(_78)
_75 = _76
_75 = offsetstart(_75, [parte2])
_75 = prepplay(_75)
addnotes(_75)
############################ LINE = 22
_79 = setinstrument(ticker1, slapBass)
_79 = [[-1], _79, -1]
_80 = 0
_81 = _79
_81[0] = [0]
_81[2] = 8
_81 = prepplay(_81)
_83 = setinstrument(ticker1, slapBass)
_83 = [[-1], _83, -1]
_84 = 0
_85 = _83
_85[0] = [0]
_85[2] = 8
_85 = prepplay(_85)
_82 = _83
_82 = offsetstart(_82, [parte2])
_82 = prepplay(_82)
addnotes(_82)
############################ LINE = 24
_88 = 8
_89 = duration(ticker1)
_87 = _88*_89
_86 = parte2+_87
t1 = _86
############################ LINE = 25
_90 = setinstrument(ticker2, slapBass)
_90 = [[-1], _90, -1]
_91 = 0
_92 = _90
_92[0] = [0]
_92[2] = 8
_92 = prepplay(_92)
_94 = setinstrument(ticker2, slapBass)
_94 = [[-1], _94, -1]
_95 = 0
_96 = _94
_96[0] = [0]
_96[2] = 8
_96 = prepplay(_96)
_93 = _94
_93 = offsetstart(_93, [t1])
_93 = prepplay(_93)
addnotes(_93)
############################ LINE = 27
_97 = []
_98 = [(72,0.25,-1,-1)]
_97 = extendseq(_97, _98)
_99 = [(-49,1.75,-1,-1)]
_97 = extendseq(_97, _99)
_100 = [(79,0.25,-1,-1)]
_97 = extendseq(_97, _100)
danglingNotes1 = _97
############################ LINE = 28
_103 = 8
_104 = duration(ticker2)
_102 = _103*_104
_101 = t1+_102
t2 = _101
############################ LINE = 29
_105 = setinstrument(danglingNotes1, harpsiChord)
_105 = [[-1], _105, -1]
_106 = 0
_107 = _105
_107[0] = [0]
_107[2] = 1
_107 = prepplay(_107)
_109 = setinstrument(danglingNotes1, harpsiChord)
_109 = [[-1], _109, -1]
_110 = 0
_111 = _109
_111[0] = [0]
_111[2] = 1
_111 = prepplay(_111)
_108 = _109
_108 = offsetstart(_108, [t2])
_108 = prepplay(_108)
addnotes(_108)
############################ LINE = 30
_112 = setinstrument(ticker1, slapBass)
_112 = [[-1], _112, -1]
_113 = 0
_114 = _112
_114[0] = [0]
_114[2] = 7
_114 = prepplay(_114)
_116 = setinstrument(ticker1, slapBass)
_116 = [[-1], _116, -1]
_117 = 0
_118 = _116
_118[0] = [0]
_118[2] = 7
_118 = prepplay(_118)
_115 = _116
_115 = offsetstart(_115, [t2])
_115 = prepplay(_115)
addnotes(_115)
############################ LINE = 32
_119 = []
_120 = [(50,0.25,-1,-1)]
_119 = extendseq(_119, _120)
_121 = [(-49,0.25,-1,-1)]
_119 = extendseq(_119, _121)
_122 = [(50,0.25,-1,-1)]
_119 = extendseq(_119, _122)
_123 = [(-49,1.25,-1,-1)]
_119 = extendseq(_119, _123)
ticker3 = _119
############################ LINE = 33
_124 = []
_125 = [(62,0.25,-1,-1)]
_124 = extendseq(_124, _125)
_126 = [(-49,0.25,-1,-1)]
_124 = extendseq(_124, _126)
_127 = [(62,0.25,-1,-1)]
_124 = extendseq(_124, _127)
_128 = [(-49,1.25,-1,-1)]
_124 = extendseq(_124, _128)
_129 = [(64,0.25,-1,-1)]
_124 = extendseq(_124, _129)
_130 = [(-49,3.75,-1,-1)]
_124 = extendseq(_124, _130)
_131 = [(52,0.25,-1,-1)]
_124 = extendseq(_124, _131)
_132 = [(-49,9.75,-1,-1)]
_124 = extendseq(_124, _132)
_133 = [(67,0.25,-1,-1)]
_124 = extendseq(_124, _133)
_134 = [(-49,0.25,-1,-1)]
_124 = extendseq(_124, _134)
_135 = [(67,0.25,-1,-1)]
_124 = extendseq(_124, _135)
_136 = [(-49,1.25,-1,-1)]
_124 = extendseq(_124, _136)
_137 = [(60,0.25,-1,-1)]
_124 = extendseq(_124, _137)
danglingNotes2 = _124
############################ LINE = 34
_140 = 7
_141 = duration(ticker1)
_139 = _140*_141
_138 = t2+_139
t3 = _138
############################ LINE = 36
_142 = setinstrument(danglingNotes2, harpsiChord)
_142 = [[-1], _142, -1]
_143 = 0
_144 = _142
_144[0] = [0]
_144[2] = 1
_144 = prepplay(_144)
_146 = setinstrument(danglingNotes2, harpsiChord)
_146 = [[-1], _146, -1]
_147 = 0
_148 = _146
_148[0] = [0]
_148[2] = 1
_148 = prepplay(_148)
_145 = _146
_145 = offsetstart(_145, [t3])
_145 = prepplay(_145)
addnotes(_145)
############################ LINE = 37
_149 = setinstrument(ticker3, slapBass)
_149 = [[-1], _149, -1]
_150 = 0
_151 = _149
_151[0] = [0]
_151[2] = 1
_151 = prepplay(_151)
_153 = setinstrument(ticker3, slapBass)
_153 = [[-1], _153, -1]
_154 = 0
_155 = _153
_155[0] = [0]
_155[2] = 1
_155 = prepplay(_155)
_152 = _153
_152 = offsetstart(_152, [t3])
_152 = prepplay(_152)
addnotes(_152)
############################ LINE = 39
_158 = 8
_159 = duration(ticker1)
_157 = _158*_159
_156 = t2+_157
t4 = _156
############################ LINE = 40
_162 = 7
_163 = duration(ticker1)
_161 = _162*_163
_160 = t4+_161
t5 = _160
############################ LINE = 42
_164 = setinstrument(ticker2, slapBass)
_164 = [[-1], _164, -1]
_165 = 0
_166 = _164
_166[0] = [0]
_166[2] = 7
_166 = prepplay(_166)
_168 = setinstrument(ticker2, slapBass)
_168 = [[-1], _168, -1]
_169 = 0
_170 = _168
_170[0] = [0]
_170[2] = 7
_170 = prepplay(_170)
_167 = _168
_167 = offsetstart(_167, [t4])
_167 = prepplay(_167)
addnotes(_167)
############################ LINE = 43
_172 = []
_173 = [(55,0.25,-1,-1)]
_172 = extendseq(_172, _173)
_174 = [(-49,0.25,-1,-1)]
_172 = extendseq(_172, _174)
_175 = [(55,0.25,-1,-1)]
_172 = extendseq(_172, _175)
_171 = setinstrument(_172, slapBass)
_171 = [[-1], _171, -1]
_176 = 0
_177 = _171
_177[0] = [0]
_177[2] = 1
_177 = prepplay(_177)
_180 = []
_181 = [(55,0.25,-1,-1)]
_180 = extendseq(_180, _181)
_182 = [(-49,0.25,-1,-1)]
_180 = extendseq(_180, _182)
_183 = [(55,0.25,-1,-1)]
_180 = extendseq(_180, _183)
_179 = setinstrument(_180, slapBass)
_179 = [[-1], _179, -1]
_184 = 0
_185 = _179
_185[0] = [0]
_185[2] = 1
_185 = prepplay(_185)
_178 = _179
_178 = offsetstart(_178, [t5])
_178 = prepplay(_178)
addnotes(_178)
############################ LINE = 50
_186 = []
_187 = [(48,0.25,-1,-1)]
_186 = extendseq(_186, _187)
_188 = [(-49,0.25,-1,-1)]
_186 = extendseq(_186, _188)
_189 = [(48,0.25,-1,-1)]
_186 = extendseq(_186, _189)
_190 = [(-49,0.25,-1,-1)]
_186 = extendseq(_186, _190)
ticker10 = _186
############################ LINE = 51
_193 = 8
_194 = duration(ticker1)
_192 = _193*_194
_191 = t4+_192
t6 = _191
############################ LINE = 52
_195 = setinstrument(ticker1, slapBass)
_195 = [[-1], _195, -1]
_196 = 0
_197 = _195
_197[0] = [0]
_197[2] = 6
_197 = prepplay(_197)
_199 = setinstrument(ticker1, slapBass)
_199 = [[-1], _199, -1]
_200 = 0
_201 = _199
_201[0] = [0]
_201[2] = 6
_201 = prepplay(_201)
_198 = _199
_198 = offsetstart(_198, [t6])
_198 = prepplay(_198)
addnotes(_198)
############################ LINE = 53
_202 = setinstrument(ticker10, synth)
_202 = [[-1], _202, -1]
_203 = 0
_204 = _202
_204[0] = [0]
_204[2] = 12
_204 = prepplay(_204)
_206 = setinstrument(ticker10, synth)
_206 = [[-1], _206, -1]
_207 = 0
_208 = _206
_208[0] = [0]
_208[2] = 12
_208 = prepplay(_208)
_205 = _206
_205 = offsetstart(_205, [t6])
_205 = prepplay(_205)
addnotes(_205)
############################ LINE = 55
_211 = 12
_212 = duration(ticker10)
_210 = _211*_212
_209 = t6+_210
t7 = _209
############################ LINE = 56
_213 = []
_214 = [(50,0.25,-1,-1)]
_213 = extendseq(_213, _214)
_215 = [(-49,0.25,-1,-1)]
_213 = extendseq(_213, _215)
_216 = [(50,0.25,-1,-1)]
_213 = extendseq(_213, _216)
_217 = [(-49,0.25,-1,-1)]
_213 = extendseq(_213, _217)
_218 = [(-49,0.5,-1,-1)]
_213 = extendseq(_213, _218)
_219 = [(48,0.25,-1,-1)]
_213 = extendseq(_213, _219)
_220 = [(-49,0.25,-1,-1)]
_213 = extendseq(_213, _220)
_221 = [(48,0.25,-1,-1)]
_213 = extendseq(_213, _221)
_222 = [(-49,0.25,-1,-1)]
_213 = extendseq(_213, _222)
_223 = [(48,0.25,-1,-1)]
_213 = extendseq(_213, _223)
_224 = [(-49,0.25,-1,-1)]
_213 = extendseq(_213, _224)
_225 = [(-49,0.5,-1,-1)]
_213 = extendseq(_213, _225)
_226 = [(47,0.25,-1,-1)]
_213 = extendseq(_213, _226)
_227 = [(-49,0.25,-1,-1)]
_213 = extendseq(_213, _227)
ticker4 = _213
############################ LINE = 57
_228 = []
_229 = [(50,0.25,-1,-1)]
_228 = extendseq(_228, _229)
_230 = [(-49,0.25,-1,-1)]
_228 = extendseq(_228, _230)
_231 = [(50,0.25,-1,-1)]
_228 = extendseq(_228, _231)
_232 = [(-49,0.25,-1,-1)]
_228 = extendseq(_228, _232)
_233 = [(48,0.25,-1,-1)]
_228 = extendseq(_228, _233)
_234 = [(-49,0.25,-1,-1)]
_228 = extendseq(_228, _234)
_235 = [(48,0.25,-1,-1)]
_228 = extendseq(_228, _235)
_236 = [(-49,0.25,-1,-1)]
_228 = extendseq(_228, _236)
_237 = [(48,0.25,-1,-1)]
_228 = extendseq(_228, _237)
_238 = [(-49,0.25,-1,-1)]
_228 = extendseq(_228, _238)
_239 = [(48,0.25,-1,-1)]
_228 = extendseq(_228, _239)
_240 = [(-49,0.25,-1,-1)]
_228 = extendseq(_228, _240)
_241 = [(47,0.25,-1,-1)]
_228 = extendseq(_228, _241)
_242 = [(-49,0.25,-1,-1)]
_228 = extendseq(_228, _242)
_243 = [(47,0.25,-1,-1)]
_228 = extendseq(_228, _243)
_244 = [(-49,0.25,-1,-1)]
_228 = extendseq(_228, _244)
ticker5 = _228
############################ LINE = 58
_245 = setinstrument(ticker4, slapBass)
_245 = [[-1], _245, -1]
_246 = 0
_247 = _245
_247[0] = [0]
_247[2] = 1
_247 = prepplay(_247)
_249 = setinstrument(ticker4, slapBass)
_249 = [[-1], _249, -1]
_250 = 0
_251 = _249
_251[0] = [0]
_251[2] = 1
_251 = prepplay(_251)
_248 = _249
_248 = offsetstart(_248, [t7])
_248 = prepplay(_248)
addnotes(_248)
############################ LINE = 59
_252 = setinstrument(ticker5, synth)
_252 = [[-1], _252, -1]
_253 = 0
_254 = _252
_254[0] = [0]
_254[2] = 1
_254 = prepplay(_254)
_256 = setinstrument(ticker5, synth)
_256 = [[-1], _256, -1]
_257 = 0
_258 = _256
_258[0] = [0]
_258[2] = 1
_258 = prepplay(_258)
_255 = _256
_255 = offsetstart(_255, [t7])
_255 = prepplay(_255)
addnotes(_255)
############################ LINE = 63
_259 = []
_260 = [(47,0.25,-1,-1)]
_259 = extendseq(_259, _260)
_261 = [(-49,0.25,-1,-1)]
_259 = extendseq(_259, _261)
_262 = [(47,0.25,-1,-1)]
_259 = extendseq(_259, _262)
_263 = [(-49,0.25,-1,-1)]
_259 = extendseq(_259, _263)
_264 = [(-49,1.0,-1,-1)]
_259 = extendseq(_259, _264)
ticker6 = _259
############################ LINE = 64
_265 = []
_266 = [(47,0.25,-1,-1)]
_265 = extendseq(_265, _266)
_267 = [(-49,0.25,-1,-1)]
_265 = extendseq(_265, _267)
_268 = [(47,0.25,-1,-1)]
_265 = extendseq(_265, _268)
_269 = [(-49,0.25,-1,-1)]
_265 = extendseq(_265, _269)
ticker7 = _265
############################ LINE = 65
_271 = duration(ticker4)
_270 = t7+_271
t8 = _270
############################ LINE = 66
_272 = setinstrument(ticker6, slapBass)
_272 = [[-1], _272, -1]
_273 = 0
_274 = _272
_274[0] = [0]
_274[2] = 12
_274 = prepplay(_274)
_276 = setinstrument(ticker6, slapBass)
_276 = [[-1], _276, -1]
_277 = 0
_278 = _276
_278[0] = [0]
_278[2] = 12
_278 = prepplay(_278)
_275 = _276
_275 = offsetstart(_275, [t8])
_275 = prepplay(_275)
addnotes(_275)
############################ LINE = 67
_279 = setinstrument(ticker7, synth)
_279 = [[-1], _279, -1]
_280 = 0
_281 = _279
_281[0] = [0]
_281[2] = 24
_281 = prepplay(_281)
_283 = setinstrument(ticker7, synth)
_283 = [[-1], _283, -1]
_284 = 0
_285 = _283
_285[0] = [0]
_285[2] = 24
_285 = prepplay(_285)
_282 = _283
_282 = offsetstart(_282, [t8])
_282 = prepplay(_282)
addnotes(_282)
############################ LINE = 70
_288 = 12
_289 = duration(ticker6)
_287 = _288*_289
_286 = t8+_287
t9 = _286
############################ LINE = 71
_290 = setinstrument(ticker1, slapBass)
_290 = [[-1], _290, -1]
_291 = 0
_292 = _290
_292[0] = [0]
_292[2] = 8
_292 = prepplay(_292)
_294 = setinstrument(ticker1, slapBass)
_294 = [[-1], _294, -1]
_295 = 0
_296 = _294
_296[0] = [0]
_296[2] = 8
_296 = prepplay(_296)
_293 = _294
_293 = offsetstart(_293, [t9])
_293 = prepplay(_293)
addnotes(_293)
############################ LINE = 72
_297 = setinstrument(ticker1, synth)
_297 = [[-1], _297, -1]
_298 = 0
_299 = _297
_299[0] = [0]
_299[2] = 8
_299 = prepplay(_299)
_301 = setinstrument(ticker1, synth)
_301 = [[-1], _301, -1]
_302 = 0
_303 = _301
_303[0] = [0]
_303[2] = 8
_303 = prepplay(_303)
_300 = _301
_300 = offsetstart(_300, [t9])
_300 = prepplay(_300)
addnotes(_300)
############################ LINE = 73
_305 = []
_306 = [(72,0.25,-1,-1)]
_305 = extendseq(_305, _306)
_307 = [(-49,1.75,-1,-1)]
_305 = extendseq(_305, _307)
_308 = [(79,0.25,-1,-1)]
_305 = extendseq(_305, _308)
_309 = [(-49,1.75,-1,-1)]
_305 = extendseq(_305, _309)
_310 = [(72,0.25,-1,-1)]
_305 = extendseq(_305, _310)
_311 = [(-49,7.75,-1,-1)]
_305 = extendseq(_305, _311)
_312 = [(74,0.25,-1,-1)]
_305 = extendseq(_305, _312)
_313 = [(-49,1.25,-1,-1)]
_305 = extendseq(_305, _313)
_314 = [(72,0.25,-1,-1)]
_305 = extendseq(_305, _314)
_315 = [(-49,1.25,-1,-1)]
_305 = extendseq(_305, _315)
_316 = [(71,0.25,-1,-1),(64,0.25,-1,-1)]
_305 = extendseq(_305, _316)
_304 = setinstrument(_305, harpsiChord)
_304 = [[-1], _304, -1]
_317 = 0
_318 = _304
_318[0] = [0]
_318[2] = 1
_318 = prepplay(_318)
_321 = []
_322 = [(72,0.25,-1,-1)]
_321 = extendseq(_321, _322)
_323 = [(-49,1.75,-1,-1)]
_321 = extendseq(_321, _323)
_324 = [(79,0.25,-1,-1)]
_321 = extendseq(_321, _324)
_325 = [(-49,1.75,-1,-1)]
_321 = extendseq(_321, _325)
_326 = [(72,0.25,-1,-1)]
_321 = extendseq(_321, _326)
_327 = [(-49,7.75,-1,-1)]
_321 = extendseq(_321, _327)
_328 = [(74,0.25,-1,-1)]
_321 = extendseq(_321, _328)
_329 = [(-49,1.25,-1,-1)]
_321 = extendseq(_321, _329)
_330 = [(72,0.25,-1,-1)]
_321 = extendseq(_321, _330)
_331 = [(-49,1.25,-1,-1)]
_321 = extendseq(_321, _331)
_332 = [(71,0.25,-1,-1),(64,0.25,-1,-1)]
_321 = extendseq(_321, _332)
_320 = setinstrument(_321, harpsiChord)
_320 = [[-1], _320, -1]
_333 = 0
_334 = _320
_334[0] = [0]
_334[2] = 1
_334 = prepplay(_334)
_319 = _320
_319 = offsetstart(_319, [t9])
_319 = prepplay(_319)
addnotes(_319)
############################ LINE = 75
_336 = duration(ticker1)
_335 = t9+_336
t10 = _335
############################ LINE = 76
_338 = []
_339 = [(55,0.25,-1,-1)]
_338 = extendseq(_338, _339)
_340 = [(-49,0.25,-1,-1)]
_338 = extendseq(_338, _340)
_337 = setinstrument(_338, synth)
_337 = [[-1], _337, -1]
_341 = 0
_342 = _337
_342[0] = [0]
_342[2] = 26
_342 = prepplay(_342)
_345 = []
_346 = [(55,0.25,-1,-1)]
_345 = extendseq(_345, _346)
_347 = [(-49,0.25,-1,-1)]
_345 = extendseq(_345, _347)
_344 = setinstrument(_345, synth)
_344 = [[-1], _344, -1]
_348 = 0
_349 = _344
_349[0] = [0]
_349[2] = 26
_349 = prepplay(_349)
_343 = _344
_343 = offsetstart(_343, [t10])
_343 = prepplay(_343)
addnotes(_343)

exportfile("out.mid")
