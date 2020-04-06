package mygit.service;

import java.util.List;
import javax.annotation.Resource;
import mygit.dao.user.UserDao;
import mygit.entity.User;
import org.springframework.stereotype.Component;


@Component
public class UserServiceImp implements UserService{
    @Resource
    UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
}