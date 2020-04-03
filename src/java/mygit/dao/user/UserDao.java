package mygit.dao;

import mygit.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
}