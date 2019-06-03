
package com.ruoyi.framework.web.service;

import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *  sun li 首创 html调用 thymeleaf 实现字典读取
 * @author sun li
 * @Date 2018/10/27 9:27
 * @Description
 */

@Service("dept")
public class DeptService {

    @Autowired
    private ISysDeptService deptService;


   /**
     * 根据部门类型查询字典数据信息
     *
     * @return 参数键值
     */

    public List<SysDept> getDept()
    {
        return  deptService.selectDeptName();
    }
}
