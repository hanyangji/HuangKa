package sunwou.service;

import java.util.List;

import sunwou.entity.GroupInfo;

public interface GroupInfoService extends BaseService<GroupInfo> {

	List<GroupInfo> findAll(GroupInfo groupInfo, Integer skip, Integer limit);

	Integer setOnLine(String gr_id,String gr_online);

	Integer updateGroupInfo(GroupInfo groupInfo);

	Object updateById(GroupInfo groupInfo);

	Object deleteGroupInfo(GroupInfo groupInfo);

	

}
