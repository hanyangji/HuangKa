package sunwou.service;

import java.util.List;
import java.util.Map;

import sunwou.entity.GroupUser;

public interface GroupUserService extends BaseService<GroupUser> {

	GroupUser adds(GroupUser groupUser,String ss,Map<String,String> map);

	List<GroupUser> findEnjoyGroup(GroupUser groupUser,Integer skip,Integer size);

}
