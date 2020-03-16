
package mygit.api;

import mygit.service.Logic.Logic;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;


@RequestMapping("mygit/api/file")
@RestController
public class FileContentController {
    private final Logic logicManager;

    @Autowired
    public FileContentController(Logic logicManager) {
        this.logicManager = logicManager;
    }

    @PostMapping
    public String GetFileContent(@RequestBody String filePath) throws JSONException {
       JSONObject jsonObject = new JSONObject();
       jsonObject.put("content",logicManager.getContentOfFile(new File(filePath)));
       return jsonObject.toString();
    }

    @DeleteMapping
    public void Delete(){ }

    @PutMapping
    public void  Update(){}
}

