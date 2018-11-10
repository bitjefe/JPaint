package model;

import java.util.Stack;


public class CommandHistory {
    private static final Stack<CommandHistory> undoStack = new Stack<CommandHistory>();
    private static final Stack<CommandHistory> redoStack = new Stack<CommandHistory>();

    public static void add(CommandHistory cmd) {
        undoStack.push(cmd);
        redoStack.clear();
    }

    public static boolean undo() {
        boolean result = !undoStack.empty();
        if (result) {
            CommandHistory c = undoStack.pop();
            redoStack.push(c);
            c.undo();
        }
        return result;
    }

    public static boolean redo() {
        boolean result = !redoStack.empty();
        if (result) {
            CommandHistory c = redoStack.pop();
            undoStack.push(c);
            c.redo();
        }
        return result;
    }

    // For testing
    CommandHistory topUndoCommand() {
        if (undoStack.empty())
            return null;
        else
            return undoStack.peek();
    }
    // For testing
    CommandHistory topRedoCommand() {
        if (redoStack.empty())
            return null;
        else
            return redoStack.peek();
    }
}