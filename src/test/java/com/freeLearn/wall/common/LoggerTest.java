package com.freeLearn.wall.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerTest {
    protected static final Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args){
        Exception exception = new RuntimeException("test print exception stack");
        LOGGER.error(exception.getMessage(), exception);
        LOGGER.fatal("test fatal log");
        LOGGER.error("test error log");
        LOGGER.warn("test warn log");
        LOGGER.info("test info log");
        LOGGER.debug("test debug log");
        LOGGER.trace("test trace log");
    }
}
