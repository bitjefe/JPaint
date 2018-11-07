package model;

import controller.IJPaintController;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeCommand;


public class UndoCommand implements IJPaintController {

    public UndoCommand(){
    }

    @Override
    public void setup() {
        //shapeList.remove(Shape);  // what is this supposed to do?
    }

}
