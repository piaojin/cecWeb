package com.piaojin.service.impl;

import java.util.List;
import com.piaojin.dao.MyFileDAO;
import com.piaojin.domain.MyFile;
import com.piaojin.service.MyFileService;


public class MyFileServiceImpl implements MyFileService {

	private MyFileDAO myfileDAO;

	public void deleteFile(MyFile file) {
		// TODO Auto-generated method stub
		myfileDAO.deleteMyFile(file);
	}

	public MyFile findFileByName(String fileName) {
		// TODO Auto-generated method stub
		return myfileDAO.findMyFileByName(fileName);
	}

	public MyFile getById(int fid) {
		// TODO Auto-generated method stub
		return myfileDAO.getById(fid);
	}

	public void save(MyFile file) {
		// TODO Auto-generated method stub
		myfileDAO.save(file);
	}

	public void update(MyFile file) {
		// TODO Auto-generated method stub
		myfileDAO.update(file);
	}

	public MyFileDAO getMyfileDAO() {
		return myfileDAO;
	}

	public void setMyfileDAO(MyFileDAO myfileDAO) {
		this.myfileDAO = myfileDAO;
	}

	public List<MyFile> getAllSharedFile() {
		// TODO Auto-generated method stub
		return myfileDAO.getAllSharedFile();
	}

}
