package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import model.DataBase;

class ClearAllMenuItem extends JMenuItem implements ActionListener {
	private DataBase dataBase;

	public ClearAllMenuItem(DataBase dataBase) {
		super("Clear all");
		addActionListener(this);
		this.dataBase = dataBase;
	}

	public void actionPerformed(ActionEvent e) {
		dataBase.clearAll();
	}
}
