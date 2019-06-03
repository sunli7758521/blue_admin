package com.ruoyi.framework.web.service;

import com.ruoyi.integral.service.IIntegralJkService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sun li
 * @Date 2018/10/30 9:31
 * @Description
 */
@Service("jkName")
public class JkService {

    @Autowired
    private IIntegralJkService jkService;

    @Autowired
    private SysUserMapper userMapper;

    /**
     *  查询所有员工
     *
     * @return 参数键值
     */
    public List<SysUser> getJkName()
    {
        return  userMapper.getUserName();
    }
}
