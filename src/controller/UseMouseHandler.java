package controller;

import model.CreateShapeCommand;
import model.MoveCommand;
import model.Shape;
import model.ShapeList;
import model.interfaces.IApplicationState;
import model.ShapeType;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class UseMouseHandler extends MouseAdapter {

    public IApplicationState appState;
    public ShapeType shapeType;
    public Point startPoint;
    public Point endPoint;
    public ShapeList shapeList; // should every on of these be :  public List<Shape> shapeList;  ????
    public Shape selectedShape;
    public List<Shape> selectedShapeList = new ArrayList<>();



    public UseMouseHandler(IApplicationState applicationState, ShapeList shapeList) {
        this.appState = applicationState;
        this.shapeList = shapeList;
    }

    public void mousePressed(MouseEvent e) {
        startPoint = new Point(e.getX(), e.getY());
    }

    public void mouseReleased(MouseEvent e) {
        shapeType = appState.getActiveShapeType();

        Point endPoint = new Point(e.getX(), e.getY());
        this.endPoint = endPoint;

        CreateShapeCommand createShapeCommand = new CreateShapeCommand(appState, shapeList, shapeType, startPoint, endPoint);
        createShapeCommand.run();
    }

    public void mouseEntered(MouseEvent e) {
        eventOutput("Mouse entered", e);
    }

    public void mouseExited(MouseEvent e) {
        eventOutput("Mouse exited", e);
    }

    public void mouseClicked(MouseEvent e) {
/*
        int x,y;
        x = e.getX();
        y = e.getY();

        boolean isSelected = false;

        System.out.println(shapeList.size());    //size increments on every mouse click not necessarily on shape add?

        for(int i=0; i<shapeList.size();i++){
            Point selectedPoint = new Point(x,y);
            if(this.shapeList.getShapeIndex(i).contains(selectedPoint) && !isSelected){         //contains throws an error cannot resolve
                isSelected = true;
                selectedShapeList.add(shapeList.getShapeIndex(i));
            }
            else shapeList.getShapeIndex(i).selected = false;           //selected throws error cannot resolve
        }
*/

    }

    public void mouseDragged(MouseEvent e){

        Point newStartPoint = endPoint;
        Point newEndPoint = new Point(e.getX(), e.getY());

        MoveCommand moveCommand = new MoveCommand(shapeList, selectedShapeList, newStartPoint, newEndPoint);
        moveCommand.run();

    }

    private void eventOutput(String eventDescription, MouseEvent e) {
        System.out.println(eventDescription + " detected on "
                + e.getComponent().getClass().getName()
                + ".");
    }
}
