package darius.utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import darius.model.Product;

public class ProductCartUtils {

	public static void initializeCartIfEmpty(HttpSession session) {
		List<Product> currentCartItems = (List<Product>) session.getAttribute("cartItems");
		if (currentCartItems == null) {
			session.setAttribute("cart", new ArrayList<Product>());
		}
	}
	
	public static void addProductToCartIfNotEmpty(HttpSession session, Product product) {
		List<Product> currentCartItems = (List<Product>) session.getAttribute("cartItems");
        currentCartItems.add(product);
        session.setAttribute("cartItems", currentCartItems);
	}

}
