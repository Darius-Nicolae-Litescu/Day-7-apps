package darius;

import darius.database.ShoppingDatabaseConnection;
import darius.database.ShoppingDatabaseStatement;
import darius.logger.Logger;
import darius.logger.console.ConsoleLogger;
import darius.persistence.ProductRepository;
import darius.persistence.ProductRepositoryImpl;
import darius.persistence.UserRepository;
import darius.persistence.UserRepositoryImpl;
import darius.service.ProductService;
import darius.service.ProductServiceImpl;
import darius.service.UserService;
import darius.service.UserServiceImpl;

public class InitializeServices {
	public static ProductService createProductServiceInstance() {
		ShoppingDatabaseConnection shoppingDatabaseConnection = new ShoppingDatabaseConnection();
        ShoppingDatabaseStatement shoppingDatabaseStatement = new ShoppingDatabaseStatement(shoppingDatabaseConnection);
        ProductRepository productRepository = new ProductRepositoryImpl(shoppingDatabaseStatement);
        ProductService productService = new ProductServiceImpl(productRepository);
        return productService;
	}
	
	public static Logger createConsoleLoggerInstance() {
		Logger logger = new ConsoleLogger();
		return logger;
	}
	
	public static UserService createUserServiceInstance() {
		ShoppingDatabaseConnection shoppingDatabaseConnection = new ShoppingDatabaseConnection();
        ShoppingDatabaseStatement shoppingDatabaseStatement = new ShoppingDatabaseStatement(shoppingDatabaseConnection);
        UserRepository userRepository = new UserRepositoryImpl(shoppingDatabaseStatement);
        UserService userService = new UserServiceImpl(userRepository);
        userService.createTable();
        return userService;
	}

}
