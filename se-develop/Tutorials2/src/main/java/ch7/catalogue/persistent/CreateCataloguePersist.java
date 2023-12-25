
package ch7.catalogue.persistent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shared.HibernateHelper;

@WebServlet(urlPatterns={"/ch7/catalogue/persistent/CreateCatalogue"})
public class CreateCataloguePersist extends HttpServlet {
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
  public void init() {
    HibernateHelper.createTable(CatalogueItemPersist.class);
    HibernateHelper.initSessionFactory(CatalogueItemPersist.class);
  }
  
  static final List<CatalogueItemPersist> itemList = 
      new ArrayList<CatalogueItemPersist>();
  
  static {
    itemList.add(new CatalogueItemPersist(
        "A1", "The Foundation Trilogy",
        "A very fine book. Why not buy one?", 1.11));
    itemList.add(new CatalogueItemPersist(
        "T2", "The Hobbit",
        "A very fine book. Why not buy two?", 2.22));
    itemList.add(new CatalogueItemPersist(
        "Y3", "Light on Yoga",
        "A very fine book. Why not buy three?", 3.33));
    itemList.add(new CatalogueItemPersist(
        "M4", "Blue Monkey Sideshow",
        "A very fine book. Why not buy four?", 4.44));
  };
  
    @Override
  protected void doGet(HttpServletRequest request,
                       HttpServletResponse response)
  throws ServletException, IOException {

      HibernateHelper.updateDB(itemList);
      response.getWriter().print("Persistent Catalogue Created");
      destroy();
    
  }
    
    @SuppressWarnings("unchecked")
    public static void createCatalogue() {
        List<CatalogueItemPersist> itemsDB = (List<CatalogueItemPersist>)
            HibernateHelper.getListData(CatalogueItemPersist.class);
        for (CatalogueItemPersist item : itemsDB) {
            HibernateHelper.removeDB(item);
        }
        HibernateHelper.updateDB(itemList);
    }
}
