package com.belatrix.logger.joblogger.factory;

import com.belatrix.logger.joblogger.enums.LoggerEnum;
import com.belatrix.logger.joblogger.destinations.LoggerConsole;
import com.belatrix.logger.joblogger.destinations.LoggerDataBase;
import com.belatrix.logger.joblogger.destinations.LoggerFile;
import com.belatrix.logger.joblogger.destinations.AbstractLogger;

public class LoggerFactory {

    public static AbstractLogger create(String type) {
        AbstractLogger logger;
        if (LoggerEnum.CONSOLE.getType().equals(type)){
            logger = new LoggerConsole();
        } else if (LoggerEnum.FILE.getType().equals(type)){
            logger = new LoggerFile();
        } else if (LoggerEnum.DATA_BASE.getType().equals(type)){
            logger = new LoggerDataBase();
        }else {
            throw new RuntimeException("Invalid logger type");
        }
        return logger;
    }
}
