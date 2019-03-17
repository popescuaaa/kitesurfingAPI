package com.api.resources.services;

import com.api.resources.entities.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User login(String name);
    User me();
    void forgotPassword();
    void signUp();
}
