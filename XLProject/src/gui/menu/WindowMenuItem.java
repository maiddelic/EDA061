package gui.menu;

import gui.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

class WindowMenuItem extends JMenuItem implements ActionListener {
    private Gui gui;

    public WindowMenuItem(Gui gui) {
        super(gui.getTitle());
        this.gui = gui;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        gui.toFront();
    }
}