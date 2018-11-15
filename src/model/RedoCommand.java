package model;

import model.interfaces.IShapeCommand;
import model.interfaces.IUndoable;

import java.util.ArrayList;
import java.util.List;


public class RedoCommand implements IShapeCommand, IUndoable {

    public ShapeList shapeList;
    public List<Shape> commandHistoryUndo;
    public List<Shape> commandHistoryRedo;

    public RedoCommand(ShapeList shapeList, List<Shape> commandHistoryUndo, List<Shape> commandHistoryRedo){
        this.shapeList = shapeList;
        this.commandHistoryUndo = commandHistoryUndo;
        this.commandHistoryRedo = commandHistoryRedo;
    }

    @Override
    public void run() {
        redo();

        if(shapeList.masterShapeList.size()==0 && commandHistoryRedo.size()==0){
            System.out.println("No commands to redo");
        }

        else{
            int shapeUndoIndex = commandHistoryRedo.size()-1;
            Shape shapeUndo = commandHistoryRedo.get(shapeUndoIndex);

            if(commandHistoryUndo.size()>1){
                commandHistoryUndo.clear();
                commandHistoryUndo.add(shapeUndo);
            } else{
                commandHistoryUndo.add(shapeUndo);
            }

            // remove last index from commandHistoryRedo
            shapeList.masterShapeList.add(shapeUndo);

            shapeList.drawShapeHandler.paintCanvas.repaint();
            shapeList.drawShapeHandler.update(shapeList.masterShapeList);

            CommandHistory.add(this);
        }


    }

    @Override
    public void undo() { CommandHistory.undo();}

    @Override
    public void redo() { CommandHistory.redo();}
}
