class CompositeLogger implements Logger {
    private final Logger consoleLogger;
    private final Logger fileLogger;
    private final Logger errorLogger;

    CompositeLogger() {
        this.consoleLogger = new ConsoleLogger();
        this.fileLogger = new FileLogger();
        this.errorLogger = new ErrorLogger();
    }

    @Override
    public void log(String message, LogLevel level) {
        switch (level) {
            case INFO:
                consoleLogger.log(message, level);
                break;
            case DEBUG:
                consoleLogger.log(message, level);
                fileLogger.log(message, level);
                break;
            case ERROR:
                consoleLogger.log(message, level);
                fileLogger.log(message, level);
                errorLogger.log(message, level);
                break;
        }
    }
}
