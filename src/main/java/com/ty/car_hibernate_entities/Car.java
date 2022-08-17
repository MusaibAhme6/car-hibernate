package com.ty.car_hibernate_entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {

	@Id
	private int id;
	private String name;
	private String brand;
	private int cost;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Car() {
		super();
	}

	public Car(int id, String name, String brand, int cost) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", brand=" + brand + ", cost=" + cost + "]\n";
	}

}
