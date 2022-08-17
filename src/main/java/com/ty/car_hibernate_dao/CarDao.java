package com.ty.car_hibernate_dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.car_hibernate_entities.Car;

public class CarDao {

	public void saveCar(Car car) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(car);
		entityTransaction.commit();
		System.out.println("Car saved successfully");
	}

	public Car getCarById(int id) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		Car car = entityManager.find(Car.class, id);
		System.out.println(car);
		return car;
	}

	public boolean deleteCarById(int id) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		Car car = entityManager.find(Car.class, id);
		if (car != null) {
			entityManager.remove(car);
			System.out.println("Car deleted");
			entityTransaction.commit();
			return true;
		} else {
			System.out.println("id does not exist.....");
			return false;
		}

	}

	public List<Car> getAllCars() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
        String q = "Select c from Car c";
		Query query = entityManager.createQuery(q);

		List<Car> lst = query.getResultList();

		for (Car c : lst) {
			System.out.println(c);
		}
		return lst;
	}

	public List<Car> getAllCarsByBrand(String brand) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String q = "select c from Car c where c.brand=?1";
		Query query = entityManager.createQuery(q);
		query.setParameter(1, brand);

		List<Car> lst = query.getResultList();

		if (lst.size() > 0) {
			for (Car c : lst) {
				System.out.println(c);
			}
		}
		return lst;
	}

	public List<Car> getAllCarsByRange(int start, int end) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		String q = "select c from Car c where c.cost between ?1 and ?2";
		Query query = entityManager.createQuery(q);
        query.setParameter(1, start);
        query.setParameter(2, end);
		List<Car> lst = query.getResultList();

		if (lst.size() > 0) {
			for (Car c : lst) {
				System.out.println(c);
			}
		}
		return lst;
	}

}
