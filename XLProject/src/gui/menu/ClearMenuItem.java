package gui.menu;

import gui.CurrentSlot;
import gui.StatusArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import xl.Address;
import model.DataBase;
import model.XLException;

class ClearMenuItem extends JMenuItem implements ActionListener {
	private CurrentSlot currentSlot;
	private DataBase dataBase;
	private StatusArea statusArea;

	public ClearMenuItem(DataBase dataBase, CurrentSlot currentSlot,
			StatusArea statusArea) {
		super("Clear");
		addActionListener(this);
		this.currentSlot = currentSlot;
		this.dataBase = dataBase;
		this.statusArea = statusArea;
	}

	public void actionPerformed(ActionEvent event) {
			dataBase.remove(new Address(currentSlot.getRow(), currentSlot.getCol()));

	}
}