package com.api.resources.services;

import com.api.resources.entities.User;
import com.api.resources.entities.UserType;
import com.api.resources.repositories.UserRepository;
import com.api.resources.utils.Encryptor;
import com.api.resources.utils.JSONHelper;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.jar.JarException;

@Service
public class UserService implements IUserService {
    private String key = "ab412345ab412345"; // 128 bit key
    private String initVector = "RandomInitVector"; // 16 bytes IV

    private
    @Autowired
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
        // place admin on top as active
        this.userRepository.save(new User("ADMIN",
                Encryptor.encrypt(key, initVector, "ADMIN"),
                UserType.ADMIN));

    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User login(String name, String password) {
        List<User> users = findAll();
        String decryptedPassword =  null;
        User currentUser = null;

        // chain verification
        for (User user : users) {
            if (user.getName().equals(name)){
                decryptedPassword = Encryptor.decrypt(key, initVector, user.getPassword());
                if (password.equals(decryptedPassword)) {
                    currentUser = user;
                }
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
            if (user.isLogedIn()) {
                return login(user.getName(), user.getPassword());
            }
        }

        return null;
    }

    @Override
    public String forgotPassword(String name) throws JSONException {
        List<User> users = findAll();
        for (User user : users) {
            if (user.getName().equals(name)){
                return JSONHelper.forgotPassword(Encryptor.decrypt(key,initVector,user.getPassword()))
                        .toString(4);
            } else {
                return "Error!";
            }
        }
        return null;
    }

    @Override
    public void signUp(String name, String password) {
        User user = new User(name, Encryptor.encrypt(key, initVector, password), UserType.USER);
        userRepository.save(user);
    }

    @Override
    public String deleteUser(String name) {
        if (name.equals("ADMIN")){
            List<User> users = findAll();
            for (User user : users) {
                if (user.getName().equals(name)) {
                    userRepository.delete(user);
                }
            }
            return "Success!";
        } else {
            return "No such user!";
        }
    }
}
