package model;

import java.awt.*;
import java.util.EnumMap;

public class RectangleFilledInStrategy {
    public RectangleFilledInStrategy(Graphics2D graphics, ShapeFactory shapeFactory, ShapeColor primaryColor, Shape shape) {

        EnumMap<ShapeColor,Color> colorMap = new EnumMap<>(ShapeColor.class);
        ColorSingleton colorSingletonPrimary = ColorSingleton.getInstance(primaryColor,colorMap);
        Color primaryColorMapped = colorMap.get(primaryColor);

        graphics.setColor(primaryColorMapped);
        graphics.fillRect(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());
    }
}
