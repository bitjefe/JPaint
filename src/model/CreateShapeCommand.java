package model;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeCommand;

import java.awt.*;

public class CreateShapeCommand implements IShapeCommand {

    public ShapeFactory shapeFactory;
    public ShapeType shapeType;
    public Point startPoint;
    public Point endPoint;
    public Shape shape;

    public CreateShapeCommand(ShapeFactory shapeFactory, ShapeType shapeType, Point startPoint, Point endPoint) {
        this.shapeFactory = shapeFactory;
        this.shapeType = shapeType;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public void run() {
        Shape shape = new Shape(shapeFactory, shapeType, startPoint, endPoint, shapeFactory.appState.getActivePrimaryColor(), shapeFactory.appState.getActiveSecondaryColor());
        shapeFactory.shapeList.masterShapeList.add(shape);
        shapeFactory.shapeList.drawShapeHandler.update(shapeFactory.shapeList.masterShapeList);
    }

    public void undo(){
        //shapeFactory.masterShapeList.remove();
        //call UndoCommand here?
    }

    public void redo(){

    }
}




