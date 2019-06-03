package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.SysPost;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.mapper.SysUserPostMapper;
import com.ruoyi.system.mapper.SysUserRoleMapper;
import com.ruoyi.system.service.ISysUserPostService;
import com.ruoyi.system.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 角色 业务层处理
 * 
 * @author ruoyi
 */
@Service
public class SysUserPostServiceImpl implements ISysUserPostService
{
    @Autowired
    private SysUserPostMapper userPostMapper;


    @Override
    public int insertSysUserPost(Long userId, SysPost sysPost)
    {
        System.out.println(userId+"看我能获取到用户的id吗？？？？？？");
        Long postId =sysPost.getPostId();
        System.out.println(postId+"我的 职位id 能获取到吗？？？？");
       /* levelAss.setCarateTime(DateUtils.getNowDate());*/
        return userPostMapper.insertSysUserPost(userId,postId);
    }
}
