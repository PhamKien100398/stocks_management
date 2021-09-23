package project.com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
	private Properties pro = null;
	private static ConfigLoader instance = null;
	String location = "file.properties";
	private ConfigLoader() {
		InputStream input = getClass().getClassLoader().getResourceAsStream(location);
		if(input != null) {
			pro = new Properties();
			try {
				pro.load(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static ConfigLoader getInstance() {
		if(instance == null) {
			instance = new ConfigLoader();
		}
		return instance;
	}
	
	public String getValue(String key) {
		if(pro.containsKey(key)) {
			return pro.getProperty(key);
		}
		return null;
	}
}
