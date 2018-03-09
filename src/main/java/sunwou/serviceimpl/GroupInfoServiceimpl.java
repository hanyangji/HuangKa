package sunwou.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sunwou.dao.GroupInfoDao;
import sunwou.entity.GroupInfo;
import sunwou.service.GroupInfoService;
@Service
public class GroupInfoServiceimpl implements GroupInfoService {
	
	@Autowired
	private GroupInfoDao groupInfoDao;
	
	public GroupInfo add(GroupInfo t) {
		groupInfoDao.add(t);
		return t;
	}

	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<GroupInfo> find(GroupInfo t) {
		// TODO Auto-generated method stub
		return null;
	}

	public GroupInfo findOne(GroupInfo t) {
		return groupInfoDao.findOne(t);
	}

	public int update(GroupInfo t) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 查询所有团购
	 */
	public List<GroupInfo> findAll(GroupInfo groupInfo, Integer skip, Integer limit) {
		return groupInfoDao.findAll(groupInfo, skip, limit);
	}

	/**
	 * 上线团购
	 */
	public Integer setOnLine(String gr_id,String gr_online) {
		
		return groupInfoDao.setOnLine(gr_id,gr_online);
	}

	public Integer updateGroupInfo(GroupInfo groupInfo) {
		
		return groupInfoDao.updateGroupInfo(groupInfo);
	}

	public Object updateById(GroupInfo groupInfo) {
		return groupInfoDao.updateById(groupInfo);
	}

	public Object deleteGroupInfo(GroupInfo groupInfo) {
		// TODO Auto-generated method stub
		return groupInfoDao.deleteGroupInfo(groupInfo);
	}

}
