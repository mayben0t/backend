package com.example.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;

/**
 drop table if exists tb_book;
 create table tb_book(
 id int(11) auto_increment primary key,
 name varchar(20) not null comment '图书名',
 author varchar(20)  comment '作者',
 publish varchar(50) comment '出版社',
 pages int(11) comment '总页数',
 price decimal(11,2) comment '价格',
 is_deleted tinyint(1) default '0' comment '是否删除',
 create_time datetime default now() comment '创建时间',
 create_user VARCHAR(20) comment '创建人',
 update_time datetime  comment '修改时间',
 update_user VARCHAR(20) comment '修改人',
 ts timestamp on update current_timestamp comment '时间戳'
 )
 engine = Innodb default charset=utf8mb4



 **/

@Data
public class Book {
    private Integer id;
    private String name;
    private String author;
    private String publish;
    private Integer pages = 0;
    private BigDecimal price;
    private boolean isDeleted = false;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;
}
