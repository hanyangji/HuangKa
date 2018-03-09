package sunwou.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import sunwou.dao.UserInfoDao;
import sunwou.entity.UserInfo;
import sunwou.service.UserInfoService;
@Service
public class UserInfoServiceimpl implements UserInfoService {
	
	@Autowired
	private UserInfoDao userInfoDao;

	public UserInfo add(UserInfo t) {
		return userInfoDao.add(t);
	}

	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<UserInfo> find(UserInfo t) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserInfo findOne(UserInfo t) {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(UserInfo t) {
		return userInfoDao.update(t);
	}

	public UserInfo addOrUpdate(UserInfo userInfo) {
		return userInfoDao.addOrUpdate(userInfo);
	}

	public Object rank(String info) {
		return userInfoDao.rank(info);
	}

	/*
	 * (non-Javadoc)每周执行一次
	 * @see sunwou.service.UserInfoService#updateRank()
	 */
	@Scheduled(cron = "0 0 * 0/1 * ?")   
	public void updateRank() {
		Integer i=userInfoDao.findAndUpdateThisWeek();
	}

}
