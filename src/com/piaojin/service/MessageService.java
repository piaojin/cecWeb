package com.piaojin.service;

import com.piaojin.domain.Message;

public interface MessageService {
	void deleteMessage(Message message);
	Message getById(int mid);
	void save(Message message);
	void update(Message message);
}
