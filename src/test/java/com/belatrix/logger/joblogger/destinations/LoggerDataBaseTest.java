package com.belatrix.logger.joblogger.destinations;

import com.belatrix.logger.joblogger.enums.LoggerEnum;
import com.belatrix.logger.joblogger.factory.LoggerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.text.DateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LoggerDataBaseTest {


    DestinationsManager destinationsManager;
    DataBaseHandler dataBaseHandler;

    @BeforeEach
    void configure(){
        destinationsManager = DestinationsManager.getInstance();
        dataBaseHandler = new DataBaseHandler();
        ReflectionTestUtils.setField(dataBaseHandler, "jdbcDriver", "org.h2.Driver");
        ReflectionTestUtils.setField(dataBaseHandler, "userName", "belatrix");
        ReflectionTestUtils.setField(dataBaseHandler, "password", "belatrix");
        ReflectionTestUtils.setField(dataBaseHandler, "databaseUrl", "jdbc:h2:./files/logdb");
    }


    @Test
    void logMessage() {
        //Arrange
        AbstractLogger abstractLogger = LoggerFactory.create(LoggerEnum.DATA_BASE.getType());
        String messageText = "kjalsjdflajslkdfjsdfdsaljd";
        String message = LoggerEnum.MESSAGE.getType() + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;

        //Act
        abstractLogger.logMessage(message);

        //Assert
        assertEquals(true, abstractLogger instanceof LoggerDataBase);
    }

    @Test
    void logWarning() {
        //Arrange
        AbstractLogger abstractLogger = LoggerFactory.create(LoggerEnum.DATA_BASE.getType());
        String messageText = "kjalsjdflajslkdfjsdfdsaljd";
        String message = LoggerEnum.WARNING.getType() + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;

        //Act
        abstractLogger.logMessage(message);

        //Assert
        assertEquals(true, abstractLogger instanceof LoggerDataBase);
    }

    @Test
    void logError() {
        //Arrange
        AbstractLogger abstractLogger = LoggerFactory.create(LoggerEnum.DATA_BASE.getType());
        String messageText = "kjalsjdflajslkdfjsdfdsaljd";
        String message = LoggerEnum.ERROR.getType() + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;

        //Act
        abstractLogger.logMessage(message);

        //Assert
        assertEquals(true, abstractLogger instanceof LoggerDataBase);
    }
}
