class LoggerFactory {
    static Logger getLogger() {
        return new CompositeLogger();
    }
}