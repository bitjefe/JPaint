package model;

import controller.IJPaintController;

import java.util.List;


public class PasteCommand implements IJPaintController {

    public List<Shape> shapeList;
    public List<Shape> shapeListCopy;

    public PasteCommand(ShapeList shapeListCopy){
        this.shapeListCopy = (List<Shape>) shapeListCopy;
    }

    @Override
    public void setup() {
        paste(shapeListCopy);
    }

    public void paste(List<Shape> shapeListCopy){
        for(Shape shape: shapeListCopy){
            shape.startPoint.x = shape.startPoint.x+ 20;
            shape.startPoint.y = shape.startPoint.y+ 20;

            shape.endPoint.x = shape.endPoint.x+ 20;
            shape.endPoint.y = shape.endPoint.y+ 20;

            shapeList.add(shape);
        }

        System.out.println("CopyCommand function works");
    }
}
