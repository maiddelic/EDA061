
package Memory;

import operand.Address;
import operand.Word;

public abstract class Memory{
	protected int length;
	protected Word[] memory;
	
	public abstract void add(Word wo);
	
	public abstract void set(Word wo, Address ad);

	public abstract Word getWord(int pos);
		
}