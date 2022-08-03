package darius.logger.console;

import darius.logger.Logger;
import darius.logger.LoggingModel;
import darius.logger.LoggingType;

public class ConsoleLogger implements Logger {
    @Override
    public void logMessage(LoggingModel loggingModel) {
        if (loggingModel != null) {
            System.out.println(loggingModel);
        }
    }

    @Override
    public void logMessage(String message, LoggingType loggingType) {
        LoggingModel loggingModel = new LoggingModel(message, loggingType);
        System.out.println(loggingModel);
    }
}
