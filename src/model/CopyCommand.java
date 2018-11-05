package model;

import controller.IJPaintController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class CopyCommand implements IJPaintController {

    public List<Shape> selectedShapeList;
    public List<Shape> shapeListCopy;
    int counter;

    //where do i call this? is this correct setup?
    public CopyCommand(ShapeList selectedShapeList){
        this.selectedShapeList = (List<Shape>) selectedShapeList;
    }

    @Override
    public void setup() {
        copy(selectedShapeList);  //throws an error due to List<Shape> shapeList vs ShapeList shapeList question
    }

    public void copy(List<Shape> selectedShapeList){
        counter =1;
        for(Shape shape: selectedShapeList){
            shapeListCopy.add(shape);
        }
        System.out.println("CopyCommand function works");
    }
}
