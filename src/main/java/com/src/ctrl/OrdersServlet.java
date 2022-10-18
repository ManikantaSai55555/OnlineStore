package com.src.ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.dao.ItemsDaoImpl;
import com.src.dao.ItemsDaoInter;
import com.src.dao.UsersDaoImpl;
import com.src.dao.UsersDaoInter;
import com.src.model.Item;
import com.src.model.Order;
import com.src.model.User;
import com.src.service.ItemServiceImpl;
import com.src.service.ItemServiceInter;
import com.src.service.OrderServiceImpl;
import com.src.service.OrderServiceInter;
import com.src.service.UserServiceImpl;
import com.src.service.UserServiceInter;

public class OrdersServlet extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode=request.getParameter("mode");
		if(mode.equals("add"))
		{
		    System.out.println("add order");
		    String itemname=request.getParameter("itemname");
		    ItemServiceInter idi=new ItemServiceImpl();
		    Item item=new Item(itemname);
		    int itemid=idi.getItemId(item);
		    String username=(String)request.getSession().getAttribute("username");
            UserServiceInter usi=new UserServiceImpl();
            int uid=usi.getUserID(new User(username));
            Order order=new Order(itemid,uid);
            OrderServiceInter osi=new OrderServiceImpl();
            int res=osi.addOrder(order);
            response.sendRedirect("./JSP/users/welcome.jsp");
		}
		else if(mode.equals("delete"))
		{
		    String itemname=request.getParameter("itemname");
            ItemServiceInter idi=new ItemServiceImpl();
            Item item=new Item(itemname);
            int itemid=idi.getItemId(item);
            String username=(String)request.getSession().getAttribute("username");
            UserServiceInter usi=new UserServiceImpl();
            int uid=usi.getUserID(new User(username));
            Order order=new Order(itemid,uid);
            OrderServiceInter osi=new OrderServiceImpl();
            int res=osi.deleteOrder(order);
            response.sendRedirect("./JSP/users/welcome.jsp");
		}
		else if(mode.equals("deleteitem"))
		{
		    String itemname=request.getParameter("itemname");
		    String username=(String)request.getSession().getAttribute("username");
		    OrderServiceInter osi=new OrderServiceImpl();
		    int res=osi.deleteOrderItem(itemname, username);
		    response.sendRedirect("./JSP/users/cart.jsp");
		}
		else if(mode.equals("pay"))
		{
		    String username=(String)request.getSession().getAttribute("username");
		    OrderServiceInter osi=new OrderServiceImpl();
		    int res=osi.orderPayment(username);
		    if(res>0)
		        response.sendRedirect("./JSP/users/success.jsp");
		    else
		        response.sendRedirect("./JSP/users/cart.jsp");
		}
		else if(mode.equals("deliver"))
		{
		    String itemname=request.getParameter("itemname");
            String username=request.getParameter("username");
            OrderServiceInter osi=new OrderServiceImpl();
            int quantity=Integer.parseInt(request.getParameter("quantity"));
            int res=osi.deliverItem(itemname, username,quantity);
            response.sendRedirect("./JSP/admin/allOrders.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
