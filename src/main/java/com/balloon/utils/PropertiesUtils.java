package com.balloon.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Description: <br/>
 * Date: 2015�?8�?13�? 下午1:48:20 <br/>
 * 
 * @author hut
 * @version
 * @see
 */
public class PropertiesUtils {

	public static final String DEFAULT_PROPERTY = "/conf/application.properties";

	public static String getProperty(String key, String filePath) {
		Properties pro = new Properties();
		try {
			pro.load(PropertiesUtils.class.getResourceAsStream(filePath));
			return pro.getProperty(key);
		} catch (IOException e) {
			return null;
		}
	}

	public static String getProperty(String key) {
		return getProperty(key, DEFAULT_PROPERTY);
	}
}
