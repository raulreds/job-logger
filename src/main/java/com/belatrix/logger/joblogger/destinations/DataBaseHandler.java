package com.belatrix.logger.joblogger.destinations;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseHandler {

    @Value("${spring.datasource.driverClassName}")
    private static String jdbcDriver;
    @Value("${spring.datasource.username}")
    private static String userName;
    @Value("${spring.datasource.password}")
    private static String password;
    @Value("${spring.datasource.url}")
    private static String databaseUrl;

    private static Connection connection = null;

    public void insertLog(String message, int logType) {
        try {
            if(connection == null){
                createConnection();
                createTable();
            }
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO Log_Values(log_text, log_type) VALUES('" + message + "'," + logType + ")");
        }catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException("Error in database", e);
        }
    }

    private void createConnection() throws ClassNotFoundException, SQLException {
        Class.forName(jdbcDriver);
        connection = DriverManager.getConnection(databaseUrl, userName, password);
    }

    private void createTable() throws SQLException{
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS Log_Values(log_text varchar(255), log_type int)");
    }
}
