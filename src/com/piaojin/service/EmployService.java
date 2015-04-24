package com.piaojin.service;

import java.util.List;

import com.piaojin.domain.Employ;

public interface EmployService {
	void deleteEmploy(Employ employ);
	Employ checkEmploy(String userName,String password);
	Employ getById(int userId);
	void save(Employ employ);
	void update(Employ employ);
	List<Employ> getAllEmploy();
}
