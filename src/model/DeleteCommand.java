package model;

import controller.IJPaintController;
import model.interfaces.IApplicationState;

import java.util.ArrayList;

public class DeleteCommand implements IJPaintController {


    public IApplicationState appState;
    public ShapeList shapeList;

    public DeleteCommand(IApplicationState appState, ShapeList shapeList) {
        this.appState = appState;
        this.shapeList = shapeList;
    }

    @Override
    public void setup() {

    }


}


