package com.ruoyi.integral.service.impl;

import com.ruoyi.common.constant.IntegralConstants;
import com.ruoyi.common.support.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.integral.domain.IntegralMenu;
import com.ruoyi.integral.domain.MenuDept;
import com.ruoyi.integral.domain.XwIntegral;
import com.ruoyi.integral.mapper.IntegralMenuMapper;
import com.ruoyi.integral.mapper.MenuDeptMapper;
import com.ruoyi.integral.mapper.XwIntegralMapper;
import com.ruoyi.integral.service.IXwIntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 行为c积分管理 服务层实现
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
@Service
public class XwIntegralServiceImpl implements IXwIntegralService 
{
	@Autowired
	private XwIntegralMapper xwIntegralMapper;

	@Autowired
	private IntegralMenuMapper integralMenuMapper;

	@Autowired
	private MenuDeptMapper menuDeptMapper;
	/**
     * 查询行为c积分管理信息
     * 
     * @param behaviorId 行为c积分管理ID
     * @return 行为c积分管理信息
     */
    @Override
	public XwIntegral selectXwIntegralById(Integer behaviorId)
	{
		XwIntegral xw = xwIntegralMapper.selectXwIntegralById(behaviorId);
		if(xw.getMenuId()!=null){
			IntegralMenu menu = integralMenuMapper.selectIntegralMenuById(Integer.parseInt(xw.getMenuId()));
			if (menu!=null){
				xw.setMenuType(menu.getTypeName());
			}
		}
	    return xw;
	}
	
	/**
     * 查询行为c积分管理列表
     * 
     * @param xwIntegral 行为c积分管理信息
     * @return 行为c积分管理集合
     */
	@Override
	public List<XwIntegral> selectXwIntegralList(XwIntegral xwIntegral)
	{
	    return xwIntegralMapper.selectXwIntegralList(xwIntegral);
	}
	
    /**
     * 新增行为c积分管理
     * 
     * @param xwIntegral 行为c积分管理信息
     * @return 结果
     */
	@Override
	public int insertXwIntegral(XwIntegral xwIntegral)
	{
		int row = 0;
		xwIntegral.setCreateTime(DateUtils.getNowDate());
		row = xwIntegralMapper.insertXwIntegral(xwIntegral);
		// todo
		if(StringUtils.isNotEmpty(xwIntegral.getDeptIds())){
		String [] depts	= xwIntegral.getDeptIds().split(",");
			for (String deptId : depts) {
				MenuDept menuDept = new MenuDept();
				menuDept.setDeptId(Long.parseLong(deptId));
				menuDept.setMenuId(xwIntegral.getBehaviorId().longValue());
				row =	menuDeptMapper.insertMenuDept(menuDept);
			}
		}
		return row;
	}
	
	/**
     * 修改行为c积分管理
     * 
     * @param xwIntegral 行为c积分管理信息
     * @return 结果
     */
	@Override
	public int updateXwIntegral(XwIntegral xwIntegral)
	{
		xwIntegral.setUpdateTime(DateUtils.getNowDate());
		return xwIntegralMapper.updateXwIntegral(xwIntegral);
	}

	/**
     * 删除行为c积分管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteXwIntegralByIds(String ids)
	{
		// 删除积分项
		int row = 0;
		row = xwIntegralMapper.deleteXwIntegralByIds(Convert.toStrArray(ids));
		// 删除关联部门
		row = menuDeptMapper.deleteByMenuIds(Convert.toStrArray(ids));
		return row;
	}

    /**
     * 禁用行为c积分管理
     */
    @Override
    public int integralTyBehaviorId(Integer behaviorId,Integer status) {

        XwIntegral xw =  xwIntegralMapper.selectXwIntegralById(behaviorId);

        if(status==0){
			xw.setStatus(IntegralConstants.INTEGRAL_JIN_YONG);
		}else{
			xw.setStatus(IntegralConstants.INTEGRAL_QI_YONG);
		}

        return  xwIntegralMapper.updateXwIntegral(xw);
    }

    /**
	 * 	 通过id删除
	 * */
	@Override
	public int deleteXwIntegralById(Integer behaviorId) {
		return xwIntegralMapper.deleteXwIntegralById(behaviorId);
	}

}
