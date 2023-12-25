<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Model.Product" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product Form</title>
  <link rel="stylesheet" href="/uliral/css/product_form.css"/>
</head>
<body>

<div class="container">
  <h2>Edit Product</h2>
  <% Product productSelect = (Product) request.getAttribute("productSelect"); %>

 <% if (productSelect != null) { %>
    
  <form action="/uliral/controller/product/ProductEdit" method="post">
    <input type="hidden" name="productId" value="<%= productSelect.getId() %>">
  
    <div class="form-group">
      <label for="productName">Product Name</label>
      <input type="text" id="productName" name="productName" value="<%= productSelect.getProductName() %>"  required>
    </div>
    
    <div class="form-group">
      <label for="productPrice">Price ($)</label>
      <input type="text" id="productPrice" name="productPrice" value="<%= productSelect.getPrice() %>"  min="0" step="1" required>
    </div>
    
    <div class="form-group">
      <label for="productQty">Quantity</label>
      <input type="number" id="productQty" name="productQty" value="<%= productSelect.getQty() %>"  min="0" step="1" required>
    </div>
    
    <div class="form-group">
      <label for="productCategory">Category</label>
      <select id="productCategory" name="productCategory">
        <option value="electronics">Electronics</option>
        <option value="clothing">Clothing</option>
        <option value="books">Books</option>
        <option value="beverages">Beverages</option>
      </select>
    </div>
    
    <div class="form-group">
      <label for="productSupplier">Supplier</label>
      <select id="productSupplier" name="productSupplier">
        <option value="1">Davaasuren</option>
        <option value="2">Temuulen</option>
        <option value="3">Ankhbayar</option>
        <option value="4">Batnyam</option>
      </select>
    </div>
    
    <div class="form-group">
      <label for="productDescription">Description</label>
      <textarea id="productDescription" name="productDescription" rows="4" required><%= productSelect.getDescription() %></textarea>
    </div>
    
    <button type="submit">Update</button>
  </form>
  <% } else { %>
        <p>No product details found.</p>
    <% } %>
</div>

</body>
</html>
    