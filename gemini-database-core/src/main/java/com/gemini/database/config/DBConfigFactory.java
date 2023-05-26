package com.gemini.database.config;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class DBConfigFactory {

    private static DBConfigFactory instance = null;

    private DBConfigFactory() {
    }

    public static DBConfigFactory getInstance() {
	if (instance == null) {
	    instance = new DBConfigFactory();
	}
	return instance;
    }

    public DBConfig getDBConfig(String vendor) throws Exception {
//	ResourceBundle rb = ResourceBundle.getBundle(vendor);
//	System.out.println(rb.getString("mysql_host"));
	String propFile = vendor + ".properties";
	InputStream in = this.getClass().getClassLoader().getResourceAsStream(propFile);
	Properties prop = new Properties();
	prop.load(in);
	in.close();
//	Iterator<Object> it = prop.keySet().iterator();
//	while (it.hasNext()) {
//	    String key = (String) it.next();
//	    System.out.println(key);
//	    System.out.println(key + "=" + prop.get(key));
//	}
	
	return populate(prop);
    }

    private DBConfig populate(Properties prop) throws Exception {
	
	DBConfig dbc = new DBConfig();
	Class<? extends DBConfig> clz = dbc.getClass();
	Field[] fields = clz.getDeclaredFields();
	for (int i = 0; i < fields.length; i++) {
	    fields[i].setAccessible(true);
	    fields[i].set(dbc, prop.getProperty(fields[i].getName()));
	}
	return dbc;
    }

    public static void main(String[] arg) throws Exception {
	DBConfigFactory fac = DBConfigFactory.getInstance();
	DBConfig dbc = fac.getDBConfig("mysql");
	System.out.println(dbc);
	System.out.println(dbc.createURL());
    }

}
