package model;

import model.interfaces.IApplicationState;
import model.interfaces.IShape;

public class ShapeFactory implements IShape {

    public IApplicationState appState;
    public ShapeList shapeList;

    public Shape makeShape(IApplicationState appState, ShapeList shapeList) {

        this.appState = appState;
        this.shapeList = shapeList;

        if (appState.getActiveShapeType() == null) {
            return null;
        }
        if(appState.getActiveShapeType().toString().equals("RECTANGLE")){
            System.out.println("You've chosen a Rectangle");  // what should this actually do?  return a new RectangleFactory()?
        }
        else if(appState.getActiveShapeType().toString().equals("ELLIPSE")){
            System.out.println("You've chosen an Ellipse");
        }
        else if(appState.getActiveShapeType().toString().equals("TRIANGLE")){
            System.out.println("You've chosen a Triangle");
        }
        return null;
    }


    //getters for appState and shapeList from main

    public IApplicationState getAppState() {return appState;}

    public ShapeList getShapeList() {return shapeList;}

}
