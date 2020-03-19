package mygit.api;

import mygit.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("mygit/api/user")
@RestController
public class UserController {

    private final WebService service;

    @Autowired
    public UserController(WebService webService) {
        this.service = webService;
    }

    @GetMapping(path = "repositories/{username}")
    public ResponseEntity GetUserRepositories(@PathVariable("username") String username) {
        return service.GetUserRepositories(username);
    }

    @GetMapping(path = "notifications/{username}")
    public ResponseEntity GetNotifications(@PathVariable("username") String username)  {
        return service.GetNotifications(username);
    }
    @GetMapping(path = "users/{username}")
    public ResponseEntity GetOtherUsers(@PathVariable("username") String username) {
        return service.GetOtherUsers(username);
    }


}


