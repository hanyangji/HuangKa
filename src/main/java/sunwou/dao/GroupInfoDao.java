package sunwou.dao;

import java.util.List;

import sunwou.entity.GroupInfo;

public interface GroupInfoDao extends BaseDao<GroupInfo> {
	List<GroupInfo> findAll(GroupInfo groupInfo,Integer skip,Integer limit);
	
	List<GroupInfo> findById(GroupInfo groupInfo);
	
	GroupInfo updateNum(GroupInfo groupInfo);
	
	GroupInfo updateSuc(GroupInfo groupInfo);
	
	GroupInfo updateExits(GroupInfo groupInfo);

	Integer setOnLine(String gr_id,String gr_online);

	Integer updateGroupInfo(GroupInfo groupInfo);

	List<GroupInfo> findGroupInfo(GroupInfo groupInfo);
	
	List<GroupInfo> findYouWant(GroupInfo groupInfo,String classname,Integer skip,Integer limit,String isable);
	
	long countNum(GroupInfo groupInfo,String classname,String isable);

	GroupInfo findGroupInfoById(String fk_gr_id,String isable);

	Object updateById(GroupInfo groupInfo);

	Object deleteGroupInfo(GroupInfo groupInfo);
}
