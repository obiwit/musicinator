import java.util.Arrays;

public class Performance {
	private String[] startTime;
	private Sequence sequence;
	private Instrument instrument;
	private String repeatTimes;

	// constructors
	public Performance(String[] startArray, Sequence seq, Instrument inst, String repeat){
		startTime = startArray;
		sequence = seq;
		instrument = inst;
		repeatTimes = repeat + "";
	}
	public Performance(String start, Sequence seq, Instrument inst, String repeat) {
		this(startToArray(start), seq, inst, repeat);
	}
	public Performance(double start, Sequence seq, Instrument inst, int repeat) {
		this(startToArray(start + ""), seq, inst, repeat + "");
	}
	public Performance(Sequence seq, Instrument inst) {
		this(0 + "", seq, inst, 1 + "");
	}
	//copy constructor
    public Performance(Performance p) {
        this(p.startTime, new Sequence(p.sequence), p.instrument, p.repeatTimes);
    }


    //Função para converter um double num Array de double's
    private static String[] startToArray(String start){
    	String[] tmpArray = new String[1];
		tmpArray[0] = start;
    	return tmpArray;
    }

	// getters & setters
	public double duration() {
		return sequence.duration();
	}
	//return array sequencial( 0-1-5-6-23-2123-...)
	public String[] startTime() {
		return startTime;
	}
	public String repeatTimes() {
		return repeatTimes;
	}
	
	// adiciona um start 
	public void addStartTime(String start) {
		String[] tmp = new String[startTime.length + 1];
		for(int i = 0; i < startTime.length; i++){
			tmp[i] = startTime[i];
		}
		tmp[tmp.length - 1] = start;
		startTime = tmp;
	}
	
	//add um array de Start's  ex.: "[0.2, 4, 5,6]"
	public void addStartTimeArray(String startArray) {
		
		String [] tmp1 = startArray.substring(1, startArray.length() - 1).split(",");
		
		// tmp1 + startArray 
		String[] tmp2  = new String[startTime.length + tmp1.length];
		
		for(int i = 0; i < startTime.length; i++){
			tmp2[i] = startTime[i];
		}
		for(int i = startTime.length; i < tmp1.length + startTime.length; i++){
			tmp2[i] = tmp1[i - startTime.length];
		}
		
	}
	
	public void repeatTimes(String repeat) {
		repeatTimes = repeat;
	}

	// other methods
	public Performance modulatePitch(int pitchChange) {
		return new Performance(startTime, sequence.modulatePitch(pitchChange), instrument, repeatTimes);
	}
	public Performance modulateTempo(double tempoChange) {
		return new Performance(startTime, sequence.modulateTempo(tempoChange), instrument, repeatTimes);
	}
	public Performance repeat(int repeats) {
		return new Performance(startTime, sequence, instrument, repeats + "");
	}

	@Override public String toString() {
//			 print rests?
//			 [[startTimes], (pitch, duration, instrument, insertionTime), ..., (,,), repeatTimes]
		
		String tmp = "";
		double insertionTime = 0;
		
		for(Chord tmpChord : sequence.chords()) {
			for(Note tmpNotes : tmpChord.notes()) {
				//note.duration() === chords.duration()
				tmp += "(" + tmpNotes.value() + ", " + tmpNotes.duration() + ", " +  instrument.name() + "[" + tmpNotes.value() + "]" + ", " + insertionTime + "), ";				
			}
			insertionTime += tmpChord.duration();
		}
		
		return "[" + Arrays.toString(startTime) + ", " + tmp + repeatTimes + "]";
		
		}
}