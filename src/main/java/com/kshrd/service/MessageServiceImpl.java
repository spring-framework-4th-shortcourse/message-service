package com.kshrd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kshrd.model.Message;
import com.kshrd.model.utility.Paging;
import com.kshrd.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService{

	private MessageRepository messageRepo;
	
	@Autowired
	public MessageServiceImpl(MessageRepository messageRepo) {
		this.messageRepo = messageRepo;
	}
	
	@Override
	public List<Message> getAllMessages(Paging paging) {
		paging.setTotalCount(messageRepo.totalRecord());
		return messageRepo.findAll(paging);
	}

	@Override
	public Message getMessageById(Integer id) {
		return messageRepo.findById(id);
	}

}
