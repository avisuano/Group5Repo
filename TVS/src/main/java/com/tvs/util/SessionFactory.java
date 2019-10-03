package com.tvs.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class SessionFactory {
	private static org.hibernate.SessionFactory sessionFactory;
	
	public static Session getSession() {
		if(sessionFactory == null) {
			sessionFactory = new Configuration()
					.configure()
					.buildSessionFactory();
		}
		
		return sessionFactory.getCurrentSession();
	}
}
