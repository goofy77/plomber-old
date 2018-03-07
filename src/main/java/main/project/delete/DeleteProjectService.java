package main.project.delete;

import main.generics.EntityDeleted;
import main.project.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProjectService {

    private final ProjectDao projectDao;

    @Autowired
    public DeleteProjectService(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    EntityDeleted deleteProject(String projectId){
        return projectDao.remove(projectId);
    }

//    EntityDeleted deleteDrawing(String projectId, String drawingId) {
//        return drawingDao.deleteDrawingByProjectId(projectId, drawingId);
//    }
}
