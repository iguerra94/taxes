package edu.iua.calculator.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T, ID extends Serializable> {
	int save(T object);
	T findById(ID id);
	List<T> findAll();
	int update(T object);
	int delete(T object);
}