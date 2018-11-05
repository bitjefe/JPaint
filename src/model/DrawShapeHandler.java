package model;

import view.gui.PaintCanvas;

import java.awt.geom.Ellipse2D;
import java.util.EnumMap;
import java.awt.Color;
import java.util.List;


public class DrawShapeHandler {

    public PaintCanvas paintCanvas;
    public Color activeColorMapped;

    public DrawShapeHandler(PaintCanvas paintCanvas){
        this.paintCanvas = paintCanvas;
    }

    public void update(List<Shape> shapeList) {
        for(Shape shape: shapeList){

            if(shape.getShapeType().toString().equals("RECTANGLE")){

                EnumMap<ShapeColor,Color> colorMap = new EnumMap<>(ShapeColor.class);
                colorMap.put(ShapeColor.BLUE, Color.BLUE);
                activeColorMapped = colorMap.get(ShapeColor.BLUE);

                System.out.println(activeColorMapped);

                paintCanvas.getGraphics2D().setColor(activeColorMapped);
                paintCanvas.getGraphics2D().drawRect(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());

            }
            else if(shape.getShapeType().toString().equals("ELLIPSE")) {
                paintCanvas.getGraphics2D().draw(new Ellipse2D.Double(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight()));
            }
            else if(shape.getShapeType().toString().equals("TRIANGLE")) {

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



/* System.out.println(shape.getShapeType());
   System.out.println(shape.getPrimaryColor());
   System.out.println(shape.getSecondaryColor());
   System.out.println(shape.getShadingType());
   System.out.println(shape.getStartAndEndPointMode());
*/

// add builder pattern for rectangle, ellipse, triangle here or in new ShapeFactory Class?
// use factories here instead of creating the shapes inline