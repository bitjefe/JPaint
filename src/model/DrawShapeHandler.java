package model;

import view.gui.PaintCanvas;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.EnumMap;
import java.util.List;

public class DrawShapeHandler {

    public PaintCanvas paintCanvas;
    public Color primaryColorMapped;
    public Color secondaryColorMapped;

    public DrawShapeHandler(PaintCanvas paintCanvas){
        this.paintCanvas = paintCanvas;
    }

    public void update(List<Shape> masterShapeList) {
        Graphics2D graphics = paintCanvas.getGraphics2D();

        for(Shape shape: masterShapeList){
            if(shape.shapeType.toString().equals("RECTANGLE") && shape.shadingType.toString().equals("OUTLINE")){
                new RectangleOutlineStrategy(graphics, shape.shapeFactory, shape.primaryColor, shape);  // (4th design pattern?)
            }

            else if(shape.shapeType.toString().equals("RECTANGLE") && shape.shadingType.toString().equals("FILLED_IN")){
                new RectangleFilledInStrategy(graphics, shape.shapeFactory, shape.primaryColor, shape);
            }

            else if(shape.shapeType.toString().equals("RECTANGLE") && shape.shadingType.toString().equals("OUTLINE_AND_FILLED_IN")){
                new RectangleOutlineFilledInStrategy(graphics, shape.shapeFactory, shape.primaryColor, shape.secondaryColor, shape);
            }

            else if(shape.shapeType.toString().equals("ELLIPSE") && shape.shadingType.toString().equals("OUTLINE")) {
                new EllipseOutlineStrategy(graphics, shape.shapeFactory, shape.primaryColor, shape);
            }

            else if(shape.shapeType.toString().equals("ELLIPSE") && shape.shadingType.toString().equals("FILLED_IN")) {
                new EllipseFilledInStrategy(graphics, shape.shapeFactory, shape.primaryColor, shape);
            }

            else if(shape.shapeType.toString().equals("ELLIPSE") && shape.shadingType.toString().equals("OUTLINE_AND_FILLED_IN")) {
                new EllipseOutlineFilledInStrategy(graphics, shape.shapeFactory, shape.primaryColor, shape.secondaryColor, shape);
            }

            else if(shape.shapeType.toString().equals("TRIANGLE")&& shape.shadingType.toString().equals("OUTLINE")) {
                new TriangleOutlineStrategy(graphics, shape.shapeFactory, shape.primaryColor, shape);
            }

            else if(shape.shapeType.toString().equals("TRIANGLE")&& shape.shadingType.toString().equals("FILLED_IN")) {
                new TriangleFilledInStrategy(graphics, shape.shapeFactory, shape.primaryColor, shape);
            }

            else if(shape.shapeType.toString().equals("TRIANGLE")&& shape.shadingType.toString().equals("OUTLINE_AND_FILLED_IN")) {
                new TriangleOutlineFilledInStrategy(graphics, shape.shapeFactory, shape.primaryColor, shape.secondaryColor, shape);
            }

            else{
                System.out.println("Something went wrong");
            }
        }
    }
}
