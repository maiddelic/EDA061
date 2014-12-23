package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;


public class SlotView extends JLabel implements MouseListener {
	SheetView view;

	public SlotView(SheetView view) {
		super("                    ", RIGHT);
		setBackground(Color.WHITE);
		setOpaque(true);
		addMouseListener(this);
		this.view = view;
	}


	public void mousePressed(MouseEvent e) {
		view.updateCurrent(this);
		setBackground(Color.yellow);
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}