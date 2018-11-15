package main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.UseMouseHandler;
import model.Shape;
import model.ShapeFactory;
import model.DrawShapeHandler;
import model.interfaces.IShapeStrategy;
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

        // turn this into a singleton / shapeList factory design pattern
        List<Shape> selectedShapeList = new ArrayList<>();
        List<Shape> copiedShapeList = new ArrayList<>();
        List<Shape> masterShapeList = new ArrayList<>();
        List<Shape> commandHistoryUndo = new ArrayList<>();
        List<Shape> commandHistoryRedo = new ArrayList<>(); ;

        //instantiate strategy object
        IShapeStrategy shapeStrategy=null;

        ShapeList shapeList = new ShapeList(new DrawShapeHandler(paintCanvas, shapeStrategy), masterShapeList, commandHistoryUndo, commandHistoryRedo);

        // shapeList.drawShapeHandler.paintCanvas?
        IJPaintController controller = new JPaintController(uiModule, appState, shapeList, selectedShapeList, copiedShapeList,commandHistoryUndo,commandHistoryRedo, paintCanvas);

        //create concrete implementation of factory interface, pass in appState and ShapeList
        ShapeFactory shapeFactory = new ShapeFactory(appState, shapeList, selectedShapeList, copiedShapeList);

        // create new instance of UseMouseHandler class and pass in shapeFactory
        UseMouseHandler useMouseHandler = new UseMouseHandler(shapeFactory);

        // add the UseMouseHandler class object to the Paint Canvas via addMouseListener()
        paintCanvas.addMouseListener(useMouseHandler);

        controller.setup();

    }
}
