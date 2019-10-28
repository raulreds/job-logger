package com.belatrix.logger.joblogger.enums;

public enum LoggerEnum {

    MESSAGE(1,"MESSAGE"),
    ERROR(2,"ERROR"),
    WARNING(3,"WARNING"),
    FILE(4,"FILE"),
    DATA_BASE(5,"DATA_BASE"),
    CONSOLE(6,"CONSOLE");

    private int id;
    private String type;

    LoggerEnum(final int id, final String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public int getId(){
        return this.id;
    }
}
