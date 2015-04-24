package com.piaojin.dao;

import java.util.List;

import com.piaojin.domain.MyFile;


/**
 * Created by piaojin on 2015/1/25.
 */
public interface MyFileDAO extends BaseDAO<MyFile>{
	List<MyFile> getAllSharedFile();
	void deleteMyFile(MyFile MyFile);
	MyFile findMyFileByName(String MyFileName);
	MyFile getById(int fid);
	void save(MyFile MyFile);
	void update(MyFile MyFile);
}
