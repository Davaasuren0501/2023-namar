package ch7.catalogue.persistent;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shared.HibernateHelper;
import shared.ButtonMethod;

public class ControllerHelper extends shared.HelperBaseCh6 {
    
    private CatalogueItemPersist item = new CatalogueItemPersist();    
    private ShoppingCartPersist<CatalogueItemPersist> cart =
        new ShoppingCartPersist<CatalogueItemPersist>();
    
    public ControllerHelper(
            HttpServlet servlet, 
            HttpServletRequest request, 
            HttpServletResponse response) {
        super(servlet, request, response);
    }
    
      
  static public void initHibernate(HttpServlet servlet) { 
    
    Boolean create = 
        Boolean.parseBoolean(servlet.getInitParameter("create"));  
    if (create) {
        HibernateHelper.createTable(
                ShoppingCartPersist.class,
                CatalogueItemPersist.class);
    }
    HibernateHelper
        .initSessionFactory(
                ShoppingCartPersist.class,
                CatalogueItemPersist.class);
    if (create) 
        CreateCataloguePersist.createCatalogue();
  }

    public String jspLocation(String page) {
        return "/WEB-INF/classes/ch7/catalogue/persistent/" + page;
    }
    
    @ButtonMethod(buttonName="saveCart")
    public String saveCartMethod() {
        methodProcess();
        HibernateHelper.updateDB(cart);
        return jspLocation("SaveCart.jsp");
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

  public String methodBrowseLoop() {
    //Make all the catalog items available from the BrowseLoop.jsp.
    @SuppressWarnings("rawtypes")
	java.util.List list = HibernateHelper
        .getListData(item.getClass());
    request.setAttribute("allItems", list);        
    return jspLocation("BrowseLoop.jsp");
  }
  
  @ButtonMethod(buttonName="addCart")
  public String methodAddCart() {
    cart.addItem(item);
    item = new CatalogueItemPersist();
    return methodBrowseLoop();
  }
  
  @ButtonMethod(buttonName="emptyCart")
  public String methodEmptyCart() {
    cart.resetItems();
    return methodBrowseLoop();
  }  
  
  @ButtonMethod(buttonName="viewItem")
  public String methodViewItem() {
    fillBeanFromRequest(item);
    if (item.getItemId() != null) {
      Object dbObj = HibernateHelper.
          getFirstMatch(item, "itemId", 
                        item.getItemId());
      if (dbObj != null) {
        item = (CatalogueItemPersist)dbObj;
      }
    }
    return methodBrowseLoop();
  }
  
  @ButtonMethod(buttonName="viewCart")
  public String methodViewCart() {
    return jspLocation("Cart.jsp");
  }
  
  @ButtonMethod(buttonName="processCart")
  public String methodProcess() {
    cart.setTotal(0);
    cart.setCount(0);
    for(Object anObject : cart.getItems()) {
      CatalogueItemPersist anItem =
              (CatalogueItemPersist)anObject;
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
      String address = loginMethod();
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
  
  
  @SuppressWarnings("unchecked")
  @ButtonMethod(buttonName="loginButton", isDefault=true)
  public String loginMethod() {
    String address;
    fillBeanFromRequest(cart);
    setErrors(cart);
    if (isValidProperty("accountNumber")) {
      Object dataPersistent = 
        HibernateHelper.getFirstMatch(cart, 
          "accountNumber", cart.getAccountNumber());
      if (dataPersistent != null) {
        cart = (ShoppingCartPersist<CatalogueItemPersist>)dataPersistent;
      }
      clearErrors();
      address = methodBrowseLoop();
    } else {
      address = jspLocation("Login.jsp");
    }
    return address;
  }
  
  @ButtonMethod(buttonName="newUser")
  public String newUserMethod() {
    cart = new ShoppingCartPersist<CatalogueItemPersist>();
    return jspLocation("Login.jsp");
  } 
}
