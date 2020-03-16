package mygit.api;

import mygit.service.WebLogic.WebLogic;
import mygit.service.WebLogic.WebObjects.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("mygit/api/user/users")
@RestController
public class OtherUsersController {

    private final WebLogic webLogicService;

    @Autowired
    public OtherUsersController(WebLogic webLogicService) {
        this.webLogicService = webLogicService;
    }

    @GetMapping(path = "{username}")
    public List<String> GetOtherUsers(@PathVariable("username") String username) {

        if(webLogicService.userExist(username)){
            return webLogicService.getUsers(username);
        }
        else {
            return null;
        }
    }

    @GetMapping(path = "{username}/{otheruser}")
    public List<Repository> GetOtherUsers(@PathVariable("username") String username, @PathVariable("otheruser") String otherUserName) {

        if(webLogicService.userExist(username)){
            return webLogicService.getUserRepositories(otherUserName);
        }
        else {
            return null;
        }
    }


    @DeleteMapping
    public void Delete(){ }

    @PutMapping
    public void  Update(){}

}

