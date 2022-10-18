<%@ page import="java.util.*,com.src.model.*,com.src.service.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<style>
th,td{
border:1px solid black;
font-weight:bold;
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
          <a class="nav-link active" aria-current="page" href="./welcomeAdmin.jsp">Items</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="./allUsers.jsp">Users</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="./allOrders.jsp">Orders</a>
        </li>
      </ul>
      </div>
      <div style="padding-right:10px;">
    	<a href="../../index.jsp" type="button" class="btn btn-primary">Logout</a>
    </div>
</nav>
<%
	ItemServiceInter isi=new ItemServiceImpl();
	ArrayList<Item> items=(ArrayList<Item>)isi.displayAllItems();
%>
<table class="table table-bordered" border="1" style="table-layout:fixed;text-align:center;margin-left:auto;margin-right:auto;width:75%;border-collapse:collapse">
<tr>
<th style="color:green;background-color:yellow;">Item</th>
<th style="color:green;background-color:yellow;">Name</th>
<th style="color:green;background-color:yellow;">Price</th>
<th style="color:green;background-color:yellow;">Quantity</th>
<th style="color:green;background-color:yellow;">Update</th>
<th style="color:green;background-color:yellow;">Delete</th></b>
</tr>
<%
	for(Item item:items)
	{
%>
<tr>
  <td style="color:blue;"><img src=<%=item.getUrl()%> alt="Item image" width="80%" height="80%"/></td>
  <td style="color:blue;"><%=item.getItemname() %></td>
  <td style="color:blue;">&#8377 <%=item.getPrice() %></td>
  <td style="color:blue;"><%=item.getQuantity() %></td>
  <td>
  <a href="./editItem.jsp?itemname=<%=item.getItemname() %>" type="button" class="btn btn-primary">Edit</a>
  </td>
  <td>
  <a href="../../itemservlet?mode=delete&itemname=<%=item.getItemname() %>" type="button" class="btn btn-primary">Delete</a>
  </td>
</tr>
<%} %>
</table>
<a href="./addItem.jsp" type="button" class="btn btn-primary">Add Item</a>
</body>
</html>