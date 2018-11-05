package model;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeCommand;

import java.awt.*;

public class CreateShapeCommand implements IShapeCommand {

    public IApplicationState appState;
    public Point startPoint;
    public Point endPoint;
    public ShapeType shapeType;
    public ShapeList shapeList;
    public Shape shape;

    public CreateShapeCommand(IApplicationState appState, ShapeList shapeList, ShapeType shapeType, Point startPoint, Point endPoint) {
        this.appState = appState;
        this.shapeType = shapeType;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.shapeList = shapeList;
    }

    public void run() {
        Shape shape = new Shape(appState, shapeType, startPoint, endPoint);
        shapeList.add(shape);
    }

    public void undo(){
        shapeList.remove(shape);
        //call UndoCommand here?
    }

    public void redo(){

    }
}


