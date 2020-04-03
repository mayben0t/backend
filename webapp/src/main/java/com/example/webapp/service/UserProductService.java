package com.example.webapp.service;

import com.example.api.model.UserProduct;
import com.example.api.service.IUserProductService;
import com.example.webapp.dao.UserProductMapper;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProductService implements IUserProductService {
    @Autowired
    private UserProductMapper userProductMapper;

    @Override
    public List<UserProduct> getAll() {

        return userProductMapper.getAll();
    }

    @Override
    public List<UserProduct> getAllByPage(Integer start,Integer size) {
        Preconditions.checkNotNull(start,"开始页码不能为空");
        Preconditions.checkNotNull(size,"页码不能为空");
        Preconditions.checkArgument(start>=0);
        Preconditions.checkArgument(size>0);

        return userProductMapper.getAllByPage(start,size);
    }

    @Override
    public Integer getAllCount() {
        return userProductMapper.getCount();
    }
}
