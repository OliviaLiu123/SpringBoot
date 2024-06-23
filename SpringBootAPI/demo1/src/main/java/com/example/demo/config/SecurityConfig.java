package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/home").permitAll()// 允许所有人访问首页和home
                .anyRequest().authenticated()//其他请求都需要认证
                .and()
                .formLogin()
                .loginPage("/login")//登录页面
                .permitAll()//允许所有人登录页面
                .and()
                .logout()
                .permitAll();//允许所有人注销
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()//使用内存中的用户存储，时间开发中建议使用数据库
                .withUser("user")
                .password("(noop)password")// 注意：这里使用了noop前缀，表示密码不进行加密处理
                .roles("USER");
    }
}
