package edu.mum.cs544.eaproject.dao;

public interface BaseDao<T> {

	void save(T t);
	
	T get(int id);
	
	void update(T t);
	
	void delete(int id);
	
}
