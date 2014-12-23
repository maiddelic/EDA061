
package program;


import operand.Address;
import operand.Operand;
import Memory.*;

public class Mul extends Expr {
	
	
	public Mul(Operand opr1, Operand opr2, Address add) {
		super(opr1, opr2, add);
	}

	@Override
	public void exec(Memory mem, ProgramCounter pc) {
		add.getWord(mem).mul(opr1.getWord(mem), opr2.getWord(mem));
	}
	public String toString(){
		return " MUL " + opr1.toString() + opr2.toString() + add.toString();
	}
}
