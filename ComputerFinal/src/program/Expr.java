/**
 * 
 */
package program;

import operand.Address;
import operand.Operand;

public abstract class Expr extends Command {
	protected Operand opr1, opr2;
	protected Address add;

	public Expr(Operand opr1, Operand opr2, Address add) {
		this.opr1 = opr1;
		this.opr2 = opr2;
		this.add = add;
	}
}
