package sunwou.service;

import java.util.List;

import sunwou.entity.UserInfo;

public interface UserInfoService extends BaseService<UserInfo> {

	UserInfo addOrUpdate(UserInfo userInfo);

	Object rank(String info);

	void updateRank();

}
