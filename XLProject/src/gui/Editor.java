package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextField;

import model.DataBase;
import model.XLException;


public class Editor extends JTextField implements ActionListener, Observer {
	private CurrentSlot slot;
	private DataBase dataBase;
	private StatusArea statusArea;

	public Editor(DataBase dataBase, CurrentSlot slot, StatusArea statusArea) {
		this.dataBase = dataBase;
		this.slot = slot;
		this.statusArea = statusArea;
		setBackground(Color.WHITE);
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		if (!getText().isEmpty()) {
			try {
				dataBase.insert(getText(), slot.getRow(), slot.getCol());
				statusArea.setText("");
			} catch (XLException e) {
				statusArea.setText(e.getMessage());
			}
		}
	}

	public void update(Observable arg0, Object arg1) {
		this.setText(dataBase.editorString(slot.getRow(), slot.getCol()));

	}
}