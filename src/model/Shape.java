package model;

import model.interfaces.IApplicationState;

import java.awt.Point;

public class Shape {
    public ShapeFactory shapeFactory;
    public ShapeList shapeList;
    public IApplicationState appState;
    public ShapeType shapeType;
    public Point startPoint;
    public Point endPoint;
    public int height, width;
    public int xMin, xMax, yMin, yMax, triangleMidPoint;
    public ShapeColor primaryColor;
    public ShapeColor secondaryColor;


    public Shape(ShapeFactory shapeFactory, ShapeType shapeType, Point startPoint, Point endPoint, ShapeColor primaryColor, ShapeColor secondaryColor) {
        this.shapeFactory = shapeFactory;
        this.shapeType = shapeType;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;

        xMin = Math.min(startPoint.x, endPoint.x);
        xMax = Math.max(startPoint.x, endPoint.x);

        yMin = Math.min(startPoint.y, endPoint.y);
        yMax = Math.max(startPoint.y, endPoint.y);

        width = xMax-xMin;
        height = yMax-yMin;
        triangleMidPoint = (xMin)+((xMax-xMin)/2);
    }

    public ShapeType getShapeType(){ return shapeType;}

    public int getXMax(){ return xMax;}

    public int getXMin(){return xMin;}

    public int getYMax(){ return yMax;}

    public int getYMin(){return yMin;}

    public int getHeight(){ return height; }

    public int getWidth(){ return width; }

    public int getTriangleMidPoint(){ return triangleMidPoint;}

    public ShapeColor getPrimaryColor(){return shapeFactory.appState.getActivePrimaryColor();}

    public ShapeColor getSecondaryColor(){return shapeFactory.appState.getActiveSecondaryColor();}

    public ShapeShadingType getShadingType(){return shapeFactory.appState.getActiveShapeShadingType();}

    public StartAndEndPointMode getStartAndEndPointMode(){return shapeFactory.appState.getActiveStartAndEndPointMode();}

}



    /*
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
    */