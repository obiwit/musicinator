from midiutil import MIDIFile
from itertools import repeat
import sys


bpm = 60 #to be defined by user
vartrack = 2 #to be defined by user


####
toadd = [[1,10,15,25,36],[(64,0.5,2,3),(62,0.25,25,4)],1]
toadd2 = [[1,10,15,25,36],[(64,0.5,2,3),(62,0.25,25,4)]]
toadd3 = [(64,0.5,2,3),(62,0.25,25,4)]

midi = MIDIFile(numTracks=1500, file_format=1) #it takes the number of tracks as a parameter
midi.addTempo(0,0,bpm) #adding tempo
currtrack = 999 #what track are we writting on




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
                    if note == -1:
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

def duration(toCheck):
    if type(toCheck[0]) is tuple:
        size = len(toCheck)-1
        return toCheck[0][3] + toCheck[size][3] + toCheck[size][1]
    else:
        size = len(toCheck[1]) - 1
        return toCheck[1][0][3] + toCheck[1][size][3] + toCheck[1][size][1]

addnotes(toadd)
print(duration(toadd2))
print(duration(toadd3))


with open("test.mid", 'wb') as file: #writting binary file
	midi.writeFile(file)
	print("written")    

