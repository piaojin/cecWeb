package com.piaojin.dao;

import java.util.List;

import com.piaojin.domain.Employ;

/**
 * Created by piaojin on 2015/1/25.
 */
public interface EmployDAO extends BaseDAO<Employ>{
	void deleteEmploy(Employ employ);
	Employ checkEmploy(String userName,String password);
	Employ getById(int userId);
	void save(Employ employ);
	void update(Employ employ);
	List<Employ> getAllEmploy();
}
