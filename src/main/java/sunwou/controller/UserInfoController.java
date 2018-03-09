package sunwou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sunwou.dao.UserInfoDao;
import sunwou.entity.UserInfo;
import sunwou.service.UserInfoService;
import sunwou.utils.ResultUtil;

@Controller
@RequestMapping("userinfo")
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
	public void rank(String info,HttpServletResponse response,HttpServletRequest request) {
		new ResultUtil().push("list", userInfoService.rank(info)).out(response, request);;
	}
	
	public void updateRank() {
		userInfoService.updateRank();
	}
	
	
	
}
