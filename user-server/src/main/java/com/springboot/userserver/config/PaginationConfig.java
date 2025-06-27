package com.springboot.userserver.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 必须要加该注解，才能加载到IOC容器中，这样才能生效
public class PaginationConfig {

    /*
    * PaginationInterceptor就是一个分页拦截器，会自动在sql语句后添加limit子语句
    *
    *
    */


    @Bean // 表示这是SpringBoot的bean对象
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
