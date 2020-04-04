package com.example.api.service;

import com.example.api.model.UserProduct;

import java.util.List;

public interface IUserProductService {
    List<UserProduct> getAll();

    List<UserProduct> getAllByPage(Integer start,Integer size);

    Integer getAllCount();

    void insert(UserProduct userProduct);

    UserProduct selectByUserIdAndDesc(Integer userId, String desc);
}
