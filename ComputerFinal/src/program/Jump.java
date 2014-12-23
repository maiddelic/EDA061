
package program;

import Memory.Memory;

public class Jump extends Command {
	protected int index;
	
	public Jump(int index) {
		this.index = index;
	}

	@Override
	public void exec(Memory mem, ProgramCounter pc) {
		pc.setCount(index);
	}
	public String toString(){
		return " JUMP " + Integer.toString(index);
	}
}
