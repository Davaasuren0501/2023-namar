
package ch6.complexPersistent;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import shared.HelperBaseCh6;
import shared.HibernateHelper;
import shared.ButtonMethod;

public class ControllerHelper extends HelperBaseCh6 {
    
    private ComplexDataPersistent data = 
        new ComplexDataPersistent();
    
    public ControllerHelper(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
        logger.warn("Controller Helper");
        logger.info("Controller Helper");
        logger.error("Controller Helper");
        logger.debug("Controller Helper");
    }

    static public void initHibernate(HttpServlet servlet) 
    {
        boolean create =
                Boolean.parseBoolean(servlet.getInitParameter("create"));
	if (create) {
	    HibernateHelper
		.createTable(ComplexDataPersistent.class);
	}     
	HibernateHelper
	    .initSessionFactory(ComplexDataPersistent.class);       
    }

    public Object getData() {   
        return data;
    }
    
    public void copyFromSession(Object sessionHelper) {
        ControllerHelper helper = (ControllerHelper) sessionHelper;
        data = helper.data;
        checked = helper.checked;
        selected = helper.selected;
    }
    
    public void resetNullable() {
        //Checkbox
        data.setExtra(null);
        //Mulitple select
        data.setTeam(null);
        //Radio
        data.setHappiness(0);
    }

    protected String jspLocation(String page) {
        return "/WEB-INF/classes/ch6/complexPersistent/" + page;
    }
    
    @ButtonMethod(buttonName="editButton", isDefault=true)
    public String editMethod() {
        return jspLocation("Edit.jsp");
    }

    @ButtonMethod(buttonName="confirmButton")
    public String confirmMethod() {
        //Create new data and populate from the query string
        resetNullable();
        fillBeanFromRequest(data);
        setCheckedAndSelected(data);
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
        if (!isValid(data)) {
            return jspLocation("Expired.jsp");
        }
        HibernateHelper.updateDB(data);
        @SuppressWarnings("rawtypes")
		List list = HibernateHelper.getListData(ComplexDataPersistent.class);
        request.setAttribute("database", list);
        return jspLocation("Process.jsp");
    }
    
    @Override
    protected void doGet() 
        throws ServletException, java.io.IOException
    {      
        //Call the method with false to place a new helper in the session
        addHelperToSession("helper", SessionData.IGNORE);

        //Edit.jsp is the only page that will be displayed from a GET request.
        String address = editMethod();

        request.getRequestDispatcher(address)
            .forward(request, response);
      
    }
    
    @Override
    protected void doPost() 
        throws ServletException, java.io.IOException 
    {           
        //Call the method with false to place a new helper in the session
        addHelperToSession("helper", SessionData.READ);

        //Edit.jsp is the only page that will be displayed from a GET request.
        String address = executeButtonMethod();

        request.getRequestDispatcher(address)
            .forward(request, response);
      }        
    
 
}
