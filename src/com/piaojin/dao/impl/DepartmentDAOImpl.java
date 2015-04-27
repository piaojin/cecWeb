package com.piaojin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.piaojin.domain.Department;
import com.piaojin.domain.Employ;


public class DepartmentDAOImpl extends BaseDAOImpl<Department> implements com.piaojin.dao.DepartmentDAO {

	public Department getById(int did) {
		// TODO Auto-generated method stub
		Department department=super.findById(Department.class, did);
		department.setKid(department.getDid());
		return department;
	}

	public void delete(Department department) {
		// TODO Auto-generated method stub
		super.delete(department);
	}

	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		List<Department> list=new ArrayList<Department>();
		List<Object> obj=null;
		String hql="from Department";
		obj=super.find(hql, null);
		for(int i=0;i<obj.size();i++){
			Department department=(Department)obj.get(i);
			department.setKid(department.getDid());
			list.add(department);
		}
		return list;
	}
	
	public void saveOrUpdate(Department department){
		super.saveOrUpdate(department);
	}

}
