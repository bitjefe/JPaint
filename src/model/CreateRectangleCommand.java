package model;
import model.interfaces.IShapeCommand;

import java.awt.*;

public class CreateRectangleCommand implements IShapeCommand {

    public Point startPoint;
    public Point endPoint;
    public ShapeType shapeType;
    public ShapeList shapeList;


    public CreateRectangleCommand(ShapeList shapeList, ShapeType shapeType, Point startPoint, Point endPoint) {
        this.shapeType = shapeType;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeList = shapeList;
    }

    public void run() {
        // add builder pattern here??
        /*
        x = startPoint.x;
        y = endPoint.y;
        Rectangle rectangle = new Rectangle(x,y,width,height);
        width = endPoint.x-startPoint.x;
        height = endPoint.y-startPoint.y;
         */

        System.out.println(startPoint.toString());
        System.out.println(endPoint.toString());
        System.out.println(shapeType.toString());

        Shape rectangle = new Shape(startPoint, endPoint);
        shapeList.add(rectangle);
    }

}


