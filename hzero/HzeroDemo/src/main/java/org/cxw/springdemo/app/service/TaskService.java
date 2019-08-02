package org.cxw.springdemo.app.service;

import org.cxw.springdemo.domain.entity.Task;
import org.springframework.stereotype.Service;

/**
 * 任务应用服务
 */
public interface TaskService {
    /**
    * @Description: 创建任务
    * @Param: task 任务
    * @return: Task
    * @Author: xueWu.Chen
    * @Date: 2019/7/30
    */
    Task create(Task task);

    /**
    * @Description: 更新任务
    * @Param: task 任务
    * @return: Task
    * @Author: xueWu.Chen
    * @Date: 2019/7/30
    */
    Task update(Task task);

    /**
    * @Description: 根据任务编号删除任务
    * @Param: taskNumber  任务编号
    * @return:
    * @Author: xueWu.Chen
    * @Date: 2019/7/30
    */

    void deleteByTaskNumber(String taskNumber);
}
