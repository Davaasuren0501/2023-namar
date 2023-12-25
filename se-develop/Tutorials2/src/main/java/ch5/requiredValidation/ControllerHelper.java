
package ch5.requiredValidation;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import shared.HelperBaseCh5;
import shared.ButtonMethod;


public class ControllerHelper extends HelperBaseCh5 {
    
    private RequestDataRequired data = 
        new RequestDataRequired();
    
    public ControllerHelper(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
    }

    public Object getData() {
        return data;
    }
    
    public void copyFromSession(Object sessionHelper) {
        if (sessionHelper.getClass() == this.getClass()) {
            data = ((ControllerHelper)sessionHelper).data;
        }        
    }
    
    protected String jspLocation(String page) {
        return "/WEB-INF/classes/ch5/requiredValidation/" 
               + page;
    }

    @ButtonMethod(buttonName="editButton", isDefault=true)
    public String editMethod() {
        return jspLocation("Edit.jsp");
    }

    @ButtonMethod(buttonName="confirmButton")
    public String confirmMethod() {
        //Populate from the query string
        fillBeanFromRequest(data);
        //The next JSP address depends on the validity of the data.
        String address;
        if (isValid(data)) {
            address = jspLocation("Confirm.jsp");
        } else {
            address = jspLocation("Edit.jsp");
        }
        return address;
    }

    @ButtonMethod(buttonName="processButton")
    public String processMethod() {
        return jspLocation("Process.jsp");
    }
    
    @Override
    public void doGet() 
        throws ServletException, java.io.IOException
    {
        //Call the method with false to place a new helper in the session
        addHelperToSession("helper", SessionData.READ);        
        
        String address = executeButtonMethod();  
        
        request.getRequestDispatcher(address).forward(request, response); 
    }
    
}
