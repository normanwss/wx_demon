package com.example.wc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;

//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    @Qualifier("backendUserDetailsService")
//    private UserDetailsService userDetailsService;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/", "/login", "/wx").permitAll()//根路径和/login路径不拦截
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login") //2登陆页面路径为/login
//                .defaultSuccessUrl("/index") //3登陆成功转向index页面
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//
//    //4在内存中配置两个用户 wyf 和 wisely ,密码和用户名一致,角色是 USER
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
//    }
//
//    //5忽略静态资源的拦截
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resources/static/**");
//    }
//
//}