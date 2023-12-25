
package ch8.services.fedex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("unused")
public class Controller extends HttpServlet {
      
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
        //ControllerEdit.jsp is only page that a GET request will see. 
        ControllerHelper helper = new ControllerHelper(this, request, response);
        helper.doGet();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
        //ControllerEdit.jsp is only page that a GET request will see. 
        ControllerHelper helper = new ControllerHelper(this, request, response);
        helper.doPost();
    }
      
}
