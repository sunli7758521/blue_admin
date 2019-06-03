package com.ruoyi.level.service.impl;

import java.util.List;

import com.ruoyi.common.constant.IntegralConstants;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.level.mapper.LevelAssMapper;
import com.ruoyi.level.domain.LevelAss;
import com.ruoyi.level.service.ILevelAssService;
import com.ruoyi.common.support.Convert;

/**
 * 水平考核 服务层实现
 * 
 * @author sunli
 * @date 2019-03-14
 */
@Service
public class LevelAssServiceImpl implements ILevelAssService 
{
	@Autowired
	private LevelAssMapper levelAssMapper;

	/**
     * 查询水平考核信息
     * 
     * @param levelId 水平考核ID
     * @return 水平考核信息
     */
    @Override
	public LevelAss selectLevelAssById(Integer levelId)
	{
	    return levelAssMapper.selectLevelAssById(levelId);
	}
	
	/**
     * 查询水平考核列表
     * 
     * @param levelAss 水平考核信息
     * @return 水平考核集合
     */
	@Override
	public List<LevelAss> selectLevelAssList(LevelAss levelAss)
	{
	    return levelAssMapper.selectLevelAssList(levelAss);
	}
	
    /**
     * 新增水平考核
     * 
     * @param levelAss 水平考核信息
     * @return 结果
     */
	@Override
	public int insertLevelAss(LevelAss levelAss)
	{
		levelAss.setCarateTime(DateUtils.getNowDate());
	    return levelAssMapper.insertLevelAss(levelAss);
	}
	
	/**
     * 修改水平考核
     * 
     * @param levelAss 水平考核信息
     * @return 结果
     */
	@Override
	public int updateLevelAss(LevelAss levelAss)
	{
		levelAss.setCarateTime(DateUtils.getNowDate());
	    return levelAssMapper.updateLevelAss(levelAss);
	}

	/**
     * 删除水平考核对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteLevelAssByIds(String ids)
	{
		return levelAssMapper.deleteLevelAssByIds(Convert.toStrArray(ids));
	}

	/**
	 * 禁用行为管理
	 */
	@Override
	public int levellevelId(Integer levelId,Integer state) {
		LevelAss as =levelAssMapper.selectLevelAssById(levelId);
		System.out.println(as+"zhi1111111111111111111111111111111111111111");
		if(state==0){
			as.setState(IntegralConstants.SQ_JIN);
		}
		return levelAssMapper.updateLevelAss(as);
	}

}
