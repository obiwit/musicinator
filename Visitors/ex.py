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

############################ LINE = 1
_1 = (109,2.0,-1,-1)
_2 = (69,1.0,-1,-1)
_3 = (60,1.0,-1,-1)
_4 = (62,3.12,-1,-1)
_5 = (71,1.0,-1,-1)
_6 = (108,1.0,-1,-1)
_7 = (62,3.0,-1,-1)
_8 = (73,0.5,-1,-1)
_9 = (64,4.0,-1,-1)
_10 = (77,3.0,-1,-1)
_11 = (65,0.0625,-1,-1)
_0 = [].append(_1).append(_2).append(_3).append(_4).append(_5).append(_6).append(_7).append(_8).append(_9).append(_10).append(_11)
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
_18 = (60,1.0,-1,-1)
_17 = [].append(_18)
intro = _17
############################ LINE = 8
_20 = (60,1.0,-1,-1)
_19 = [].append(_20)
twinkle1 = _19
############################ LINE = 9
_22 = (60,1.0,-1,-1)
_23 = (60,1.0,-1,-1)
_24 = (67,1.0,-1,-1)
_25 = (67,1.0,-1,-1)
_26 = (69,1.0,-1,-1)
_27 = (69,1.0,-1,-1)
_28 = (67,2.0,-1,-1)
_29 = (65,1.0,-1,-1)
_30 = (65,1.0,-1,-1)
_31 = (64,1.0,-1,-1)
_32 = (64,1.0,-1,-1)
_33 = (62,1.0,-1,-1)
_34 = (62,1.0,-1,-1)
_35 = (60,2.0,-1,-1)
_21 = [].append(_22).append(_23).append(_24).append(_25).append(_26).append(_27).append(_28).append(_29).append(_30).append(_31).append(_32).append(_33).append(_34).append(_35)
twinkle = _21
############################ LINE = 10
p = _guitar
############################ LINE = 12
_37 = (-49,4.0,-1,-1)
_38 = (60,4.0,-1,-1)
_39 = (67,4.0,-1,-1)
_40 = (72,3.5,-1,-1)
_41 = (77,0.5,-1,-1)
_42 = (75,8.0,-1,-1)
_43 = (60,4.0,-1,-1)
_44 = (67,4.0,-1,-1)
_36 = [].append(_37).append(_38).append(_39).append(_40).append(_41).append(_42).append(_43).append(_44)
intro2 = _36
############################ LINE = 14
_46 = (60,0.25,-1,-1)
_47 = (60,1.0,-1,-1)
_48 = (67,1.0,-1,-1)
_49 = (67,1.0,-1,-1)
_50 = (69,0.5,-1,-1)
_51 = (69,0.5,-1,-1)
_52 = (67,2.0,-1,-1)
_53 = (65,1.0,-1,-1)
_54 = (65,1.0,-1,-1)
_55 = (64,1.0,-1,-1)
_56 = (64,1.0,-1,-1)
_57 = (62,1.0,-1,-1)
_58 = (62,1.0,-1,-1)
_59 = (60,2.0,-1,-1)
_45 = [].append(_46).append(_47).append(_48).append(_49).append(_50).append(_51).append(_52).append(_53).append(_54).append(_55).append(_56).append(_57).append(_58).append(_59)
pp = _guitar
############################ LINE = 16
band = 
############################ LINE = 18
band3 = _drums
############################ LINE = 19
_60 = 1
_61 = 2
_62 = 3
n = 
############################ LINE = 20
_63 = 1
_64 = 3
n2 = _64
############################ LINE = 21
_66 = (60,1.0,-1,-1)
_67 = (60,1.0,-1,-1)
_68 = (67,1.0,-1,-1)
_69 = (67,1.0,-1,-1)
_70 = (69,1.0,-1,-1)
_71 = (69,1.0,-1,-1)
_72 = (67,2.0,-1,-1)
_73 = (65,1.0,-1,-1)
_74 = (65,1.0,-1,-1)
_75 = (64,1.0,-1,-1)
_76 = (64,1.0,-1,-1)
_77 = (62,1.0,-1,-1)
_78 = (62,1.0,-1,-1)
_79 = (60,2.0,-1,-1)
_65 = [].append(_66).append(_67).append(_68).append(_69).append(_70).append(_71).append(_72).append(_73).append(_74).append(_75).append(_76).append(_77).append(_78).append(_79)
s = _65
############################ LINE = 24
############################ LINE = 25
############################ LINE = 26
############################ LINE = 30
_80 = duration(_s)
_81 = 10
############################ LINE = 31
_82 = duration(_s)
_83 = 5
############################ LINE = 34
############################ LINE = 37
############################ LINE = 43
############################ LINE = 45
_85 = (60,1.0,-1,-1)
_86 = (60,1.0,-1,-1)
_87 = (67,1.0,-1,-1)
_88 = (67,1.0,-1,-1)
_89 = (69,1.0,-1,-1)
_90 = (69,1.0,-1,-1)
_91 = (67,2.0,-1,-1)
_92 = (65,1.0,-1,-1)
_93 = (65,1.0,-1,-1)
_94 = (64,1.0,-1,-1)
_95 = (64,1.0,-1,-1)
_96 = (62,1.0,-1,-1)
_97 = (62,1.0,-1,-1)
_98 = (60,2.0,-1,-1)
_84 = [].append(_85).append(_86).append(_87).append(_88).append(_89).append(_90).append(_91).append(_92).append(_93).append(_94).append(_95).append(_96).append(_97).append(_98)
############################ LINE = 48
_100 = (62,1.5,-1,-1)
_101 = (62,0.5,-1,-1)
_102 = (64,1.0,-1,-1)
_103 = (62,1.0,-1,-1)
_104 = (67,1.0,-1,-1)
_105 = (65,2.0,-1,-1)
_99 = [].append(_100).append(_101).append(_102).append(_103).append(_104).append(_105)
_107 = (62,1.5,-1,-1)
_108 = (62,0.5,-1,-1)
_109 = (64,1.0,-1,-1)
_110 = (62,1.0,-1,-1)
_111 = (69,1.0,-1,-1)
_112 = (67,2.0,-1,-1)
_106 = [].append(_107).append(_108).append(_109).append(_110).append(_111).append(_112)
_114 = (62,1.5,-1,-1)
_115 = (62,0.5,-1,-1)
_116 = (74,1.0,-1,-1)
_117 = (71,1.0,-1,-1)
_118 = (67,1.0,-1,-1)
_119 = (65,1.0,-1,-1)
_120 = (64,1.0,-1,-1)
_113 = [].append(_114).append(_115).append(_116).append(_117).append(_118).append(_119).append(_120)
p_a = 
############################ LINE = 55
new_band = _violin
############################ LINE = 59
intro3 = _p_a[0]
############################ LINE = 61
############################ LINE = 62
