package com.piaojin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.piaojin.domain.Employ;


public class EmployDAOImpl extends BaseDAOImpl<Employ> implements com.piaojin.dao.EmployDAO {

public void deleteEmploy(Employ employ) {
		// TODO Auto-generated method stub
		super.delete(employ);
	}

	public Employ checkEmploy(String userName,String password) {
		// TODO Auto-generated method stub
		String hql="from Employ where name='"+userName+"' and pwd='"+password+"'";
		List list=super.find(hql, null);
		if(list.size()==1){
			return (Employ)list.get(0);
		}else{
			return null;
		}
	}

	public Employ getById(int userId) {
		// TODO Auto-generated method stub
		return super.findById(Employ.class, userId);
	}
	
	public void save(Employ employ){
		super.save(employ);
	}

	public void update(Employ employ) {
		// TODO Auto-generated method stub
		super.saveOrUpdate(employ);
	}
	
	public List<Employ> getAllEmploy(){
		List<Employ> list=new ArrayList<Employ>();
		List<Object> obj=null;
		String hql="from Employ";
		obj=super.find(hql, null);
		for(int i=0;i<obj.size();i++){
			list.add((Employ)obj.get(i));
		}
		return list;
	}
}
