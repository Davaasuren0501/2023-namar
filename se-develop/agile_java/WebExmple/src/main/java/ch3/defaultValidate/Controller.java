
package ch3.defaultValidate;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/ch3/defaultValidate/Controller"})
public class Controller extends HttpServlet {
  
  protected void doGet(HttpServletRequest request, 
                       HttpServletResponse response)
  throws ServletException, IOException {
    RequestDataDefault data = new RequestDataDefault();    
    request.getSession().setAttribute("refData", data);
    
    data.setHobby(request.getParameter("hobby"));
    data.setAversion(request.getParameter("aversion"));
    
    String address;
    if (request.getParameter("processButton") != null)
    {
      address = "/ch3/dataBean/Process.jsp";
    } 
    else if (request.getParameter("confirmButton") != null)
    {
      address = "/ch3/dataBean/Confirm.jsp";
    } 
    else
    {
      address = "/ch3/dataBean/Edit.jsp";
    }
    
    RequestDispatcher dispatcher =
        request.getRequestDispatcher(address);
    dispatcher.forward(request, response);
  }
}
