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

	/**
	 * The main view with which shopkeeper will interact
	 * @return String having full path to view present in WebContent
	 */
	@RequestMapping(value = "/shopManage", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String shopManage()
	{
		return "shop-manage/shop-id";
	}

	/**
	 * View containing shop id input field.
	 * It also adds id to current session for future use.
	 * @param id shop's id as present in the database
	 * @param session {@link HttpSession} for storing id of the shop
	 * @return String having full path to view present in WebContet
	 */
	@RequestMapping("/shopManage/selectInterface")
	public String shopSelectInterface(@RequestParam("id") String id,
			HttpSession session)
	{
		session.setAttribute("id", id);
		return "/shop-manage/shop-select-interface";
	}

	/**
	 * Transaction view where shop keeper can manage
	 * sale and return of various products
	 * @param session {@link HttpSession} having main session value as id of the shop
	 * @return String having full path to view present in WebContent
	 */
	@RequestMapping("shopManage/transaction")
	public String transaction(HttpSession session)
	{
		return "shop-manage/transaction";
	}

	/**
	 * Analysis view where the shop owner can review various
	 * analytical aspects of various products present in his/her shop
	 * along with some key market details of important product.
	 * @param model {@link ModelMap} of the application for adding various attributes
	 * @param session {@link HttpSession} of the application
	 * @return String having full path to view present in WebContent. 
	 */
	@RequestMapping("shopManage/analysis")
	public String analysis(ModelMap model, HttpSession session)
	{
		String shopId = (String) session.getAttribute("id");
		model.addAttribute("shopDataList", ShoppingDataDao.read(shopId));
		model.addAttribute("shop", ShopCRUD.read(shopId));
		return "shop-manage/analysis";
	}
}
