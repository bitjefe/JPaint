package model;

import view.gui.PaintCanvas;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class DrawShapeHandler {

    public PaintCanvas paintCanvas;

    public DrawShapeHandler(PaintCanvas paintCanvas){
        this.paintCanvas = paintCanvas;
    }

    public void update(ArrayList<Shape> shapeList) {
        for(Shape shape: shapeList){

            System.out.println(shape.getShapeType());

            // add builder pattern for rectangle, ellipse, triangle here or in new ShapeFactory Class?
            // use factories here instead of creating the shapes inline

            if(shape.getShapeType().toString().equals("RECTANGLE")){
                paintCanvas.getGraphics2D().drawRect(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());
            }
            else if(shape.getShapeType().toString().equals("ELLIPSE")) {
                paintCanvas.getGraphics2D().draw(new Ellipse2D.Double(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight()));
            }
            else if(shape.getShapeType().toString().equals("TRIANGLE")) {

                System.out.println(shape.getStartPoint().x);
                int[] xCords = {shape.getXMin(), shape.getTriangleMidPoint(), shape.getXMax()};
                int[] yCords = {shape.getYMax(), shape.getYMin(), shape.getYMax() };

                paintCanvas.getGraphics2D().drawPolygon(xCords, yCords, 3);
            }
            else{
                System.out.println("Something went wrong");
            }
        }
    }
}
