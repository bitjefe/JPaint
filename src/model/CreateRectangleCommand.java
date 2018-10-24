package model;
import model.interfaces.IShapeCommand;

import java.awt.*;

public class CreateRectangleCommand extends ShapeList implements IShapeCommand {

    private static int x, y, width, height;
    private Point startPoint;
    private Point endPoint;


    public CreateRectangleCommand(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public void run() {
        // add builder pattern here??
        x = startPoint.x;
        y = endPoint.y;
        width = startPoint.x - endPoint.x;
        height = startPoint.y - endPoint.y;
        Rectangle rectangle = new Rectangle(x,y,width,height);
        ShapeList.add(rectangle);
    }

}


