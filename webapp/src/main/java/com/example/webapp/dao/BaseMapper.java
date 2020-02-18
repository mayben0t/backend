package com.example.webapp.dao;

import java.util.List;

public interface BaseMapper<T> {
    List<T> getAll();

    List<T> getAllByPage(int start,int size);

    int getCount();

    T getById(Integer id);

    int insert(T body);

    int deleteById(Integer id);

    int update(T body);
}
