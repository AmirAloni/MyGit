package mygit.api;

import mygit.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("mygit/api")
@RestController
public class LoginController {

    private final WebService service;

    @Autowired
    public LoginController(WebService webService) {
        this.service = webService;
    }

    @GetMapping(path = "login/{username}")
    public ResponseEntity Login(@PathVariable("username") String username){
        return service.Login(username);
    }

    @GetMapping(path = "logout/{username}")
    public ResponseEntity Logout(@PathVariable("username") String username){
        return service.Logout(username);
    }

    @PostMapping(path = "signup/{username}")
    public ResponseEntity SignUp(@PathVariable("username") String username){
        return service.SignUp(username);
    }

}
