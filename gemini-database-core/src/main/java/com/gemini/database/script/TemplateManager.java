package com.gemini.database.script;

import java.io.InputStream;
import java.util.Properties;

public class TemplateManager {
    
    private static TemplateManager instance = null;
    
    private TemplateManager() {	
    }
    
    public static TemplateManager getInstance() {
	if (instance == null) {
	    instance = new TemplateManager();
	}
	return instance;
    }
    
    public Properties getTemplates() throws Exception {
	String tempFile = "template.properties";
	InputStream in = this.getClass().getClassLoader().getResourceAsStream(tempFile);
	Properties prop = new Properties();
	prop.load(in);
	in.close();
//	Iterator<Object> it = prop.keySet().iterator();
//	while (it.hasNext()) {
//	    String key = (String) it.next();
//	    System.out.println(key);
//	    System.out.println(key + "=" + prop.get(key));
//	}
	
	return prop;
    }

    public static void main(String[] args) throws Exception {
	System.out.println(TemplateManager.getInstance().getTemplates().getProperty("INSERT_GPDB_FILM_01"));
	System.out.println(TemplateManager.getInstance().getTemplates().getProperty("INSERT_GPDB_FILM_02"));

    }

}
