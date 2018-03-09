package sunwou.serviceimpl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sunwou.dao.UserCouponDao;
import sunwou.entity.UserCoupon;
import sunwou.entity.UserInfo;
import sunwou.service.UserCouponService;
import sunwou.utils.TimeUtil;
@Service
public class UserCouponServiceimpl implements UserCouponService {
	
	@Autowired
	private UserCouponDao userCouponDao;

	public UserCoupon add(UserCoupon t) {
		return userCouponDao.add(t);
	}

	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<UserCoupon> find(UserCoupon t) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserCoupon findOne(UserCoupon t) {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(UserCoupon t) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 用户查看个人优惠券，过期不显示
	 */
	public List<UserCoupon> findCouponByUserId(UserCoupon userCoupon,String isable) {
		
		List<UserCoupon> list=userCouponDao.findCouponByUserId(userCoupon,isable);
//		List<UserCoupon> reList=new ArrayList<UserCoupon>();
//		for(int i=0;i<list.size();i++) {
//			try {
//				if(TimeUtil.isBelong(list.get(i).getUcpon_starttime(), list.get(i).getUcpon_deadline())) {
//					reList.add(list.get(i));
//				}
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		return list;
	}

	
	public Integer useCoupon(UserCoupon userCoupon) {
		int i=0;
		try {
			//优惠券是否在使用时间内
			if(TimeUtil.isBelong(userCoupon.getUcpon_starttime(), userCoupon.getUcpon_deadline())) {
				i= userCouponDao.useCoupon(userCoupon);
			}else {
				i=0;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public Integer updateCouponAvailable(UserCoupon userCoupon) {
		return userCouponDao.updateCouponAvailable(userCoupon);
	}


}
