package gui.menu;

import gui.Gui;
import gui.StatusArea;

import java.awt.FileDialog;

import model.DataBase;
import model.XLBufferedReader;

class OpenMenuItem extends FileMenuItem {
	private DataBase dataBase; 
    public OpenMenuItem(Gui gui, StatusArea statusArea, DataBase dataBase) {
        super(gui, statusArea, "Open");
        action = FileDialog.LOAD;
        this.dataBase = dataBase;
    }

    public void action(String name) {
        try {
            XLBufferedReader reader = new XLBufferedReader(name);
            dataBase.readFromFile(reader);
        } catch (Exception e) {
            statusArea.setText(e.getMessage());
       }
    }
}