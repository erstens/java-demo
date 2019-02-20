package com.demo.ideaplugin.frame;

import java.io.Serializable;

/**
 * 配置类
 */
public class Config implements Serializable {
    private static String host ;
    private static String user ;
    private static String pwd ;
    private static String database ;
    private static String tableName ;

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        Config.host = host;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        Config.user = user;
    }

    public static String getPwd() {
        return pwd;
    }

    public static void setPwd(String pwd) {
        Config.pwd = pwd;
    }

    public static String getDatabase() {
        return database;
    }

    public static void setDatabase(String database) {
        Config.database = database;
    }

    public static String getTableName() {
        return tableName;
    }

    public static void setTableName(String tableName) {
        Config.tableName = tableName;
    }
}
