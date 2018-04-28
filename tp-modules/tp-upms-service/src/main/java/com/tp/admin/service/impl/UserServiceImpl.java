package com.tp.admin.service.impl;

import com.tp.admin.entity.User;
import com.tp.admin.mapper.UserMapper;
import com.tp.admin.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author tp
 * @since 2018-04-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> listUsers() {
        User user  = new User();
        user.setIdUser("1");
        List<User> users = new ArrayList<>();
        users.add(userMapper.selectOne(user));
        return users;
    }
}
