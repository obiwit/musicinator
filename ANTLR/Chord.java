
public class Chord {
	
	private Note[] notes;
		
	public Chord(String chordSt) {
		notes = new Note[chordSt.split("\\|").length];
			
		int i = 0;
		for(String st : chordSt.split("\\|")) {
			notes[i++] = new Note(st);
		}		
	}
	
	public Note[] notes(){
		return notes;
	}
}
