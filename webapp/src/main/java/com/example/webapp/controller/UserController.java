package com.example.webapp.controller;

import com.example.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.api.service.IUserService;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/test")
    public List<User> getAll(){
        return userService.getAll();
    }
}
