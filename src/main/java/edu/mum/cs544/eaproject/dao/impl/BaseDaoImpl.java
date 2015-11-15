package edu.mum.cs544.eaproject.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.cs544.eaproject.dao.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	protected SessionFactory sessionFactory;

	private Class<T> type;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}
	
	public void save(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

	public void update(T t) {
		sessionFactory.getCurrentSession().saveOrUpdate(t);
	}

	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete((T) session.load(type, id));
	}

	public T get(int id) {
		return (T) sessionFactory.getCurrentSession().get(type, id);
	}
}
