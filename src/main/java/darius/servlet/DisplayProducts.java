package darius.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import darius.InitializeDatabaseData;
import darius.InitializeServices;
import darius.logger.Logger;
import darius.logger.LoggingType;
import darius.model.Product;
import darius.service.ProductService;
import darius.utils.ProductCartUtils;

@WebServlet("/DisplayProducts")
public class DisplayProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService productService;
	private Logger logger;

	public DisplayProducts() {
		super();
		productService = InitializeServices.createProductServiceInstance();
		logger = InitializeServices.createConsoleLoggerInstance();
		InitializeDatabaseData.initializeProductData(productService);
		logger.logMessage(this.getClass().toString() + " constructor invoked", LoggingType.INFO);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null) {
			String username = (String) session.getAttribute("username");
			String filterByName = (String) request.getParameter("filterByName");
			logger.logMessage("Filter term: " + filterByName, LoggingType.INFO);
			if (filterByName != null) {
				request.setAttribute("products", productService.filterByProductName(filterByName));
			} else {
				request.setAttribute("products", productService.getAll());
			}
			request.setAttribute("username", username);
			request.getRequestDispatcher("DisplayProducts.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("Login").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		HttpSession session = request.getSession(false);
		String productId = (String) session.getAttribute("productId");
		Long productIdLong = Long.parseLong(productId);
		if (productIdLong != null) {
			Product product = productService.getById(productIdLong);
			if (product != null) {
				if (session != null) {
					ProductCartUtils.initializeCartIfEmpty(session);
					ProductCartUtils.addProductToCartIfNotEmpty(session, product);
				}
			}
		}
	}

}
