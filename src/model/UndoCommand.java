package model;

import model.interfaces.IShapeCommand;
import model.interfaces.IUndoable;

import java.util.ArrayList;
import java.util.List;


public class UndoCommand implements IShapeCommand, IUndoable {

    ShapeList shapeList;
    public List<Shape> commandHistoryUndo;
    public List<Shape> commandHistoryRedo;

    public UndoCommand(ShapeList shapeList, List<Shape> commandHistoryUndo, List<Shape> commandHistoryRedo){
        this.shapeList = shapeList;
        this.commandHistoryUndo = commandHistoryUndo;
        this.commandHistoryRedo = commandHistoryRedo;

    }

    @Override
    public void run() {
        undo();

        if(shapeList.masterShapeList.size()==0 && commandHistoryRedo.size()==0){
            System.out.println("No commands to undo");
        }
        else{
            int shapeRedoIndex = shapeList.masterShapeList.size()-1;
            Shape shapeRedo = shapeList.masterShapeList.get(shapeRedoIndex);

            if(commandHistoryRedo.size()>1){
                commandHistoryRedo.clear();
                commandHistoryRedo.add(shapeRedo);
            } else{
                commandHistoryRedo.add(shapeRedo);
            }

            shapeList.masterShapeList.remove(shapeList.masterShapeList.size()-1);

            shapeList.drawShapeHandler.paintCanvas.repaint();
            shapeList.drawShapeHandler.update(shapeList.masterShapeList);


            CommandHistory.add(this);
        }



    }

    @Override
    public void undo() { CommandHistory.undo(); }

    @Override
    public void redo() { CommandHistory.redo();}

}
