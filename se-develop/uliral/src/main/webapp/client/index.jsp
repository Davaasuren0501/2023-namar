<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product List</title>
  <link rel="stylesheet" href="/uliral/css/list_product.css"/>
</head>
<body>

<div style="height:830px; max-width: 1500px;margin: 0 auto;background: #fff;padding: 20px;border-radius: 8px;box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);">

	<nav class="navbar">
	  <a href="#" class="navbar-brand">MR.D</a>
	  
	  <div class="menu-icon" onclick="toggleMenu()">☰</div>
		
	  <ul class="navbar-menu" id="navbarMenu">
	    <li><a href="/uliral/client/index.jsp">Home</a></li>
	    <li><a href="/uliral/controller/product/ProductServlet">Product</a></li>
	    <li><a href="/uliral/controller/supplier/SupplierServlet">Supplier</a></li>
    	<li><a href="/uliral/index.jsp">Exit</a></li>
	  </ul>
	</nav>
	<div style="display:flex;width:100%;height:100%;justify-content:center;align-items:center;">Бараа материалын бүртгэл</div>

</div>

</body>
</html>
