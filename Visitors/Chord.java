import java.util.Arrays;

public class Chord {

	private Note[] notes;
	private double duration;

	public Chord(Note[] notes, double duration) {
		this.notes = notes;
		this.duration = duration;
		enforceDuration();
	}

	private void enforceDuration(){
		for (int i = 0; i < notes.length; i++) {
			notes[i].duration(duration);
		}
	}
	
	public Chord(String chordSt) {
		notes = new Note[chordSt.split("\\|").length];
		double duration = 1;
		String temp = chordSt;

		if (temp.contains("{")) {
			duration = Double.parseDouble(chordSt.substring(temp.indexOf("{") + 1, temp.indexOf("}")));
		} else if (temp.contains("'")) {
			while (temp.contains("'")) {
				duration /= 2;
				temp = temp.substring(0, temp.length() - 1);
			}
		}
		
		this.duration = duration;

		int i = 0;
		for (String st : chordSt.split("\\|")) {
			notes[i] = new Note(st);
			notes[i].duration(duration);
			i++;
		}

	}
	
	public Note[] modulatePitch(int PitchChange) {
		Note[] tmpNotes = notes;
		
		for(int i = 0; i < tmpNotes.length; i++) {
			tmpNotes[i].value(PitchChange);
		}
		
		return tmpNotes;
		
	}

	public Note[] notes() {
		return notes;
	}
	
	public double duration() {
		return duration;
	}

	@Override
	public String toString() {
		return Arrays.toString(notes);
		//.substring(1, Arrays.toString(notes).length() - 1)
	}
}
