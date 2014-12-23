package gui.menu;

import gui.Gui;
import gui.StatusArea;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

public abstract class FileMenuItem extends JMenuItem implements ActionListener {
    private static final String EXTENSION = ".xl";
    protected Gui gui;
    protected int action;
    private String title;
    protected StatusArea statusArea;

    protected FileMenuItem(Gui gui, StatusArea statusArea, String title) {
        super(title);
        this.gui = gui;
        this.statusArea = statusArea;
        this.title = title;
        addActionListener(this);
    }

    public abstract void action(String fullName);

    public void actionPerformed(ActionEvent event) {
        FileDialog dialog = new FileDialog(gui, title, action);
        dialog.setVisible(true);
        String file = dialog.getFile();
        String dir = dialog.getDirectory();
        dialog.dispose();
        if (file == null) {
            return;
        }
        if (!file.endsWith(EXTENSION)) {
            file += EXTENSION;
        }
        statusArea.setText("");
        action(dir + file);
        String name = file.substring(0, file.indexOf('.'));
        gui.rename(name);
    }
}