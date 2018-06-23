public class Performance {
	private double startTime;
	private Sequence sequence;
	private Instrument instrument;

	// constructors
	public Performance(double start, Sequence seq, Instrument inst) {
		startTime = start;
		sequence = seq;
		instrument = inst;
	}
	public Performance(Sequence seq, Instrument inst) {
		this(0, seq, inst);
	}



	// other methods
	public Performance modulatePitch(int pitchChange) {
		return new Performance(startTime, sequence.modulatePitch(pitchChange), instrument);
	}

	public Performance modulateTempo(double tempoChange) {
		return new Performance(startTime, sequence.modulateTempo(tempoChange), instrument);
	}

}