package io.github.kartiksethi.loggers;

import io.github.kartiksethi.enums.LogLevel;

public final class DebugLogger extends Logger {
    public DebugLogger(Logger nextLogger){
        super(LogLevel.DEBUG, nextLogger);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if(this.level == logLevel){
            System.out.println("DEBUG log : "+message);
        } else {
            super.log(logLevel, message);
        }
    }
}

