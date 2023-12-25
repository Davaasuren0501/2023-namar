package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Product;
import controller.MyController;

//@WebServlet("/client/ProductServlet")
public class ProductServlet extends HttpServlet {

 /**
	 * 
	 */
	private static final long serialVersionUID = -1627621998328751419L;
@Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String productName = request.getParameter("productName");
     String productPrice =request.getParameter("productPrice");
     String productQty = request.getParameter("productQty");
     String productCategory = request.getParameter("productCategory");
     int supplierId = Integer.parseInt( request.getParameter("productSupplier"));
     String productDescription = request.getParameter("productDescription");

     System.out.println( "Product name: " + productName);     
     System.out.println( "Product price: " + productPrice);  
     System.out.println( "Product qty: " + productQty);  
     System.out.println( "Product supplierId: " + supplierId);  
     System.out.println( "Product desc: " + productDescription);     
     System.out.println( "Product categ: " + productCategory);   

     System.out.println( "db connect : " + MyController.db );   

     int id_create = MyController.db.insertProduct(productName, productQty, productPrice, productDescription, supplierId);
     
     System.out.println("id_create: " + id_create );
     if(id_create > 0) {
         System.out.println( "Create product in db" );    
         doGet(request, response);
     } else {
         System.out.println( "Can't create product ");  
 		request.setAttribute("message", "Sorry, Can't create product" );
 	    RequestDispatcher dispatcher = request.getRequestDispatcher("/client/error/error.jsp");
 	    dispatcher.forward(request, response); 
     }
 }
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 
	 	System.out.println( "call doGet from ProductServlet" );
	 	String searchQuery = request.getParameter("searchInp");
	 	System.out.println( "search query" );
	 	System.out.println( searchQuery );
	 	System.out.println( request );
	 	String url;
	 	ArrayList<Product> list_data = MyController.db.selectProduct(searchQuery);
	 	
	 	if(list_data!= null) {
	 		request.setAttribute("dataList", list_data);
	 		url = "/client/product/list.jsp";
	 	} else {
	 		request.setAttribute("message", "Can't get product data from database" );
	 		url = "/client/error/error.jsp";
	 	}
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}
}

