package controller;

import model.ShapeList;
import view.gui.PaintCanvas;
import java.util.ArrayList;

import java.awt.*;

public class DrawShapeHandler extends ShapeList {

    private static PaintCanvas paintCanvas;

    public DrawShapeHandler(PaintCanvas paintCanvas) {
        paintCanvas.getGraphics2D();
    }

    public void update(ArrayList<Shape> shapeList) {
        for (Shape shape : shapeList) {
            DrawShapeHandler.draw(shape);
        }
    }

    private static void draw(Shape shape){
        Graphics2D g2d = paintCanvas.getGraphics2D();
        g2d.draw(shape);
    }

}
