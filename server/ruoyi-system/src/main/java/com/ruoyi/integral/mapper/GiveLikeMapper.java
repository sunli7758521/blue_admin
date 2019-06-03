package com.ruoyi.integral.mapper;
import com.ruoyi.integral.domain.GiveLike;
import java.util.List;

/**
 * @author zhaoyan
 * @date 2018/12/20 14:26
 */
public interface GiveLikeMapper
{
    /**
     * 查询员工爱心点赞信息
     *
     * @param dId 员工爱心点赞ID
     * @return 员工爱心点赞信息
     */
    public GiveLike selectGiveLikeById(Integer dId);

    /**
     * 查询员工爱心点赞列表
     *
     * @param giveLike 员工爱心点赞信息
     * @return 员工爱心点赞集合
     */
    public List<GiveLike> selectGiveLikeList(GiveLike giveLike);

    /**
     * 新增员工爱心点赞
     *
     * @param giveLike 员工爱心点赞信息
     * @return 结果
     */
    public int insertGiveLike(GiveLike giveLike);

    /**
     * 修改员工爱心点赞
     *
     * @param giveLike 员工爱心点赞信息
     * @return 结果
     */
    public int updateGiveLike(GiveLike giveLike);

    /**
     * 删除员工爱心点赞
     *
     * @param dId 员工爱心点赞ID
     * @return 结果
     */
    public int deleteGiveLikeById(Integer dId);

    /**
     * 批量删除员工爱心点赞
     *
     * @param dIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteGiveLikeByIds(String[] dIds);

    /**
     * 查询爱心点赞数据
     * @return list
     */
    public List<GiveLike> findGiveLikeByUserId(GiveLike giveLike);
}
