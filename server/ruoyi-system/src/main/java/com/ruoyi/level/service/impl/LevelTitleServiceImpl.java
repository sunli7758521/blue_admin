package com.ruoyi.level.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.level.mapper.LevelTitleMapper;
import com.ruoyi.level.domain.LevelTitle;
import com.ruoyi.level.service.ILevelTitleService;
import com.ruoyi.common.support.Convert;

/**
 * 水平考核题目 服务层实现
 * 
 * @author sunli
 * @date 2019-03-14
 */
@Service
public class LevelTitleServiceImpl implements ILevelTitleService 
{
	@Autowired
	private LevelTitleMapper levelTitleMapper;

	/**
     * 查询水平考核题目信息
     * 
     * @param tId 水平考核题目ID
     * @return 水平考核题目信息
     */
    @Override
	public LevelTitle selectLevelTitleById(Integer tId)
	{
	    return levelTitleMapper.selectLevelTitleById(tId);
	}
	
	/**
     * 查询水平考核题目列表
     * 
     * @param levelTitle 水平考核题目信息
     * @return 水平考核题目集合
     */
	/*@Override
	public List<LevelTitle> selectLevelTitleList(LevelTitle levelTitle)
	{
	    return levelTitleMapper.selectLevelTitleList(levelTitle);
	}*/


	/**
	 * 查询水平考核题目列表
	 *
	 * @param levelTitle 水平考核题目信息
	 * @return 水平考核题目集合
	 */
	@Override
	public List<LevelTitle> selectLevelIdTitleList(String levelId)
	{
		return levelTitleMapper.selectLevelIdTitleList(levelId);
	}
	
    /**
     * 新增水平考核题目
     * 
     * @param levelTitle 水平考核题目信息
     * @return 结果
     */
	@Override
	public int insertLevelTitle(LevelTitle levelTitle)
	{
		levelTitle.setCatabTime(DateUtils.getNowDate());
	    return levelTitleMapper.insertLevelTitle(levelTitle);
	}
	
	/**
     * 修改水平考核题目
     * 
     * @param levelTitle 水平考核题目信息
     * @return 结果
     */
	@Override
	public int updateLevelTitle(LevelTitle levelTitle)
	{
		levelTitle.setCatabTime(DateUtils.getNowDate());
	    return levelTitleMapper.updateLevelTitle(levelTitle);
	}

	/**
     * 删除水平考核题目对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteLevelTitleByIds(String ids)
	{
		return levelTitleMapper.deleteLevelTitleByIds(Convert.toStrArray(ids));
	}
	
}
