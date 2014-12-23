package gui.menu;

import gui.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

class NewMenuItem extends JMenuItem implements ActionListener {
    private Gui gui;

    public NewMenuItem(Gui gui) {
        super("New");
        this.gui = gui;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        new Gui(gui);
    }
}