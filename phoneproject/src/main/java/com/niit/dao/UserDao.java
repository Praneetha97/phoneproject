package com.niit.dao;

import java.util.List;

import com.niit.bean.User;

public interface UserDao {
	 public boolean addUser(User user);
	   public boolean deleteUser(User user);
	   public boolean updateUser(User user);
	   public List<User> listUsers();
	   public User getUser(int userID);

}
