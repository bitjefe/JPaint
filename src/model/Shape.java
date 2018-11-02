package model;

import java.awt.Point;

public class Shape {
    public ShapeType shapeType;
    public Point startPoint;
    public Point endPoint;
    public int height, width;
    public int xMin, xMax, yMin, yMax, triangleMidPoint;

    public Shape(ShapeType shapeType, Point startPoint, Point endPoint){
        this.shapeType = shapeType;
        this.startPoint = startPoint;
        this.endPoint = endPoint;

        xMin = Math.min(startPoint.x, endPoint.x);
        xMax = Math.max(startPoint.x, endPoint.x);

        yMin = Math.min(startPoint.y, endPoint.y);
        yMax = Math.max(startPoint.y, endPoint.y);

        width = xMax-xMin;
        height = yMax-yMin;
        triangleMidPoint = (xMin)+((xMax-xMin)/2);
    }

    public ShapeType getShapeType() {return shapeType;}

    public Point getStartPoint(){ return startPoint; }

    public Point getEndPoint(){ return endPoint; }

    public int getXMax(){ return xMax;}

    public int getXMin(){return xMin;}

    public int getYMax(){ return yMax;}

    public int getYMin(){return yMin;}

    public int getHeight(){ return height; }

    public int getWidth(){ return width; }

    public int getTriangleMidPoint(){ return triangleMidPoint;}
}
