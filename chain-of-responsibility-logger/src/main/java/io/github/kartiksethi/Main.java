package io.github.kartiksethi;

import io.github.kartiksethi.loggers.LogManager;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LogManager log = LogManager.getInstance();
        log.info("This is info log.");
        log.debug("This is debug log");
        log.warn("This is warn log");
        log.error("This is error log.");
    }
}