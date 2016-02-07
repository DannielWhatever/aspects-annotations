package com.micaminodelninja.aspectannotations.controller;

import com.micaminodelninja.aspectannotations.aspect.annotations.RequireAuth;
import com.micaminodelninja.aspectannotations.domain.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Daniel on 06-02-2016.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private User user;
    {
        user = new User();
        user.setName("default");
        user.setLastName("default");
        user.setAge(99);
    }

    @RequestMapping(method = RequestMethod.GET)
    public User getUser(){
        return user;
    }

    @RequireAuth
    @RequestMapping(method = RequestMethod.POST)
    public User setUser(@RequestBody User user){
        this.user = user;
        return this.user;
    }

}
