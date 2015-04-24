package com.piaojin.dao;

import com.piaojin.domain.Message;

/**
 * Created by yangjb on 2015/1/25.
 */
public interface MessageDAO extends BaseDAO<Message>{
	void deleteMessage(Message message);
	Message getById(int mid);
	void save(Message message);
	void update(Message message);
}
