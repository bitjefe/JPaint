package model;

import java.util.ArrayList;
import java.util.List;


public class ShapeList{

    public DrawShapeHandler drawShapeHandler;
    public Shape shape;

    public List<Shape> shapeList = new ArrayList<>();

    public ShapeList(DrawShapeHandler drawShapeHandler){
        this.drawShapeHandler = drawShapeHandler;
    }

    public void add(Shape shape){
        shapeList.add(shape);
        drawShapeHandler.update(shapeList);
    }


    public void remove(){
        shapeList.remove(shapeList.size()-1);
        drawShapeHandler.update(shapeList);             //doesn't update the canvas until you click on canvas again
    }

    public int size(){
        int counter =0;
        for(Shape shape: shapeList){
            counter++;
        }
        return counter;
    }

}
