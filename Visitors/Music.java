import java.util.*;

public class Music {
	private int bpm;
	private Map<String, Instrument> instruments; // contains defined instruments
	private double longestPerformanceDuration; // used for the loop instruction
	private ArrayList<String> reserved;
    private Map<String, Integer> noteMap; // Map - noteName to Pitch	

	// constructors
	public Music(int bpm) {
		this.bpm = bpm;
		noteMap = new HashMap<>();
		reserved = new ArrayList<>();

		// creates instruments supported by default
		instruments = new HashMap<>();
		instruments.put("piano", new Instrument("piano", 1));
		instruments.put("guitar", new Instrument("guitar", 25));
		instruments.put("violin", new Instrument("violin", 41));
		instruments.put("cello", new Instrument("cello", 43));
		instruments.put("bass", new Instrument("bass", 44));
		instruments.put("drums", new Instrument("drums", 119));

		populateReserved();
	}

	public Music() {
		// creates a new music, with default BPM of 120
		this(120);
	}

	// getters and setters
	public int bpm() {
		return bpm;
	}

	public void bpm(int newBpm) {
		bpm = newBpm;
	}
	public HashMap<String, Integer> noteMap() { // returns shallow copy of note Map
		return new HashMap<String, Integer>(noteMap);	
	}
	public HashMap<String, Instrument> instruments() {
		return new HashMap<String, Instrument>(instruments);
	}

	// other methods
	public void addInstrument(String name, Instrument i) {
		instruments.put(name, i);
		addReservedWord(name);
	}
	public Instrument getInstrument(String name) {
		assert instruments.containsKey(name);
		return instruments.get(name);
	}
	public boolean isInstrument(String name) {
		return instruments.containsKey(name);
	}

	public boolean isNoteName(String name) {
		return noteMap.containsKey(name);
	}
	public void mapNote(String noteName, int note) { // maps a note
		noteMap.put(noteName, note);	
		addReservedWord(noteName);
	}

	private void populateReserved() {
		String[] python_keywords = { "and", "as", "assert", "break", "class", "continue", "def", "del", "elif", "else",
				"except", "finally", "for", "from", "global", "if", "import", "in", "is", "lambda", "nonlocal", "not",
				"or", "pass", "raise", "return", "try", "while", "with", "yield", "abs", "all", "any",
				"ascii", "bin", "bool", "bytearray", "bytes", "callable", "chr", "classmethod", "compile", "complex",
				"copyright", "credits", "delattr", "dict", "dir", "divmod", "enumerate", "eval", "exec", "exit",
				"filter", "float", "format", "frozenset", "getattr", "globals", "hasattr", "hash", "help", "hex", "id",
				"input", "int", "isinstance", "issubclass", "iter", "len", "license", "list", "locals", "map", "max",
				"memoryview", "min", "next", "object", "oct", "open", "ord", "pow", "print", "property", "quit",
				"range", "repr", "reversed", "round", "set", "setattr", "slice", "sorted", "staticmethod", "str", "sum",
				"super", "tuple", "type", "vars", "zip" };

		instruments.forEach((key, value) -> {
			reserved.add(key);
		});

		for (String s : python_keywords) {
			reserved.add(s);
		}

	}

	public void addReservedWord(String word){
		reserved.add(word);
	}

	public boolean isReservedWord(String word) {
		return reserved.contains(word);
	}
}