package com.example.webapp.dao;

import com.example.api.model.UserProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserProductMapper extends BaseMapper<UserProduct>{

    int insertSelective(UserProduct record);

    void insertBatch(@Param("list") List<UserProduct> body);

    UserProduct selectByUserIdAndDesc(Integer userId, String desc);

    int update(UserProduct userProduct);

    int updateByUserId(UserProduct userProduct);
}