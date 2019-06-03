package com.ruoyi.level.mapper;

import com.ruoyi.level.domain.LevelAss;
import java.util.List;	

/**
 * 水平考核 数据层
 * 
 * @author sunli
 * @date 2019-03-14
 */
public interface LevelAssMapper 
{
	/**
     * 查询水平考核信息
     * 
     * @param levelId 水平考核ID
     * @return 水平考核信息
     */
	public LevelAss selectLevelAssById(Integer levelId);
	
	/**
     * 查询水平考核列表
     * 
     * @param levelAss 水平考核信息
     * @return 水平考核集合
     */
	public List<LevelAss> selectLevelAssList(LevelAss levelAss);
	
	/**
     * 新增水平考核
     * 
     * @param levelAss 水平考核信息
     * @return 结果
     */
	public int insertLevelAss(LevelAss levelAss);
	
	/**
     * 修改水平考核
     * 
     * @param levelAss 水平考核信息
     * @return 结果
     */
	public int updateLevelAss(LevelAss levelAss);
	
	/**
     * 删除水平考核
     * 
     * @param levelId 水平考核ID
     * @return 结果
     */
	public int deleteLevelAssById(Integer levelId);
	
	/**
     * 批量删除水平考核
     * 
     * @param levelIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteLevelAssByIds(String[] levelIds);



}