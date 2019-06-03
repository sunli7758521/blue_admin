package com.ruoyi.integral.mapper;

import com.ruoyi.integral.domain.IntegralAppExcel;

import java.util.List;

/**
 * @author zhaoyan
 * @Date 2019/3/1 13:49
 */
public interface IntegralAppExcelMapper {

     List<IntegralAppExcel> selectIaeTotal(IntegralAppExcel integralAppExcel);
}
