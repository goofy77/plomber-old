package main.models;

import main.project.commands.UpdateProjectCommand;
import org.springframework.data.annotation.Id;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Project {

    @Id
    private String projectId;

    private String userId;

    private Set<Drawing> drawings;

    private String projectName;


    public Project(String name, Drawing drawing, String userId) {
        this.drawings = Stream.of(drawing).collect(Collectors.toSet());
        this.projectName = name;
        this.userId = userId;
    }

    public Project(UpdateProjectCommand command) {
        this.drawings = command.getDrawings();
        this.projectName = command.getProjectName();
        this.userId = command.getUserId();
        this.projectId = command.getProjectId();
    }

    private Project() {
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getUserId() {
        return userId;
    }

    public Set<Drawing> getDrawings() {
        return drawings;
    }

    public void updateDrawings(Drawing drawing) {
        if(this.drawings.contains(drawing)){
            replaceDrawing(drawing);
        }
    }

    private Set<Drawing> replaceDrawing(Drawing drawing){
        this.drawings.remove(drawing);
        this.drawings.add(drawing);
        return this.drawings;
    }

    public Project updatePoject(UpdateProjectCommand command) {
        if(command.getProjectId().equals(this.getProjectId())){
            this.projectName = command.getProjectName();
            this.drawings = command.getDrawings();
        }
        return this;
    }

    public Optional<Drawing> getDrawingById(String drawingId){
        return this.drawings.stream()
                .filter(drawing -> drawing.getDrawingId().toHexString().equals(drawingId))
                .findFirst();
    }
}
