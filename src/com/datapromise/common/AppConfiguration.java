package com.datapromise.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfiguration {

	private static Properties props = null;
	
	public synchronized static Properties getProperties()
	{
		if (props == null){
			InputStream propStream = AppConfiguration.class.getClassLoader().getResourceAsStream("config.properties");
		
			try {
				props = new Properties();
				props.load(propStream);
			} 
			catch (IOException e) {
				throw new AppException(e);
			}
		}
		
		return props;
	}
	
	
}
