package main.project.commands;

import main.upload.DrawingFile;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

import java.io.IOException;

public class CreateProjectCommand {

    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String drawingName;
    @NotNull
    private DrawingFile drawingFile;

    public CreateProjectCommand( String name, String drawingName, MultipartFile file) throws IOException {
        this.name = name;
        this.drawingName = drawingName;
        this.drawingFile = new DrawingFile(file.getBytes());
    }

    public String getName() {
        return name;
    }

    public String getDrawingName() {
        return drawingName;
    }

    public DrawingFile getDrawingFile() {
        return drawingFile;
    }
}
