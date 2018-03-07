package main.project.update;

import main.models.Drawing;
import main.project.commands.UpdateProjectCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class UpdateProjectController {

    private final UpdateProjectService projectUpdateService;

    @Autowired
    public UpdateProjectController(UpdateProjectService projectUpdateService) {
        this.projectUpdateService = projectUpdateService;
    }

    @PutMapping("/{projectId}/drawing")
    public UpdateProjectCommand changeRotation(@PathVariable String projectId, @RequestBody Drawing drawing){
        return projectUpdateService.updateProjectDrawing(projectId, drawing);
    }

    @PutMapping()
    public UpdateProjectCommand updateProject(@RequestBody UpdateProjectCommand project){
        return projectUpdateService.updateProject(project);
    }
}
