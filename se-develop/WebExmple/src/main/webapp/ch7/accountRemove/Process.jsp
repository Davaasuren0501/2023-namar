<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="utf-8">
    <title>Process Page</title>
  </head>
  <body>
    <p>
      Thank you for your information. Your hobby of 
      <b>${helper.data.hobby}</b> and aversion of 
      <b>${helper.data.aversion}</b> will be added to 
      account number <b>${helper.data.hobby}</b>.
    <form method="POST" action="Controller">
      <p>
        Edit the current record.
        <input type="submit" name="editButton" 
                             value="Edit">
        Remove the current record.
        <input type="submit" name="removeButton" 
                             value="Remove">
      </p>
    </form>        
    <form method="GET" action="Controller">
      <p>
        Log on as a new user. 
        <input type="submit" name="newUserButton" 
                             value="New User">
      </p>
    </form>
    <p>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
                 prefix="core" %>
      <core:forEach var="record" items="${database}">
        ${record.accountNumber}, 
        ${record.hobby}, 
        ${record.aversion}<br>
      </core:forEach>
  </body>
</html>
