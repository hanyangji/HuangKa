package sunwou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sunwou.dao.UserInfoDao;
import sunwou.entity.UserInfo;
import sunwou.service.UserInfoService;
import sunwou.utils.ResultUtil;

@Controller
@RequestMapping("userinfo")
@EnableScheduling
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	/**
	 * 添加用户
	 * @param userInfo
	 */
	@RequestMapping("addUser")
	public void addUser(UserInfo userInfo,HttpServletResponse response,HttpServletRequest request) {
		new ResultUtil().push("result", userInfoService.add(userInfo)).out(response, request);;
	}

	/**
	 * 完整用户修改个人信息
	 * @param userInfo
	 */
	@RequestMapping("updateUserInfo")
	public void updateUserInfo(UserInfo userInfo,HttpServletResponse response,HttpServletRequest request) {
		new ResultUtil().push("result", userInfoService.update(userInfo)).out(response, request);;
	}
	

	/**
	 * 用户唯一接口
	 */
	@RequestMapping("addOrUpdate")
	public void addOrUpdate(UserInfo userInfo,HttpServletResponse response,HttpServletRequest request) {
		new ResultUtil().push("list", userInfoService.addOrUpdate(userInfo)).out(response, request);
	}
	/**
	 * 用户开团数排序
	 * @param info
	 * @param response
	 * @param request
	 */
	@RequestMapping("findRank")
	public void rank(UserInfo userInfo,HttpServletResponse response,HttpServletRequest request) {
		new ResultUtil().push("list", userInfoService.rank(userInfo)).out(response, request);;
	}
	/**
	 * 每周一凌晨0点执行一次(保存本周开团数)
	 */
	@Scheduled(cron = "0 0 0 ? * MON")
	public void updateRank() {
		userInfoService.updateRank();
	}
}
