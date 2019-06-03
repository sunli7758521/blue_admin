package com.ruoyi.web.controller.integral;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.constant.PicUrlConstants;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.integral.domain.IntegralGoods;
import com.ruoyi.integral.service.IIntegralGoodsService;
import com.ruoyi.web.core.base.BaseController;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 商品管理 信息操作处理
 * 
 * @author sunli
 * @date 2018-10-30
 */
@Controller
@RequestMapping("/integral/integralGoods")
public class IntegralGoodsController extends BaseController
{
    private String prefix = "integral/integralGoods";
	
	@Autowired
	private IIntegralGoodsService integralGoodsService;
	
	@RequiresPermissions("integral:integralGoods:view")
	@GetMapping()
	public String integralGoods()
	{
	    return prefix + "/integralGoods";
	}
	
	/**
	 * 查询商品管理列表
	 */
	@RequiresPermissions("integral:integralGoods:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(IntegralGoods integralGoods)
	{
		startPage();
        List<IntegralGoods> list = integralGoodsService.selectIntegralGoodsList(integralGoods);
		return getDataTable(list);
	}
	
	/**
	 * 新增商品管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存商品管理
	 */
	@RequiresPermissions("integral:integralGoods:add")
	@Log(title = "商品管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(IntegralGoods integralGoods )
	{

		return toAjax(integralGoodsService.insertIntegralGoods(integralGoods));
	}

	/**
	 * 修改商品管理
	 */
	@GetMapping("/edit/{goodId}")
	public String edit(@PathVariable("goodId") Integer goodId, ModelMap mmap)
	{
		IntegralGoods integralGoods = integralGoodsService.selectIntegralGoodsById(goodId);
		mmap.put("integralGoods", integralGoods);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存商品管理
	 */
	@RequiresPermissions("integral:integralGoods:edit")
	@Log(title = "商品管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(IntegralGoods integralGoods)
	{
		if (StringUtils.isEmpty(integralGoods.getGoodLbImg())){
			integralGoods.setGoodLbImg(integralGoodsService.selectIntegralGoodsById(integralGoods.getGoodId()).getGoodLbImg());
		}
		integralGoods.setUpdateTime(DateUtils.getNowDate());
		return toAjax(integralGoodsService.updateIntegralGoods(integralGoods));
	}
	
	/**
	 * 删除商品管理
	 */
	@RequiresPermissions("integral:integralGoods:remove")
	@Log(title = "商品管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(integralGoodsService.deleteIntegralGoodsByIds(ids));
	}

	@PostMapping(value = "/uploadFile")
	@Log(title = "上传图片",businessType = BusinessType.OTHER)
	@ApiOperation(value="上传图片", notes="上传图片")
	@ApiImplicitParam(name = "",value = "json对象",required = true)
	@ResponseBody
	public Map<String, Object> uploadFile(HttpServletRequest req){
		Map<String, Object> map = new HashMap<>();
		String pic = "" ;
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
		List<MultipartFile> multipartfiles = multipartRequest.getFiles("file");
		String picPath = PicUrlConstants.URL+PicUrlConstants.DRAWIMG;
		if(multipartfiles.size() > 0){
			for(MultipartFile file : multipartfiles) {
				try {

					/*String uuid = UUID.randomUUID().toString();
					file.getOriginalFilename();
					//String fileName = uuid + file.getOriginalFilename().replace("[","_");

                    String 	newFile = fileName.replace(",","a");
						file.transferTo(new File( picPath + newFile))
					pic = PicUrlConstants.HTTP_URL + newFile;;*/

					String uuid = UUID.randomUUID().toString();
					String ff = file.getOriginalFilename();
					String fileType = ff.substring(ff.lastIndexOf("."));
					String fileName = uuid+fileType;
					file.transferTo(new File( picPath + fileName));
					pic = PicUrlConstants.HTTP_URL + PicUrlConstants.DRAWIMG + fileName;


				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println(pic + "=====================");
		map.put("pic",pic);
		return map;
	}
	
}
