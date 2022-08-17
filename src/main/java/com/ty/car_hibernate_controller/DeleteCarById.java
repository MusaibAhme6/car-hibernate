package com.ty.car_hibernate_controller;

import com.ty.car_hibernate_dao.CarDao;

public class DeleteCarById {

	public static void main(String[] args) {
		
		CarDao cd=new CarDao();
		
		cd.deleteCarById(3);
	}
}
