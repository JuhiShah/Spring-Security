package com.ss.dao;

import java.util.List;

import com.ss.model.User;

public interface UserDao {

	void addUser(User user);
	void editUser(User user);
	void deleteUser(int userId);
	User findUser(int userId);
	User findUserByName(String name);
	List<User> getAllUsers();
}
