package com.ruoyi.integral.service;

import com.ruoyi.integral.domain.Integral;
import com.ruoyi.system.domain.SysPost;
import com.ruoyi.system.domain.SysRole;
import com.ruoyi.system.domain.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 积分 服务层
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
public interface IIntegralService 
{



	public Integral selectdanbiao(Integer userId,String name);




	/**
     * 查询积分信息
     * 
     * @param integralId 积分ID
     * @return 积分信息
     */
	public Integral selectIntegralById(Integer integralId);
	
	/**
     * 查询积分列表
     * 
     * @param integral 积分信息
     * @return 积分集合
     */
	public List<Integral> selectIntegralList(Integral integral);
	
	/**
     * 新增积分
     * 
     * @param integral 积分信息
     * @return 结果
     */
	public int insertIntegral(Integral integral);

	public int insertIntegral2(SysUser sysUser1, SysPost sysPost,Long userId);
	
	/**
     * 修改积分
     * 
     * @param integral 积分信息
     * @return 结果
     */
	public int updateIntegral(Integral integral);
		
	/**
     * 删除积分信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralByIds(String ids);

	/**
	 * 查询积分榜信息
	 *
	 * @param integral 查询积分榜信息
	 * @return 结果
	 */
	//List<Map> selectUserIntegral(Integral integral);

	void insertOrUpdate( List<Integral> list);

    /**
     * 按条件查询积分榜
     * @param map 包含 部门主键、职位主键、用户主键
     * @return
     */
    Integral  findIntegralByDpu(Map<String,Object> map);

    /** 跟据用户ids 删除 所关联的积分总表的id */
    void deleteIntegralByUserIds(Long [] ids);


}
