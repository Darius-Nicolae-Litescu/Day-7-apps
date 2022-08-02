package darius.service;

import darius.model.Product;

import java.util.List;

public interface ProductService {
    void createTable();

    void insert(Product product);

    void update(Product product);

    void delete(Long id);

    Product getById(Long id);

    List<Product> getAll();

    List<Product> filterByProductName(String name);

    void dropTable();

    void dropDatabase();
}
