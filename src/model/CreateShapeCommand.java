package model;
import model.interfaces.IShapeCommand;
import model.persistence.ApplicationState;

import java.awt.*;

public class CreateShapeCommand implements IShapeCommand {

    public Point startPoint;
    public Point endPoint;
    public ShapeType shapeType;
    public ShapeList shapeList;

    //public Shape shape;


    public CreateShapeCommand(ShapeList shapeList, ShapeType shapeType, Point startPoint, Point endPoint) {
        this.shapeType = shapeType;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeList = shapeList;
    }

    public void run() {
        Shape shape = new Shape(shapeType, startPoint, endPoint);
        shapeList.add(shape);
    }

   /* public void undo(){
        shapeList.remove(shape);
    }
    */
}


