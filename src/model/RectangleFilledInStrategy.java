package model;

import model.interfaces.IShapeStrategy;

import java.awt.*;
import java.util.EnumMap;

public class RectangleFilledInStrategy implements IShapeStrategy {
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private Graphics2D graphics;
    private Shape shape;


    public RectangleFilledInStrategy(Graphics2D graphics, ShapeColor primaryColor, ShapeColor secondaryColor, Shape shape) {
        this.graphics = graphics;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shape = shape;
    }

    @Override
    public Color EnumColorMap(ShapeColor shapeColor) {
        EnumMap<ShapeColor,Color> colorMap = new EnumMap<>(ShapeColor.class);
        ColorSingleton colorSingleton = ColorSingleton.getInstance(shapeColor,colorMap);
        Color colorMapped = colorMap.get(shapeColor);
        return colorMapped;
    }

    @Override
    public void draw() {
        Color primaryColorMapped = EnumColorMap(primaryColor);
        graphics.setColor(primaryColorMapped);
        graphics.fillRect(shape.getXMin(), shape.getYMin(), shape.getWidth(), shape.getHeight());
    }

}