package darius.logger;

import darius.utils.Constants;

import java.time.ZonedDateTime;

public class LoggingModel {
    private String message;
    private LoggingType loggingType;
    private ZonedDateTime zonedDateTime;
    private String applicationName;

    public LoggingModel() {
    }

    public LoggingModel(String message, LoggingType loggingType) {
        this.message = message;
        this.loggingType = loggingType;
        this.zonedDateTime = ZonedDateTime.now();
        this.applicationName = Constants.APPLICATION_NAME;
    }

    public LoggingModel(String message, LoggingType loggingType, ZonedDateTime zonedDateTime, String applicationName) {
        this.message = message;
        this.loggingType = loggingType;
        this.zonedDateTime = zonedDateTime;
        this.applicationName = applicationName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LoggingType getLoggingType() {
        return loggingType;
    }

    public void setLoggingType(LoggingType loggingType) {
        this.loggingType = loggingType;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    @Override
    public String toString() {
        return "LoggingModel{" +
                "message='" + message + '\'' +
                ", loggingType=" + loggingType +
                ", zonedDateTime=" + zonedDateTime +
                ", applicationName='" + applicationName + '\'' +
                '}';
    }
}
