package com.piaojin.service;

import java.util.List;
import com.piaojin.domain.Department;

public interface DepartmentService {

	void saveOrUpdate(Department department);
	Department getById(int did);
	void delete(Department department);
	List<Department> getAllDepartment();
}
