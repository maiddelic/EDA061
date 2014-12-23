
package program;

import operand.Address;
import operand.Word;
import Memory.*;

public class Copy extends Command  {
	private Word wo;
	private Address address;
	
	public Copy(Word word, Address address) {
		this.wo = word;
		this.address = address;
	}

	public void exec(Memory mem, ProgramCounter pc) {
		mem.set(wo, address);
	}
	public String toString(){
		return " COPY " + wo.toString() +address.toString(); 
	}
}
