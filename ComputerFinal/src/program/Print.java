
package program;

import operand.Operand;
import Memory.Memory;

public class Print extends Command{

	private Operand op;
	public Print(Operand op) {
		this.op = op;
	}

	@Override
	public void exec(Memory mem, ProgramCounter pc) {
		System.out.print(op.getWord(mem).toString());
		
	}
	public String toString(){
		return " PRINT " + op;
	}
}
