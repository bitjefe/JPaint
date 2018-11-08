package main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.UseMouseHandler;
import model.Shape;
import model.ShapeFactory;
import model.DrawShapeHandler;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;
import java.util.List;

import model.ShapeList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        PaintCanvas paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);

        ShapeList shapeList = new ShapeList(new DrawShapeHandler(paintCanvas));
        List<Shape> selectedShapeList = new ArrayList<>();

        IJPaintController controller = new JPaintController(uiModule, appState,shapeList, selectedShapeList);

        //create concrete implementation of factory interface, pass in appState and ShapeList
        ShapeFactory shapeFactory = new ShapeFactory(appState, shapeList, selectedShapeList);
        UseMouseHandler useMouseHandler = new UseMouseHandler(shapeFactory, shapeList);   //when refactored like this it draws all shapes in the shapeList every time for the new shape

        // create new instance of UseMouseHandler class
        //UseMouseHandler useMouseHandler = new UseMouseHandler(appState, shapeList);

        // add the UseMouseHandler class object to the Paint Canvas via addMouseListener()
        paintCanvas.addMouseListener(useMouseHandler);

        controller.setup();

    }
}
