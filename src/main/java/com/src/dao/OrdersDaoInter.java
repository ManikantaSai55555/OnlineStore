package com.src.dao;

import java.util.List;

import com.src.model.Order;

public interface OrdersDaoInter {
    public int addOrder(Order order);
    public int deleteOrder(Order order);
    public List<Order> getAllOrders();
    public int getOrderQuantity(String itemname,String username);
    public int deleteOrderItem(String itemname,String username);
    public int orderPayment(String username);
    public int deliverItem(String itemname,String username,int quantity);
}
