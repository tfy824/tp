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
    List<User> listUsers();
}
