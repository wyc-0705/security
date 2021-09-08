package com.atguigu.securitydemo1.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("index")
    public String index(){
        return "hello index";
    }

    @GetMapping("update")
    //PostAuthorize 方法执行之后再验证
    //只有具有这些角色的用户才可以访问
    //@Secured({"ROLE_sale","ROLE_manager"})
    //有权限就可以访问
    @PreAuthorize("hasAnyAuthority('admins')")
    public String update(){
        return "hello update";
    }




}
