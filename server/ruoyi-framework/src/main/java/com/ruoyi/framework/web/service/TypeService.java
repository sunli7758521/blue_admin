package com.ruoyi.framework.web.service;

import com.ruoyi.integral.domain.IntegralType;
import com.ruoyi.integral.service.IIntegralTypeService;
import com.ruoyi.task.domain.TaskType;
import com.ruoyi.task.service.ITaskTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sun li
 * @Date 2018/12/25 11:40
 * @Description
 */
@Service("task")
public class TypeService {

    @Autowired
    private ITaskTypeService taskTypeService;

    @Autowired
    private IIntegralTypeService integralTypeService;

    /**
     *      查询所有任务类型
     */
    public List<TaskType> getTaskIntegral(){

        return taskTypeService.selectTaskTypeList(new TaskType());
    }

    /**
     *      查询所有积分类型
     */
    public List<IntegralType> getIntegral(){

        return integralTypeService.selectIntegralTypeList(new IntegralType());
    }
}
