package main.project.update;

import main.exceptions.EntityNotFoundException;
import main.models.Drawing;
import main.models.Project;
import main.project.ProjectDao;
import main.project.commands.UpdateProjectCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProjectService {

    private final ProjectDao projectDao;

    @Autowired
    public UpdateProjectService(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    UpdateProjectCommand updateProjectDrawing(String projectId, Drawing drawing){
        Project project = projectDao.findOne(projectId).orElseThrow(EntityNotFoundException::new);
        project.updateDrawings(drawing);
        projectDao.save(project);
        return new UpdateProjectCommand(project);
    }

    //todo wtf?
    public UpdateProjectCommand updateProject(UpdateProjectCommand command) {
        projectDao.save(new Project(command));
        return new UpdateProjectCommand(new Project(command));
    }
}
