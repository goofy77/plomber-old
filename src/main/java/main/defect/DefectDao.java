package main.defect;

import main.generics.GenericDao;
import main.models.Defect;

public class DefectDao extends GenericDao<Defect> {

    public DefectDao() {
        super(Defect.class);
    }


}
