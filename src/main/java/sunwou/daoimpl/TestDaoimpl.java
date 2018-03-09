package sunwou.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import sunwou.dao.testDao;
import sunwou.entity.Hello;
@Component
public class TestDaoimpl implements testDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Hello> find() {
		
		return null;
	}

}
