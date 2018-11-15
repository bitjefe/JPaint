package model;

import model.interfaces.IShapeCommand;
import model.interfaces.IUndoable;

import java.awt.*;

public class CreateShapeCommand implements IShapeCommand, IUndoable {

    public ShapeFactory shapeFactory;
    public ShapeType shapeType;
    public Point startPoint;
    public Point endPoint;
    public Shape shape;
    public String clickType;

    public CreateShapeCommand(ShapeFactory shapeFactory, ShapeType shapeType, Point startPoint, Point endPoint, String clickType) {
        this.shapeFactory = shapeFactory;
        this.shapeType = shapeType;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.clickType = clickType;
    }

    @Override
    public void run() {
        Shape shape = new Shape(shapeType, startPoint, endPoint, shapeFactory.appState.getActivePrimaryColor(),
                shapeFactory.appState.getActiveSecondaryColor(), shapeFactory.appState.getActiveShapeShadingType(), clickType);

        shapeFactory.shapeList.masterShapeList.add(shape);
        shapeFactory.shapeList.drawShapeHandler.update(shapeFactory.shapeList.masterShapeList);
        CommandHistory.add(this);
    }

    @Override
    public void undo(){
        CommandHistory.undo();
    }

    @Override
    public void redo(){
        run();
    }
}




