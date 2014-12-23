package operand;

import Memory.Memory;

public class LongWord extends Word {
	protected long i;

	public LongWord(long i) {
		this.i = i;
	}

	@Override
	public Word getWord(Memory memory) {
		return this;

	}

	@Override
	public long getValue() {
		return new Long(i);
	}

	@Override
	public boolean equals(Word w) {
		return i == w.getValue();
	}

	

	public void mul(Word w1, Word w2) {
		this.i = w1.getValue() * w2.getValue();

	}
	
	
	@Override
	public void add(Word w1, Word w2) {
		this.i = w1.getValue() + w2.getValue();

	}

	@Override
	public void copy(Word w1) {
		this.i = w1.getValue();

	}
	public String toString(){
		return Integer.toString((int) i);
	}

	@Override
	public long getValue(Memory memory) {
		// TODO Auto-generated method stub
		return 0;
	}
}
