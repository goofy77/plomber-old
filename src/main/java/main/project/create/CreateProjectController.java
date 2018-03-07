package main.project.create;

import main.project.commands.CreateProjectCommand;
import main.project.commands.GetProjectCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/project")
public class CreateProjectController {

    private final CreateProjectService projectCreationService;

    @Autowired
    public CreateProjectController(CreateProjectService projectCreationService) {
        this.projectCreationService = projectCreationService;
    }

    @PostMapping(params = {"name", "drawingName"})
    public GetProjectCommand createsProject(@RequestParam MultipartFile file, String name, String drawingName) throws IOException {
        return projectCreationService.save(new CreateProjectCommand(name, drawingName, file));
    }

}
