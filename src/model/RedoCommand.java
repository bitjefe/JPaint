package model;

import controller.IJPaintController;
import model.interfaces.IShapeCommand;
import model.interfaces.IUndoable;


public class RedoCommand implements IShapeCommand, IUndoable {

    public ShapeList shapeList;

    public RedoCommand(ShapeList shapeList){
        this.shapeList = shapeList;
    }

    @Override
    public void run() {
        redo();
        System.out.println("Redo Command has been run");
        shapeList.drawShapeHandler.paintCanvas.repaint();
        shapeList.drawShapeHandler.update(shapeList.masterShapeList);
        CommandHistory.add(this);
    }

    @Override
    public void undo() { CommandHistory.undo();}

    @Override
    public void redo() {
        CommandHistory.redo();
    }
}
