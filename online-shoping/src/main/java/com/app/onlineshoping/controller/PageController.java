package com.app.onlineshoping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.shoping_backend.dao.CategoryDAO;
import com.app.shoping_backend.dto.Category;

@Controller
public class PageController {

	@Autowired 
	private CategoryDAO categoryDAO;
	
	
	@RequestMapping(value = { "/", "/home", "index" })
	public ModelAndView index() {

		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "Home");
		
		//passing the list of categories
		mav.addObject("categories",categoryDAO.list());
		
		mav.addObject("userclickshome", true);

		return mav;

	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {

		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "About Us");
		mav.addObject("userclicksabout", true);

		return mav;

	}

	/*@RequestMapping(value = "/listproducts")
	public ModelAndView listproducts() {

		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "View Products");
		mav.addObject("userclickslistproducts", true);

		return mav;

	}
*/
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {

		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "Contact Us");
		mav.addObject("userclickscontact", true);

		return mav;

	}
	
	/*
	 * methods to load all the products
	 * */
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {

		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "All Products");
		mav.addObject("categories", categoryDAO.list());   
		mav.addObject("userclicksallproducts", true);

		return mav;

	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id  ) {

		ModelAndView mav = new ModelAndView("page");
		// categoryDAO to fetch single category
		
		Category category = null;
		 category = categoryDAO.get(id);
		
		mav.addObject("title", category.getName());
		
		//passing the list of categories
		mav.addObject("categories", categoryDAO.list());
		
		//passing the single category object
		mav.addObject("category", category);
		
		mav.addObject("userclickscategoryproducts", true);

		return mav;

	}


}
