package io.github.kartiksethi.loggers;

public final class LoggerChainFactory {
    private LoggerChainFactory() {}

    public static Logger createLoggerChain() {
        Logger errorLogger = new ErrorLogger(null);
        Logger warnLogger = new WarnLogger(errorLogger);
        Logger debugLogger = new DebugLogger(warnLogger);
        return new InfoLogger(debugLogger);
    }
}
