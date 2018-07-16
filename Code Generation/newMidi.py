from midiutil import MIDIFile
from itertools import repeat
from math import ceil
import sys


bpm = 60 #to be defined by user
vartrack = 2 #to be defined by user
longest = 0

toadd = [[1,10,15,25,36],[(64,0.5,2,3),(62,0.25,25,4)],1]
toadd2 = [[1,10,15,25,36],[(64,0.5,2,3),(62,0.25,25,4)]]
toadd3 = [(64,0.5,2,3),(62,0.25,25,4)]
toadd4 = [[0], [(56, 0.5, 1, 0), (-37, 0.5, 1, 0.5), (61, 0.5, 1, 1.0), (-37, 0.5, 1, 1.5), (68, 1.2, 1, 2.0), (68, 1.2, 1, 3.2), (68, 0.8, 1, 4.4), (64, 0.5, 1, 5.2), (-37, 0.5, 1, 5.7), (69, 0.5, 1, 6.2), (-37, 0.5, 1, 6.7), (63, 1.2, 1, 7.2), (63, 1.2, 1, 8.4), (63, 0.8, 1, 9.6)], 4]
toadd5 = [[0], [(56, 0.5, 126, 0), (-37, 0.5, 126, 0.5), (61, 0.5, 126, 1.0), (-37, 0.5, 126, 1.5), (68, 1.2, 126, 2.0), (68, 1.2, 126, 3.2), (68, 0.8, 126, 4.4), (64, 0.5, 126, 5.2), (-37, 0.5, 126, 5.7), (69, 0.5, 126, 6.2), (-37, 0.5, 126, 6.7), (63, 1.2, 126, 7.2), (63, 1.2, 126, 8.4), (63, 0.8, 126, 9.6)], 4]
toadd6 = [[0], [(56, 0.5, 1, 0), (-37, 0.5, 2, 0.5), (61, 0.5, 3, 1.0), (-37, 0.5, 4, 1.5), (68, 1.2, 1, 2.0), (68, 1.2, 5, 3.2), (68, 0.8, 1, 4.4), (64, 0.5, 1, 5.2), (-37, 0.5, 1, 5.7), (69, 0.5, 1, 6.2), (-37, 0.5, 1, 6.7), (63, 1.2, 1, 7.2), (63, 1.2, 1, 8.4), (63, 0.8, 1, 9.6)], 4]
midi = MIDIFile(numTracks=5, file_format=1, removeDuplicates=False, deinterleave=False) #it takes the number of tracks as a parameter
midi.addTempo(0,0,bpm) #adding tempo
currchannel = 0 #what channel are we writting on

ch_inst = []

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
    try:
        if len(ch_inst) > 16:
            raise ValueError
    except ValueError:
        print("MIDI does not Support over 16 instruments/channels")

    if len(ch_inst) == 0:
        ch_inst.append(instrument)
        return 0
    elif instrument in ch_inst:
        return ch_inst.index(instrument)
    elif instrument not in ch_inst:
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
        temp = toMod
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
        temp = toMod
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

addnotes(toadd6)


with open("test.mid", 'wb') as file: #writting binary file
	midi.writeFile(file)
	print("written")   