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
        // TODO Auto-generated method stub
        return udi.addUsers(user);
    }

    @Override
    public int deleteUsers(User user) {
        // TODO Auto-generated method stub
        return udi.deleteUsers(user);
    }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        return udi.getAllUsers();
    }

    @Override
    public List<Order> getOrders(User user) {
        // TODO Auto-generated method stub
        return udi.getOrders(user);
    }

    @Override
    public int getUserID(User user) {
        // TODO Auto-generated method stub
        return udi.getUserID(user);
    }

    @Override
    public User getUserById(int userid) {
        return udi.getUserById(userid);
    }

}
