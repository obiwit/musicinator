public class Note {
	private int value;
	private double duration;

	// constructors
	public Note(int v, double d) {
		duration = d;
		value = v;
	}
	public Note(int v) {
		this(v, 1);
	}
	public Note(String note) {
		duration = 1;
		String noDuration = note;
		
		if (note.contains("{")) {
			duration = Double.parseDouble(note.substring(note.indexOf("{") + 1, note.indexOf("}")));
			noDuration = note.substring(0, note.indexOf("{"));
		} else if (note.contains("'")) {
			while(note.contains("'")) {
				duration /= 2;
				note = note.substring(0, note.length()-1);
			}
			noDuration = note;
		}

		value = noteToPitch(noDuration);
	}

	// getters
	public int value() {
		return value;
	}
	public double duration() {
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
			else // equals "b"
				value--;
		}

		return value;

	}

	private static int getBaseValue(char symbol) {
		
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

		return -1;
	}
}
