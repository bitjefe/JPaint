package model;

import java.awt.*;
import java.util.EnumMap;

public class TriangleFilledInStrategy {
    public TriangleFilledInStrategy(Graphics2D graphics, ShapeFactory shapeFactory, ShapeColor primaryColor, Shape shape) {

        int[] xCords = {shape.getXMin(), shape.getTriangleMidPoint(), shape.getXMax()};
        int[] yCords = {shape.getYMax(), shape.getYMin(), shape.getYMax() };

        EnumMap<ShapeColor,Color> colorMap = new EnumMap<>(ShapeColor.class);
        ColorSingleton colorSingletonPrimary = ColorSingleton.getInstance(primaryColor,colorMap);
        Color primaryColorMapped = colorMap.get(primaryColor);

        graphics.setColor(primaryColorMapped);
        graphics.fillPolygon(xCords, yCords, 3);
    }
}
