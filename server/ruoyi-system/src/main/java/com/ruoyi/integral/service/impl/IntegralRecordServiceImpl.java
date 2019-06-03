package com.ruoyi.integral.service.impl;

import com.ruoyi.common.support.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.integral.domain.Integral;
import com.ruoyi.integral.domain.IntegralGoods;
import com.ruoyi.integral.domain.IntegralRecord;
import com.ruoyi.integral.domain.IntegralRecordLog;
import com.ruoyi.integral.mapper.IntegralGoodsMapper;
import com.ruoyi.integral.mapper.IntegralMapper;
import com.ruoyi.integral.mapper.IntegralRecordLogMapper;
import com.ruoyi.integral.mapper.IntegralRecordMapper;
import com.ruoyi.integral.service.IIntegralRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品兑换记录 服务层实现
 * 
 * @author sunli
 * @date 2018-10-30
 */
@Service
public class IntegralRecordServiceImpl implements IIntegralRecordService 
{
	@Autowired
	private IntegralRecordMapper integralRecordMapper;

	@Autowired
	private IntegralMapper integralMapper;

	@Autowired
	private IntegralGoodsMapper integralGoodsMapper;

	@Autowired
	private IntegralRecordLogMapper integralRecordLogMapper;

	/**
     * 查询商品兑换记录信息
     * 
     * @param recordId 商品兑换记录ID
     * @return 商品兑换记录信息
     */
    @Override
	public IntegralRecord selectIntegralRecordById(Integer recordId)
	{
	    return integralRecordMapper.selectIntegralRecordById(recordId);
	}
	
	/**
     * 查询商品兑换记录列表
     * 
     * @param integralRecord 商品兑换记录信息
     * @return 商品兑换记录集合
     */
	@Override
	public List<IntegralRecord> selectIntegralRecordList(IntegralRecord integralRecord)
	{
	    return integralRecordMapper.selectIntegralRecordList(integralRecord);
	}
	
    /**
     * 新增商品兑换记录
     * 
     * @param integralRecord 商品兑换记录信息
     * @return 结果
     */
	@Override
	public int insertIntegralRecord(IntegralRecord integralRecord)
	{
	    return integralRecordMapper.insertIntegralRecord(integralRecord);
	}
	
	/**
     * 修改商品兑换记录
     * 
     * @param integralRecord 商品兑换记录信息
     * @return 结果
     */
	@Override
	public int updateIntegralRecord(IntegralRecord integralRecord)
	{
	    return integralRecordMapper.updateIntegralRecord(integralRecord);
	}

	/**
     * 删除商品兑换记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteIntegralRecordByIds(String ids)
	{
		return integralRecordMapper.deleteIntegralRecordByIds(Convert.toStrArray(ids));
	}

	/**
	 * 修改审批状态 添加商品记录日志 以及修改商品所对应的积分
	 */
	@Override
	public int successStatus(int recordId, int status) {
		IntegralRecord record = integralRecordMapper.selectIntegralRecordById(recordId);
		Integer ii = null;
		if(status==1){
			if(record.getUserId()!=null){
				//更改积分表
		//	Integral integral =	integralMapper.selectUsernameAndPhone(record.getUserName(),record.getUserPhone()+"");
				Integral integral =	integralMapper.selectByUserId(record.getUserId()+"");
			record.setSyIntegral(integral.getCountIntegral());
			record.setShTime(DateUtils.getNowDate());
			record.setDhCreateTime(DateUtils.getNowDate());
			record.setStatus(1);
		 ii = integralRecordMapper.updateIntegralRecord(record);
			//添加商品日志记录
			IntegralRecordLog log = new IntegralRecordLog();
			log.setGId(record.getGId());
				log.setDhCreateTime(record.getDhCreateTime());
				log.setDhIntegral(record.getDhIntegral());
				log.setRecordImg(record.getRecordImg());
				log.setRecordName(record.getRecordName());
				log.setShTime(DateUtils.getNowDate());
				log.setSyIntegral(integral.getCountIntegral());
				log.setUserName(record.getUserName());
				log.setUserPhone(record.getUserPhone());
				log.setStatus(0);
				integralRecordLogMapper.insertIntegralRecordLog(log);
			}
		}
		else if(status == 2){
			record.setStatus(2);
			record.setShTime(DateUtils.getNowDate());
			record.setDhCreateTime(DateUtils.getNowDate());
			/** 更新积分表的总积分和添加积分 */
			record.setSyIntegral(getSyIntegral(record));
			/** 更新产品的剩余数量和库存数 */
		    int row  =	updateGoodKuAndDhNum(record);
			/** 更新产品的剩余数量和库存数 */
			//int rows =	updateIntegral(record);

			ii = integralRecordMapper.updateIntegralRecord(record);

		}
		return ii;
	}
	/** 更新产品的剩余数量和库存数 */
	private int updateGoodKuAndDhNum(IntegralRecord record) {
		IntegralGoods good = integralGoodsMapper.selectIntegralGoodsById(record.getGId());
		good.setYdhNum(good.getYdhNum()+1);
		good.setGoodCount(good.getGoodCount() + 1);
		good.setGoodKc(good.getGoodKc()+1);
	int row =	integralGoodsMapper.updateIntegralGoods(good);
	return row;
	}

	/** 更新积分表的总积分和添加积分 */
	private Integer getSyIntegral(IntegralRecord record) {
		Integral integral = integralMapper.selectByUserId(record.getUserId()+"");
		if(integral !=null){
			integral.setCountIntegral(integral.getCountIntegral() + record.getDhIntegral());
			integral.setDelIntegral(integral.getDelIntegral()- record.getDhIntegral());
			integral.setAddIntegral(integral.getAddIntegral() + record.getDhIntegral());
			integral.setGoodCountIntegral(integral.getGoodCountIntegral() + record.getDhIntegral());
		int row = integralMapper.updateIntegral(integral);
		}
		Integer count =	integral.getCountIntegral();
		return count;
	}

}
