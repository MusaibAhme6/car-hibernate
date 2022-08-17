package com.ty.car_hibernate_controller;

import com.ty.car_hibernate_dao.UserDao;
import com.ty.car_hibernate_entities.User;

public class SaveUser {

	
	public static void main(String[] args) {
		
		UserDao ud=new UserDao();
		
		User user=new User();
		user.setName("abid");
		user.setEmail("abid@123");
		user.setPassword("sayed@99");
		ud.saveUser(user);
	}
}
