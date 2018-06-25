public class Performance {
	private double startTime;
	private Sequence sequence;
	private Instrument instrument;
	private int repeatTimes;

	// constructors
	public Performance(double start, Sequence seq, Instrument inst, int repeat) {
		startTime = start;
		sequence = seq;
		instrument = inst;
		repeatTimes = repeat;
	}
	public Performance(Sequence seq, Instrument inst) {
		this(0, seq, inst, 1);
	}
	//copy constructor
    public Performance(Performance p) {
        this(p.startTime, new Sequence(p.sequence), p.instrument, p.repeatTimes);
    }

	// getters & setters
	public double duration() {
		return sequence.duration();
	}
	public double[] startTime() {
		return startTime;
	}
	public int repeatTimes() {
		return repeatTimes;
	}
	// TODO!! 2 functions bellow + startTime() which should return more than 1 value, if applicable
	// repeats (2+ equal start times) must be supported!
	public void changeStartTime(double toReplace, double newStart) {
		assert newStart > 0;
		//startTime = start;
		startTime = newStart;
	}
	public void addStartTime(double start) {
		assert start > 0;
		//startTime = start;
	}
	public void repeatTimes(int repeat) {
		assert repeat > 0;
		repeatTimes = repeat;
	}

	// other methods
	public Performance modulatePitch(int pitchChange) {
		return new Performance(startTime, sequence.modulatePitch(pitchChange), instrument, repeatTimes);
	}
	public Performance modulateTempo(double tempoChange) {
		return new Performance(startTime, sequence.modulateTempo(tempoChange), instrument, repeatTimes);
	}
	public Performance delay(double delay) {
		return new Performance(startTime + delay, sequence, instrument, repeatTimes);
	}
	public Performance repeat(int repeats) {
		return new Performance(startTime, sequence, instrument, repeats);
	}

}