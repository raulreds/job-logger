package com.belatrix.logger.joblogger.destinations;

import com.belatrix.logger.joblogger.enums.LoggerEnum;
import com.belatrix.logger.joblogger.factory.LoggerFactory;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LoggerConsoleTest {

    @Test
    void logMessage() {
        //Arrange
        AbstractLogger abstractLogger = LoggerFactory.create(LoggerEnum.CONSOLE.getType());
        String messageText = "kjalsjdflajslkdfjsdfdsaljd";
        String message = LoggerEnum.MESSAGE.getType() + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;

        //Act
        abstractLogger.logMessage(message);

        //Assert
        assertEquals(true, abstractLogger instanceof LoggerConsole);
    }

    @Test
    void logWarning() {
        //Arrange
        AbstractLogger abstractLogger = LoggerFactory.create(LoggerEnum.CONSOLE.getType());
        String messageText = "kjalsjdflajslkdfjsdfdsaljd";
        String message = LoggerEnum.WARNING.getType() + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;

        //Act
        abstractLogger.logMessage(message);

        //Assert
        assertEquals(true, abstractLogger instanceof LoggerConsole);
    }

    @Test
    void logError() {
        //Arrange
        AbstractLogger abstractLogger = LoggerFactory.create(LoggerEnum.CONSOLE.getType());
        String messageText = "kjalsjdflajslkdfjsdfdsaljd";
        String message = LoggerEnum.ERROR.getType() + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;

        //Act
        abstractLogger.logMessage(message);

        //Assert
        assertEquals(true, abstractLogger instanceof LoggerConsole);
    }
}
