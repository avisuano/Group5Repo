package com.tvs.util;

import org.hibernate.cfg.Configuration;

public class Session {
private static org.hibernate.SessionFactory sessionFactory;
	
	public static org.hibernate.Session getSession() {
		if(sessionFactory == null) {
			sessionFactory = new Configuration()
					.configure()
					.buildSessionFactory();
		}
		
		return sessionFactory.getCurrentSession();
	}
}
