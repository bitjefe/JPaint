package model;

import model.interfaces.IShapeStrategy;
import view.gui.PaintCanvas;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.EnumMap;
import java.util.List;

public class DrawShapeHandler {

    private IShapeStrategy shapeStrategy;
    public PaintCanvas paintCanvas;

    public DrawShapeHandler(PaintCanvas paintCanvas, IShapeStrategy shapeStrategy){
        this.paintCanvas = paintCanvas;
        this.shapeStrategy = shapeStrategy;
    }

    public void update(List<Shape> masterShapeList) {
        Graphics2D graphics = paintCanvas.getGraphics2D();

        for(Shape shape: masterShapeList){
            if(shape.shapeType.toString().equals("RECTANGLE") && shape.shadingType.toString().equals("OUTLINE") && shape.clickType.equals("LEFT")){
                shapeStrategy = new RectangleOutlineStrategy(graphics, shape.primaryColor, shape.secondaryColor, shape);
            }
            else if(shape.shapeType.toString().equals("RECTANGLE") && shape.shadingType.toString().equals("OUTLINE") && shape.clickType.equals("RIGHT")){
                shapeStrategy = new RectangleOutlineStrategy(graphics, shape.secondaryColor, shape.primaryColor, shape);
            }

            else if(shape.shapeType.toString().equals("RECTANGLE") && shape.shadingType.toString().equals("FILLED_IN")){
                shapeStrategy = new RectangleFilledInStrategy(graphics, shape.primaryColor, shape.secondaryColor, shape);
            }

            else if(shape.shapeType.toString().equals("RECTANGLE") && shape.shadingType.toString().equals("OUTLINE_AND_FILLED_IN")){
                shapeStrategy = new RectangleOutlineFilledInStrategy(graphics, shape.primaryColor, shape.secondaryColor, shape);
            }

            else if(shape.shapeType.toString().equals("ELLIPSE") && shape.shadingType.toString().equals("OUTLINE")) {
                shapeStrategy = new EllipseOutlineStrategy(graphics, shape.primaryColor, shape.secondaryColor, shape);
            }

            else if(shape.shapeType.toString().equals("ELLIPSE") && shape.shadingType.toString().equals("FILLED_IN")) {
                shapeStrategy = new EllipseFilledInStrategy(graphics, shape.primaryColor,shape.secondaryColor, shape);
            }

            else if(shape.shapeType.toString().equals("ELLIPSE") && shape.shadingType.toString().equals("OUTLINE_AND_FILLED_IN")) {
                shapeStrategy = new EllipseOutlineFilledInStrategy(graphics, shape.primaryColor, shape.secondaryColor, shape);
            }

            else if(shape.shapeType.toString().equals("TRIANGLE")&& shape.shadingType.toString().equals("OUTLINE")) {
                shapeStrategy = new TriangleOutlineStrategy(graphics, shape.primaryColor, shape.secondaryColor, shape);
            }

            else if(shape.shapeType.toString().equals("TRIANGLE")&& shape.shadingType.toString().equals("FILLED_IN")) {
                shapeStrategy = new TriangleFilledInStrategy(graphics, shape.primaryColor, shape.secondaryColor, shape);
            }

            else if(shape.shapeType.toString().equals("TRIANGLE")&& shape.shadingType.toString().equals("OUTLINE_AND_FILLED_IN")) {
                shapeStrategy = new TriangleOutlineFilledInStrategy(graphics, shape.primaryColor, shape.secondaryColor, shape);
            }

            else{
                System.out.println("Something went wrong");
            }
            //draws the shape after the shapeType and shadingType are determined and the appropriate strategy objects is returned
            shapeStrategy.draw();
        }
    }
}
