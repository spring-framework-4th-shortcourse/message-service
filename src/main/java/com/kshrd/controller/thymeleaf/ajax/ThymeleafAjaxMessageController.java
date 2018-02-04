package com.kshrd.controller.thymeleaf.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kshrd.model.Message;
import com.kshrd.model.utility.Paging;
import com.kshrd.service.MessageService;

@Controller
public class ThymeleafAjaxMessageController {

	@Autowired
	private MessageService mService;
	
	@GetMapping("/thymeleaf-ajax")
	public String homePage(Model model, Paging paging){
		
		List<Message> messages = mService.getAllMessages(paging);
		model.addAttribute("messages", messages);
		model.addAttribute("paging", paging);
		
		return "thymeleaf-ajax/index";
	}
	
	@GetMapping("/thymeleaf-ajax/messages")
	public String thymeleafAjax(Model model, Paging paging){
		System.out.println(paging);
		List<Message> messages = mService.getAllMessages(paging);
		model.addAttribute("messages", messages);
		model.addAttribute("paging", paging);
		
		System.out.println(messages);
		return "thymeleaf-ajax/index :: messageTemplate";
	}
	
}
