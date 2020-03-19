package mygit.api;

import mygit.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("mygit/api/file")
@RestController
public class FilesController {
    private final WebService service;

    @Autowired
    public FilesController(WebService webService) {
        this.service = webService;
    }

    @PostMapping
    public ResponseEntity GetFileContent(@RequestBody String path) {
        return service.GetFileContent(path);
    }
}

