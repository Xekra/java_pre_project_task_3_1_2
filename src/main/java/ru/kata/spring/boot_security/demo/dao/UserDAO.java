package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDAO {

    void createUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    List<User> getAllUsers();
}
