package model;
import java.util.ArrayList;

public class ShapeList {

    public DrawShapeHandler drawShapeHandler;

    public ArrayList<Shape> shapeList = new ArrayList<>();

    public ShapeList(DrawShapeHandler drawShapeHandler){
        this.drawShapeHandler = drawShapeHandler;
    }

    public void add(Shape shape){
        shapeList.add(shape);
        drawShapeHandler.update(shapeList);
    }

 /*   public void remove(Shape shape){
        shapeList.remove(shape);
        drawShapeHandler.update(shapeList);
    }
 */
}
