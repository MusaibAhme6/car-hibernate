package com.ty.car_hibernate_controller;

import com.ty.car_hibernate_dao.CarDao;

public class GetAllCarsByRange {

	public static void main(String[] args) {
		
		CarDao cd=new CarDao();
		
		cd.getAllCarsByRange(10000000, 20000000);
	}
}
