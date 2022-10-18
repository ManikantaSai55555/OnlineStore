<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
  <head>
  <title>Success Page</title>
    <link href="https://fonts.googleapis.com/css?family=Nunito+Sans:400,400i,700,900&display=swap" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
  </head>
    <style>
      body,.card {
        text-align: center;
        padding: 40px 0;
        background: #EBF0F5;
        background-image: linear-gradient( 109.6deg, rgba(156,252,248,1) 11.2%, rgba(110,123,251,1) 91.1% );
      }
        h1 {
          color: #88B04B;
          font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
          font-weight: 900;
          font-size: 40px;
          margin-bottom: 10px;
        }
        p {
         color: #404F5E;
          font-family: "Nunito Sans", "Helvetica Neue", sans-serif;
          font-size:20px;
          margin: 0;
        }
      i {
        color: #9ABC66;
        font-size: 100px;
        line-height: 200px;
        margin-left:-15px;
      }
      .card {
        background: white;
        padding: 60px;
        border-radius: 4px;
        box-shadow: 0 2px 3px #C8D0D8;
        display: inline-block;
        margin: 0 auto;
      }
      nav{
      	padding-top:0;
      }
    </style>
    <body>
    <nav class="navbar navbar-expand-lg bg-light">
	<a href="./welcome.jsp">
      <img
        src="https://img.icons8.com/3d-fluency/2x/shop.png"
        alt="icon"
        height="50px"
        width="50px"
        />
    </a>
    <div style="position:absolute;right:183px;">
    	<a href="./orders.jsp" type="button" class="btn btn-primary">Orders</a>
    </div>
    <div style="position:absolute;right:80px;">
    	<a href="./cart.jsp" type="button" class="btn btn-primary">Go to Cart</a>
    </div>
    <div style="position:absolute;right:0;">
    	<a href="../../index.jsp" type="button" class="btn btn-primary">Logout</a>
    </div>
	</nav>
    <div class="card">
      <div style="border-radius:200px; height:200px; width:200px; background: #F8FAF5; margin:0 auto;">
        <i class="checkmark"><span style="font-family: Arial Unicode MS, Lucida Grande">
     &#10004;
</span></i>
      </div>
        <h1>Success</h1> 
        <b><p>We received your purchase request;<br/> we'll be in touch shortly!</p></b>
      </div>
      </body>
</html>
