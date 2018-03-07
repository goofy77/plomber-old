package main.download;

import main.upload.FileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileDownloadController
{
    private final FileDao fileDao;

    @Autowired
    public FileDownloadController(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    @GetMapping(value = "/image/{id}")
    public byte[] getFile(@PathVariable String id) {
        return fileDao.findOne(id).getContent();
    }
}
