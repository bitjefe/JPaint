package model;

import controller.IJPaintController;
import model.interfaces.IApplicationState;
import java.util.List;

import java.util.ArrayList;

public class DeleteCommand implements IJPaintController {

    public IApplicationState appState;
    public ShapeList shapeList;

    public DeleteCommand(IApplicationState appState, ShapeList shapeList) {
        this.appState = appState;
        this.shapeList = shapeList;
    }

    //doesn't update the canvas until you click on canvas again, but it does remove the shapes from shapeList

    @Override
    public void setup() {
        System.out.println("delete button has been clicked!");
        shapeList.remove();
    }

}


