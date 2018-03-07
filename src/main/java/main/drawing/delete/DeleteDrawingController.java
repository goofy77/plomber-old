package main.drawing.delete;

import main.generics.EntityDeleted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project/{projectId}/drawing/{drawingId}")
public class DeleteDrawingController {

    private final DeleteDrawingService drawingService;

    @Autowired
    public DeleteDrawingController(DeleteDrawingService drawingService) {
        this.drawingService = drawingService;
    }

    @DeleteMapping
    public EntityDeleted deleteDrawing(@PathVariable String projectId, @PathVariable String drawingId){
        return drawingService.deleteDrawing(projectId, drawingId);
    }
}
