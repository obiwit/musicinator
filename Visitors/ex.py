from midiutil import MIDIFile
import sys

bpm = 120
midi = MIDIFile(numTracks=24, file_format=1)
midi.addTempo(0,0,bpm)
currtrack = 0

def addnotes(notes):
    time = notes[0] #When the sequence will start time wise
    temp = 1 #default instrument
    global currtrack #we want the global scope of this variable


    repeat_times = (int)(notes[len(notes)-1])

    for x in range(len(time)):
        initialTime = time[x]
        for _ in range(repeat_times):
            for i in range(1, len(notes)-1):
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
_0 = extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq([], _1),_2),_3),_4),_5),_6),_7),_8),_9),_10),_11)
_12 = 40
_13 = 20
_14 = 12
first1_sequence = _14
############################ LINE = 3
_15 = duration(_first1_sequence)
t = _15
############################ LINE = 4
_16 = 20
non = _16
############################ LINE = 6
_18 = [(60,1.0,-1,-1),(64,1.0,-1,-1),(67,1.0,-1,-1)]
_17 = extendseq([], _18)
intro = _17
############################ LINE = 8
_20 = [(60,1.0,-1,-1)]
_19 = extendseq([], _20)
twinkle1 = _19
############################ LINE = 9
_22 = [(60,1.0,-1,-1)]
_23 = [(60,1.0,-1,-1)]
_24 = [(67,1.0,-1,-1)]
_25 = [(67,1.0,-1,-1)]
_26 = [(69,1.0,-1,-1)]
_27 = [(69,1.0,-1,-1)]
_28 = [(67,2.0,-1,-1)]
_29 = [(65,1.0,-1,-1)]
_30 = [(65,1.0,-1,-1)]
_31 = [(64,1.0,-1,-1)]
_32 = [(64,1.0,-1,-1)]
_33 = [(62,1.0,-1,-1)]
_34 = [(62,1.0,-1,-1)]
_35 = [(60,2.0,-1,-1)]
_21 = extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq([], _22),_23),_24),_25),_26),_27),_28),_29),_30),_31),_32),_33),_34),_35)
twinkle = _21
############################ LINE = 10
p = _36
############################ LINE = 12
_38 = [(-49,4.0,-1,-1)]
_39 = [(60,4.0,-1,-1)]
_40 = [(67,4.0,-1,-1)]
_41 = [(72,3.5,-1,-1)]
_42 = [(64,0.5,-1,-1),(67,0.5,-1,-1),(72,0.5,-1,-1)]
_43 = [(64,8.0,-1,-1),(67,8.0,-1,-1),(72,8.0,-1,-1)]
_44 = [(60,4.0,-1,-1)]
_45 = [(67,4.0,-1,-1)]
_37 = extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq([], _38),_39),_40),_41),_42),_43),_44),_45)
intro2 = _37
############################ LINE = 14
pp = _46
############################ LINE = 16
_47 = [_guitar,_bass,_drums]
band = _47
############################ LINE = 18
band3 = _drums
############################ LINE = 19
_49 = 2
_50 = 3
_48 = [_49,_50]
n = _48
############################ LINE = 20
_52 = 1
_53 = 1
_51 = range(_52, _53+1)
n2 = _51
############################ LINE = 21
_55 = [(60,1.0,-1,-1)]
_56 = [(60,1.0,-1,-1)]
_57 = [(67,1.0,-1,-1)]
_58 = [(67,1.0,-1,-1)]
_59 = [(69,1.0,-1,-1)]
_60 = [(69,1.0,-1,-1)]
_61 = [(67,2.0,-1,-1)]
_62 = [(65,1.0,-1,-1)]
_63 = [(65,1.0,-1,-1)]
_64 = [(64,1.0,-1,-1)]
_65 = [(64,1.0,-1,-1)]
_66 = [(62,1.0,-1,-1)]
_67 = [(62,1.0,-1,-1)]
_68 = [(60,2.0,-1,-1)]
_54 = extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq(extendseq([], _55),_56),_57),_58),_59),_60),_61),_62),_63),_64),_65),_66),_67),_68)
s = _54
############################ LINE = 24
############################ LINE = 25
############################ LINE = 26
############################ LINE = 30
_70 = duration(_s)
_71 = 10
############################ LINE = 31
_72 = duration(_s)
_73 = 5
############################ LINE = 34
############################ LINE = 37
############################ LINE = 43
############################ LINE = 45
############################ LINE = 48
_78 = [_79,_80]
p_a = _78
############################ LINE = 55
new_band = _violin
############################ LINE = 59
intro3 = _p_a[0]
############################ LINE = 61
############################ LINE = 62
