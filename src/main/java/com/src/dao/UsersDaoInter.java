package com.src.dao;

import java.util.List;

import com.src.model.Order;
import com.src.model.User;

public interface UsersDaoInter {
    public int getUserID(User user);
	public int addUsers(User user);
	public int deleteUsers(User user);
	public User getUserById(int userid);
	public List<Order> getPaidOrders(User user);
	public List<User> getAllUsers();
	public List<Order> getOrders(User user);
}
