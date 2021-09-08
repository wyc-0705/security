package com.atguigu.securitydemo1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
//开启注解，注解已经可以使用
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)//secured PreAuthorize
public class Securitydemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Securitydemo1Application.class, args);
    }

}
