package sunwou.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sunwou.dao.GroupInfoDao;
import sunwou.daoimpl.GroupInfoDaoimpl;
import sunwou.entity.GroupInfo;
import sunwou.service.GroupInfoService;
import sunwou.utils.AjaxUtil;
import sunwou.utils.ResultUtil;
import sunwou.utils.TimeUtil;

@RestController
@RequestMapping("groupinfo")
public class GroupInfoController {

	@Autowired
	private GroupInfoService groupInfoService;
	
	@Autowired
	private GroupInfoDao groupInfoDao;
	
	@RequestMapping("findYouWant")
	public void test(HttpServletResponse response,HttpServletRequest request,GroupInfo groupInfo,Integer page,Integer size,String isable) {
		long l=groupInfoDao.countNum(groupInfo,"GroupInfo",isable);
		int skip=(page-1)*size;
		List<GroupInfo> listResult=groupInfoDao.findYouWant(groupInfo,"GroupInfo",skip,size,isable);
		System.out.println(isable);
		new ResultUtil().push("list", listResult).push("page", page).push("count", l).out(response, request);
	}
	
	
	/**
	 * 团购信息添加
	 * @param response
	 * @param g
	 */
	@RequestMapping("add")
	public void add(HttpServletResponse response,GroupInfo groupInfo,HttpServletRequest request) {
		
		groupInfo=groupInfoService.add(groupInfo);
		
		System.out.println(groupInfo);
		new ResultUtil().push("list", groupInfo).out(response, request);
	}
	
	

	/**
	 * 查询所有
	 * @param response
	 * @param groupInfo
	 */
	@RequestMapping("findAll")
	public void findAll(HttpServletResponse response,GroupInfo groupInfo,Integer skip,Integer limit,HttpServletRequest request) {
		List<GroupInfo> ls=groupInfoService.findAll(groupInfo,0,1);
		AjaxUtil.PrintArrayClass(response, ls);
	}
	
	/**
	 * 设置团购上下线
	 * @param response
	 * @param gr_id
	 */
	@RequestMapping("setIsOnLine")
	public void setIsOnLine(HttpServletResponse response,String gr_id,String gr_online,HttpServletRequest request) {
		new ResultUtil().push("result", groupInfoService.setOnLine(gr_id,gr_online)).out(response, request);;
	}
	
	@RequestMapping("updateGroupInfoById")
	public void updateById(HttpServletResponse response,HttpServletRequest request,GroupInfo groupInfo) {
		new ResultUtil().push("result", groupInfoService.updateById(groupInfo)).out(response, request);
	}
	
	@RequestMapping("deleteGroupInfo")
	public void deleteGroupInfo(HttpServletResponse response,HttpServletRequest request,GroupInfo groupInfo) {
		new ResultUtil().push("result", groupInfoService.deleteGroupInfo(groupInfo)).out(response, request);
	}
	
}
