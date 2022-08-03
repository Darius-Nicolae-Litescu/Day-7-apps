package darius.logger.database;

import darius.logger.LoggingModel;

public interface DatabaseLoggerService {
    void createTable();

    void insert(LoggingModel loggingModel);
}
