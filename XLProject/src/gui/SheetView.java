package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import xl.Adjustment;
import xl.NumberAdjustment;

import model.DataBase;


public class SheetView extends JPanel implements Observer {
	private SlotView slotView[][];
	private int rows, cols;
	private CurrentSlot currentSlot;

	public SheetView(int rows, int cols, CurrentSlot currentSlot) {
		this.rows = rows;
		this.cols = cols;
		this.currentSlot = currentSlot;
		slotView = new SlotView[rows][cols];
		setLayout(new GridLayout(rows + 1, cols, 2, 2));
		for (int j = 0; j < cols; j++) {
			JLabel lbl = new JLabel(String.valueOf((char) (j + 'A')),
					SwingConstants.CENTER);
			lbl.setBackground(Color.LIGHT_GRAY);
			lbl.setOpaque(true);
			add(lbl);
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				SlotView slotViewIj = new SlotView(this);
				add(slotViewIj);
				slotView[i][j] = slotViewIj;
			}
		}
		slotView[0][0].setBackground(Color.yellow);
		setBackground(Color.black);
	}

	public void update(Observable db, Object arg1) {
		DataBase dataBase = (DataBase) db;
		for (int j = 0; j < cols; j++) {
			for (int i = 0; i < rows; i++) {
				String text = dataBase.toString(i, j);
				slotView[i][j].setText(text);
			}
		}
	}

	public void updateCurrent(SlotView slot) {
		for (int j = 0; j < cols; j++) {
			for (int i = 0; i < rows; i++) {
				if (slotView[i][j].equals(slot)) {
					slotView[currentSlot.getRow()][currentSlot.getCol()]
							.setBackground(Color.white);
					currentSlot.set(i, j);
					return;
				}
			}
		}

	}

	public CurrentSlot getCurrent() {
		return currentSlot;
	}
}
