package main.drawing;

import main.upload.DrawingFile;
import main.upload.FileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrawingService {

    private final FileDao pdfDrawingDao;

    @Autowired
    public DrawingService(FileDao pdfDrawingDao) {
        this.pdfDrawingDao = pdfDrawingDao;
    }

    public String saveDrawingToRDs(DrawingFile file){
        DrawingFile fileUrl = pdfDrawingDao.save(file);
        return String.valueOf(fileUrl.getPdfDrawingId());
    }

}
