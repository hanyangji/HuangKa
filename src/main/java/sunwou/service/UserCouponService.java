package sunwou.service;

import java.util.List;

import sunwou.entity.UserCoupon;
import sunwou.entity.UserInfo;

public interface UserCouponService extends BaseService<UserCoupon> {


	Integer useCoupon(UserCoupon userCoupon);

	Integer updateCouponAvailable(UserCoupon userCoupon);

	List<UserCoupon> findCouponByUserId(UserCoupon userCoupon, String isable);

}
