package com.ruoyi.web.controller.level;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.level.domain.LevelAss;
import com.ruoyi.level.service.ILevelAssService;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 水平考核 信息操作处理
 *
 * @author sunli
 * @date 2019-03-14
 */
@Controller
@RequestMapping("/level/levelAss")
public class LevelAssController extends BaseController
{
	private String prefix = "level/levelAss";

	@Autowired
	private ILevelAssService levelAssService;

	@Autowired
	private ISysDeptService deptService;

	@RequiresPermissions("level:levelAss:view")
	@GetMapping()
	public String levelAss()
	{
		return prefix + "/levelAss";
	}

	/**
	 * 查询水平考核列表
	 */
	@RequiresPermissions("level:levelAss:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(LevelAss levelAss)
	{
		startPage();
		List<LevelAss> list = levelAssService.selectLevelAssList(levelAss);
		return getDataTable(list);
	}

	/**
	 * 新增水平考核
	 */
	@GetMapping("/add/{parentId}")
	public String add(@PathVariable("parentId") Long  parentId,ModelMap mmap)
	{
		mmap.put("dept", deptService.selectDeptById(parentId));

	 return prefix + "/add";
}

	/**
	 * 新增保存水平考核
	 */
	@RequiresPermissions("level:levelAss:add")
	@Log(title = "水平考核", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(LevelAss levelAss)
	{
			Integer a	=ShiroUtils.getUserId().intValue();
		System.out.println(a+"aaaaaaaaaaaaaaaaasdsdsadasdddddddddd");
		levelAss.setUserId(a);
		return toAjax(levelAssService.insertLevelAss(levelAss));
	}

	/**
	 * 修改水平考核
	 */
	@GetMapping("/edit/{levelId}")
	public String edit(@PathVariable("levelId") Integer levelId, ModelMap mmap)
	{
		LevelAss levelAss = levelAssService.selectLevelAssById(levelId);
		mmap.put("levelAss", levelAss);
		return prefix + "/edit";
	}

	/**
	 * 修改保存水平考核
	 */
	@RequiresPermissions("level:levelAss:edit")
	@Log(title = "水平考核", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(LevelAss levelAss)
	{

        System.out.println(levelAss+"查看 打印出来我修改的值");
		return toAjax(levelAssService.updateLevelAss(levelAss));
	}

	/**
	 * 删除水平考核
	 */
	@RequiresPermissions("level:levelAss:remove")
	@Log(title = "水平考核", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{
		return toAjax(levelAssService.deleteLevelAssByIds(ids));
	}

	/**
	 * 禁用
	 */
	@GetMapping("/level/{levelId}/{state}")
	@ResponseBody
	public AjaxResult levellevelId(@PathVariable("levelId") String levelId,@PathVariable("state") String state)
	{
		System.out.println(levelId+"^^^^11111111111111111111111111111111111^");
		System.out.println(state);
		return toAjax(levelAssService.levellevelId(Integer.parseInt(levelId),Integer.parseInt(state)));
	}
}
