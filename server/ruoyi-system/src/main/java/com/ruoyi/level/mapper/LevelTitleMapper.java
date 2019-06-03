package com.ruoyi.level.mapper;

import com.ruoyi.level.domain.LevelTitle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 水平考核题目 数据层
 * 
 * @author sunli
 * @date 2019-03-14
 */
public interface LevelTitleMapper 
{
	/**
     * 查询水平考核题目信息
     * 
     * @param tId 水平考核题目ID
     * @return 水平考核题目信息
     */
	public LevelTitle selectLevelTitleById(Integer tId);
	
	/**
     * 查询水平考核题目列表
     * 
     * @param levelTitle 水平考核题目信息
     * @return 水平考核题目集合
     */
	/*public List<LevelTitle> selectLevelTitleList(LevelTitle levelTitle);*/

	/**
	 * 查询水平考核题目列表
	 *
	 * @param levelTitle 水平考核题目信息
	 * @return 水平考核题目集合
	 */
	public List<LevelTitle> selectLevelIdTitleList(@Param("levelId")String levelId);
	
	/**
     * 新增水平考核题目
     * 
     * @param levelTitle 水平考核题目信息
     * @return 结果
     */
	public int insertLevelTitle(LevelTitle levelTitle);
	
	/**
     * 修改水平考核题目
     * 
     * @param levelTitle 水平考核题目信息
     * @return 结果
     */
	public int updateLevelTitle(LevelTitle levelTitle);
	
	/**
     * 删除水平考核题目
     * 
     * @param tId 水平考核题目ID
     * @return 结果
     */
	public int deleteLevelTitleById(Integer tId);
	
	/**
     * 批量删除水平考核题目
     * 
     * @param tIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteLevelTitleByIds(String[] tIds);
	
}