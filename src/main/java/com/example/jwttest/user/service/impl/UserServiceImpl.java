package com.example.jwttest.user.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.jwttest.basPoint.entity.BasPoint;
import com.example.jwttest.user.entity.MyUserDetails;
import com.example.jwttest.user.entity.User;
import com.example.jwttest.user.mapper.UserMapper;
import com.example.jwttest.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.jwttest.utils.JwtTokenUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lpf
 * @since 2021-09-14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    UserDetailsService userDetailsService;
    @Resource
    JwtTokenUtil jwtTokenUtil;
    @Resource
    PasswordEncoder passwordEncoder;

    @Override
    public Page<User> getList(Page<User> page, Wrapper<User> queryWrapper) {
        Page<User> userPage = baseMapper.selectPage(page, queryWrapper);
        List<User> list = userPage.getRecords();
        userPage.setRecords(list);
        return userPage;
    }


    @Override
    public String login(String username, String password) {
        MyUserDetails userDetails = (MyUserDetails) userDetailsService.loadUserByUsername(username);
        if (userDetails != null) {
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                return null;
            }
            if (!userDetails.isEnabled()) {
                return "-1";
            }
            return jwtTokenUtil.generateToken(userDetails);
        }
        return null;
    }

    @Override
    public int register(User user) {
        if (query().eq("username", user.getUsername()).one() != null) {
            return -1;//已注册
        }
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        save(user);
        return 0;
    }

    @Override
    public int updateUser(User user) {
        if (query().eq("id", user.getId()).one() == null) {
            return -1;//用户不存在
        }
        if(user.getPassword()!=null){
            String encodePassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodePassword);
        }
        updateById(user);
        return 0;
    }

    @Override
    public Page<User> selectPage(Page<User> page, User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(org.springframework.util.StringUtils.hasText(user.getUsername()),"username",user.getUsername());
        if (user.getStatus() != null){
            queryWrapper.eq("status",user.getStatus());
        }
        queryWrapper.eq(StringUtils.hasText(user.getNickname()),"nickname",user.getNickname());
        return page(page,queryWrapper);
    }

    @Override
    public User findUserInfoByUserName(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(org.springframework.util.StringUtils.hasText(username),"username",username);
        return getOne(queryWrapper);
    }

}
