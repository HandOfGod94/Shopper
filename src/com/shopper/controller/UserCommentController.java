package com.shopper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopper.dao.UserCommentCRUD;
import com.shopper.entity.UserComment;

@Controller
public class UserCommentController
{
	@RequestMapping(value="/userComment", method=RequestMethod.GET)
	public String userComment(ModelMap model)
	{
		model.addAttribute("userComment", new UserComment());
		return "userComment";
	}
	
	@RequestMapping(value="/addUserComment")
	public String addUserComment(@ModelAttribute("SpringWeb")UserComment userComment, ModelMap model)
	{
		boolean insert = UserCommentCRUD.insert(userComment);
		model.addAttribute("message", insert);
		return "result"; 
	}
}
