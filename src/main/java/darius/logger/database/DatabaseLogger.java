package darius.logger.database;

import darius.database.ShoppingDatabaseStatement;
import darius.logger.Logger;
import darius.logger.LoggingModel;
import darius.logger.LoggingType;

public class DatabaseLogger implements Logger {
    private final DatabaseLoggerService databaseLoggerService;

    public DatabaseLogger(ShoppingDatabaseStatement shoppingDatabaseStatement) {
        databaseLoggerService = new DatabaseLoggerServiceImpl(shoppingDatabaseStatement);
        databaseLoggerService.createTable();
    }

    @Override
    public void logMessage(LoggingModel loggingModel) {
        databaseLoggerService.insert(loggingModel);
    }

    @Override
    public void logMessage(String message, LoggingType loggingType) {
        LoggingModel loggingModel = new LoggingModel(message, loggingType);
        databaseLoggerService.insert(loggingModel);
    }
}
