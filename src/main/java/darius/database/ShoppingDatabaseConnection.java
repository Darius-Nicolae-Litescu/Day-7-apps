package darius.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ShoppingDatabaseConnection {
    private Connection connection;

    public void connect() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:6033/tapi", "dariusnicolae", "sda@Da2d9asd");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Statement createStatement() {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Statement createStatement(int typeScrollSensitive, int concurReadOnly) {
        try {
            return connection.createStatement(typeScrollSensitive, concurReadOnly);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}