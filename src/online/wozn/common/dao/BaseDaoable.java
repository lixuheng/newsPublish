package online.wozn.common.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDaoable<T>{
	//根据ID来加载实体
	T get(Class<T> entryClazz ,Serializable id);
	//保存实体
	Serializable save(T entity);
	// 更新实体
	void update(T entity);
	void merge(T entity);
	//删除实体
	void delete(T entity);
	void delete(Class<T> entityClazz ,Serializable id);
	//获取所有实体
	List<T> getAll(Class<T> entityClazz);
	//获取所有实体总数
	long count(Class<T> entityClazz);
	
}
