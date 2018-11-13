package model;

import controller.IJPaintController;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeCommand;
import model.interfaces.IUndoable;


public class UndoCommand implements IShapeCommand, IUndoable {

    ShapeList shapeList;

    public UndoCommand(ShapeList shapeList){
        this.shapeList = shapeList;
    }

    @Override
    public void run() {
        undo();
        System.out.println("Undo Command has been run");
        shapeList.drawShapeHandler.paintCanvas.repaint();
        shapeList.drawShapeHandler.update(shapeList.masterShapeList);
        CommandHistory.add(this);
    }

    @Override
    public void undo() { CommandHistory.undo(); }

    @Override
    public void redo() { CommandHistory.redo();}

}
