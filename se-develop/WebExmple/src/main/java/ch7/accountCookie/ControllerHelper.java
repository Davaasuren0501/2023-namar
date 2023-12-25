package ch7.accountCookie;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import shared.CookieUtil;

import ch7.accountLogin.RequestDataAccount;
import javax.servlet.http.HttpServlet;
import shared.HibernateHelper;
import shared.ButtonMethod;

public class ControllerHelper
        extends ch7.accountLogin.ControllerHelper {

    public ControllerHelper(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
    }

    public String jspLocation(String page) {
        return "/WEB-INF/classes/ch7/accountCookie/" + page;
    }

    @Override
    @ButtonMethod(isDefault = true)
    public String getMethod() {
        String address = "Login.jsp";
        Cookie accountCookie =
                CookieUtil.findCookie(request, "account");
        if (accountCookie != null) {
            Object dataPersistent = HibernateHelper.getFirstMatch(data,
                    "accountNumber",
                    accountCookie.getValue());
            if (dataPersistent != null) {
                data = (RequestDataAccount) dataPersistent;
            }
            address = "Edit.jsp";
        }
        return jspLocation(address);
    }
    
    @Override
    @ButtonMethod(buttonName = "newUserButton")
    public String newUserMethod() {
        data = new RequestDataAccount();
        return jspLocation("Login.jsp");
    }

    @Override
    @ButtonMethod(buttonName = "processButton")
    public String processMethod() {
        if (!isValid(data)) {
            return jspLocation("Expired.jsp");
        }
        response.addCookie(
                new Cookie("account", data.getAccountNumber()));
        HibernateHelper.updateDB(data);
        @SuppressWarnings("rawtypes")
		List list = HibernateHelper.getListData(RequestDataAccount.class);
        request.setAttribute("database", list);
        return jspLocation("Process.jsp");
    }

}
