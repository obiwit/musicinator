import java.util.Arrays;

public class Instrument {	
	private int NOTERANGE = 108;
	private int value[];
	private String name;

	public Instrument(String n, int v) {	
		name = n;
		value = new int[NOTERANGE];	
		for (int i = 0; i < NOTERANGE; i++)	
			value[i] = v;	
	}

	public void redefineRange(int start, int end, int newValue) {	
		assert start > 0 && start <= end && end < NOTERANGE;	
		for (int i = start; i <= end; i++)	
			value[i] = newValue;	
	}

	public void redefineNote(int pitch, int newValue) {
		assert pitch > 0 && pitch < NOTERANGE;	
		value[pitch] = newValue;	
	}		

	public int value(int note) {	
		assert note > 0 && note < NOTERANGE;	
		return value[note];	
	}
	
	public String name() {
		return name;
	}

	@Override
	public String toString() {
		return Arrays.toString(value);
	}
}