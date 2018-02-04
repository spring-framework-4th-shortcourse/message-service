package com.kshrd.controller.thymeleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kshrd.model.Message;
import com.kshrd.model.utility.Paging;
import com.kshrd.service.MessageService;

@Controller
public class MessageController {

	private MessageService mService;
	
	@Autowired
	public MessageController(MessageService mService) {
		this.mService = mService;
	}
	
	@GetMapping("/thymeleaf")
	public String homePage(Model model, 
			@RequestParam(value = "limit", required = false, defaultValue="2") Integer limit, 
			@RequestParam(value = "page", required = false, defaultValue="1") Integer page){
		Paging paging = new Paging();
		paging.setLimit(limit);
		paging.setPage(page);
		
		List<Message> messages = mService.getAllMessages(paging);
		model.addAttribute("messages", messages);
		model.addAttribute("paging", paging);
		
		return "thymeleaf/index";
	}
	
	
}
