package sunwou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import sunwou.entity.UserCoupon;
import sunwou.entity.UserInfo;
import sunwou.service.UserCouponService;
import sunwou.utils.ResultUtil;

@Controller
@RequestMapping("usercoupon")
public class UserCouponController {

	@Autowired
	private UserCouponService userCouponService;
	
	/**
	 * 用户查看个人优惠券
	 * @param response
	 * @param userInfo
	 */
	@RequestMapping("findCoupon")
	public void findAll(HttpServletResponse response,UserCoupon userCoupon,HttpServletRequest request,String isable) {
		new ResultUtil().push("result",userCouponService.findCouponByUserId(userCoupon,isable)).out(response, request);;
	}
	
	/**
	 * 用户使用优惠券
	 * @param response
	 * @param userCoupon
	 */
	@RequestMapping("useCoupon")
	public void useCoupon(HttpServletResponse response,UserCoupon userCoupon,HttpServletRequest request) {
		new ResultUtil().push("result",userCouponService.useCoupon(userCoupon)).out(response, request);;
	}
	
	@RequestMapping("updateCouponAvailable")
	public void updateCouponAvailable(HttpServletResponse response,UserCoupon userCoupon,HttpServletRequest request) {
		new ResultUtil().push("result", userCouponService.updateCouponAvailable(userCoupon)).out(response, request);;
	}
	
	/**
	 * 给用户添加优惠券
	 * @param response
	 * @param userCoupon
	 */
	@RequestMapping("addCoupon")
	public void addCoupon(HttpServletResponse response,UserCoupon userCoupon) {
		userCouponService.add(userCoupon);
	}
	
}
