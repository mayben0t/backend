package com.example.webapp.dao;

import com.example.api.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper{
    List<User> getAll();
}