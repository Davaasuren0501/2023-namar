
package ch3.sharedVariable.error;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/ch3/sharedVariable/error/ControllerSharedVariableError"})
public class ControllerSharedVariableError extends HttpServlet {
    
    public int accessCount = 0;
        
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response)
    throws ServletException, IOException {
        
        String address = "/ch3/sharedVariable/Edit.jsp";
        
        incrementSharedVariable();
        
        request.setAttribute("accessCount", accessCount);
        request.getRequestDispatcher(address)
            .forward(request, response);
    }
    
    public void incrementSharedVariable() {
        int temp = accessCount;
        temp++;
        System.out.println(temp);
        try {
          Thread.sleep(3000);
        } catch (java.lang.InterruptedException ie) {
            
        }
        accessCount = temp;
    }
}
