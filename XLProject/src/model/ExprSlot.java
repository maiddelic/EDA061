package model;

import xl.NumberAdjustment;
import expr.Expr;

public class ExprSlot extends Slot {
	private Expr expr;
	private NumberAdjustment adjustment;

	public ExprSlot(Expr expr) {
		this.expr = expr;
		adjustment = new NumberAdjustment(0, 1);
	}

	public double value(Environment env) {
		return expr.value(env);
	}

	public String toString(Environment env) {
		return adjustment.right(value(env));
	}
	
	public String toString(){
		return expr.toString();
	}
}
