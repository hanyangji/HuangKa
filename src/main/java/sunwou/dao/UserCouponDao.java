package sunwou.dao;

import java.util.List;

import sunwou.entity.UserCoupon;
import sunwou.entity.UserInfo;

public interface UserCouponDao extends BaseDao<UserCoupon> {

	List<UserCoupon> addList(List<UserCoupon> userCouponList);


	Integer useCoupon(UserCoupon userCoupon);

	Integer updateCouponAvailable(UserCoupon userCoupon);

	List<UserCoupon> findCouponByUserId(UserCoupon userCoupon, String isable);

}
