package model;
import java.util.ArrayList;

public class ShapeList {

    DrawShapeHandler drawShapeHandler;

    ArrayList<Shape> ShapeList = new ArrayList<>();

    public ShapeList(DrawShapeHandler drawShapeHandler){
        this.drawShapeHandler = drawShapeHandler;
    }

    public void add(Shape shape){
        ShapeList.add(shape);
        drawShapeHandler.update(ShapeList);
    }
}
