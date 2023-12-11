
package ch3.reorganised;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch3.defaultValidate.RequestDataDefault;
import javax.servlet.http.HttpServlet;
public class ControllerHelper extends HelperBase {
  
  protected RequestDataDefault data;
  
  public ControllerHelper(HttpServlet servlet,
                          HttpServletRequest request,
                          HttpServletResponse response) {
    super(servlet, request, response);
    data = new RequestDataDefault();
  }
  
  public Object getData() {
    return data;
  }
  
  public void doGet() 
      throws ServletException, IOException 
  {  
    request.getSession().setAttribute("helper", this);
    
    data.setHobby(request.getParameter("hobby"));
    data.setAversion(request.getParameter("aversion"));
    
    //The address of the next JSP will be stored in a variable.
    String address;
    
    //Set the value of the address variable to the page that is associated
    //with the button that was pressed.
    if (request.getParameter("processButton") != null) 
    {
      address = "Process.jsp";
    } 
    else if (request.getParameter("confirmButton") != null)
    {
      address = "Confirm.jsp";
    } 
    else 
    {
      address = "Edit.jsp";
    }
    
    RequestDispatcher dispatcher =
        request.getRequestDispatcher(address);
    dispatcher.forward(request, response);
  }
  
}
