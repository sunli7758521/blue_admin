package com.ruoyi.integral.service.impl;

import com.ruoyi.common.support.Convert;
import com.ruoyi.integral.domain.Integral;
import com.ruoyi.integral.mapper.IntegralMapper;
import com.ruoyi.integral.service.IIntegralService;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.mapper.SysDeptMapper;
import com.ruoyi.system.mapper.SysPostMapper;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.mapper.SysUserPostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 积分 服务层实现
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
@Service
public class IntegralServiceImpl implements IIntegralService 
{
	@Autowired
	private IntegralMapper integralMapper;
	@Autowired
	private SysDeptMapper sysDeptMapper;
	@Autowired
	private SysPostMapper sysPostMapper;
	@Autowired
	private SysUserPostMapper sysUserPostMapper;
	@Autowired
	private SysUserMapper sysUserMapper;

//	@Override
//	public Integer selectuserid(Integer user_id) {
//		return sysUserMapper.se;
//	}

	/**
     * 查询积分信息
     * 
     * @param integralId 积分ID
     * @return 积分信息
     */
    @Override
	public Integral selectIntegralById(Integer integralId)
	{
	    return integralMapper.selectIntegralById(integralId);
	}
	
	/**
     * 查询积分列表
     * 
     * @param integral 积分信息
     * @return 积分集合
     */
	@Override
	public List<Integral> selectIntegralList(Integral integral)
	{
		List<Integral> integrals =	integralMapper.selectIntegralList(integral);
//		for (Integral in : integrals) {
//
//			SysUser user = sysUserMapper.selectUserById(in.getUserId().longValue());
//			if (user != null) {
//				if(user.getDeptId() !=null){
//					SysDept dept = sysDeptMapper.selectDeptByName(user.getDeptId().intValue());
//					if (dept != null) {
//						in.setDeptName(dept.getDeptName());
//						in.setDeptId(dept.getDeptId().intValue());
//						SysUserPost userPost = sysUserPostMapper.selectUserById(in.getUserId().longValue());
//						if(userPost !=null ){
//							in.setPostId(userPost.getPostId().intValue());
//							SysPost post = sysPostMapper.selectPostById(userPost.getPostId());
//							if(post !=null){
//								in.setPostName(post.getPostName());
//							}
//						}
//					}
//				}
//
//			}
//		}
	    return integrals;
	}
	
    /**
     * 新增积分
     * 
     * @param integral 积分信息
     * @return 结果
     */
	@Override
	public int insertIntegral(Integral integral)
	{
	    return integralMapper.insertIntegral(integral);
	}




	@Override
	public int insertIntegral2(SysUser sysUser1,SysPost sysPost,Long userId)
	{
	/*	Long userId=sysUser1.getUserId();*/
		String userName= sysUser1.getUserName();
		String phonenumber =sysUser1.getPhonenumber();
		Integer jiChuIntegral=sysUser1.getJiChuIntegral();
		Long deptId  =sysUser1.getDeptId();
		Long postId=sysPost.getPostId();

		Integral integral=new Integral();
		integral.setUserId(Integer.parseInt(String.valueOf(userId)));
		integral.setUserName(userName);
		integral.setUserPhone(phonenumber);
		integral.setCountIntegral(jiChuIntegral);
		integral.setPostId(Integer.parseInt(String.valueOf(postId)));
		integral.setDeptId(Integer.parseInt(String.valueOf(deptId)));
		integral.setGoodCountIntegral(jiChuIntegral);




		return integralMapper.insertIntegral(integral);
	}
	
	/**
     * 修改积分
     * 
     * @param integral 积分信息
     * @return 结果
     */
	@Override
	public int updateIntegral(Integral integral)
	{
	    return integralMapper.updateIntegral(integral);
	}

	/**
     * 删除积分对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteIntegralByIds(String ids)
	{
		return integralMapper.deleteIntegralByIds(Convert.toStrArray(ids));
	}

	/**
	 * 批量插入或更新
	 * @param list
	 */
	@Override
	public void insertOrUpdate(List<Integral> list) {
		this.integralMapper.insertOrUpdate(list);
	}
    /**
     * 按条件查询积分榜
     * @param map 包含 部门主键、职位主键、用户主键
     * @return
     */
    @Override
    public Integral findIntegralByDpu(Map<String, Object> map) {
        return this.integralMapper.findIntegralByDpu(map);
    }



	/** 跟据用户ids 删除 所关联的积分总表的id */
	@Override
	public void deleteIntegralByUserIds(Long [] ids) {

		this.integralMapper.deleteIntegralByUserId(ids);
	}

	/**
	 * 查询积分榜信息
	 *
	 * @param integral 查询积分榜信息
	 * @return 结果
	 */
	/*@Override
	public List<Map> selectUserIntegral(Integral integral) {
		return integralMapper.selectUserIntegral(integral);
	}*/



	@Override
	public Integral selectdanbiao(Integer userId ,String name) {


		return 	this.integralMapper.selectdanbiao(userId,name);
	}

}
