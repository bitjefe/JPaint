package model;

import controller.IJPaintController;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeCommand;
import model.interfaces.IUndoable;

public class DeleteCommand implements IShapeCommand, IUndoable {

    private final int masterShapeListSize;
    public IApplicationState appState;
    public ShapeList shapeList;


    public DeleteCommand(IApplicationState appState, ShapeList shapeList) {
        this.appState = appState;
        this.shapeList = shapeList;
        this.masterShapeListSize = shapeList.masterShapeList.size();
    }

    //doesn't update the canvas until you click on canvas again, but it does remove the shapes from shapeList
    @Override
    public void run() {
        delete();
        shapeList.drawShapeHandler.paintCanvas.repaint();
        shapeList.drawShapeHandler.update(shapeList.masterShapeList);
        CommandHistory.add(this);
    }

    public void delete(){
        if(masterShapeListSize==0){
            System.out.println("No shapes to delete!");
        } else {
            shapeList.masterShapeList.remove(masterShapeListSize-1);
        }

    }

    @Override
    public void undo() {
        CommandHistory.undo();
        shapeList.masterShapeList.add(shapeList.masterShapeList.get(masterShapeListSize-1));

    }


    @Override
    public void redo() {
        run();
    }
}


