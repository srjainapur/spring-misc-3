package com.java.spring.boot.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.java.spring.boot.bean.User;

public class UserDAOTest {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UsersDB");
		EntityManager emanager = factory.createEntityManager();
		
		// Begin Transaction
		emanager.getTransaction().begin();
		
		User user = new User();
		user.setFullname("Samanvi S Jainapur");
		user.setPassword("Samanvi@123");
		user.setEmail("sjainapur@zensar.com");
		
		// Save the user
		emanager.persist(user);
		
		// Updating the user
		User existingUser = new User();
		existingUser.setId(25);
		existingUser.setEmail("Samanvi@gmail.com");
		existingUser.setFullname("Samanvi S Jainapur");
		existingUser.setPassword("Samanvi@123");
		emanager.merge(existingUser);
		
		// Find the user
		int primaryKey = 25;
		User find = emanager.find(User.class, primaryKey);
		System.out.println("User Id :  " + find.getId());
		System.out.println("Full Name  " + find.getFullname());
		System.out.println("Email      " + find.getEmail());
		System.out.println("Password   " + find.getPassword());
		
		// Write custom query
		String sql = "SELECT u FROM User u where u.email = 'Samanvi@gmail.com'";
		Query query = emanager.createQuery(sql);
		User singleResult = (User)query.getSingleResult();
		System.out.println("User Id :  " + singleResult.getId());
		System.out.println("Full Name  " + singleResult.getFullname());
		System.out.println("Email      " + singleResult.getEmail());
		System.out.println("Password   " + singleResult.getPassword());
		
		// Remove user
		int primeKey = 27;
		User reference = emanager.getReference(User.class, primeKey);
		emanager.remove(reference);
		
		emanager.getTransaction().commit();
		emanager.close();
		factory.close();
	}
}
