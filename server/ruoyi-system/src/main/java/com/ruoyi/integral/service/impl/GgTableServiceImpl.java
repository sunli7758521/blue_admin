package com.ruoyi.integral.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.integral.mapper.GgTableMapper;
import com.ruoyi.integral.domain.GgTable;
import com.ruoyi.integral.service.IGgTableService;
import com.ruoyi.common.support.Convert;

/**
 * 广告图片 服务层实现
 * 
 * @author sunli
 * @date 2018-11-06
 */
@Service
public class GgTableServiceImpl implements IGgTableService 
{
	@Autowired
	private GgTableMapper ggTableMapper;

	/**
     * 查询广告图片信息
     * 
     * @param gId 广告图片ID
     * @return 广告图片信息
     */
    @Override
	public GgTable selectGgTableById(Integer gId)
	{
	    return ggTableMapper.selectGgTableById(gId);
	}
	
	/**
     * 查询广告图片列表
     * 
     * @param ggTable 广告图片信息
     * @return 广告图片集合
     */
	@Override
	public List<GgTable> selectGgTableList(GgTable ggTable)
	{
	    return ggTableMapper.selectGgTableList(ggTable);
	}
	
    /**
     * 新增广告图片
     * 
     * @param ggTable 广告图片信息
     * @return 结果
     */
	@Override
	public int insertGgTable(GgTable ggTable)
	{
	    return ggTableMapper.insertGgTable(ggTable);
	}
	
	/**
     * 修改广告图片
     * 
     * @param ggTable 广告图片信息
     * @return 结果
     */
	@Override
	public int updateGgTable(GgTable ggTable)
	{
	    return ggTableMapper.updateGgTable(ggTable);
	}

	/**
     * 删除广告图片对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteGgTableByIds(String ids)
	{
		return ggTableMapper.deleteGgTableByIds(Convert.toStrArray(ids));
	}
	
}
