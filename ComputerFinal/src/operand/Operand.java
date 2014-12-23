
package operand;

import Memory.Memory;

public interface Operand{

	public Word getWord(Memory memory);

	public long getValue(Memory memory);
	
	public String toString();
	
}
