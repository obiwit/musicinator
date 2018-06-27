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
    	String[] tmpArray = { start };
    	return tmpArray;
    }
	
	public void addStartTime(String start) {
//		assert start > 0;
		String[] tmp = new String[startTime.length + 1];
		for(int i = 0; i < startTime.length; i++){
			tmp[i] = startTime[i];
		}
		tmp[startTime.length] = start;
		startTime = tmp;

		Arrays.sort(startTime);
	}
	
	
	public void repeatTimes(String repeat) {
//		assert repeat > 0;
		repeatTimes = repeat;
	}

	// return Performance with Pitch changed
	public Performance modulatePitch(int pitchChange) {
		return new Performance(startTime, sequence.modulatePitch(pitchChange), instrument, repeatTimes);
	}

	//return Performance with Tempo changed
	public Performance modulateTempo(double tempoChange) {
		return new Performance(startTime, sequence.modulateTempo(tempoChange), instrument, repeatTimes);
	}

	//return Performance with with one or more repeats
	public Performance repeat(String repeats) {
		return new Performance(startTime, sequence, instrument, repeats);
	}


	// getters
	public double duration() {
		return sequence.duration();
	}

	public String[] startTime() {
		return startTime;
	}
	
	public String repeatTimes() {
		return repeatTimes;
	}

//			toString() importante para a passagem das performances
//			o formato da string é: 
//			[[startTimes], (pitch, duration, instrument, insertionTime),(pitch2, duration2, instrument2, insertionTime2), ..... , repeatTimes]
	@Override public String toString() {
		String tmp = "";
		double insertionTime = 0;
		
		for(Chord tmpChord : sequence.chords()) {
			for(Note tmpNotes : tmpChord.notes()) {
				//tmpNotes.duration() equivalente a tmpChord.duration()
				tmp += "(" + tmpNotes.value() + ", " + tmpNotes.duration() + ", " +  instrument.name() + "[" + tmpNotes.value() + "]" + ", " + insertionTime + "), ";				
			}
			insertionTime += tmpChord.duration();
		}
		
		return "[" + Arrays.toString(startTime) + ", " + tmp + repeatTimes + "]";
		
		}
}