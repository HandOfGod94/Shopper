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
	/**
	 * User comment view where user can interact with application 
	 * for submitting feedback
	 * @param model {@link ModelMap} of the application for handling attributes
	 * @return String having full path to user commment view
	 */
	@RequestMapping(value="/userComment", method=RequestMethod.GET)
	public String userComment(ModelMap model)
	{
		model.addAttribute("userComment", new UserComment());
		return "userComment";
	}
	
	/**
	 * Handles request from user comment form and adds it
	 * to database
	 * @param userComment {@link UserComment} object having values from form submitted
	 * @param model {@link ModelMap} object of the application
	 * @return String pointing to same view as user comment view
	 */
	@RequestMapping(value="/addUserComment")
	public String addUserComment(@ModelAttribute("SpringWeb")UserComment userComment, ModelMap model)
	{
		boolean insert = UserCommentCRUD.insert(userComment);
		model.addAttribute("message", insert);
		model.addAttribute("result", (insert)?"Successfully Added":"Oops some error");
		return "userComment";
	}
}
