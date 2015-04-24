package com.piaojin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.piaojin.domain.MyFile;

public class MyFileDAOImpl extends BaseDAOImpl<MyFile> implements com.piaojin.dao.MyFileDAO {

public void deleteMyFile(MyFile MyFile) {
		// TODO Auto-generated method stub
		super.delete(MyFile);
	}

	public MyFile findMyFileByName(String MyFileName) {
		// TODO Auto-generated method stub
		String hql="from MyFile where name="+"'"+MyFileName+"'";
		List list=super.find(hql, null);
		if(list.size()==1){
			return (MyFile)list.get(0);
		}else{
			return null;
		}
	}

	public MyFile getById(int fid) {
		// TODO Auto-generated method stub
		return super.findById(MyFile.class, fid);
	}
	
	public void save(MyFile MyFile){
		super.save(MyFile);
	}

	public void update(MyFile MyFile) {
		// TODO Auto-generated method stub
		super.saveOrUpdate(MyFile);
	}

	public List<MyFile> getAllSharedFile() {
		// TODO Auto-generated method stub
		String hql="from MyFile where status = 0";
		List<Object> objlist=null;
		List<MyFile> list=null;
		objlist=super.find(hql,null);
		if(objlist!=null){
			list=new ArrayList<MyFile>();
			for(Object o:objlist){
				list.add((MyFile)o);
			}
		}
		return list;
	}
}
