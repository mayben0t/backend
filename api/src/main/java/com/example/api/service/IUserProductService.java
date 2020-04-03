package com.example.api.service;

import com.example.api.model.UserProduct;

import java.util.List;

public interface IUserProductService {
    List<UserProduct> getAll();

    List<UserProduct> getAllByPage(Integer start,Integer size);

    Integer getAllCount();
}
