package model;

import controller.IJPaintController;
import java.util.List;

public class CopyCommand implements IJPaintController{

    public ShapeList shapeList;
    public List<Shape> selectedShapeList;
    public List<Shape> shapeListCopy;
    int counter;

    //where do i call this? is this correct setup?
    public CopyCommand(List<Shape> selectedShapeList, List<Shape> shapeListCopy, ShapeList shapeList){
        this.selectedShapeList = selectedShapeList;
        this.shapeListCopy = shapeListCopy;
        this.shapeList = shapeList;
    }

    @Override
    public void setup() {
        if(selectedShapeList!= null) {
            copy(shapeList.masterShapeList);
        }
    }

    public void copy(List<Shape> masterShapeList /*List<Shape> selectedShapeList*/){
        counter =1;
        for(Shape shape: shapeList.masterShapeList){
            shapeListCopy.add(shape);
        }
        System.out.println("CopyCommand function works");
    }

}
