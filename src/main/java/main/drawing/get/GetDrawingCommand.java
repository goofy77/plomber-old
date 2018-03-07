package main.drawing.get;

import main.models.Defect;
import main.models.Drawing;

import java.util.List;

public class GetDrawingCommand {

    private String drawingId;

    private String name;

    private String drawingUrl;

    private Integer rotation;

    private List<Defect> defects;

    private GetDrawingCommand(){}

    GetDrawingCommand(Drawing drawing) {
        this.drawingId = drawing.getDrawingId().toHexString();
        this.name = drawing.getName();
        this.drawingUrl = drawing.getDrawingUrl();
        this.rotation = drawing.getRotation();
        this.defects = drawing.getDefects();
    }

    public String getDrawingId() {
        return drawingId;
    }

    public String getName() {
        return name;
    }

    public String getDrawingUrl() {
        return drawingUrl;
    }

    public Integer getRotation() {
        return rotation;
    }

    public List<Defect> getDefects() {
        return defects;
    }
}
