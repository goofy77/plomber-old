package main.project.create;

import main.models.Drawing;
import main.drawing.DrawingService;
import main.models.Project;
import main.project.ProjectDao;
import main.project.commands.CreateProjectCommand;
import main.project.commands.GetProjectCommand;
import main.security.user.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProjectService {

    private final DrawingService pdfDrawingService;

    private final ProjectDao projectDao;

    @Autowired
    public CreateProjectService(DrawingService pdfDrawingService, ProjectDao projectDao) {
        this.pdfDrawingService = pdfDrawingService;
        this.projectDao = projectDao;
    }

    GetProjectCommand save(CreateProjectCommand command){
        String fileUrl = pdfDrawingService.saveDrawingToRDs(command.getDrawingFile());
        Project project = new Project(command.getName(), new Drawing(fileUrl, command.getDrawingName()), CurrentUser.getName());
        projectDao.save(project);
        return new GetProjectCommand(project);
    }
}
