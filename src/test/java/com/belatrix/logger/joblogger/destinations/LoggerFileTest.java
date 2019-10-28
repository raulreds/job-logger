package com.belatrix.logger.joblogger.destinations;

import com.belatrix.logger.joblogger.enums.LoggerEnum;
import com.belatrix.logger.joblogger.factory.LoggerFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.test.util.ReflectionTestUtils;

import java.text.DateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LoggerFileTest {

    DestinationsManager destinationsManager;

    @BeforeEach
    void configure(){
        destinationsManager = DestinationsManager.getInstance();
        ReflectionTestUtils.setField(destinationsManager, "filePath", "./files/log.txt");
    }

    @Test
    void logMessage() {
        //Arrange
        AbstractLogger abstractLogger = LoggerFactory.create(LoggerEnum.FILE.getType());
        String messageText = "kjalsjdflajslkdfjsdfdsaljd";
        String message = LoggerEnum.MESSAGE.getType() + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;

        //Act
        abstractLogger.logMessage(message);

        //Assert
        //Can search the log in the file
        assertEquals(true, abstractLogger instanceof LoggerFile);
    }

    @Test
    void logWarning() {
        //Arrange
        AbstractLogger abstractLogger = LoggerFactory.create(LoggerEnum.FILE.getType());
        String messageText = "kjalsjdflajslkdfjsdfdsaljd";
        String message = LoggerEnum.WARNING.getType() + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;

        //Act
        abstractLogger.logMessage(message);

        //Assert
        //Can search the log in the file
        assertEquals(true, abstractLogger instanceof LoggerFile);
    }

    @Test
    void logError() {
        //Arrange
        AbstractLogger abstractLogger = LoggerFactory.create(LoggerEnum.FILE.getType());
        String messageText = "kjalsjdflajslkdfjsdfdsaljd";
        String message = LoggerEnum.ERROR.getType() + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;

        //Act
        abstractLogger.logMessage(message);

        //Assert
        //Can search the log in the file
        assertEquals(true, abstractLogger instanceof LoggerFile);
    }
}
