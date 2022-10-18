<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Item</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous"></script>
<style>
body {
	background-image: linear-gradient(109.6deg, rgba(156, 252, 248, 1) 11.2%,
		rgba(110, 123, 251, 1) 91.1%);
}

.edititem {
	width: 30%;
	border: 2px solid black;
	margin-left: auto;
	margin-right: auto;
	margin-top: 8%;
	margin-bottom: auto;
	padding-left: 10px;
	padding-right: 10px;
	text-align: center;
	padding-top: 20px;
	padding-bottom: 20px;
}

label {
	font-weight: bold;
}

form {
	display: table;
	padding-left: 10%;
}

p {
	display: table-row;
}

label {
	display: table-cell;
}

input {
	display: table-cell;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-light">
		<a href="./welcomeAdmin.jsp"> <img
			src="https://img.icons8.com/3d-fluency/2x/shop.png" alt="icon"
			height="50px" width="50px" />
		</a>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="./welcomeAdmin.jsp">Items</a></li>
				<li class="nav-item"><a class="nav-link" href="./allUsers.jsp">Users</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="./allOrders.jsp">Orders</a>
				</li>
			</ul>
		</div>
		<div style="padding-right: 10px;">
			<a href="../../index.jsp" type="button" class="btn btn-primary">Logout</a>
		</div>
	</nav>
	<%
	String itemname = request.getParameter("itemname");
	%>
	<div class="edititem">
		<h2>
			Edit
			<%=itemname%></h2>
		<form action="../../itemservlet?mode=edit&itemname=<%=itemname%>"
			method="post">
			<p>
				<label for="price">Enter Price : </label> <input type="number"
					name="price" placeholder="price" />
			</p>
			<p>
				<label for="quantity">Enter Quantity : </label> <input type="number"
					name="quantity" placeholder="quantity" />
			</p>
			<div style="text-align: center">
				<input type="submit" />
			</div>
		</form>
	</div>
</body>
</html>