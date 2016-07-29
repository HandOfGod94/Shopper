package com.shopper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class handles miscellaneous controller which are
 * responsible for just simple routing of views. 
 * @author 1021124
 *
 */

@Controller
public class MiscController
{
	/**
	 * Start point of application
	 * @return String pointing to first view of the application
	 */
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
}
