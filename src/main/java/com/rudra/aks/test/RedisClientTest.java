package com.rudra.aks.test;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rudra.aks.AppConfiguration;
import com.rudra.aks.bo.UserBO;
import com.rudra.aks.service.UserService;
import com.rudra.aks.service.UserServiceImpl;

public class RedisClientTest {
	/**
	 * Logger
	 */
	private static final Logger logger = Logger.getLogger(RedisClientTest.class);
	
	public static void main(String []args) {
		logger.info("Redis client started ... ");
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		UserService userService = context.getBean(UserServiceImpl.class);
		
		UserBO userBO = new UserBO.UserBuilder().createUser(new Integer(450),"rudra","ankush","verman","aks@rd.com","1234");
		logger.info("UserBO saving... " + userBO);
		userService.saveUser(userBO);
		
		UserBO userBO1 = new UserBO.UserBuilder().createUser(new Integer(550),"abhi","ankush","verman","aks@rd.com","1234");
		logger.info("UserBO saving... " + userBO);
		userService.saveUser(userBO);
		
		userService.deleteUserById(550);
		
		UserBO userget = userService.getUserById(450);
		logger.info("get user : " + userget);
	}
}
