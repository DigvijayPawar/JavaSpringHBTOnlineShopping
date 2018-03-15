package com.app.shoping_backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.shoping_backend.dao.CategoryDAO;
import com.app.shoping_backend.dto.Category;

//@Component
@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> list() {

		String selectActiveCategory = "FROM Category where active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active",true);
		
		return query.getResultList();
	}

	/*
	 * getting single category based on id
	 */
	@Override
	public Category get(int id) {

		/*
		 * here the id which we are passing is of premitive type. to fetch the category
		 * by id we need to pass its reference type by using wrapper class
		 * Integer.valueOf(id);
		 */

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	@Override

	public boolean add(Category category) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/*
	 * method to update a single category
	 */
	@Override
	public boolean update(Category category) {
		try {
			// update the category into the database table
			sessionFactory.getCurrentSession().update((category));
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try {
			
			sessionFactory.getCurrentSession().update((category));
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
