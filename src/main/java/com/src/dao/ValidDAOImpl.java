package com.src.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ValidDAOImpl implements ValidDAOInter {

    Connection con=null;
    Statement stmt=null;
    
    public void getMyStatement(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
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
    public boolean validUser(String username, String password) {
        boolean res=false;
        getMyStatement();
        String query="select * from users where username='"+username+"' and password='"+password+"'";
        System.out.println(query);
        try {
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next())
            {
                res=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnections();
        return res;
    }

}
