package com.example.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Delegate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDTO<T> {
    private Integer code = 0;
    private String msg;
    private T body;


    public ResultDTO(Integer code, T body) {
        this.code = code;
        this.body = body;
    }
}
