package com.ss.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ss.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	
	@PersistenceContext
	EntityManager em;
	
	public void addUser(User user) {
		em.persist(user);
	}

	public void editUser(User user) {
		try{
			System.out.println("Inside try");
			em.persist(user);
			//return true;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Inside catch");
			//return false;
		}
	}

	public void deleteUser(int userId) {
		System.out.println("delete user");
		em.remove(findUser(userId));
	}

	public User findUser(int userId) {
		User user = new User();
		String strQuery = "select model from User model where id="+userId;
		Query query = em.createQuery(strQuery);
		try{
			System.out.println("Inside try");
			user = (User) query.getSingleResult();
		}catch(Exception e){
			System.out.println("Inside catch");
			user = null;
		}
		return user;
	}

	public User findUserByName(String name) {
		
		User user = null;
		String strQuery = "select model from User model where model.username='"+name+"' ";
		Query query = em.createQuery(strQuery);
		try{
			System.out.println("Inside try");
			user = (User) query.getSingleResult();
			return user;
		}catch(Exception e){
			System.out.println("Inside catch");
			e.printStackTrace();
			return user;
		}
	}

	public List<User> getAllUsers() {
		
		List list = new ArrayList<User>();
		String strQuery = "select model from User model ";
		try{
			Query query = em.createQuery(strQuery);
			list = query.getResultList();
			System.out.println("Inside try");
			return list;
		}catch(Exception e){
			System.out.println("Inside catch");
			return null;
		}
	}
}
