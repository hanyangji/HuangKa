package sunwou.service;

import java.util.List;

public interface BaseService<T> {

	T add(T t);
	
	int delete(String id);
	
	List<T> find(T t);
	
	T findOne(T t);
	
	int update(T t);
}
