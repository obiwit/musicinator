from midiutil import MIDIFile
from itertools import repeat
import sys


bpm = 60 #to be defined by user
vartrack = 2 #to be defined by user


####
toadd = [1,(60,1,2),(62,1,25),(64,1,64),(65,1,53),(67,1,32),(69,1,14),(71,1,87),(72,1,69),2]
toadd1= [1,(72,1,5),(71,1,55),(69,1,31),(67,1,45),(65,1,115),(64,1,54),(62,1,87),(60,1,69),2]
####

midi = MIDIFile(numTracks=1500, file_format=1) #it takes the number of tracks as a parameter
midi.addTempo(0,0,bpm) #adding tempo
currtrack = 999 #what track are we writting on




def addnotes(notes):
    time = notes[0] #When the sequence will start time wise
    temp = 1 #default instrument
    global currtrack #we want the global scope of this variable

    

    negativeError = ValueError("Start time should be positive")
    if time < 0:
	    raise negativeError

    repeat_times = (int)(notes[len(notes)-1])
    
        
    for _ in range(repeat_times):
        for i in range(1, len(notes)-1):
            try:
                note = notes[i][0] #getting the note
                duration = notes[i][1] #duration of the note
            except:
                pass
            
            try: #trying for instrument change
                instrument = notes[i][2] #checking for instrument
                if(instrument != temp):
                    midi.addProgramChange(currtrack, 0, time, instrument) #changing the current instrument
                    temp = instrument
            except:
                instrument = temp #it keeps the old instrument
                pass
            
            midi.addNote(currtrack,0,note,time,duration,100)

            print("Added note {}, with instument {} with a duration of {} on {} time, on channel {}".format(note, instrument, duration, time, currtrack))
            time += duration
    currtrack += 1


addnotes(toadd)
addnotes(toadd1)

with open("test.mid", 'wb') as file: #writting binary file
	midi.writeFile(file)
	print("written")    

