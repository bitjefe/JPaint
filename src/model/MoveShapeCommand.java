package model;

import model.interfaces.IShapeCommand;

import java.util.ArrayList;
import java.awt.Point;
import java.util.List;

public class MoveShapeCommand implements IShapeCommand {

    public Point newStartPoint;
    public Point newEndPoint;
    public ShapeList shapeList;
    public List<Shape> selectedShapeList;


    public MoveShapeCommand(ShapeList shapeList, List<Shape> selectedShapeList, Point newStartPoint, Point newEndPoint){
        this.shapeList = shapeList;
        this.selectedShapeList = selectedShapeList;
        this.newStartPoint = newStartPoint;
        this.newEndPoint = newEndPoint;
    }

    @Override
    public void run() {
        move();

        // how to get this redraw the shapes?
    }

    private void move() {
        for(Shape shape: selectedShapeList) {
            int deltaX = (newEndPoint.x - newStartPoint.x);
            int deltaY = (newEndPoint.y - newStartPoint.y);

            int newStartPointX = (shape.startPoint.x)+deltaX;
            int newStartPointY = (shape.startPoint.y)+deltaY;

            int newEndPointX = (shape.endPoint.x)+deltaX;
            int newEndPointY = (shape.endPoint.y)+deltaY;

            shape.startPoint = new Point(newStartPointX, newStartPointY);
            shape.endPoint = new Point(newEndPointX,newEndPointY);
        }
    }

    @Override
    public void undo() {

    }


    public void redo(){

    }
}
