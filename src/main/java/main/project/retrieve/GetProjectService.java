package main.project.retrieve;

import main.exceptions.EntityNotFoundException;
import main.models.Project;
import main.project.ProjectDao;
import main.project.commands.GetProjectCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetProjectService {

    private final ProjectDao projectDao;

    @Autowired
    public GetProjectService(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    List<GetProjectCommand> findAll() {
        List<Project> listOfProjects = projectDao.findAll();
        return listOfProjects.stream()
                .map(GetProjectCommand::new)
                .collect(Collectors.toList());
    }

   public  GetProjectCommand findOne(String projectId) {
        Project project = projectDao.findOne(projectId)
                .orElseThrow(EntityNotFoundException::new);
        return new GetProjectCommand(project);
    }
}
