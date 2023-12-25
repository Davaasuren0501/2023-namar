<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model.Supplier" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Supplier List</title>
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
  	<a href="/uliral/client/supplier/form.jsp"  class="button-like">Create Supplier</a>
     <form action="/uliral/controller/supplier/SupplierServlet" >
        <input type="text" id="searchInput" style="margin-left:5px" name="searchQuery" placeholder="Search for supplier...">
        <input type="submit" value="Search" class="button-like">
    </form>
  </div>

  <table>
    <thead>
      <tr>
        <th>Supplier ID</th>
        <th>Name</th>
        <th>Address</th>
        <th>Phone</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <% 
      		ArrayList<Supplier> supplierList = (ArrayList<Supplier>) request.getAttribute("dataList");
            if(supplierList != null && !supplierList.isEmpty()) {
                for(Supplier supplier : supplierList) {
            %>
                    <tr>
                        <td><%= supplier.getId() %></td>
                        <td><%= supplier.getName() %></td>
                        <td><%= supplier.getAddress() %></td>
                        <td><%= supplier.getPhone() %></td>
				        <td>
				  			<a href="/uliral/client/supplier/formEdit.jsp"  class="button-like">Edit</a>
						</td>
                    </tr>
            <% 
                }
            } else {
            %>
                <tr>
                    <td colspan="6">No supplier available.</td>
                </tr>
            <% 
            }
            %>
    </tbody>
  </table>

</div>

</body>
</html>
