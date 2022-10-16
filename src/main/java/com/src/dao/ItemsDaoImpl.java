package com.src.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.src.model.Item;
import com.src.model.User;

public class ItemsDaoImpl implements ItemsDaoInter {

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
    public int getItemId(Item item)
    {
        getMyStatement();
        String query="select * from items where itemname='"+item.getItemname()+"'";
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
    public int addItem(Item item) {
        getMyStatement();
        String query="insert into items(itemname,item_price,itemquantity,itemimage,itemcategory) values('"+item.getItemname()+"',"+item.getPrice()+","+item.getQuantity()+",'"+item.getUrl()+"','"+item.getCategory()+"')";
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
    public int deleteItem(Item item) {
        getMyStatement();
        String query="delete from items where itemname='"+item.getItemname()+"'";
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
    public int editItem(Item item) {
        getMyStatement();
        String query="update items set item_price="+item.getPrice()+",itemquantity="+item.getQuantity()+" where itemname='"+item.getItemname()+"'";
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
    public long getItemPrice(Item item)
    {
        getMyStatement();
        String query="select item_price where itemname="+item.getItemname();
        long price=0L;
        try {
            ResultSet res=stmt.executeQuery(query);
            price=res.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }

    @Override
    public List<Item> displayAllItems() {
        getMyStatement();
        String query="select * from items";
        List<Item> itemList = new ArrayList();
        try {
            ResultSet res=stmt.executeQuery(query);
            while(res.next())
            {
                Item item=new Item(res.getString(2),res.getLong(3),res.getInt(4),res.getString(5),res.getString(6));
                itemList.add(item);
                System.out.println(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnections();
        return itemList;
    }

    @Override
    public Item getItemsById(int itemid) {
        getMyStatement();
        String query="select * from items where itemid="+itemid;
        ResultSet res;
        Item item=null;
        try {
            res = stmt.executeQuery(query);
            res.next();
            item=new Item(res.getString(2),res.getLong(3),res.getInt(4),res.getString(5),res.getString(6));
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        closeConnections();
        return item;
    }

}
