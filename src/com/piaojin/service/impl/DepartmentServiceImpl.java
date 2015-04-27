package com.piaojin.service.impl;

import java.util.List;

import com.piaojin.dao.DepartmentDAO;
import com.piaojin.domain.Department;
import com.piaojin.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDAO departmentDAO;
	
	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public void saveOrUpdate(Department department) {
		// TODO Auto-generated method stub
		departmentDAO.saveOrUpdate(department);
	}

	public Department getById(int did) {
		// TODO Auto-generated method stub
		return departmentDAO.getById(did);
	}

	public void delete(Department department) {
		// TODO Auto-generated method stub
		departmentDAO.delete(department);
	}

	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return departmentDAO.getAllDepartment();
	}

}
