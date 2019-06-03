package com.ruoyi.web.controller.level;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.level.domain.LevelTitle;
import com.ruoyi.level.service.ILevelTitleService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 水平考核题目 信息操作处理
 * 
 * @author sunli
 * @date 2019-03-14
 */
@Controller
@RequestMapping("/level/levelTitle")
public class LevelTitleController extends BaseController
{
    private String prefix = "level/levelTitle";
	
	@Autowired
	private ILevelTitleService levelTitleService;
	
	@RequiresPermissions("level:levelTitle:view")
	@GetMapping("/listTitle/{levelId}")
	public String listTitle(@PathVariable("levelId") String levelId, ModelMap mmap)
	{
		/*rquest.getSession().setAttribute("levelId",levelId);*/
		mmap.put("levelId",levelId);
		    return prefix + "/levelTitle";
	}
	
	/**
	 * 查询水平考核题目列表
	 */
	/*@RequiresPermissions("level:levelTitle:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(String levelId)
	{
		startPage();

       // List<LevelTitle> list = levelTitleService.selectLevelTitleList(levelTitle);
		ist<LevelTitle> list = levelTitleService.selectLevelTitleList(levelTitle);
		return getDataTable(list);
	}*/



	/**
	 * 查询水平考核题目列表
	 */
	@RequiresPermissions("level:levelTitle:list")
	@PostMapping("/listTitle1/{levelId}")
	@ResponseBody
	public TableDataInfo list(@PathVariable("levelId") String levelId)
	{
		startPage();

		// List<LevelTitle> list = levelTitleService.selectLevelTitleList(levelTitle);
		List<LevelTitle> list = levelTitleService.selectLevelIdTitleList(levelId);
		return getDataTable(list);
	}




	/**
	 * 新增水平考核题目
	 */
	@GetMapping("/add/{levelId}")
	public String add(@PathVariable("levelId") String levelId, ModelMap mmap)
	{
		mmap.put("levelId",levelId);
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存水平考核题目
	 */
	@RequiresPermissions("level:levelTitle:add")
	@Log(title = "水平考核题目", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(LevelTitle levelTitle)
	{
		return toAjax(levelTitleService.insertLevelTitle(levelTitle));
	}

	/**
	 * 修改水平考核题目
	 */
	@GetMapping("/edit/{tId}")
	public String edit(@PathVariable("tId") Integer tId, ModelMap mmap)
	{
		LevelTitle levelTitle = levelTitleService.selectLevelTitleById(tId);
		mmap.put("levelTitle", levelTitle);
		return prefix + "/edit";
	}
	
	/**
	 * 修改保存水平考核题目
	 */
	@RequiresPermissions("level:levelTitle:edit")
	@Log(title = "水平考核题目", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(LevelTitle levelTitle)
	{
        System.out.println(levelTitle+"查看我的 修改的值");
		return toAjax(levelTitleService.updateLevelTitle(levelTitle));
	}
	
	/**
	 * 删除水平考核题目
	 */
	@RequiresPermissions("level:levelTitle:remove")
	@Log(title = "水平考核题目", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(levelTitleService.deleteLevelTitleByIds(ids));
	}


	
}
