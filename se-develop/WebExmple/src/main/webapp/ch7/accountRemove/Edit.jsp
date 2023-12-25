<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="utf-8">
    <title>Edit Page</title>
  </head>
  <body>
    <p>This is a simple HTML page that has a form in it.</p>
    <p>The value of the hobby that was sent to this page is: 
            ${helper.data.hobby}<br>
       The value of the aversion that was sent to this page is: 
            ${helper.data.aversion}</p>
    <form method="POST" action="Controller">
      <p>This is the data for account number <b>${helper.data.accountNumber}</b>.</p>
      <p>
        Hobby ${helper.errors.hobby} 
        <input type="text" name="hobby" value="${helper.data.hobby}"><br>
        Aversion ${helper.errors.aversion} 
        <input type="text" name="aversion" value="${helper.data.aversion}">
        <input type="submit" name="confirmButton" value="Confirm">
      </p> 
    </form>
  </body>
</html>
