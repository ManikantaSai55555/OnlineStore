package com.src.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.model.Item;
import com.src.model.User;
import com.src.service.ItemServiceImpl;
import com.src.service.ItemServiceInter;
import com.src.service.UserServiceImpl;
import com.src.service.UserServiceInter;

public class ItemServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String mode=request.getParameter("mode");
	    if(mode.equals("add"))
	    {
	        String itemname=request.getParameter("itemname");
	        long price=Long.parseLong(request.getParameter("price"));
	        int quantity=Integer.parseInt(request.getParameter("quantity"));
	        String url=request.getParameter("url");
	        String category=request.getParameter("category");
	        ItemServiceInter isi=new ItemServiceImpl();
	        Item item=new Item(itemname,price,quantity,url,category);
	        int res=isi.addItem(item);
	        if(res>0)
	            response.sendRedirect("./JSP/admin/welcomeAdmin.jsp");
	        else
	            response.sendRedirect("./JSP/items/addItem.jsp");
	    }
	    else if(mode.equals("delete"))
        {
            String itemname=request.getParameter("itemname");
            Item item=new Item(itemname);
            ItemServiceInter isi=new ItemServiceImpl();           
            int result=isi.deleteItem(item);
            if(result>0)
            {
                response.sendRedirect("./JSP/admin/welcomeAdmin.jsp");
            }
            else
            {
                response.sendRedirect("./JSP/items/deleteItem.jsp");
            }
        }
	    else if(mode.equals("edit"))
	    {
	        String itemname=request.getParameter("itemname");
            long price=Long.parseLong(request.getParameter("price"));
            int quantity=Integer.parseInt(request.getParameter("quantity"));
            Item item=new Item(itemname,price,quantity);
            ItemServiceInter isi=new ItemServiceImpl(); 
            int res=isi.editItem(item);
            if(res>0)
                response.sendRedirect("./JSP/admin/welcomeAdmin.jsp");
            else
                response.sendRedirect("./JSP/items/editItem.jsp");
	    }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
