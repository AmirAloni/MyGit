
package mygit.api;

import mygit.service.Logic.Logic;
import mygit.service.Logic.Node.CommitNode;
import mygit.service.Logic.Objects.BranchData;
import mygit.service.WebLogic.WebLogic;
import mygit.service.WebLogic.WebObjects.Notification;
import mygit.service.WebLogic.WebObjects.Repository;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@RequestMapping("mygit/api/user/repos")
@RestController
public class RepoController {

    private final WebLogic webLogicService;

    @Autowired
    public RepoController(WebLogic webLogicService) {
        this.webLogicService = webLogicService;
    }

    @GetMapping(path = "{username}/{repo}")
    public List<Object> GetRepoData(@PathVariable("username") String username, @PathVariable("repo") String repoName) throws JSONException {
        Logic logicManager = new Logic(username, "C:\\magit-ex3\\" + username + "\\repositories\\" + repoName);
        List<Object> repository = new ArrayList<>();

        if (webLogicService.userExist(username)) {
            File repoFile = new File("C:\\magit-ex3\\" + username + "\\repositories\\" + repoName);
            Repository repositoryDetails = webLogicService.getRepositoryDetails(repoFile);

            ArrayList<Notification> notificationList = webLogicService.getNotifications(username);
            ArrayList<CommitNode> CommitBranchList = webLogicService.getAllBranchCommits(username, repositoryDetails);
            ArrayList<BranchData> branchData = (ArrayList<BranchData>) logicManager.GetAllBranchesDetails();
            Boolean isPr = Files.exists(Paths.get(logicManager.getPathFolder(".magit"), "PR"));
            Boolean isLr = Files.exists(Paths.get(logicManager.getPathFolder("branches"), "RTB"));

            repository.add(repositoryDetails);
            repository.add(notificationList);
            repository.add(CommitBranchList);
            repository.add(branchData);
            repository.add(isPr);
            repository.add(isLr);
        }
        return repository;
    }

    @DeleteMapping
    public void Delete(){ }

    @PutMapping
    public void  Update(){}
}




