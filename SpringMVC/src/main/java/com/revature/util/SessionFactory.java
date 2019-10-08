package com.revature.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionFactory {

	/*
	 * We only need on instance of our SessionFactory, as one SessionFactory
	 * can produce as many sessions as we need it to.
	 */
	private static org.hibernate.SessionFactory sessionFactory;
	
	public static Session getSession() {
		if(sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}
		
		return sessionFactory.getCurrentSession();
	}
}
