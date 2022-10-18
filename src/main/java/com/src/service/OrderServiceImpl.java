package com.src.service;

import java.util.List;

import com.src.dao.OrdersDaoImpl;
import com.src.dao.OrdersDaoInter;
import com.src.model.Order;

public class OrderServiceImpl implements OrderServiceInter {

    OrdersDaoInter odi=new OrdersDaoImpl();
    @Override
    public int addOrder(Order order) {
        return odi.addOrder(order);
    }

    @Override
    public int deleteOrder(Order order) {
        return odi.deleteOrder(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return odi.getAllOrders();
    }

    @Override
    public int getOrderQuantity(String itemname, String username) {
        return odi.getOrderQuantity(itemname,username);
    }

    @Override
    public int deleteOrderItem(String itemname, String username) {
        return odi.deleteOrderItem(itemname, username);
    }

    @Override
    public int orderPayment(String username) {
        return odi.orderPayment(username);
    }

    @Override
    public int deliverItem(String itemname, String username,int quantity) {
        return odi.deliverItem(itemname, username,quantity);
    }

}
