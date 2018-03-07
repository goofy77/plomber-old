package main.drawing.get;

import main.drawing.DrawingDao;
import main.exceptions.EntityNotFoundException;
import main.models.Drawing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetDrawingService {

    private final DrawingDao drawingDao;

    @Autowired
    public GetDrawingService(DrawingDao drawingDao) {
        this.drawingDao = drawingDao;
    }

    GetDrawingCommand getDrawing(String drawingId){
        Drawing drawing = drawingDao.getDrawing(drawingId).orElseThrow(EntityNotFoundException::new);
        return new GetDrawingCommand(drawing);
    }
}
