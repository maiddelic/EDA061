package gui.menu;

import gui.Gui;
import gui.GuiList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

class CloseMenuItem extends JMenuItem implements ActionListener {
    private Gui gui;
    private GuiList guiList;

    public CloseMenuItem(Gui gui, GuiList guiList) {
        super("Close");
        this.gui = gui;
        this.guiList = guiList;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        guiList.remove(gui);
        gui.dispose();
        if (guiList.isEmpty()) {
            System.exit(0);
        } else {
            guiList.last().toFront();
        }
    }
}
