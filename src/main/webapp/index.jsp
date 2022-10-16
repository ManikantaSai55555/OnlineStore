<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<title>Login</title>
<style>
body{
background-image: linear-gradient( 109.6deg, rgba(156,252,248,1) 11.2%, rgba(110,123,251,1) 91.1% );
}
.formclass{
	width:30%;
	border:2px solid black;
	margin-left:auto;
	margin-right:auto;
	margin-top:8%;
	margin-bottom:auto;
	padding-left:10px;
	padding-right:10px;
}
</style>
</head>
<body>
<div class="formclass" align="center">
<h1>LOGIN</h1><hr>
<form action="./usersservlet?mode=valid" method="post" style="text-align:center;margin-left:auto;margin-right:auto">
  <div class="mb-3">
    <label for="uname" class="form-label">Username</label>
    <input type="text" name="uname" class="form-control" id="uname">
    </div>
  <div class="mb-3">
    <label for="pwd" class="form-label">Password</label>
    <input type="password" name="pwd" class="form-control" id="pwd">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button><br/><br/>
  New User?<a href="./JSP/users/addUser.jsp">Register</a>
</form>
</div>
</body>
</html>
