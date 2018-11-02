package main;

import controller.IJPaintController;
import controller.JPaintController;
import controller.UseMouseHandler;
import model.DrawShapeHandler;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import model.ShapeList;

public class Main {
    public static void main(String[] args){
        PaintCanvas paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);


        ShapeList shapeList = new ShapeList(new DrawShapeHandler(paintCanvas));

        // create new instance of UseMouseHandler class
        UseMouseHandler useMouseHandler = new UseMouseHandler(appState, shapeList);

        // add the UseMouseHandler class object to the Paint Canvas via addMouseListener()
        paintCanvas.addMouseListener(useMouseHandler);

        controller.setup();

    }
}
