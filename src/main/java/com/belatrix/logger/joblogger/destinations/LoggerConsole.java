package com.belatrix.logger.joblogger.destinations;

import org.apache.logging.log4j.util.Strings;

import java.util.logging.Level;

public class LoggerConsole extends AbstractLogger {

    private DestinationsManager destinationsManager;

    public LoggerConsole(){
        this.destinationsManager = DestinationsManager.getInstance();
        logger.addHandler(this.destinationsManager.getConsoleHandler());
    }

    @Override
    public void logMessage(String message){
        if(Strings.isNotBlank(message)){
            logger.log(Level.INFO, message);
        }else{
            throw new RuntimeException("Message must be specified");
        }
    }

    @Override
    public void logWarning(String warning) {
        if(Strings.isNotBlank(warning)){
            logger.log(Level.WARNING, warning);
        }else{
            throw new RuntimeException("Warning must be specified");
        }
    }

    @Override
    public void logError(String error) {
        if(Strings.isNotBlank(error)){
            logger.log(Level.SEVERE, error);
        }else{
            throw new RuntimeException("Warning must be specified");
        }
    }
}
