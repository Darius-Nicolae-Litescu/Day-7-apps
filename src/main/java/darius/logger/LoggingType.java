package darius.logger;

public enum LoggingType {

    INFO(LoggingLevel.INFO),
    WARN(LoggingLevel.WARN),
    DEBUG(LoggingLevel.DEBUG),
    ERROR(LoggingLevel.ERROR);

    private final String loggingType;

    LoggingType(String loggingType) {
        this.loggingType = loggingType;
    }

    public String getLoggingType() {
        return this.loggingType;
    }

    public static class LoggingLevel {
        public static final String INFO = "INFO";
        public static final String WARN = "WARN";
        public static final String DEBUG = "DEBUG";
        public static final String ERROR = "ERROR";

    }
}
