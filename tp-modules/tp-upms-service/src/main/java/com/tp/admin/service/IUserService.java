package com.tp.admin.service;

import com.tp.admin.entity.User;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author tp
 * @since 2018-04-28
 */
public interface IUserService extends IService<User> {
    /**
     * listUsers
     * @return List<User>
     */
    List<User> listUsers();

    /**
     * findByNameAndPassword
     * @param name
     * @param password
     * @return User
     */
    User findByNameAndPassword(String name,String password);
}
