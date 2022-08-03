package darius.logger;

public interface Logger {
    void logMessage(LoggingModel loggingModel);

    void logMessage(String message, LoggingType loggingType);
}
