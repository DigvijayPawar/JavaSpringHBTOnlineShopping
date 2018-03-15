package com.app.shoping_backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.shoping_backend.dao.ProductDAO;
import com.app.shoping_backend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> list() {
		String selectActiveProduct = "FROM Product";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProduct);

		/*query.setParameter("active", true);*/

		return query.getResultList();
	}

	@Override
	public Product get(int id) {
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Product product) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProduct = "FROM Product where active = :active";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProduct, Product.class);

		query.setParameter("active", true);

		return query.getResultList();	
		
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProduct = "FROM Product where active = :active AND categoryId = :categoryId ";

		return sessionFactory.getCurrentSession()
				.createQuery(selectActiveProduct,Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId)
				.getResultList();
		}

	@Override
	public 
	List<Product> getLatestActiveProducts(int count) {

		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product where active = :active order by id",Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
		}	
	}


