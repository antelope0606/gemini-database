package com.gemini.database.conn;

import java.sql.Connection;
import java.sql.DriverManager;

import com.gemini.database.config.DBConfig;
import com.gemini.database.config.DBConfigFactory;

public class DBConnFactory {

    private static DBConnFactory singleInstance = null;

    public static DBConnFactory getInstance() {
	if (singleInstance == null) {
	    singleInstance = new DBConnFactory();
	}
	return singleInstance;
    }

    public Connection getconn(String vendor) throws Exception {
	DBConfig conf = DBConfigFactory.getInstance().getDBConfig(vendor);
	Class.forName(conf.getDriverClass()).newInstance();
	return (DriverManager.getConnection(conf.getUrl(), conf.getUserName(),conf.getPassword()));
    }

    public static void main(String[] args) throws Exception {
	DBConnFactory dbcf = DBConnFactory.getInstance();
	dbcf.getconn("mysql");

    }

}
