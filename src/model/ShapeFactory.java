package model;

import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import java.util.List;

public class ShapeFactory implements IShape {

    public IApplicationState appState;
    public ShapeList shapeList;
    public List<Shape> selectedShapeList;

    public Shape makeShape(IApplicationState appState, ShapeList shapeList, List<Shape> selectedShapeList) {

        this.appState = appState;
        this.shapeList = shapeList;
        this.selectedShapeList = selectedShapeList;

        if (appState.getActiveShapeType() == null) {
            return null;
        }

        //create rectangles, ellipses, and triangles in here (determine filled in/ outline, both, etc)

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

    public IApplicationState getAppState(){return appState;}

    public ShapeList getShapeList(){return shapeList;}

}
