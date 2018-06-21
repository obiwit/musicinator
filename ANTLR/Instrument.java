public class Instrument {

	private int NOTERANGE = 108;
	private int value[];

	public Instrument(int v) {
		value = new int[NOTERANGE];
		for (int i = 0; i < NOTERANGE; i++)
			value[i] = v;
	}

	public void redefineRange(int start, int end, int newValue) {
		assert start > 0 && end < NOTERANGE;
		for (int i = start; i <= end; i++)
			value[i] = newValue;
	}

	public int value(int note) {
		assert note > 0 && note < NOTERANGE;
		return value[note];
	}
}