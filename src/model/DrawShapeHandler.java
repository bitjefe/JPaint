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

        //System.out.println("shapeList has this many shapes = "+ masterShapeList.size()+"\n");
        Graphics2D graphics = paintCanvas.getGraphics2D();

        for(Shape shape: masterShapeList){

            if(shape.shapeType.toString().equals("RECTANGLE") && shape.shadingType.toString().equals("OUTLINE")){
                new RectangleOutlineStrategy(graphics, shape.shapeFactory, shape.primaryColor, shape);  // this draws a blue outlined rectangle! (4th design pattern)
            }

            // refactor the rest of these to respective strategy objects

            else if(shape.shapeType.toString().equals("RECTANGLE") && shape.shadingType.toString().equals("FILLED_IN")){

                EnumMap<ShapeColor,Color> colorMap = new EnumMap<>(ShapeColor.class);
                ColorSingleton colorSingletonPrimary = ColorSingleton.getInstance(shape.primaryColor,colorMap);

                primaryColorMapped = colorMap.get(shape.primaryColor);

                graphics.setColor(primaryColorMapped);
                graphics.fillRect(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());
            }

            else if(shape.shapeType.toString().equals("RECTANGLE") && shape.shadingType.toString().equals("OUTLINE_AND_FILLED_IN")){

                EnumMap<ShapeColor,Color> colorMap = new EnumMap<>(ShapeColor.class);
                ColorSingleton colorSingletonPrimary = ColorSingleton.getInstance(shape.primaryColor,colorMap);
                ColorSingleton colorSingletonSecondary = ColorSingleton.getInstance(shape.secondaryColor, colorMap);

                primaryColorMapped = colorMap.get(shape.primaryColor);
                secondaryColorMapped = colorMap.get(shape.secondaryColor);

                graphics.setColor(primaryColorMapped);
                graphics.fillRect(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());
                graphics.setColor(secondaryColorMapped);
                graphics.drawRect(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());

            }
            else if(shape.shapeType.toString().equals("ELLIPSE") && shape.shadingType.toString().equals("FILLED_IN")) {

                EnumMap<ShapeColor,Color> colorMap = new EnumMap<>(ShapeColor.class);
                ColorSingleton colorSingletonPrimary = ColorSingleton.getInstance(shape.primaryColor,colorMap);

                primaryColorMapped = colorMap.get(shape.primaryColor);

                graphics.setColor(primaryColorMapped);
                graphics.fillOval(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());

            }
            else if(shape.shapeType.toString().equals("ELLIPSE") && shape.shadingType.toString().equals("OUTLINE")) {

                EnumMap<ShapeColor,Color> colorMap = new EnumMap<>(ShapeColor.class);
                ColorSingleton colorSingletonPrimary = ColorSingleton.getInstance(shape.primaryColor,colorMap);

                primaryColorMapped = colorMap.get(shape.primaryColor);

                graphics.setColor(primaryColorMapped);
                graphics.drawOval(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());

            }
            else if(shape.shapeType.toString().equals("ELLIPSE") && shape.shadingType.toString().equals("OUTLINE_AND_FILLED_IN")) {

                EnumMap<ShapeColor,Color> colorMap = new EnumMap<>(ShapeColor.class);
                ColorSingleton colorSingletonPrimary = ColorSingleton.getInstance(shape.primaryColor,colorMap);
                ColorSingleton colorSingletonSecondary = ColorSingleton.getInstance(shape.secondaryColor, colorMap);

                primaryColorMapped = colorMap.get(shape.primaryColor);
                secondaryColorMapped = colorMap.get(shape.secondaryColor);

                graphics.setColor(secondaryColorMapped);
                graphics.drawOval(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());
                graphics.setColor(primaryColorMapped);
                graphics.fillOval(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());

            }
            else if(shape.shapeType.toString().equals("TRIANGLE")&& shape.shadingType.toString().equals("OUTLINE")) {

                int[] xCords = {shape.getXMin(), shape.getTriangleMidPoint(), shape.getXMax()};
                int[] yCords = {shape.getYMax(), shape.getYMin(), shape.getYMax() };

                EnumMap<ShapeColor,Color> colorMap = new EnumMap<>(ShapeColor.class);
                ColorSingleton colorSingletonPrimary = ColorSingleton.getInstance(shape.primaryColor,colorMap);

                primaryColorMapped = colorMap.get(shape.primaryColor);

                graphics.setColor(primaryColorMapped);
                graphics.drawPolygon(xCords, yCords, 3);
            }

            else if(shape.shapeType.toString().equals("TRIANGLE")&& shape.shadingType.toString().equals("FILLED_IN")) {

                int[] xCords = {shape.getXMin(), shape.getTriangleMidPoint(), shape.getXMax()};
                int[] yCords = {shape.getYMax(), shape.getYMin(), shape.getYMax() };

                EnumMap<ShapeColor,Color> colorMap = new EnumMap<>(ShapeColor.class);
                ColorSingleton colorSingletonPrimary = ColorSingleton.getInstance(shape.primaryColor,colorMap);
                ColorSingleton colorSingletonSecondary = ColorSingleton.getInstance(shape.secondaryColor, colorMap);

                primaryColorMapped = colorMap.get(shape.primaryColor);

                graphics.setColor(primaryColorMapped);
                graphics.fillPolygon(xCords, yCords, 3);

            }

            else if(shape.shapeType.toString().equals("TRIANGLE")&& shape.shadingType.toString().equals("OUTLINE_AND_FILLED_IN")) {

                int[] xCords = {shape.getXMin(), shape.getTriangleMidPoint(), shape.getXMax()};
                int[] yCords = {shape.getYMax(), shape.getYMin(), shape.getYMax() };

                EnumMap<ShapeColor,Color> colorMap = new EnumMap<>(ShapeColor.class);
                ColorSingleton colorSingletonPrimary = ColorSingleton.getInstance(shape.primaryColor,colorMap);
                ColorSingleton colorSingletonSecondary = ColorSingleton.getInstance(shape.secondaryColor, colorMap);

                primaryColorMapped = colorMap.get(shape.primaryColor);
                secondaryColorMapped = colorMap.get(shape.secondaryColor);

                graphics.setColor(primaryColorMapped);
                graphics.fillPolygon(xCords, yCords, 3);

                graphics.setColor(secondaryColorMapped);
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