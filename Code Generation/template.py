from midiutil import MIDIFile
from itertools import repeat
import sys


bpm = 60
vartrack = 2
toadd = [1,(60,1,2),(62,1,25),(64,1,64),(65,1,53),(67,1,32),(69,1,14),(71,1,87),(72,1,69),2]
toadd1= [1,(60,1,5),(62,1,55),(64,1,31),(65,1,45),(67,1,115),(69,1,54),(71,1,87),(72,1,69),2]
midi = MIDIFile(vartrack) #it takes the number of tracks as a parameter, I haven't played with it.
midi.addTempo(0,0,bpm)
time = toadd[0] #if there's initial silence it's the first parameter, for aditional silence please pass the note 0
temp = 1
currtrack = 1

def addnotes(toadd):
	global temp
	global time
	global instrument
	global currtrack
	
	
	negativeError = ValueError("Start time should be positive")
	if toadd[0] < 0:
		raise negativeError

	if isinstance(toadd[len(toadd)-1], (int)): #if last element is an integer, it's the number of repeats
		toadd.extend(repeat(toadd,len(toadd)-1))
		


	for i in range(1, len(toadd)-1):
		try:
			note = toadd[i][0] #getting the note
			duration = toadd[i][1] #duration of the note
		except:
			pass

		try: #trying for instrument change
			instrument = toadd[i][2] #checking for instrument
			if(instrument != temp):
				midi.addProgramChange(0, 0, time, instrument) #changing the current instrument
				temp = instrument
				print("changed instrument") 
		except:
			instrument = temp # keep the previous instrument, defaults as Acoustic Grand Piano
			pass #Continue writting
		print(note, duration, instrument)
		midi.addNote(currtrack,0,note,time,duration,100) #Adding the actual note
		time += duration #incrementing time so that the next note falls where the previous ended
		print(time)
	currtrack += 1 #increasing so that the next list is written in another track

addnotes(toadd)
addnotes(toadd1)		
	

with open("test.mid", 'wb') as file: #writting binary file
	midi.writeFile(file)
	print("written")

