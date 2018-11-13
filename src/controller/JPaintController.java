package controller;

import model.*;
import model.interfaces.IApplicationState;
import view.EventName;
import view.gui.PaintCanvas;
import view.interfaces.IUiModule;

import java.util.List;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    public ShapeList shapeList;
    public List<Shape> selectedShapeList;
    public List<Shape> copiedShapeList;
    public PaintCanvas paintCanvas;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, ShapeList shapeList, List<Shape> selectedShapeList, List<Shape> copiedShapeList, PaintCanvas paintCanvas) {
        this.shapeList = shapeList;
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.selectedShapeList = selectedShapeList;
        this.copiedShapeList = copiedShapeList;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.DELETE, () -> new DeleteCommand(applicationState, shapeList).run());//applicationState.DeleteCommand());
        uiModule.addEvent(EventName.COPY, () -> new CopyCommand(selectedShapeList, copiedShapeList, shapeList).run());
        uiModule.addEvent(EventName.PASTE, () -> new PasteCommand(copiedShapeList, shapeList).run());

        //do i need a commandHistory list here for undo redo?
        uiModule.addEvent(EventName.UNDO, () -> new UndoCommand(shapeList).run());
        uiModule.addEvent(EventName.REDO, () -> new RedoCommand(shapeList).run());
    }
}
