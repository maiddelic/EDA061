package model;

public class ErrorSlot extends Slot {

	public ErrorSlot() {
	}

	public double value(Environment env) {
		throw new XLException("Circular ERROR");
	}

	public String toString(Environment env) {
		return "";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
}
