package model;

public abstract class Slot {

	public Slot() {
	}
	
	public abstract double value(Environment env);

	public abstract String toString(Environment env);
	
	public abstract String toString();
	
	
}
