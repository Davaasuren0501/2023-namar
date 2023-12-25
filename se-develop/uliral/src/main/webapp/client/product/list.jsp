<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.Product" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product List</title>
  <link rel="stylesheet" href="/uliral/css/list_product.css"/>
</head>
<body>

<div style="height:830px;overflow-y:scroll; max-width: 1500px;margin: 0 auto;background: #fff;padding: 20px;border-radius: 8px;box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);">

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

  <div class="search-container" style="display:flex;">
  	<a href="/uliral/client/product/form.jsp"  class="button-like">Create Product</a>
     <form action="/uliral/controller/product/ProductServlet" >
        <input type="text" id="searchInput" style="margin-left:5px" value="${param.searchValue}" name="searchInp" placeholder="Search for products...">
        <input type="submit" value="Search" class="button-like">
    </form>
  </div>

  <table>
    <thead>
      <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Price ($)</th>
        <th>Qty</th>
        <th>Supplier</th>
        <th>Description</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <% 
      		ArrayList<Product> productList = (ArrayList<Product>) request.getAttribute("dataList");
            if(productList != null && !productList.isEmpty()) {
                for(Product product : productList) {
            %>
                    <tr>
                        <td><%= product.getId() %></td>
                        <td><%= product.getProductName() %></td>
                        <td><%= product.getPrice() %></td>
                        <td><%= product.getQty() %></td>
                        <td><%= product.getSupplierId() %></td>
                        <td><%= product.getDescription() %></td>
				        <td>
				        	<form action = "/uliral/controller/product/ProductEdit" method="get">
					        	<input type="hidden" name="productId" value="<%= product.getId() %>">
					        	<input type="submit" value="Edit" class="button-like">
				        	</form>
						</td>
                    </tr>
            <% 
                }
            } else {
            %>
                <tr>
                    <td colspan="6">No products available.</td>
                </tr>
            <% 
            }
            %>
    </tbody>
  </table>

</div>

</body>
</html>
