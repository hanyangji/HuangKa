package sunwou.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sunwou.entity.GroupUser;
import sunwou.service.GroupUserService;
import sunwou.utils.ResultUtil;

@RestController
@RequestMapping("groupuser")
public class GroupUserController {

	@Autowired
	private GroupUserService groupUserService;
	
	private String appid="";
	private String secert="";
	
	/**
	 * 用户点击参团
	 * @param response
	 * @param groupUser
	 */
	@RequestMapping("add")
	public void add(HttpServletResponse response,HttpServletRequest request,GroupUser groupUser,Map<String,String> map) {
		new ResultUtil().push("groupUser",groupUserService.adds(groupUser,"5a5cd2ac91016d060266cbd7",map)).out(response, request);;
	}
	
	/**
	 * 用户查看个人参加团购
	 */
	@RequestMapping("findEnjoyGroup")
	public void enjoyGroup(HttpServletResponse response,HttpServletRequest request,GroupUser groupUser,Integer page,Integer size) {
		Integer skip=null;
		if(page!=null&&size!=null) {
			skip=(page-1)*size;
		}
		List<GroupUser> list=groupUserService.findEnjoyGroup(groupUser,skip,size);
		new ResultUtil().push("list",list).out(response, request);
	}
	
	
}
