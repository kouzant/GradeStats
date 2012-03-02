package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigParser {
	private static Properties props = new Properties();
	
	public ConfigParser(String configFile){
		try{
			InputStream is = new FileInputStream(new File(configFile));
			props.load(is);
		}catch(FileNotFoundException ex){
			System.err.println("Configuration file not found");
			ex.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	public String getConfigFile(){
		return props.getProperty("GSKeystore", "ssl/GradeStats.jks");
	}
}
