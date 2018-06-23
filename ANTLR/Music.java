import java.util.*;

public class Music {
	private int bpm;
	private Map<String, Instrument> instruments; // contains defined instruments

	//ArrayList<Performances> performances; // might not store them and just send to python

	public Music(int bpm) {
		this.bpm = bpm;

		// creates instruments supported by default
		instruments = new HashMap<>();
		instruments.put("piano", new Instrument(1));
		instruments.put("guitar", new Instrument(25));
		instruments.put("violin", new Instrument(41));
		instruments.put("cello", new Instrument(43));
		instruments.put("bass", new Instrument(44));
		instruments.put("drums", new Instrument(119));
	}
	public Music() {		
		// creates a new music, with default BPM of 120
		this(120);
	}

	public void setBPM(int newBpm) {
		bpm = newBpm;
	}

	public void addInstrument(String name, Instrument i) {
		instruments.put(name, i);
	}

	public Instrument getInstrument(String name) {
		assert instruments.containsKey(name);
		return instruments.get(name);
	}

	public boolean isInstrument(String name) {
		return instruments.containsKey(name);
	}

	public Map getMap(){
		return instruments;
	}
}