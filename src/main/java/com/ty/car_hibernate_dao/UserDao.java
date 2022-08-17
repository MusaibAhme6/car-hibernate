package com.ty.car_hibernate_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.ty.car_hibernate_entities.User;

public class UserDao {

	
	public void saveUser(User user) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();;
		entityManager.persist(user);
		entityTransaction.commit();
		System.out.println("User saved successfully");
	}
	
	public User validateUser(String email,String password) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		String q="Select u from User u where u.email=?1 and u.password=?2";
		Query query=entityManager.createQuery(q);
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		List<User> lst=query.getResultList();
		User user=null;
		
		if(lst.size()>0) {
			 user=lst.get(0);
		}
		System.out.println(user);
		return user;
	}
	public boolean deleteUser(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		entityTransaction.begin();
		User user = entityManager.find(User.class, id);
		if (user != null) {
			entityManager.remove(user);
			System.out.println("User deleted");
			entityTransaction.commit();
			return true;
		} else {
			System.out.println("id does not exist.....");
			return false;
		}
		
	}
	public  User getUserByEmail(String email) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		String q="Select u from User u where u.email=?1";
		Query query=entityManager.createQuery(q);
		query.setParameter(1, email);
		
		List<User> lst=query.getResultList();
		User user=null;
		
		if(lst.size()>0) {
			 user=lst.get(0);
			 System.out.println(user);
				return user;
		}
		else {
			System.out.println("User not present");
			return null;
		}
	}
}
