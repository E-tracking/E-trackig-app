package com.mkyong.users.dao;

import java.util.List;

import com.mkyong.users.model.User;

public interface UserDao {

	User findByUserName(String username);
	int findUserId(String username);
	User findUserByUserId(int userId,String userType);
	List<User> getAllUsers();
	void AddUSer(User U);
	void deleteUser(User user);
	void update(User user);
}