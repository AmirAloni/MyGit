
package mygit.api;

import mygit.service.Logic.Logic;
import mygit.service.WebLogic.WebLogic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;


@RequestMapping("mygit/api/user/repos/repo")
@RestController
public class FetchCommitsController {
    private final WebLogic webLogicService;

    @Autowired
    public FetchCommitsController(WebLogic webLogicService) {
        this.webLogicService = webLogicService;
    }

    @GetMapping(path = "{username}/{repo}/{commit}") //http://localhost:8080/mygit/api/user/{username}/repos/{reponame}
    public String GetCommitData(@PathVariable("username") String username, @PathVariable("repo") String repoName, @PathVariable("commit") String commitSha1) throws JSONException {
        Logic logicManager = new Logic(username, "C:\\magit-ex3\\" + username + "\\repositories\\" + repoName);
        logicManager.spreadCommitToShow(commitSha1);

        return createJsonFiles(username, repoName, logicManager.getRootFolderName()).toString();
    }

    public JSONObject createJsonFiles(String username, String repoName, String rootFolderName) throws JSONException {

        File rootFolder = new File("C:\\magit-ex3\\" + username + "\\repositories\\" + repoName + "\\.magit\\commitToShow\\" + rootFolderName);
        return getJsonDataRec(rootFolder);
    }

    private JSONObject getJsonDataRec(File rootFolder) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", rootFolder.getName());

        if(rootFolder.isFile()){
            jsonObject.put("path", rootFolder.getAbsolutePath());
            return jsonObject;
        }

        if(rootFolder.isDirectory()){
            JSONArray jsonArray = new JSONArray();
            for(File file : rootFolder.listFiles()){
                jsonArray.put(getJsonDataRec(file));
            }
            jsonObject.put("toggled", true);
            jsonObject.put("children", jsonArray);
            return jsonObject;
        }

         return null;
    }

    @DeleteMapping(path = "{username}/{repo}")
    public void DeleteCommitToShow(@PathVariable("username") String username, @PathVariable("repo") String repoName) {
        Logic logicManager = new Logic(username, "C:\\magit-ex3\\" + username + "\\repositories\\" + repoName + "\\.magit\\commitToShow");
        logicManager.deleteFolder(new File(logicManager.getM_ActiveRepository()));
    }

    @PutMapping
    public void  Update(){}
}
