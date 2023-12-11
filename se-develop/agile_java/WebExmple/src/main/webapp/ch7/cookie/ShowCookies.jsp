<!DOCTYPE HTML>
<html>
  <head>
    <meta charset="utf-8">
    <title>JSP Page</title></head>
  <body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="core" %>    <h2>Received Cookies</h2>
    <p>
    These are the cookies that were sent to the current
    controller. Any cookies set by the current controller
    will not be seen until the page is reloaded.
    <table>
      <tr><th>Name<th>Value
      <core:forEach var="element" items="${cookie}">
        <tr><td>${element.value.name}<td>${element.value.value}
      </core:forEach>
    </table>
    <h2>${marlins}</h2>
    <hr>
    <form action="/${pageContext.servletContext.servletContextName}/ch7/cookie/Controller">
      <input type="submit" name="showCookieButton" 
             value="Show Cookies">
      <input type="submit" name="setCookieButton" 
             value="Set Cookies">
      <input type="submit" name="deleteCookieButton" 
             value="Delete Cookie">
      <input type="submit" name="findCookieButton" 
             value="Find Cookie">
    </form>
    <form action="/${pageContext.servletContext.servletContextName}/ch7/cookie/specific/Controller">
      <input type="submit" name="showCookieButton" 
             value="Show Specific Cookies">
      <input type="submit" name="setSpecificCookieButton" 
             value="Set Specific Cookie">
    </form>
  </body>
</html>
