package model;



public class TextSlot extends Slot {
	private String text;

	public TextSlot(String text) {
		this.text = text;
	}

	

	public double value(Environment env) {
		return 0;
	}

	public String toString(Environment env) {
		if (text.length() == 1) {
			return "";
		}
		return text.substring(1);
	}
	
	public String toString() {
		return text;
	}
}
