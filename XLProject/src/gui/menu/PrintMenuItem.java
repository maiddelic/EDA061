package gui.menu;

import gui.Gui;
import gui.StatusArea;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JMenuItem;

import model.XLException;



class PrintMenuItem extends JMenuItem implements ActionListener {
    private Gui gui;
    private StatusArea statusArea;

    public PrintMenuItem(Gui gui, StatusArea statusArea) {
        super("Print");
        this.gui = gui;
        this.statusArea = statusArea;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable(gui);
        //printJob.pageDialog(printJob.defaultPage());
        boolean doPrint = printerJob.printDialog();
        if (doPrint) {
            try {
                printerJob.print();
            } catch (PrinterException e) {
                statusArea.setText(e.getMessage());
            }
        }
    }

    
    	
    	
    }
//        Toolkit toolkit = gui.getToolkit();
//        PrintJob printJob = toolkit.getPrintJob(gui, "Frame", null);
//        if (printJob == null) {
//            throw new XLException("PrintJob failed");
//        }
//        Graphics graphics = printJob.getGraphics();
//        Dimension size = gui.getSize();
//        Dimension pageSize = printJob.getPageDimension();
//        graphics.translate((pageSize.width - size.width) / 2,
//                (pageSize.height - size.height) / 2);
//        graphics.drawRect(-1, -1, size.width + 1, size.height + 1);
//        gui.printAll(graphics);
//        graphics.dispose();
//        printJob.end();
//    }
