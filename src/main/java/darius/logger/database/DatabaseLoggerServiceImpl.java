package darius.logger.database;

import darius.database.ShoppingDatabaseStatement;
import darius.logger.LoggingModel;

import java.time.format.DateTimeFormatter;

public class DatabaseLoggerServiceImpl implements DatabaseLoggerService {
    private final ShoppingDatabaseStatement shoppingDatabaseStatement;
    private final String DATE_TIME_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public DatabaseLoggerServiceImpl(ShoppingDatabaseStatement shoppingDatabaseStatement) {
        this.shoppingDatabaseStatement = shoppingDatabaseStatement;
    }

    @Override
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Logging " +
                "(id BIGINT NOT NULL AUTO_INCREMENT," +
                " message LONGTEXT NOT NULL," +
                " logging_type VARCHAR(255) NOT NULL," +
                " zoned_date_time DATETIME NOT NULL," +
                " application_name VARCHAR(255) NOT NULL," +
                " PRIMARY KEY (id)" +
                ")";

        shoppingDatabaseStatement.execute(sql, new String());
    }

    @Override
    public void insert(LoggingModel loggingModel) {
        String sql = "INSERT INTO " +
                "Logging(`message`,`logging_type`,`zoned_date_time`,`application_name`) " +
                "VALUES (?,?,?,?)";

        shoppingDatabaseStatement.execute(
                sql,
                loggingModel.getMessage(),
                loggingModel.getLoggingType().toString(),
                DateTimeFormatter.ofPattern(DATE_TIME_FORMAT_PATTERN).format(loggingModel.getZonedDateTime()),
                loggingModel.getApplicationName());
    }
}
