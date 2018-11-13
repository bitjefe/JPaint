package model;

import controller.IJPaintController;
import model.interfaces.IShapeCommand;
import model.interfaces.IUndoable;

import java.util.List;


public class PasteCommand implements IShapeCommand, IUndoable {

    public ShapeList shapeList;
    public List<Shape> shapeListCopy;

    public PasteCommand(List<Shape> shapeListCopy, ShapeList shapeList){
        this.shapeListCopy = shapeListCopy;
        this.shapeList = shapeList;
    }

    @Override
    public void run() {
        paste(shapeListCopy);
        shapeList.drawShapeHandler.paintCanvas.repaint();
        shapeList.drawShapeHandler.update(shapeList.masterShapeList);
        CommandHistory.add(this);
    }

    public void paste(List<Shape> shapeListCopy){

        for(Shape shape: shapeListCopy){

            shape.startPoint.x = shape.startPoint.x+ 200;
            shape.startPoint.y = shape.startPoint.y+ 200;

            shape.endPoint.x = shape.endPoint.x+ 200;
            shape.endPoint.y = shape.endPoint.y+ 200;

            Shape copiedShape = new Shape(shape.shapeType, shape.startPoint, shape.endPoint, shape.primaryColor, shape.secondaryColor, shape.shadingType);

            shapeList.masterShapeList.add(copiedShape);
        }


        System.out.println("ShapeList Copy has this many shapes= " + shapeListCopy.size());
        System.out.println("MasterShapeList has this many shapes= " + shapeList.masterShapeList.size());
       // System.out.println("PasteCommand function works");
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}
