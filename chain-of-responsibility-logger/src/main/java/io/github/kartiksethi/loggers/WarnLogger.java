package io.github.kartiksethi.loggers;

import io.github.kartiksethi.enums.LogLevel;

public final class WarnLogger extends Logger {
    public WarnLogger(Logger nextLogger){
        super(LogLevel.WARN, nextLogger);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if(this.level == logLevel){
            System.out.println("WARN : "+message);
        } else {
            super.log(logLevel, message);
        }
    }
}
