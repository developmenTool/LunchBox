package com.lunchbox.sample.sampleRest.service;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.lunchbox.sample.sampleRest.model.User;
import com.lunchbox.sample.sampleRest.util.HibernateUtil;

/**
 * Data interaction service for {@link User user}
 * @author Aditya Narain
 */
public class UserService {

	/**
	 * @author adityanarain
	 *
	 */
	public enum UserPresence{
		/**
		 * User is active
		 */
		ACTIVE(1),
		/**
		 * User is inactive
		 */
		INACTIVE(0);
		private  int statusValue;
		private UserPresence(int val){
			statusValue = val;
		}
		/**
		 * Returns the status of the user
		 * @return status of the user. 
		 */
		public Integer getStatus(){
			return  statusValue;
		}
		
	}
	private  Session session;
	private Logger LOGGER = Logger.getLogger(UserService.class);

	/**
	 * Adds a new {@link User user} to the database
	 * @param user {@link User} that need to be added
	 * @return user that was added.If user was not added successfully null is returned.
	 */
	public User addUser(User user){
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			user.setIsActive(UserPresence.ACTIVE.getStatus());
			session.save(user);
			tx.commit();
			return user;
		}
		catch(HibernateException ex){
			if(tx != null){
				tx.rollback();	
			}
			LOGGER.log(Level.ERROR, ex);
		}
		finally{
			session.close(); 
		}
		return null;
	}
	/**
	 * Gets all users from the database
	 * @return instance of all {@link User users}
	 */
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers(){
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = null;
		try{
			cr = session.createCriteria(User.class);
			cr.add(Restrictions.eq("isActive", UserPresence.ACTIVE.getStatus()));
			return (List<User>)cr.list();
		}
		catch(HibernateException ex){
			LOGGER.log(Level.ERROR, ex);
		}
		finally{
			session.close();
		}
		return Collections.<User>emptyList();
		
	}
	
	/**
	 * Gets the user with userName
	 * @param userId unique user id
	 * @return {@link User}
	 */
	public User getUserWithUserId(String userId){
		session = HibernateUtil.getSessionFactory().openSession();
		Criteria cr = null;
		try{
			cr = session.createCriteria(User.class);
			cr.add(Restrictions.eq("userId", userId));
			return (User) cr.uniqueResult();
		}
		catch(HibernateException ex){
			LOGGER.log(Level.ERROR, ex);
		}
		finally{
			session.close();
		}
		return null;
		
	}
	/**
	 * Updates the specified 
	 * @param user {@link User user} to be updated
	 * @return updated user if successful, null is returned if update is unsuccessful
	 */
	public User updateUser(User user){
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			user.setIsActive(UserPresence.ACTIVE.getStatus());
			session.saveOrUpdate(user);
			tx.commit();
			return user;
		}
		catch(HibernateException ex){
			if(tx != null){
				tx.rollback();
			}
			LOGGER.log(Level.ERROR, ex);
		}
		finally{
			session.close();
		}
		return null;
	}
	
	/**
	 * Deletes the User by setting the active indicator of the user as {@link UserPresence#INACTIVE inactive}
	 * @param user to be deleted
	 */
	public void deleteUser(User user){
		session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			user.setIsActive(UserPresence.INACTIVE.getStatus());
			session.saveOrUpdate(user);
			tx.commit();
		}
		catch(HibernateException ex){
			if(tx != null){
				tx.rollback();
			}
			LOGGER.log(Level.ERROR, ex);
		}
		finally{
			session.close();
		}
	}
	

}
