package model;

import model.interfaces.IApplicationState;

import java.awt.*;
import java.util.List;

public class ShapeFactory {

    public IApplicationState appState;
    public ShapeList shapeList;
    public List<Shape> selectedShapeList;
    public List<Shape> copiedShapeList;
    public Shape shape;


    public ShapeFactory(IApplicationState appState, ShapeList shapeList, List<Shape> selectedShapeList, List<Shape> copiedShapeList) {
        this.appState = appState;
        this.shapeList = shapeList;
        this.selectedShapeList = selectedShapeList;
        this.copiedShapeList = copiedShapeList;
    }

    public void createRectangle() {
        if (appState.getActiveShapeType().toString().equals("RECTANGLE")) {
            System.out.println("You're trying to draw a rectangle!");
            if(appState.getActiveShapeShadingType().equals("FILLED_IN")){
                shapeList.masterShapeList.add(shape);
            }
            else if(appState.getActiveShapeShadingType().equals("OUTLINE")){
                shapeList.masterShapeList.add(shape);
            }

            else if(appState.getActiveShapeShadingType().equals("OUTLINE_AND_FILLED_IN")){
                shapeList.masterShapeList.add(shape);
            }
        }
    }

    public void createEllipse() {
        if (appState.getActiveShapeType().toString().equals("ELLIPSE")) {
            System.out.println("You're trying to draw a Ellipse!");
            if(appState.getActiveShapeShadingType().equals("FILLED_IN")){
                shapeList.masterShapeList.add(shape);
            }
            else if(appState.getActiveShapeShadingType().equals("OUTLINE")){
                shapeList.masterShapeList.add(shape);
            }
            else if(appState.getActiveShapeShadingType().equals("OUTLINE_AND_FILLED_IN")){
                shapeList.masterShapeList.add(shape);
            }
        }
    }

    public void createTriangle() {
        if (appState.getActiveShapeType().toString().equals("TRIANGLE")) {
            System.out.println("You're trying to draw a Triangle!");
            if(appState.getActiveShapeShadingType().equals("FILLED_IN")){
                shapeList.masterShapeList.add(shape);
            }
            else if(appState.getActiveShapeShadingType().equals("OUTLINE")){
                shapeList.masterShapeList.add(shape);
            }
            else if(appState.getActiveShapeShadingType().equals("OUTLINE_AND_FILLED_IN")){
                shapeList.masterShapeList.add(shape);
            }
        }
    }
}











