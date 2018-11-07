package model;

import model.interfaces.IShapeCommand;

import java.awt.*;

public class SelectShapeCommand implements IShapeCommand {
    public SelectShapeCommand(ShapeFactory shapeFactory, Point startPoint, Point endPoint) {
    }

    @Override
    public void run() {
    }

    @Override
    public void undo() {

    }


    public void redo(){

    }
}
