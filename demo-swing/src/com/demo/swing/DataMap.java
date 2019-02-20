package com.demo.swing;

import java.io.Serializable;
import java.util.Map;

public class DataMap implements Serializable {
    private static final long serialVersionUID = -7292775147495756703L;
    private String host ;
    private String user ;
    private String pwd ;
    private String db ;
    private String table ;
    private String output ;
    private Map<String,Object> modelType ;

    private static DataMap instance = null ;

    private DataMap() {
    }

    public static synchronized DataMap getInstance() {
        if (null == instance) {
            instance = new DataMap();
//            instance.setHost("1");
//            instance.setUser("2");
//            instance.setPwd("3");
//            instance.setTable("4");
//            instance.setDb("5");
//            instance.setOutput("/Users/wangao");
//            Map m = new HashMap();
//            m.put("entity", "entity2");
//            m.put("dao", "dao1");
//            instance.setModelType(m);
            return instance;
        }
        return instance;
    }
    public static boolean alreadeyInited(){
        if(null == instance) {
            return false ;
        }
        return true ;
    }

    public String getHost() {
        return host;
    }

    public DataMap setHost(String host) {
        this.host = host;
        return this ;
    }

    public String getUser() {
        return user;
    }

    public DataMap setUser(String user) {
        this.user = user;
        return this ;

    }

    public String getPwd() {
        return pwd;
    }

    public DataMap setPwd(String pwd) {
        this.pwd = pwd;
        return this ;

    }

    public String getDb() {
        return db;
    }

    public DataMap setDb(String db) {
        this.db = db;
        return this ;

    }

    public String getTable() {
        return table;
    }

    public DataMap setTable(String table) {
        this.table = table;
        return this ;

    }

    public String getOutput() {
        return output;
    }

    public DataMap setOutput(String output) {
        this.output = output;
        return this ;

    }

    public Map getModelType() {
        return modelType;
    }

    public DataMap setModelType(Map modelType) {
        this.modelType = modelType;
        return this ;
    }

    @Override
    public String toString() {
        return "DataMap{" +
                "host='" + host + '\'' +
                ", user='" + user + '\'' +
                ", pwd='" + pwd + '\'' +
                ", db='" + db + '\'' +
                ", table='" + table + '\'' +
                ", output='" + output + '\'' +
                ", modelType=" + modelType +
                '}';
    }
}
