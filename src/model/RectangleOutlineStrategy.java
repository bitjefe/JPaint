package model;

import java.awt.*;
import java.util.EnumMap;

public class RectangleOutlineStrategy {
    
    public RectangleOutlineStrategy(Graphics2D graphics, ShapeFactory shapeFactory, ShapeColor primaryColor, Shape shape) {

        System.out.println("you're in the strategy now");

        EnumMap<ShapeColor,Color> colorMap = new EnumMap<>(ShapeColor.class);
        ColorSingleton colorSingletonPrimary = ColorSingleton.getInstance(primaryColor,colorMap);
        Color primaryColorMapped = colorMap.get(primaryColor);

        graphics.setColor(primaryColorMapped);
        graphics.drawRect(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());
    }
}

