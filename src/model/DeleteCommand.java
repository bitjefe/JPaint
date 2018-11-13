package model;

import controller.IJPaintController;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeCommand;
import model.interfaces.IUndoable;

public class DeleteCommand implements IShapeCommand, IUndoable {

    public IApplicationState appState;
    public ShapeList shapeList;

    public DeleteCommand(IApplicationState appState, ShapeList shapeList) {
        this.appState = appState;
        this.shapeList = shapeList;
    }

    //doesn't update the canvas until you click on canvas again, but it does remove the shapes from shapeList

    @Override
    public void run() {
        System.out.println("delete button has been clicked!");
        delete();
        shapeList.drawShapeHandler.paintCanvas.repaint();
        shapeList.drawShapeHandler.update(shapeList.masterShapeList);
    }

    public void delete(){
        int masterShapeListSize = shapeList.masterShapeList.size();
        shapeList.masterShapeList.remove(masterShapeListSize-1);        //add any functionality to delete shapes from selectedShapeList?
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }
}


