package sunwou.daoimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;


import sunwou.dao.UserCouponDao;
import sunwou.entity.UserCoupon;
import sunwou.entity.UserInfo;
@Component
public class UserCouponDaoimpl implements UserCouponDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	

	public UserCoupon add(UserCoupon t) {
		mongoTemplate.insert(t, "UserCoupon");
		return t;
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
	 * 批量给用户发优惠券
	 */
	public List<UserCoupon> addList(List<UserCoupon> userCouponList) {
		List<UserCoupon> list=new ArrayList<UserCoupon>();
		for(int i=0;i<userCouponList.size();i++) {
			mongoTemplate.insert(userCouponList.get(i), "UserCoupon");
			System.out.println("usercoupon:"+userCouponList.get(i));
//			list.get(i).setUcpon_id(userCouponList.get(i).getUcpon_id());
		}
//		mongoTemplate.insertAll(userCouponList,"UserCoupon");
		return list;
	}

	/**
	 * 用户查看个人优惠券
	 */
	public List<UserCoupon> findCouponByUserId(UserCoupon userCoupon,String isable) {
		Query query=new Query();
		Criteria criteria=new Criteria();
		if(userCoupon.getFk_us_id()!=null) {
			criteria.and("fk_us_id").is(userCoupon.getFk_us_id());
		}
		if(isable!=null) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date now =new Date();
//			String strNow=sdf.format(now);
//			criteria.and("ucpon_starttime").lte(strNow);
			criteria.and("ucpondeadline").gte(now);
		}
		if(userCoupon.getUcpon_id()!=null) {
			criteria.and("_id").is(userCoupon.getUcpon_id());
		}
		if(userCoupon.getIsavailable()!=null) {
			criteria.and("isavailable").is(userCoupon.getIsavailable());
		}
		query.addCriteria(criteria);
		query.with(new Sort(Direction.DESC,"_id"));
		List<UserCoupon> list= mongoTemplate.find(query, UserCoupon.class, "UserCoupon");
		return list;
	}

	/**
	 * 用户使用优惠券
	 */
	public Integer useCoupon(UserCoupon userCoupon) {
		Query query = new Query(Criteria.where("_id").is(userCoupon.getUcpon_id()).and("fk_us_id").is(userCoupon.getFk_us_id()));
		 int num=mongoTemplate.remove(query, UserCoupon.class).getN();
		return num;
	}

	/**
	 * 用户使用优惠券，改变优惠券状态
	 */
	public Integer updateCouponAvailable(UserCoupon userCoupon) {
		
		return mongoTemplate.upsert(new Query(Criteria.where("_id").is(userCoupon.getUcpon_id())), new Update().set("isavailable", userCoupon.getIsavailable()), "UserCoupon").getN();
	}
	
	

}
