
package ch5.persistentData.configure;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
  
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


public void init() { 
    ControllerHelper.initHibernate(this);
  }
  
  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {
    //ControllerEdit.jsp is only page that a GET request will see.
    ControllerHelper helper = 
        new ControllerHelper(this, request, response);
    helper.doGet();
  }
  
  
  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws IOException, ServletException {
    //ControllerEdit.jsp is only page that a GET request will see.
    ControllerHelper helper = 
        new ControllerHelper(this, request, response);
    helper.doPost();
  }

}
