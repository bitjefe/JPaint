package model;

import controller.IJPaintController;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeCommand;


public class UndoCommand implements IJPaintController {

    public IApplicationState appState;
    public ShapeList shapeList;

    public UndoCommand(IApplicationState appState, ShapeList shapeList){
        this.appState = appState;
        this.shapeList = shapeList;
    }

    @Override
    public void setup() {
        //shapeList.remove(Shape);
    }


}
