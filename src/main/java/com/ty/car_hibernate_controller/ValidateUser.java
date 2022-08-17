package com.ty.car_hibernate_controller;

import com.ty.car_hibernate_dao.UserDao;

public class ValidateUser {

	public static void main(String[] args) {
		
		UserDao ud=new UserDao();
		
		ud.validateUser("musaib@123", "ahmed@99");
	}
}
