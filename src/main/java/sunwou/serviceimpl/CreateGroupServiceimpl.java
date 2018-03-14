package sunwou.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sunwou.dao.CreateGroupDao;
import sunwou.dao.GroupInfoDao;
import sunwou.dao.UserInfoDao;
import sunwou.entity.CreateGroup;
import sunwou.service.CreateGroupService;
import sunwou.utils.WXUtil;
@Service
public class CreateGroupServiceimpl implements CreateGroupService {
	
	@Autowired
	private CreateGroupDao createGroupDao;
	
	@Autowired
	private GroupInfoDao groupInfoDao;
	
	@Autowired
	private UserInfoDao userInfoDao;
	
	private static String appid="";
	private static String secert="";
	private static String templateid="";
	private static String first="";
	
	

	public CreateGroup add(CreateGroup t) {
		t=createGroupDao.add(t);
		if(t.getCg_id()!=null) {
			//团购信息表的开团数+1
			System.out.println(groupInfoDao.updateExits(t.getGroupInfo()));
			//增加个人开团数(总的和每周的)
			userInfoDao.incCreateNum(t.getFk_us_id());
		}
		return t;
	}

	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<CreateGroup> find(CreateGroup t) {
		// TODO Auto-generated method stub
		return null;
	}

	public CreateGroup findOne(CreateGroup t) {
		// TODO Auto-generated method stub
		return null;
	}

	public int update(CreateGroup t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<CreateGroup> findCreateGroupYouWant(CreateGroup createGroup,Integer skip,Integer limit) {
		return createGroupDao.findCreateGroupYouWant(createGroup,skip,limit);
	}

	public void checkTimeOut(List<CreateGroup> list) {
		Map<String,String> map=new HashMap<String,String>();
		map.put("appid", appid);
		map.put("secert", secert);
		map.put("template_id", templateid);
		map.put("keywordcount", "2");
		map.put("keyword", "keyword");
		map.put("first", first);
		for(int i=0;i<list.size();i++) {
			map.put("touser", list.get(i).getAppid());
			map.put("form_id", list.get(i).getPreptyid());
			WXUtil.snedM(map);
		}
	}
}
