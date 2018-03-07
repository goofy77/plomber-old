package main.defect;

import main.models.Coordinates;

public class CreateDefectCommand {
    private String description;
    private DefectType defectType;
    private Coordinates coordinates;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public String getDescription() {
        return description;
    }

    public DefectType getDefectType() {
        return defectType;
    }

}
