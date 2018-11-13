package model;

import controller.IJPaintController;
import model.interfaces.IShapeCommand;
import model.interfaces.IUndoable;

import java.util.List;

public class CopyCommand implements IShapeCommand {

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
    public void run() {
        if(selectedShapeList!= null) {
            copy(selectedShapeList);
        }
    }

    public void copy(List<Shape> selectedShapeList){
        counter =1;
        for(Shape shape: selectedShapeList){
            shapeListCopy.add(shape);
        }
        System.out.println("CopyCommand function works");
    }

}
