package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class StatusArea extends JLabel implements Observer {
    public StatusArea() {
        setBackground(Color.WHITE);
        setOpaque(true);
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		setText("");
		
	}
}