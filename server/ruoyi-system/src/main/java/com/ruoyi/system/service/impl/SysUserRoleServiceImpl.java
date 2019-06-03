package com.ruoyi.system.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.support.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysRoleDept;
import com.ruoyi.system.domain.SysRoleMenu;
import com.ruoyi.system.mapper.SysRoleDeptMapper;
import com.ruoyi.system.mapper.SysRoleMapper;
import com.ruoyi.system.mapper.SysRoleMenuMapper;
import com.ruoyi.system.mapper.SysUserRoleMapper;
import com.ruoyi.system.service.ISysRoleService;
import com.ruoyi.system.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 角色 业务层处理
 * 
 * @author ruoyi
 */
@Service
public class SysUserRoleServiceImpl implements ISysUserRoleService
{

    @Autowired
    private SysUserRoleMapper userRoleMapper;


    @Override
    public int insertSysUserRole(Long userId, SysRole sysRole)
    {

        System.out.println(userId+"我的 用户id 值 看到拿回来了没呀");
        Long roleId =sysRole.getRoleId();
        System.out.println( roleId+"我的角色id值 有没啊啊？？、");
       /* levelAss.setCarateTime(DateUtils.getNowDate());*/
        return userRoleMapper.insertSysUserRole(userId,roleId);
    }
}
