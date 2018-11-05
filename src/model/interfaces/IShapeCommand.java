package model.interfaces;

public interface IShapeCommand {
    void run();
    void undo();
    void redo();
}

