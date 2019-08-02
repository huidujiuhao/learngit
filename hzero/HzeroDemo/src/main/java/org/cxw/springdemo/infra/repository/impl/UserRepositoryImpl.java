package org.cxw.springdemo.infra.repository.impl;

import org.cxw.springdemo.domain.entity.User;
import org.cxw.springdemo.domain.repository.UserRepository;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;

/**
 * @description: User Repository类的具体实现类
 * @author: xueWu.Chen
 * @create: 2019-07-30
 **/
@Component
public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository {

}
