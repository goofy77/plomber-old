package main.defect;

import main.project.commands.UpdateProjectCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/project/{projectId}/drawing/{drawingId}/defect")
public class CreateDefectController {

    private final DefectCreatorService defectService;

    @Autowired
    public CreateDefectController(DefectCreatorService defectService) {
        this.defectService = defectService;
    }

    @PostMapping
    public UpdateProjectCommand createDefect(@RequestPart MultipartFile file, @RequestPart CreateDefectCommand command, @PathVariable String projectId, @PathVariable String drawingId) throws IOException {
        return defectService.addDefect(file, command, projectId, drawingId);
    }
}
