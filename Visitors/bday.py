from midiutil import MIDIFile
from math import ceil
import sys
import copy

bpm = 160
midi = MIDIFile(numTracks=10, file_format=1, deinterleave=False)
midi.addTempo(0,0,bpm)
currchannel = 0
longest = 0
ch_inst = []

bass = [44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44]
piano = [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
violin = [41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41]
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

################# LINE = 2
# original instruction =  numberrepeat_times=getInt("Number of repetitions: ");
_0 = getInt("Number of repetitions: ")
repeat_times = _0
################# LINE = 5
# original instruction =  sequence[]melody_lines=[[D{1.5}D{0.5}EDGF#{2}],[D{1.5}D{0.5}EDAG{2}],[D{1.5}D{0.5}D5BGF#E],[C5{1.5}C5{0.5}BGAG{3}]];
_2 = []
_3 = [(62,1.5,-1,-1)]
_2 = extendseq(_2, _3)
_4 = [(62,0.5,-1,-1)]
_2 = extendseq(_2, _4)
_5 = [(64,1.0,-1,-1)]
_2 = extendseq(_2, _5)
_6 = [(62,1.0,-1,-1)]
_2 = extendseq(_2, _6)
_7 = [(67,1.0,-1,-1)]
_2 = extendseq(_2, _7)
_8 = [(65,2.0,-1,-1)]
_2 = extendseq(_2, _8)
_9 = []
_10 = [(62,1.5,-1,-1)]
_9 = extendseq(_9, _10)
_11 = [(62,0.5,-1,-1)]
_9 = extendseq(_9, _11)
_12 = [(64,1.0,-1,-1)]
_9 = extendseq(_9, _12)
_13 = [(62,1.0,-1,-1)]
_9 = extendseq(_9, _13)
_14 = [(69,1.0,-1,-1)]
_9 = extendseq(_9, _14)
_15 = [(67,2.0,-1,-1)]
_9 = extendseq(_9, _15)
_16 = []
_17 = [(62,1.5,-1,-1)]
_16 = extendseq(_16, _17)
_18 = [(62,0.5,-1,-1)]
_16 = extendseq(_16, _18)
_19 = [(74,1.0,-1,-1)]
_16 = extendseq(_16, _19)
_20 = [(71,1.0,-1,-1)]
_16 = extendseq(_16, _20)
_21 = [(67,1.0,-1,-1)]
_16 = extendseq(_16, _21)
_22 = [(65,1.0,-1,-1)]
_16 = extendseq(_16, _22)
_23 = [(64,1.0,-1,-1)]
_16 = extendseq(_16, _23)
_24 = []
_25 = [(72,1.5,-1,-1)]
_24 = extendseq(_24, _25)
_26 = [(72,0.5,-1,-1)]
_24 = extendseq(_24, _26)
_27 = [(71,1.0,-1,-1)]
_24 = extendseq(_24, _27)
_28 = [(67,1.0,-1,-1)]
_24 = extendseq(_24, _28)
_29 = [(69,1.0,-1,-1)]
_24 = extendseq(_24, _29)
_30 = [(67,3.0,-1,-1)]
_24 = extendseq(_24, _30)
_1 = [_2,_9,_16,_24]
melody_lines = _1
################# LINE = 12
# original instruction =  numberoffset=0;
_31 = 0
offset = _31
################# LINE = 13
# original instruction =  fornumbernin1->repeat_times{atoffsetplaymelody_lines+12*(n-1)onpianosequentially;forsequencemelodyinmelody_lines{offset=offset+|melody|;}}
_33 = 1
_32 = range(_33, repeat_times+1)
for n in _32:
	################# LINE = 14
	# original instruction =  atoffsetplaymelody_lines+12*(n-1)onpianosequentially;
	for _35 in range(0, len(melody_lines)):
		_37 = 12
		_39 = 1
		_38 = n-_39
		_36 = _37*_38
		melody_lines[_35] = modPitch(melody_lines[_35], _36)
	_34 = []
	for _40 in melody_lines:
		_40 = setinstrument(_40, piano)
		_40 = [[-1], _40, -1]
		_34.append(_40)
	_41 = 0
	for _42 in _34:
		_42[0] = [_41]
		_42[2] = 1
		_42 = prepplay(_42)
		_43 = duration(_42)
		_41 = _41+_43
	for _44 in _34:
		_44 = offsetstart(_44, [offset])
		_44 = prepplay(_44)
		addnotes(_44)
	################# LINE = 15
	# original instruction =  forsequencemelodyinmelody_lines{offset=offset+|melody|;}
	for melody in melody_lines:
		################# LINE = 16
		# original instruction =  offset=offset+|melody|;
		_46 = duration(melody)
		_45 = offset+_46
		offset = _45

exportfile("bday.mid")
