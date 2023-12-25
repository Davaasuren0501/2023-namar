
package ch7.catalogue;


import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import shared.HelperBaseCh6;
import shared.HibernateHelper;
import shared.ButtonMethod;

public class ControllerHelper extends HelperBaseCh6 {
  
  protected CatalogueItem item = new CatalogueItem();
  protected ShoppingCart<CatalogueItem> cart =
      new ShoppingCart<CatalogueItem>();
  
  public ControllerHelper(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) {
        super(servlet, request, response);
  }
  
  static public void initHibernate(HttpServlet servlet) {    
    HibernateHelper
        .initSessionFactory(CatalogueItem.class);
  }
  
  public Object getItem() {
    return item;
  }
  
  public Object getCart() {
    return cart;
  }
  
  public void copyFromSession(Object sessionHelper) {
    if (sessionHelper.getClass() == this.getClass()) {
      item = ((ControllerHelper)sessionHelper).item;
      cart = ((ControllerHelper)sessionHelper).cart;
    }
  }
  
  public String jspLocation(String page) {
    return "/WEB-INF/classes/ch7/catalogue/" + page;
  }
  
  @ButtonMethod(isDefault=true)
  public String methodDefault() {
    //Make all the catalog items available from the BrowseLoop.jsp.
    @SuppressWarnings("rawtypes")
	java.util.List list = HibernateHelper
        .getListData(CatalogueItem.class);
    request.setAttribute("allItems", list);        
    return jspLocation("BrowseLoop.jsp");
  }
  
  @ButtonMethod(buttonName="addCart")
  public String methodAddCart() {
    cart.addItem(item);
    item = new CatalogueItem();
    return methodDefault();
  }
  
  @ButtonMethod(buttonName="emptyCart")
  public String methodEmptyCart() {
    cart.resetItems();
    return methodDefault();
  }  
  
  @ButtonMethod(buttonName="viewItem")
  public String methodViewItem() {
    fillBeanFromRequest(item);
    if (item.getItemId() != null) {
      Object dbObj = HibernateHelper.
          getFirstMatch(item, "itemId", 
                        item.getItemId());
      if (dbObj != null) {
        item = (CatalogueItem)dbObj;
      }
    }
    return methodDefault();
  }
  
  @ButtonMethod(buttonName="viewCart")
  public String methodViewCart() {
    return jspLocation("Cart.jsp");
  }
  
  @ButtonMethod(buttonName="processCart")
  public String methodProcess() {
    cart.setTotal(0);
    cart.setCount(0);
    for(CatalogueItem anItem : cart.getItems()) {
      cart.addTotal(anItem.getPrice());
      cart.incrCount();
    }
    return jspLocation("Process.jsp");
  }
  
  @Override
  public void doGet()
    throws IOException, ServletException 
  {   
      addHelperToSession("helper", SessionData.IGNORE);

      //BrowseLoop.jsp is only page that a GET request will see.
      String address = methodDefault();

      request.getRequestDispatcher(address)
          .forward(request, response);    
  }
  
  @Override
  public void doPost()
    throws ServletException, IOException 
  {   
      addHelperToSession("helper", SessionData.READ);

      String address = executeButtonMethod();

      request.getRequestDispatcher(address).forward(request, response);   
  }
}
