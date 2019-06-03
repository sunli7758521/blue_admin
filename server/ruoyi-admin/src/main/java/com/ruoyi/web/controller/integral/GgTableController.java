package com.ruoyi.web.controller.integral;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.integral.domain.GgTable;
import com.ruoyi.integral.service.IGgTableService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 广告图片 信息操作处理
 * 
 * @author sunli
 * @date 2018-11-06
 */
@Controller
@RequestMapping("/integral/ggTable")
public class GgTableController extends BaseController
{
    private String prefix = "integral/ggTable";
	
	@Autowired
	private IGgTableService ggTableService;
	
	@RequiresPermissions("integral:ggTable:view")
	@GetMapping()
	public String ggTable()
	{
	    return prefix + "/ggTable";
	}
	
	/**
	 * 查询广告图片列表
	 */
	@RequiresPermissions("integral:ggTable:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(GgTable ggTable)
	{
		startPage();
        List<GgTable> list = ggTableService.selectGgTableList(ggTable);
		for (GgTable table : list) {
			table.setgImgs(Constants.IMG_URL + table.getgImgs());
		}
		return getDataTable(list);
	}
	
	/**
	 * 新增广告图片
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存广告图片
	 */
	@RequiresPermissions("integral:ggTable:add")
	@Log(title = "广告图片", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(GgTable ggTable, @RequestParam("file") MultipartFile file)
	{		
		return toAjax(ggTableService.insertGgTable(ggTable));
	}

	/**
	 * 修改广告图片
	 */
	@GetMapping("/edit/{gId}")
	public String edit(@PathVariable("gId") Integer gId, ModelMap mmap)
	{
		GgTable ggTable = ggTableService.selectGgTableById(gId);
		mmap.put("ggTable", ggTable);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存广告图片
	 */
	@RequiresPermissions("integral:ggTable:edit")
	@Log(title = "广告图片", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(GgTable ggTable)
	{		
		return toAjax(ggTableService.updateGgTable(ggTable));
	}
	
	/**
	 * 删除广告图片
	 */
	@RequiresPermissions("integral:ggTable:remove")
	@Log(title = "广告图片", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(ggTableService.deleteGgTableByIds(ids));
	}
	
}
