
package ch2.servletController.annotated;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        urlPatterns={"/ch2/servletController/annotated/Controller"})
public class Controller extends HttpServlet
{
  
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException
  {
    
    //The address of the JSP will be stored as a string.
    String address;
    
    //Set the value of the address to the URL of the page
    //that is associated with the button that was pressed.
    //This 'if' statement is translating a button name to
    //a URL.
    //As the author of the controller, you have knowledge
    //of all the pages that it controls. You must test for
    //the button that was clicked by testing if its name in
    //in the query string using the 'getParameter' method.
    //Only the button that was clicked will have its name 
    //in the query string.
    if (request.getParameter("processButton") != null)
    {
      //This app is reusing the JSPs from the servletController example.
      address = "../Process.jsp";
    }
    else if (request.getParameter("confirmButton") != null)
    {
      address = "../Confirm.jsp";
    }
    else
    {
      address = "../Edit.jsp";
    }
    
    //Create a request dispatcher for the address
    //and forward the request and response objects to it.
    RequestDispatcher dispatcher =
        request.getRequestDispatcher(address);
    dispatcher.forward(request, response);
  }
}
