package model;

import model.interfaces.IShapeCommand;
import model.interfaces.IUndoable;

import java.awt.*;
import java.util.List;

public class SelectShapeCommand implements IShapeCommand, IUndoable {

    public ShapeFactory shapeFactory;
    public Point startPoint;
    public Point endPoint;
    public int x,y;

    public SelectShapeCommand(ShapeFactory shapeFactory, Point startPoint, Point endPoint) {
        this.shapeFactory = shapeFactory;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    @Override
    public void run() {
        selectAndAdd(shapeFactory.shapeList.masterShapeList);
        shapeFactory.shapeList.drawShapeHandler.update(shapeFactory.shapeList.masterShapeList);
    }

    public void selectAndAdd(List<Shape> masterShapeList){
        x = startPoint.x;
        y = endPoint.y;

        for(Shape shape: masterShapeList){
            if(shape.containsPoint(x,y)){
                shapeFactory.selectedShapeList.add(shape);
            }
        }
       // System.out.println("Selected ShapeList has this many shapes= " + shapeFactory.selectedShapeList.size());
    }


    @Override
    public void undo() {

    }


    public void redo(){

    }
}
