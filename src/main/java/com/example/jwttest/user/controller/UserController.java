package com.example.jwttest.user.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.jwttest.api.CommonResult;
import com.example.jwttest.basDevice.entity.BasDevice;
import com.example.jwttest.user.entity.User;
import com.example.jwttest.user.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户管理
 * </p>
 *
 * @author lpf
 * @since 2021-09-14
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    IUserService userService;

    /**
     * 登录获取token
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public CommonResult login(String username, String password) {
        String token = userService.login(username, password);
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        if (token.equals("-1")) {
            return CommonResult.validateFailed("账号被禁用");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        return CommonResult.success(tokenMap);
    }
    /**
     * 注册账号
     * @param user
     * @return
     */
    @PostMapping("/register")
    public CommonResult register(User user) {

        int result = userService.register(user);
        if (result == -1) {
            return CommonResult.failed("该账号已注册");
        }
        return CommonResult.success("注册成功");
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PostMapping("/updateUser")
    public CommonResult updateUser(User user) {

        int result = userService.updateUser(user);
        if (result == -1) {
            return CommonResult.failed("修改失败");
        }
        return CommonResult.success("修改成功");
    }


    /**
     * 分页查询用户信息
     * @param pagelimit
     * @param pageSize
     * @param user
     * @return
     */
    @PostMapping("/selectPage")
    public CommonResult selectPage(int pagelimit, int pageSize, User user) {
        Page<User> page =Page.of(pagelimit,pageSize);
        page = userService.selectPage(page,user);
        return CommonResult.success(page);
    }


    /**
     * 登录获取token
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/appLogin")
    public CommonResult appLogin(String username, String password) {
        String token = userService.login(username, password);
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        if (token.equals("-1")) {
            return CommonResult.validateFailed("账号被禁用");
        }
        Map<String, Object> tokenMap = new HashMap<>();
        User user =userService.findUserInfoByUserName(username);
        tokenMap.put("token", token);
        tokenMap.put("userInfo", user);
        return CommonResult.success(tokenMap);
    }




/*
    @GetMapping("/testJwt")
    public CommonResult testJwt() {
        return CommonResult.success("有Token测试成功");
    }

    @GetMapping("/testNoJwt")
    public CommonResult testNoJwt() {
        return CommonResult.success("无Token测试成功");
    }

    @GetMapping("/testPerm")
    public CommonResult testPerm() {
        return CommonResult.success("权限测试成功");
    }*/
}

