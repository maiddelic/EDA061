/**
 * 
 */
package program;

import operand.Address;
import operand.Operand;
import Memory.*;

/**
 * @author maiddelic
 *
 */
public class Add extends Expr {

	
	public Add(Operand opr1, Operand opr2, Address add) {
		super(opr1, opr2, add);
	}

	@Override
	public void exec(Memory mem, ProgramCounter pc) {
		//mem.getWord(add.getWord(mem).add(opr1.getWord(mem), opr2.getWord(mem));
		add.getWord(mem).add(opr1.getWord(mem), opr2.getWord(mem));
	}
	public String toString(){
		return " ADD " + opr1.toString() + opr2.toString() + add.toString();
	}
}
