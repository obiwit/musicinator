public class Note {
	private String value;
	private String duration;

	// constructors
	public Note(int v, double d) {
		duration = d + "";
		value = v + "";
	}
	public Note(int v) {
		this(v, 1);
	}
	public Note(String note) {
		double d = durationFromStr(note);

		String noDuration = note;
		if (note.contains("{")) {
			noDuration = note.substring(0, note.indexOf("{"));
		} else if (note.contains("'")) {
			noDuration = note.substring(0, note.indexOf("'"));;
		}

		this.value = noteToPitch(noDuration) + "";
		this.duration = d + "";
	}
	
	//setters
	
	public void duration(double duration) {
		assert duration > 0;
		this.duration = duration + "";
	}
	
	public void value(int pitchChange) {
		this.value = this.value + " + " + pitchChange;
	}

	// getters
	public String value() {
		return value;
	}
	public String duration() {
		return duration;
	}

	// other methods
	// @Override public String toString() {
	// 	return "("+value+"-"+duration+")";
	// }

	// static functions
	public static int noteToPitch(String note) {

		int value = getBaseValue(note.charAt(0));
		
		if(note.matches(".*[0-8].*")) {
			int octave = Character.getNumericValue(note.charAt(note.length() - 1));
			if (note.contains("-")) 
				octave *= -1;

			value += 12*(octave+1); // base value starts from octave -1
		} else {
			value += 60; // 48 = 12 * 5, 4(=-1+5) is the octave by default
		}

		String[] splitted = note.split("");
		for (int i = 1; i < splitted.length - 1; i++) {
			if(splitted[i].equals("#"))
				value++;
			else if(splitted[i].equals("b"))
				value--;
		}

		return value;

	}

	public static double durationFromStr(String dur) {
		double duration = 1;
		if (dur.contains("{")) {
			duration = Double.parseDouble(dur.substring(dur.indexOf("{") + 1, dur.indexOf("}")));
		} else if (dur.contains("'")) {
			while(dur.contains("'")) {
				duration /= 2;
				dur = dur.substring(0, dur.length()-1);
			}
		}
		return duration;
	}

	private static int getBaseValue(char symbol) {
		//de acordo com o simbolo dado: [A-G] retorna Value do seu numero MIDI
		
		switch (symbol) {
			case 'C':
				return 0;
			case 'D':
				return 2;
			case 'E':
				return 4;
			case 'F':
				return 5;
			case 'G':
				return 7;
			case 'A':
				return 9;
			case 'B':
				return 11;
		}

		return -109; // guarantees rests ('R') are negative
	}
	@Override
	public String toString() {
		return "("+this.value()+","+this.duration()+",-1,-1)";
	}
}
