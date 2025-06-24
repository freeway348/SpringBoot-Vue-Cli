package com.springboot.userserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 */
// 扫描指定的包路径下的所有@Mapper接口，加载到IOC容器中
@MapperScan(basePackages = "com.springboot.userserver.*.mapper") // 扫描哪些包路径下的@Mapper
@SpringBootApplication
public class UserServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(UserServerApplication.class, args);
    }

}
