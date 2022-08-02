package darius.service;

import darius.model.Product;
import darius.persistence.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;


    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public void createTable() {
        productRepository.createTable();
    }

    @Override
    public void insert(Product product) {
        productRepository.insert(product);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public List<Product> filterByProductName(String name) {
        return productRepository.filterByProductName(name);
    }

    @Override
    public void dropTable() {
        productRepository.dropTable();
    }

    @Override
    public void dropDatabase() {
        productRepository.dropDatabase();
    }
}
