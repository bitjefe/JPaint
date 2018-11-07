package model;

import controller.IJPaintController;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CopyCommand implements IJPaintController{

    public List<Shape> selectedShapeList;
    public List<Shape> shapeListCopy;
    int counter;

    //where do i call this? is this correct setup?
    public CopyCommand(List<Shape> selectedShapeList, List<Shape> shapeListCopy){
        this.selectedShapeList = selectedShapeList;
        this.shapeListCopy = shapeListCopy;
    }

    @Override
    public void setup() {
        if(selectedShapeList!= null) {
            copy(selectedShapeList);
        }
        System.out.println("No shapes selected!");
    }

    public void copy(List<Shape> selectedShapeList){
        counter =1;
        for(Shape shape: selectedShapeList){
            shapeListCopy.add(shape);
        }
        System.out.println("CopyCommand function works");
    }

}
