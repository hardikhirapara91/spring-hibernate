package com.hardik.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Abstract DAO
 * 
 * @author HARDIK HIRAPARA
 *
 */
public abstract class AbstractDao {

	@Autowired
	public SessionFactory sessionFactory;

	/**
	 * Get Session
	 * 
	 * @return Session
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Persist Entity
	 * 
	 * @param entiry
	 */
	public void persist(Object entiry) {
		getSession().persist(entiry);
	}

	/**
	 * Update Entity
	 * 
	 * @param entity
	 */
	public void update(Object entity) {
		getSession().update(entity);
	}

	/**
	 * Delete Entity
	 * 
	 * @param entity
	 */
	public void delete(Object entity) {
		getSession().delete(entity);
	}
}
