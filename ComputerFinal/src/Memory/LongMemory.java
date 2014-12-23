/**
 * 
 */
package Memory;

import operand.Address;
import operand.Word;

public class LongMemory extends Memory {

	private int index;
	private Word memory[];

	public LongMemory(int length) {
		index = 0;
		memory = new Word[length];
	}

	public void add(Word wo) {
		memory[index] = wo;
		index++;
	}

	public void set(Word wo, Address ad) {
		memory[ad.i] = wo;
	}

	public Word getWord(int pos) {
		return memory[pos];
	}

}
