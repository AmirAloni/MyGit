package mygit.api;

import mygit.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("mygit/api/user/repository")
@RestController
public class RepositoryController {

    private final WebService service;

    @Autowired
    public RepositoryController(WebService webService) {
        this.service = webService;
    }

    @GetMapping(path = "{username}/{repository}")
    public ResponseEntity GetRepositoryData(@PathVariable("username") String username, @PathVariable("repository") String repositoryName) {
        return service.GetRepositoryData(username, repositoryName);
    }

    @PostMapping(path = "{username}/{reponame}")
    public ResponseEntity CreateRepository(@PathVariable("username") String username, @PathVariable("reponame") String repoName) {
        return service.CreateRepository(username, repoName);
    }

    @GetMapping(path = "{username}/{repo}/{commit}")
    public ResponseEntity GetCommitData(@PathVariable("username") String username, @PathVariable("repo") String repoName, @PathVariable("commit") String commitSha1) {
        return service.GetCommitData(username, repoName, commitSha1);
    }

    // @DeleteMapping(path = "{username}/{repo}")
    // public void DeleteCommitToShow(@PathVariable("username") String username, @PathVariable("repo") String repoName) {
    //     Logic logicManager = new Logic(username, "C:\\magit-ex3\\" + username + "\\repositories\\" + repoName + "\\.magit\\commitToShow");
    //     logicManager.deleteFolder(new File(logicManager.getM_ActiveRepository()));
    // }
}




