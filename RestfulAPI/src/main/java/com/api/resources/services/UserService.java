package com.api.resources.services;

import com.api.resources.entities.User;
import com.api.resources.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User login(String name) {
        List<User> users = findAll();
        User currentUser = null;
        for (User user : users) {
            if (user.getName().equals(name)){
                currentUser = user;
            }
        }
        if (currentUser != null) {
            currentUser.setLogedIn(true);
            userRepository.save(currentUser); // update
            return currentUser;
        } else
            return null;
    }

    @Override
    public User me() {
        List<User> users = findAll();
        for (User user : users) {
            if (user.isLogedIn() == true) {
                return login(user.getName());
            }
        }

        return null;
    }

    @Override
    public void forgotPassword() {

    }

    @Override
    public void signUp() {

    }
}
