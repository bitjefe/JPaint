package model;

import model.interfaces.IApplicationState;

import java.awt.Point;
import java.awt.Color;

public class Shape {
    public IApplicationState appState;
    public ShapeType shapeType;
    public Point startPoint;
    public Point endPoint;
    public int height, width;
    public int xMin, xMax, yMin, yMax, triangleMidPoint;

    public Shape(IApplicationState appState, ShapeType shapeType, Point startPoint, Point endPoint){
        this.appState = appState;
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

    public int getXMax(){ return xMax;}

    public int getXMin(){return xMin;}

    public int getYMax(){ return yMax;}

    public int getYMin(){return yMin;}

    public int getHeight(){ return height; }

    public int getWidth(){ return width; }

    public int getTriangleMidPoint(){ return triangleMidPoint;}

    public ShapeColor getPrimaryColor(){return appState.getActivePrimaryColor();}

    public ShapeColor getSecondaryColor(){return appState.getActiveSecondaryColor();}

    public ShapeShadingType getShadingType(){return appState.getActiveShapeShadingType();}

    public StartAndEndPointMode getStartAndEndPointMode(){return appState.getActiveStartAndEndPointMode();}

}
