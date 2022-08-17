package com.ty.car_hibernate_controller;

import com.ty.car_hibernate_dao.UserDao;

public class GetUserByEmail {

	public static void main(String[] args) {
		
		UserDao ud=new UserDao();
		ud.getUserByEmail("abid@123");
	}
}
