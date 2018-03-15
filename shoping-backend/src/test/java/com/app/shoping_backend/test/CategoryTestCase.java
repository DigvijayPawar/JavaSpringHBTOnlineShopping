package com.app.shoping_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.shoping_backend.dao.CategoryDAO;
import com.app.shoping_backend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.app.shoping_backend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}

	/*
	 * @Test public void testAddCategory() { category = new Category();
	 * 
	 * category.setName("laptop");
	 * category.setDescription("This is laptop category");
	 * category.setImageUrl("CAT_101.jpg");
	 * assertEquals("Something went wrong while inserting the product",true,categoryDAO.add(
	 * category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testGetCategory() {
	 * 
	 * category = categoryDAO.get(2);
	 * 
	 * category.setName("laptop");
	 * category.setDescription("This is television category");
	 * category.setImageUrl("CAT_102.jpg");
	 * assertEquals("Succesfully fetched a single category from table","laptop",
	 * category.getName());
	 * 
	 * }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * 
	 * category = categoryDAO.get(2); category.setName("TV");
	 * category.setDescription("This is television category");
	 * category.setImageUrl("CAT_102.jpg");
	 * assertEquals("Succesfully updated a single category inside table",true,
	 * categoryDAO.update(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * category = categoryDAO.get(2);
	 * assertEquals("Succesfully updated a single category inside table",true,
	 * categoryDAO.delete(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testListCategory() {
	 * assertEquals("Succesfully updated a single category inside table",1,
	 * categoryDAO.list().size()); }
	 */

	@Test
	public void testCRUDCategory() {

		// Add operation
		category = new Category();

		category.setName("laptop");
		category.setDescription("This is laptop category");
		category.setImageUrl("CAT_101.jpg");
		assertEquals("Succesfully added category inside table", true, categoryDAO.add(category));

	
		category = new Category();

		category.setName("Television");
		category.setDescription("This is Television category");
		category.setImageUrl("CAT_102.jpg");
		assertEquals("Succesfully added category inside table", true, categoryDAO.add(category));

		// fetching or updating the cateory

		category = categoryDAO.get(2);
		category.setName("TV");
		assertEquals("Succesfully updated a single category inside table", true, categoryDAO.update(category));

		// delete the category

		assertEquals("Succesfully updated a single category inside table", true, categoryDAO.delete(category));

		// list all the active categories
		assertEquals("Succesfully updated a single category inside table", 1, categoryDAO.list().size());

	}

}
