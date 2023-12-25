
package ch3.reorganised;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/ch3/reorganised/ControllerReorganised"})
public class ControllerReorganised extends HttpServlet {
          
    public void doGet(HttpServletRequest request, 
                         HttpServletResponse response)
    throws ServletException, IOException {
        ControllerHelper helper = 
            new ControllerHelper(this, request, response);
        helper.doGet();
    }   
}
