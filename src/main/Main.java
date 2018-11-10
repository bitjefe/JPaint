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

        List<Shape> selectedShapeList = new ArrayList<>();
        List<Shape> copiedShapeList = new ArrayList<>();
        List<Shape> masterShapeList = new ArrayList<>();

        ShapeList shapeList = new ShapeList(new DrawShapeHandler(paintCanvas), masterShapeList);

        //do i need to instantiation a command history list here as well? Pass into JPaintController and ShapeFactory like the other 3 lists


        // can probably refactor this to take in shapeList instead of masterShapeList, then use shapeList.masterShapeList, can then remove paintcanvas and use
        // shapeList.drawShapeHandler.paintCanvas?
        IJPaintController controller = new JPaintController(uiModule, appState, shapeList, selectedShapeList, copiedShapeList, paintCanvas);

        //create concrete implementation of factory interface, pass in appState and ShapeList
        ShapeFactory shapeFactory = new ShapeFactory(appState, shapeList, selectedShapeList, copiedShapeList);

        // create new instance of UseMouseHandler class and pass in shapeFactory
        UseMouseHandler useMouseHandler = new UseMouseHandler(shapeFactory);

        // add the UseMouseHandler class object to the Paint Canvas via addMouseListener()
        paintCanvas.addMouseListener(useMouseHandler);

        controller.setup();

    }
}
