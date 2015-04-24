package com.piaojin.service;

import java.util.List;
import com.piaojin.domain.MyFile;


public interface MyFileService {
	List<MyFile> getAllSharedFile();
	void deleteFile(MyFile file);
	MyFile findFileByName(String fileName);
	MyFile getById(int fid);
	void save(MyFile file);
	void update(MyFile file);
}
