import java.util.ArrayList;
import java.util.Arrays;

public class Performance {
	private double[] startTime;
	private Sequence sequence;
	private Instrument instrument;
	private int repeatTimes;

	// constructors
	public Performance(double[] startArray, Sequence seq, Instrument inst, int repeat){
		startTime = startArray;
		sequence = seq;
		instrument = inst;
		repeatTimes = repeat;
	}
	public Performance(double start, Sequence seq, Instrument inst, int repeat) {
		this(startToArray(start), seq, inst, repeat);
	}
	public Performance(Sequence seq, Instrument inst) {
		this(0, seq, inst, 1);
	}
	//copy constructor
    public Performance(Performance p) {
        this(p.startTime, new Sequence(p.sequence), p.instrument, p.repeatTimes);
    }


    //Função para converter um double num Array de double's
    private static double[] startToArray(double start){
    	double[] tmpArray = new double[1];
		tmpArray[0] = start;
    	return tmpArray;
    }

	// getters & setters
	public double duration() {
		return sequence.duration();
	}
	//return array sequencial( 0-1-5-6-23-2123-...)
	public double[] startTime() {
		return startTime;
	}
	public int repeatTimes() {
		return repeatTimes;
	}
	
	public void changeStartTime(double toReplace, double newStart) {
		assert newStart > 0 && (new ArrayList<>(Arrays.asList(startTime))).contains(toReplace);

		//System.out.println("Linha 55 Performance: " + (new ArrayList<>(Arrays.asList(startTime))).contains(toReplace));

		for(int i = 0; i < startTime.length; i++){
			if(startTime[i] == toReplace){
				startTime[i] = newStart;
				break;
			}
		}

		Arrays.sort(startTime);
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
				tmp += "(" + tmpNotes.value() + ", " + tmpNotes.duration() + ", " + instrument.value(tmpNotes.value()) + ", " + insertionTime + "), ";				
			}
			insertionTime += tmpChord.duration();
		}
		
		return "[" + Arrays.toString(startTime) + ", " + tmp + repeatTimes + "]";
		
		}
}