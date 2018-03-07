package main.project.retrieve;

import main.project.commands.GetProjectCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/project")
public class GetProjectController {

    private final GetProjectService getProjectService;

    @Autowired
    public GetProjectController(GetProjectService getProjectService) {
        this.getProjectService = getProjectService;
    }

    @GetMapping("/all")
    public List<GetProjectCommand> getAllProjects(){
        return getProjectService.findAll();
    }

    @GetMapping("/{projectId}")
    public GetProjectCommand getProject(@PathVariable String projectId){
        return getProjectService.findOne(projectId);
    }

}
