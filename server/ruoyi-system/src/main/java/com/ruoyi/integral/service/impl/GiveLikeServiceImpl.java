package com.ruoyi.integral.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.integral.mapper.GiveLikeMapper;
import com.ruoyi.integral.domain.GiveLike;
import com.ruoyi.integral.service.IGiveLikeService;
import com.ruoyi.common.support.Convert;

/**
 * 员工爱心点赞 服务层实现
 * 
 * @author zhaoyan
 * @date 2018-12-20
 */
@Service
public class GiveLikeServiceImpl implements IGiveLikeService 
{
	@Autowired
	private GiveLikeMapper giveLikeMapper;

	/**
     * 查询员工爱心点赞信息
     * 
     * @param dId 员工爱心点赞ID
     * @return 员工爱心点赞信息
     */
    @Override
	public GiveLike selectGiveLikeById(Integer dId)
	{
	    return giveLikeMapper.selectGiveLikeById(dId);
	}
	
	/**
     * 查询员工爱心点赞列表
     * 
     * @param giveLike 员工爱心点赞信息
     * @return 员工爱心点赞集合
     */
	@Override
	public List<GiveLike> selectGiveLikeList(GiveLike giveLike)
	{
	    return giveLikeMapper.selectGiveLikeList(giveLike);
	}
	
    /**
     * 新增员工爱心点赞
     * 
     * @param giveLike 员工爱心点赞信息
     * @return 结果
     */
	@Override
	public int insertGiveLike(GiveLike giveLike)
	{
	    return giveLikeMapper.insertGiveLike(giveLike);
	}
	
	/**
     * 修改员工爱心点赞
     * 
     * @param giveLike 员工爱心点赞信息
     * @return 结果
     */
	@Override
	public int updateGiveLike(GiveLike giveLike)
	{
	    return giveLikeMapper.updateGiveLike(giveLike);
	}

	/**
     * 删除员工爱心点赞对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteGiveLikeByIds(String ids)
	{
		return giveLikeMapper.deleteGiveLikeByIds(Convert.toStrArray(ids));
	}

	/**
	 * 查询爱心点赞数据
	 * @return list
	 */
	public List<GiveLike> findGiveLikeByUserId(GiveLike giveLike){
		List<GiveLike> listGl = this.giveLikeMapper.findGiveLikeByUserId(giveLike);
		return listGl;
	}
}
