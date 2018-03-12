package sunwou.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mongodb.util.JSON;

import sunwou.dao.GroupInfoDao;
import sunwou.entity.CreateGroup;
import sunwou.entity.GroupInfo;
import sunwou.service.CreateGroupService;
import sunwou.utils.ResultUtil;
import sunwou.wxpay.WXpayUtil;

@Controller
@RequestMapping("creategroup")
public class CreateGroupController {
	
	@Autowired
	private CreateGroupService createGroupService;
	
	@Autowired
	private GroupInfoDao groupInfoDao;
	
	/**
	 * 团长开团调起微信支付
	 */
	@RequestMapping("payCost")
	public void payCast(HttpServletResponse response,HttpServletRequest request,String openid,GroupInfo groupInfo) {
		String out_trade_no="huangka"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		List<GroupInfo> list=groupInfoDao.findYouWant(groupInfo, "GroupInfo", null, null, null);
		Double dd = Double.parseDouble(list.get(0).getGr_cost())*100;
		Integer d=dd.intValue();
		String free=Integer.toString(d);
//		WXpayUtil.payrequest("皇卡优惠拼团", out_trade_no, list.get(0).getGr_cost(), openid, list.get(0).getGr_id(), request.getRemoteAddr());
		new ResultUtil().push("result", JSON.parse(WXpayUtil.payrequest("皇卡优惠拼团", out_trade_no, free, openid, list.get(0).getGr_id(), request.getRemoteAddr()))).out(response, request);
	}
	
	@RequestMapping("paySuccess")
	public void pay(HttpServletResponse response,HttpServletRequest request) {
		new ResultUtil().push("result",1).out(response, request);;
	}
	
	/**
	 * 用户发起开团
	 * @param response
	 * @param createGroup
	 */
	@RequestMapping("add")
	public void add(HttpServletResponse response,CreateGroup createGroup,HttpServletRequest request){
//		createGroup.setEnjoy_num(1);
//		createGroup.setFk_us_id("5a5cb69591016d05a1afd3f5");
//		GroupInfo groupInfo=new GroupInfo();
//		groupInfo.setGr_success(1);
//		groupInfo.setGr_cost("100000");
//		groupInfo.setGr_exits(1);
//		groupInfo.setGr_id("5a5cba1391016d05ac38420c");
//		groupInfo.setGr_limitnum(2);
//		groupInfo.setGr_num(1);
//		createGroup.setGroupInfo(groupInfo);
		GroupInfo groupInfo=new GroupInfo();
		groupInfo.setGr_id(createGroup.getFk_gr_id());
		List<GroupInfo> list=groupInfoDao.findById(groupInfo);
		createGroup.setGroupInfo(list.get(0));
		createGroup.setEnjoy_num(1);
		createGroup=createGroupService.add(createGroup);
		System.out.println(createGroup.getCg_id());
		new ResultUtil().push("result", createGroup.getCg_id()).out(response, request);;
	}
	
	/**
	 * 完整查询个人开团记录（前后台）
	 * @param response
	 * @param request
	 * @param createGroup
	 * @param page
	 * @param size
	 */
	@RequestMapping("findGroupByUserId")
	public void findGroupByUserId(HttpServletResponse response,HttpServletRequest request,CreateGroup createGroup,String isable,Integer page,Integer size) {
		Integer skip=(page-1)*size;
		List<CreateGroup> createGroupList=createGroupService.findCreateGroupYouWant(createGroup,skip,size);
		for(int i=0;i<createGroupList.size();i++) {
			GroupInfo groupInfo=groupInfoDao.findGroupInfoById(createGroupList.get(i).getFk_gr_id(),isable);
			createGroupList.get(i).setGroupInfo(groupInfo);
		}
		new ResultUtil().push("list", createGroupList)
		.out(response, request);
	}
	
	/*
	 * 拼团失败,给用户发送提醒
	 */
	@Scheduled(cron = "0 00 00 * * ?")  
	public void checkTimeOut() {
		CreateGroup cg=new CreateGroup();
		cg.getGroupInfo().setGr_deadline("1");
		List<CreateGroup> list=createGroupService.findCreateGroupYouWant(cg,null,null);
		createGroupService.checkTimeOut(list);
	}
	
	
	

}
