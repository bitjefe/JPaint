package model;
import model.interfaces.IShapeCommand;

import java.awt.*;

public class CreateRectangleCommand implements IShapeCommand {

    public Point startPoint;
    public Point endPoint;
    public ShapeList shapelist;


    public CreateRectangleCommand(ShapeList shapelist, Point startPoint, Point endPoint) {
        this.shapelist = shapelist;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
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

        Shape rectangle = new Shape(startPoint, endPoint);
        shapelist.add(rectangle);
    }

}


