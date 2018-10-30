package model;

import java.awt.Point;

public class Shape {
    public Point startPoint;
    public Point endPoint;
    public int height;
    public int width;

    public Shape(Point startPoint, Point endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        width = Math.abs(endPoint.x - startPoint.x);
        height = Math.abs(startPoint.y-endPoint.y);
    }

    public Point getStartPoint(){
        return startPoint;
    }

    public Point getEndPoint(){
        return endPoint;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }
}
