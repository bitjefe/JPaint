package model.interfaces;

import model.ShapeList;
import model.Shape;
import java.util.List;

public interface IShape {
    Shape makeShape(IApplicationState appState, ShapeList shapeList, List<Shape> selectedShapeList);
}
