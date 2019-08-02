package org.cxw.springdemo.app.service;

import org.cxw.springdemo.domain.entity.User;

/**
 * 用户应用服务
 */
public interface UserService {
    /**
    * @Description: 创建用户
    * @Param: user User
    * @return:  User
    * @Author: xueWu.Chen
    * @Date: 2019/7/30
    */
    User create(User user);

    /**
    * @Description: 删除用户（同时删除任务）
    * @Param: userId  用户ID
    * @return:
    * @Author: xueWu.Chen
    * @Date: 2019/7/30
    */
    void delete(Long userId);

}
