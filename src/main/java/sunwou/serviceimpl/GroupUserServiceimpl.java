package sunwou.serviceimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;

import sunwou.dao.CreateGroupDao;
import sunwou.dao.GroupInfoDao;
import sunwou.dao.GroupUserDao;
import sunwou.dao.UserCouponDao;
import sunwou.dao.UserInfoDao;
import sunwou.entity.CreateGroup;
import sunwou.entity.GroupInfo;
import sunwou.entity.GroupUser;
import sunwou.entity.UserCoupon;
import sunwou.entity.UserInfo;
import sunwou.service.GroupUserService;
import sunwou.utils.WXUtil;
@Service
public class GroupUserServiceimpl implements GroupUserService {
	
	@Autowired
	private GroupUserDao groupUserDao;
	
	@Autowired
	private CreateGroupDao createGroupDao;
	
	@Autowired
	private GroupInfoDao groupInfoDao;
	
	@Autowired
	private UserCouponDao userCouponDao;
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	private static String appid="";
	private static String secert="";
	private static String templateid="";
	private static String first="";

	public GroupUser adds(GroupUser t,String cg_id,Map<String,String> map) {
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		Date data=null;
		//根据id查询CreateGroup表中对应的参团人数
		CreateGroup createGroup=createGroupDao.findById(t.getFk_cg_id()).get(0);
		String tuanzhangId=createGroup.getFk_us_id();
		if(createGroup.getEnjoy_num()<createGroup.getGroupInfo().getGr_limitnum()) {
			//参团用户表添加一条记录
			GroupUser groupUser=groupUserDao.add(t);
			//开团表的参团人数+1
			createGroup=createGroupDao.updateEnjoyNum(createGroup);
			//查询团购信息是否存在
//			List<GroupInfo> listg=groupInfoDao.findById(createGroup.getGroupInfo());
//			GroupInfo groupInfo=listg.get(0);
//			if(groupInfo!=null) {
				UserInfo userInfo=new UserInfo();
				GroupInfo groupInfo=new GroupInfo();
				groupInfo.setGr_id(createGroup.getFk_gr_id());
				//团购信息表的参团人数+1
				groupInfoDao.updateNum(groupInfo);
				System.out.println("num"+createGroup.getEnjoy_num()+","+createGroup.getGroupInfo().getGr_limitnum());
				//最后一个人参团之后，团购成功
				if((createGroup.getEnjoy_num()>=(createGroup.getGroupInfo().getGr_limitnum()-1))) {
					//团购信息表成功开团数+1
					groupInfoDao.updateSuc(groupInfo);
					groupUserDao.updateSuc(groupUser);
					List<GroupUser> ls=groupUserDao.findBycgId(createGroup);
					map.put("appid", appid);
					map.put("secert", secert);
					map.put("template_id", templateid);
					map.put("keywordcount", "2");
					map.put("keyword", "keyword");
					map.put("first", first);
					userInfo.setUs_id(tuanzhangId);
					map.put("touser", userInfoDao.findById(userInfo).getOpendid());
					map.put("form_id", ls.get(0).getTuanzhuang_propertyid());
					WXUtil.snedM(map);
					List<UserCoupon> userCouponList=new ArrayList<UserCoupon>();
					for(int i=0;i<ls.size();i++) {
						userInfo.setUs_id(ls.get(i).getFk_us_id());
						String openid=userInfoDao.findById(userInfo).getOpendid();
						map.put("touser", openid);
						map.put("form_id", ls.get(i).getEnjoy_from_id());
						WXUtil.snedM(map);
						UserCoupon userCoupon=new UserCoupon();
						userCoupon.setShopid(groupInfo.getShopId());
						userCoupon.setFk_us_id(ls.get(i).getFk_us_id());
						userCoupon.setUcpon_deadline(createGroup.getGroupInfo().getCpon_deadline());
						try {
							userCoupon.setUcpondeadline(sd.parse(createGroup.getGroupInfo().getCpon_deadline()));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						userCoupon.setUcpon_info(createGroup.getGroupInfo().getCpon_info());
						userCoupon.setAppid(createGroup.getGroupInfo().getAppid());
						userCoupon.setUcpon_starttime(createGroup.getGroupInfo().getCpon_start_time());
						userCoupon.setIsavailable("true");
						userCouponList.add(i,userCoupon);
					}
					UserCoupon userCoupon=new UserCoupon();
					userCoupon.setShopid(groupInfo.getShopId());
					userCoupon.setFk_us_id(tuanzhangId);
					userCoupon.setUcpon_deadline(createGroup.getGroupInfo().getCpon_deadline());
					userCoupon.setUcpon_info(groupInfo.getCpon_head_info());
					userCoupon.setAppid(createGroup.getGroupInfo().getAppid());
					userCoupon.setUcpon_starttime(createGroup.getGroupInfo().getCpon_start_time());
					userCoupon.setIsavailable("true");
					try {
						userCoupon.setUcpondeadline(sd.parse(createGroup.getGroupInfo().getCpon_deadline()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					userCouponList.add(userCoupon);
					System.out.println("userCouponList:"+userCouponList);
					List<UserCoupon> list=userCouponDao.addList(userCouponList);
					System.out.println("list"+list);
				}
			}else {
				//团购信息不存在
			}
		return null;
	}

	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<GroupUser> find(GroupUser t) {
		// TODO Auto-generated method stub
		return null;
	}

	public GroupUser findOne(GroupUser t) {
		
		return null;
	}

	public int update(GroupUser t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public GroupUser add(GroupUser t) {
		// TODO Auto-generated method stub
		return null;
	}

	public GroupUser adds(GroupUser groupUser) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<GroupUser> findEnjoyGroup(GroupUser groupUser,Integer skip,Integer size) {
		
		return groupUserDao.findEnjoyGroup(groupUser,skip,size);
	}
	


}
