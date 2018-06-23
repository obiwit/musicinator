public class Sequence {
	private double duration;
	private Note[] notes;

	// constructors
	public Sequence(Note[] n) {
		duration = 0;
		notes = new Note[n.length]; 	// (if notes was not its own array, it'd be a shallow copy of n)

		for (int i = 0; i < n.length; i++) {
			duration += n[i].duration();
			notes[i] = n[i];
		}
	}
	//copy constructor
    public Sequence(Sequence s) {
        this(s.notes);
    }

	// getters
	public double duration() {
		return duration;
	}


	// other methods
	public Sequence modulatePitch(int pitchChange) {
		Sequence s = new Sequence(notes);

		for (int i = 0; i < notes.length; i++) {
			s.notes[i] = new Note(s.notes[i].value() + pitchChange, s.notes[i].duration());
		}

		return s;
	}

	public Sequence modulateTempo(double tempoChange) {
		Sequence s = new Sequence(notes);

		for (int i = 0; i < notes.length; i++) {
			s.notes[i] = new Note(
				s.notes[i].value(), 
				(tempoChange > 0)? s.notes[i].duration() * tempoChange 
								 : s.notes[i].duration() / tempoChange
				);
		}
		
		return s;
	}

	public void absorb(Sequence s) { // absorbs another sequence (concatenates to its own end)
		// update duration
		duration += s.duration;

		// create new note array
		Note[] n = new Note[notes.length + s.notes.length];

		// fill new note array
		for (int i = 0; i < notes.length; i++) {
			n[i] = notes[i];
		}
		for (int i = 0; i < s.notes.length; i++) {
			n[notes.length+i] = s.notes[i];
		}

		notes = n;
	}

	@Override public String toString() {
		String s = "[ ";
		for (int i = 0; i < notes.length; i++) 
			s += notes[i].value() + " ";
		return s + "]";
	}
}