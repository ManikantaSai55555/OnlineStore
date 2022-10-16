<%@ page import="com.src.service.*,com.src.model.*,java.util.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
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
<%

	ItemServiceInter isi=new ItemServiceImpl();
	OrderServiceInter osi=new OrderServiceImpl();
	String username=(String)request.getSession(false).getAttribute("username");
	ArrayList<Item> itemsList=(ArrayList<Item>)isi.displayAllItems();
	System.out.println(itemsList);
	//displayItems();
%>
<nav class="navbar navbar-expand-lg bg-light">
	<a>
      <img
        src="https://img.icons8.com/3d-fluency/2x/shop.png"
        alt="icon"
        height="50px"
        width="50px"
        />
    </a>
    <div class="collapse navbar-collapse" id="navbarNav" style="margin-left:37%;">
      <h1>Welcome <%=username %></h1>
    </div>
    <div style="padding-right:10px;">
    	<a href="./cart.jsp" type="button" class="btn btn-primary">Go to Cart</a>
    </div>
    <div>
    	<a href="../../index.jsp" type="button" class="btn btn-primary">Logout</a>
    </div>
</nav>
<table class="border" border="1" style="table-layout:fixed;text-align:center;margin-left:auto;margin-right:auto;width:75%;border-collapse:collapse">
<tr>
<th style="color:green;background-color:yellow;">Item</th>
<th style="color:green;background-color:yellow;">Name</th>
<th style="color:green;background-color:yellow;">Price</th>
<th style="color:green;background-color:yellow;">Quantity</th>
</tr>
<%
	for(Item item:itemsList)
	{
		int quantity=osi.getOrderQuantity(item.getItemname(), username);
		
%>
<tr>
  <td><img src=<%=item.getUrl()%> alt="Item image" width="75%" height="75%"/></td>
  <td><b><%=item.getItemname() %></b></td>
  <td><b>&#8377 <%=item.getPrice() %></b></td>
  <td style="color:blue;">
  <div class="btn-group" role="group" aria-label="Basic mixed styles example">
  <a type="button" class="btn btn-danger" href="../../ordersservlet?mode=delete&itemname=<%=item.getItemname() %>" ><b>-</b></a>
  <button type="button" class="btn"><%=quantity %></button>
  <a type="button" class="btn btn-success" href="../../ordersservlet?mode=add&itemname=<%=item.getItemname() %>" ><b>+</b></a>
</div>
  </td>
</tr>
<%} %>
</table>
</body>
</html>