package gui.menu;

import gui.Gui;
import gui.StatusArea;

import java.awt.FileDialog;

import model.DataBase;
import model.XLPrintStream;


class SaveMenuItem extends FileMenuItem {
	private DataBase dataBase;
    public SaveMenuItem(Gui gui, StatusArea statusArea, DataBase dataBase) {
        super(gui, statusArea, "Save");
        action = FileDialog.SAVE;
        this.dataBase = dataBase;
    }

    public void action(String name) {
        try {
            //XLPrintStream printStream = new XLPrintStream(name);
            dataBase.saveToFile(name);
        } catch (Exception e) {
            statusArea.setText(e.getMessage());
        }
    }
}