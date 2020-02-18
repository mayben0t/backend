package com.example.webapp.service;

import com.example.api.model.User;
import com.example.webapp.dao.UserMapper;
import com.example.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("IUserService")
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }
}
