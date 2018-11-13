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
    public List<Shape> shapeListBeforeMoved = new ArrayList<>();
    public List<Shape> shapeListBeforeUndo = new ArrayList<>();
    public int deltaX;
    public int deltaY;


    public MoveShapeCommand(ShapeFactory shapeFactory, ShapeType shapeType, Point mousePressed, Point mouseReleased){
        this.shapeFactory = shapeFactory;
        this.shapeType = shapeType;
        this.mousePressed = mousePressed;
        this.mouseReleased = mouseReleased;
        deltaX= (mouseReleased.x - mousePressed.x);
        deltaY = (mouseReleased.y - mousePressed.y);
    }

    @Override
    public void run() {
        move(shapeFactory.shapeList.masterShapeList);
        pasteMoved(movedShapeList);
        shapeFactory.shapeList.drawShapeHandler.paintCanvas.repaint();
        shapeFactory.shapeList.drawShapeHandler.update(shapeFactory.shapeList.masterShapeList);
        CommandHistory.add(this);
    }

    private void move(List<Shape> masterShapeList) {

        for(Shape shape: masterShapeList) {

            if(shape.containsPoint(mousePressed.x, mousePressed.y)){

                int newStartPointX = (shape.startPoint.x)+deltaX;
                int newStartPointY = (shape.startPoint.y)+deltaY;

                int newEndPointX = (shape.endPoint.x)+deltaX;
                int newEndPointY = (shape.endPoint.y)+deltaY;

                Point newStartPoint = new Point(newStartPointX, newStartPointY);
                Point newEndPoint = new Point(newEndPointX,newEndPointY);

                Shape movedShape = new Shape(shapeType, newStartPoint, newEndPoint, shape.primaryColor, shape.secondaryColor, shape.shadingType);
                movedShapeList.add(shape);
                movedShapeList.add(movedShape);
            }
        }
    }

    public void pasteMoved(List<Shape> movedShapeList) {
        for (Shape shape : movedShapeList) {
            if (!shapeFactory.shapeList.masterShapeList.contains(shape)) {
                Shape movedShape = new Shape(shape.shapeType, shape.startPoint, shape.endPoint, shape.primaryColor, shape.secondaryColor, shape.shadingType);
                shapeFactory.shapeList.masterShapeList.add(movedShape);
            }
            else{
                shapeFactory.shapeList.masterShapeList.remove(shape);
            }
        }
    }

    @Override
    public void undo() {

        System.out.println("undo move shape run");

        movedShapeList.clear();

        for(Shape shape: shapeFactory.shapeList.masterShapeList) {

            if(shape.containsPoint(mousePressed.x+deltaX, mousePressed.y+deltaY)) {

                int newStartPointX = (shape.startPoint.x) - deltaX;
                int newStartPointY = (shape.startPoint.y) - deltaY;

                int newEndPointX = (shape.endPoint.x) - deltaX;
                int newEndPointY = (shape.endPoint.y) - deltaY;

                Point newStartPoint = new Point(newStartPointX, newStartPointY);
                Point newEndPoint = new Point(newEndPointX, newEndPointY);

                Shape removedShape = new Shape(shapeType, newStartPoint, newEndPoint, shape.primaryColor, shape.secondaryColor, shape.shadingType);
                movedShapeList.add(removedShape);
                shapeListBeforeUndo.add(shape);
            }
        }
        pasteMoved(movedShapeList);

        for(Shape shape: shapeListBeforeUndo){
            if (shapeFactory.shapeList.masterShapeList.contains(shape)){
                shapeFactory.shapeList.masterShapeList.remove(shape);
            }
        }

        shapeFactory.shapeList.drawShapeHandler.paintCanvas.repaint();
        shapeFactory.shapeList.drawShapeHandler.update(shapeFactory.shapeList.masterShapeList);

    }

    @Override
    public void redo() {

        // this redo() method will not run when i click redo button. only the redoCommand run() method in that class
        System.out.println("redo move shape run");
        move(shapeFactory.shapeList.masterShapeList);
        pasteMoved(movedShapeList);
        shapeFactory.shapeList.drawShapeHandler.paintCanvas.repaint();
        shapeFactory.shapeList.drawShapeHandler.update(shapeFactory.shapeList.masterShapeList);
        CommandHistory.redo();
    }


}

