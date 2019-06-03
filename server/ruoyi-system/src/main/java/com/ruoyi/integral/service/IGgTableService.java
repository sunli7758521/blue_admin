package com.ruoyi.integral.service;

import com.ruoyi.integral.domain.GgTable;
import java.util.List;

/**
 * 广告图片 服务层
 * 
 * @author sunli
 * @date 2018-11-06
 */
public interface IGgTableService 
{
	/**
     * 查询广告图片信息
     * 
     * @param gId 广告图片ID
     * @return 广告图片信息
     */
	public GgTable selectGgTableById(Integer gId);
	
	/**
     * 查询广告图片列表
     * 
     * @param ggTable 广告图片信息
     * @return 广告图片集合
     */
	public List<GgTable> selectGgTableList(GgTable ggTable);
	
	/**
     * 新增广告图片
     * 
     * @param ggTable 广告图片信息
     * @return 结果
     */
	public int insertGgTable(GgTable ggTable);
	
	/**
     * 修改广告图片
     * 
     * @param ggTable 广告图片信息
     * @return 结果
     */
	public int updateGgTable(GgTable ggTable);
		
	/**
     * 删除广告图片信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteGgTableByIds(String ids);
	
}
