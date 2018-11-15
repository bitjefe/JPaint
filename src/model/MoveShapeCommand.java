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

                Shape movedShape = new Shape(shapeType, newStartPoint, newEndPoint, shape.primaryColor, shape.secondaryColor, shape.shadingType, shape.clickType);
                shapeFactory.shapeList.commandHistoryUndo.add(shape);
                shapeFactory.shapeList.commandHistoryRedo.add(movedShape);

                movedShapeList.add(shape);
                movedShapeList.add(movedShape);

            }
        }
    }

    private void pasteMoved(List<Shape> movedShapeList) {
        for (Shape shape : movedShapeList) {
            if (!shapeFactory.shapeList.masterShapeList.contains(shape)) {
                Shape movedShape = new Shape(shape.shapeType, shape.startPoint, shape.endPoint, shape.primaryColor, shape.secondaryColor, shape.shadingType, shape.clickType);
                shapeFactory.shapeList.masterShapeList.add(movedShape);
            }
            else{
                shapeFactory.shapeList.masterShapeList.remove(shape);
            }
        }
    }

    @Override
    public void undo() {
        if(shapeFactory.shapeList.masterShapeList.size()<=0){
            System.out.println("no shapes left to remove");
        } else {
            System.out.println("masterShapeList size = "+ shapeFactory.shapeList.masterShapeList.size());
            shapeFactory.shapeList.masterShapeList.remove(shapeFactory.shapeList.masterShapeList.size()-1);
            pasteMoved(shapeFactory.shapeList.commandHistoryUndo);
            pasteMoved(shapeFactory.shapeList.commandHistoryRedo);

            System.out.println("masterShapeList size = "+ shapeFactory.shapeList.masterShapeList.size());
            shapeFactory.shapeList.drawShapeHandler.paintCanvas.repaint();
            shapeFactory.shapeList.drawShapeHandler.update(shapeFactory.shapeList.masterShapeList);
        }

    }

    // bug in redo, pastes both the moved shape and the originally drawn shape on redo button. Can't get rid of both shapes in masterShapeList

    @Override
    public void redo() {
        run();
    }

}

