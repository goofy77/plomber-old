package main.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import main.defect.DefectType;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Defect {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId defectId;
    private String description;
    private String photoUrl;
    private Coordinates coordinates;
    private LocalDateTime createdAt;
    private DefectType defectType;

    public Defect() {
        this.defectId = new ObjectId();
    }

    public Defect(String description, String photoUrl, Coordinates coordinates, DefectType defectType) {
        this.defectType = defectType;
        this.defectId = new ObjectId();
        this.description = description;
        this.photoUrl = photoUrl;
        this.coordinates = coordinates;
        this.createdAt = LocalDateTime.now();
    }

    public ObjectId getDefectId() {
        return defectId;
    }

    public String getDescription() {
        return description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public DefectType getDefectType() {
        return defectType;
    }
}
