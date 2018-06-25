from midiutil import MIDIFile
from itertools import repeat
import sys


bpm = 60 #to be defined by user
vartrack = 2 #to be defined by user


####
toadd = [[1,10,15,25,36],(64,0.5,2),(62,0.25,25),1]

midi = MIDIFile(numTracks=1500, file_format=1) #it takes the number of tracks as a parameter
midi.addTempo(0,0,bpm) #adding tempo
currtrack = 999 #what track are we writting on




def addnotes(notes):
    time = notes[0] #When the sequence will start time wise
    temp = 1 #default instrument
    global currtrack #we want the global scope of this variable


    repeat_times = (int)(notes[len(notes)-1])
    
    for x in range(len(time)):
        currtime = time[x]
        for _ in range(repeat_times):
            for i in range(1, len(notes)-1):
                try:
                    note = notes[i][0] #getting the note
                    duration = notes[i][1] #duration of the note
                    if note < 0:
                        currtime+=duration
                        continue

                except:
                    pass
                
                try: #trying for instrument change
                    instrument = notes[i][2] #checking for instrument
                    if(instrument != temp):
                        midi.addProgramChange(currtrack, 0, currtime, instrument) #changing the current instrument
                        temp = instrument
                except:
                    instrument = temp #it keeps the old instrument
                    pass
                
                midi.addNote(currtrack,0,note,currtime,duration,100)

                print("Added note {}, with instument {} with a duration of {} on time {}, on channel {}".format(note, instrument, duration, currtime, currtrack))
                currtime += duration
        currtrack += 1


addnotes(toadd)


with open("test.mid", 'wb') as file: #writting binary file
	midi.writeFile(file)
	print("written")    

