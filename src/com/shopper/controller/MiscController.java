package com.shopper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class handles miscellaneous controller which are
 * responsible for just simple routing of jsp pages. 
 * @author 1021124
 *
 */

@Controller
public class MiscController
{
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
}
