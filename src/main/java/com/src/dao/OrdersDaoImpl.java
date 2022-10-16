package com.src.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.src.model.Item;
import com.src.model.Order;
import com.src.model.User;
import com.src.service.ItemServiceImpl;
import com.src.service.ItemServiceInter;
import com.src.service.UserServiceImpl;
import com.src.service.UserServiceInter;

public class OrdersDaoImpl implements OrdersDaoInter {

    Connection con=null;
    Statement stmt=null;
    
    public void getMyStatement(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","Root@123");
            stmt=con.createStatement();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void closeConnections() {
        try {
            con.close();
            stmt.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Override
    public int addOrder(Order order) {
        getMyStatement();
        String query="select item_price from items where itemid="+order.getItemid();
        ResultSet result;
        long price=0L;
        try {
            result = stmt.executeQuery(query);
            result.next();
            price=result.getLong(1);
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
        query="select * from orders where itemid="+order.getItemid()+" and uid="+order.getUserid();
        int res=0;
        try {
            result = stmt.executeQuery(query);
            if(result.next())
            {
                query="update orders set orderquantity=orderquantity+1, orderprice=orderprice+"+price+" where itemid="+order.getItemid()+" and uid="+order.getUserid();
            }
            else
            {
                query="insert into orders(itemid,uid,orderquantity,orderprice) values("+order.getItemid()+","+order.getUserid()+",1,"+price+")";
            }
            try {
                res=stmt.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }            
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        closeConnections();
        return res;
    }

    @Override
    public int deleteOrder(Order order) {
        getMyStatement();
        String query="select item_price from items where itemid="+order.getItemid();
        ResultSet result;
        long price=0L;
        int res=0;
        try {
            result = stmt.executeQuery(query);
            result.next();
            price=result.getLong(1);
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
        query="select orderquantity from orders where itemid="+order.getItemid()+" and uid="+order.getUserid();
        try {
            result=stmt.executeQuery(query);
            if(result.next())
            {
                if(result.getInt(1)>1)
                {
                    query="update orders set orderquantity=orderquantity-1, orderprice=orderprice-"+price+" where itemid="+order.getItemid()+" and uid="+order.getUserid();
                }
                else
                {
                    query="delete from orders where itemid="+order.getItemid()+" and uid="+order.getUserid();
                }
                res=stmt.executeUpdate(query);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        closeConnections();
        return res;
    }

    @Override
    public List<Order> getAllOrders() {
        getMyStatement();
        String query="select * from orders";
        List<Order> orderList = new ArrayList();
        try {
            ResultSet res=stmt.executeQuery(query);
            while(res.next())
            {
                Order order=new Order(res.getInt(2),res.getInt(3),res.getInt(4),res.getLong(5));
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnections();
        return orderList;
    }

    @Override
    public int getOrderQuantity(String itemname, String username) {
        getMyStatement();
        ItemServiceInter idi=new ItemServiceImpl();
        Item item=new Item(itemname);
        int itemid=idi.getItemId(item);
        UserServiceInter usi=new UserServiceImpl();
        int uid=usi.getUserID(new User(username));
        String query="select orderquantity from orders where itemid="+itemid+" and uid="+uid;
        int quantity=0;
        try {
            ResultSet res=stmt.executeQuery(query);
            if(res.next())
                quantity=res.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnections();
        return quantity;
    }

    @Override
    public int deleteOrderItem(String itemname, String username) {
        getMyStatement();
        ItemServiceInter idi=new ItemServiceImpl();
        Item item=new Item(itemname);
        int itemid=idi.getItemId(item);
        UserServiceInter usi=new UserServiceImpl();
        int uid=usi.getUserID(new User(username));
        String query="delete from orders where itemid="+itemid+" and uid="+uid;
        int res=0;
        try {
            res=stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnections();
        return res;
    }

}
