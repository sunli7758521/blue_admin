package com.ruoyi.integral.service.impl;

import com.ruoyi.common.constant.IntegralConstants;
import com.ruoyi.common.support.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.integral.domain.Integral;
import com.ruoyi.integral.domain.IntegralAppExcel;
import com.ruoyi.integral.domain.IntegralApproval;
import com.ruoyi.integral.domain.IntegralLog;
import com.ruoyi.integral.mapper.IntegralAppExcelMapper;
import com.ruoyi.integral.mapper.IntegralApprovalMapper;
import com.ruoyi.integral.mapper.IntegralLogMapper;
import com.ruoyi.integral.mapper.IntegralMapper;
import com.ruoyi.integral.service.IIntegralApprovalService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 审批管理 服务层实现
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
@Service
public class IntegralApprovalServiceImpl implements IIntegralApprovalService
{
	@Autowired
	private IntegralApprovalMapper integralApprovalMapper;

	@Autowired
	private IntegralLogMapper integralLogMapper;

	@Autowired
	private IntegralMapper integralMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
	private IntegralAppExcelMapper integralAppExcelMapper;


	/**
     * 查询审批管理信息
     * 
     * @param approvalId 审批管理ID
     * @return 审批管理信息
     */
    @Override
	public IntegralApproval selectIntegralApprovalById(Integer approvalId)
	{
	    return integralApprovalMapper.selectIntegralApprovalById(approvalId);
	}
	
	/**
     * 查询审批管理列表
     * 
     * @param integralApproval 审批管理信息
     * @return 审批管理集合
     */
	@Override
	public List<IntegralApproval> selectIntegralApprovalList(IntegralApproval integralApproval)
	{
		return integralApprovalMapper.selectIntegralApprovalList(integralApproval);
	}
	
    /**
     * 新增审批管理
     * 
     * @param integralApproval 审批管理信息
     * @return 结果
     */
	@Override
	public int insertIntegralApproval(IntegralApproval integralApproval)
	{
	    return integralApprovalMapper.insertIntegralApproval(integralApproval);
	}
	
	/**
     * 修改审批管理
     * 
     * @param integralApproval 审批管理信息
     * @return 结果
     */
	@Override
	public int updateIntegralApproval(IntegralApproval integralApproval)
	{
	    return integralApprovalMapper.updateIntegralApproval(integralApproval);
	}

	/**
     * 删除审批管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteIntegralApprovalByIds(String ids)
	{
		return integralApprovalMapper.deleteIntegralApprovalByIds(Convert.toStrArray(ids));
	}

	/**
	 *  审批通过
	 * 修改审批转态 添加用户积分
	 *
	 * @param approvalId 需要修改审批转态 approvalId
	 * @return 结果
	 */
	@Override
	public int successStatus(Integer approvalId,Integer status) {
		IntegralApproval integralApproval =	integralApprovalMapper.selectIntegralApprovalById(approvalId);
		int bb=1;

		if (status.equals(IntegralConstants.SQ_FAIL)){
			integralApproval.setStatus(IntegralConstants.SQ_FAIL);
			integralApproval.setSpTime(new Date());
			int b = integralApprovalMapper.updateIntegralApproval(integralApproval);
		}else if(status.equals(IntegralConstants.SQ_CX)){
			integralApproval.setStatus(IntegralConstants.SQ_CX);
			integralApproval.setSpTime(new Date());
			int b = integralApprovalMapper.updateIntegralApproval(integralApproval);
		}else {
			integralApproval.setStatus(IntegralConstants.SQ_SUCCESS);
			integralApproval.setSpTime(DateUtils.getNowDate());
			/** 更新积分审批管理状态*/
			int b = integralApprovalMapper.updateIntegralApproval(integralApproval);
			/** 添加积分日志*/
			IntegralLog log = new IntegralLog();
			log.setApprovalNum(integralApproval.getApprovalNum());
			log.setBianIntegral(integralApproval.getSqIntegral());
			log.setGetTime(integralApproval.getApprovalTime()+"");
			log.setIntegralTitle(integralApproval.getApprovalTitle());
			log.setIntegralContent(integralApproval.getApprovalContent());
			log.setUserDept(integralApproval.getUserDept());
			log.setUserPost(integralApproval.getUserPost());
			log.setTypeId(integralApproval.getIntegralTypeId());
			log.setUserPost(integralApproval.getUserPost());
			log.setUserName(integralApproval.getUserName());
			log.setUserPhone(integralApproval.getUserPhone());
			log.setIntegralContent(integralApproval.getApprovalContent());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			log.setGetTime(format.format(integralApproval.getSpTime()));
			log.setStatus(IntegralConstants.INTEGRALLOG_DEFULLT);
			int i = integralLogMapper.insertIntegralLog(log);
			/** 通过手机号和姓名去积分表里更改总积分 */
			//Integral integral = integralMapper.selectUsernameAndPhone(integralApproval.getUserName(), integralApproval.getUserPhone() + "");
			Integral integral = integralMapper.selectByUserId(integralApproval.getUserId()+"");
			synchronized (integral){
//				if (integral.getAddIntegral() == null) {
//					integral.setAddIntegral(0 + integralApproval.getSqIntegral());
//				}
//				else {
//					integral.setAddIntegral(integral.getAddIntegral() + integralApproval.getSqIntegral());
//				}
				integral.setCountIntegral(integral.getCountIntegral() + integralApproval.getSqIntegral());
				integral.setGoodCountIntegral(integral.getGoodCountIntegral() + integralApproval.getSqIntegral());
				bb = integralMapper.updateIntegral(integral);
			}


		}
            return bb;

	}

	/**
	 *  积分榜 excel 导出
	 *
	 */
	@Override
	public List<Map> selectIntegralBangExeclLists(IntegralApproval integralApproval) {
		List<Map> listMap =	integralApprovalMapper.selectIntegralBangExeclLists(integralApproval);

		for (Map map : listMap) {
			List<Map> typeList = integralApprovalMapper.selectByUserIdGetType(map.get("userId") + "");
			for (Map ma : typeList) {

				if(ma.get("integralTypeId").equals(1)){
					Integer count =	integralApprovalMapper.selectCount(map.get("userId")+"",1);
					map.put("Acount",count);
				} else
				if (ma.get("integralTypeId").equals(2)){
					Integer count =	integralApprovalMapper.selectCount(map.get("userId")+"",2);
					map.put("Bcount",count);
				} else
				if (ma.get("integralTypeId").equals(3)){
					Integer count =	integralApprovalMapper.selectCount(map.get("userId")+"",3);
					map.put("Ccount",count);
				} else
				 if (ma.get("integralTypeId").equals(4)){
					Integer count =	integralApprovalMapper.selectCount(map.get("userId")+"",4);
					map.put("adminCount",count);
				} else
				/*积分类型 1.品德 2 业绩 3行为 4.管理 5自由奖扣 6.爱心点赞.7 积分支票  8悬赏任务*/
				 if (ma.get("integralTypeId").equals(5)){
					Integer count =	integralApprovalMapper.selectCount(map.get("userId")+"",5);
					map.put("freeCount",count);
				} else
				if (ma.get("integralTypeId").equals(6)){
					Integer count =	integralApprovalMapper.selectCount(map.get("userId")+"",6);
					map.put("loveCount",count);
				} else
				if (ma.get("integralTypeId").equals(7)){
					Integer count =	integralApprovalMapper.selectCount(map.get("userId")+"",7);
					map.put("checkCount",count);
				} else
				if (ma.get("integralTypeId").equals(8)){
					Integer count =	integralApprovalMapper.selectCount(map.get("userId")+"",8);
					map.put("rewardTask",count);
				}
			}

		}
		return listMap;
	}

	@Override
	public void insertBathch(List<IntegralApproval> list, List<Integral> iList, List<SysUser> users) {
		integralMapper.insertOrUpdate(iList);
		integralApprovalMapper.insertBatch(list);
		sysUserMapper.updateUserBatch(users);
	}

	/**
	 * 积分统计
	 * @param integralAppExcel
	 * @return
	 */
	@Override
	public List<IntegralAppExcel> selectIaeTotal(IntegralAppExcel integralAppExcel) {
		return integralAppExcelMapper.selectIaeTotal(integralAppExcel);
	}


}
