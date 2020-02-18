package com.example.webapp.controller;


import com.example.api.dto.PageDTO;
import com.example.api.dto.ResultDTO;
import com.example.api.model.Book;
import com.example.webapp.service.BookService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/getAll")
    public PageDTO getAll(@RequestParam(value = "page",defaultValue = "1")Integer page,
                          @RequestParam(value = "size",defaultValue = "5")Integer size){
        if(Objects.isNull(page)||Objects.isNull(size)||page<1||size<1){
            return new PageDTO().setResultDTO(new ResultDTO(1,"检查参数",null));
        }
        int count = bookService.getCount();
        return new PageDTO().setPage(page).setSize(size)
                .setCount(count).setTotalPagesByCount(count)
                .setResultDTO(new ResultDTO<>(0,"success",bookService.getAll(page,size)));
    }

    @PostMapping(value = "/insert")
    public ResultDTO insert(Book book){
        if(Objects.isNull(book)|| StringUtils.isEmpty(book.getName())){
            return new ResultDTO(1,"书籍信息为空或书名为空",null);
        }
        int insert = bookService.insert(book);
        if(insert==0){
            return new ResultDTO(1,"插入失败",null);
        }
        return new ResultDTO(0,"插入成功",null);
    }

    @PostMapping(value = "/update")
    public ResultDTO update(Book book){
        if(Objects.isNull(book)||Objects.isNull(book.getId())|| StringUtils.isEmpty(book.getName())){
            return new ResultDTO(1,"书籍id为空或书名为空",null);
        }
        int updateById = bookService.updateById(book);
        if(updateById==0){
            return new ResultDTO(1,"更新失败",null);
        }
        return new ResultDTO(0,"更新成功",null);
    }

    @PostMapping(value = "/delete")
    public ResultDTO update(Integer id){
        if(Objects.isNull(id)){
            return new ResultDTO(1,"id为空",null);
        }
        int del = bookService.delete(id);
        if(del==0){
            return new ResultDTO(1,"删除失败",null);
        }
        return new ResultDTO(0,"删除成功",null);
    }
}
