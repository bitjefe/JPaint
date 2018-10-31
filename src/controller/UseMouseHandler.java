package controller;

import model.CreateRectangleCommand;
import model.ShapeList;
import model.interfaces.IApplicationState;
import model.ShapeType;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

    public void mousePressed(MouseEvent e) {
        startPoint = new Point(e.getX(), e.getY());
    }

    public void mouseReleased(MouseEvent e) {
        shapeType = applicationState.getActiveShapeType();


        Point endPoint = new Point(e.getX(), e.getY());
        this.endPoint = endPoint;


        if (shapeType.toString().equals("RECTANGLE")) {

            CreateRectangleCommand createRectangleCommand = new CreateRectangleCommand(shapeList, shapeType, startPoint, endPoint);
            createRectangleCommand.run();

        } else if (shapeType.toString().equals("ELLIPSE")) {
            System.out.println(startPoint.toString());
            System.out.println(endPoint.toString());
            System.out.println(shapeType.toString());
            //CreateEllipseCommand ellipseCommand = new CreateEllipseCommand(startPoint, endPoint);

        } else if (shapeType.toString().equals("TRIANGLE")){
            System.out.println(startPoint.toString());
            System.out.println(endPoint.toString());
            System.out.println(shapeType.toString());
            //CreateTriangleCommand triangleCommand = new CreateTriangleCommand(startPoint, endPoint);
        }

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
