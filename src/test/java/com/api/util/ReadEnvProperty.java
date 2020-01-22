package com.api.util;

import java.io.InputStream;
import java.util.Properties;

public class ReadEnvProperty {	
  
	public String getProperties(String key) {
		Properties prop = new Properties();
		String value = null;
		try {			
			InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("config.properties");
			prop.load(resourceAsStream);
			value = prop.getProperty(key);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return value;
	}
	
}
