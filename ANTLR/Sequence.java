public class Sequence {
	private double duration;
	private Chord[] chords;

	// constructors
	public Sequence(Chord[] n) {
		duration = 0;
		chords = new Chord[n.length]; 	// (if notes was not its own array, it'd be a shallow copy of n)

		for (int i = 0; i < n.length; i++) {
			duration += n[i].duration();
			chords[i] = n[i];
		}
	}
	//copy constructor
    public Sequence(Sequence s) {
        this(s.chords);
    }

	// getters
	public double duration() {
		return duration;
	}
	
	public Chord[] chords() {
		return chords;
	}


	// other methods
	public Sequence modulatePitch(int pitchChange) {
		Sequence s = new Sequence(chords);
		
		for (int i = 0; i < chords.length; i++) {
			s.chords[i] = new Chord(s.chords[i].modulatePitch(pitchChange), s.chords[i].duration());
		}

		return s;
	}

	public Sequence modulateTempo(double tempoChange) {
		Sequence s = new Sequence(chords);

		for (int i = 0; i < chords.length; i++) {
			s.chords[i] = new Chord(
				s.chords[i].notes(), 
				(tempoChange > 0)? s.chords[i].duration() * tempoChange 
								 : s.chords[i].duration() / tempoChange
				);
		}
		
		return s;
	}

	public void absorb(Sequence s) { // absorbs another sequence (concatenates to its own end)
		// update duration
		duration += s.duration;

		// create new note array
		Chord[] c = new Chord[chords.length + s.chords.length];

		// fill new note array
		for (int i = 0; i < chords.length; i++) {
			c[i] = chords[i];
		}
		for (int i = 0; i < s.chords.length; i++) {
			c[chords.length+i] = s.chords[i];
		}

		chords = c;
	}

	@Override public String toString() {
		String s = "[ ";
		for (int i = 0; i < chords.length; i++) {
			for(Note n : chords[i].notes()) {
				s += "[" + n.value() + ", " + n.duration() + "] ,";
			}
		}
		return s + "]";
	}
}