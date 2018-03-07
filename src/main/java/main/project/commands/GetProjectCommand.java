package main.project.commands;

import main.models.Drawing;
import main.models.Project;

import java.util.Set;

public class GetProjectCommand {

    private String projectId;

    private String userId;

    private Set<Drawing> drawings;

    private String projectName;

    private GetProjectCommand(){}

    public GetProjectCommand(Project project){
        this.projectId = project.getProjectId();
        this.drawings = project.getDrawings();
        this.userId = project.getUserId();
        this.projectName = project.getProjectName();
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

    public String getProjectName() {
        return projectName;
    }
}
