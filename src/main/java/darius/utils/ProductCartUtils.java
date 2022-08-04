package darius.utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import darius.model.Product;

public class ProductCartUtils {

	private final CastUtils<Product> castUtils;

	public ProductCartUtils() {
		this.castUtils = new CastUtils<Product>();
	}

	public void initializeCartIfEmpty(HttpSession session) {
		Object cartItems = session.getAttribute("cartItems");
		List<Product> currentCartItems = castUtils.castObjectToList(cartItems, Product.class);
		if (currentCartItems == null) {
			session.setAttribute("cart", new ArrayList<Product>());
		}
	}

	public void addProductToCartIfNotEmpty(HttpSession session, Product product) {
		Object cartItems = session.getAttribute("cartItems");
		List<Product> currentCartItems = castUtils.castObjectToList(cartItems, Product.class);
		currentCartItems.add(product);
		session.setAttribute("cartItems", currentCartItems);
	}

	public void removeProductToCartIfNotEmpty(HttpSession session, Long productId) {
		Object cartItems = session.getAttribute("cartItems");
		List<Product> currentCartItems = castUtils.castObjectToList(cartItems, Product.class);
		currentCartItems.removeIf(item -> item.getId().equals(productId));
		session.setAttribute("cartItems", currentCartItems);
	}
	
}
