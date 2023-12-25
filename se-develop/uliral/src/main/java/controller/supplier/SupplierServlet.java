package controller.supplier;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import Model.Product;
import Model.Supplier;
import controller.MyController;

/**
 * Servlet implementation class SupplierServlet
 */
//@WebServlet("/client/SupplierServlet")
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String supplierName = request.getParameter("supplierName");
        String supplierAddress = request.getParameter("supplierAddress");
        String supplierPhone = request.getParameter("supplierPhone");
        int supplierParent = Integer.parseInt( request.getParameter("supplierParent"));
        
        int id_create = MyController.db.insertSupplier(supplierName, supplierAddress, supplierPhone, supplierParent);
        
        System.out.println("id_create: " + id_create );
        if(id_create > 0) {
            System.out.println( "Create supplier in db" );    
            doGet(request, response);
        } else {
            System.out.println( "Can't create supplier ");  
    		request.setAttribute("message", "Sorry, Can't create supplier" );
    	    RequestDispatcher dispatcher = request.getRequestDispatcher("/client/error/error.jsp");
    	    dispatcher.forward(request, response); 
        }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 
	 	System.out.println( "call doGet from SupplierServlet" );
	 	String searchQuery = request.getParameter("searchQuery");
	 	System.out.println( "search query" );
	 	System.out.println( searchQuery );
	 	System.out.println( request );
	 	String url;
	 	ArrayList<Supplier> list_data = MyController.db.selectSupplier(searchQuery);
	 	
	 	if(list_data!= null) {
	 		request.setAttribute("dataList", list_data);
	 		url = "/client/supplier/list.jsp";
	 	} else {
	 		request.setAttribute("message", "Can't get supplier data from database" );
	 		url = "/client/error/error.jsp";
	 	}
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

}
