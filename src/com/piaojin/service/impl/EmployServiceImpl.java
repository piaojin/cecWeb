package com.piaojin.service.impl;

import java.util.List;

import com.piaojin.dao.EmployDAO;
import com.piaojin.domain.Employ;
import com.piaojin.service.EmployService;

public class EmployServiceImpl implements EmployService {

	private EmployDAO employDAO;
	public EmployDAO getEmployDAO() {
		return employDAO;
	}

	public void setEmployDAO(EmployDAO employDAO) {
		this.employDAO = employDAO;
	}

	public void deleteEmploy(Employ employ) {
		// TODO Auto-generated method stub
		employDAO.deleteEmploy(employ);
	}

	public Employ checkEmploy(String userName, String password) {
		// TODO Auto-generated method stub
		return employDAO.checkEmploy(userName, password);
	}

	public Employ getById(int userId) {
		// TODO Auto-generated method stub
		return employDAO.getById(userId);
	}

	public void save(Employ employ) {
		// TODO Auto-generated method stub
		employDAO.save(employ);
	}

	public void update(Employ employ) {
		// TODO Auto-generated method stub
		employDAO.update(employ);
	}

	public List<Employ> getAllEmploy() {
		// TODO Auto-generated method stub
		return employDAO.getAllEmploy();
	}

}
