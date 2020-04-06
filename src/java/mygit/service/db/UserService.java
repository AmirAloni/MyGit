package mygit.service;

import mygit.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void insertUser(User emp);

    void updateUser(User emp);

    void deleteUser(User emp);

}