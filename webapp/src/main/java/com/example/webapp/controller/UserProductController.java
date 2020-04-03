package com.example.webapp.controller;

import com.example.api.dto.PageDTO;
import com.example.api.dto.ResultDTO;
import com.example.api.model.UserProduct;
import com.example.api.service.IUserProductService;
import com.example.webapp.service.UserProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("userProduct控制器类")
@RestController
@RequestMapping(value = "/userProduct")
public class UserProductController {
    @Autowired
    private IUserProductService userProductService;

    @GetMapping("/findAll")
    public ResultDTO findAll(){
        return new ResultDTO(0,userProductService.getAll());
    }

    @GetMapping("/getAll")
    public ResultDTO getAll(@RequestParam(value = "page",required=false,defaultValue = "1")Integer page,
                            @RequestParam (value = "size",defaultValue = "10")Integer size
                            ){
        page = ((page==null)||page<=0)?1:page;
        size = ((size==null)||size<=0)?10:size;

        PageDTO<List<UserProduct>> listPageDTO = new PageDTO<>();
        listPageDTO.setPage(page)
                 .setSize(size)
                 .setResult(new ResultDTO<>(0,userProductService.getAllByPage((page-1)*size,size)))
                 .setCount(userProductService.getAllCount())
                 .setTotalPagesByCount(listPageDTO.getCount());
        return new ResultDTO(0,listPageDTO);
    }
}
