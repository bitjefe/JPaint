package model;

import model.interfaces.IShapeCommand;
import model.interfaces.IUndoable;

import java.util.ArrayList;
import java.awt.Point;
import java.util.List;

public class MoveShapeCommand implements IShapeCommand, IUndoable {

    public Point newStartPoint;
    public Point newEndPoint;
    public ShapeFactory shapeFactory;


    public MoveShapeCommand(ShapeFactory shapeFactory, Point newStartPoint, Point newEndPoint){
        this.shapeFactory = shapeFactory;
        this.newStartPoint = newStartPoint;
        this.newEndPoint = newEndPoint;
    }

    @Override
    public void run() {
        move();

        // how to get this redraw the shapes?
    }

    private void move() {
        for(Shape shape: shapeFactory.selectedShapeList) {
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
