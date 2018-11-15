package model;

import model.interfaces.IShapeStrategy;

import java.awt.*;
import java.util.EnumMap;

public class TriangleOutlineFilledInStrategy implements IShapeStrategy {
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
    private Graphics2D graphics;
    private Shape shape;


    public TriangleOutlineFilledInStrategy(Graphics2D graphics, ShapeColor primaryColor, ShapeColor secondaryColor, Shape shape) {
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
        int[] xCords = {shape.getXMin(), shape.getTriangleMidPoint(), shape.getXMax()};
        int[] yCords = {shape.getYMax(), shape.getYMin(), shape.getYMax() };

        Color primaryColorMapped = EnumColorMap(primaryColor);
        graphics.setColor(primaryColorMapped);
        graphics.fillPolygon(xCords, yCords, 3);

        Color secondaryColorMapped = EnumColorMap(secondaryColor);
        graphics.setColor(secondaryColorMapped);
        graphics.drawPolygon(xCords, yCords, 3);
    }

}