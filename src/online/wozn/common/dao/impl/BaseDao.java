package online.wozn.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import online.wozn.common.dao.BaseDaoable;

public class BaseDao<T> implements BaseDaoable<T> {
	public BaseDao(){};
	// =========================注入Hibernate的SessionFactory=========================
	protected SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// =========================实现方法=================================
	@Override
	@SuppressWarnings("unchecked")
	public T get(Class<T> entryClazz, Serializable id) {
		// TODO Auto-generated method stub
		return (T) this.getSessionFactory()
				.getCurrentSession()
				//.openSession()
				.get(entryClazz, id);
	}

	@Override
	public Serializable save(T entity) {
		// TODO Auto-generated method stub
		return getSessionFactory()
				.getCurrentSession()
				//.openSession()
				.save(entity);
	}

	@Override
	public void update(T entity) {
		System.out.println("begin update  the entity is"+entity);
		// TODO Auto-generated method stub
		getSessionFactory()
		.getCurrentSession()
		//.openSession()
		.saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		getSessionFactory()
		.getCurrentSession()
		//.openSession()
		.delete(entity);
	}

	@Override
	public void delete(Class<T> entityClazz, Serializable id) {
		// TODO Auto-generated method stub
		getSessionFactory()
				.getCurrentSession()
				//.openSession()
				.createQuery("delete " + entityClazz.getSimpleName() + " en where en.id = ?0").setParameter("0", id)
				.executeUpdate();
	}

	@Override
	public List<T> getAll(Class<T> entityClazz) {
		// TODO Auto-generated method stub
		String hql = "select en from "+entityClazz.getSimpleName() +" en" ;
		return find(hql);
	}
	
	
	@Override
	public long count(Class<T> entityClazz) {
		List<T> list = find("select count(*) from "
				+ entityClazz.getSimpleName());
		if(list!=null || list.size()>0){
			return (Long)list.get(0);
		}
		return 0;
	}
	
	//无参数查询
	@SuppressWarnings("unchecked")
	public List<T> find(String hql){
		return (List<T>)getSessionFactory()
				.getCurrentSession()
				//.openSession()
				.createQuery(hql)
				.list();
	}
	
	@SuppressWarnings("unchecked")
	//带参数查询
	public List<T>  find(String hql,Object...params){
		//Query query = getSessionFactory().getCurrentSession().createQuery(hql);
		//Transaction tx = session.beginTransaction();
		Query query =getSessionFactory().openSession().createQuery(hql);
		System.out.println("params length is "+params.length);
		for(int i=0;i<params.length ;i++){
			query.setParameter(i+"", params[i]);
		}
		//tx.commit();
		//session.close();
		return (List<T>)query.list();
	}
	@SuppressWarnings("unchecked")
	//分页查询
	public List<T> findByPage(String hql,int pageNo, int pageSize){
		return 
				(List<T>)getSessionFactory()
				.getCurrentSession()
				//.openSession()
				.createQuery(hql)
				.setFirstResult((pageNo-1)*pageSize)
				.setMaxResults(pageSize)
				.list();
	}
	
	@SuppressWarnings("unchecked")
	//带参分页查询
	public List<T> findByPage(String hql,int pageNo, int pageSize,Object...params){
		Query query=getSessionFactory()
				.getCurrentSession()
				//.openSession()
				.createQuery(hql);
		for(int i=0;i<params.length;i++){
			query.setParameter(i+"", params[i]);
		}
		// 执行分页，并返回查询结果
		return query.setFirstResult((pageNo - 1) * pageSize)
			.setMaxResults(pageSize)
			.list();
	}
	@Override
	public void merge(T entity) {
		// TODO Auto-generated method stub
		getSessionFactory()
				.getCurrentSession()
				//.openSession()
				.merge(entity);
	}

	/*
	public static void main(String[] args) {
		
		ApplicationContext ac = 
				new FileSystemXmlApplicationContext("C:\\Users\\Administrator\\eclipsework\\newsprint\\WebContent\\WEB-INF\\applicationContext.xml"); 
		SessionFactory sessionFactory = (SessionFactory)ac.getBean("sessionFactory");
		Session session = sessionFactory.getCurrentSession();
		Transaction tc = session.beginTransaction();
		//Session session = sessionFactory.openSession();
		System.out.println("haha");
		session.close();
		
	}*/

}
