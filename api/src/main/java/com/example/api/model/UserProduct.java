package com.example.api.model;

import lombok.Data;

import java.util.Date;
@Data
public class UserProduct {
    private Long id;

    private Integer userId;

    private String desc;

    private Date ts;
}