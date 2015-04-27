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
			MyFile myfile=(MyFile)list.get(0);
			myfile.setKid(myfile.getFid());
			return myfile;
		}else{
			return null;
		}
	}

	public MyFile getById(int fid) {
		// TODO Auto-generated method stub
		MyFile myfile=super.findById(MyFile.class, fid);
		myfile.setKid(myfile.getFid());
		return myfile;
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
		String hql="from MyFile";
		List<Object> objlist=null;
		List<MyFile> list=null;
		objlist=super.find(hql,null);
		if(objlist!=null){
			list=new ArrayList<MyFile>();
			for(Object o:objlist){
				MyFile tempfile=(MyFile)o;
				tempfile.setUname(tempfile.getEmploy().getName());
				tempfile.setKid(tempfile.getFid());
				list.add(tempfile);
			}
		}
		return list;
	}
}
