package sunwou.dao;

import java.util.List;

import sunwou.entity.GroupInfo;

public interface BaseDao<T> {

	T add(T t);
	
	int delete(String id);
	
	List<T> find(T t);
	
	T findOne(T t);
	
	int update(T t);
}
