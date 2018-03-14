package sunwou.dao;

import java.util.List;

import sunwou.entity.CreateGroup;

public interface CreateGroupDao extends BaseDao<CreateGroup>{

	List<CreateGroup> findById(String cg_id);
	
	CreateGroup updateEnjoyNum(CreateGroup createGroup);

	List<CreateGroup> findCreateGroupYouWant(CreateGroup createGroup,Integer skip,Integer limit);

}
