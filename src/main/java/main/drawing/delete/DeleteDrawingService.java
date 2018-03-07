package main.drawing.delete;

import main.drawing.DrawingDao;
import main.generics.EntityDeleted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteDrawingService {

    private final DrawingDao drawingDao;

    @Autowired
    public DeleteDrawingService(DrawingDao drawingDao) {
        this.drawingDao = drawingDao;
    }

    EntityDeleted deleteDrawing(String projectId, String drawingId) {
        return drawingDao.deleteDrawingByProjectId(projectId, drawingId);
    }
}
