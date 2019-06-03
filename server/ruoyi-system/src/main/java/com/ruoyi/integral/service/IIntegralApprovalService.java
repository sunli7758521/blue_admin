package com.ruoyi.integral.service;

import com.ruoyi.integral.domain.Integral;
import com.ruoyi.integral.domain.IntegralAppExcel;
import com.ruoyi.integral.domain.IntegralApproval;
import com.ruoyi.system.domain.SysUser;

import java.util.List;
import java.util.Map;

/**
 * 审批管理 服务层
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
public interface IIntegralApprovalService
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
     * 删除审批管理信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteIntegralApprovalByIds(String ids);


	/**
	 * 修改审批转态 添加用户积分
	 *
	 * @param approvalId  需要修改审批转态 approvalId
	 * @return 结果
	 */
	int successStatus(Integer approvalId,Integer status);

	/**
	 *  积分榜 excel 导出
	 *
	 */
	List<Map> selectIntegralBangExeclLists(IntegralApproval integralApproval);

	/**
	 * 批量保存
	 */
	void insertBathch(List<IntegralApproval> list,List<Integral> iList,List<SysUser> users);

	/**
	 * 积分审批统计
	 * @param integralAppExcel
	 * @return
	 */
	List<IntegralAppExcel> selectIaeTotal(IntegralAppExcel integralAppExcel);
}
