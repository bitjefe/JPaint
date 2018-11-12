package model;

import model.interfaces.IShapeCommand;
import model.interfaces.IUndoable;

import java.util.ArrayList;
import java.awt.Point;
import java.util.List;

public class MoveShapeCommand implements IShapeCommand, IUndoable {

    public ShapeType shapeType;
    public Point mousePressed;
    public Point mouseReleased;
    public ShapeFactory shapeFactory;
    public List<Shape> movedShapeList = new ArrayList<>();


    public MoveShapeCommand(ShapeFactory shapeFactory, ShapeType shapeType, Point mousePressed, Point mouseReleased){
        this.shapeFactory = shapeFactory;
        this.shapeType = shapeType;
        this.mousePressed = mousePressed;
        this.mouseReleased = mouseReleased;
    }

    @Override
    public void run() {
        move(shapeFactory.shapeList.masterShapeList);
        pasteMoved(movedShapeList);
        shapeFactory.shapeList.drawShapeHandler.paintCanvas.repaint();
        shapeFactory.shapeList.drawShapeHandler.update(shapeFactory.shapeList.masterShapeList);

        //CommandHistory.add(this)
    }

    private void move(List<Shape> masterShapeList) {

        int deltaX = (mouseReleased.x - mousePressed.x);
        int deltaY = (mouseReleased.y - mousePressed.y);

        for(Shape shape: masterShapeList) {
            if(shape.containsPoint(mousePressed.x, mousePressed.y)){

                System.out.println("Original startPoint = "+ shape.startPoint);
                System.out.println("Original endPoint = "+ shape.endPoint);

                int newStartPointX = (shape.startPoint.x)+deltaX;
                int newStartPointY = (shape.startPoint.y)+deltaY;

                int newEndPointX = (shape.endPoint.x)+deltaX;
                int newEndPointY = (shape.endPoint.y)+deltaY;

                Point newStartPoint = new Point(newStartPointX, newStartPointY);
                Point newEndPoint = new Point(newEndPointX,newEndPointY);

                System.out.println("shapeType = "+ shapeType);
                System.out.println("newStartPoint = "+ newStartPoint);
                System.out.println("newEndPoint = "+ newEndPoint);
                System.out.println("primaryColor = "+ shape.primaryColor);
                System.out.println("secondaryColor = "+ shape.secondaryColor);

                Shape movedShape = new Shape(shapeFactory, shapeType, newStartPoint, newEndPoint, shape.primaryColor, shape.secondaryColor);
                movedShapeList.add(shape);
                movedShapeList.add(movedShape);

                System.out.println("movedShapeList size = "+ movedShapeList.size());
            }
        }
    }

    public void pasteMoved(List<Shape> movedShapeList) {
        for (Shape shape : movedShapeList) {
            if (!shapeFactory.shapeList.masterShapeList.contains(shape)) {
                Shape movedShape = new Shape(shape.shapeFactory, shape.shapeType, shape.startPoint, shape.endPoint, shape.primaryColor, shape.secondaryColor);
                shapeFactory.shapeList.masterShapeList.add(movedShape);
            }
            else{
                shapeFactory.shapeList.masterShapeList.remove(shape);
            }
        }
    }


    @Override
    public void undo() {

    }


    public void redo(){

    }
}

