package com.ruoyi.work.mapper;

import com.ruoyi.work.domain.Gzd;
import java.util.List;	

/**
 * 工作台应用管理 数据层
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
public interface GzdMapper 
{
	/**
     * 查询工作台应用管理信息
     * 
     * @param gztId 工作台应用管理ID
     * @return 工作台应用管理信息
     */
	public Gzd selectGzdById(Integer gztId);
	
	/**
     * 查询工作台应用管理列表
     * 
     * @param gzd 工作台应用管理信息
     * @return 工作台应用管理集合
     */
	public List<Gzd> selectGzdList(Gzd gzd);
	
	/**
     * 新增工作台应用管理
     * 
     * @param gzd 工作台应用管理信息
     * @return 结果
     */
	public int insertGzd(Gzd gzd);
	
	/**
     * 修改工作台应用管理
     * 
     * @param gzd 工作台应用管理信息
     * @return 结果
     */
	public int updateGzd(Gzd gzd);
	
	/**
     * 删除工作台应用管理
     * 
     * @param gztId 工作台应用管理ID
     * @return 结果
     */
	public int deleteGzdById(Integer gztId);
	
	/**
     * 批量删除工作台应用管理
     * 
     * @param gztIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteGzdByIds(String[] gztIds);
	
}