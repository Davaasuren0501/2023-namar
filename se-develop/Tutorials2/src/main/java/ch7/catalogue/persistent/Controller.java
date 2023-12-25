package ch7.catalogue.persistent;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends javax.servlet.http.HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
            throws ServletException, IOException {
        new ControllerHelper(this, request, response).doGet();
    }

    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
            throws ServletException, IOException {
        new ControllerHelper(this, request, response).doPost();
    }

    @Override
    public void init() throws ServletException {
        ControllerHelper.initHibernate(this);
    }
    
}
