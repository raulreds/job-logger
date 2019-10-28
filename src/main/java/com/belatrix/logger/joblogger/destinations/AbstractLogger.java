package com.belatrix.logger.joblogger.destinations;

import java.util.logging.Logger;

public abstract class AbstractLogger {

    public static final Logger logger = Logger.getLogger("belatrix");

    public abstract void logMessage(String message);
    public abstract void logWarning(String warning);
    public abstract void logError(String error);
}
