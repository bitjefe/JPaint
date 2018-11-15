package model;

import java.util.ArrayList;
import java.util.List;


public class ShapeList{

    public DrawShapeHandler drawShapeHandler;
    public Shape shape;
    public List<Shape> commandHistoryUndo;
    public List<Shape> commandHistoryRedo;

    public List<Shape> masterShapeList;

    public ShapeList(DrawShapeHandler drawShapeHandler, List<Shape> masterShapeList, List<Shape> commandHistoryUndo, List<Shape> commandHistoryRedo)
    {
        this.drawShapeHandler = drawShapeHandler;
        this.masterShapeList = masterShapeList;
        this.commandHistoryUndo = commandHistoryUndo;
        this.commandHistoryRedo = commandHistoryRedo;
    }

}
