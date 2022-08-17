package com.ty.car_hibernate_controller;

import com.ty.car_hibernate_dao.CarDao;

public class GetAllCars {

	public static void main(String[] args) {
		
		CarDao cd=new CarDao();
		cd.getAllCars();
	}
}
