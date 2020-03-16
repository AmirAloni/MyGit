package mygit.api;

import mygit.service.Logic.Logic;
import mygit.service.WebLogic.WebLogic;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("mygit/api/user/repo/new")
@RestController
public class NewRepositoryController {

    private final WebLogic webLogicService;

    @Autowired
    public NewRepositoryController(WebLogic webLogicService) {
        this.webLogicService = webLogicService;
    }

    @GetMapping(path = "{username}/{reponame}")
    public Boolean GetNotifications(@PathVariable("username") String username, @PathVariable("reponame") String repoName) throws JSONException {

        if(webLogicService.userExist(username)){
            Logic logic = new Logic(username, repoName);
            if(logic.initRepository(repoName)){
                return true;
            }
        }
        return false;
    }

    @DeleteMapping
    public void Delete(){ }

    @PutMapping
    public void  Update(){}

}
