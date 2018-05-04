package com.tp.admin.service.impl;

import com.tp.admin.controller.UserController;
import com.tp.admin.entity.User;
import com.tp.admin.mapper.UserMapper;
import com.tp.admin.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.tp.common.utils.MD5;
import com.tp.common.utils.SHA1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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

    @Override
    public User findByNameAndPassword(String name, String password) {
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("login_name",name);
        paramMap.put("password", SHA1.convert(password));
        List<User> userList = userMapper.selectByMap(paramMap);
        if (userList != null && userList.size() > 0){
            return userList.get(0);
        }else {
            logger.info("用户名密码不正确");
            return null;
        }
    }
}
