package model;

import view.gui.PaintCanvas;

import java.awt.geom.Ellipse2D;
import java.util.EnumMap;
import java.awt.Color;
import java.util.List;
import java.awt.Graphics2D;


public class DrawShapeHandler {

    public PaintCanvas paintCanvas;
    public Color activeColorMapped;

    public DrawShapeHandler(PaintCanvas paintCanvas){
        this.paintCanvas = paintCanvas;
    }

    public void update(List<Shape> shapeList) {

        System.out.println("shapeList has this many shapes added = "+ shapeList.size());
        Graphics2D graphics = paintCanvas.getGraphics2D();

        for(Shape shape: shapeList){

            if(shape.getShapeType().toString().equals("RECTANGLE")){

                EnumMap<ShapeColor,Color> colorMap = new EnumMap<>(ShapeColor.class);
                colorMap.put(ShapeColor.BLUE, Color.BLUE);

                //this always returns a null pointer exception

                /*ColorSingleton colorSingleton = ColorSingleton.getInstance(shape.getPrimaryColor());
                activeColorMapped = colorSingleton.getEnum().get(ShapeColor.BLUE);
                */

                activeColorMapped = colorMap.get(ShapeColor.BLUE);
                System.out.println(activeColorMapped);

                graphics.setColor(activeColorMapped);
                graphics.drawRect(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());

            }
            else if(shape.getShapeType().toString().equals("ELLIPSE")) {
                graphics.draw(new Ellipse2D.Double(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight()));
            }
            else if(shape.getShapeType().toString().equals("TRIANGLE")) {

                int[] xCords = {shape.getXMin(), shape.getTriangleMidPoint(), shape.getXMax()};
                int[] yCords = {shape.getYMax(), shape.getYMin(), shape.getYMax() };

                graphics.drawPolygon(xCords, yCords, 3);
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