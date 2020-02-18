package com.example.webapp.service;

import com.example.api.model.Book;
import com.example.webapp.dao.BookMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public int getCount(){
        return bookMapper.getCount();
    }


    public List<Book> getAll(int page,int size){
        int start = (page-1)*size;
        return bookMapper.getAllByPage(start,size);
    }

    public Book findById(Integer id){
        if(Objects.isNull(id)){
           return null;
        }
        return bookMapper.getById(id);
    }

    public int updateById(Book book){
        if(Objects.isNull(book)||Objects.isNull(book.getId())){
            return 0;
        }
        return bookMapper.update(book);
    }

    public int insert(Book book){
        if(Objects.isNull(book)|| StringUtils.isEmpty(book.getName())){
            return 0;
        }
        return bookMapper.insert(book);
    }

    public int delete(Integer id){
        if(Objects.isNull(id)){
            return 0;
        }
        return bookMapper.deleteById(id);
    }
}
