package com.ruoyi.web.controller.integral;

import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.constant.PicUrlConstants;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.integral.domain.Integral;
import com.ruoyi.integral.domain.IntegralAppExcel;
import com.ruoyi.integral.domain.IntegralApproval;
import com.ruoyi.integral.service.IIntegralApprovalService;
import com.ruoyi.integral.service.IIntegralService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.web.core.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * 审批管理 信息操作处理
 *
 * @author sunli
 * @date 2018-10-24
 */
@Controller
@RequestMapping("/integral/excel")
public class IntegralExcelController extends BaseController
{
	private String prefix = "integral/integralBang";

	@Autowired
	private IIntegralApprovalService integralApprovalService;

	@Autowired
	private IIntegralService iIntegralService;

	@Autowired
	private ISysUserService sysUserService;



	@RequiresPermissions("integralBang:integralBang:view")
	@GetMapping()
	public String integralApproval()
	{
		return prefix + "/integralBangExcel";
	}

	/**
	 * 查询审批管理列表
	 */
	@RequiresPermissions("integralBang:integralBang:list")
	@PostMapping("/list")
	@ResponseBody  //
	public TableDataInfo list(IntegralAppExcel integralAppExcel)
	{
		startPage();
		//List<Map> list = integralApprovalService.selectIntegralBangExeclLists(integralApproval);
		List<IntegralAppExcel> lists = integralApprovalService.selectIaeTotal(integralAppExcel);
		return getDataTable(lists);
	}


	/**
	 * 导入
	 * importExcel
	 */
	@GetMapping("/impExcelPage")
	public String impExcelPage()
	{
		return prefix + "/importExcel";
	}


	@PostMapping("/importExcel")
	@ResponseBody
	@RequiresPermissions("integral:integralBang:importExcel")
	@Transactional(rollbackFor=Exception.class)
	public AjaxResult importExcel(@RequestParam("file") MultipartFile file){
		ExcelUtil<IntegralAppExcel> util = new ExcelUtil<IntegralAppExcel>(IntegralAppExcel.class);
		String message = "上传失败";
		boolean falg = false;
		int row = 1;
		List<Integral> iList = new ArrayList<Integral>();
		List<IntegralApproval> listias = new ArrayList<IntegralApproval>();
		List<SysUser> users = new ArrayList<SysUser>();
		try {
			File fileExcel = new File(PicUrlConstants.URL +file.getOriginalFilename());
			file.transferTo(fileExcel);
			InputStream is = new FileInputStream(fileExcel.getPath());
			List<IntegralAppExcel> list = util.importExcel(is);
			for(IntegralAppExcel ie : list){
				String username = ie.getUserName();
				String depname = ie.getDepName();
				String postname = ie.getPostName();
				SysUser user = sysUserService.findByudpName(username,depname,postname);
				/**根据 for 循环查询出来 用户信息*/
				if(user==null){
					message = "第"+row+"行"+username+"用户不存在";
					falg = true;
					break;
				}
				Long userIc=user.getUserId();//获取到用户的id
				String name =user.getUserName();
				/*		Integer postid = Integer.parseInt(String.valueOf(postiid));*/
				System.out.println(name+"看到我的值为几？？？");
				System.out.println(userIc+"看到我了啦啦啦啦啦啦啦");

				Integer userId=Integer.parseInt(String.valueOf(userIc));//强转类型
				System.out.println(userId+"我的结果是啥");
				String jifen=ie.getJifen();
				System.out.println(jifen+"分为多少啊？？"+"==============================");
				Integral zhi=iIntegralService.selectdanbiao(userId,name);
				System.out.println(zhi+"看到我了没？？？、");
				Integer zzong	 =	zhi.getCountIntegral();//获取总分数

				Integer fen	  =Integer.parseInt(String.valueOf(jifen));
				Integer qian   = zhi.getGoodCountIntegral();//获取到 之前的积分商城的值
				Integer zongfen=fen+qian;
				String ainte = ie.getAinte();//A积分
				String binte = ie.getBinte();//B积分
				String cinte = ie.getCinte();//c积分
				String maInte = ie.getMaInte();//管理奖扣积分
				String freeInte = ie.getFreeInte();//自由奖扣总分
				String loveInte = ie.getLoveInte();//爱心点赞积分
				String checkInte = ie.getCheckInte();//积分支票积分
				String orInte = ie.getOrInte();//悬赏任务积分
				String bsinte = ie.getBasInte();//基础积分
				String mininte = ie.getMinusInte();//扣除积分
				String total = ie.getCount();//总积分
				Integer zf=Integer.parseInt(String.valueOf(total));//强转类型
				Integer  zfz   =zf+zzong; //这个是我输入的分加上我之前的总分
				IntegralApproval a = this.setInteApp(user,ainte,1);
				IntegralApproval b = this.setInteApp(user,binte,2);
				IntegralApproval c = this.setInteApp(user,cinte,3);
				IntegralApproval ma = this.setInteApp(user,maInte,4);
				IntegralApproval free = this.setInteApp(user,freeInte,5);
				IntegralApproval love = this.setInteApp(user,loveInte,6);
				IntegralApproval check = this.setInteApp(user,checkInte,7);
				IntegralApproval or = this.setInteApp(user,orInte,8);
				IntegralApproval d = this.setMinusInte(user,mininte);
				Integral integral = this.setIntegral(user,zfz,zongfen);
				user = sysUserService.selectUserById(user.getUserId());
				user.setJiChuIntegral(Integer.valueOf(bsinte));//更新基础积分
				listias.add(a);
				listias.add(b);
				listias.add(c);
				listias.add(ma);
				listias.add(free);
				listias.add(love);
				listias.add(check);
				listias.add(or);
				iList.add(integral);
				users.add(user);
				row++;
			}
			if(falg){
				return AjaxResult.error(message);
			}
			integralApprovalService.insertBathch(listias,iList,users);
			message = "上传成功";
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//回滚
			e.printStackTrace();
		}
		return AjaxResult.success(message);
	}

	public IntegralApproval setInteApp(SysUser user,String ainte,Integer typeid){
		IntegralApproval al = new IntegralApproval();
		al.setApprovalNum("JFB"+ DateUtils.dateTime());
		/*1.品德 2 业绩 3行为 4.管理 5自由奖扣 6.爱心点赞.7 积分支票  8悬赏任务*/
		String typeName = null;
		if(typeid==1){
			typeName = "A品德总积分";
		}else if(typeid==2){
			typeName = "B业绩总积分";
		}else if(typeid==3){
			typeName = "C行为总积分";
		}else if(typeid==4){
			typeName = "管理奖扣总积分";
		}else if(typeid==5){
			typeName = "自由奖扣总分";
		}else if(typeid==6){
			typeName = "爱心点赞总分";
		}else if(typeid==7){
			typeName = "积分支票总分";
		}else if(typeid==8){
			typeName = "悬赏任务总分";
		}
		String ph = user.getPhonenumber();
		String post = user.getPostId();
		al.setApprovalTitle(typeName);
		al.setUserId(user.getUserId().intValue());
		al.setUserName(user.getUserName());
		if(StringUtils.isNotEmpty(ph)){
			al.setUserPhone(Long.valueOf(ph));
		}
		if(StringUtils.isNotEmpty(post)){
			al.setUserPostId(Integer.valueOf(post));
		}
		al.setUserDeptId(user.getDeptId().intValue());
		al.setUserDept(user.getRemark());
		al.setUserPost(user.getPostName());
		al.setTiJiaoId(user.getUserId());
		al.setTiJiaoName(user.getUserName());
		al.setIntegralTypeId(typeid);
		al.setSqTime(new Date());
		al.setSpTime(new Date());
		al.setStatus(1);
		al.setSqIntegral(Integer.valueOf(ainte));
		al.setApprovalTime(new Date());
		return al;
	}

	/**
	 * 积分榜赋值
	 * @return
	 */
	public Integral setIntegral(SysUser user,Integer zfz,Integer zongfen){
		Map<String,Object> map = new HashMap<String,Object>();
		Long userid = user.getUserId();
		Long deptId = user.getDeptId();
		String postId = user.getPostId();
		map.put("userId",userid);
		map.put("deptId",deptId);
		map.put("postId",postId);
		Integral integral = null;
		integral = iIntegralService.findIntegralByDpu(map);
		if(integral == null)
			integral = new Integral();
		integral.setUserId(userid.intValue());
		integral.setUserName(user.getUserName());
		integral.setUserPhone(user.getPhonenumber());
		integral.setCountIntegral(zfz);
		integral.setGoodCountIntegral(zongfen);
		integral.setDeptId(deptId.intValue());
		integral.setPostId(Integer.valueOf(user.getPostId()));
		return  integral;
	}

	public IntegralApproval setMinusInte(SysUser user,String ainte){
		String ph = user.getPhonenumber();
		String post = user.getPostId();
		IntegralApproval al = new IntegralApproval();
		al.setApprovalNum("JFB"+ DateUtils.dateTime());
		/*1.品德 2 业绩 3行为 4.管理 5自由奖扣 6.爱心点赞.7 积分支票  8悬赏任务*/
		if(StringUtils.isNotEmpty(ph)){
			al.setUserPhone(Long.valueOf(ph));
		}
		if(StringUtils.isNotEmpty(post)){
			al.setUserPostId(Integer.valueOf(post));
		}
		al.setApprovalTitle("扣除积分");
		al.setUserId(user.getUserId().intValue());
		al.setUserName(user.getUserName());
		al.setUserDeptId(user.getDeptId().intValue());
		al.setUserDept(user.getRemark());
		al.setUserPost(user.getPostName());
		al.setTiJiaoId(user.getUserId());
		al.setTiJiaoName(user.getUserName());
		al.setkIntegral(Integer.valueOf(ainte));
		al.setSqTime(new Date());
		al.setSpTime(new Date());
		al.setStatus(1);
		al.setApprovalTime(new Date());
		return al;
	}

	/**
	 * 导出
	 * importExcel
	 */
	@PostMapping("/export")
	@ResponseBody
	public AjaxResult exportExcelPage(IntegralAppExcel integralAppExcel)
	{
		List<IntegralAppExcel> lists = integralApprovalService.selectIaeTotal(integralAppExcel);
		ExcelUtil<IntegralAppExcel> util = new ExcelUtil<IntegralAppExcel>(IntegralAppExcel.class);
		return util.exportExcel(lists, "积分榜统计");
	}

}
