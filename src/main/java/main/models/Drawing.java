package main.models;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.LinkedList;
import java.util.List;

public class Drawing {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId drawingId;

    private String name;

    private String drawingUrl;

    private Integer rotation;

    private List<Defect> defects;

    private Drawing() {
        this.drawingId = new ObjectId();
    }

    public Drawing(List<Defect> defects, String drawngUrl, String drawingName) {
        this(drawngUrl, drawingName);
        this.defects = defects;
    }

    public Drawing(String drawngUrl, String drawingName) {
        this(drawngUrl);
        this.name = drawingName;
        this.defects = defects;
    }

    private Drawing(String drawingUrl) {
        this.drawingUrl = drawingUrl;
        this.drawingId = new ObjectId();
        this.rotation = 0;
    }

    public List<Defect> getDefects() {
        return defects;
    }

    public String getName() {
        return name;
    }

    public ObjectId getDrawingId() {
        return drawingId;
    }

    public String getDrawingUrl() {
        return drawingUrl;
    }

    public Integer getRotation() {
        return rotation;
    }

    public Drawing addDefect(Defect defect){
        if(this.defects == null){
            this.defects = new LinkedList<>();
        }
        this.defects.add(defect);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Drawing)) return false;

        Drawing drawing = (Drawing) o;

        if (drawingId != null ? !drawingId.equals(drawing.drawingId) : drawing.drawingId != null) return false;
        return drawingUrl.equals(drawing.drawingUrl);
    }

    @Override
    public int hashCode() {
        int result = drawingId != null ? drawingId.hashCode() : 0;
        result = 31 * result + drawingUrl.hashCode();
        return result;
    }
}
