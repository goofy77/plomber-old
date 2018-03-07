package main.project;

import main.generics.GenericDao;
import main.models.Project;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDao extends GenericDao<Project> {

    public ProjectDao() {
        super(Project.class);
    }



}
