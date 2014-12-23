
package program;

import operand.Operand;
import Memory.Memory;

public class JumpEq extends Jump {
	private Operand op1, op2;
	
	
	public JumpEq(int index, Operand op1, Operand op2) {
		super(index);
		this.op1 = op1;
		this.op2 = op2;
		
	}
	
	public void  exec(Memory memory, ProgramCounter pc){
		if(op1.getWord(memory).equals(op2.getWord(memory))){
			super.exec(memory, pc);
		}
	}
	public String toString(){
		return " JUMPEQ " +Integer.toString(index) + op1.toString() + op2.toString();
	}
}
