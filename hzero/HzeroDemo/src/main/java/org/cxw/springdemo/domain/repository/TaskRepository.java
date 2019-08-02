package org.cxw.springdemo.domain.repository;

import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.domain.AuditDomain;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.cxw.springdemo.domain.entity.Task;
import org.hzero.mybatis.base.BaseRepository;

import java.util.List;

/**
 * 任务资源库
 */
public interface TaskRepository extends BaseRepository<Task> {
    /**
    * @Description: 分页查询任务
    * @Param:  task Task
     * @Param:  pageRequest 分页参数
    * @return: Page<Task>
    * @Author: xueWu.Chen
    * @Date: 2019/7/30
    */
    Page<Task> pageTask(Task task, PageRequest pageRequest);


    /**
    * @Description: 根据员工ID查询任务
    * @Param: employeeId 员工ID
    * @return: List<Task>
    * @Author: xueWu.Chen
    * @Date: 2019/7/30
    */
    List<Task> selectByEmployeeId(Long employeeId);

    /**
    * @Description: 根据任务编号查询任务详细（包含员工姓名）
    * @Param:  taskNumber 任务编号
    * @return: Task
    * @Author: xueWu.Chen
    * @Date: 2019/7/30
    */

    Task selectDetailByTaskNumber(String taskNumber);
}
