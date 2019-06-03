package com.ruoyi.integral.mapper;

import com.ruoyi.integral.domain.Integral;
import com.ruoyi.integral.domain.IntegralApproval;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 审批管理 数据层
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
public interface IntegralApprovalMapper 
{
	/**
     * 查询审批管理信息
     * 
     * @param approvalId 审批管理ID
     * @return 审批管理信息
     */
	public IntegralApproval selectIntegralApprovalById(Integer approvalId);
	
	/**
     * 查询审批管理列表
     * 
     * @param integralApproval 审批管理信息
     * @return 审批管理集合
     */
	public List<IntegralApproval> selectIntegralApprovalList(IntegralApproval integralApproval);

	/**
     * 新增审批管理
     * 
     * @param integralApproval 审批管理信息
     * @return 结果
     */
	public int insertIntegralApproval(IntegralApproval integralApproval);
	
	/**
     * 修改审批管理
     * 
     * @param integralApproval 审批管理信息
     * @return 结果
     */
	public int updateIntegralApproval(IntegralApproval integralApproval);
	
	/**
     * 删除审批管理
     * 
     * @param approvalId 审批管理ID
     * @return 结果
     */
	public int deleteIntegralApprovalById(Integer approvalId);
	
	/**
     * 批量删除审批管理
     * 
     * @param approvalIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralApprovalByIds(String[] approvalIds);

	/**
	 *  积分榜 excel 导出
	 *
	 */
    List<Map> selectIntegralBangExeclLists(IntegralApproval integralApproval);

	/**
	 *  查询每一种类型的总积分
	 */
	Integer selectCount(@Param("userId")  String userId,@Param("integralTypeId") Integer integralTypeId);

	/**
	 *  根据用户id 查询积分类型
	 */
	List<Map> selectByUserIdGetType(@Param("userId") String userId);

	/**
	 *  根据用户id 查询积分类型
	 */
	int insertBatch(@Param("list") List<IntegralApproval> list);
}