
package ch7.accountRemove;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shared.HibernateHelper;
import shared.ButtonMethod;

@SuppressWarnings("unused")
public class ControllerHelper
    extends ch7.accountLogin.ControllerHelper {
  
  public ControllerHelper(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
  }
  
  @Override
  public String jspLocation(String page) {
    return "/WEB-INF/classes/ch7/accountRemove/" + page;
  }
  
  @ButtonMethod(buttonName="removeButton")
  public String removeMethod() {
    HibernateHelper.removeDB(data);
    data = new ch7.accountLogin.RequestDataAccount();
    return jspLocation("Login.jsp");
  }

}
