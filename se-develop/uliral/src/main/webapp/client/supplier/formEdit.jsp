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
  <h2>Edit Supplier</h2>
  <form action="#" method="post">
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
        <option value="supplier1">Supplier1</option>s
        <option value="supplier2">Supplier2</option>
        <option value="supplier3">Supplier3</option>
        <option value="supplier4">Supplier4</option>
      </select>
    </div>
    
    <div class="form-group">
      <label for="supplierDescription">Description</label>
      <textarea id="supplierDescription" name="supplierDescription" rows="4" required></textarea>
    </div>
    --%>
    
    <button type="submit">Update</button>
  </form>
</div>

</body>
</html>
    