package main.defect;

import main.drawing.DrawingService;
import main.exceptions.EntityNotFoundException;
import main.models.Defect;
import main.models.Project;
import main.project.ProjectDao;
import main.project.commands.UpdateProjectCommand;
import main.project.update.UpdateProjectService;
import main.upload.DrawingFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DefectCreatorService {

    private final DrawingService drawingService;

    private final UpdateProjectService projectUpdateService;

    private final ProjectDao projectDao;

    @Autowired
    public DefectCreatorService(DrawingService drawingService, UpdateProjectService projectUpdateService, ProjectDao projectDao) {
        this.drawingService = drawingService;
        this.projectUpdateService = projectUpdateService;
        this.projectDao = projectDao;
    }

    UpdateProjectCommand addDefect(MultipartFile file, CreateDefectCommand command, String projectId, String drawingId) throws IOException {
        Project project = projectDao.findOne(projectId).orElseThrow(EntityNotFoundException::new);
        Defect defect = createDefectToAdd(command, file);
        project.getDrawings().stream()
                .filter(drawing -> drawing.getDrawingId().toHexString().equals(drawingId))
                .findFirst()
                .ifPresent(drawing -> drawing.addDefect(defect));
        return projectUpdateService.updateProject(new UpdateProjectCommand(project));
    }

    private Defect createDefectToAdd(CreateDefectCommand command, MultipartFile file) throws IOException {
        String photoUrl = drawingService.saveDrawingToRDs(new DrawingFile(file.getBytes()));
        return new Defect(command.getDescription(), photoUrl, command.getCoordinates(), command.getDefectType());
    }

}
