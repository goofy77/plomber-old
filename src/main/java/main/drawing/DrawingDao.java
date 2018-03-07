package main.drawing;

import com.mongodb.BasicDBObject;
import com.mongodb.WriteResult;
import main.generics.EntityDeleted;
import main.generics.GenericDao;
import main.models.Drawing;
import main.models.Project;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class DrawingDao extends GenericDao<Drawing> {

    public DrawingDao() {
        super(Drawing.class);
    }

    public EntityDeleted deleteDrawingByProjectId(String projectId, String drawingId){
        Query query = Query.query(Criteria
                .where("drawings")
                .elemMatch(Criteria.where("_id").is(new ObjectId(drawingId)))
                .and("_id").is(projectId));
        Update update = new Update().pull("drawings", new BasicDBObject("_id", drawingId));
        WriteResult writeResult = mongoTemplate.updateMulti(query, update, Project.class);
        return new EntityDeleted(writeResult.getN() > 0);
    }

    public Optional<Drawing> getDrawing(String drawingId){
        Query query = Query.query(Criteria
                .where("drawings")
                .elemMatch(Criteria.where("_id").is(new ObjectId(drawingId))));
        Project project = mongoTemplate.findOne(query, Project.class);
        return project.getDrawingById(drawingId);
    }
}