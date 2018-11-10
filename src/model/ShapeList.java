package model;

import java.util.ArrayList;
import java.util.List;


public class ShapeList{

    public DrawShapeHandler drawShapeHandler;
    public Shape shape;

    public List<Shape> masterShapeList;

    public ShapeList(DrawShapeHandler drawShapeHandler, List<Shape> masterShapeList)
    {
        this.drawShapeHandler = drawShapeHandler;
        this.masterShapeList = masterShapeList;
    }

}
