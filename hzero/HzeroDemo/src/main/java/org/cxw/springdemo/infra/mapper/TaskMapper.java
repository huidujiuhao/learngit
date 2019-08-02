package org.cxw.springdemo.infra.mapper;

import io.choerodon.mybatis.common.BaseMapper;
import org.cxw.springdemo.domain.entity.Task;

import java.util.List;

/**
 * TaskMapper
 */
public interface TaskMapper extends BaseMapper<Task> {
    /**
     * 查询任务
     * @parem params 任务查询参数
     * @return Task
     */
    List<Task> selectTask(Task params);
}
