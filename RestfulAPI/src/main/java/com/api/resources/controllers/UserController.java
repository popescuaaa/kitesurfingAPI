package com.api.resources.controllers;

import com.api.resources.entities.User;
import com.api.resources.services.IUserService;
import com.api.resources.utils.JSONErrors;
import com.api.resources.utils.JSONHelper;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;


@RestController
@RequestMapping(value = "api")
public class UserController {

    @Autowired
    IUserService iUserService;

    @GetMapping(value = "users/all", produces = "application/json")
    public String findAllUsers() throws JSONException {
        // just names
       return JSONHelper.allUserInSystem(iUserService.findAll()).toString(4);
    }

    @GetMapping(value = "sign/{name}/{password}", produces = "application/json")
    public String signUpUser(@PathVariable(value = "name") String name,
                             @PathVariable(value = "password") String password) throws NoSuchPaddingException,
                                                                                       NoSuchAlgorithmException {
        iUserService.signUp(name,password);
        return "Success!";
    }

    @GetMapping(value = "login/{name}/{password}", produces = "application/json")
    public String logInUser(@PathVariable(value = "name") String name,
                            @PathVariable(value = "password") String password) throws JSONException{
        if (iUserService.login(name, password) != null) {
            return JSONHelper.createJSONObject(iUserService.login(name, password)).toString(4);
        } else {
            return JSONErrors.NO_USER_LOGGED().toString(4);
        }
    }

    @GetMapping(value = "users/me", produces = "application/json")
    public String getPersonalInfo() throws JSONException{
        for (User user : iUserService.findAll()) {
            if (user.isLogedIn()) {
                return JSONHelper.createJSONObject(iUserService.login(user.getName(), user.getPassword())).toString(4);
            } else {
                return JSONErrors.NO_USER_LOGGED().toString(4);
            }
        }

        return null;
    }

    @GetMapping(value = "users/me/forgotPassword/{name}", produces = "application/json")
    public String recoverPassword(@PathVariable(value = "name") String name) throws JSONException {
        return iUserService.forgotPassword(name);
    }

}
