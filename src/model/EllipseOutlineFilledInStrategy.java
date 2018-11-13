package model;

import java.awt.*;
import java.util.EnumMap;

public class EllipseOutlineFilledInStrategy {
    public EllipseOutlineFilledInStrategy(Graphics2D graphics, ShapeFactory shapeFactory, ShapeColor primaryColor, ShapeColor secondaryColor, Shape shape) {

        EnumMap<ShapeColor,Color> colorMap = new EnumMap<>(ShapeColor.class);
        ColorSingleton colorSingletonPrimary = ColorSingleton.getInstance(primaryColor,colorMap);
        ColorSingleton colorSingletonSecondary = ColorSingleton.getInstance(secondaryColor,colorMap);
        Color primaryColorMapped = colorMap.get(primaryColor);

        Color secondaryColorMapped = colorMap.get(secondaryColor);

        graphics.setColor(primaryColorMapped);
        graphics.fillOval(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());

        graphics.setColor(secondaryColorMapped);
        graphics.drawOval(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());
    }
}
