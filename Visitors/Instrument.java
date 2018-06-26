import java.util.Arrays;

public class Instrument {	
	private int NOTERANGE = 120; // 0-119
	private int value[];
	private String name;

	public Instrument(String n, int v) {	
		name = n;
		value = new int[NOTERANGE];	
		for (int i = 0; i < NOTERANGE; i++)	
			value[i] = v;	
	}

	public void concatenate(Instrument inst, int discriminant){
		for(int i = 1; i < NOTERANGE; i++){
			int val = inst.value(i);
			if(val != discriminant){
				value[i] = val;
			}
		}
	}

	public void redefineRange(int start, int end, int newValue) {	
		assert start > 0 && start <= end && end < NOTERANGE;	
		for (int i = start; i <= end; i++)	
			value[i] = newValue;	
	}

	public void redefineNote(int pitch, int newValue) {
		assert pitch >= 0 && pitch < NOTERANGE;	
		value[pitch] = newValue;	
	}		

	public int value(int note) {	
		assert note >= 0 && note < NOTERANGE;	
		return value[note];	
	}
	
	public String name() {
		return name;
	}

	public void name(String name){
		this.name = name;
	}

	@Override
	public String toString() {
		return Arrays.toString(value);
	}
}