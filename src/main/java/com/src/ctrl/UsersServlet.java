package com.src.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.model.User;
import com.src.service.UserServiceImpl;
import com.src.service.UserServiceInter;
import com.src.service.ValidImpl;
import com.src.service.ValidInter;

public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UsersServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String mode=request.getParameter("mode");
		if(mode.equals("valid"))
		{
		    String username=request.getParameter("uname");
		    String password=request.getParameter("pwd");
		    if(username.equals("admin") && password.equals("admin@123"))
		    {
		        System.out.println("admin");
		        response.sendRedirect("./JSP/admin/welcomeAdmin.jsp");
		    }
		    else
		    {
    		    ValidInter vi=new ValidImpl();
                boolean rs=vi.validUser(username, password);
                if(rs)
                {
                    HttpSession session=request.getSession();
                    session.setAttribute("username", username);
                    response.sendRedirect("./JSP/users/welcome.jsp");
                }
                else
                {
                    RequestDispatcher rd=request.getRequestDispatcher("./index.jsp");
                    PrintWriter out=response.getWriter();
                    response.setContentType("text/html");
                    out.print("<center><h4 style='color:red;'> Invalid username and password</h4></center>");
                    rd.include(request, response); 
                }
		    }
		}
		else if(mode.equals("add"))
		{
		    String username=request.getParameter("uname");
            String password=request.getParameter("pwd");
            User user=new User(username,password);
            UserServiceInter usi=new UserServiceImpl();
            int res=usi.addUsers(user);
            if(res>0)
            {
                HttpSession session=request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("./JSP/users/welcome.jsp");
            }
            else
            {
                RequestDispatcher rd=request.getRequestDispatcher("./JSP/users/addUser.jsp");
                PrintWriter out=response.getWriter();
                response.setContentType("text/html");
                out.print("<center><h4 style='color:red;'> User already exists with this username!!</h4></center>");
                rd.include(request, response);
            }
		}
		else if(mode.equals("delete"))
		{
		    String username=request.getParameter("uname");
		    User user = new User(username);
		    UserServiceInter usi=new UserServiceImpl();            
            int result=usi.deleteUsers(user);
            if(result>0)
            {
                response.sendRedirect("./JSP/admin/welcomeAdmin.jsp");
            }
            else
            {
                response.sendRedirect("./JSP/users/deleteUser.jsp");
            }
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
