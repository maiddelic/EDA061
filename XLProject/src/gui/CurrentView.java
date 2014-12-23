package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;

public class CurrentView extends JLabel implements Observer {
    
	public CurrentView() {
        super("A1");
        setBackground(Color.WHITE);
        setOpaque(true);
    }

	public void update(Observable slot, Object arg1) {
		CurrentSlot current = (CurrentSlot)slot;
		char col = (char) (current.getCol()+ 'A');
		int row = current.getRow() +1;
		setText(col + "" + row);
	}
}