package com.kshrd.service;

import java.util.List;

import com.kshrd.model.Message;
import com.kshrd.model.utility.Paging;

public interface MessageService {
	
	List<Message> getAllMessages(Paging paging);
	Message getMessageById(Integer id);
	
}
