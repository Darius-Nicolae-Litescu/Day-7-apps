package darius.database;

import darius.model.Product;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShoppingDatabaseStatement {
    private Statement statement;
    private final ShoppingDatabaseConnection connection;

    public ShoppingDatabaseStatement(ShoppingDatabaseConnection connection) {
        this.connection = connection;
    }

    public void execute(String sql, Object... params) {
        connection.connect();
        statement = connection.createStatement();
        if (statement != null) {
            execute(statement, sql, params);
            close();
        }
    }

    public boolean execute(Statement statement, String sql, Object... params) {
        try {
            sql = replaceParametersInSqlString(sql, params);
            return statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String replaceParametersInSqlString(String sql, Object... params) {
        if (params != null && params.length > 0) {
            for (Object param : params) {
                if (sql.contains("%")) {
                    sql = sql.replaceAll("\\%.*?\\%\\s?", "'%" + param + "%'");
                } else {
                    {
                        if (param instanceof String) {
                            sql = sql.replaceFirst("\\?", "'" + param + "'");
                        } else if (param instanceof Long || param instanceof Integer || param instanceof BigDecimal) {
                            sql = sql.replaceFirst("\\?", param.toString());
                        }
                    }
                }
            }
        }
        return sql;
    }

    public Product executeGetById(String sql, Long id) {
        Product product = null;
        try {
            sql = replaceParametersInSqlString(sql, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                product = new Product(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("product_code"),
                        resultSet.getString("picture_href"),
                        resultSet.getBigDecimal("ron_price_per_unit"),
                        resultSet.getInt("tax_percentage"),
                        resultSet.getInt("available_quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return product;
    }

    public List<Product> executeGetMultipleProducts(String sql, Object... params) {
        try {
            statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            sql = replaceParametersInSqlString(sql, params);
            ResultSet resultSet = statement.executeQuery(sql);
            int resultCount = 0;
            if (resultSet.last()) {
                resultCount = resultSet.getRow();
                resultSet.beforeFirst();
            }
            System.out.println("Retrieving " + resultCount + " products");
            List<Product> productList = new ArrayList<>(resultCount);
            while (resultSet.next()) {
                Product product = new Product(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("product_code"),
                        resultSet.getString("picture_href"),
                        resultSet.getBigDecimal("ron_price_per_unit"),
                        resultSet.getInt("tax_percentage"),
                        resultSet.getInt("available_quantity"));
                productList.add(product);
            }
            return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();
        return null;
    }

    public void close() {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}