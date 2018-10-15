package controller;

import view.gui.PaintCanvas;


import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MouseAdapter extends JPanel implements MouseListener {

    private PaintCanvas paintCanvas;
    static final String NEWLINE = System.getProperty("line.separator");

    public MouseAdapter(){
        paintCanvas = new PaintCanvas();
        paintCanvas.addMouseListener(this);
    }


    public void mousePressed(MouseEvent e) {
        eventOutput("Mouse pressed (# of clicks: " + e.getClickCount() + ") ", e);
    }

    public void mouseReleased(MouseEvent e) {
        eventOutput("Mouse released (# of clicks: " + e.getClickCount() + ") ", e);
    }

    public void mouseEntered(MouseEvent e) {
        eventOutput("Mouse entered", e);
    }

    public void mouseExited(MouseEvent e) {
        eventOutput("Mouse exited", e);
    }

    public void mouseClicked(MouseEvent e) {
        eventOutput("Mouse clicked (# of clicks: " + e.getClickCount() + ")", e);
    }

    private void eventOutput(String eventDescription, MouseEvent e){
        System.out.println(eventDescription + " detected on "
                + e.getComponent().getClass().getName()
                + ".");
    }

}
