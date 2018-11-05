package model.interfaces;

import model.ShapeList;
import model.Shape;

public interface IShape {
    Shape makeShape(IApplicationState appState, ShapeList shapeList);
}
