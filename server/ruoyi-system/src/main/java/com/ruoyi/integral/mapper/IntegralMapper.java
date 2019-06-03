package com.ruoyi.integral.mapper;

import com.ruoyi.integral.domain.Integral;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 积分 数据层
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
public interface IntegralMapper 
{
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
	
	/**
     * 修改积分
     * 
     * @param integral 积分信息
     * @return 结果
     */
	public int updateIntegral(Integral integral);
	
	/**
     * 删除积分
     * 
     * @param integralId 积分ID
     * @return 结果
     */
	public int deleteIntegralById(Integer integralId);
	
	/**
     * 批量删除积分
     * 
     * @param integralIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralByIds(String[] integralIds);

	/**
	 * 查询积分榜信息
	 *
	 * @param integral 查询积分榜信息
	 * @return 结果
	 */
	List<Map> selectUserIntegral(Integral integral);

	/**
	 * 通过手机号和姓名去积分表里更改总积分
	 *
	 * @param userName phone 查询积分榜信息
	 * @return 结果
	 */
    Integral selectUsernameAndPhone(@Param("userName") String userName, @Param("phone")  String phone);

	/**
	 *  根据用户名查询积分
	 *  @param userName 积分奖扣信息
	 *   @return 结果
	 */
    Integral selectUserName(@Param("userName") String userName);

	/**
	 *  根据用户名id查询积分
	 *  @param id 积分奖扣信息
	 *   @return 结果
	 */
    Integral selectByUserId(@Param("id") String id);

	/**
	 * 批量插入或更新
	 * @param list
	 * @return
	 */
	int insertOrUpdate(@Param("list") List<Integral> list);

    /**
     * 按条件查询积分榜
     * @param map 包含 部门主键、职位主键、用户主键
     * @return
     */
    Integral  findIntegralByDpu(@Param("map") Map<String,Object> map);

	/** 跟据用户ids 删除 所关联的积分总表的id */
    void deleteIntegralByUserId(Long [] ids);

	Integral selectdanbiao(@Param("userId") Integer userId,@Param("name") String name );

}