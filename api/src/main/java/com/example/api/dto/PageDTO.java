package com.example.api.dto;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.jws.HandlerChain;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PageDTO<T> {
    private Integer page = 1;
    private Integer size = 10;
    private Integer count;
    private Integer totalPages;
    private ResultDTO<T> result;

    public PageDTO setTotalPagesByCount(int count){
        this.totalPages = count%size ==0 ?count/size:count/size+1;
        return this;
    }

}
