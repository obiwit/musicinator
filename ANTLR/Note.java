public class Note {
	private int value;
	private double duration;

	public Note(int v, int d) {
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
		}

		value = noteToPitch(noDuration);
	}

	public int value() {
		return value;
	}
	public double duration() {
		return duration;
	}

	public static int noteToPitch(String note) {

		int value = getBaseValue(note.charAt(0));
		
		if(note.matches(".*[0-8].*")) {
			int octave = Character.getNumericValue(note.charAt(note.length() - 1));
			value += 12*octave;
		} else {
			value += 48; // 48 = 12 * 4, 4 is the octave by default
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
				return 12;
			case 'D':
				return 14;
			case 'E':
				return 16;
			case 'F':
				return 17;
			case 'G':
				return 19;
			case 'A':
				return 21;
			case 'B':
				return 23;
		}

		return -1;
	}
}
