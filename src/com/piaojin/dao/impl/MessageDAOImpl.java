package com.piaojin.dao.impl;

import java.util.List;
import com.piaojin.domain.Message;


public class MessageDAOImpl extends BaseDAOImpl<Message> implements com.piaojin.dao.MessageDAO {

public void deleteMessage(Message message) {
		// TODO Auto-generated method stub
		super.delete(message);
	}

	public Message getById(int mid) {
		// TODO Auto-generated method stub
		Message message=super.findById(Message.class, mid);
		message.setKid(message.getMid());
		return message;
	}
	
	public void save(Message message){
		super.save(message);
	}

	public void update(Message message) {
		// TODO Auto-generated method stub
		super.saveOrUpdate(message);
	}
}
