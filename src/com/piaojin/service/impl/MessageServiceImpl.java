package com.piaojin.service.impl;

import com.piaojin.dao.MessageDAO;
import com.piaojin.domain.Message;
import com.piaojin.service.MessageService;

public class MessageServiceImpl implements MessageService {

	private MessageDAO messageDAO;
	public void deleteMessage(Message message) {
		// TODO Auto-generated method stub
		messageDAO.deleteMessage(message);
	}

	public Message getById(int mid) {
		// TODO Auto-generated method stub
		return messageDAO.getById(mid);
	}

	public MessageDAO getMessageDAO() {
		return messageDAO;
	}

	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

	public void save(Message message) {
		// TODO Auto-generated method stub
		messageDAO.save(message);
	}

	public void update(Message message) {
		// TODO Auto-generated method stub
		messageDAO.update(message);
	}

}
