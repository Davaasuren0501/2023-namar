package controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Product;
import controller.MyController;

/**
 * Servlet implementation class ProductEdit
 */
//@WebServlet("/ProductEdit")
public class ProductEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url;
		if( request.getParameter( "productId" ) != null ) {
			String idp = request.getParameter("productId");
			int idProduct = Integer.parseInt(idp);
			Product productSelect = MyController.db.getProduct(idProduct);
	  		request.setAttribute("productSelect", productSelect );
	  		System.out.println( "can get product select" );
	  		url ="/client/product/formEdit.jsp";
		} else {
	 		url = "/client/error/error.jsp";
	         System.out.println( "Can't get product ");  
	  		request.setAttribute("message", "Sorry, Can't get product" );
		}
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        String productPrice = request.getParameter("productPrice");
        String productQty = request.getParameter("productQty");
        int productSupplier = Integer.parseInt( request.getParameter("productSupplier"));
        String productDescription = request.getParameter("productDescription");

        System.out.println( productId );
        System.out.println( productName );
        System.out.println( productPrice );
        System.out.println( productQty );
        System.out.println( productSupplier );
        System.out.println( productDescription );
        
        int success= MyController.db.updateProduct(productName, productQty, productPrice, productSupplier, productId);
        String url;
        if( success > 0 ) {
        	url = "/controller/product/ProductServlet";
        } else {
	 		url = "/client/error/error.jsp";
	  		request.setAttribute("message", "Sorry, Can't update product" );
        }
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
