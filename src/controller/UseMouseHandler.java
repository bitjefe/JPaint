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
    public IApplicationState appState;
    public ShapeType shapeType;
    public Point startPoint;
    public Point endPoint;
    public ShapeList shapeList;
    public List<Shape> selectedShapeList;

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
        shapeType = shapeFactory.getAppState().getActiveShapeType();
        System.out.println(shapeType);

        Point endPoint = new Point(e.getX(), e.getY());
        this.endPoint = endPoint;


        IShapeCommand shapeCommand = null;

        if(shapeFactory.getAppState().getActiveStartAndEndPointMode()== StartAndEndPointMode.DRAW) {
            shapeCommand = new CreateShapeCommand(shapeFactory, startPoint, endPoint);
        }
        else if(shapeFactory.getAppState().getActiveStartAndEndPointMode()==StartAndEndPointMode.SELECT) {
            shapeCommand = new SelectShapeCommand(shapeFactory, startPoint, endPoint);
        }
        else if(shapeFactory.getAppState().getActiveStartAndEndPointMode()==StartAndEndPointMode.MOVE){
            System.out.println("Move functionality not implemented yet");   // still an error here, might need to implement MoveCommand from MouseReleased or error handle the shapeCommand.run() below
            Point newStartPoint = endPoint;
            Point newEndPoint = new Point(e.getX(), e.getY());
            //shapeCommand = new MoveShapeCommand(shapeList, selectedShapeList, newStartPoint, newEndPoint);
        }
        shapeCommand.run();
    }

    public void mouseEntered(MouseEvent e) {
        eventOutput("Mouse entered", e);
    }

    public void mouseExited(MouseEvent e) {
        eventOutput("Mouse exited", e);
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e){

    }

    private void eventOutput(String eventDescription, MouseEvent e) {
        System.out.println(eventDescription + " detected on "
                + e.getComponent().getClass().getName()
                + ".");
    }
}
