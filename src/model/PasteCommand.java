package model;

import controller.IJPaintController;

import java.util.List;


public class PasteCommand implements IJPaintController {

    public ShapeList shapeList;
    public List<Shape> shapeListCopy;

    public PasteCommand(List<Shape> shapeListCopy, ShapeList shapeList){
        this.shapeListCopy = shapeListCopy;
        this.shapeList = shapeList;
    }

    @Override
    public void setup() {
        paste(shapeListCopy);
        shapeList.drawShapeHandler.paintCanvas.repaint();
        shapeList.drawShapeHandler.update(shapeList.masterShapeList);
    }

    public void paste(List<Shape> shapeListCopy){

        for(Shape shape: shapeListCopy){

            shape.startPoint.x = shape.startPoint.x+ 200;
            shape.startPoint.y = shape.startPoint.y+ 200;

            shape.endPoint.x = shape.endPoint.x+ 200;
            shape.endPoint.y = shape.endPoint.y+ 200;

            Shape copiedShape = new Shape(shape.shapeFactory, shape.shapeType, shape.startPoint, shape.endPoint, shape.primaryColor, shape.secondaryColor);

            shapeList.masterShapeList.add(copiedShape);
        }


        System.out.println("ShapeList Copy has this many shapes= " + shapeListCopy.size());
        System.out.println("MasterShapeList has this many shapes= " + shapeList.masterShapeList.size());
       // System.out.println("PasteCommand function works");
    }
}
