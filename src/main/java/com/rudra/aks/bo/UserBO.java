package com.rudra.aks.bo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class UserBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String emailID;
	private String password;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "UserBO [userId=" + userId + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", emailID=" + emailID + ", password=" + password + "]";
	}
	
	public static class UserBuilder {
		public UserBO createUser(Object... userinfo) {
			UserBO userBO = new UserBO();
			userBO.setUserId((Integer)userinfo[0]);
			userBO.setUserName((String)userinfo[1]);
			userBO.setFirstName((String)userinfo[2]);
			userBO.setLastName((String)userinfo[3]);
			userBO.setEmailID((String)userinfo[4]);
			userBO.setPassword((String)userinfo[5]);
			return userBO;
		}
	}
}
