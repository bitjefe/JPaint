package model;

import java.awt.*;
import java.util.EnumMap;

public class TriangleOutlineFilledInStrategy {
    public TriangleOutlineFilledInStrategy(Graphics2D graphics, ShapeFactory shapeFactory, ShapeColor primaryColor, ShapeColor secondaryColor, Shape shape) {

        int[] xCords = {shape.getXMin(), shape.getTriangleMidPoint(), shape.getXMax()};
        int[] yCords = {shape.getYMax(), shape.getYMin(), shape.getYMax() };

        EnumMap<ShapeColor,Color> colorMap = new EnumMap<>(ShapeColor.class);
        ColorSingleton colorSingletonPrimary = ColorSingleton.getInstance(primaryColor,colorMap);
        ColorSingleton colorSingletonSecondary = ColorSingleton.getInstance(secondaryColor,colorMap);
        Color primaryColorMapped = colorMap.get(primaryColor);

        Color secondaryColorMapped = colorMap.get(secondaryColor);

        graphics.setColor(primaryColorMapped);
        graphics.fillPolygon(xCords, yCords, 3);

        graphics.setColor(secondaryColorMapped);
        graphics.drawPolygon(xCords, yCords, 3);
    }
}
