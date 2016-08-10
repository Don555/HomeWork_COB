package com.framework.util;

import java.io.IOException;
import java.util.Properties;

/*
 * Class that extracts properties from the prop file.
 * 
 * @author Sebastiano Armeli-Battana
 */
public class PropertyLoader {

	public static final String TEST_DATA = "/application.test_data";
	public static final String PROP_FILE = "/application.properties";
        
        private PropertyLoader() {}

	public static String loadProperty(String name, String file) {
		Properties props = new Properties();
		try {
			props.load(PropertyLoader.class.getResourceAsStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String value = "";

		if (name != null) {
			value = props.getProperty(name);
		}
		return value;
	}
}