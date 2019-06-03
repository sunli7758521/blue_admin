package com.ruoyi.integral.service.impl;

import com.ruoyi.common.constant.IntegralConstants;
import com.ruoyi.common.support.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.integral.domain.IntegralMenu;
import com.ruoyi.integral.domain.PdIntegral;
import com.ruoyi.integral.mapper.IntegralMenuMapper;
import com.ruoyi.integral.mapper.PdIntegralMapper;
import com.ruoyi.integral.service.IPdIntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 品德A积分管理 服务层实现
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
@Service
public class PdIntegralServiceImpl implements IPdIntegralService 
{
	@Autowired
	private PdIntegralMapper pdIntegralMapper;
	@Autowired
	private IntegralMenuMapper integralMenuMapper;

	/**
     * 查询品德A积分管理信息
     * 
     * @param behaviorId 品德A积分管理ID
     * @return 品德A积分管理信息
     */
    @Override
	public PdIntegral selectPdIntegralById(Integer behaviorId)
	{
		PdIntegral pd = pdIntegralMapper.selectPdIntegralById(behaviorId);
		if(pd.getMenuId()!=null){
			IntegralMenu menu = integralMenuMapper.selectIntegralMenuById(Integer.parseInt(pd.getMenuId()));
			if (menu!=null){
				pd.setMenuType(menu.getTypeName());
			}
		}
		return pd;
	}
	
	/**
     * 查询品德A积分管理列表
     * 
     * @param pdIntegral 品德A积分管理信息
     * @return 品德A积分管理集合
     */
	@Override
	public List<PdIntegral> selectPdIntegralList(PdIntegral pdIntegral)
	{
	    return pdIntegralMapper.selectPdIntegralList(pdIntegral);
	}
	
    /**
     * 新增品德A积分管理
     * 
     * @param pdIntegral 品德A积分管理信息
     * @return 结果
     */
	@Override
	public int insertPdIntegral(PdIntegral pdIntegral)
	{
		pdIntegral.setCreateTime(DateUtils.getNowDate());
	    return pdIntegralMapper.insertPdIntegral(pdIntegral);
	}
	
	/**
     * 修改品德A积分管理
     * 
     * @param pdIntegral 品德A积分管理信息
     * @return 结果
     */
	@Override
	public int updatePdIntegral(PdIntegral pdIntegral)
	{
		pdIntegral.setUpdateTime(DateUtils.getNowDate());
		return pdIntegralMapper.updatePdIntegral(pdIntegral);
	}

	/**
     * 删除品德A积分管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deletePdIntegralByIds(String ids)
	{
		return pdIntegralMapper.deletePdIntegralByIds(Convert.toStrArray(ids));
	}

	/**
	 * 禁用品德A积分管理
	 */
	@Override
	public int integralTyBehaviorId(Integer behaviorId,Integer status) {
		PdIntegral pd =	pdIntegralMapper.selectPdIntegralById(behaviorId);
		if(status ==0 ){
			pd.setStatus(Integer.parseInt(IntegralConstants.INTEGRAL_JIN_YONG));
		}
		return pdIntegralMapper.updatePdIntegral(pd);
	}

	@Override
	public int deletePdIntegralById(Integer behaviorId) {
		return pdIntegralMapper.deletePdIntegralById(behaviorId);
	}

}
