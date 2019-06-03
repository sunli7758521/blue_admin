package com.ruoyi.web.controller.integral;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.constant.PicUrlConstants;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.integral.domain.IntegralDraw;
import com.ruoyi.integral.service.IIntegralDrawService;
import com.ruoyi.work.domain.Gzd;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.web.core.base.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 抽奖实现 信息操作处理
 * 
 * @author sunli
 * @date 2019-02-21
 */
@Controller
@RequestMapping("/integral/integralDraw")
public class IntegralDrawController extends BaseController
{
    private String prefix = "integral/integralDraw";
	
	@Autowired
	private IIntegralDrawService integralDrawService;
	
	@RequiresPermissions("integral:integralDraw:view")
	@GetMapping()
	public String integralDraw()
	{
	    return prefix + "/integralDraw";
	}
	
	/**
	 * 查询抽奖实现列表
	 */
	@RequiresPermissions("integral:integralDraw:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(IntegralDraw integralDraw)
	{
		startPage();
        List<IntegralDraw> list = integralDrawService.selectIntegralDrawList(integralDraw);
		return getDataTable(list);
	}
	/**
	 * 新增抽奖实现
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存抽奖实现
	 */
	@RequiresPermissions("integral:integralDraw:add")
	@Log(title = "抽奖实现", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(IntegralDraw integralDraw,@RequestParam("file") MultipartFile file)
	{
		if(integralDraw==null){
			return error();
		}
		String filePath = PicUrlConstants.URL+ PicUrlConstants.DRAWIMG;
		filePath = uploadFiles1(filePath,null, file);

		String picUrl = PicUrlConstants.HTTP_URL+filePath;
		integralDraw.setGoodsUrl(picUrl);
		integralDraw.setStatus("0");
		integralDraw.setCreateBy(getLoginName());
		integralDraw.setCreateTime(new Date());
		return toAjax(integralDrawService.insertIntegralDraw(integralDraw));
	}
	/** 保存上传图片 */
	private String uploadFiles1(String savePath,String origPath, MultipartFile file) {
		String url = null;
		try {
			if(file != null && !file.isEmpty()) {
				String uuid = UUID.randomUUID().toString();
				String fileName = uuid + "-" + file.getOriginalFilename();
				File newFile = new File(savePath + "/" + fileName);
				file.transferTo(newFile);
				url = PicUrlConstants.DRAWIMG + fileName;
			}
			/**
			 *删除原文件
			 */
			if(StringUtils.isNotBlank(origPath)){
				String[] split = origPath.split("/");
				String dir = split[3];
				String fileName = split[4];
				String filepath = PicUrlConstants.URL+dir+"/"+fileName;
				File origFile = new File(filepath);
				if(origFile.isFile())
					origFile.delete();
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}
	/**
	 * 回显图片
	 * @param gztId
	 * @return
	 */
	@GetMapping( "/loadImge/{id}")
	@ResponseBody
	public AjaxResult loadImge(@PathVariable String id, HttpServletResponse response){
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		ServletOutputStream out = null;
		if(StringUtils.isEmpty(id))return null;

		IntegralDraw  gzd = integralDrawService.selectIntegralDrawById(Integer.valueOf(id));
		if(gzd==null)return null;
		String url = gzd.getGoodsUrl();
		FileInputStream inputStream = null;
		try {
			String[] split = url.split("/");
			String dir = split[3];
			String fileName = split[4];
			String filepath = PicUrlConstants.URL+dir+"/"+fileName;
			inputStream = new FileInputStream(filepath);
			BufferedImage bi = ImageIO.read(inputStream);
			out = response.getOutputStream();
			ImageIO.write(bi,"png",out);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (inputStream!=null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	/**
	 * 修改抽奖实现
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		IntegralDraw integralDraw = integralDrawService.selectIntegralDrawById(id);
		mmap.put("integralDraw", integralDraw);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存抽奖实现
	 */
	@RequiresPermissions("integral:integralDraw:edit")
	@Log(title = "抽奖实现", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(IntegralDraw integralDraw, HttpServletRequest request)
	{
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
		if(integralDraw ==null){
			return error();
		}
		if(file!=null){
			String filePath = PicUrlConstants.URL+ PicUrlConstants.DRAWIMG;
			filePath = uploadFiles1(filePath,integralDraw.getGoodsUrl(), file);
			String picUrl = PicUrlConstants.HTTP_URL+filePath;
			integralDraw.setGoodsUrl(picUrl);
		}

		integralDraw.setUpdateBy(getLoginName());
		integralDraw.setUpdateTime(new Date());
		return toAjax(integralDrawService.updateIntegralDraw(integralDraw));
	}
	
	/**
	 * 删除抽奖实现
	 */
	@RequiresPermissions("integral:integralDraw:remove")
	@Log(title = "抽奖实现", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(integralDrawService.deleteIntegralDrawByIds(ids));
	}
	
}
