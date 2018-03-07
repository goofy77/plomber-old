package main.project.delete;

import main.generics.EntityDeleted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class DeleteProjectController {

    private final DeleteProjectService projectDeletionService;

    @Autowired
    public DeleteProjectController(DeleteProjectService projectDeletionService) {
        this.projectDeletionService = projectDeletionService;
    }

    @DeleteMapping("{projectId}")
    public EntityDeleted deleteProject(@PathVariable String projectId) {
        return projectDeletionService.deleteProject(projectId);
    }

//    @DeleteMapping("{projectId}/drawing/{drawingId}")
//    public EntityDeleted deleteDrawing(@PathVariable String projectId, @PathVariable String drawingId){
//        return projectDeletionService.deleteDrawing(projectId, drawingId);
//    }
}
