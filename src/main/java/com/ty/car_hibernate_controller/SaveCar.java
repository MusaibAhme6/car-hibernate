package com.ty.car_hibernate_controller;

import com.ty.car_hibernate_dao.CarDao;
import com.ty.car_hibernate_entities.Car;

public class SaveCar {
	
	public static void main(String[] args) {
		
		Car car=new Car();
		car.setId(3);
		car.setName("huracan");
		car.setBrand("lamborgini");
		car.setCost(60000000);
		
		CarDao cd=new CarDao();
		cd.saveCar(car);
	}

}
