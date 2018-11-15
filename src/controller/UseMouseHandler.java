package controller;

import model.*;
import model.interfaces.IShapeCommand;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UseMouseHandler extends MouseAdapter {

    public ShapeFactory shapeFactory;
    public ShapeType shapeType;
    public Point startPoint;
    public Point endPoint;
    public String clickType;


    public UseMouseHandler(ShapeFactory shapeFactory) {
        this.shapeFactory = shapeFactory;
    }

    public void mousePressed(MouseEvent e) {
        startPoint = new Point(e.getX(), e.getY());
    }

    public void mouseReleased(MouseEvent e) {

        shapeType = shapeFactory.appState.getActiveShapeType();
        endPoint = new Point(e.getX(), e.getY());


        if(e.getButton() == MouseEvent.BUTTON1){
            clickType = "LEFT";
        }

        if(e.getButton() == MouseEvent.BUTTON3){
            clickType = "RIGHT";
        }

        IShapeCommand shapeCommand = null;

        if(shapeFactory.appState.getActiveStartAndEndPointMode()== StartAndEndPointMode.DRAW) {
            shapeCommand = new CreateShapeCommand(shapeFactory, shapeType, startPoint, endPoint, clickType);
        }
        else if(shapeFactory.appState.getActiveStartAndEndPointMode()==StartAndEndPointMode.SELECT) {
            shapeCommand = new SelectShapeCommand(shapeFactory, startPoint, endPoint);
        }
        else if(shapeFactory.appState.getActiveStartAndEndPointMode()==StartAndEndPointMode.MOVE){
             shapeCommand = new MoveShapeCommand(shapeFactory, shapeType, startPoint, endPoint);
        }
        shapeCommand.run();
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) { }

    public void mouseDragged(MouseEvent e){ }

    private void eventOutput(String eventDescription, MouseEvent e) {
        System.out.println(eventDescription + " detected on "
                + e.getComponent().getClass().getName()
                + ".");
    }
}
