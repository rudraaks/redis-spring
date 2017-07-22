package com.rudra.aks.service;

import java.util.Map;

import com.rudra.aks.bo.UserBO;

public interface UserService {
	void saveUser(UserBO userBO);
	void updateUser(UserBO userBO);
	void deleteUserById(int userid);
	UserBO getUserById(int userid);
	Map<Object, Object>	listUser();
}
