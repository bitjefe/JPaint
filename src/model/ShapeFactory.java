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
}













