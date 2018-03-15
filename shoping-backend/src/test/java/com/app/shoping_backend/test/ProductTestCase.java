package com.app.shoping_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.shoping_backend.dao.ProductDAO;
import com.app.shoping_backend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.app.shoping_backend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
		
	/*	@Test
		public void testCRUDProduct() {

			// Add operation
			product = new Product();

			product.setName("Oppo selfie 111");
			product.setDescription("This is the description for Oppo mobile in mobile category");
			product.setBrand("OPPO");
			product.setActive(true);
			product.setUnitPrice(25000);
			product.setCategoryId(3);
			product.setSupplierId(3);
			assertEquals("Something went wrong while inserting product inside table", true, productDAO.add(product));

		
			// fetching or updating the cateory

			product = productDAO.get(2);
			product.setName("Samsung Galaxy S7");
			assertEquals("Something went wromg while updating the product inside table", true, productDAO.update(product));

			// delete the category

			assertEquals("Something went wromg while deleting/deactiving the product inside table", true, productDAO.delete(product));

			// list all the active categories
			assertEquals("Something went wromg while showing the product from table", 6, productDAO.list().size());

		}

*/
	
	@Test
	public void testListActiveProducts() {
		assertEquals("Something went wromg while showing the product from table", 5, productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testListActiveProductsByCategory() {
		assertEquals("Something went wromg while showing the list of active products from table", 3, productDAO.listActiveProductsByCategory(3).size());
	}
	@Test
	public void testLatestActiveProducts() {
		assertEquals("Something went wromg while showing the latest Active products from table", 3, productDAO.getLatestActiveProducts(3).size());
	}
	
		
}


