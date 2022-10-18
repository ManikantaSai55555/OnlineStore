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
th,td{
border:1px solid black;
}
body{
background-image: linear-gradient( 109.6deg, rgba(156,252,248,1) 11.2%, rgba(110,123,251,1) 91.1% );
}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-light">
	<a href="./welcomeAdmin.jsp">
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
    <div style="padding-right:10px;">
    	<a href="../../index.jsp" type="button" class="btn btn-primary">Logout</a>
    </div>
</nav>
<% 
	OrderServiceInter osi=new OrderServiceImpl();
	ItemServiceInter isi=new ItemServiceImpl();
	UserServiceInter usi=new UserServiceImpl();
	ArrayList<Order> orderList=(ArrayList<Order>)osi.getAllOrders();
%>
<table class="table table-bordered" border="1" style="table-layout:fixed;text-align:center;margin-left:auto;margin-right:auto;width:75%;border-collapse:collapse">
<tr>
<th style="color:green;background-color:yellow;"><b>Item</b></th>
<th style="color:green;background-color:yellow;"><b>Item Name</b></th>
<th style="color:green;background-color:yellow;"><b>User Name</b></th>
<th style="color:green;background-color:yellow;"><b>Quantity</b></th>
<th style="color:green;background-color:yellow;"><b>Total Amount</b></th>
<th style="color:green;background-color:yellow;"><b>Status</b></th>
<th style="color:green;background-color:yellow;"><b>Deliver?</b></th>
</tr>
<%
	for(Order order:orderList)
	{
		Item item=isi.getItemsById(order.getItemid());
		User user=usi.getUserById(order.getUserid());
%>
<tr>
  <td style="color:blue;"><img src=<%=item.getUrl()%> alt="Item image" width="80%" height="80%"/></td>
  <td style="color:blue;"><b><%=item.getItemname() %></b></td>
  <td style="color:blue;"><b><%=user.getUsername() %></b></td>
  <td style="color:blue;"><b><%=order.getOrderQuantity() %></b></td>
  <td style="color:blue;"><b><%=order.getOrderPrice() %></b></td>
  <td style="color:blue;"><b><%=order.getStatus() %></b></td>
  <td><a href="../../ordersservlet?mode=deliver&itemname=<%=item.getItemname() %>&username=<%=user.getUsername() %>&quantity=<%=order.getOrderQuantity() %>" type="button" class="btn btn-primary"><%= (order.getStatus().equals("delivered"))?"<span>&#10003;</span>":"Deliver" %></a></td>
</tr>
<%} %>
</body>
</html>