package com.ruoyi.integral.service.impl;

import com.ruoyi.common.constant.IntegralConstants;
import com.ruoyi.common.support.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.integral.domain.IntegralMenu;
import com.ruoyi.integral.domain.YjIntegral;
import com.ruoyi.integral.mapper.IntegralMenuMapper;
import com.ruoyi.integral.mapper.YjIntegralMapper;
import com.ruoyi.integral.service.IYjIntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业绩B积分管理 服务层实现
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
@Service
public class YjIntegralServiceImpl implements IYjIntegralService 
{
	@Autowired
	private YjIntegralMapper yjIntegralMapper;
	@Autowired
	private IntegralMenuMapper integralMenuMapper;

	/**
     * 查询业绩B积分管理信息
     * 
     * @param behaviorId 业绩B积分管理ID
     * @return 业绩B积分管理信息
     */
    @Override
	public YjIntegral selectYjIntegralById(Integer behaviorId)
	{
		YjIntegral yj =	yjIntegralMapper.selectYjIntegralById(behaviorId);

		if(yj.getMenuId()!=null){
			IntegralMenu menu = integralMenuMapper.selectIntegralMenuById(Integer.parseInt(yj.getMenuId()));
			if (menu!=null){
				yj.setMenuType(menu.getTypeName());
			}
		}
		return yj;
	}
	
	/**
     * 查询业绩B积分管理列表
     * 
     * @param yjIntegral 业绩B积分管理信息
     * @return 业绩B积分管理集合
     */
	@Override
	public List<YjIntegral> selectYjIntegralList(YjIntegral yjIntegral)
	{
	    return yjIntegralMapper.selectYjIntegralList(yjIntegral);
	}
	
    /**
     * 新增业绩B积分管理
     * 
     * @param yjIntegral 业绩B积分管理信息
     * @return 结果
     */
	@Override
	public int insertYjIntegral(YjIntegral yjIntegral)
	{
		yjIntegral.setCreateTime(DateUtils.getNowDate());
		return yjIntegralMapper.insertYjIntegral(yjIntegral);
	}
	
	/**
     * 修改业绩B积分管理
     * 
     * @param yjIntegral 业绩B积分管理信息
     * @return 结果
     */
	@Override
	public int updateYjIntegral(YjIntegral yjIntegral)
	{
		yjIntegral.setUpdateTime(DateUtils.getNowDate());
	    return yjIntegralMapper.updateYjIntegral(yjIntegral);
	}

	/**
     * 删除业绩B积分管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteYjIntegralByIds(String ids)
	{
		return yjIntegralMapper.deleteYjIntegralByIds(Convert.toStrArray(ids));
	}

	/**
	 * 禁用业绩B积分管理
	 */
	@Override
	public int integralTyBehaviorId(Integer behaviorId,Integer status) {
		YjIntegral yj =	yjIntegralMapper.selectYjIntegralById(behaviorId);
		if(status == 0){
			yj.setStatus(Integer.parseInt(IntegralConstants.INTEGRAL_JIN_YONG));
		}

		return yjIntegralMapper.updateYjIntegral(yj);
	}

	/**
	 * 修改保存业绩B积分管理
	 */
	@Override
	public int deleteYJIntegralById(Integer behaviorId) {
		return yjIntegralMapper.deleteYjIntegralById(behaviorId);
	}

}
