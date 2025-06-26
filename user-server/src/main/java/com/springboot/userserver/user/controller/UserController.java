package com.springboot.userserver.user.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.userserver.user.dto.LoginUser;
import com.springboot.userserver.user.dto.QueryUser;
import com.springboot.userserver.user.entity.User;
import com.springboot.userserver.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 *  controller，service注释：标记注释，spring在启动前通过自动装配扫描标记注解，将带有该类注解的类加载到IOC容器中
 *
 *  需要做接口定义
 *  以登录为例：
 *  url：由域名+接口路径组成；  域名：http://localhost:8088，接口路径：/user/login
 *  url:"http://localhost:8088/user/login"
 *  method(请求类型)： POST          GET请求一般做查询，POST请求一般在数据提交时使用
 *  params：{     请求参数，可选
 *      "username":"admin",
 *      "password":"123456"
 *  }
 *  response：{
 *      "code":200,          表示一个状态码： 200 --- 成功； 500 ------- 失败
 *      "msg":"登录成功"        msg用于信息提示： 登录成功； 用户名/密码错误
 *      "data":{}              可选，如果需要返回数据，则将数据存在该字段中
 *  }
 * </p>
 *
 * RequestMapping： 定义url路径的注解，分为两种，分别是类和方法的定义；    类------url路径的公共部分，方法------具体某个接口的路径，完整url路径=类路径+方法路径
 *
 * @author sdx2009
 * @since 2025-06-23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource // 做依赖注入，从SpringbootIOC容器中取对象
    private UserService userService; // 取的对象及对应的变量即为该行

    // @RequestMapping(value = "/login", method = RequestMethod.POST) // 两个RequestMapping组成类和方法的url路径之和
    // 写法太麻烦了，以下用另一种写法来实现相同功能
    @PostMapping("/login")
    public JSONObject login(@RequestBody LoginUser loginUser){ // @RequestBody用在POST请求上，只解析json格式的请求参数，将json数据转换成LoginUser对象
        // 1. 将请求参数LoginUser转发给service层处理
        boolean result = userService.loginUser(loginUser); // 返回是否登陆成功的结果

        // 2. 获取处理结果，返回给前端
        JSONObject obj = new JSONObject();

        if (result){
            obj.put("code", 200);
            obj.put("msg", "登陆成功");
        }else{
            obj.put("code", 500);
            obj.put("msg", "用户名或密码错误");
        }

        return obj;
    }

    @GetMapping("/page")
    public JSONObject page(QueryUser queryUser){

        // 1. 将请求参数转发给service处理
        Page<User> result = userService.pageUser(queryUser);

        // 2. 获取处理结果，返回给前端
        // 如果获取值result为空，则返回给前端也没有影响，不会出现页面为空的情况
        JSONObject obj = new JSONObject();
        obj.put("code", 200);
        obj.put("rows", result.getRecords()); // Records存储的是查询到的数据链表；而getTotal()存储的是查询到的数据总数
        obj.put("total", result.getTotal());


        return obj;
    }

    @PostMapping("/add")
    public JSONObject add(@RequestBody User user){ // 原本是不允许使用/entity下的实体类对象的（不符合开发规范），因为实体类一般不修改其字段，但前端传过来的数据不一定与该实体类的对象一致，所以可能更改实体类（但这样做会导致实体类无法与数据库中数据进行配对），所以一般不使用实体类

        boolean result = userService.save(user); // 使用mybatis-plus中的save方法，将前端传入的数据存到数据表中，并返回结果（是否成功）


        JSONObject obj = new JSONObject();

        if (result){ // 保存数据成功
            obj.put("code", 200);
            obj.put("msg", "添加用户成功");
        }else {
            obj.put("code", 500);
            obj.put("msg", "添加用户失败");
        }
        return obj;
    }

    @PostMapping("/update")
    public JSONObject update(@RequestBody User user){
        boolean result = userService.updateById(user); // mybatis-plus的方法，在单表中mybatis-plus比mybatis方便，但在多表中这俩差不多
        // 使用预加载，将数据预先存储到redis中，比用mysql语句查询的实时性会更好，适合在实时性要求高时使用
        JSONObject obj = new JSONObject();
        if (result){
            obj.put("code", 200);
            obj.put("msg", "修改用户成功");
        }else {
            obj.put("code", 500);
            obj.put("msg", "修改用户失败");
        }

        return obj;
    }


}
