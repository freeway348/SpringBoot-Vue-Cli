package com.springboot.userserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/*
* configuration:当Spring启动时自动扫描该注解，把该注解标记的类注册到IOC容器中
*/

@Configuration
public class CorsConfig {

    // bean 表示该方法返回的类需要注册到IOC容器中
    @Bean
    public CorsFilter corsFilter(){ // CorsFilter过滤器实现跨域访问，如果使用拦截器来实现跨域访问，则可能出现问题
        // 1. 初始化跨域策略对象，在该对象中设置跨域策略
        CorsConfiguration conf = new CorsConfiguration();
        // 表示允许所有的请求源跨域访问，如：http://localhost:8848
        conf.addAllowedOrigin("*");
        // 允许所有的请求头跨域访问
        conf.addAllowedHeader("*");
        // 允许所有的请求方式跨域，如：POST， GET， PUT， OPTIONS等
        conf.addAllowedMethod("*");


        // 设置哪些url允许使用跨域策略
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", conf); // 允许所有的url路径跨域

        return new CorsFilter(source);
    }

}
