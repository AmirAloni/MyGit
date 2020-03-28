package mygit.api;

import java.util.List;
import javax.annotation.Resource;

import mygit.entity.User;
import mygit.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/postgressApp")
public class UserDBController {
    @Resource
    UserService userService;
    @GetMapping(value = "/usersList")
    public List<User> getUsers() {
        return userService.findAll();
    }
    @PostMapping(value = "/createUser")
    public void createEmployee(@RequestBody User user) {
        userService.insertUser(user);
    }
    @PutMapping(value = "/updateUser")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }
    @PutMapping(value = "/executeUpdateUser")
    public void executeUpdateUser(@RequestBody User user) {
        userService.executeUpdateUser(user);
    }
    @DeleteMapping(value = "/deleteUserById")
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }
}
