package com.atguigu.securitydemo1.entity;


import lombok.Data;
//1.实体类
@Data
public class Users {
    private Integer id;
    private String username;
    private String password;
}
