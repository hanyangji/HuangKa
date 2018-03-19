package sunwou.dao;

import java.util.List;

import sunwou.entity.UserInfo;

public interface UserInfoDao extends BaseDao<UserInfo> {

	UserInfo addPoints(UserInfo userInfo);

	UserInfo findById(UserInfo userinfo);

	UserInfo addOrUpdate(UserInfo userInfo);
	
	UserInfo incCreateNum(String us_id);

	Object rank(UserInfo info);

	Integer findAndUpdateThisWeek();

}
