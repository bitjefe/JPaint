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
            shape.startPoint.x = shape.startPoint.x+ 20;
            shape.startPoint.y = shape.startPoint.y+ 20;

            shape.endPoint.x = shape.endPoint.x+ 20;
            shape.endPoint.y = shape.endPoint.y+ 20;

            shapeList.masterShapeList.add(shape);
        }


        System.out.println("ShapeList Copy has this many shapes= " + shapeListCopy.size());
        System.out.println("MasterShapeList has this many shapes= " + shapeList.masterShapeList.size());
       // System.out.println("PasteCommand function works");
    }
}
