package com.example.webapp.dao;


import com.example.api.model.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book>{

}
