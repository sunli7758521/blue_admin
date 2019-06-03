package com.ruoyi.integral.service.impl;

import com.ruoyi.common.constant.IntegralConstants;
import com.ruoyi.common.support.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.integral.domain.Integral;
import com.ruoyi.integral.domain.IntegralApproval;
import com.ruoyi.integral.domain.IntegralJk;
import com.ruoyi.integral.domain.IntegralLog;
import com.ruoyi.integral.mapper.IntegralApprovalMapper;
import com.ruoyi.integral.mapper.IntegralJkMapper;
import com.ruoyi.integral.mapper.IntegralLogMapper;
import com.ruoyi.integral.mapper.IntegralMapper;
import com.ruoyi.integral.service.IIntegralJkService;
import com.ruoyi.system.domain.SysDept;
import com.ruoyi.system.domain.SysPost;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.domain.SysUserPost;
import com.ruoyi.system.mapper.SysDeptMapper;
import com.ruoyi.system.mapper.SysPostMapper;
import com.ruoyi.system.mapper.SysUserMapper;
import com.ruoyi.system.mapper.SysUserPostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 积分奖扣 服务层实现
 * 
 * @author sunli
 * @date 2018-10-25
 */
@Service
@Transactional
public class IntegralJkServiceImpl implements IIntegralJkService {
	@Autowired
	private IntegralJkMapper integralJkMapper;

	@Autowired
	private IntegralMapper integralMapper;

	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private IntegralLogMapper integralLogMapper;

	@Autowired
	private IntegralApprovalMapper integralApprovalMapper;

	@Autowired
	private SysDeptMapper sysDeptMapper;

	@Autowired
	private SysUserPostMapper sysUserPostMapper;
	@Autowired
	private SysPostMapper sysPostMapper;


	/**
	 * 查询积分奖扣信息
	 *
	 * @param jkId 积分奖扣ID
	 * @return 积分奖扣信息
	 */
	@Override
	public IntegralJk selectIntegralJkById(Integer jkId) {
		return integralJkMapper.selectIntegralJkById(jkId);
	}

	/**
	 * 查询积分奖扣列表
	 *
	 * @param integralJk 积分奖扣信息
	 * @return 积分奖扣集合
	 */
	@Override
	public List<IntegralJk> selectIntegralJkList(IntegralJk integralJk) {
		return integralJkMapper.selectIntegralJkList(integralJk);
	}

	/**
	 * 新增积分奖扣
	 *
	 * @param integralJk 积分奖扣信息
	 * @return 结果
	 *//*
	@Override
	public int insertIntegralJk(IntegralJk integralJk, String[] jkNames) {
		integralJk.setJkNum("JKB" + DateUtils.dateTime());
		if (integralJk.getJkTime() != null) {
			integralJk.setJkTime(integralJk.getJkTime());
		}
		integralJk.setJkTime(new Date());
		*//** 根据部门id 和 员工姓名 查询员工*//*
		for (String jkName : jkNames) {
			Integral integral = null;
			if (integralJk.getDeptId() == null) {
				integral = getUserName(jkName);
				integralJk.setJkName(jkName);
			}
			else {
				SysUser sysUser = sysUserMapper.selectUserNameAndDeptId(integralJk.getDeptId(), jkName);
				integral = getUserName(sysUser.getUserName());
				integralJk.setJkName(jkName);
			}
			if (integralJk.getjIntegral() != null && integralJk.getjIntegral() > 0) {
				integralJk.setjIntegral(integralJk.getjIntegral());
				integral.setCountIntegral(integral.getCountIntegral() + integralJk.getjIntegral());
				if (integral.getAddIntegral() == null) {
					integral.setAddIntegral(0 + integralJk.getjIntegral());
				}
				else {
					integral.setAddIntegral(integral.getAddIntegral() + integralJk.getjIntegral());
				}
			}
			if (integralJk.getkIntegral() != null && integralJk.getkIntegral() > 0) {
				integralJk.setkIntegral(integralJk.getkIntegral());
				integral.setCountIntegral(integral.getCountIntegral() - integralJk.getkIntegral());
				if (integral.getDelIntegral() == null) {
					integral.setDelIntegral(0 + integralJk.getkIntegral());
				}
				else {
					integral.setDelIntegral(integral.getDelIntegral() + integralJk.getkIntegral());
				}
				integralJk.setkIntegral(integralJk.getkIntegral());
			}
			//修改积分
			int integraNum = integralMapper.updateIntegral(integral);
			//添加日志
			int log = insertIntegralLog(integralJk);
			//添加审批管理
			//int IntegralApproval = insertIntegralApproval(integralJk);
			//添加积分奖扣
			int integralNum = integralJkMapper.insertIntegralJk(integralJk);
		}
		return 1;
	}*/

	/**
	 * 添加审批积分奖扣信息
	 *
	 * @param
	 * @param integralJk
	 * @return 结果
	 */
	private int insertIntegralApproval(IntegralJk integralJk, SysUser user) {
		SysUserPost userPost = sysUserPostMapper.selectUserById(user.getUserId());

		IntegralApproval integralApproval = new IntegralApproval();
		integralApproval.setUserDept(integralJk.getDeptName());
		integralApproval.setUserPostId(userPost.getPostId().intValue());
		integralApproval.setUserPost(sysPostMapper.selectPostById(userPost.getPostId()).getPostName());
		integralApproval.setUserDeptId(user.getDeptId().intValue());
		integralApproval.setUserPhone(Long.parseLong(user.getPhonenumber()));
		integralApproval.setSpTime(integralJk.getJkTime());
		integralApproval.setStatus(1);
		integralApproval.setTypeId(integralJk.getTypeId());
		integralApproval.setApprovalContent(integralJk.getJkTitle());
		integralApproval.setApprovalNum(integralJk.getJkNum());
		integralApproval.setIntegralTypeId(integralJk.getTypeId());
		integralApproval.setUserName(integralJk.getJkName());
		integralApproval.setUserImg(integralJk.getJkImg());
		integralApproval.setSqIntegral(integralJk.getjIntegral());
		integralApproval.setkIntegral(integralJk.getkIntegral());
		return integralApprovalMapper.insertIntegralApproval(integralApproval);
	}

	/**
	 * 添加日志积分奖扣信息
	 *
	 * @param
	 * @param integralJk
	 * @return 结果
	 */
//	private int insertIntegralLog(IntegralJk integralJk, SysUser user) {
//		SysUserPost userPost = sysUserPostMapper.selectUserById(user.getUserId());
//
//		IntegralLog log = new IntegralLog();
//		// 管理奖扣 integralJk.getTypeId()
//		log.setTypeId(4);
//		log.setUserPhone(Long.parseLong(user.getPhonenumber()));
//		log.setUserPost(sysPostMapper.selectPostById(userPost.getPostId()).getPostName());
//		log.setStatus(IntegralConstants.ZY_INTEGRAL);
//		log.setGetTime(integralJk.getJkTime());
//		log.setIntegralTitle(integralJk.getJkTitle());
//		log.setBianIntegral(integralJk.getjIntegral());
//		log.setTypeId(integralJk.getTypeId());
//		log.setkIntegral(integralJk.getkIntegral());
//		log.setUserName(integralJk.getJkName());
//		log.setApprovalNum(integralJk.getJkNum());
//		log.setUserDept(integralJk.getDeptName());
//		log.setUserImg(integralJk.getJkImg());
//		log.setIntegralContent(integralJk.getJkTitle());
//		return integralLogMapper.insertIntegralLog(log);
//	}

	/**
	 * 根据用户名查询积分
	 *
	 * @param userName 积分奖扣信息
	 * @return 结果
	 */
	private Integral getUserName(String userName) {

		return integralMapper.selectUserName(userName);
	}

	/**
	 * 修改积分奖扣
	 *
	 * @param integralJk 积分奖扣信息
	 * @return 结果
	 */
	@Override
	public int updateIntegralJk(IntegralJk integralJk) {
		return integralJkMapper.updateIntegralJk(integralJk);
	}

	/**
	 * 删除积分奖扣对象
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteIntegralJkByIds(String ids) {
		return integralJkMapper.deleteIntegralJkByIds(Convert.toStrArray(ids));
	}

	/**
	 * 批量添加员工奖扣
	 */
	@Override
	public int insertIntegralUserList(IntegralJk integralJk) {

		int row = 0;
		/** 所用的员工的 ids*/
		String[] ids = integralJk.getIds().split(",");
		for (String userId : ids) {
			IntegralApproval ia = new IntegralApproval();
			//管理奖扣类型
			//ia.setTypeId(integralJk.getTypeId());
			ia.setIntegralTypeId(integralJk.getTypeId());
			ia.setUserId(Integer.parseInt(userId));
			SysUser user = sysUserMapper.selectUserById(Long.parseLong(userId));
			ia.setUserName(user.getUserName());
			SysUserPost userPost = sysUserPostMapper.selectUserById(Long.parseLong(userId));
			if (userPost != null) {
				ia.setUserPostId(userPost.getPostId().intValue());
			}
			SysPost post = sysPostMapper.selectPostById(userPost.getPostId());
			if (post != null) {
				ia.setUserPost(post.getPostName());
			}
//		    SysUser sysUser = ShiroUtils.getUserEntity();
//		if(sysUser !=null){
//			ia.setTiJiaoId(sysUser.getUserId());
//			ia.setUserName(sysUser.getUserName());
//		}
			ia.setApprovalTitle(integralJk.getJkTitle());
			ia.setApprovalContent(integralJk.getJkDescribe());
			ia.setApprovalTime(new Date());
			ia.setSpTime(new Date());
			ia.setSqTime(new Date());
			if (integralJk.getjIntegral() != null) {
				ia.setSqIntegral(integralJk.getjIntegral());
			} else {
				ia.setSqIntegral(0);
			}
			if (integralJk.getkIntegral() != null) {
				ia.setkIntegral(integralJk.getkIntegral());
			} else {
				ia.setkIntegral(0);
			}
			ia.setApprovalNum("JKB" + DateUtils.dateTime());
			ia.setUserDeptId(user.getDeptId().intValue());

			SysDept dept = sysDeptMapper.selectDeptById(user.getDeptId());
			if (dept != null) {
				ia.setUserDept(dept.getDeptName());
			}
			// 管理奖扣不用审批
			ia.setStatus(1);
			// 添加审批表
			row = integralApprovalMapper.insertIntegralApproval(ia);


			if (row > 0) {
				System.out.println("成功");
			} else {
				System.out.println("失败");
			}
			// 添加审批日志表
			//insertIntegralLog(integralJk, user);
			//更新积分表的商城的good
			Integral integral = integralMapper.selectByUserId(userId);

			synchronized (integral){
				// 奖励
				if (StringUtils.isNotNull(integralJk.getjIntegral()) && integralJk.getjIntegral() > 0) {
					integral.setCountIntegral(integral.getCountIntegral() + integralJk.getjIntegral());
					integral.setGoodCountIntegral(integral.getGoodCountIntegral() + integralJk.getjIntegral());

//					if (integral.getAddIntegral() == null) {
//						integral.setAddIntegral(0 + integralJk.getjIntegral());
//					} else {
//						integral.setAddIntegral(integral.getAddIntegral() + integralJk.getjIntegral());
//					}
				}
				// 扣除积分商城 显示积分
				if (StringUtils.isNotNull(integralJk.getkIntegral()) && integralJk.getkIntegral() > 0) {
//					if (integral.getDelIntegral() == null) {
//						integral.setDelIntegral(0 + integralJk.getkIntegral());
//					} else {
//						integral.setDelIntegral(integral.getDelIntegral() + integralJk.getkIntegral());
//					}
					integral.setCountIntegral(integral.getCountIntegral() - integralJk.getkIntegral());
					integral.setGoodCountIntegral(integral.getGoodCountIntegral() - integralJk.getkIntegral());
				}
				//修改积分
				int integraNum = integralMapper.updateIntegral(integral);
			}


			// 添加日志
			IntegralLog log = new IntegralLog();
			log.setTypeId(integralJk.getTypeId());
			log.setUserId(Integer.parseInt(userId));
			log.setUserName(user.getUserName());
			if (post != null) {
				log.setUserPost(post.getPostName());
			}
			log.setIntegralTitle(integralJk.getJkTitle());
			log.setIntegralContent(integralJk.getJkDescribe());

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			log.setGetTime(format.format(DateUtils.getNowDate()));

			if (integralJk.getjIntegral() != null) {
				log.setBianIntegral(integralJk.getjIntegral());
			} else {
				log.setBianIntegral(0);
			}
			if (integralJk.getkIntegral() != null) {
				log.setkIntegral(integralJk.getkIntegral());
			} else {
				log.setkIntegral(0);
			}
			log.setApprovalNum("JKB" + DateUtils.dateTime());

			if (dept != null) {
				log.setUserDept(dept.getDeptName());
			}
			log.setUserPhone(Long.parseLong(user.getPhonenumber()));
			// 管理奖扣不用审批
			ia.setStatus(1);
			integralLogMapper.insertIntegralLog(log);

		}


		return row;
	}

}


