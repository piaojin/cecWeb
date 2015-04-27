package com.piaojin.dao;

import java.util.List;

import com.piaojin.domain.Department;

public interface DepartmentDAO extends BaseDAO<Department>{

	void saveOrUpdate(Department department);
	Department getById(int did);
	void delete(Department department);
	List<Department> getAllDepartment();
	
}