package com.belatrix.logger.joblogger.destinations;

import com.belatrix.logger.joblogger.enums.LoggerEnum;
import org.apache.logging.log4j.util.Strings;

public class LoggerDataBase extends AbstractLogger {

    private DestinationsManager destinationsManager;

    public LoggerDataBase(){
        this.destinationsManager = DestinationsManager.getInstance();
    }

    @Override
    public void logMessage(String message){
        if(Strings.isNotBlank(message)){
            this.destinationsManager.getDataBaseHandler().insertLog(message, LoggerEnum.MESSAGE.getId());
        }else{
            throw new RuntimeException("Message must be specified");
        }
    }

    @Override
    public void logWarning(String warning) {
        if(Strings.isNotBlank(warning)){
            this.destinationsManager.getDataBaseHandler().insertLog(warning, LoggerEnum.WARNING.getId());
        }else{
            throw new RuntimeException("Message must be specified");
        }
    }

    @Override
    public void logError(String error) {
        if(Strings.isNotBlank(error)){
            this.destinationsManager.getDataBaseHandler().insertLog(error, LoggerEnum.ERROR.getId());
        }else{
            throw new RuntimeException("Message must be specified");
        }
    }
}
