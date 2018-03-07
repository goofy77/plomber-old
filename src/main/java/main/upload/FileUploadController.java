package main.upload;

import main.drawing.DrawingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileUploadController {

    private final DrawingService pdfDrawingService;

    @Autowired
    public FileUploadController(DrawingService pdfDrawingService) {
        this.pdfDrawingService = pdfDrawingService;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public DrawingUrl handleFileUpload(@RequestParam MultipartFile file) throws IOException {
        DrawingFile pdfDrawing = new DrawingFile(file.getBytes());
        return new DrawingUrl(pdfDrawingService.saveDrawingToRDs(pdfDrawing));
    }
}
