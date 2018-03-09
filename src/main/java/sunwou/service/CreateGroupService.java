package sunwou.service;

import java.util.List;

import sunwou.entity.CreateGroup;

public interface CreateGroupService extends BaseService<CreateGroup> {

	List<CreateGroup> findCreateGroupYouWant(CreateGroup createGroup,Integer skip,Integer limit);

	void checkTimeOut(List<CreateGroup> list);

	
}
