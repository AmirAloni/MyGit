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

    @PostMapping(path = "update")
    public ResponseEntity updateFileContent(@RequestBody String pathContent) {
        String path = pathContent.split("~")[0];
        String content = pathContent.split("~")[1];
        return service.updateFileContent(path, content);
    }
}

