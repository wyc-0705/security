package com.atguigu.securitydemo1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//配置类
@Configuration
public class SecurityConfigTest extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Bean
    PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置没有权限跳转自定义页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");
        http.formLogin().loginPage("/login.html")//自定义自己编写的登陆页面
                        .loginProcessingUrl("/user/login")//登录访问的路径
                        .defaultSuccessUrl("/test/index").permitAll()//认证成功后跳转的路径
                        .and().authorizeRequests()
                            .antMatchers("/","/test/hello","/user/login").permitAll()//不需要认证的路径
                            //.antMatchers("/test/index").hasAuthority("admins")//当前登录用户只有admin权限才能访问index
                            //.antMatchers("/test/index").hasAnyAuthority("admins,manager")
                            .antMatchers("/test/index").hasRole("sale")


                        .anyRequest().authenticated()
                        .and().csrf().disable();//关闭csrf防护
    }
}
