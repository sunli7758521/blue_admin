package com.ruoyi.web.controller.work;

import com.google.common.net.HttpHeaders;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.PicUrlConstants;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.web.core.base.BaseController;
import com.ruoyi.work.domain.Gzd;
import com.ruoyi.work.service.IGzdService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * 工作台应用管理 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-10-24
 */
@Controller
@RequestMapping("/work/gzd")
public class GzdController extends BaseController
{
    private String prefix = "work/gzd";
	
	@Autowired
	private IGzdService gzdService;
	
	@RequiresPermissions("work:gzd:view")
	@GetMapping()
	public String gzd()
	{
		System.out.println(12);
		return prefix + "/gzd";
	}
	
	/**
	 * 查询工作台应用管理列表
	 */
	@RequiresPermissions("work:gzd:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Gzd gzd)
	{
		startPage();
        List<Gzd> list = gzdService.selectGzdList(gzd);
		for (Gzd gz : list) {
			// gz.setYyImg(Constants.IMG_URL + gz.getYyImg());
			gz.setYyImg(gz.getYyImg());
		}
		return getDataTable(list);
	}
	
	/**
	 * 新增工作台应用管理
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存工作台应用管理
	 *   上传图片
	 */
	@RequiresPermissions("work:gzd:add")
	@Log(title = "工作台应用管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public  Map<String, Object> addSave(Gzd gzd, @RequestParam("file") MultipartFile file)
	{
		if(gzd==null){
			return error();
		}
		String filePath = PicUrlConstants.URL+PicUrlConstants.GZTIMG;
		filePath = addUploadFiles(filePath, file);
		gzd.setYyImg(PicUrlConstants.HTTP_URL+filePath);
		gzd.setStatus("0");
		gzd.setCreateTime(new Date());
		this.gzdService.insertGzd(gzd);
		return success();
	}

	/**
	 * 保存文件
	 * @param savePath 保存路径
	 * @param origPath 源文件
	 * @param file 上传文件
	 * @return
	 */
	private String addUploadFiles(String filePath,  MultipartFile file) {
		String url = null;
		try {
			if(file != null && !file.isEmpty()) {
				String uuid = UUID.randomUUID().toString();
				String ff = file.getOriginalFilename();
				String fileType = ff.substring(ff.lastIndexOf("."));
				String fileName = uuid+fileType;
				file.transferTo(new File( filePath + fileName));
				url = PicUrlConstants.GZTIMG + fileName;
//				file.
//				String uuid = UUID.randomUUID().toString();
//				String fileName = uuid + "/" + file.getOriginalFilename();
//				File newFile = new File(filePath + "/" + fileName);
//				file.transferTo(newFile);
//				url = PicUrlConstants.GZTIMG+fileName;
			}

		}catch (Exception e) {

			e.printStackTrace();
		}
		return url;
	}

	/**
	 * 保存文件
	 * @param savePath 保存路径
	 * @param origPath 源文件
	 * @param file 上传文件
	 * @return
	 */
	public  String uploadFiles(String savePath,String origPath, MultipartFile file){
		String url = null;
		try {
			if(file != null && !file.isEmpty()) {
				String uuid = UUID.randomUUID().toString();
				String fileName = uuid + "/" + file.getOriginalFilename();
				File newFile = new File(savePath + "/" + fileName);
				file.transferTo(newFile);
				url = PicUrlConstants.GZTIMG+fileName;
			}
			/**
			 *删除原文件
			 */
			if(StringUtils.isNotEmpty(origPath)){
				String[] split = origPath.split("/");
				String dir = split[3];
				String fileName = split[4];
				String filepath = PicUrlConstants.URL+dir+"/"+fileName;
				File origFile = new File(filepath);
				if(origFile.isFile())
					origFile.delete();
			}
		}catch (Exception e) {
			url = null;
			e.printStackTrace();
		}
		return url;
	}

	/**
	 * 修改工作台应用管理
	 */
	@GetMapping("/edit/{gztId}")
	public String edit(@PathVariable("gztId") Integer gztId, ModelMap mmap)
	{
		Gzd gzd = gzdService.selectGzdById(gztId);
		mmap.put("gzd", gzd);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存工作台应用管理
	 */
	@RequiresPermissions("work:gzd:edit")
	@Log(title = "工作台应用管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Gzd gzd, HttpServletRequest request)
	{
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
		if(gzd==null){
			return error();
		}
		if(file!=null){
			String filePath = PicUrlConstants.URL+PicUrlConstants.GZTIMG;
			filePath = uploadFiles(filePath,gzd.getYyImg(), file);
			gzd.setYyImg(PicUrlConstants.HTTP_URL+filePath);
		}
		gzd.setUpdateTime(new Date());
		this.gzdService.updateGzd(gzd);
		return success();
	}
	
	/**
	 * 删除工作台应用管理
	 */
	@RequiresPermissions("work:gzd:remove")
	@Log(title = "工作台应用管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(gzdService.deleteGzdByIds(ids));
	}


	/**
	 * 回显图片
	 * @param gztId
	 * @return
	 */
	@RequiresPermissions("work:gzd:loadImge")
	@GetMapping( "/loadImge/{gztId}")
	@ResponseBody
	public AjaxResult loadImge(@PathVariable String gztId,HttpServletResponse response){
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		ServletOutputStream out = null;
		if(StringUtils.isEmpty(gztId))return null;
		Gzd gzd = gzdService.selectGzdById(Integer.valueOf(gztId));
		if(gzd==null)return null;
		String url = gzd.getYyImg();
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
	 * 启用工作台应用管理
	 */
	@Transactional(rollbackFor=Exception.class)
	@RequiresPermissions("work:gzd:unlock")
	@Log(title = "工作台应用管理", businessType = BusinessType.UPDATE)
	@PostMapping( "/unlock")
	@ResponseBody
	public AjaxResult unlock(String ids)
	{
		boolean flag = false;
		try{
			String[] sts = ids.split(",");
			for(String s : sts){
				Gzd gzd = gzdService.selectGzdById(Integer.valueOf(s));
				gzd.setStatus("0");
				int i = gzdService.updateGzd(gzd);
				if(i!=1){
					flag = true;
				}
			}
		}catch (Exception e){
			e.printStackTrace();
			flag = true;
		}
		if(flag)
			return error();

		return success();
	}

	/**
	 * 停用工作台应用管理
	 */
	@Transactional(rollbackFor=Exception.class)
	@RequiresPermissions("work:gzd:lock")
	@Log(title = "工作台应用管理", businessType = BusinessType.UPDATE)
	@PostMapping( "/lock")
	@ResponseBody
	public AjaxResult lock(String ids)
	{
		boolean flag = false;
		try{
			String[] sts = ids.split(",");
			for(String s : sts){
				Gzd gzd = gzdService.selectGzdById(Integer.valueOf(s));
				gzd.setStatus("1");
				int i = gzdService.updateGzd(gzd);
				if(i!=1){
					flag = true;
				}
			}
		}catch (Exception e){
			e.printStackTrace();
			flag = true;
		}
		if(flag)
			return error();

		return success();
	}


	/**
	 * 停用工作台应用管理
	 */
	@Transactional(rollbackFor=Exception.class)
	@RequiresPermissions("work:gzd:lottery")
	@Log(title = "工作台应用管理", businessType = BusinessType.UPDATE)
	@PostMapping( "/lotteryUpdate")
	@ResponseBody
	public AjaxResult lotteryUpdate(String id,String lottery)
	{
		Gzd gzd = gzdService.selectGzdById(Integer.valueOf(id));
		gzd.setLotteryStatus(lottery);
		return toAjax(gzdService.updateGzd(gzd));
	}

	/** 工作台启用 禁用 */
	@Transactional(rollbackFor=Exception.class)
	@RequiresPermissions("work:gzd:qj")
	@Log(title = "工作台应用管理", businessType = BusinessType.UPDATE)
	@PostMapping( "/qj")
	@ResponseBody
	public AjaxResult qj(String id,String status)
	{
		Gzd gzd = gzdService.selectGzdById(Integer.valueOf(id));
		if(status.equalsIgnoreCase("0")){
			gzd.setStatus("1");
		}else if(status.equalsIgnoreCase("1")){
			gzd.setStatus("0");
		}
		return toAjax(gzdService.updateGzd(gzd));
	}
}
