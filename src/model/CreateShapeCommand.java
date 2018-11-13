package model;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeCommand;
import model.interfaces.IUndoable;

import java.awt.*;

public class CreateShapeCommand implements IShapeCommand, IUndoable {

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

    @Override
    public void run() {
        /*
        if (shapeType.toString().equals("RECTANGLE")) {
            if(shapeFactory.appState.getActiveShapeShadingType().equals("FILLED_IN")){

            }
            else if(shapeFactory.appState.getActiveShapeShadingType().equals("OUTLINE")){

            }

            else if(shapeFactory.appState.getActiveShapeShadingType().equals("OUTLINE_AND_FILLED_IN")){

            }
        }
        */

        Shape shape = new Shape(shapeType, startPoint, endPoint, shapeFactory.appState.getActivePrimaryColor(), shapeFactory.appState.getActiveSecondaryColor(), shapeFactory.appState.getActiveShapeShadingType());
        shapeFactory.shapeList.masterShapeList.add(shape);
        shapeFactory.shapeList.drawShapeHandler.update(shapeFactory.shapeList.masterShapeList);
        CommandHistory.add(this);
    }

    @Override
    public void undo(){
        //shapeFactory.masterShapeList.remove();
        //call UndoCommand here?
    }

    @Override
    public void redo(){

    }
}




