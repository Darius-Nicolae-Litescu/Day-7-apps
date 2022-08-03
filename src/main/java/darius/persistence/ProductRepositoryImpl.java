package darius.persistence;

import darius.database.ShoppingDatabaseStatement;
import darius.model.Product;

import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private final ShoppingDatabaseStatement shoppingDatabaseStatement;

    public ProductRepositoryImpl(ShoppingDatabaseStatement shoppingDatabaseStatement) {
        this.shoppingDatabaseStatement = shoppingDatabaseStatement;
    }

    @Override
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Product " +
                "(id BIGINT NOT NULL AUTO_INCREMENT," +
                " name VARCHAR(255) NOT NULL," +
                " product_code VARCHAR(255) NOT NULL," +
                " picture_href VARCHAR(255) NOT NULL," +
                " ron_price_per_unit DECIMAL(20,3) NOT NULL," +
                " tax_percentage BIGINT NOT NULL," +
                " available_quantity BIGINT NOT NULL," +
                " PRIMARY KEY (id)" +
                ")";

        shoppingDatabaseStatement.execute(sql, new String());
    }


    @Override
    public void insert(Product product) {
        String sql = "INSERT INTO " +
                "Product(`name`,`product_code`,`picture_href`,`ron_price_per_unit`,`tax_percentage`,`available_quantity`) " +
                "VALUES (?,?,?,?,?,?)";
        shoppingDatabaseStatement.execute(
                sql,
                product.getName(),
                product.getProductCode(),
                product.getPictureHref(),
                product.getRonPricePerUnit(),
                product.getTaxPercentage(),
                product.getAvailableQuantity());
    }


    @Override
    public void update(Product product) {
        String sql = "UPDATE Product " +
                "`name` = ?, `product_code` = ?, `picture_href` = ?, `ron_price_per_unit` = ?, `tax_percentage` = ?, `available_quantity` = ?" +
                " WHERE id = ?";
        Object[] updateParams = new Object[]{
                product.getName(),
                product.getProductCode(),
                product.getPictureHref(),
                product.getRonPricePerUnit(),
                product.getTaxPercentage(),
                product.getAvailableQuantity(),
                product.getId()
        };
        shoppingDatabaseStatement.execute(sql,updateParams);
    }


    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM Product WHERE id = ?";
        shoppingDatabaseStatement.execute(sql, id);
    }

    @Override
    public Product getById(Long id) {
        String sql = "SELECT * FROM Product WHERE id = ?";
        return shoppingDatabaseStatement.executeGetProductById(sql, id);
    }

    @Override
    public List<Product> getAll() {
        String sql = "SELECT * FROM Product";
        return shoppingDatabaseStatement.executeGetMultipleProducts(sql);
    }

    @Override
    public List<Product> filterByProductName(String name) {
        String sql = "SELECT * from Product where name like %?%";
        return shoppingDatabaseStatement.executeGetMultipleProducts(sql, name);
    }

    @Override
    public void dropTable() {
        String sql = "DROP TABLE IF EXISTS Product";
        shoppingDatabaseStatement.execute(sql, new String());
    }

    @Override
    public void dropDatabase() {
        String sql = "DROP DATABASE IF EXISTS Product";
        shoppingDatabaseStatement.execute(sql, new String());
    }
}
