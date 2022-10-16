package com.src.service;

import java.util.List;

import com.src.model.Order;

public interface OrderServiceInter {
    public int addOrder(Order order);
    public int deleteOrder(Order order);
    public List<Order> getAllOrders();
    public int getOrderQuantity(String itemname,String username);
    public int deleteOrderItem(String itemname, String username);
}