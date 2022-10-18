package com.src.service;

import java.util.List;

import com.src.dao.UsersDaoImpl;
import com.src.dao.UsersDaoInter;
import com.src.model.Order;
import com.src.model.User;

public class UserServiceImpl implements UserServiceInter {

    UsersDaoInter udi=new UsersDaoImpl();

    @Override
    public int addUsers(User user) {
        return udi.addUsers(user);
    }

    @Override
    public int deleteUsers(User user) {
        return udi.deleteUsers(user);
    }

    @Override
    public List<User> getAllUsers() {
        return udi.getAllUsers();
    }

    @Override
    public List<Order> getOrders(User user) {
        return udi.getOrders(user);
    }

    @Override
    public int getUserID(User user) {
        return udi.getUserID(user);
    }

    @Override
    public User getUserById(int userid) {
        return udi.getUserById(userid);
    }

    @Override
    public List<Order> getPaidOrders(User user) {
        return udi.getPaidOrders(user);
    }

}
