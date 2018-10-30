package model;

import view.gui.PaintCanvas;

import java.awt.*;
import java.util.ArrayList;

public class DrawShapeHandler {

    public PaintCanvas paintCanvas;

    public DrawShapeHandler(PaintCanvas paintCanvas){
        this.paintCanvas = paintCanvas;
    }

    public void update(ArrayList<Shape> shapeList) {
        for(Shape shape: shapeList){
            paintCanvas.getGraphics2D().drawRect(shape.getStartPoint().x, shape.getStartPoint().y, shape.getWidth(), shape.getHeight());
        }
    }
}
