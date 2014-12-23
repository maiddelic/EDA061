package gui;

import java.util.Observable;

public class CurrentSlot extends Observable {
	private int row;
	private int col;

	public CurrentSlot() {
		this.col = 0;
		this.row = 0;
	}

	public void set(int row, int col) {
		this.row = row;
		this.col = col;
		changeState();
	}

	public void changeState() {
		setChanged();
		notifyObservers();
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
}
