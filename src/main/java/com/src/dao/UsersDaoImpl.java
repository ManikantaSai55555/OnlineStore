package com.src.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.src.model.Item;
import com.src.model.Order;
import com.src.model.User;

public class UsersDaoImpl implements UsersDaoInter {

    Connection con=null;
    Statement stmt=null;
    
    public void getMyStatement(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","Root@123");
            stmt=con.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void closeConnections() {
        try {
            con.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public int addUsers(User user) {
        getMyStatement();
        String query="insert into users(username,password) values('"+user.getUsername()+"','"+user.getPassword()+"')";
        int res=0;
        try {
            res=stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnections();
        return res;
    }

    @Override
    public int deleteUsers(User user) {
        getMyStatement();
        String query="delete from users where username='"+user.getUsername()+"'";
        int res=0;
        try {
            res=stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnections();
        return res;
    }

    @Override
    public List<User> getAllUsers() {
        getMyStatement();
        String query="select * from users";
        List<User> userList = new ArrayList();
        try {
            ResultSet res=stmt.executeQuery(query);
            while(res.next())
            {
                User user=new User(res.getString(2),res.getString(3));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnections();
        return userList;
    }

    @Override
    public List<Order> getOrders(User user) {
        int id=getUserID(user);
        getMyStatement();
        String query="select * from orders where status='unpaid' and uid="+id;
        List<Order> orderList = new ArrayList();
        try {
            ResultSet res=stmt.executeQuery(query);
            while(res.next())
            {
                Order order=new Order(res.getInt(2),res.getInt(3),res.getInt(4),res.getLong(5),res.getString(6));
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnections();
        return orderList;
    }

    @Override
    public int getUserID(User user) {
        getMyStatement();
        String query="select * from users where username='"+user.getUsername()+"'";
        ResultSet res;
        int id=0;
        try {
            res = stmt.executeQuery(query);
            res.next();
            id=res.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnections();
        return id;
    }

    @Override
    public User getUserById(int userid) {
        getMyStatement();
        String query="select * from users where uid="+userid;
        ResultSet res;
        User user=null;
        try {
            res = stmt.executeQuery(query);
            res.next();
            user=new User(res.getString(2),res.getString(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnections();
        return user;
    }

    @Override
    public List<Order> getPaidOrders(User user) {
        int id=getUserID(user);
        getMyStatement();
        String query="select * from orders where status!='unpaid' and uid="+id+" order by orderid desc";
        List<Order> orderList = new ArrayList();
        try {
            ResultSet res=stmt.executeQuery(query);
            while(res.next())
            {
                Order order=new Order(res.getInt(2),res.getInt(3),res.getInt(4),res.getLong(5),res.getString(6));
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnections();
        return orderList;
    }
    
    

}
