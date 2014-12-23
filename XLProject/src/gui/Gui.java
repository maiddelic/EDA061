package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;
import gui.menu.ExitListener;
import gui.menu.XLMenuBar;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import javax.swing.JFrame;

import model.DataBase;

public class Gui extends JFrame implements Printable {
	private static final int ROWS = 10, COLUMNS = 8;
	private GuiList guiList;
	private StatusArea statusArea = new StatusArea();
	private int count;
	private DataBase dataBase;

	private Gui(GuiList guiList, int count) {
		super("Untitled-" + count);
		this.guiList = guiList;
		this.count = count;
		// model
		dataBase = new DataBase();
		CurrentSlot currentSlot = new CurrentSlot();

		setLocation(count * 20, count * 20);
		guiList.add(this);
		setLayout(new BorderLayout());
		// statusPanel
		BorderPanel statusPanel = new BorderPanel();
		CurrentView currentView = new CurrentView();
		statusPanel.add(WEST, currentView);
		statusPanel.add(CENTER, statusArea);
		// sheetPanel
		BorderPanel sheetPanel = new BorderPanel();
		SheetView sheetView = new SheetView(ROWS, COLUMNS, currentSlot);
		sheetPanel.add(WEST, new RowNumberPanel(ROWS));
		sheetPanel.add(CENTER, sheetView);
		// gui
		Editor editor = new Editor(dataBase, currentSlot, statusArea);
		add(NORTH, statusPanel);
		add(CENTER, editor);
		add(SOUTH, sheetPanel);
		setJMenuBar(new XLMenuBar(this, guiList, statusArea, dataBase, currentSlot));
		addWindowListener(new ExitListener());
		pack();
		setResizable(false);
		setVisible(true);
		dataBase.addObserver(sheetView);
		dataBase.addObserver(editor);
		currentSlot.addObserver(currentView);
		currentSlot.addObserver(editor);
	}
	

	public Gui(Gui oldGui) {
		this(oldGui.guiList, oldGui.count + 1);
	}
	
	public int print(Graphics g, PageFormat pageFormat, int page) {
		if (page > 0)
			return NO_SUCH_PAGE;
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		printAll(g2d);
		return PAGE_EXISTS;
	}

	public void rename(String title) {
		setTitle(title);
		guiList.setChanged();
	}



	public static void main(String[] args) {
		new Gui(new GuiList(), 0);
	}

}