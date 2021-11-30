package com.dvdrental.dao;

import com.dvdrental.model.Category;
import com.dvdrental.util.HibernateUtil;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Manko
 */
public class CategoryHibernateDAO implements AbstractDAO<Category> {
	@SneakyThrows
	@Override
	public List<Category> findAll() {
		List<Category> categories = new ArrayList<>();
		final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		final Session session = sessionFactory.getCurrentSession();
		try{
			final Transaction transaction = session.beginTransaction();
			categories.addAll( session.createQuery("SELECT c FROM Category c", Category.class).getResultList());
			transaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public Category findById(Long id) {
		return null;
	}

	@Override
	public void deleteById(Long id) {

	}

	@Override
	public void save(Category entity) {

	}
}
