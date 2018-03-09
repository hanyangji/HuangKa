package sunwou.dao;

import java.util.List;

import sunwou.entity.CreateGroup;
import sunwou.entity.GroupUser;

public interface GroupUserDao extends BaseDao<GroupUser>{

	List<GroupUser> findBycgId(CreateGroup createGroup);

	List<GroupUser> findEnjoyGroup(GroupUser groupUser,Integer skip,Integer size);

}
