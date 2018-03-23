package com.app.onlineshoping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.onlineshoping.exception.ProductNotFoundException;
import com.app.shoping_backend.dao.CategoryDAO;
import com.app.shoping_backend.dao.ProductDAO;
import com.app.shoping_backend.dto.Category;
import com.app.shoping_backend.dto.Product;

@Controller
public class PageController {

	@Autowired 
	private CategoryDAO categoryDAO;

	@Autowired 
	private ProductDAO productDAO;
	
	public static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	
	@RequestMapping(value = { "/", "/home", "index" })
	public ModelAndView index() {

		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "Home");

		logger.info("Inside PageController index method- INFO");
		logger.debug("Inside PageController index method- DEBUG");
		
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

	// to get dynamic single category page 
	
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProducts(@PathVariable int id  ) throws ProductNotFoundException {

		ModelAndView mav = new ModelAndView("page");
		// productDAO to fetch single product
		
		Product product  = productDAO.get(id);
		
		if(product == null) {
			throw new ProductNotFoundException();
		}
		
		//update the view count
		product.setViews(product.getViews() +1);
		productDAO.update(product);
				
		mav.addObject("title", product.getName());
			
		mav.addObject("product", product);
		
		mav.addObject("userclicksshowproducts", true);

		return mav;

	}

	
	
	
	
	
}
