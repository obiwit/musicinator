import java.util.*;

public class Music {
	private int bpm;
	private Map<String, Instrument> intruments; // contains defined instruments

	//ArrayList<Performances> performances; // might not store them and just send to python

	public Music(int bpm) {
		this.bpm = bpm;

		// creates instruments supported by default
		intruments = new HashMap<>();
		intruments.put("piano", new Instrument(1));
		intruments.put("guitar", new Instrument(25));
		intruments.put("violin", new Instrument(41));
		intruments.put("cello", new Instrument(43));
		intruments.put("bass", new Instrument(44));
		intruments.put("drums", new Instrument(119));
	}
	public Music() {		
		// creates a new music, with default BPM of 120
		Music(120);
	}

	public void setBPM(int newBpm) {
		bpm = newBpm;
	}

	public void addInstrument(String name, Instrument i) {
		instruments.put(name, i);
	}

	public Instrument getInstrument(String name) {
		assert instruments.contains(name);
		return instruments.get(name);
	}
}