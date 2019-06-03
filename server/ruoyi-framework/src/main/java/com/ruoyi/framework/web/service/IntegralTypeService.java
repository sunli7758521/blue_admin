package com.ruoyi.framework.web.service;

import com.ruoyi.integral.domain.IntegralMenu;
import com.ruoyi.integral.domain.IntegralType;
import com.ruoyi.integral.service.IIntegralMenuService;
import com.ruoyi.integral.service.IIntegralTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  sun li 首创 html调用 thymeleaf 实现字典读取
 * @author sun li
 * @Date 2018/10/27 10:05
 * @Description
 */
@Service("type")
public class IntegralTypeService {

    @Autowired
    private IIntegralTypeService typeService;

    @Autowired
    private IIntegralMenuService iIntegralMenuService;

    /**
     * 获取积分类型查询字典数据信息
     *
     * @return 参数键值
     */
    public List<IntegralType> integralType()
    {
        return  typeService.integralType();
    }


    /**
     * 获取积分类型
     *
     * @return 参数键值
     */
    public List<IntegralMenu> getTypeName(String typeId){
        return iIntegralMenuService.getTypeName(typeId);
    }

}
