package main.drawing.get;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project/drawing/{drawingId}")
public class GetDrawingController {

    private final GetDrawingService getDrawingService;

    @Autowired
    public GetDrawingController(GetDrawingService getDrawingService) {
        this.getDrawingService = getDrawingService;
    }

    @GetMapping
    public GetDrawingCommand getDrawing(@PathVariable String drawingId){
        return getDrawingService.getDrawing(drawingId);
    }
}
