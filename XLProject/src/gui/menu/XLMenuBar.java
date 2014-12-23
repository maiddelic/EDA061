package gui.menu;

import gui.CurrentSlot;
import gui.Gui;
import gui.GuiList;
import gui.StatusArea;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import model.DataBase;

public class XLMenuBar extends JMenuBar {
    public XLMenuBar(Gui gui, GuiList guiList, StatusArea statusArea, DataBase dataBase, CurrentSlot currentSlot) {
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        file.add(new PrintMenuItem(gui, statusArea));
        file.add(new SaveMenuItem(gui, statusArea,dataBase));
        file.add(new OpenMenuItem(gui, statusArea,dataBase));
        file.add(new NewMenuItem(gui));
        file.add(new CloseMenuItem(gui, guiList));
        edit.add(new ClearMenuItem(dataBase, currentSlot, statusArea));
        edit.add(new ClearAllMenuItem(dataBase));
        add(file);
        add(edit);
        add(new WindowMenu(guiList));
    }
}