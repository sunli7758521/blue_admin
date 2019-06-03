package com.ruoyi.framework.web.service;

import com.ruoyi.integral.domain.IntegralSqfs;
import com.ruoyi.integral.service.IIntegralSqfsService;
import com.ruoyi.system.domain.SysDictData;
import com.ruoyi.system.service.ISysDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * RuoYi首创 html调用 thymeleaf 实现字典读取
 *
 * @author ruoyi
 */
@Service("dict")
public class DictService
{
    @Autowired
    private ISysDictDataService dictDataService;

    @Autowired
    private IIntegralSqfsService iIntegralSqfsService;
    /**
     * 根据字典类型查询字典数据信息
     *
     * @param dictType 字典类型
     * @return 参数键值
     */
    public List<SysDictData> getType(String dictType)
    {
        List<SysDictData> list = dictDataService.selectDictDataByType(dictType);
        return list;
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    public String getLabel(String dictType, String dictValue)
    {
        return dictDataService.selectDictLabel(dictType, dictValue);
    }

    /**
     * 查询申请方式
     *
     * @return 可申请方式
     */
    public List<IntegralSqfs> getSqfs()
    {
        return iIntegralSqfsService.getSqfs();
    }
}
