package com.shopper.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopper.dao.ShopCRUD;
import com.shopper.dao.ShoppingDataDao;

/**
 * This class contains all the URL routes available for shopkeeper for different
 * activities he/she can perform with the system.
 * 
 * @author 1021124
 *
 */

@Controller
public class ShopManagementController
{

	@RequestMapping(value = "/shopManage", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String shopManage()
	{
		return "shop-manage/shop-id";
	}

	@RequestMapping("/shopManage/selectInterface")
	public String shopSelectInterface(@RequestParam("id") String id,
			HttpSession session)
	{
		session.setAttribute("id", id);
		return "/shop-manage/shop-select-interface";
	}

	@RequestMapping("shopManage/transaction")
	public String transaction(HttpSession session)
	{
		return "shop-manage/transaction";
	}

	@RequestMapping("shopManage/analysis")
	public String analysis(ModelMap model, HttpSession session)
	{
		String shopId = (String) session.getAttribute("id");
		model.addAttribute("shopDataList", ShoppingDataDao.read(shopId));
		model.addAttribute("shop", ShopCRUD.read(shopId));
		return "shop-manage/analysis";
	}
}
