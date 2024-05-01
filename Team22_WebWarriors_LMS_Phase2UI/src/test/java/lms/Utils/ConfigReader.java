package lms.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigReader {
	
	static Properties prop = new Properties();
	
	//Method to read from config.properties file
	public static String readPropertiesFile(String key) {
		
		try { // Giving the config.properties file location                                      
			InputStream input = new FileInputStream(FileNameConstants.configFile_PATH);
			prop.load(input); //Loading the config.properties file
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);// Getting the required property from the config.properties file
	}
	
	//Method to write to config.properties file
	public static void writePropertiesFile(String key, String value) {
		
		try {
			OutputStream output = new FileOutputStream("\\Users\\jyoth\\git\\repository\\Ds_algo_Achievers\\Ds_algo_Achievers\\src\\test\\java\\Config\\config.properties");
			prop.setProperty(key, value);
			prop.store(output, null);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
//	public static String getApplicationUrl() {
//		String url = prop.getProperty("HomePageUrl");
//		System.out.println("URL is " +url);
//		if (url != null)
//			return url;
//		else
//			throw new RuntimeException("url not available. ");
//	}

//	public static void main(String[] args) {
//		String str = readPropertiesFile("getStartedPageUrl");
//		System.out.println(str);
////		writePropertiesFile("url","pageLink");
//
//	}

}
