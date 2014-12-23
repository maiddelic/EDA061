
package program;

import Memory.Memory;

public class Halt extends Jump {

	public Halt() {
		super(-1);
	}
	public void exec(Memory memory, ProgramCounter pc){
		pc.setCount(-1);
	}
	public String toString(){
		return " HALT ";
	}
}
