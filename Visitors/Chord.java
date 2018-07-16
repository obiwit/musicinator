import java.util.Arrays;

public class Chord {

	private Note[] notes;
	private double duration;

	// constructors
	public Chord(Note[] notes, double duration) {
		this.notes = notes;
		this.duration = duration;
		enforceDuration();
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
	private void enforceDuration(){
		for (int i = 0; i < notes.length; i++) {
			notes[i].duration(duration);
		}
	}

	// gettes
	public Note[] notes() {
		return notes;
	}
	
	public double duration() {
		return duration;
	}

	
	// other methods
	public Note[] modulatePitch(int PitchChange) {
		Note[] tmpNotes = notes;
		
		for(int i = 0; i < tmpNotes.length; i++) {
			tmpNotes[i].value(PitchChange);
		}
		
		return tmpNotes;
		
	}
	@Override public String toString() {
		String temp = "[";
		for (Note t_note : notes) {
			temp += t_note.toString() +",";
		}
		return temp.substring(0, temp.length()-1) + "]";
	}
}
