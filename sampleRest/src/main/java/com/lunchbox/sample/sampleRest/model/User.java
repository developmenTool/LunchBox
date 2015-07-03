package com.lunchbox.sample.sampleRest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Model for Sample User
 * @author Aditya Narain
 */
@Entity
@Table(name = "lb_user")
public class User implements Serializable {

	/**
	 * Unique Serial Version for User class
	 */
	private static final long serialVersionUID = 4388090686278382624L;
	
	@Id
	@Column(name = "lb_userid", unique = true, nullable = false)
	private String userId;
	
	@Column(name = "lb_username", nullable = false)
	private String userName;
	
	@Column(name = "lb_firstname", nullable = false)
	private String firstName;
	
	@Column(name = "lb_lastname", nullable = false)
	private String lastName;
	
	@Column(name = "lb_isactive", nullable = false)
	private Integer isActive;
	
	/**
	 * Default Constructor for User
	 */
	public User(){
		/*
		 * DEFAULT CONSTRUCTOR
		 */
	}
	
	/**
	 * Constructor for User
	 * @param id unique id for each user referred as userId, cannot be null or empty.
	 * @param userName email address of the user, cannot be null or empty.
	 * @param firstName first name of the user, cannot be null or empty.
	 * @param lastName last name of the user, cannot be null or empty.
	 * @param isActive  value for user being active. If user is active then value will be 1 else 0.
	 * @throws IllegalArgumentException if parameter conditions are not met.
	 */
	public User(String id, String userName, String firstName, String lastName, Integer isActive){
		if(userId == null || userId.trim().isEmpty()){
			throw new IllegalArgumentException("userId cannot be null or empty");
		}
		if(userName == null || userName.trim().isEmpty()){
			throw new IllegalArgumentException("userName cannot be null or empty");
		}
		if(firstName == null || firstName.trim().isEmpty()){
			throw new IllegalArgumentException("userName cannot be null or empty");
		}
		if(lastName == null || lastName.trim().isEmpty()){
			throw new IllegalArgumentException("userName cannot be null or empty");
		}
		
		this.userId = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isActive = isActive;
	}

	/**
	 * Gets userId
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the userId
	 * @param userId id unique id for each user referred as userId, cannot be null or empty.
	 * @throws IllegalArgumentException if parameter conditions are not met.
	 */
	public void setUserId(String userId) {
		if(userId == null || userId.trim().isEmpty()){
			throw new IllegalArgumentException("userId cannot be null or emtpy");
		}
		this.userId = userId;
	}

	/** 
	 * Gets userName
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the userName
	 * @param userName userName email address of the user, cannot be null or empty.
	 * @throws IllegalArgumentException if parameter conditions are not met.
	 */
	public void setUserName(String userName) {
		if(userName == null || userName.trim().isEmpty()){
			throw new IllegalArgumentException("userName cannot be null or empty");
		}
		this.userName = userName;
	}

	/**
	 * Gets the user firstName
	 * @return firstName of the user
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the firstname of the user
	 * @param firstName of user
	 * @throws IllegalArgumentException if parameter conditions are not met.
	 */
	public void setFirstName(String firstName) {
		if(firstName == null || firstName.trim().isEmpty()){
			throw new IllegalArgumentException("userName cannot be null or empty");
		}
		this.firstName = firstName;
	}

	/**
	 * Gets the user lastname
	 * @return lastname
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the lastName of the user
	 * @param lastName of the user
	 * @throws IllegalArgumentException if parameter conditions are not met.
	 */
	public void setLastName(String lastName) {
		if(lastName == null || lastName.trim().isEmpty()){
			throw new IllegalArgumentException("userName cannot be null or empty");
		}
		this.lastName = lastName;
	}

	/**
	 * Gets the active indicator of the user, If user is active 1 is returned else 0
	 * @return active indicator of the user
	 */
	public Integer getIsActive() {
		return isActive;
	}

	/**
	 * Sets the active indicator of the user. If user is active 1 is set else 0
	 * @param isActive active indicator of the user
	 */
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	
	
	

}
