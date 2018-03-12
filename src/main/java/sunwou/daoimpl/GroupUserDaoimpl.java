package sunwou.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import sunwou.dao.GroupUserDao;
import sunwou.entity.CreateGroup;
import sunwou.entity.GroupUser;
@Component
public class GroupUserDaoimpl implements GroupUserDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	public GroupUser add(GroupUser t) {
		mongoTemplate.insert(t, "GroupUser");
		return t;
	}

	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<GroupUser> find(GroupUser t) {
		// TODO Auto-generated method stub
		return null;
	}

	public GroupUser findOne(GroupUser t) {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(GroupUser t) {
		return 0;
	}

	public List<GroupUser> findBycgId(CreateGroup createGroup) {
		Query query=new Query(Criteria.where("fk_cg_id").is(createGroup.getCg_id()));
		List<GroupUser> ls=mongoTemplate.find(query, GroupUser.class, "GroupUser");
		return ls;
	}

	/**
	 * 完整查询用户参团
	 */
	public List<GroupUser> findEnjoyGroup(GroupUser groupUser,Integer skip,Integer size) {
		Query query=new Query();
		Criteria criteria=new Criteria();
		if(groupUser.getFk_cg_id()!=null) {
			criteria.and("fk_cg_id").is(groupUser.getFk_cg_id());
		}
		if(groupUser.getFk_us_id()!=null) {
			criteria.and("fk_us_id").is(groupUser.getFk_us_id());
		}
		if(groupUser.getGroupName()!=null) {
			criteria.and("groupName").is(groupUser.getGroupName());
		}
		if(groupUser.getGu_id()!=null) {
			criteria.and("gu_id").is(groupUser.getGu_id());
		}
		if(groupUser.getGroupName()!=null) {
			criteria.and("groupName").is(groupUser.getGroupName());
		}
		if(groupUser.getGroupdeadline()!=null) {
			criteria.and("groupdeadline").lte((groupUser.getGroupdeadline()));
		}
		if(skip!=null&&size!=null) {
			query.skip(skip).limit(size);
		}
		query.addCriteria(criteria);
		query.with(new Sort(Direction.DESC,"_id"));
		return mongoTemplate.find(query, GroupUser.class, "GroupUser");
	}
	
	public GroupUser updateSuc(GroupUser groupUser) {
		Query query= new Query(Criteria.where("_id").is(groupUser.getGu_id()));
		Update update=new Update().inc("successNum", 1);
		return mongoTemplate.findAndModify(query, update, GroupUser.class,"GroupUser");
	}

}
