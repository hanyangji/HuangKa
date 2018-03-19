package sunwou.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import sunwou.dao.UserInfoDao;
import sunwou.entity.UserInfo;
@Component
public class UserInfoDaoimpl implements UserInfoDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	public UserInfo add(UserInfo t) {
		mongoTemplate.insert(t, "UserInfo");
		return t;
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

	/**
	 * 完整用户修改个人信息
	 */
	public int update(UserInfo t) {
		Query query=new Query(Criteria.where("_id").is(t.getUs_id()));
		Update update=new Update();
		
		if(t.getNickname()!=null) {
			update.set("nickname", t.getNickname());
		}
		if(t.getCity()!=null) {
			update.set("city", t.getCity());
		}
		if(t.getIcon()!=null) {
			update.set("icon", t.getIcon());
		}
		return mongoTemplate.upsert(query, update, "UserInfo").getN();
	}
	
	/*
	 * 增加个人开团数
	 */
	public UserInfo incCreateNum(String us_id) {
		Query query=new Query(Criteria.where("_id").is(us_id));
		Update update=new Update();
		UserInfo ui=new UserInfo();
		UserInfo userInfo=mongoTemplate.findOne(query, UserInfo.class,"UserInfo");
		if(userInfo.getCountGroup()==null) {
			update.set("countGroup", 1);
			if(userInfo.getCountGroupThisWeek()==null) {
				update.set("countGroupThisWeek", 1);
			}else {
				update.inc("countGroupThisWeek", 1);
			}
		}else {
			if(userInfo.getCountGroupThisWeek()==null) {
				update.set("countGroupThisWeek", 1);
			}else {
				update.inc("countGroupThisWeek", 1);
			}
			update.inc("countGroup", 1);
		}
			ui=mongoTemplate.findAndModify(query, update, UserInfo.class,"UserInfo");
		return ui;
	}

	public UserInfo addPoints(UserInfo userInfo) {
		Query query=new Query(Criteria.where("_id").is(userInfo.getUs_id()));
		Update update=new Update().inc("points", 1);
		mongoTemplate.findAndModify(query, update, UserInfo.class);
		return userInfo;
	}

	public UserInfo findById(UserInfo userinfo) {
		Query query=new Query(Criteria.where("_id").is(userinfo.getUs_id()));
		mongoTemplate.find(query, UserInfo.class, "UserInfo");
		return  userinfo;
	}

	public UserInfo addOrUpdate(UserInfo userInfo) {
		Query query=new Query();
		Criteria criteria=new Criteria();
		Update update=new Update();
		if(userInfo.getFk_userid()!=null) {
			update.set("fk_userid", userInfo.getFk_userid());
		}
		if(userInfo.getCity()!=null) {
			update.set("city", userInfo.getCity());
		}
		if(userInfo.getIcon()!=null) {
			update.set("icon", userInfo.getIcon());
		}
		if(userInfo.getNickname()!=null) {
			update.set("nickname", userInfo.getNickname());
		}
		
		mongoTemplate.save(update, "UserInfo");
		return userInfo;
	}

	/**
	 * 个人开团数排名
	 */
	public Object rank(UserInfo userInfo) {
		Query query = new Query();
		Criteria criteria=new Criteria();
		if(userInfo.getCountGroup()!=null) {
			query.with(new Sort(Direction.DESC,userInfo.getCountGroup()));
			criteria.and(userInfo.getCountGroup()).exists(true);
		}
		if(userInfo.getCountGroupLastWeek()!=null) {
			query.with(new Sort(Direction.DESC,userInfo.getCountGroupLastWeek()));
			criteria.and(userInfo.getCountGroupLastWeek()).exists(true);
		}
		query.limit(10);
		query.addCriteria(criteria);
	    List<UserInfo> li =mongoTemplate.find(query, UserInfo.class, "UserInfo"); 
		return li;
	}
	

	public void updateRank() {
	}

	public Integer findAndUpdateThisWeek() {
		Query query = new Query();
		Criteria criteria=Criteria.where("countGroupThisWeek").exists(true);
		query.addCriteria(criteria);
		List<UserInfo> list=mongoTemplate.find(query, UserInfo.class,"UserInfo");
		Update u=new Update();
		for(int i=0;i<list.size();i++) {
			u.set("countGroupLastWeek",list.get(i).getCountGroupThisWeek());
			u.set("countGroupThisWeek", 0);
		}
		return mongoTemplate.updateFirst(query, u, "UserInfo").getN();
	}
	

}
