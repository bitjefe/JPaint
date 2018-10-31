package model;
import java.util.ArrayList;

public class ShapeList {

    public DrawShapeHandler drawShapeHandler;

    public ArrayList<Shape> shapeList = new ArrayList<>();

    public ShapeList(DrawShapeHandler drawShapeHandler){
        this.drawShapeHandler = drawShapeHandler;
    }

    public void add(Shape shape){

        if(shape == null){
            System.out.println("error in ShapeList");
        }
        else {
            shapeList.add(shape);
            drawShapeHandler.update(shapeList);
        }

    }
}
