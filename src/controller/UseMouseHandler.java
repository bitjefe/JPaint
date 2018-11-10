package controller;

import model.*;
import model.Shape;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeCommand;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class UseMouseHandler extends MouseAdapter {

    public ShapeFactory shapeFactory;
    public ShapeType shapeType;
    public Point startPoint;
    public Point endPoint;
    public Point newStartPoint;
    public Point newEndPoint;

   /* public UseMouseHandler(IApplicationState applicationState, ShapeList shapeList) {
        this.appState = applicationState;
        this.shapeList = shapeList;
    }
    */

    public UseMouseHandler(ShapeFactory shapeFactory) {
        this.shapeFactory = shapeFactory;
    }

    public void mousePressed(MouseEvent e) {
        startPoint = new Point(e.getX(), e.getY());
    }

    public void mouseReleased(MouseEvent e) {

        shapeType = shapeFactory.appState.getActiveShapeType();
        endPoint = new Point(e.getX(), e.getY());

        IShapeCommand shapeCommand = null;

        if(shapeFactory.appState.getActiveStartAndEndPointMode()== StartAndEndPointMode.DRAW) {
            shapeCommand = new CreateShapeCommand(shapeFactory, shapeType, startPoint, endPoint);
        }
        else if(shapeFactory.appState.getActiveStartAndEndPointMode()==StartAndEndPointMode.SELECT) {
            shapeCommand = new SelectShapeCommand(shapeFactory, startPoint, endPoint);
        }
        else if(shapeFactory.appState.getActiveStartAndEndPointMode()==StartAndEndPointMode.MOVE){
             newStartPoint = endPoint;
             newEndPoint = new Point(e.getX(), e.getY());
             shapeCommand = new MoveShapeCommand(shapeFactory, newStartPoint, newEndPoint);
        }
        shapeCommand.run();
    }

    public void mouseEntered(MouseEvent e) {
        eventOutput("Mouse entered", e);
    }

    public void mouseExited(MouseEvent e) {
        eventOutput("Mouse exited", e);
    }

    public void mouseClicked(MouseEvent e) { }

    public void mouseDragged(MouseEvent e){ }

    private void eventOutput(String eventDescription, MouseEvent e) {
        System.out.println(eventDescription + " detected on "
                + e.getComponent().getClass().getName()
                + ".");
    }
}
