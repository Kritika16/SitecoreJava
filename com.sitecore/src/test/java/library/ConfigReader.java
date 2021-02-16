package library;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	Properties pro;
	public ConfigReader(){
		 
		try {
			// Specify the file location I used . operation here because
			//we have object repository inside project directory only
			File src=new File("./Configuration/Config.property");
			 
			// Create  FileInputStream object
			FileInputStream fis=new FileInputStream(src);
			 
			// Create Properties class object to read properties file
			pro=new Properties();
			 
			// Load file so we can use into our script
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is=="+e.getMessage());
		} 
		}
	
	public String getChromePath() {
		
		String path =pro.getProperty("ChromeDriverPath");
		return path;
		
	}
	public String getDuckDuckGoURL() {
		
		String URLDuckDuckGo =pro.getProperty("URLDuckDuckGo");
		return URLDuckDuckGo;
		
	}
	public String getExpediaURL() {
		
		String URLExpedia =pro.getProperty("URLExpedia");
		return URLExpedia;
		
	}
	
}