package model;

import java.io.IOException;
import expr.Expr;
import expr.ExprParser;
import expr.Parser;

public class SlotFactory {
	private Parser parser = new ExprParser();
	private char text = '#';
	
	public Slot createSlot(String input) {
		try {
			if (input.charAt(0) == text) {
				return createTextSlot(input);
			} else {
				return createExprSlot(input);
			}
		} catch (IndexOutOfBoundsException e) {
			return new ErrorSlot();
		}
	}

	

	private Slot createExprSlot(String input) {
		Expr expr = null;
		try {
			expr = parser.build(input);
		} catch (IOException e) {
			expr = null;
		}
		return new ExprSlot(expr);
	}
	
	private Slot createTextSlot(String input) {
		return new TextSlot(input);
	}
}
