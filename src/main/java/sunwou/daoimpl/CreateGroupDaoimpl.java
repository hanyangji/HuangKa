package sunwou.daoimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import sunwou.dao.CreateGroupDao;
import sunwou.entity.CreateGroup;
@Component
public class CreateGroupDaoimpl implements CreateGroupDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public CreateGroup add(CreateGroup t) {
		mongoTemplate.insert(t , "CreateGroup");
		return t;
	}

	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<CreateGroup> find(CreateGroup t) {
		return null;
	}

	public CreateGroup findOne(CreateGroup t) {
		
		return null;
	}

	public int update(CreateGroup t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<CreateGroup> findById(String cg_id) {
		Query query=new Query(Criteria.where("_id").is(cg_id));
		List<CreateGroup> ls=mongoTemplate.find(query, CreateGroup.class, "CreateGroup");
		return ls;
	}

	//参团人数+1
	public CreateGroup updateEnjoyNum(CreateGroup createGroup) {
		Query query= new Query(Criteria.where("_id").is(createGroup.getCg_id()));
		Update update=new Update().inc("enjoy_num", 1);
		return mongoTemplate.findAndModify(query, update, CreateGroup.class,"CreateGroup");
	}

	/**
	 * 完整查询
	 */
	public List<CreateGroup> findCreateGroupYouWant(CreateGroup createGroup,Integer skip,Integer limit) {
		Query query=new Query();
		Criteria criteria=new Criteria();
		if(createGroup.getCg_id()!=null) {
			criteria.and("_id").is(createGroup.getCg_id());
		}
		if(createGroup.getFk_gr_id()!=null) {
			criteria.and("fk_gr_id").is(createGroup.getFk_gr_id());
		}
		if(createGroup.getFk_us_id()!=null) {
			criteria.and("fk_us_id").is(createGroup.getFk_us_id());
		}
		if(createGroup.getEnjoy_num()!=null) {
			criteria.and("enjoy_num").is(createGroup.getEnjoy_num());
		}
		if(createGroup.getGroupInfo().getGr_deadline()!=null) {
			SimpleDateFormat simpledf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date now = null;
			try {
				now = simpledf.parse(simpledf.format(new Date()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Criteria cr = new Criteria() {
	            @Override
	            public DBObject getCriteriaObject() {
	                DBObject obj = new BasicDBObject();
	                obj.put("$where", "enjoy_num < groupInfo.gr_limitnum");
	                return obj;
	            }
	        };
	        cr.and("grdeadline").lt(now);
	        criteria.elemMatch(cr);
		}
		if(skip!=null&&limit!=null) {
			query.skip(skip).limit(limit);
		}
		query.addCriteria(criteria);
//		query.skip(skip).limit(size);
		query.with(new Sort(Direction.DESC,"_id"));
		return mongoTemplate.find(query, CreateGroup.class, "CreateGroup");
	}

}
