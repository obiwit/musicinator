import java.util.ArrayList;
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
	
	
	public void addStartTime(double start) {
		assert start > 0;
		double[] tmp = new double[startTime.length + 1];
		for(int i = 0; i < startTime.length; i++){
			tmp[i] = startTime[i];
		}
		tmp[startTime.length] = start;
		startTime = tmp;

		Arrays.sort(startTime);
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
	public Performance repeat(int repeats) {
		return new Performance(startTime, sequence, instrument, repeats);
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