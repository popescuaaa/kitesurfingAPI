package com.api.resources.services;

import com.api.resources.entities.User;
import org.json.JSONException;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface IUserService {
    List<User> findAll();
    User login(String name, String password);
    User me();
    String forgotPassword(String name) throws JSONException;
    void signUp(String name, String password) throws NoSuchAlgorithmException, NoSuchPaddingException;
    String deleteUser(String name); // just for admin rights on
}
