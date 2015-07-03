package com.lunchbox.sample.sampleRest.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author adityanarain
 *
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory = getInstance();
	private static SessionFactory getInstance() throws ExceptionInInitializerError{
		return new Configuration().configure().buildSessionFactory();
	}
	/**
	 * @return
	 */
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
	/**
	 * 
	 */
	public static void closeSessionFactory(){
		sessionFactory.close();
	}

}
