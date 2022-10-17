<%@ page import="java.util.*,com.src.model.*,com.src.service.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<style>
body{
background-image: linear-gradient( 109.6deg, rgba(156,252,248,1) 11.2%, rgba(110,123,251,1) 91.1% );
}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
	<a>
      <img
        src="https://img.icons8.com/3d-fluency/2x/shop.png"
        alt="icon"
        height="50px"
        width="50px"
        />
    </a>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="./welcomeAdmin.jsp">Items</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="./allUsers.jsp">Users</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./allOrders.jsp">Orders</a>
        </li>
      </ul>
    </div>
</nav>
<% 
	OrderServiceInter osi=new OrderServiceImpl();
	ItemServiceInter isi=new ItemServiceImpl();
	UserServiceInter usi=new UserServiceImpl();
	ArrayList<Order> orderList=(ArrayList<Order>)osi.getAllOrders();
%>
<table class="table table-bordered" border="1" style="text-align:center;margin-left:auto;margin-right:auto;width:75%;border-collapse:collapse">
<tr>
<th style="color:green;background-color:yellow;">Item</th>
<th style="color:green;background-color:yellow;">Item Name</th>
<th style="color:green;background-color:yellow;">User Name</th>
<th style="color:green;background-color:yellow;">Quantity</th>
<th style="color:green;background-color:yellow;">Total Amount</th>
<th style="color:green;background-color:yellow;">Status</th>
<th style="color:green;background-color:yellow;">Deliver?</th>
</tr>
<%
	for(Order order:orderList)
	{
		Item item=isi.getItemsById(order.getItemid());
		User user=usi.getUserById(order.getUserid());
%>
<tr>
  <td style="color:blue;"><img src=<%=item.getUrl()%> alt="Item image" width="400" height="400"/></td>
  <td style="color:blue;"><%=item.getItemname() %></td>
  <td style="color:blue;"><%=user.getUsername() %></td>
  <td style="color:blue;"><%=order.getOrderQuantity() %></td>
  <td style="color:blue;"><%=order.getOrderPrice() %></td>
  <td style="color:blue;"><%=order.getStatus() %></td>
  <td><a href="../../ordersservlet?mode=deliver&itemname=<%=item.getItemname() %>&username=<%=user.getUsername() %>" type="button" class="btn btn-primary">Deliver</a></td>
</tr>
<%} %>
</body>
</html>