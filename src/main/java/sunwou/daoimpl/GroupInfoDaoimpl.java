package sunwou.daoimpl;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import sunwou.dao.GroupInfoDao;
import sunwou.entity.GroupInfo;
import sunwou.utils.StringUtil;
@Component
public class GroupInfoDaoimpl implements GroupInfoDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	//默认从0开始取
	private static final int MIN_COUNT=0;
	//默认取的条数
	private static final int MAX_COUNT=20;
	
    public static Map<String, Class> classes = new HashMap<String, Class>();
	  
	  
	public static final String ENTITYBASE="mongoBaseEntity";

	  
	static{
//		  classes.put(ENTITYBASE, new MongoBaseEntity().getClass());
		  classes.put("GroupInfo", new GroupInfo().getClass());
	}	

	Date now=new Date();
	
	public List<GroupInfo> findYouWant(GroupInfo groupInfo,String classname,Integer skip,Integer limit,String isable){
		Criteria criteria=new Criteria();
		if(groupInfo.getGr_id()!=null) {
			criteria.and("_id").is(groupInfo.getGr_id());
		}
		if(groupInfo.getGr_name()!=null) {
			criteria.and("gr_name").is(groupInfo.getGr_name());
		}
		if(groupInfo.getShopId()!=null) {
			criteria.and("shopId").is(groupInfo.getShopId());
		}
		if(groupInfo.getGr_online()!=null) {
			criteria.and("gr_online").is(groupInfo.getGr_online());
		}
		if(groupInfo.getCpon_deadline()!=null) {
			criteria.and("cpon_deadline").is(groupInfo.getCpon_deadline());
		}
		if(groupInfo.getCpon_info()!=null) {
			criteria.and("cpon_info").is(groupInfo.getCpon_info());
		}
		if(groupInfo.getGr_cost()!=null) {
			criteria.and("gr_cost").is(groupInfo.getGr_cost());
		}
		if(groupInfo.getGr_limitnum()!=null) {
			criteria.and("gr_limitnum").is(groupInfo.getGr_limitnum());
		}
		if(groupInfo.getGr_success()!=null) {
			criteria.and("gr_success").is(groupInfo.getGr_success());
		}
		if(groupInfo.getGr_num()!=null) {
			criteria.and("gr_num").is(groupInfo.getGr_num());
		}
		if(isable!=null) {
		    SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd" );
		    String starttime="2018-01-10";
		    String endtime="2018-07-09";
		    
			criteria.and("grdeadline").gte(now);
//					criteria.and("grdeadline").gte(format.parse(starttime)).lt(format.parse(endtime));
				
			
		}
		Query query=new Query(criteria);
		if(skip!=null&&limit!=null) {
			query.skip(skip).limit(limit);
		}
		query.with(new Sort(Direction.DESC,"_id"));
		List<GroupInfo> list=mongoTemplate.find(query, GroupInfo.class, classname);
		long i=mongoTemplate.count(query, classname);
		
		return list;
	}

	
	public GroupInfo add(GroupInfo t) {
		
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date=sd.parse(t.getGr_deadline());
			t.setGrdeadline(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mongoTemplate.insert(t,"GroupInfo");
		return t;
	}

	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<GroupInfo> find(GroupInfo t) {
		return null;
	}

	public GroupInfo findOne(GroupInfo t) {
		return null;
	}

	public int update(GroupInfo t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List<GroupInfo> findAll(GroupInfo groupInfo,Integer skip,Integer limit){
		Query query=new Query();
//		query.skip(skip);
//		query.limit(limit);
		List<GroupInfo> ls=mongoTemplate.find(query, GroupInfo.class,"GroupInfo");
		System.out.println("daols:"+ls);
		return ls;
	}

	public List<GroupInfo> findById(GroupInfo groupInfo) {
		System.out.println("sed");
		Query query=new Query(Criteria.where("_id").is(groupInfo.getGr_id()));
		List<GroupInfo> ls=mongoTemplate.find(query, GroupInfo.class, "GroupInfo");
		System.out.println("ls"+ls);
		return ls;
	}

	public GroupInfo updateNum(GroupInfo groupInfo) {
		Query query=new Query(Criteria.where("_id").is(groupInfo.getGr_id()));
		Update update=new Update();
		update.inc("gr_num", 1);
		mongoTemplate.updateFirst(query, update, GroupInfo.class,"GroupInfo");
		return groupInfo;
	}
	public GroupInfo updateSuc(GroupInfo groupInfo) {
		Query query=new Query(Criteria.where("_id").is(groupInfo.getGr_id()));
		Update update=new Update();
		update.inc("gr_successs", 1);
		mongoTemplate.updateFirst(query, update, GroupInfo.class,"GroupInfo");
		return groupInfo;
	}
	public GroupInfo updateExits(GroupInfo groupInfo) {
		Query query=new Query(Criteria.where("_id").is(groupInfo.getGr_id()));
		Update update=new Update();
		update.inc("gr_exits", 1);
		mongoTemplate.updateFirst(query, update, GroupInfo.class,"GroupInfo");
		return groupInfo;
	}

	
	public Integer setOnLine(String gr_id,String gr_online) {
		int i=mongoTemplate.upsert(new Query(Criteria.where("_id").is(gr_id)), new Update().set("gr_online", gr_online), "GroupInfo").getN();
		return i;
	}

	public Integer updateGroupInfo(GroupInfo groupInfo) {
//		Query query=new Query(Criteria.where("_id").is(groupInfo.getGr_id()));
//		Update update=new Update();
//		update.set("gr_name", groupInfo);
//		update.set("gr_imglist", groupInfo);
//		update.set("gr_rule", groupInfo);
//		update.set("gr_cost", groupInfo);
//		update.set("gr_deadline", groupInfo);
//		update.set("gr_online", groupInfo);
//		update.set("cpon_info", groupInfo);
//		
//		mongoTemplate.upsert(query, update, "GroupInfo");
		return null;
	}


	public long countNum(GroupInfo groupInfo,String classname,String isable) {
		Criteria criteria=new Criteria();
		if(groupInfo.getGr_id()!=null) {
			criteria.and("_id").is(groupInfo.getGr_id());
		}
		if(groupInfo.getGr_name()!=null) {
			criteria.and("gr_name").is(groupInfo.getGr_name());
		}
		if(groupInfo.getShopId()!=null) {
			criteria.and("shopId").is(groupInfo.getShopId());
		}
		if(groupInfo.getGr_online()!=null) {
			criteria.and("gr_online").is(groupInfo.getGr_online());
		}
		if(groupInfo.getCpon_deadline()!=null) {
			criteria.and("cpon_deadline").is(groupInfo.getCpon_deadline());
		}
		if(groupInfo.getCpon_info()!=null) {
			criteria.and("cpon_info").is(groupInfo.getCpon_info());
		}
		if(groupInfo.getGr_cost()!=null) {
			criteria.and("gr_cost").is(groupInfo.getGr_cost());
		}
		if(groupInfo.getGr_limitnum()!=null) {
			criteria.and("gr_limitnum").is(groupInfo.getGr_limitnum());
		}
		if(groupInfo.getGr_success()!=null) {
			criteria.and("gr_success").is(groupInfo.getGr_success());
		}
		if(groupInfo.getGr_num()!=null) {
			criteria.and("gr_num").is(groupInfo.getGr_num());
		}
		if(isable!=null) {
		    SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd" );
//		    String starttime="2018-01-10";
//		    String endtime="2018-07-09";
		    Date now=new Date();
			criteria.and("grdeadline").gte(now);
			System.out.println("sd");
			
		}
		Query query=new Query(criteria);
		long i=mongoTemplate.count(query, classname);
		return i;
	}


	public List<GroupInfo> findGroupInfo(GroupInfo groupInfo) {
		Query query=new Query(Criteria.where("_id").is(groupInfo.getGr_id()));
		
		return mongoTemplate.findAllAndRemove(query, "GroupInfo");
	}


	
	public GroupInfo findGroupInfoById(String fk_gr_id,String isable) {
		Query query=new Query(Criteria.where("_id").is(fk_gr_id));
		Criteria criteria=new Criteria();
		if(isable!=null) {
			criteria.and("grdeadline").gte(now);
		}
		return mongoTemplate.find(query, GroupInfo.class, "GroupInfo").get(0);
	}


	public Object updateById(GroupInfo groupInfo) {
		Query query=new Query();
		Update update=new Update();
		Object value=null;
		query.addCriteria(new Criteria().where("_id").is(groupInfo.getGr_id()));
		for(Field f:groupInfo.getClass().getDeclaredFields()) {
				f.setAccessible(true);
				try {
					value = f.get(groupInfo);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					value=null;
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					value=null;
				}
				if(StringUtil.check(value)) {
					System.out.println(value+","+f.getName());
					if(f.getName().equals("gr_id")) {
						continue;
					}
					update.set(f.getName(),value);
				}
		}
		return mongoTemplate.updateFirst(query, update, "GroupInfo").getN();
	}


	public Object deleteGroupInfo(GroupInfo groupInfo) {
//		Query query=new Query();
//		Criteria criteria=new Criteria();
//		Object value=null;
//		for(Field f:groupInfo.getClass().getDeclaredFields()) {
//				f.setAccessible(true);
//				try {
//					value = f.get(groupInfo);
//				} catch (IllegalArgumentException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					value=null;
//				} catch (IllegalAccessException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					value=null;
//				}
//				if(StringUtil.check(value)) {
//					System.out.println(value+","+f.getName());
//					if(f.getName().equals("id")) {
//						StringBuffer sd=new StringBuffer(f.getName());
//						sd.insert(0, "_");
//						System.out.println(value+","+f.getName()+sd);
//						criteria.and(sd.toString()).is(value);
//						continue;
//					}
//					criteria.and(f.getName()).is(value);
//				}
//		}
//		query.addCriteria(criteria);
		Query query=new Query(new Criteria().where("_id").is(groupInfo.getGr_id()));
		
		return mongoTemplate.findAndRemove(query, GroupInfo.class, "GroupInfo");
	}

}
