package mygit.api;

import mygit.service.WebLogic.WebLogic;
import mygit.service.WebLogic.WebObjects.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("mygit/api/user")
@RestController
public class UserController {

    private final WebLogic webLogicService;

    @Autowired
    public UserController(WebLogic webLogicService) {
        this.webLogicService = webLogicService;
    }

    @GetMapping(path = "{username}")
    public List<Repository> GetUserData(@PathVariable("username") String username) {

        if(webLogicService.userExist(username)){
            List<Repository> repositoriesList = webLogicService.getUserRepositories(username);
            return repositoriesList;
        }
        else {
            return null;
        }
    }

    @DeleteMapping
    public void Delete(){ }

    @PutMapping
    public void Update(){}

}


