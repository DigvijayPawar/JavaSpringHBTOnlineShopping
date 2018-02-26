package com.app.shoping_backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.shoping_backend.dao.CategoryDAO;
import com.app.shoping_backend.dto.Category;

//@Component
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private static List<Category> categories = new ArrayList<>();

	static {

		// First category
		Category category = new Category();
		category.setId(1);
		category.setName("Mobile");
		category.setDescription("This is Mobile category");
		category.setImageUrl("CAT_1.jpg");
		// category.setActive(true);
		categories.add(category);

		// Second category
		category = new Category();
		category.setId(2);
		category.setName("Television");
		category.setDescription("This is Television category");
		category.setImageUrl("CAT_2.jpg");
		// category.setActive(true);

		categories.add(category);

		// Third category
		category = new Category();
		category.setId(3);
		category.setName("laptop");
		category.setDescription("This is laptop category");
		category.setImageUrl("CAT_3.jpg");
		// category.setActive(true);

		categories.add(category);

	}

	@Override
	public List<Category> list() {

		return categories;
	}

	@Override
	public Category get(int id) {

		// enhanced for loop
		for (Category category : categories) {

			if (category.getId() == id)
				return category;
		}
		return null; 
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		
		try {
			
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false; 	
		}
		
		
	}

}
