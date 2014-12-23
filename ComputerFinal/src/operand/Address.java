/**
 * 
 */
package operand;

import Memory.Memory;


/**
 * @author jonathanklingberg
 *
 */
public class Address implements Operand {
	public int i;

	public Address(int i) {
		this.i = i;
	}
	
	public Word getWord(Memory memory){
		return memory.getWord(i);
	}

	@Override
	public long getValue(Memory memory) {
		return memory.getWord(i).getValue();
	}
	public String toString(){
		return  "[" + i + "]" ;
	}
}
