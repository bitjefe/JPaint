package model;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

public class ShapeList{

    public DrawShapeHandler drawShapeHandler;

    public List<Shape> shapeList = new ArrayList<>();
    public Shape getShapeIndex;

    public ShapeList(DrawShapeHandler drawShapeHandler){
        this.drawShapeHandler = drawShapeHandler;
    }

    public void add(Shape shape){
        shapeList.add(shape);
        drawShapeHandler.update(shapeList);
    }

    public void remove(Shape shape){
        shapeList.remove(shape);
        drawShapeHandler.update(shapeList);
    }

    public int size(){
        int counter = 0;
        for(Shape shape:shapeList){
            counter++;
        }
        return counter;
    }

    public Shape getShapeIndex(int index){
        return this.shapeList.get(index);
    }

}
