package darius;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import darius.database.ShoppingDatabaseConnection;
import darius.database.ShoppingDatabaseStatement;
import darius.persistence.ProductRepository;
import darius.persistence.ProductRepositoryImpl;
import darius.service.ProductService;
import darius.service.ProductServiceImpl;

@WebServlet("/DisplayProducts")
public class DisplayProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final ProductService productService;
	
	public DisplayProducts(){
		super();
		System.out.println(this.getClass().toString() + " constructor invoked");
        ShoppingDatabaseConnection shoppingDatabaseConnection = new ShoppingDatabaseConnection();
        ShoppingDatabaseStatement shoppingDatabaseStatement = new ShoppingDatabaseStatement(shoppingDatabaseConnection);
        ProductRepository productRepository = new ProductRepositoryImpl(shoppingDatabaseStatement);
        productService = new ProductServiceImpl(productRepository);
        InitializeDatabaseData.initializeProductData(productService);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filterByName = (String) request.getParameter("filterByName");
		System.out.println("Filter term: " + filterByName);
		if(filterByName != null) {
			request.setAttribute("products", productService.filterByProductName(filterByName));
		} else {
			request.setAttribute("products", productService.getAll());
		}
		request.getRequestDispatcher("DisplayProducts.jsp").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
