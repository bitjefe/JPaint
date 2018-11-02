package controller;

import model.CreateShapeCommand;
import model.ShapeList;
import model.interfaces.IApplicationState;
import model.ShapeType;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.EventName;

public class UseMouseHandler extends MouseAdapter {

    public IApplicationState applicationState;
    public ShapeType shapeType;
    public Point startPoint;
    public Point endPoint;
    public ShapeList shapeList;


    public UseMouseHandler(IApplicationState applicationState, ShapeList shapeList) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
    }

    public void mousePressed(MouseEvent e) { startPoint = new Point(e.getX(), e.getY()); }

    public void mouseReleased(MouseEvent e) {
        shapeType = applicationState.getActiveShapeType();

        Point endPoint = new Point(e.getX(), e.getY());
        this.endPoint = endPoint;

        CreateShapeCommand createShapeCommand = new CreateShapeCommand(shapeList, shapeType, startPoint, endPoint);
        createShapeCommand.run();
    }

    public void mouseEntered(MouseEvent e) {
        eventOutput("Mouse entered", e);
    }

    public void mouseExited(MouseEvent e) {
        eventOutput("Mouse exited", e);
    }

    public void mouseClicked(MouseEvent e) {
        // eventOutput("Mouse clicked (# of clicks: " + e.getClickCount() + ")", e);

    }

    private void eventOutput(String eventDescription, MouseEvent e) {
        System.out.println(eventDescription + " detected on "
                + e.getComponent().getClass().getName()
                + ".");
    }
}
