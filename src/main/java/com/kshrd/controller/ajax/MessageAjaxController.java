package com.kshrd.controller.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kshrd.model.Message;
import com.kshrd.model.utility.Paging;
import com.kshrd.service.MessageService;

@Controller
public class MessageAjaxController {

	@GetMapping("/ajax")
	public String ajaxHome(){
		return "ajax/index";
	}
	
	@Autowired
	private MessageService mService;
	
	@ResponseBody
	@GetMapping("/ajax/messages")
	public List<Message> getAllMessage(Paging paging){
		return mService.getAllMessages(paging);
	}
	
}
