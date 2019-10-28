package com.belatrix.logger.joblogger.destinations;

import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;

public class DestinationsManager {

    @Value("${logger.file_path}")
    private String filePath;

    private static DestinationsManager destinationsManager = null;
    private static ConsoleHandler consoleHandler = null;
    private FileHandler fileHandler = null;
    private static DataBaseHandler dataBaseHandler = null;

    private DestinationsManager(){}

    public static DestinationsManager getInstance() {
        if (destinationsManager == null) {
            destinationsManager = new DestinationsManager();
        }
        return destinationsManager;
    }

    public ConsoleHandler getConsoleHandler() {
        if (consoleHandler == null) {
            consoleHandler = new ConsoleHandler();
        }
        return consoleHandler;
    }

    public FileHandler getFileHandler() {
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            fileHandler = new FileHandler(filePath);
        } catch (IOException | SecurityException e) {
            throw new RuntimeException("Error creating file", e);
        }
        return fileHandler;
    }

    public DataBaseHandler getDataBaseHandler() {
        if (dataBaseHandler == null) {
            dataBaseHandler = new DataBaseHandler();
        }
        return dataBaseHandler;
    }
}
