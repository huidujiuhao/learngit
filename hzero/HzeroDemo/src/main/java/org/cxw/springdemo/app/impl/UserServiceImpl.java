package org.cxw.springdemo.app.impl;

import io.choerodon.core.exception.CommonException;
import org.cxw.springdemo.app.service.UserService;
import org.cxw.springdemo.domain.entity.Task;
import org.cxw.springdemo.domain.entity.User;
import org.cxw.springdemo.domain.repository.TaskRepository;
import org.cxw.springdemo.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @description: User的业务操作实现类
 * @author: xueWu.Chen
 * @create: 2019-07-30
 **/
@Service
public class UserServiceImpl implements UserService {

    private final TaskRepository taskRepository;

    private final UserRepository userRepository;

    public UserServiceImpl(TaskRepository taskRepository,UserRepository userRepository){
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }
    /**
     * @param user
     * @Description: 创建用户
     * @Param: user User
     * @return: User
     * @Author: xueWu.Chen
     * @Date: 2019/7/30
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public User create(User user) {
        userRepository.insert(user);
        return user;
    }

    /**
     * @param userId
     * @Description: 删除用户（同时删除任务）
     * @Param: userId  用户ID
     * @return:
     * @Author: xueWu.Chen
     * @Date: 2019/7/30
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long userId) {
        User exist = userRepository.selectByPrimaryKey(userId);
        if(exist == null){
            throw new CommonException("htdo.warn.user.notFound");
        }
        //删除用户
        userRepository.deleteByPrimaryKey(userId);
        //删除与用户关联的任务
        List<Task> tasks = taskRepository.selectByEmployeeId(userId);
        if(CollectionUtils.isEmpty(tasks)){
            taskRepository.batchDelete(tasks);
        }
    }
}
