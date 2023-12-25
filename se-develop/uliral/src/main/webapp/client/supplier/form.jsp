<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
  <h2>Create Supplier</h2>
  <form action="/uliral/controller/supplier/SupplierServlet" method="post">
    <div class="form-group">
      <label for="supplierName">Supplier Name</label>
      <input type="text" id="supplierName" name="supplierName" required>
    </div>
    
    <div class="form-group">
      <label for="supplierAddress">Address</label>
      <input type="text" id="supplierAddress" name="supplierAddress" required>
    </div>
    
    <div class="form-group">
      <label for="supplierPhone">Phone</label>
      <input type="number" id="supplierPhone" name="supplierPhone" min="0" required>
    </div>
    
	<%--
    <div class="form-group">
      <label for="supplierParent">Parent</label>
      <select id="supplierParent" name="supplierParent">
        <option value="1">Davaasuren</option>
        <option value="2">Ankhbayar</option>
        <option value="3">Temuulen</option>
        <option value="4">Batnyam</option>
      </select>
    </div>
	--%>
    
    <button type="submit">Create Supplier</button>
  </form>
</div>

</body>
</html>
    